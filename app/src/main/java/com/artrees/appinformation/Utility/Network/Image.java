package com.artrees.appinformation.Utility.Network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Artrees on 1/5/2016.
 */
public class Image extends BaseHttp
{
    public String FileName;

    @Override public String toString() {return this.FileName;}

    public static Bitmap DownloadImage(String url)
    {
        Bitmap bitmap = null;
        InputStream in = null;
        URL urlConn = null;
        try {

            urlConn = new URL(url);
            in =  urlConn.openStream();
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return bitmap;
    }

    public static Drawable DownloadDrawableFromNetwork(String url ) {
        url = url.trim();
        Drawable drawable=null;
        try {

            URL Url = new URL(url);
            InputStream is = (InputStream) Url.getContent();
            return Drawable.createFromStream(is, "src");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (OutOfMemoryError e) {
            e.printStackTrace();
            drawable= null;
        }catch (IOException e) {
            e.printStackTrace();
            drawable= null;
        }
        catch (Exception e) {
            e.printStackTrace();
            drawable= null;
        }
        return drawable;
    }//end of method
}
