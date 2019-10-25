package com.example.t0716025;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.net.URI;
import java.net.URL;

public class PostCalculateTask {
    protected String BASE_URL;
    protected IMainActivity ui;
    protected Context context;
    protected Gson gson;

    public void execute(String[] expr, int precision)
    {
        Input input=new Input(expr,precision);
        String inputStr=gson.toJson(input);
    }

    public void callVolley(JSONObject json)
    {
        BASE_URL="(http://api.mathjs.org/";
        RequestQueue queue= Volley.newRequestQueue(context);
        StringRequest stringRequest=new StringRequest(Request.Method.POST,BASE_URL,new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                textView.setText("Response is: "+ response.substring(0,500));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("That didn't work!");
            }
        });

    }

    public void processResult(String json)
    {
        gson.fromJson(json,Result.class);
    }
}
