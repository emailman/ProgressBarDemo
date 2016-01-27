package edu.dtcc.nhollowa.progressbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar firstBar = null;
    private ProgressBar secondBar = null;
    private Button myButton;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstBar = (ProgressBar) findViewById(R.id.firstBar);
        secondBar = (ProgressBar) findViewById(R.id.secondBar);
        myButton = (Button)findViewById(R.id.myButton);
        myButton.setOnClickListener(new ButtonListener());

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

    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            if (i == 0 || i == 10){
                //make the progress bar visible
                firstBar.setVisibility(View.VISIBLE);
                firstBar.setMax(150);
                secondBar.setVisibility(View.VISIBLE);
            } else if (i < firstBar.getMax()){
                //set first progress bar value
                firstBar.setProgress(i);
                //set second progress bar
                firstBar.setSecondaryProgress(i + 10);
            } else {

                firstBar.setProgress(0);

                firstBar.setSecondaryProgress(0);

                i = 0;
                firstBar.setVisibility(View.GONE);
                secondBar.setVisibility(View.GONE);
            }

            i = i + 10;
        }
    }
}
