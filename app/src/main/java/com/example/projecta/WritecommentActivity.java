package com.example.projecta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class WritecommentActivity extends AppCompatActivity {
    Button saveComment, cancel;
    RatingBar ratingStar;
    EditText comment;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writecomment);

        saveComment = (Button)findViewById(R.id.saveComment);
        cancel = (Button)findViewById(R.id.cancel);
        ratingStar = (RatingBar)findViewById(R.id.ratingStar);
        comment = (EditText)findViewById(R.id.comment);

        saveComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //저장하는 기능 추가

                Intent intent = new Intent();
                intent.putExtra("message","작성하기 화면에서 돌아왔습니다.");
                intent.putExtra("저장여부","true");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("message","작성하기 화면에서 돌아왔습니다.");
                intent.putExtra("저장여부","false");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}