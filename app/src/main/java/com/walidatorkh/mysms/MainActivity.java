package com.walidatorkh.mysms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView phoneNumber;
    TextView messageText;
    TextView url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNumber = (TextView)findViewById(R.id.phoneNumber);
        messageText = (TextView)findViewById(R.id.messageText);
        url = (TextView)findViewById(R.id.EditTextUrl);
    }


    public void sendMessage(View view) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms: " + phoneNumber.getText().toString()));
        intent.putExtra("sms_body", messageText.getText().toString());

        startActivity(intent);

    }
    public void openUrl(View view){
        String urlText = url.getText().toString();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(urlText));

        String refferUrl = "https://www.google.com";
        intent.putExtra(Intent.EXTRA_REFERRER, refferUrl);

        startActivity(intent);

    }



}
