package com.testnotepad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnRun = (Button)findViewById(R.id.button_run);
        btnRun.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e("Test", "onclick");
				do_exec("am instrument --user 0 -w com.testnotepad/com.testnotepad.InstrumentationTestRunner");
			}
		});
	}
	
	String do_exec(String cmd) {  
        String s = "/n";  
        try {  
            Process p = Runtime.getRuntime().exec(cmd);  
            BufferedReader in = new BufferedReader(  
                                new InputStreamReader(p.getInputStream()));  
            String line = null;  
            while ((line = in.readLine()) != null) {  
                s += line + "/n";                 
            }  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return cmd;       
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
