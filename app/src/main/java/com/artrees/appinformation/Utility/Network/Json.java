package com.artrees.appinformation.Utility.Network;

import com.artrees.appinformation.Utility.Network.BaseHttp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by Artrees on 1/5/2016.
 */
public abstract class Json extends BaseHttp {

    protected static JSONObject getJSONObjectFromWeb(String urlString, String content) throws JSONException, UnsupportedEncodingException {
        JSONObject json = null;

        try {
            String strjson = HttpRequestPost(urlString, content); //convertStreamToString(inputStream);
            json = new JSONObject(strjson);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return json;
        }
    }

    protected static JSONArray getJSONArrayFromWeb(String urlString, String content) throws JSONException, UnsupportedEncodingException {
        JSONArray json = null;

        try {
            String strjson = HttpRequestPost(urlString, content); //convertStreamToString(inputStream);
            json = new JSONArray(strjson);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return json;
        }
    }

//    @Override public abstract String toString();
//    protected static String convertStreamToString(InputStream is) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        StringBuilder sb = new StringBuilder();
//        String line = null;
//        try {
//            while ((line = reader.readLine()) != null) {
//                sb.append(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                is.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return sb.toString();
//    }

//    protected abstract T deserializeObj(T object);



//    protected static JSONArray deserializeArray(InputStream inputStream) throws JSONException, UnsupportedEncodingException {
//        String strjson = convertStreamToString(inputStream);
//        JSONArray json = new JSONArray(strjson);
//        return json;
//    }
}
