package com.artrees.appinformation.Message;

import android.net.Uri;

import com.artrees.appinformation.Utility.Network.Json;

import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Artrees on 1/6/2016.
 */
public class MemberShip extends Json {
    public String MemberShipID;
    public String UserName;
    public String MemberName;
    public String MemberSurname;
    public String Role;

    @Override public String toString() {return this.UserName;}

    public static MemberShip Instance(String userName){
        String urlstring = "http://110.77.136.64/easyinsurewebservice/customerservices.asmx/Authenticate";
        String content = "";
        MemberShip result = null;
        JSONObject json = null;

        /// Set parameter
        Uri.Builder builder = new Uri.Builder()
                .appendQueryParameter("Username", userName)
                .appendQueryParameter("Password", "test")
                .appendQueryParameter("AccessCode", "test");
        content = builder.build().getEncodedQuery();

        try {
            json = getJSONObjectFromWeb(urlstring, content);
            if (json != null) {
                result = new MemberShip();
                result.UserName = json.getString("UserName");
                result.MemberName = json.getString("MemberName");
                result.MemberSurname = json.getString("MemberSurname");
                result.MemberShipID = json.getString("MemberShipID");
                result.Role = json.getString("Role");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

//    @Override
//    protected T deserializeObj() {
//        return null;
//    }


}
