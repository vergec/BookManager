package com.example.verge.bookmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TitleActivity extends AppCompatActivity implements View.OnClickListener{

    //private RelativeLayout mLayoutTitleBar;
    private TextView mTitleTextView;
    private Button mForwardButton;
    private ImageView mBack;
    //private FrameLayout mContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViews();   //加载 activity_title 布局 ，并获取标题及两侧按钮
    }

    private void setupViews() {
        super.setContentView(R.layout.activity_title);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.hide();
        }
        mTitleTextView = findViewById(R.id.text_title);
        mBack=findViewById(R.id.backward);
        mForwardButton = findViewById(R.id.button_forward);
    }

    /**
     * 是否显示返回按钮
     *
     * @param show          true则显示
     */
    protected void showBackwardView(boolean show) {
        if (mBack != null) {
            if (show) {
                mBack.setVisibility(View.VISIBLE);
            } else {
                mBack.setVisibility(View.INVISIBLE);
            }
        } // else ignored
    }

    /**
     * 提供是否显示提交按钮
     *
     * @param forwardResId 文字
     * @param show         true则显示
     */
    protected void showForwardView(int forwardResId, boolean show) {
        if (mForwardButton != null) {
            if (show) {
                mForwardButton.setVisibility(View.VISIBLE);
                mForwardButton.setText(forwardResId);
            } else {
                mForwardButton.setVisibility(View.INVISIBLE);
            }
        } // else ignored
    }

    /**
     * 返回按钮点击后触发
     * @param backwardView
     */
    protected void onBackward(View backwardView) {
        Toast.makeText(this, "点击返回，可在此处调用finish()", Toast.LENGTH_SHORT).show();
        //finish();
    }

    /**
     * 提交按钮点击后触发
     *
     * @param forwardView
     */
    protected void onForward(View forwardView) {
        Toast.makeText(this, "我是提交按钮", Toast.LENGTH_SHORT).show();
    }

    //设置标题内容
    @Override
    public void setTitle(int titleId) {
        mTitleTextView.setText(titleId);
    }

    //设置标题内容
    @Override
    public void setTitle(CharSequence title) {
        mTitleTextView.setText(title);
    }

    //设置标题文字颜色
    @Override
    public void setTitleColor(int textColor) {
        mTitleTextView.setTextColor(textColor);
    }

    //取出FrameLayout并调用父类removeAllViews()方法
//    @Override
//    public void setContentView(int layoutResID) {
//        mContentLayout.removeAllViews();
//        View.inflate(this, layoutResID, mContentLayout);
//        onContentChanged();
//    }

//    @Override
//    public void setContentView(View view) {
//        mContentLayout.removeAllViews();
//        mContentLayout.addView(view);
//        onContentChanged();
//    }

    /* (non-Javadoc)
     * @see android.app.Activity#setContentView(android.view.View, android.view.ViewGroup.LayoutParams)
     */
//    @Override
//    public void setContentView(View view, ViewGroup.LayoutParams params) {
//        mContentLayout.removeAllViews();
//        mContentLayout.addView(view, params);
//        onContentChanged();
//    }

    /* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     * 按钮点击调用的方法
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.backward:
                onBackward(v);
                break;

            case R.id.button_forward:
                onForward(v);
                break;

            default:
                break;
        }
    }
}
