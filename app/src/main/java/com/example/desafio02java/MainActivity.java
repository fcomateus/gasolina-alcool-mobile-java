package com.example.desafio02java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewHolder.btn_verify = findViewById(R.id.verify);
        mViewHolder.et_alcohol_price = findViewById(R.id.alcohol_price);
        mViewHolder.et_gas_price = findViewById(R.id.gas_price);

        this.mViewHolder.btn_verify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.verify){
            Double alcohol_price = Double.valueOf(this.mViewHolder.et_alcohol_price.getText().toString());
            Double gas_price = Double.valueOf(this.mViewHolder.et_gas_price.getText().toString());

            if(alcohol_price/gas_price >= 0.7f){
                //gasolina
                Toast.makeText(this, this.getString(R.string.better_gas), Toast.LENGTH_LONG).show();
            } else {
                //alcool
                Toast.makeText(this, this.getString(R.string.better_alcohol), Toast.LENGTH_LONG).show();
            }

        }
    }

    private static class ViewHolder {
        EditText et_gas_price;
        EditText et_alcohol_price;
        Button btn_verify;
    }
}