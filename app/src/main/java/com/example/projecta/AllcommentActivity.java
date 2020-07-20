package com.example.projecta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AllcommentActivity extends AppCompatActivity {
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcomment);

        listview = (ListView)findViewById(R.id.listView);

        //ListView 추가
        ListView listView = (ListView)findViewById(R.id.listView);
        CommentAdapter adapter = new CommentAdapter();
        adapter.addItem(new CommentItem("kim101**", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kim201**", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kym71**", "웃긴 내용보다는 좀 더 진지한 영화"));
        adapter.addItem(new CommentItem("beaut**", "연기가 부족한 느낌이 드는 배우도 있다. 그래도 전체적으로는 재밌다."));
        adapter.addItem(new CommentItem("dong1**", "하정우 빡빡이, 강동원 존잘"));
        adapter.addItem(new CommentItem("ha**", "dong1님 말이 쫌 심하시네요."));

        listView.setAdapter(adapter);
    }//end onCreate()

    class CommentAdapter extends BaseAdapter {
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();

        //사용자 정의 메소드
        public void addItem(CommentItem item){
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CommentItemView view = new CommentItemView(getApplicationContext());

            CommentItem item = items.get(position);
            view.setUserId(item.getUserId());
            view.setUserComment(item.getComment());

            return view;
        }
    }//end CommentAdapter class
}