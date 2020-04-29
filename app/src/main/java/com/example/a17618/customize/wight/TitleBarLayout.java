package com.example.a17618.customize.wight;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.a17618.customize.R;

public class TitleBarLayout extends RelativeLayout {
    TextView leftText, centerText, rightText;

    //    ImageView leftImageView, centerImageView, rightImageView;
    int leftTextColor, centerTextColor, rightTextColor;
    private Drawable leftImage, centerImage, rightImage;
    private float leftTextSize, centerTextSize, rightTextSize;
    private String leftTextContent, centerTextContent, rightTextContent;
    private Drawable leftBackground, centerBackground, rightBackground;
    private TitleBarClickListener listener;

    LayoutParams leftParams, centerParams, rightParams;

    public interface TitleBarClickListener {
        void leftTextClick();

        void leftImageClick();


        void rightImageClick();

        void rightTextClick();

        void centerTextClick();

        void centerImageClick();
    }

    public void setOnTopbarClickListener(TitleBarClickListener listener) {
        this.listener = listener;
    }


    public TitleBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray  ta = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        leftTextColor = ta.getColor(R.styleable.TitleBar_titleLeftTextColor, 0);
        centerTextColor = ta.getColor(R.styleable.TitleBar_titleCenterTextColor, 0);
        rightTextColor = ta.getColor(R.styleable.TitleBar_titleRightTextColor, 0);
        leftTextSize = ta.getDimension(R.styleable.TitleBar_titleLeftTextSize, 0);
        centerTextSize = ta.getDimension(R.styleable.TitleBar_titleCenterTextSize, 0);
        rightTextSize = ta.getDimension(R.styleable.TitleBar_titleRightTextSize, 0);
        leftTextContent = ta.getString(R.styleable.TitleBar_titleLeftText);
        centerTextContent = ta.getString(R.styleable.TitleBar_titleCenterText);
        rightTextContent = ta.getString(R.styleable.TitleBar_titleRightText);
        leftImage = ta.getDrawable(R.styleable.TitleBar_titleLeftImage);
        centerImage = ta.getDrawable(R.styleable.TitleBar_titleCenterImage);
        rightImage = ta.getDrawable(R.styleable.TitleBar_titleRightImage);
        leftBackground = ta.getDrawable(R.styleable.TitleBar_titleLeftBackground);
        centerBackground = ta.getDrawable(R.styleable.TitleBar_titleCenterBackground);
        rightBackground = ta.getDrawable(R.styleable.TitleBar_titleRightBackground);
        ta.recycle();
        leftText = new TextView(context);
        centerText = new TextView(context);
        rightText = new TextView(context);
//        leftImageView = new ImageView(context);
//        centerImageView = new ImageView(context);
//        rightImageView = new ImageView(context);

        leftText.setText(leftTextContent);
        centerText.setText(centerTextContent);
        rightText.setText(rightTextContent);

        leftText.setTextSize(leftTextSize);
        centerText.setTextSize(centerTextSize);
        rightText.setTextSize(rightTextSize);

        leftText.setTextColor(leftTextColor);
        centerText.setTextColor(centerTextColor);
        rightText.setTextColor(rightTextColor);

//        leftText.setBackground(leftBackground);
//        centerText.setBackground(centerBackground);
//        rightText.setBackground(rightBackground);
//        leftImageView.setImageDrawable(leftImage);
//        centerImageView.setImageDrawable(centerImage);
//        rightImageView.setImageDrawable(rightImage);

        leftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_START, TRUE);

        addView(leftText, leftParams);
//        addView(leftImageView, leftParams);

        centerParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        centerParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);

        addView(centerText, centerParams);
//        addView(centerImageView, centerParams);

        rightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_END, TRUE);

        addView(rightText, rightParams);
//        addView(rightImageView, rightParams);


//        leftImageView.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (listener != null)
//                    listener.leftImageClick();
//            }
//        });
        leftText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.leftTextClick();
            }
        });
//        centerImageView.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (listener!=null){
//                    listener.centerImageClick();
//                }
//            }
//        });
        centerText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.centerTextClick();
                }
            }
        });
//
//        rightImageView.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (listener!=null)
//                    listener.rightImageClick();
//            }
//        });
        rightText.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.rightTextClick();
            }
        });


    }




}
