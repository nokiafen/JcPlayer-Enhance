package com.example.jean.jcplayer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;

/**
 * Created by chenhailin on 2017/12/26.
 */

public class RoateUtil {
    Context cxt;
    View v;
    private ObjectAnimator animator;

    public RoateUtil(Context cxt, View v) {
        this.cxt = cxt;
        this.v = v;
    }

    /**
     * 开始旋转
     */
    public  void startRotate(){
        v.setVisibility(View.VISIBLE);
            animator=ObjectAnimator.ofFloat(v,"rotation",0f,360f);
            animator.setDuration(1000);
            animator.setInterpolator(new LinearInterpolator());//not stop
            animator.setRepeatCount(-1);//set repeat time forever
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("onAnimationStart","onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("onAnimationEnd","onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
            animator.start();
    }

    public  void stopRotate(){
        if (animator!=null&&animator.isRunning()) {
            animator.removeAllListeners();
            animator.end();
            v.clearAnimation();
        }


        final  ObjectAnimator   alpha = ObjectAnimator.ofFloat(v, "alpha", 1f, 0.5f);
            alpha.setDuration(500);//设置动画时间
            alpha.setInterpolator(new AccelerateInterpolator());//设置动画插入器，减速
            alpha.setRepeatCount(0);//设置动画重复次数，这里-1代表无限
            alpha.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    alpha.end();
                    v.setVisibility(View.INVISIBLE);
                    v.clearAnimation();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            alpha.start();//启动动画。
    }
}
