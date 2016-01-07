package cn.hongye.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import cn.hongye.activity.R;

/**
 * author 汪洪
 * date 2016/1/7
 * Created by Ethan on 09.
 */
public class RefreshListView extends ListView implements AbsListView.OnScrollListener,View.OnTouchListener{
    private TextView headerViewTip;
    private ImageView headerViewImg;
    private ProgressBar headerViewProgress;
    private View headerView;//listview刷新的头部
    private int measuredHeight;
    private int scrollState;//滑动状态
    private int firstVisibleItem;//第一个可见状态

    /**         刷新         */
    private int state;
    private final int NORMAL=0;//正常状态(隐藏headerView)
    private final int DOWN=1;//下拉状态
    private final int UP=2;//松开刷新
    private final int PULL=3;//正在刷新

    public RefreshListView(Context context) {
        super(context);
        assignViews(context);
    }

    public RefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        assignViews(context);
    }

    public RefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        assignViews(context);
    }

    private void assignViews(Context context) {
        headerView = LayoutInflater.from(context).inflate(R.layout.layout_refreshlistview_header, null);
        headerViewTip = (TextView) headerView.findViewById(R.id.tip);
        headerViewImg = (ImageView) headerView.findViewById(R.id.img);
        headerViewProgress = (ProgressBar) headerView.findViewById(R.id.progress);
        this.addHeaderView(headerView);
        measuredHeight = headerView.getMeasuredHeight();
        setHeaderViewTip(-measuredHeight);
        RotateAnimation animation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        animation.setInterpolator(new LinearInterpolator());
        animation.setDuration(200);
        animation.setFillAfter(true);

        this.setOnScrollListener(this);
        this.setOnTouchListener(this);
    }

    private void setHeaderViewTip(int height){
        headerView.setPadding(0,height,0,0);
        headerView.invalidate();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        this.scrollState = scrollState;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        this.firstVisibleItem = firstVisibleItem;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
