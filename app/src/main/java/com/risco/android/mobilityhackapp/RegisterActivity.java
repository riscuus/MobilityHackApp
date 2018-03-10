package com.risco.android.mobilityhackapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Albert Risco on 10/03/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    private Context mContext;

    //Layout stuff
    private EditText mUsername;
    private EditText mEmail;
    private EditText mPassword;
    private ProgressBar mProgressBar;
    private Button btnRegister;
    private LinearLayout mLoginLink;

    private String username;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_register);

        initWidgets();

        //Intent to login activity
        TextView newAccountText = (TextView) findViewById(R.id.newAccountText);
        newAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RegisterActivity.class);
                startActivity(intent);

            }
        });
    }

    private void initWidgets(){
        mContext = RegisterActivity.this;
        mUsername=(EditText) findViewById(R.id.register_input_username);
        mEmail=(EditText) findViewById(R.id.register_input_email);
        mPassword=(EditText) findViewById(R.id.register_input_password);
        mProgressBar=(ProgressBar) findViewById(R.id.register_progressBar);
        btnRegister =(Button) findViewById(R.id.register_btn);
        mLoginLink=(LinearLayout) findViewById(R.id.login_text);
        //firebaseMethods = new FirebaseMethods(mContext);
        //append="";
        mLoginLink=(LinearLayout) findViewById(R.id.login_text);
        mProgressBar.setVisibility(View.GONE);
    }
}
