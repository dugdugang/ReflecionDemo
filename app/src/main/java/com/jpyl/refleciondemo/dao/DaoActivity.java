package com.jpyl.refleciondemo.dao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jpyl.refleciondemo.R;
import com.jpyl.refleciondemo.annotation.Str;
import com.jpyl.refleciondemo.dao.anno.Column;
import com.jpyl.refleciondemo.dao.anno.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by dg on 2017/3/14.
 */

public class DaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Filter filter1 = new Filter();
        filter1.setId(110);
        Log.i("M-TAG", "" + filter1.getId());
        Filter filter2 = new Filter();
        filter2.setUserName("xxjhhasjh");
        Filter filter3 = new Filter();
        filter3.setEmail("51342676@qq.com");

        String s1 = query(filter1);
        String s2 = query(filter2);
        String s3 = query(filter3);
        Log.i("M-TAG", "" + s1);
        Log.i("M-TAG", "" + s2);
        Log.i("M-TAG", "" + s3);


    }

    private String query(Object filter) {
        //获取class
        Class c = filter.getClass();
        StringBuilder sb = new StringBuilder();
        //得到table的名字
        boolean isExist = c.isAnnotationPresent(Table.class);
        if (!isExist)
            return null;
        Table table = (Table) c.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");
        //遍历所有属性
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            //处理每个字段对应的sql
            //拿到字段名
            boolean exist = field.isAnnotationPresent(Column.class);
            if (!exist)
                continue;
            Column column = field.getAnnotation(Column.class);
            String columnName = column.name();
            //拿到字段值
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1)
                    .toUpperCase() + fieldName.substring(1);
            Object fieldValue = null;
            try {
                Method methodName = c.getMethod(getMethodName);
                fieldValue = methodName.invoke(filter);

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //拼装sql
            if (fieldValue == null || (fieldValue instanceof Integer && (Integer) fieldValue == 0))
                continue;
            sb.append(" and ").append(fieldName).append(" = ");
            if (fieldValue instanceof String) {
                sb.append("'").append(fieldValue).append("'");

            } else if (fieldValue instanceof Integer){
                sb.append(fieldValue);
            }

        }

        return sb.toString();
    }
}
