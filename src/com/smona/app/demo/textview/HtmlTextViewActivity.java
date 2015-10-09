package com.smona.app.demo.textview;

import com.smona.app.demo.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class HtmlTextViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.html_textview);
        TextView text = (TextView) findViewById(R.id.text);
        
        String content = "TextView *#*#html#*#* FormateTextView = (TextView)findViewById(R.id.testTextView);";
        content = content.replace("*#*#", "<font color='blue'>");
        content = content.replace("#*#*", "</font>");
        
        text.setText(Html.fromHtml(content));
    }

}
