package com.artrees.appinformation;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.artrees.appinformation.Utility.LoadingTask.ProgressLoadingTask;

/**
 * Created by Artrees on 12/31/2015.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected abstract int getLayoutResId();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(getLayoutResId());

        this.toolbar = (Toolbar)findViewById(R.id.toolbar);

        this.toolbar.setNavigationIcon(android.R.drawable.ic_lock_idle_lock);
        this.setTitle("App Information");
        setSupportActionBar(this.toolbar);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        //// For FloatActionTheme
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Replace Action this part", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });
    }



    protected class ImagesLoadingTask extends ProgressLoadingTask {

        public ImagesLoadingTask(Context context, String DataType) {
            super(context, DataType);
        }

        @Override
        protected Void doInBackground(Void... params) {
            return null;
        }
    }
}
