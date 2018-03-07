package com.example.asus.finaldesginer;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

 private List<String> msgList=new ArrayList<>();

 private EditText inputText;

 private Button send;

 private RecyclerView msgRecyclerView;

 private MsgAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        initComments();
        inputText=(EditText)findViewById(R.id.input_text);
        send=(Button)findViewById(R.id.send);
        msgRecyclerView=(RecyclerView)findViewById(R.id.msg_recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(layoutManager);
        adapter=new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=inputText.getText().toString();
                if (!"".equals(content)){
                    String msg=content;
//                    SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE)
//                            .edit();
//                    editor.putString("comment",msg);

                    msgList.add(msg);
                    adapter.notifyItemInserted(0);//有新评论时，刷新显示
                    msgRecyclerView.scrollToPosition(0);
                    inputText.setText("");//清空输入框中的内容
                }
            }
        });
    }

//    public List<String>  load() {
//            FileInputStream in=null;
//            BufferedReader reader=null;
//            StringBuilder content=new StringBuilder();
//            List<String> msgList2=new ArrayList<>();
//            try{
//                in=openFileInput("data");
//                reader=new BufferedReader(new InputStreamReader(in));
//                String line ="";
//                while ((line=reader.readLine())!=null){
//                    content.append(line);
//                }
//            }  catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//                if (reader!=null){
//                    try {
//                        reader.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            msgList2.add(content.toString());
//
//        return msgList2 ;
//    }

    private void initComments() {
        String msg1="Wish for good luck!";
        msgList.add(msg1);
        String msg2="Try your best!";
        msgList.add(msg2);
        String msg3="Come on!";
        msgList.add(msg3);
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        List<String> msgList1=msgList;
//        save(msgList1);
//
//
//    }
//
//    public void save(List<String> inputText) {
//        FileOutputStream out=null;
//        BufferedWriter writer=null;
//        try {
//            out=openFileOutput("data", Context.MODE_PRIVATE);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (writer!=null){
//                    writer.close();
//            }
//        } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
}
