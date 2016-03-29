package com.artrees.appinformation.Utility.LoadingTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.ContactsContract;

/**
 * Created by Artrees on 1/4/2016.
 */
public abstract class FeedLoadingTask extends AsyncTask<String, Void, String> {
    protected ProgressDialog progressDialog;
    protected String datatype;
    protected Context context;

    public FeedLoadingTask(Context context, String DataType) {
        this.context = context;
        this.datatype = DataType;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(this.context,
                                                null,
                                                String.format("Downloading %s...", datatype),
                                                true);
        progressDialog.setCancelable(true);
    }

    @Override
    protected String doInBackground(String... params) {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
        }
        return "Executed";
    }

    @Override
    protected void onPostExecute(String result) {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
