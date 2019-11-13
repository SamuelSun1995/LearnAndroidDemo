package cn.weli.learnandroiddemo.ViewControl.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class DrawView extends View {

    private float currentX = 40f;
    private float currentY = 50f;

    //定义并且创建画笔
    private Paint p = new Paint();


    //xml中初始化必须加入
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置画笔颜色
        p.setColor(Color.RED);
        //绘制一个小球
        canvas.drawCircle(currentX, currentY, 15F, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        //修改两个成员变量
        currentX = event.getX();
        currentY = event.getY();
        //通知当前组件重绘自己
        invalidate();

        return true;
    }

}
