package com.example.t0716025;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements  IMainActivity , View.OnClickListener {

    PostCalculateTask postCalculateTask;
    TextView res , expr , precision;
    Button btnHitung;
    HashMap<String  , Input > params;
    Input input;
    JSONObject json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.res = this.findViewById(R.id.res);
        this.expr = this.findViewById(R.id.inputEkspresi);
        this.precision = this.findViewById(R.id.precision);
        this.btnHitung = this.findViewById(R.id.cntBtn);
        this.btnHitung.setOnClickListener(this);
        this.params = new HashMap<>();

    }

    @Override
    public void updateText(String message) {
        this.res.setText(message);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==  this.btnHitung.getId()){
            this.input = new Input(new String[] {this.expr.getText().toString()} , Integer.parseInt(this.precision.getText().toString()));
            this.params.put("params" , this.input);
            Log.d("wow", "onClick: ");
        }
    }
}
