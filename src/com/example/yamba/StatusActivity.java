package com.example.yamba;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import winterwell.jtwitter.Twitter;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StatusActivity extends Activity implements OnClickListener {
	private static final String TAG = "StatusActivity";
	EditText messageField;
	Button sendButton;
	Twitter twitter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status);
		
		messageField = (EditText)findViewById(R.id.messageField);
		sendButton = (Button)findViewById(R.id.sendButton);
		
		sendButton.setOnClickListener(this);
		
		twitter = new Twitter("student", "password");
		twitter.setAPIRootUrl("http://ymba.example.com/api");
	}
	
	public void onClick(View v) {
		twitter.setStatus(messageField.getText().toString());
		Log.d(TAG, "onClicked");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.status, menu);
		return true;
	}

}
