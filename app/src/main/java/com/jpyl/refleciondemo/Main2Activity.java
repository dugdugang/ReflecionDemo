package com.jpyl.refleciondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.jpyl.refleciondemo.annotation.AnnotationManager;
import com.jpyl.refleciondemo.annotation.ID;
import com.jpyl.refleciondemo.annotation.Str;

public class Main2Activity extends AppCompatActivity {
    @ID(value=R.id.text)
    private TextView view;
    @Str("hello world!")
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AnnotationManager.init(this);
        view.setText(text);
    }
}
