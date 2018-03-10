package com.risco.android.mobilityhackapp.utils;

import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.util.Log;
import android.widget.EditText;

import com.android.volley.RequestQueue;

import java.io.UnsupportedEncodingException;

/**
 * Created by hector on 10/03/18.
 */

public abstract class NDEFdecrypt { //just usable for methods, cannot be instanced

    public static String getTextFromNdefRecord(NdefRecord ndefRecord)  // gets the text from a record (inside a message)
    {
        String tagContent = null;
        try {
            byte[] payload = ndefRecord.getPayload();
            String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";
            int languageSize = payload[0] & 0063;
            tagContent = new String(payload, languageSize + 1,
                    payload.length - languageSize - 1, textEncoding);
        } catch (UnsupportedEncodingException e) {
            Log.e("getTextFromNdefRecord", e.getMessage(), e);
        }
        return tagContent;
    }

    public static void readTextFromMessage(NdefMessage ndefMessage, String[] toWrite, int numOfReads, EditText txtTagContent, RequestQueue queue) { // does the whole deencrpytion and Sends data to the api

        NdefRecord[] ndefRecords = ndefMessage.getRecords();

        if(ndefRecords != null && ndefRecords.length>0){

            NdefRecord ndefRecord = ndefRecords[0];
            toWrite[numOfReads] = NDEFdecrypt.getTextFromNdefRecord(ndefRecord);
            //String csvWrite = toWrite + "\n" + l.get(Integer.parseInt(toWrite))[0].toString();
            if(numOfReads==1) {
                VoleyFuncts.sendReqGetResp(toWrite,txtTagContent,queue);
            }
            //txtTagContent.setText(csvWrite);
        }
    }


}
