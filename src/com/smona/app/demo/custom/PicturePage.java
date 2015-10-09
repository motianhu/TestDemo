package com.smona.app.demo.custom;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class PicturePage extends HorPagedView {

    // small
    private float mNewScale;
    private float[] mOldAlphas;
    private float[] mNewAlphas;
    private int mLastChildCount = -1;

    // These properties refer to the background protection gradient used for
    // AllApps and Customize
    private Drawable mBackground;
    boolean mDrawBackground = true;
    private float mBackgroundAlpha = 0;

    enum State {
        NORMAL, SPRING_LOADED
    };

    private State mState = State.NORMAL;
    private boolean mIsSwitchingState = false;

    //
    private float mOverviewModeShrinkFactor;

    public PicturePage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PicturePage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mOverviewModeShrinkFactor = mConfigScaleValue;
        mContentIsRefreshable = false;
        this.setPageSpacing(44);
        setDataIsReady();
    }

    @Override
    public void syncPages() {

    }

    @Override
    public void syncPageItems(int page, boolean immediate) {

    }

    /*
     * This interpolator emulates the rate at which the perceived scale of an
     * object changes as its distance from a camera increases. When this
     * interpolator is applied to a scale animation on a view, it evokes the
     * sense that the object is shrinking due to moving away from the camera.
     */
    static class ZInterpolator implements TimeInterpolator {
        private float focalLength;

        public ZInterpolator(float foc) {
            focalLength = foc;
        }

        public float getInterpolation(float input) {
            return (1.0f - focalLength / (focalLength + input))
                    / (1.0f - focalLength / (focalLength + 1.0f));
        }
    }

    /*
     * The exact reverse of ZInterpolator.
     */
    static class InverseZInterpolator implements TimeInterpolator {
        private ZInterpolator zInterpolator;

        public InverseZInterpolator(float foc) {
            zInterpolator = new ZInterpolator(foc);
        }

        public float getInterpolation(float input) {
            return 1 - zInterpolator.getInterpolation(1 - input);
        }
    }

    /*
     * ZInterpolator compounded with an ease-out.
     */
    static class ZoomOutInterpolator implements TimeInterpolator {
        private final DecelerateInterpolator decelerate = new DecelerateInterpolator(
                0.75f);
        private final ZInterpolator zInterpolator = new ZInterpolator(0.13f);

        public float getInterpolation(float input) {
            return decelerate.getInterpolation(zInterpolator
                    .getInterpolation(input));
        }
    }

    /*
     * InvereZInterpolator compounded with an ease-out.
     */
    static class ZoomInInterpolator implements TimeInterpolator {
        private final InverseZInterpolator inverseZInterpolator = new InverseZInterpolator(
                0.35f);
        private final DecelerateInterpolator decelerate = new DecelerateInterpolator(
                3.0f);

        public float getInterpolation(float input) {
            return decelerate.getInterpolation(inverseZInterpolator
                    .getInterpolation(input));
        }
    }

    /*
     * private void enableHwLayersOnVisiblePages() { final int screenCount =
     * getChildCount();
     * 
     * getVisiblePages(mTempVisiblePagesRange); int leftScreen =
     * mTempVisiblePagesRange[0]; int rightScreen = mTempVisiblePagesRange[1];
     * int forceDrawScreen = -1; if (leftScreen == rightScreen) { // make sure
     * we're caching at least two pages always if (rightScreen < screenCount -
     * 1) { rightScreen++; forceDrawScreen = rightScreen; } else if (leftScreen
     * > 0) { leftScreen--; forceDrawScreen = leftScreen; } } else {
     * forceDrawScreen = leftScreen + 1; }
     * 
     * for (int i = 0; i < screenCount; i++) { final View layout = (View)
     * getPageAt(i); if (!(leftScreen <= i && i <= rightScreen && (i ==
     * forceDrawScreen || shouldDrawChild(layout)))) {
     * layout.setLayerType(LAYER_TYPE_NONE, null); } }
     * 
     * for (int i = 0; i < screenCount; i++) { final View layout = (View)
     * getPageAt(i);
     * 
     * if (leftScreen <= i && i <= rightScreen && (i == forceDrawScreen ||
     * shouldDrawChild(layout))) { if (layout.getLayerType() !=
     * LAYER_TYPE_HARDWARE) { layout.setLayerType(LAYER_TYPE_HARDWARE, null); }
     * } } }
     */
    @Override
    protected void overScroll(float amount) {
        acceleratedOverScroll(amount);
    }

    private void setState(State state) {
        mState = state;
    }

    void changeState1(final State state, int snapPage) {
        if (mState == state) {
            return;
        }

        // Initialize animation arrays for the first time if necessary
        initAnimationArrays();

        final State oldState = mState;
        final boolean oldStateIsNormal = (oldState == State.NORMAL);
        setState(state);
        final boolean stateIsNormal = (state == State.NORMAL);
        final boolean stateIsOverview = (state == State.SPRING_LOADED);
        float finalWorkspaceTranslationY = 0;

        boolean workspaceToAllApps = (oldStateIsNormal);
        boolean allAppsToWorkspace = (stateIsNormal);

        mNewScale = 1.0f;

        if (state != State.NORMAL) {
            if (stateIsOverview) {
                mNewScale = mOverviewModeShrinkFactor;
            }
        }

        for (int i = 0; i < getChildCount(); i++) {
            final View cl = (View) getChildAt(i);
            boolean isCurrentPage = (i == getNextPage());
            float initialAlpha = cl.getAlpha();
            float finalAlpha = 1f;

            // If we are animating to/from the small state, then hide the side
            // pages and fade the
            // current page in
            if (!mIsSwitchingState) {
                if (workspaceToAllApps || allAppsToWorkspace) {
                    if (allAppsToWorkspace && isCurrentPage) {
                        initialAlpha = 0f;
                    } else if (!isCurrentPage) {
                        initialAlpha = finalAlpha = 0f;
                    }
                    // cl.setAlpha(initialAlpha);
                    cl.setScaleX(mNewScale);
                    cl.setScaleY(mNewScale);
                    cl.setTranslationY(finalWorkspaceTranslationY);
                }
            }

            mOldAlphas[i] = initialAlpha;
            mNewAlphas[i] = finalAlpha;
            // cl.setAlpha(finalBackgroundAlpha);//
            // setBackgroundAlpha(finalBackgroundAlpha);
            // cl.setAlpha(finalAlpha);
        }

        if (stateIsOverview) {
            animateBackgroundGradient(80 / 100f);
        } else {
            // Fade the background gradient away
            animateBackgroundGradient(0f);
        }
    }

    private void initAnimationArrays() {
        final int childCount = getChildCount();
        if (mLastChildCount == childCount)
            return;
        mOldAlphas = new float[childCount];
        mNewAlphas = new float[childCount];
    }

    private void animateBackgroundGradient(float finalAlpha) {
        if (mBackground == null)
            return;
        // if (mBackgroundFadeInAnimation != null) {
        // mBackgroundFadeInAnimation.cancel();
        // mBackgroundFadeInAnimation = null;
        // }
        // if (mBackgroundFadeOutAnimation != null) {
        // mBackgroundFadeOutAnimation.cancel();
        // mBackgroundFadeOutAnimation = null;
        // }
        // float startAlpha = getBackgroundAlpha();
        // if (finalAlpha != startAlpha) {
        // setBackgroundAlpha(finalAlpha);
        // }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Draw the background gradient if necessary
        if (mBackground != null && mBackgroundAlpha > 0.0f && mDrawBackground) {
            int alpha = (int) (mBackgroundAlpha * 255);
            mBackground.setAlpha(alpha);
            mBackground.setBounds(getScrollX(), 0, getScrollX()
                    + getMeasuredWidth(), getMeasuredHeight());
            mBackground.draw(canvas);
        }

        super.onDraw(canvas);
    }

    public void changeState(State state, int page) {
        if (mState == state) {
            return;
        }

        // Initialize animation arrays for the first time if necessary
        initAnimationArrays();

        // Stop any scrolling, move to the current page right away
        setCurrentPage(getNextPage());

        final State oldState = mState;
        final boolean oldStateIsNormal = (oldState == State.NORMAL);
        mState = state;
        final boolean stateIsSpringLoaded = (state == State.SPRING_LOADED);
        float finalScaleFactor = stateIsSpringLoaded ? 0.8f : 1.0f;

        if (state != State.NORMAL) {
            if (oldStateIsNormal) {
                setLayoutScale(finalScaleFactor);
                // updateChildrenLayersEnabled(false);
            } else {
                setLayoutScale(finalScaleFactor);
            }
        } else {
            setPageSpacing(0);
            setLayoutScale(1.0f);
        }

        for (int i = 0; i < getChildCount(); i++) {
            final View cl = getChildAt(i);
            float finalAlpha = (stateIsSpringLoaded || (i == mCurrentPage)) ? 1f
                    : 0f;
            float currentAlpha = cl.getAlpha();
            float initialAlpha = currentAlpha;

            mOldAlphas[i] = initialAlpha;
            mNewAlphas[i] = finalAlpha;
            cl.setScaleX(finalScaleFactor);
            cl.setScaleY(finalScaleFactor);
        }

        if (stateIsSpringLoaded) {
            // Right now we're covered by Apps Customize
            // Show the background gradient immediately, so the gradient will
            // be showing once AppsCustomize disappears
            animateBackgroundGradient(80 / 100f);
        } else {
            // Fade the background gradient away
            animateBackgroundGradient(0f);
        }
    }

    // int getOverviewModeTranslationY() {
    // int childHeight = getNormalChildHeight();
    // int viewPortHeight = getViewportHeight();
    // int scaledChildHeight = (int) (mOverviewModeShrinkFactor * childHeight);
    //
    // int offset = (viewPortHeight - scaledChildHeight) / 2;
    // int offsetDelta = mOverviewModePageOffset - offset + mInsets.top;
    //
    // return offsetDelta;
    // }
}
