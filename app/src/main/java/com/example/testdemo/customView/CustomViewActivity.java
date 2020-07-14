package com.example.testdemo.customView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.test.R;

public class CustomViewActivity extends AppCompatActivity {

    private int[] imgs = new int[] {R.drawable.zoom_imageview, R.drawable.zoom_imageview2,
            R.drawable.zoom_imageview3};
    private ImageView[] imageViews = new ImageView[imgs.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view2);

//        ViewPager viewPager = findViewById(R.id.viewpager);
////
//        viewPager.setAdapter(new PagerAdapter() {
//            @Override
//            public int getCount()    {
//                return imgs.length;
//            }
//
//            @NonNull
//            @Override
//            public Object instantiateItem(@NonNull ViewGroup container, int position) {
//                ZoomImageView zoomImageView = new ZoomImageView(CustomViewActivity.this);
//                zoomImageView.setScaleType(ImageView.ScaleType.MATRIX);
//                zoomImageView.setImageResource(imgs[position]);
//                imageViews[position] = zoomImageView;
//                container.addView(zoomImageView);
//                return zoomImageView;
//            }
//
//            @Override
//            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
////                super.destroyItem(container, position, object);
//                container.removeView(imageViews[position]);
//            }
//
//            @Override
//            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
//                return view == o;
//            }
//        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
