package blog.samples.com.animationssample;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.Button;

import static android.view.MotionEvent.INVALID_POINTER_ID;

/*
 * Created by akhil on 6/11/18.
 */

public class MainActivity extends AppCompatActivity implements ScaleGestureDetector.OnScaleGestureListener {

    SpringAnimation springAnimation;
    private float dx = 0;
    private float dy = 0;
    private Button reset;
    private boolean isFirst = false;

    private ScaleGestureDetector scaleGestureDetector;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mActivePointerId;
    private float mPosX;
    private float mPosY;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = findViewById(R.id.reset);
        scaleGestureDetector = new ScaleGestureDetector(this, this);

        springAnimation = new SpringAnimation(reset, DynamicAnimation.TRANSLATION_Y);


      /*  Button bounce = findViewById(R.id.bounce);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(bounce, "translationY", 0f, 180f);
        objectAnimator.setDuration(1000);
        objectAnimator.setInterpolator(new BounceInterpolator());
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);

        scaleGestureDetector = new ScaleGestureDetector(this, this);

        bounce.setOnClickListener(view -> objectAnimator.start());

        Button position = findViewById(R.id.position);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(position, "translationY", 0, 180f);
        objectAnimator1.setDuration(1000);
        objectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator1.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator1.setRepeatMode(ValueAnimator.REVERSE);

        position.setOnClickListener(view -> objectAnimator1.start());

        Button color = findViewById(R.id.color);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofObject(color, "backgroundColor", new ArgbEvaluator(),*//*Red*//*0xFFFF8080, *//*Blue*//*0xFF8080FF);
        objectAnimator2.setDuration(1000);
        objectAnimator2.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator2.setRepeatCount(ValueAnimator.INFINITE);


        objectAnimator2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                Log.i("animation", "cancelled " + animation.isPaused());
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                Log.i("animation", "started " + animation.isStarted());
            }
        });

        color.setOnClickListener(view -> objectAnimator2.start());

        Button rotate = findViewById(R.id.rotate);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(rotate, "rotation", 0f, 360f);
        objectAnimator3.setDuration(1000);
        objectAnimator3.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator3.setRepeatCount(ValueAnimator.INFINITE);

        rotate.setOnClickListener(view -> objectAnimator3.start());

        reset = findViewById(R.id.reset);
        SpringAnimation springAnimation = new SpringAnimation(reset, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(10);
        springForce.setFinalPosition(200);
        springForce.setStiffness(4);
        springAnimation.setSpring(springForce);


        String[] mimetypes = new String[1];
        mimetypes[0] = ClipDescription.MIMETYPE_TEXT_PLAIN;

        ClipData clipData = new ClipData(new ClipDescription("SimpleDrag", mimetypes), new ClipData.Item("Drag a view"));*/


      /*  reset.setOnClickListener(view -> {

            springAnimation.start();

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

        reset.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {

                return false;
            }
        });*/

        /*reset.setOnTouchListener((view, motionEvent) -> {

            switch (motionEvent.getAction()) {

                case MotionEvent.ACTION_DOWN:
                    dx = view.getX() - motionEvent.getRawX();
                    dy = view.getY() - motionEvent.getRawY();
                    return true;

                 case MotionEvent.ACTION_MOVE:
                     float newX = motionEvent.getRawX() + dx;
                     float newY = motionEvent.getY() + dy;

                     view.animate().x(newX).y(newY).setDuration(0).start();
                     springAnimation.animateToFinalPosition(newX);
                     springAnimation.animateToFinalPosition(newY);
                     return true;
            }
            return false;
        });
*/

    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Let the ScaleGestureDetector inspect all events.
        scaleGestureDetector.onTouchEvent(ev);

        final int action = ev.getActionMasked();

        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                final int pointerIndex = ev.getActionIndex();
                final float x = ev.getX(pointerIndex);
                final float y = ev.getY(pointerIndex);

                // Remember where we started (for dragging)
                mLastTouchX = x;
                mLastTouchY = y;
                // Save the ID of this pointer (for dragging)
                mActivePointerId = ev.getPointerId(0);

                break;
            }

            case MotionEvent.ACTION_MOVE: {
                // Find the index of the active pointer and fetch its position
                final int pointerIndex =
                        ev.findPointerIndex(mActivePointerId);

                final float x = ev.getX(pointerIndex);
                final float y = ev.getY(pointerIndex);

                // Calculate the distance moved
                final float dx = x - mLastTouchX;
                final float dy = y - mLastTouchY;

                mPosX += dx;
                mPosY += dy;

                reset.setX(mPosX);
                reset.setY(mPosY);

                // Remember this touch position for the next move event
                mLastTouchX = x;
                mLastTouchY = y;


                break;
            }

            case MotionEvent.ACTION_UP: {
                mActivePointerId = INVALID_POINTER_ID;
                break;
            }

            case MotionEvent.ACTION_BUTTON_RELEASE: {
                Log.i("drag", "fired_Release");
            }

            case MotionEvent.ACTION_CANCEL: {
                mActivePointerId = INVALID_POINTER_ID;
                Log.i("drag", "fired_Cancel");
                break;
            }

            case MotionEvent.ACTION_POINTER_UP: {

                final int pointerIndex = MotionEventCompat.getActionIndex(ev);
                final int pointerId = MotionEventCompat.getPointerId(ev, pointerIndex);

                if (pointerId == mActivePointerId) {
                    // This was our active pointer going up. Choose a new
                    // active pointer and adjust accordingly.
                    final int newPointerIndex = pointerIndex == 0 ? 1 : 0;
                    mLastTouchX = MotionEventCompat.getX(ev, newPointerIndex);
                    mLastTouchY = MotionEventCompat.getY(ev, newPointerIndex);
                    mActivePointerId = MotionEventCompat.getPointerId(ev, newPointerIndex);
                }
                break;
            }
        }
        return true;
    }

    @Override
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        return false;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return false;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

    }
}
