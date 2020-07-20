package com.example.projecta;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button likeBtn, unlikeBtn, writeCommentBtn, viewAllCommentBtn;
    TextView likeCountView, unlikeCountView;

    ListView listview;

    int likeCount = 1;
    int unlikeCount = 1;
    boolean likeState = false;
    boolean unlikeState = false;
    final static int WRITECOMMENT_CODE = 101;
    final static int ALLCOMMENT_CODE = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView)findViewById(R.id.listView);

        writeCommentBtn = (Button)findViewById(R.id.writeCommentBtn);
        viewAllCommentBtn = (Button)findViewById(R.id.viewAllCommentBtn);

        likeBtn = (Button)findViewById(R.id.likeBtn);
        unlikeBtn = (Button)findViewById(R.id.unlikeBtn);

        likeCountView = (TextView)findViewById(R.id.likeCountView);
        unlikeCountView =(TextView)findViewById(R.id.unlikeCountView);

        //Comment 관련 버튼 Toast 띄우기
        writeCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "작성하기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), WritecommentActivity.class);

                startActivityForResult(intent, WRITECOMMENT_CODE);
            }
        });

        viewAllCommentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "모두보기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AllcommentActivity.class);

                startActivityForResult(intent, ALLCOMMENT_CODE);
            }
        });

        //좋아요 싫어요 버튼 기능 정의
        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(likeState){
                    decreaseLikeCount();
                    /*if(unlikeState){
                        decreaseUnlikeCount();
                    }*/
                }else{
                    increaseLikeCount();
                    if(unlikeState){
                       decreaseUnlikeCount();
                       unlikeState = !unlikeState;
                    }
                }
                likeState = !likeState;
            }//end onClick()
        });

        unlikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(unlikeState){
                    decreaseUnlikeCount();
                    /*if(likeState){
                        decreaseLikeCount();
                    }*/
                }else{
                    increaseUnlikeCount();
                    if(likeState){
                        decreaseLikeCount();
                        likeState = !likeState;
                    }
                }
                unlikeState = !unlikeState;
            }//end onClick()
        });

        //ListView 추가
        ListView listView = (ListView)findViewById(R.id.listView);
        CommentAdapter adapter = new CommentAdapter();
        adapter.addItem(new CommentItem("kim101**", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("kim201**", "적당히 재밌다. 오랜만에 잠 안오는 영화 봤네요."));

        listView.setAdapter(adapter);
    }//end onCreate()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(requestCode == WRITECOMMENT_CODE){
                Toast.makeText(getApplicationContext(), data.getStringExtra("message") +
                        "\n" + "저장여부 : " + data.getStringExtra("저장여부"), Toast.LENGTH_SHORT).show();
            }
        }
    }

    class CommentAdapter extends BaseAdapter{
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


    public void increaseLikeCount(){
        likeCount += 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeBtn.setBackgroundResource(R.drawable.ic_thumb_up_selected);

    }//end increaseLikeCount()

    public void  decreaseLikeCount(){
        likeCount -= 1;
        likeCountView.setText(String.valueOf(likeCount));
        likeBtn.setBackgroundResource(R.drawable.ic_thumb_up);

    }//end decreaseLikeCount()

    public void increaseUnlikeCount(){
        unlikeCount += 1;
        unlikeCountView.setText(String.valueOf(unlikeCount));
        unlikeBtn.setBackgroundResource(R.drawable.ic_thumb_down_selected);

    }//end increaseUnlikeCount()

    public void decreaseUnlikeCount(){
        unlikeCount -= 1;
        unlikeCountView.setText(String.valueOf(unlikeCount));
        unlikeBtn.setBackgroundResource(R.drawable.ic_thumb_down);

    }//end decreaseUnlikeCount()
}