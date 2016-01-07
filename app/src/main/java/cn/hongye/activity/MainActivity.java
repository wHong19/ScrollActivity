package cn.hongye.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.TextView;

import cn.hongye.view.RefreshListView;

public class MainActivity extends ListActivity {
    private RefreshListView listView;
    String[] data={"张三","李四","王五","赵六","王旗","发放","发过","软卧","法尔"
            ,"张三","李四","王五","赵六","王旗","发放","发过","软卧","法尔"
            ,"张三","李四","王五","赵六","王旗","发放","发过","软卧","法尔"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (RefreshListView) getListView();
        listView.setAdapter(new ListAdapter());
    }

    class ListAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if (null==convertView){
                textView=new TextView(MainActivity.this);
                textView.setPadding(40,60,0,60);
                convertView=textView;
            }else {
                textView= (TextView) convertView;
            }
            textView.setText(data[position]);
            return convertView;
        }
    }

}
