package com.example.usgir.movienow;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    int j[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        j = new int[]{R.drawable.orange,R.drawable.enpt,R.drawable.neevalle,R.drawable.rock,R.drawable.yvm};
        imageView = (ImageView)findViewById(R.id.imageView7);
        final ViewFlipper flipper = (ViewFlipper)findViewById(R.id.flipper);
        flipper.setFlipInterval(2000);
        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        flipper.setInAnimation(in);
        flipper.setOutAnimation(out);
        flipper.startFlipping();
        flipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = flipper.indexOfChild(flipper.getCurrentView());
                imageView.setImageResource(j[i]);
            }
        });
    }
}
