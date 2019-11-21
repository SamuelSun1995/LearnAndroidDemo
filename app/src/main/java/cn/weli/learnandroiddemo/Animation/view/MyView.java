package cn.weli.learnandroiddemo.Animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.nio.file.Path;

public class MyView extends View {

    //定义画笔
    private Paint paint =new Paint();
    private RectF rect = new RectF();


    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //把整张画布绘制成白色
        canvas.drawColor(Color.WHITE);
        //去锯齿
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4f);
        int viewWidth = this.getWidth();
        //绘制圆
        canvas.drawCircle(viewWidth/10+10,viewWidth/10+10,viewWidth/10,paint);
        //绘制正方形
        canvas.drawRect(10f,viewWidth/5+20,viewWidth/5+10,viewWidth*2/5+20,paint);
    }
}
