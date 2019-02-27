package com.videos.luisdalopez56.dibujos03;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class Grafico extends View {

    int color = 0;
    float ancho = 0, alto = 0;

    public Grafico(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray colorTyped = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CustomView, 0 , 0);
        color = colorTyped.getInteger(R.styleable.CustomView_viewColor,0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (this.color == 0) {
        Random rnd = new Random();
        this.color = Color.argb(255, (int) rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        }

        Paint pincel = new Paint();
        pincel.setStyle(Paint.Style.FILL);
        pincel.setAntiAlias(true);
        pincel.setColor(color);
        canvas.drawRect(0 ,0 ,ancho ,alto , pincel);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        ancho = w;
        alto = h;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor(){
        invalidate();
        return color;
    }
}