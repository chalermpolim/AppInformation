package com.artrees.appinformation;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.artrees.appinformation.Message.MemberShip;
import com.artrees.appinformation.Model.SynData;
import com.artrees.appinformation.Utility.LoadingTask.FeedLoadingTask;

public class MainActivity extends BaseActivity {
    private Button bt_loaddata;
    protected ProgressBar progress;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // For connection to web error
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        this.progress = (ProgressBar)findViewById(R.id.progress);

        this.progress.setVisibility(View.GONE);
        this.bt_loaddata = (Button) findViewById(R.id.bt_loaddata);

        this.bt_loaddata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new WebServiceLoadingTask(MainActivity.this, "Information").execute();
            }
        });

//        SynData synData = new SynData(getApplicationContext());
//        Toast.makeText(this, synData.SynDate.toString(), Toast.LENGTH_LONG).show();
//
//        synData.setUpdate(getApplicationContext());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class WebServiceLoadingTask extends FeedLoadingTask {

        public WebServiceLoadingTask(Context context, String DataType) {
            super(context, DataType);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // This is for ui coding
        }

        @Override
        protected void onPostExecute(String result) {
            MemberShip memberShip = MemberShip.Instance("Freedom");
            Toast.makeText(MainActivity.this, memberShip.MemberName, Toast.LENGTH_LONG).show();

            super.onPostExecute(result);
        }
    }
}
