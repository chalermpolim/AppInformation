package com.artrees.appinformation.Utility.Network;

import android.net.Uri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Artrees on 1/13/2016.
 */
public class BaseHttp {

    protected static String HttpRequestPost(String urlString, String content) throws IOException
    {
        // Only display the first 2000 characters of the retrieved
        // web page content.
        int BUFFER_SIZE = 2000;
        String contentAsString = "";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream in = null;
            OutputStream out;
            byte[] buff;

            conn.setReadTimeout(10000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            //conn.setRequestProperty("Accept", "*/*");
            //conn.addRequestProperty("Accept-Encoding", "gzip deflate sdch");
            //conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            // Starts the query
            out = conn.getOutputStream();
            buff = content.getBytes("UTF-8");
            out.write(buff);
            out.flush();
            out.close();

            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                in = conn.getInputStream();
                contentAsString = ReadBufferToString(in, BUFFER_SIZE);
                in.close();
            }

        }catch (MalformedURLException e2) {
            return "";
        } catch (Exception ex) {
            return "";
        } finally {
            return contentAsString;
        }
    }

    private static String ReadBufferToString(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        return result.toString();
    }
}
