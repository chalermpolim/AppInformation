package com.artrees.appinformation.Utility.Resource;

import java.lang.reflect.Field;

/**
 * Created by Artrees on 3/20/2016.
 */
public class AndroidResource {

    // Get R resource identify in string
    // getResId("map1", R.drawable.class);
    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
