package com.risco.android.mobilityhackapp.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.risco.android.mobilityhackapp.R;
import com.risco.android.mobilityhackapp.utils.FirebaseMethods;

/**
 * Created by Albert Risco on 10/03/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    private Context mContext;

    //Firebase stuff
    private FirebaseAuth mAuth;
    private FirebaseMethods firebaseMethods;

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
        setContentView(R.layout.activity_register);



        initWidgets();
        mProgressBar.setVisibility(View.GONE);

        SetupRegisterListener();


    }

    private void initWidgets(){
        mContext = RegisterActivity.this;
        mUsername=(EditText) findViewById(R.id.register_input_username);
        mEmail=(EditText) findViewById(R.id.register_input_email);
        mPassword=(EditText) findViewById(R.id.register_input_password);
        mProgressBar=(ProgressBar) findViewById(R.id.register_progressBar);
        btnRegister =(Button) findViewById(R.id.register_btn);
        mLoginLink=(LinearLayout) findViewById(R.id.login_text);
        firebaseMethods = new FirebaseMethods(mContext);
        //append="";
        mLoginLink=(LinearLayout) findViewById(R.id.login_text);
        mProgressBar.setVisibility(View.GONE);
        mAuth = FirebaseAuth.getInstance();
    }

    private void SetupRegisterListener(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=mEmail.getText().toString();
                password=mPassword.getText().toString();
                username=mUsername.getText().toString();

                if(email==null || password==null || username==null){
                    Toast.makeText(mContext, "Ups! You must fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    mProgressBar.setVisibility(View.VISIBLE);
                    firebaseMethods.registerNewEmail(email, password, username, mProgressBar);
                    firebaseMethods.addNewUserData(email, password, username);



                }
            }
        });
    }


}
