SliderIndicator
=========

## Easy and light weight native like indicator library and can easily integrate with with ViewPager.

**in the app, build.gradle file add the following**

 `implementation 'com.yuvi.widget:sliderindicator:1.0.2'`

**Maven**

    <dependency>
      <groupId>com.yuvi.widget</groupId>
      <artifactId>sliderindicator</artifactId>
      <version>1.0.2</version>
      <type>pom</type>
    </dependency>

**Adding in the Layout**

    <?xml version="1.0" encoding="utf-8"?>
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="8dp"
        android:orientation="vertical">
    
        <android.support.v4.view.ViewPager
            android:id="@+id/pager"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"
            app:layout_constraintHorizontal_weight="1"/>
    
        <com.yuvi.widget.SliderIndicator
            android:id="@+id/sliderIndicator1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:orientation="horizontal"
            app:select="#FF0000"
            app:type="CIRCLE"
            app:unselect="#FFEB3B" />
    
        <com.yuvi.widget.SliderIndicator
            android:id="@+id/sliderIndicator2"
            android:layout_width="wrap_content"
            android:layout_marginTop="4dp"
            android:layout_height="wrap_content"
            android:layout_gravity="center_horizontal"
            android:orientation="horizontal"
            app:select="#FF0000"
            app:type="RECTANGLE"
            app:unselect="#FFEB3B" />
    
    </LinearLayout>

**In Java Activity** 
 

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

**OutPut**
![Round Indicator](https://github.com/yuviii/SliderIndicator/blob/master/device-2018-05-25-082444.png?raw=true)

![enter image description here](https://github.com/yuviii/SliderIndicator/blob/master/device-2018-05-25-082548.png?raw=true)
For more detail please clone the sample project 

    git clone https://github.com/yuviii/SliderIndicator.git


Happy coding. Any contribution is heartly welcomed and for any queries
[Yubaraj Poudel @Author](yubarajpoudel708@gmail.com)

