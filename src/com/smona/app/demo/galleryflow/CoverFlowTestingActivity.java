package com.smona.app.demo.galleryflow;

import com.smona.app.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

/****
 * The Class CoverFlowTestingActivity.
 */
public class CoverFlowTestingActivity extends Activity {

    private TextView textView;

    /*
     * (non-Javadoc)
     * 
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.galleryflow);
        textView = (TextView) findViewById(R.id.statusText);
        // note resources below are taken using getIdentifier to allow importing
        // this library as library.
        final CoverFlow reflectingCoverFlow = (CoverFlow) findViewById(R.id.coverflowReflect);
        setupCoverFlow(reflectingCoverFlow, false);
        // final CoverFlow coverFlow1 = (CoverFlow) findViewById(this
        // .getResources().getIdentifier("coverflow", "id",
        // "com.smona.app.demo.galleryflow"));
        // setupCoverFlow(coverFlow1, false);
    }

    /**
     * Setup cover flow.
     * 
     * @param converFlow
     *            the m cover flow
     * @param reflect
     *            the reflect
     */
    private void setupCoverFlow(final CoverFlow converFlow,
            final boolean reflect) {
        BaseAdapter coverImageAdapter;
        if (reflect) {
            coverImageAdapter = new ReflectingImageAdapter(
                    new ResourceImageAdapter(this));
        } else {
            coverImageAdapter = new ResourceImageAdapter(this);
        }
        converFlow.setAdapter(coverImageAdapter);
        converFlow.setSelection(2, true);
        setupListeners(converFlow);
    }

    /**
     * Sets the up listeners.
     * 
     * @param mCoverFlow
     *            the new up listeners
     */
    private void setupListeners(final CoverFlow mCoverFlow) {
        mCoverFlow.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> parent,
                    final View view, final int position, final long id) {
                textView.setText("Item clicked! : " + id);
            }

        });
        mCoverFlow.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent,
                    final View view, final int position, final long id) {
                textView.setText("Item selected! : " + id);
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {
                textView.setText("Nothing clicked!");
            }
        });
    }

}
