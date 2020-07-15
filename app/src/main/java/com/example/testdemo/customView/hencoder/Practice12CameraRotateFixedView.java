package com.example.testdemo.customView.hencoder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.test.R;
import com.example.testdemo.LLog;


public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Camera camera = new Camera();
    Matrix matrix = new Matrix();

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX1 = point1.x + bitmapWidth/2;
        int centerY1 = point1.y + bitmapHeight/2;
        int centerX2 = point2.x + bitmapWidth/2;
        int centerY2 = point2.y + bitmapHeight/2;

        LLog.d("cameraLocation", camera.getLocationX()
                + "\n" + camera.getLocationY()
                + "\n" + camera.getLocationZ());

        camera.save();
        camera.rotateX(30);
        matrix.reset();
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-centerX1, -centerY1);
        matrix.postTranslate(centerX1, centerY1);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


        /**
         * Canvas 的几何变换顺序是反的，所以要把移动到中心的代码写在下面，把从中心移动回来的代码写在上面。
         * */
        canvas.save();
        camera.save(); // 保存 Camera 的状态
        camera.rotateY(30); // 旋转 Camera 的三维空间
        canvas.translate(centerX2, centerY2); // 旋转之后把投影移动回来
        camera.applyToCanvas(canvas); // 把旋转投影到 Canvas
        canvas.translate(-centerX2, -centerY2); // 旋转之前把绘制内容移动到轴心（原点）
        camera.restore(); // 恢复 Camera 的状态
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);

        canvas.restore();
    }
}
