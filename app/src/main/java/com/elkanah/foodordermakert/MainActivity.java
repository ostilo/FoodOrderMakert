package com.elkanah.foodordermakert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elkanah.foodordermakert.ui.LoginFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager mslideViewPager;
    private LinearLayout mdotLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDots;
    private Button btn1,btn2;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mslideViewPager = findViewById(R.id.SlideViewPager);
        mdotLayout = findViewById(R.id.DotLayout);
        sliderAdapter = new SliderAdapter(this);
        mslideViewPager.setAdapter(sliderAdapter);
        btn1 = findViewById(R.id.btn_back);
        btn2 = findViewById(R.id.btn_next);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mslideViewPager.setCurrentItem(mCurrentPage + 1);
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });
        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mslideViewPager.setCurrentItem(mCurrentPage - 1);
                    }
                });

        addDotIndicator(0);
        mslideViewPager.addOnPageChangeListener(viewListner);
    }

    public void addDotIndicator(int position) {
        mDots = new TextView[3];
        mdotLayout.removeAllViews();
        int i;
        for (i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226:"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorPrimary));
            mdotLayout.addView(mDots[i]);
        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
    ViewPager.OnPageChangeListener viewListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotIndicator(i);

            mCurrentPage = i;
            if (i==0){
                btn2.setEnabled(true);
                btn1.setEnabled(false);
                btn2.setVisibility(View.INVISIBLE);
                btn1.setVisibility(View.INVISIBLE);
                btn2.setText("Next");
                btn1.setText("");
            }else if (i==mDots.length-1){
                btn2.setEnabled(true);
                btn1.setEnabled(true);
                btn1.setVisibility(View.VISIBLE);
                btn2.setText("Finish");
                btn1.setText("Back");
            }else {
                btn2.setEnabled(true);
                btn1.setEnabled(true);
                btn2.setVisibility(View.VISIBLE);
                btn1.setVisibility(View.VISIBLE);
                btn2.setText("Next");
                btn1.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}

