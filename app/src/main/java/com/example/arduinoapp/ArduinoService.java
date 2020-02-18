package com.example.arduinoapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ArduinoService {



    @GET("change")
    Call<Arduino> getState();

    @GET("switch")
    Call<Arduino> getMode();
}


/*
                StringRequest stringRequest = new StringRequest(Request.Method.GET,
                        "http://192.168.43.142:8000/archlogr" , new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        Toast.makeText(getApplicationContext(),"Response :"+ response,Toast.LENGTH_LONG).show();                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                    }
                });

                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
*/
