package com.example.t0716025;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PostCalculateTask implements  Response.Listener , Response.ErrorListener  {
    protected String BASE_URL;
    protected IMainActivity ui;
    protected Context context;
    protected Gson gson;
    protected  String jsonInput;


    public PostCalculateTask(IMainActivity ui , Activity activity){
        this.ui = ui;
        this.BASE_URL = "http://api.mathjs.org/v4/";
        this.gson = new Gson();
        this.context = (Activity) activity;
    }
    public void execute(String[] expr, int precision)
    {
        Input input = new Input(expr , precision);
       this.jsonInput =   this.gson.toJson(input);

    }

    public void callVolley(JSONObject json)
    {
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest request =  new JsonObjectRequest(this.BASE_URL , json ,this , this);
        queue.add(request);

    }

    public void processResult(String json)
    {
        gson.fromJson(json,Result.class);
    }

    @Override
    public void onResponse(Object response) {
            this.ui.updateText("sukses");
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        this.ui.updateText("error");
    }
}
