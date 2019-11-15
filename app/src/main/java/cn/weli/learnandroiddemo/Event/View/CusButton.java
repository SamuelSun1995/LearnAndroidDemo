package cn.weli.learnandroiddemo.Event.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

public class CusButton extends AppCompatButton {

    private int tag =-1;

    public CusButton(Context context) {
        super(context);
    }

    public CusButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CusButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(++tag>0){

            setBackgroundColor(Color.GREEN);

        }

    }
}
