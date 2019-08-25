package com.example.sms;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    private EditText txtPhone, txtMessage;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtPhone = (EditText) this.findViewById(R.id.editText);
        this.txtMessage = (EditText) this.findViewById(R.id.editText2);
        this.btnSubmit = (Button) this.findViewById(R.id.button);

        this.btnSubmit.setOnClickListener(this);
    }

	@Override
	public void onClick(View arg0) {
		// get the number entered by the user
        String phone = this.txtPhone.getText().toString();
		// get the message entered by the user
        String message = this.txtMessage.getText().toString();
        
        // check phone number and prompt if the phone number is empty
        if(phone.equals(""))
        {
        	Toast.makeText(this, "Please enter phone number", Toast.LENGTH_LONG).show();
        }
        // check message and prompt if the phone number is empty
        else if(message.equals("")) 
        { 
        	Toast.makeText(this, "Please enter message", Toast.LENGTH_LONG).show();
        }
        // call sendMessage method with arguments phone number, and the message 
        else 
        {
	        sendMessage(phone, message);		
        }
	}

	// sendMessage method
    private void sendMessage(String phone, String message) {
    	// setup sms intent
    	Intent sendSMS = new Intent(Intent.ACTION_VIEW);
    	// address = means the phone number of the recipient
        sendSMS.putExtra("address", phone);
        // sms_body = means the message of the text
        sendSMS.putExtra("sms_body", message);
        // type of text/message
        sendSMS.setType("vnd.android-dir/mms-sms");
        // start sms intent
        this.startActivity(sendSMS);
    }
}