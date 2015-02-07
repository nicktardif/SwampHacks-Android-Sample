package com.swamphacks.sample.swamphacksandroidcodebase;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    ImageView ghostImageView;
    ImageView pieImageView;

    Animation ghostAnimation;
    Animation.AnimationListener ghostAnimationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the pie and ghost image views
        ghostImageView = (ImageView) findViewById(R.id.ghost);
        pieImageView = (ImageView) findViewById(R.id.pie);

        ghostAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.spooky_animation);
        ghostAnimationListener = getGhostAnimationListener();

        pieImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ghostAnimation.setAnimationListener(ghostAnimationListener);
                ghostImageView.setVisibility(View.VISIBLE);
                ghostImageView.bringToFront();
                ghostImageView.startAnimation(ghostAnimation);
            }
        });
    }

    // Create an animation listener to set the visibility to false after the animation ends
    private Animation.AnimationListener getGhostAnimationListener() {
        return new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Don't worry about this
                return;
            }
            public void onAnimationRepeat(Animation animation) {
                // Don't worry about this
                return;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ghostImageView.setVisibility(View.INVISIBLE);
            }
        };
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
