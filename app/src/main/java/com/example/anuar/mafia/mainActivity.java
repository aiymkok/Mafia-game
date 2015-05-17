package com.example.anuar.mafia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class mainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        Button buttonRank = (Button) findViewById(R.id.buttonRank);
        Button buttonRule = (Button) findViewById(R.id.buttonRule);
        Button buttonExit = (Button) findViewById(R.id.buttonExit);


        buttonStart.setOnClickListener(this);
        buttonRank.setOnClickListener(this);
        buttonRule.setOnClickListener(this);
        buttonExit.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.buttonStart:
                intent = new Intent(this, playActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonRank:
                intent = new Intent(this, rankActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonRule:
                intent = new Intent(this, ruleActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonExit:
                finish();
                System.exit(0);
                break;
        }

    }
}
