package com.risco.android.mobilityhackapp.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.risco.android.mobilityhackapp.models.User;

/**
 * Created by Albert Risco on 10/03/2018.
 */

public class FirebaseMethods {
    private static final String TAG = "FirebaseMethods";

    private Context mContext;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    private String userID;

    public FirebaseMethods(Context context){
        mContext=context;
        mAuth= FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef=mFirebaseDatabase.getReference();

        if(mAuth.getCurrentUser() != null){
            userID = mAuth.getCurrentUser().getUid();
        }

    }

    /**
     * Register a new email into firebase
     * @param email
     * @param password
     * @param username
     */
    public void registerNewEmail(final String email, String password, final String username, final ProgressBar pb){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            userID = mAuth.getCurrentUser().getUid();
                            Toast.makeText(mContext, "Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                            pb.setVisibility(View.GONE);


                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(mContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            pb.setVisibility(View.GONE);
                        }

                        // ...
                    }
                });
    }
    public void addNewUserData(final String email, final String password, final String username){
        Log.d(TAG, "registerNewUserData: Adding new user to de database");

        User user = new User(userID, email, password, username,0);

        myRef.child("users").child(userID).setValue(user);

    }
}
