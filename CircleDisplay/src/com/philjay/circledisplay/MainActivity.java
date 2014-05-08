
package com.philjay.circledisplay;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
    
    private CircleDisplay mCircleDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mCircleDisplay = (CircleDisplay) findViewById(R.id.circleDisplay);

        mCircleDisplay.setAnimDuration(3000);
        mCircleDisplay.setValueWidthPercent(55f);
        mCircleDisplay.showPercentage(75f, true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.refresh) mCircleDisplay.showValue((float) (Math.random() * 1000f), 1000f, true);
        if(item.getItemId() == R.id.github) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/PhilJay/CircleDisplay"));
            startActivity(i);
        }
        return true;
    }
}