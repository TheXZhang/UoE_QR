package com.example.zhang.uoe_qr;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Authorisation extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorisation_layout);

    }

    public void onClickAuthorise(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
