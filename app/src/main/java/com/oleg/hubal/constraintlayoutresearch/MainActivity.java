package com.oleg.hubal.constraintlayoutresearch;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ConstraintSet mConstraintSet = new ConstraintSet();
    private ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mConstraintLayout = (ConstraintLayout) findViewById(R.id.content);
        mConstraintSet.clone(mConstraintLayout);
        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startConstraintAnimation();
            }
        });
    }

    private void startConstraintAnimation() {
        TransitionManager.beginDelayedTransition(mConstraintLayout);
        mConstraintSet.connect(R.id.imageView4, ConstraintSet.BOTTOM, R.id.content, ConstraintSet.BOTTOM, 0);
        mConstraintSet.connect(R.id.imageView4, ConstraintSet.RIGHT, R.id.content, ConstraintSet.RIGHT, 0);
        mConstraintSet.connect(R.id.imageView4, ConstraintSet.TOP, R.id.content, ConstraintSet.TOP, 0);
        mConstraintSet.connect(R.id.imageView4, ConstraintSet.LEFT, R.id.content, ConstraintSet.LEFT, 0);
        mConstraintSet.applyTo(mConstraintLayout);
    }

    private void vectorIconAnimation() {
        final ImageView imageView = (ImageView) findViewById(R.id.iv_vector);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable vector = imageView.getDrawable();
                ((Animatable) vector).start();
            }
        });
    }
}
