package com.jpyl.refleciondemo.annotation;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by dg on 2017/3/13.
 */

public class AnnotationManager {
    public static void init(Activity activity) {
        Field[] fields = activity.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ID.class)) {
                int id = field.getAnnotation(ID.class).value();
                if (id != -1) {
                    field.setAccessible(true);
                    View view = null;
                    try {
//                        if (field.getType().getName().equals("TextView"))
//                            view = activity.findViewById(id);
//                    Log.i("M-TAG",""+field.getType().getName());
                        field.set(activity, activity.findViewById(id));
                        if (field.getType() == TextView.class)
                            ((TextView) field.get(activity)).setTextColor(Color.BLUE);
//                        (TextView) field
//                        view.setTextColor(Color.BLUE);
//                        if (field.getType().getSimpleName().equals("TextView")){
//                            field.set(activity,);
//
//                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (field.isAnnotationPresent(Str.class)) {
                String str = field.getAnnotation(Str.class).value();
                field.setAccessible(true);
                try {
                    field.set(activity, str);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
