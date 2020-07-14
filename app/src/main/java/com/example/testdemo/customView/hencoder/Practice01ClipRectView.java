package com.example.testdemo.customView.hencoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.test.R;


public class Practice01ClipRectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Path path;

    public Practice01ClipRectView(Context context) {
        super(context);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = (getWidth() - bitmap.getWidth()) / 2;
        int top = (getHeight() - bitmap.getHeight()) / 2;

        path.addCircle(left + (float) bitmap.getWidth() / 2 + 50,
                top + (float) bitmap.getWidth() / 2 +50,
                (float) bitmap.getWidth() / 2,
                Path.Direction.CW);

        canvas.save();
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, left, top, paint);
        canvas.restore();
    }
}
