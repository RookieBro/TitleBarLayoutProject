package com.example.a17618.customize.wight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.a17618.customize.R;

public class TitleBarLayout extends RelativeLayout {
    TextView leftText,centerText,rightText;

    ImageView leftImageView,centerImageView,rightImageView;
    int leftTextColor,centerTextColor,rightTextColor;
    private Drawable leftImage,centerImage,rightImage;
    private float leftTextSize,centerTextSize,rightTextSize;
    private String leftTextContent,centerTextContent,rightTextContent;
    private Drawable leftBackground,centerBackground,rightBackground;




    public TitleBarLayout(Context context) {
        super(context);
    }

    public TitleBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        leftTextColor=ta.getColor(R.styleable.TitleBar_titleLeftTextColor,0);
        centerTextColor=ta.getColor(R.styleable.TitleBar_titleCenterTextColor,0);
        rightTextColor=ta.getColor(R.styleable.TitleBar_titleRightTextColor,0);
        leftTextSize=ta.getDimension(R.styleable.TitleBar_titleLeftTextSize,0);
        centerTextSize=ta.getDimension(R.styleable.TitleBar_titleCenterTextSize,0);
        rightTextSize=ta.getDimension(R.styleable.TitleBar_titleRightTextSize,0);
        leftTextContent=ta.getString(R.styleable.TitleBar_titleLeftText);
        centerTextContent=ta.getString(R.styleable.TitleBar_titleCenterText);
        rightTextContent=ta.getString(R.styleable.TitleBar_titleRightText);
        leftImage=ta.getDrawable(R.styleable.TitleBar_titleLeftImage);
        centerImage=ta.getDrawable(R.styleable.TitleBar_titleCenterImage);
        rightImage=ta.getDrawable(R.styleable.TitleBar_titleRightImage);
        leftBackground=ta.getDrawable(R.styleable.TitleBar_titleLeftBackground);
        centerBackground=ta.getDrawable(R.styleable.TitleBar_titleCenterBackground);
        rightBackground=ta.getDrawable(R.styleable.TitleBar_titleRightBackground);
        ta.recycle();
        leftText=new TextView(context);
        centerText=new TextView(context);
        rightText=new TextView(context);
        leftImageView=new ImageView(context);
        centerImageView=new ImageView(context);
        rightImageView=new ImageView(context);

        leftText.setText(leftTextContent);
        centerText.setText(centerTextContent);
        rightText.setText(rightTextContent);

        leftText.setTextSize(leftTextSize);
        centerText.setTextSize(centerTextSize);
        rightText.setTextSize(rightTextSize);

        leftText.setTextColor(leftTextColor);
        centerText.setTextColor(centerTextColor);
        rightText.setTextColor(rightTextColor);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            leftText.setBackground(leftBackground);
            centerText.setBackground(centerBackground);
            rightText.setBackground(rightBackground);
        }
        leftImageView.setImageDrawable(leftImage);


    }

    public TitleBarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
