package com.smona.app.demo.evencustom;

import java.util.ArrayList;

import com.smona.app.demo.custom.HorPagedView.PageSwitchListener;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Scroller;

public class RootPage extends FrameLayout {

    private static final String TAG = "RootPage";
    private static final boolean DEBUG = true;
    protected static final int INVALID_PAGE = Integer.MAX_VALUE;

    // the min drag distance for a fling to register, to prevent random page
    // shifts
    private static final int MIN_LENGTH_FOR_FLING = 1;

    protected static final int PAGE_SNAP_ANIMATION_DURATION = 550;
    protected static final int MAX_PAGE_SNAP_DURATION = 750;
    protected static final int SLOW_PAGE_SNAP_ANIMATION_DURATION = 950;
    protected static final float NANOTIME_DIV = 1000000000.0f;

    private static final float RETURN_TO_ORIGINAL_PAGE_THRESHOLD = 0.33f;
    // The page is moved more than halfway, automatically move to the next page
    // on touch up.
    private static final float SIGNIFICANT_MOVE_THRESHOLD = 0.25f;

    // The following constants need to be scaled based on density. The scaled
    // versions will be
    // assigned to the corresponding member variables below.
    static final int AUTOMATIC_PAGE_SPACING = -1;

    protected int mFlingThresholdVelocity;
    protected int mMinFlingVelocity;
    protected int mMinSnapVelocity;

    protected float mDensity;
    protected float mSmoothingTime;
    protected float mTouchX;

    protected boolean mFirstLayout = true;

    protected int mCurrentPage;
    protected int mNextPage = INVALID_PAGE;
    protected boolean mIsLoop = true;
    protected int mMaxScrollX;
    protected Scroller mScroller;
    private VelocityTracker mVelocityTracker;

    private float mDownMotionX;
    protected float mLastMotionX;
    protected float mLastMotionXRemainder;
    protected float mLastMotionY;
    protected float mTotalMotionX;

    protected final static int TOUCH_STATE_REST = 0;
    protected final static int TOUCH_STATE_SCROLLING = 1;
    protected final static int TOUCH_STATE_PREV_PAGE = 2;
    protected final static int TOUCH_STATE_NEXT_PAGE = 3;
    protected final static float ALPHA_QUANTIZE_LEVEL = 0.0001f;

    protected int mTouchState = TOUCH_STATE_REST;
    protected boolean mForceScreenScrolled = false;

    protected OnLongClickListener mLongClickListener;

    protected boolean mAllowLongPress = true;

    protected int mTouchSlop;
    private int mMaximumVelocity;
    private int mMinimumWidth;
    protected int mPageSpacing = 0;
    protected int mPageLayoutPaddingTop;
    protected int mPageLayoutPaddingBottom;
    protected int mPageLayoutPaddingLeft;
    protected int mPageLayoutPaddingRight;
    protected int mPageLayoutWidthGap;
    protected int mPageLayoutHeightGap;
    protected int mCellCountX = 0;
    protected int mCellCountY = 0;
    protected boolean mCenterPagesVertically;
    protected boolean mAllowOverScroll = true;
    protected int mUnboundedScrollX;
    protected int[] mTempVisiblePagesRange = new int[2];
    protected boolean mForceDrawAllChildrenNextFrame;

    // mOverScrollX is equal to getScrollX() when we're within the normal scroll
    // range. Otherwise
    // it is equal to the scaled overscroll position. We use a separate value so
    // as to prevent
    // the screens from continuing to translate beyond the normal bounds.
    protected int mOverScrollX;

    // parameter that adjusts the layout to be optimized for pages with that
    // scale factor
    protected float mLayoutScale = 1.0f;

    protected static final int INVALID_POINTER = -1;

    protected int mActivePointerId = INVALID_POINTER;

    private PageSwitchListener mPageSwitchListener;

    protected ArrayList<Boolean> mDirtyPageContent;

    // If true, syncPages and syncPageItems will be called to refresh pages
    protected boolean mContentIsRefreshable = true;

    // If true, modify alpha of neighboring pages as user scrolls left/right
    protected boolean mFadeInAdjacentScreens = true;

    // It true, use a different slop parameter (pagingTouchSlop = 2 * touchSlop)
    // for deciding
    // to switch to a new page
    protected boolean mUsePagingTouchSlop = true;

    // If true, the subclass should directly update scrollX itself in its
    // computeScroll method
    // (SmoothPagedView does this)
    protected boolean mDeferScrollUpdate = false;

    protected boolean mIsPageMoving = false;

    // All syncs and layout passes are deferred until data is ready.
    protected boolean mIsDataReady = false;

    // Scrolling indicator
    protected static final int sScrollIndicatorFadeInDuration = 150;
    protected static final int sScrollIndicatorFadeOutDuration = 650;
    protected static final int sScrollIndicatorFlashDuration = 650;

    protected float mConfigScaleValue = 1f;
    protected float mConfigScaleLimitValue = 0f;
    protected float mConfigAlphaValue = 0f;
    protected float mConfigAlphaLimitValue = 0f;

    public RootPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Skip touch handling if there are no pages to swipe
        if (getChildCount() <= 0)
            return super.onTouchEvent(ev);

        acquireVelocityTrackerAndAddMovement(ev);

        final int action = ev.getAction();

        switch (action & MotionEvent.ACTION_MASK) {
        case MotionEvent.ACTION_DOWN:
            /*
             * If being flinged and user touches, stop the fling. isFinished
             * will be false if being flinged.
             */
            if (!mScroller.isFinished()) {
                mScroller.abortAnimation();
            }

            // Remember where the motion event started
            mDownMotionX = mLastMotionX = ev.getX();
            mLastMotionXRemainder = 0;
            mTotalMotionX = 0;
            mActivePointerId = ev.getPointerId(0);
            if (mTouchState == TOUCH_STATE_SCROLLING) {
                pageBeginMoving();
            }
            break;

        case MotionEvent.ACTION_MOVE:
            if (mTouchState == TOUCH_STATE_SCROLLING) {
                // Scroll to follow the motion event
                final int pointerIndex = ev.findPointerIndex(mActivePointerId);
                final float x = ev.getX(pointerIndex);
                final float deltaX = mLastMotionX + mLastMotionXRemainder - x;

                mTotalMotionX += Math.abs(deltaX);

                // Only scroll and update mLastMotionX if we have moved some
                // discrete amount. We
                // keep the remainder because we are actually testing if we've
                // moved from the last
                // scrolled position (which is discrete).
                if (Math.abs(deltaX) >= 1.0f) {
                    mTouchX += deltaX;
                    mSmoothingTime = System.nanoTime() / NANOTIME_DIV;
                    if (!mDeferScrollUpdate) {
                        scrollBy((int) deltaX, 0);
                        // if (DEBUG)
                        // Log.d(TAG, "onTouchEvent().Scrolling: " + deltaX);
                    } else {
                        invalidate();
                    }
                    mLastMotionX = x;
                    mLastMotionXRemainder = deltaX - (int) deltaX;
                } else {
                    awakenScrollBars();
                }
            } else {
                // determineScrollingStart(ev);
            }
            break;

        case MotionEvent.ACTION_UP:
            if (mTouchState == TOUCH_STATE_SCROLLING) {
                final int activePointerId = mActivePointerId;
                final int pointerIndex = ev.findPointerIndex(activePointerId);
                final float x = ev.getX(pointerIndex);
                final VelocityTracker velocityTracker = mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
                int velocityX = (int) velocityTracker
                        .getXVelocity(activePointerId);
                final int deltaX = (int) (x - mDownMotionX);
                final int pageWidth = getScaledMeasuredWidth(getPageAt(mCurrentPage));
                boolean isSignificantMove = Math.abs(deltaX) > pageWidth
                        * SIGNIFICANT_MOVE_THRESHOLD;

                mTotalMotionX += Math.abs(mLastMotionX + mLastMotionXRemainder
                        - x);

                boolean isFling = mTotalMotionX > MIN_LENGTH_FOR_FLING
                        && Math.abs(velocityX) > mFlingThresholdVelocity;

                // In the case that the page is moved far to one direction and
                // then is flung
                // in the opposite direction, we use a threshold to determine
                // whether we should
                // just return to the starting page, or if we should skip one
                // further.
                boolean returnToOriginalPage = false;
                if (Math.abs(deltaX) > pageWidth
                        * RETURN_TO_ORIGINAL_PAGE_THRESHOLD
                        && Math.signum(velocityX) != Math.signum(deltaX)
                        && isFling) {
                    returnToOriginalPage = true;
                }

                int finalPage;
                // We give flings precedence over large moves, which is why we
                // short-circuit our
                // test for a large move if a fling has been registered. That
                // is, a large
                // move to the left and fling to the right will register as a
                // fling to the right.
                boolean isDeltaXLeft = deltaX < 0;
                boolean isVelocityXLeft = velocityX < 0;

                if (DEBUG) {
                    Log.d(TAG, "isSignificantMove: " + isSignificantMove
                            + ", isDeltaXLeft: " + isDeltaXLeft + ", isFling: "
                            + isFling + ", isVelocityXLeft: " + isVelocityXLeft
                            + ", mCurrentPage: " + mCurrentPage);
                }

                if (((isSignificantMove && !isDeltaXLeft && !isFling) || (isFling && !isVelocityXLeft))
                        && mCurrentPage >= 0) {
                    finalPage = returnToOriginalPage ? mCurrentPage
                            : mCurrentPage - 1;
                    if (DEBUG) {
                        Log.d(TAG, "left finalPage: " + finalPage
                                + ", returnToOriginalPage: "
                                + returnToOriginalPage + ", mCurrentPage: "
                                + mCurrentPage);
                    }
                    // snapToPageWithVelocity(finalPage, velocityX);
                } else if (((isSignificantMove && isDeltaXLeft && !isFling) || (isFling && isVelocityXLeft))
                        && mCurrentPage <= getChildCount() - 1) {
                    finalPage = returnToOriginalPage ? mCurrentPage
                            : mCurrentPage + 1;

                    if (DEBUG) {
                        Log.d(TAG, "right finalPage: " + finalPage
                                + ", returnToOriginalPage: "
                                + returnToOriginalPage + ", mCurrentPage: "
                                + mCurrentPage);
                    }
                    // snapToPageWithVelocity(finalPage, velocityX);
                } else {
                    // snapToDestination();
                }
            } else if (mTouchState == TOUCH_STATE_PREV_PAGE) {
                // at this point we have not moved beyond the touch slop
                // (otherwise mTouchState would be TOUCH_STATE_SCROLLING), so
                // we can just page
                // int nextPage = Math.max(0, mCurrentPage - 1);
                int nextPage = mCurrentPage - 1;
                if (nextPage != mCurrentPage) {
                    // snapToPage(nextPage);
                } else {
                    // snapToDestination();
                }
            } else if (mTouchState == TOUCH_STATE_NEXT_PAGE) {
                // at this point we have not moved beyond the touch slop
                // (otherwise mTouchState would be TOUCH_STATE_SCROLLING), so
                // we can just page
                // int nextPage = Math.min(getChildCount() - 1, mCurrentPage +
                // 1);
                int nextPage = mCurrentPage + 1;

                if (nextPage != mCurrentPage) {
                    // snapToPage(nextPage);
                } else {
                    // snapToDestination();
                }
            } else {
                onUnhandledTap(ev);
            }
            mTouchState = TOUCH_STATE_REST;
            mActivePointerId = INVALID_POINTER;
            releaseVelocityTracker();
            break;

        case MotionEvent.ACTION_CANCEL:
            if (mTouchState == TOUCH_STATE_SCROLLING) {
                // snapToDestination();
            }
            mTouchState = TOUCH_STATE_REST;
            mActivePointerId = INVALID_POINTER;
            releaseVelocityTracker();
            break;

        case MotionEvent.ACTION_POINTER_UP:
            onSecondaryPointerUp(ev);
            break;
        }

        return true;
    }

    protected int getScaledMeasuredWidth(View child) {
        // This functions are called enough times that it actually makes a
        // difference in the
        // profiler -- so just inline the max() here
        final int measuredWidth = child.getMeasuredWidth();
        final int minWidth = mMinimumWidth;
        final int maxWidth = (minWidth > measuredWidth) ? minWidth
                : measuredWidth;
        return (int) (maxWidth * mLayoutScale + 0.5f);
    }

    private void acquireVelocityTrackerAndAddMovement(MotionEvent ev) {
        if (mVelocityTracker == null) {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(ev);
    }

    private void releaseVelocityTracker() {
        if (mVelocityTracker != null) {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
    }

    private void onSecondaryPointerUp(MotionEvent ev) {
        final int pointerIndex = (ev.getAction() & MotionEvent.ACTION_POINTER_INDEX_MASK) >> MotionEvent.ACTION_POINTER_INDEX_SHIFT;
        final int pointerId = ev.getPointerId(pointerIndex);
        if (pointerId == mActivePointerId) {
            // This was our active pointer going up. Choose a new
            // active pointer and adjust accordingly.
            final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
            mLastMotionX = mDownMotionX = ev.getX(newPointerIndex);
            mLastMotionY = ev.getY(newPointerIndex);
            mLastMotionXRemainder = 0;
            mActivePointerId = ev.getPointerId(newPointerIndex);
            if (mVelocityTracker != null) {
                mVelocityTracker.clear();
            }
        }
    }

    protected void onUnhandledTap(MotionEvent ev) {
    }

    protected void notifyPageSwitchListener() {
        if (mPageSwitchListener != null) {
            mPageSwitchListener.onPageSwitch(getPageAt(mCurrentPage),
                    mCurrentPage);
        }
    }

    View getPageAt(int index) {
        return getChildAt(index);
    }

    protected void pageBeginMoving() {
        if (!mIsPageMoving) {
            mIsPageMoving = true;
            onPageBeginMoving();
        }
    }

    protected void pageEndMoving() {
        if (mIsPageMoving) {
            mIsPageMoving = false;
            onPageEndMoving();
        }
    }

    protected boolean isPageMoving() {
        return mIsPageMoving;
    }

    // a method that subclasses can override to add behavior
    protected void onPageBeginMoving() {
    }

    // a method that subclasses can override to add behavior
    protected void onPageEndMoving() {
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

}
