package com.yuvi.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * Created by yubaraj on 12/21/17.
 */

/**
 * Slider indicator is generic view used during the design of the indicator in the sliderview
 */

public class SliderIndicator extends LinearLayout {

    int selectColor, unselectColor;
    int type_shape = 0;

    public SliderIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attributeSet) {
        // get the value from the attributes
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.sliderIndicator, 0, 0);
        // color when the item is selected
        // should be set in the layout design

        selectColor = typedArray.getColor(R.styleable.sliderIndicator_select, Color.BLACK);

        // color when the indicator is unselected
        unselectColor = typedArray.getColor(R.styleable.sliderIndicator_unselect, Color.GRAY);
        // define what type of the indicator should be used either circular or the rectangular
        type_shape = typedArray.getInt(R.styleable.sliderIndicator_type, 0);
        // show how many indicators is needed

        typedArray.recycle();
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setOrientation(HORIZONTAL);
        this.setLayoutParams(layoutParams);
    }

    public void addWithSlider(final ViewPager sliderView) {
        final int totatCount = sliderView.getAdapter().getCount();
        Utils.log(this.getClass(), "totalCount = " + totatCount);

        for (int i = 0; i < totatCount; i++) {
            View indicatorView = new View(getContext());
            LayoutParams layoutParams = new LayoutParams(Utils.pxFromDp(getContext(), 8), Utils.pxFromDp(getContext(), 8));
            layoutParams.leftMargin = Utils.pxFromDp(getContext(), 4);
            indicatorView.setLayoutParams(layoutParams);
            indicatorView.setTag(i + "");
            this.addView(indicatorView);
        }

        sliderView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                managePageIndicator(position, totatCount);
                CharSequence title = sliderView.getAdapter().getPageTitle(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        managePageIndicator(0, totatCount);
    }

    private void managePageIndicator(int position, int totalCount) {
        int backgroundColor;
        for (int i = 0; i < totalCount; i++) {
            if (i == position) {
                backgroundColor = selectColor;
            } else {
                backgroundColor = unselectColor;
            }
            GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{backgroundColor, backgroundColor});
            if (type_shape == 1) {
                drawable.setShape(GradientDrawable.RECTANGLE);
            } else {
                drawable.setShape(GradientDrawable.OVAL);
            }
//            drawable.setStroke(strokeSize, strokeColor);
            this.findViewWithTag(i + "").setBackgroundDrawable(drawable);
        }
    }

}
