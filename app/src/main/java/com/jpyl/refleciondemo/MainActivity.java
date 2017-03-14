package com.jpyl.refleciondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            initDefault();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initDefault() throws ClassNotFoundException {
        Test test=new Test();
        String className = test.getClass().getName();
//        String
        //  className=className.substring(className.indexOf(" ")+1);

        Log.i("M-TAG", "" + className);
        Log.i("M-TAG", "" + getPackageName());
        Log.i("M-TAG", "" + Test.class);
        Class c = Class.forName(className);
        //获取所有的属性
        Field[] fields = c.getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        sb.append(Modifier.toString(c.getModifiers()) + " class " + c.getSimpleName() + " {" + "\n");
        for (Field field : fields) {
            sb.append("\t");
            sb.append(Modifier.toString(field.getModifiers()) + " ");
            sb.append(field.getType().getSimpleName() + " ");
            sb.append(field.getName() + ";\n");
        }
        sb.append("}");
        Log.i("M-TAG", "" + sb);
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            Class<?>[] parameters =  method.getParameterTypes();
            String param = "";
            if (parameters.length > 0) {
                StringBuffer sbr = new StringBuffer();
                for (Class<?> cs:parameters){
                    sbr.append(cs.getSimpleName()+" "+cs.getName()+",");
                }
                param=sbr.substring(0,sbr.length()-1);
            }
            Log.i("M-TAG",""+Modifier.toString(method.getModifiers())+" "+method.getReturnType().getSimpleName()+" " +method.getName()+" ("+param+")");

        }
        try {
            Method method=c.getMethod("Printf",String.class);
            method.invoke(MainActivity.this,"ssss");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
