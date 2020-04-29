package com.example.a17618.customize.wight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.a17618.customize.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * title bar
 */
public class EaseTitleBar extends LinearLayout {
    /*其他界面的布局*/
    @BindView(R.id.left_image)
    ImageView mLeftImage;
    @BindView(R.id.left_layout)
    RelativeLayout mLeftLayout;

    @BindView(R.id.right_image)
    ImageView mRightImage;
    @BindView(R.id.right_layout)
    RelativeLayout mRightLayout;


    @BindView(R.id.root)
    RelativeLayout mRoot;
    @BindView(R.id.right_text)
    TextView mRightText;
    @BindView(R.id.left_text)
    TextView mLeftText;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.son_title)
    TextView mSonTitle;

    @BindView(R.id.tv_close)
    TextView mTvClose;

    @BindView(R.id.center_layout)
    RelativeLayout mCenterLayout;

    @BindView(R.id.center_image)
    ImageView mCenterImage;



    @BindView(R.id.view_divider)
    View mDividerLine;




    private static final String TAG = "EaseTitleBar";

    public EaseTitleBar(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs);
    }

    public EaseTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EaseTitleBar(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        setOrientation(VERTICAL);
        LayoutInflater.from(context)
                .inflate(R.layout.view_title_bar, this);
        ButterKnife.bind(this);
        parseStyle(context, attrs);

        //设置字体加粗
        TextPaint paint = mTitle.getPaint();
        paint.setFakeBoldText(true);
    }
    private void parseStyle(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.EaseTitleBar);
            int textColor = ta.getColor(R.styleable.EaseTitleBar_titleBarTextColor, context.getResources().getColor(R.color.black));

            setTextStyle(ta, mTitle,
                    R.styleable.EaseTitleBar_titleBarTitle,
                    R.styleable.EaseTitleBar_titleBarTitleTextColor,
                    textColor);
            setTextStyle(ta, mSonTitle,
                    R.styleable.EaseTitleBar_titleBarsonTitle,
                    R.styleable.EaseTitleBar_titleBarsonTitleTextColor,
                    textColor);

            setTextStyle(ta, mTvClose,
                    R.styleable.EaseTitleBar_titleBarCloseTitle,
                    R.styleable.EaseTitleBar_titleBarCloseTitleTextColor,
                    textColor);


            setTextStyle(ta, mLeftText,
                    R.styleable.EaseTitleBar_titleBarLeftText,
                    R.styleable.EaseTitleBar_titleBarLeftTextColor,
                    textColor);

            setTextStyle(ta, mRightText,
                    R.styleable.EaseTitleBar_titleBarRightText,
                    R.styleable.EaseTitleBar_titleBarRightTextColor,
                    textColor);

            setIconStyle(ta, mLeftImage, R.styleable.EaseTitleBar_titleBarLeftImage);
            setIconStyle(ta, mCenterImage, R.styleable.EaseTitleBar_titleBarCenterImage);
            setIconStyle(ta, mRightImage, R.styleable.EaseTitleBar_titleBarRightImage);


            Drawable background = ta.getDrawable(R.styleable.EaseTitleBar_titleBarBackground);
            if (null != background) {
                mRoot.setBackground(background);
            }
            if (!TextUtils.isEmpty(mRightText.getText())) {
                mRightText.setVisibility(VISIBLE);
                mRightImage.setVisibility(GONE);
            }
            if (!TextUtils.isEmpty(mLeftText.getText())) {
                mLeftText.setVisibility(VISIBLE);
            }
            ta.recycle();
        }
    }

    private void setTextString(TextView view, String str) {
        if (TextUtils.isEmpty(str)) {
            view.setVisibility(INVISIBLE);
        } else {
            view.setVisibility(VISIBLE);
        }
        view.setText(str);
    }

    private void setTextStyle(TypedArray ta, TextView view, int textStyleId, int colorStyleId, int defaultColor) {
        if (ta == null) return;
        view.setText(ta.getString(textStyleId));
        view.setTextColor(ta.getColor(colorStyleId, defaultColor));
    }

    private void setIconStyle(TypedArray ta, ImageView view, int styleId) {
        if (ta == null) return;
        Drawable drawable = ta.getDrawable(styleId);
        if (null != drawable) {
            view.setImageDrawable(drawable);
        }
    }

    public View getDividerLine() {
        return mDividerLine;
    }


    public TextView getTitleView() {
        return mTitle;
    }

    public TextView getmLeftText() {
        return mLeftText;
    }

    public TextView getSonTitleView() {
        return mSonTitle;
    }
    public TextView getCloseTitleView() {
        return mTvClose;
    }


    public ImageView getLeftImageView() {
        return mLeftImage;
    }

    public ImageView getmCenterImage() {
        return mCenterImage;
    }

    public ImageView getRightImageView() {
        return mRightImage;
    }

    public View getLeftLayoutView() {
        return mLeftLayout;
    }

    public View getCenterLayoutView() {
        return mCenterLayout;
    }

    public View getRightLayoutView() {
        return mRightLayout;
    }


    public void setLeftImageResource(int resId) {
        mLeftImage.setImageResource(resId);
    }

    public void setCenterImageResource(int resId) {
        mCenterImage.setImageResource(resId);
    }

    public void setRightImageResource(int resId) {
        mRightImage.setImageResource(resId);
    }

    public void setLeftLayoutClickListener(OnClickListener listener) {
        mLeftLayout.setOnClickListener(listener);
    }


    public void setCenterLayoutClickListener(OnClickListener listener) {
        mCenterLayout.setOnClickListener(listener);
    }

    public void setRightLayoutClickListener(OnClickListener listener) {
        mRightLayout.setOnClickListener(listener);
    }

    public void setAllLayoutClickLister(OnClickListener listener) {
        mRoot.setOnClickListener(listener);
    }
    public void setCloseLayoutClickLister(OnClickListener listener) {
        mTvClose.setOnClickListener(listener);
    }


    public void hideToolbar(View view) {
        mRoot.animate()
                .y(-mRoot.getHeight())
                .setInterpolator(new AccelerateInterpolator(2));
        view.animate()
                .y(0)
                .setInterpolator(new AccelerateInterpolator(2));
    }

    public void showToolbar(View view) {
        view.animate()
                .y(mRoot.getHeight())
                .setInterpolator(new AccelerateInterpolator(2));
        mRoot.animate()
                .translationY(0)
                .setInterpolator(new DecelerateInterpolator(2));
    }

    public static void hideToolbar(View title,View content) {
        title.animate()
                .y(-title.getHeight())
                .setInterpolator(new AccelerateInterpolator(2));
        content.animate()
                .y(0)
                .setInterpolator(new AccelerateInterpolator(2));
    }

    public static void showToolbar(View title,View content) {
        title.animate()
                .y(0)
                .setInterpolator(new AccelerateInterpolator(2));
        content.animate()
                .translationY(0)
                .setInterpolator(new DecelerateInterpolator(2));
    }

    /*其他toolbar的设置*/
    public void setLeftLayoutVisibility(int visibility) {
        mLeftLayout.setVisibility(visibility);
    }

    public void setRightLayoutVisibility(int visibility) {
        mRightLayout.setVisibility(visibility);
    }

    public void setRightImageVisibility(int visibility) {
        mRightImage.setVisibility(visibility);
    }

    public void setLeftImageVisibility(int visibility) {
        mLeftImage.setVisibility(visibility);
    }

    public void setCenterImageVisibility(int visibility) {
        mCenterImage.setVisibility(visibility);
    }

    public void setRightTextVisibility(int visibility) {
        mRightText.setVisibility(visibility);
    }

    public void setLeftTextVisibility(int visibility) {
        mLeftText.setVisibility(visibility);
    }

    public void setCloseTextVisibility(int visibility) {
        mTvClose.setVisibility(visibility);
    }

    public void setDividerLineVisibility(int visibility) {
        mDividerLine.setVisibility(visibility);
    }

    public void setRightText(String title) {
        setTextString(mRightText, title);
    }

    public void setLeftText(String title) {
        setTextString(mLeftText, title);
    }

    public void setRightTitleColor(int color) {
        mRightText.setTextColor(color);
    }

    public void setLeftTitleColor(int color) {
        mLeftText.setTextColor(color);
    }

    public void setTitle(String title) {
        setTextString(mTitle, title);
    }

    public void setSonTitle(String title) {
        setTextString(mSonTitle, title);
    }

    public void setCloseTitle(String title) {
        setTextString(mTvClose, title);
    }



    public void setBackgroundColor(int color) {
        mRoot.setBackgroundColor(color);
    }


    public void setTitleColor(int color) {
        mTitle.setTextColor(color);
    }

    public void setSonTitleColor(int color) {
        mSonTitle.setTextColor(color);
    }

    public void setCloseTitleColor(int color) {
        mTvClose.setTextColor(color);
    }



    public TextView getRightTitle() {
        return mRightText;
    }

    public RelativeLayout getLeftLayout() {
        return mLeftLayout;
    }

    public RelativeLayout getRightLayout() {
        return mRightLayout;
    }



}
