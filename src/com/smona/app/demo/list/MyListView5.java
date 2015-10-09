/**
 * 
 */
package com.smona.app.demo.list;


import android.app.ListActivity;
import android.os.Bundle;

/**
 * @author allin
 * 
 */
public class MyListView5 extends ListActivity {

    private SpeedScrollListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listener = new SpeedScrollListener();
        getListView().setOnScrollListener(listener);
        GPlusListAdapter plusAdapter = new NowImageAdapter(
                getApplicationContext(), listener);
        setListAdapter(plusAdapter);

        // nowAdapter = new PlusImageAdapter(getApplicationContext(), listener);
        // setListAdapter(nowAdapter);
    }

}
