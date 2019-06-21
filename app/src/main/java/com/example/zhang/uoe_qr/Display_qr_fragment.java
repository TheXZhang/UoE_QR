package com.example.zhang.uoe_qr;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Display_qr_fragment extends Fragment {

    private ImageView qr_view;
    private Animation fadeOutAnimation = new AlphaAnimation (1.0f, 0.0f);
    private Animation fadeInAnimation = new AlphaAnimation (0.0f, 1.0f);
    private int count=1;
    private TextView textTimer;
    private int time=59;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.display_qr_frag,container,false);
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
        qr_view = v.findViewById(R.id.qr_view);
        textTimer = v.findViewById(R.id.timer);

        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fadeOutAnimation.setDuration(2000);
        fadeInAnimation.setDuration(2000);

        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                qr_view.startAnimation(fadeOutAnimation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        fadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                if (count >3){
                    count =1;
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                switch (count){
                    case 1:
                        Glide.with(getContext()).asBitmap().load("https://i.ibb.co/yfDw6y6/qr3.png").into(qr_view);
                        qr_view.startAnimation(fadeInAnimation);
                        Log.d("count1", "1");
                        count++;
                        break;
                    case 2:
                        Glide.with(getContext()).asBitmap().load("https://i.ibb.co/CQgYrWv/qr2.png").into(qr_view);
                        qr_view.startAnimation(fadeInAnimation);
                        Log.d("count2", "2");
                        count++;
                        break;
                    case 3:
                        Glide.with(getContext()).asBitmap().load("https://i.ibb.co/L1w3byW/qr1.png").into(qr_view);
                        qr_view.startAnimation(fadeInAnimation);
                        Log.d("count3", "3");
                        count++;
                        break;

                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        qr_view.startAnimation(fadeOutAnimation);

        new CountDownTimer(60000*2, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                textTimer.setText(new SimpleDateFormat("mm:ss", Locale.UK).format(new Date(millisUntilFinished)));
            }

            @Override
            public void onFinish() {
                textTimer.setText("QR code expired");
            }
        }.start();

    }



}
