package com.risco.android.mobilityhackapp.activites;

<<<<<<< HEAD
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.risco.android.mobilityhackapp.R;
import com.risco.android.mobilityhackapp.utils.CSVFile;
import com.risco.android.mobilityhackapp.utils.NDEFdecrypt;

import java.util.List;
=======
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.risco.android.mobilityhackapp.R;
>>>>>>> 544005a5bc46810a133eac5385a052589cf5a6ad

/**
 * Created by Albert Risco on 10/03/2018.
 */

public class HomescreenActivity extends AppCompatActivity {

    private Context mContext;

    private FirebaseAuth mAuth;

<<<<<<< HEAD
    NfcAdapter nfcAdapter;
    EditText txtTagContent;
    CSVFile csv;
    static List<String[]> l;
    int numOfReads = 0;
    String[] toWrite;
    RequestQueue queue;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
=======
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
>>>>>>> 544005a5bc46810a133eac5385a052589cf5a6ad

        mContext=HomescreenActivity.this;

        mAuth = FirebaseAuth.getInstance();
<<<<<<< HEAD
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

        txtTagContent = (EditText)findViewById(R.id.txtTagContent);
        csv = new CSVFile(getResources().openRawResource(R.raw.metroutils));
        l = csv.read();
        toWrite = new String[2];
        queue = Volley.newRequestQueue(this);
=======
>>>>>>> 544005a5bc46810a133eac5385a052589cf5a6ad

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null){
            Intent intent = new Intent(mContext, LoginActivity.class);

        }
    }
<<<<<<< HEAD

    @Override
    protected void onResume() {
        super.onResume();

        enableForegroundDispatchSystem();
    }

    @Override
    protected void onPause() {
        super.onPause();

        disableForegroundDispatchSystem();
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        if (intent.hasExtra(NfcAdapter.EXTRA_TAG)) {
            Toast.makeText(this, "NfcIntent!", Toast.LENGTH_SHORT).show();

                Parcelable[] parcelables = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);

                if(parcelables != null && parcelables.length > 0)
                {
                    NDEFdecrypt.readTextFromMessage((NdefMessage) parcelables[0],toWrite,numOfReads,txtTagContent,queue);
                    numOfReads++;
                }else{
                    Toast.makeText(this, "No NDEF messages found!", Toast.LENGTH_SHORT).show();
                }
        }
    }

    private void enableForegroundDispatchSystem() {

        Intent intent = new Intent(this, HomescreenActivity.class).addFlags(Intent.FLAG_RECEIVER_REPLACE_PENDING);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        IntentFilter[] intentFilters = new IntentFilter[]{};

        nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFilters, null);
    }

    private void disableForegroundDispatchSystem() {
        nfcAdapter.disableForegroundDispatch(this);
    }


    public static List<String[]> getL() {
        return l;
    }

=======
>>>>>>> 544005a5bc46810a133eac5385a052589cf5a6ad
}
