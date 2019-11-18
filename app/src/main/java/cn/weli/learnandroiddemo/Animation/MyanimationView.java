package cn.weli.learnandroiddemo.Animation;

import android.animation.AnimatorInflater;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;

import cn.weli.learnandroiddemo.R;

public class MyanimationView extends View {
    public MyanimationView(Context context) {
        super(context);
        //加载动画资源
        ObjectAnimator colorAnim = (ObjectAnimator) AnimatorInflater.loadAnimator(context, R.animator.color_anim);
        colorAnim.setEvaluator(new ArgbEvaluator());

        //对View本身应用属性动画
        colorAnim.setTarget(this);
        //开始指定动画
        colorAnim.start();
    }
}
