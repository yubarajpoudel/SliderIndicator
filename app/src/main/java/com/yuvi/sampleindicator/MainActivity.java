package com.yuvi.sampleindicator;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yuvi.widget.SliderIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = findViewById(R.id.pager);
        List<String> dataList = new ArrayList<>();
        dataList.add(0, "page1");
        dataList.add(1, "page2");
        dataList.add(2, "page3");

        BaseViewPagerAdapter<String> adapter = new BaseViewPagerAdapter<String>(getSupportFragmentManager(), dataList) {
            @Override
            public Fragment attachFragment(String s) {
                return new SampleScreenFragment();
            }
        };
        pager.setAdapter(adapter);
        SliderIndicator sliderIndicator1 = findViewById(R.id.sliderIndicator1);
        sliderIndicator1.addWithSlider(pager);

        SliderIndicator sliderIndicator2 = findViewById(R.id.sliderIndicator2);
        sliderIndicator2.addWithSlider(pager);
    }
}
