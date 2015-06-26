package com.nikhil.watermark.activity;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.ImageView;

public class WaterMarkActivity extends Activity {
	ImageView imViewAndroid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imViewAndroid = (ImageView) findViewById(R.id.imViewAndroid);
		Point p=new Point();
		p.set(180, 1000);
		Bitmap b=waterMark(BitmapFactory.decodeResource(getResources(), R.drawable.car),"₤12345678",p,Color.BLUE,90,30,true);
		imViewAndroid.setImageBitmap(b);

	}
	public  Bitmap waterMark(Bitmap src, String watermark, Point location, int color, int alpha, int size, boolean underline) {
		//get source image width and height
		int w = src.getWidth();
		int h = src.getHeight();

		Bitmap result = Bitmap.createBitmap(w, h, src.getConfig());
		
		Canvas canvas = new Canvas(result);
		canvas.drawBitmap(src, 0, 0, null);
		Paint paint = new Paint();
		paint.setColor(color);
		paint.setAlpha(alpha);
		paint.setTextSize(30);
		paint.setAntiAlias(true);
		paint.setColor(Color.BLUE);
		canvas.drawRect(0, 0, 170, 70, paint);		
		paint.setColor(Color.WHITE);
		paint.setFakeBoldText(true);
		canvas.drawText(watermark, 0, 50, paint);

		return result;
	}
}