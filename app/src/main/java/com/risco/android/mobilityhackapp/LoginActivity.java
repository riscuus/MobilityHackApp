package com.risco.android.mobilityhackapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Albert Risco on 10/03/2018.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private Context mContext;

    //Layout stuff
    private ProgressBar mProgressBar;
    private EditText mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initWidgets();

        //Intent to register activity
        TextView newAccountText = (TextView) findViewById(R.id.newAccountText);
        newAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RegisterActivity.class);
                startActivity(intent);

            }
        });
    }

    public void initWidgets(){
        //Initialize stuff
        mProgressBar=(ProgressBar) findViewById(R.id.login_loading_progressBar);
        mEmail=(EditText) findViewById(R.id.input_email);
        mPassword=(EditText) findViewById(R.id.input_password);
        mContext=LoginActivity.this;
        mProgressBar.setVisibility(View.GONE);
    }
}
