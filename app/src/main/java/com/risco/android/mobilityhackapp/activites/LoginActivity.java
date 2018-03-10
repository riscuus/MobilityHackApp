package com.risco.android.mobilityhackapp.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.risco.android.mobilityhackapp.R;
<<<<<<< HEAD
import com.risco.android.mobilityhackapp.utils.CSVFile;

import java.util.List;
=======
>>>>>>> 544005a5bc46810a133eac5385a052589cf5a6ad

/**
 * Created by Albert Risco on 10/03/2018.
 */

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private Context mContext;

<<<<<<< HEAD

=======
>>>>>>> 544005a5bc46810a133eac5385a052589cf5a6ad
    //Layout stuff
    private ProgressBar mProgressBar;
    private EditText mEmail, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
<<<<<<< HEAD
=======

>>>>>>> 544005a5bc46810a133eac5385a052589cf5a6ad
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

<<<<<<< HEAD

=======
>>>>>>> 544005a5bc46810a133eac5385a052589cf5a6ad
}
