package blog.samples.com.animationssample;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

/*
 * Created by akhil on 6/11/18.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bounce = findViewById(R.id.bounce);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(bounce, "translationY", 0f, 180f);
        objectAnimator.setDuration(1000);
        objectAnimator.setInterpolator(new BounceInterpolator());

        bounce.setOnClickListener(view -> objectAnimator.start());

        Button position = findViewById(R.id.position);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(position, "translationY", 0, 180f);
        objectAnimator1.setDuration(1000);
        objectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator1.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator1.setRepeatMode(ValueAnimator.REVERSE);

        position.setOnClickListener(view -> objectAnimator1.start());

        Button color = findViewById(R.id.color);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofObject(color, "alpha", new ArgbEvaluator(),R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        objectAnimator2.setDuration(1000);
        objectAnimator2.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator2.setRepeatCount(ValueAnimator.INFINITE);

        color.setOnClickListener(view -> objectAnimator2.start());

        Button rotate = findViewById(R.id.rotate);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(rotate, "rotation", 0f, 360f);
        objectAnimator3.setDuration(1000);
        objectAnimator3.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator3.setRepeatCount(ValueAnimator.INFINITE);

        rotate.setOnClickListener(view -> objectAnimator3.start());

        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(view -> {

            if (objectAnimator.isRunning()) {
                objectAnimator.reverse();
                objectAnimator.cancel();
                objectAnimator.end();
            }

            if (objectAnimator1.isRunning()) {
                objectAnimator1.reverse();
                objectAnimator1.cancel();
                objectAnimator.end();
            }

            if (objectAnimator2.isRunning()) {
                objectAnimator2.reverse();
                objectAnimator2.cancel();
                objectAnimator.end();
            }

            if (objectAnimator3.isRunning()) {
                objectAnimator3.reverse();
                objectAnimator3.cancel();
                objectAnimator.end();
            }
        });
    }
}
