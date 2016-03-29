package com.artrees.appinformation.Utility.LoadingTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Artrees on 1/4/2016.
 */
public abstract class ProgressLoadingTask extends AsyncTask<Void, Integer, Void> {
    protected ProgressDialog progressDialog;
    protected String datatype;
    protected Context context;

    public ProgressLoadingTask(Context context, String DataType) {
        this.context = context;
        this.datatype = DataType;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(this.context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Loading...");
        progressDialog.setMessage(String.format("Downloading %s...", this.datatype));
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(false);
        progressDialog.setMax(100);
        progressDialog.setProgress(0);
        progressDialog.show();
    }

    protected void onProgressUpdate(Integer... values) {
        progressDialog.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(Void result) {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}
