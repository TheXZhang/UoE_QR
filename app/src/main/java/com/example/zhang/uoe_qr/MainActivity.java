package com.example.zhang.uoe_qr;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClickSignin(View v) {
        Display_qr_fragment qr_frag = new Display_qr_fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.qr_frag_container,qr_frag).addToBackStack(null).commit();
        }



}
