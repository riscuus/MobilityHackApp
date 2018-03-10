package com.risco.android.mobilityhackapp.utils;

import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.risco.android.mobilityhackapp.activites.HomescreenActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by hector on 10/03/18.
 */

public abstract class VoleyFuncts { //just usable for methods, cannot be instanced

    private static String getURL(String oLatitude, String oLongitude, String dLatitude, String dLongitude){
        return "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + oLatitude+","+oLongitude+"&destinations="+dLatitude+","+dLongitude+ "&key=AIzaSyA-48lZzbH5RRQZqVj9-zyDZErld6lrwBE";
    }

    public static void sendReqGetResp(String[] toWrite, final EditText txtTagContent, RequestQueue queue){
        List<String[]> l = HomescreenActivity.getL(); // gets de CSV data
        String url = getURL(l.get(Integer.parseInt(toWrite[0]))[1], l.get(Integer.parseInt(toWrite[0]))[0], l.get(Integer.parseInt(toWrite[1]))[1], l.get(Integer.parseInt(toWrite[1]))[0]);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            //getJSONArray("elements").get(0).getJsonObject("distance").getInt("value");
                            txtTagContent.setText(extractFromJSON(json)[0]);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //RESPOSTA EN CAS D’ERROR
            }
        });
        queue.add(stringRequest);
    }

    public static String[] extractFromJSON(JSONObject json){ // scalable for adding more paramaters
        String[] data = new String[10]; //max 10 params
        try {
            data[0] = json.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(0).getJSONObject("distance").getString("value");
            return data;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }
}
