package com.example.zhang.uoe_qr;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Access_selection_fragment selection_frag = new Access_selection_fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.frag_container,selection_frag).addToBackStack(null).commit();
    }

    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        }
    }

}
