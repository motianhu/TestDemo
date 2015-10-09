/**
 * 
 */
package com.smona.app.demo.list;

import java.util.ArrayList;

import com.smona.app.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.ListView;

/**
 * @author allin
 * 
 */
public class MyListView extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list_1);

        MyAdapter adapter = new MyAdapter(getData(), this);
        ListView listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setLayoutAnimation(getAnimationController());
    }

    protected LayoutAnimationController getAnimationController1() {
        AlphaAnimation alpha = new AlphaAnimation(0, 1);
        alpha.setDuration(500);
        LayoutAnimationController lac = new LayoutAnimationController(alpha);
        lac.setOrder(LayoutAnimationController.ORDER_RANDOM);
        return lac;
    }

    protected LayoutAnimationController getAnimationController() {
        int duration = 300;
        AnimationSet set = new AnimationSet(true);

        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(duration);
        set.addAnimation(animation);

        animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        animation.setDuration(duration);
        set.addAnimation(animation);

        LayoutAnimationController controller = new LayoutAnimationController(
                set, 0.5f);
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        return controller;
    }

    private ArrayList<String> getData() {

        ArrayList<String> data = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            data.add("测试数据 " + i);
        }
        return data;
    }
}
