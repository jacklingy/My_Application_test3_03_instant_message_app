package edu.ncu.myapplication_test3_03_instant_message_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    private RecyclerView recyclerView;
    private List<Message> messageList = new ArrayList<>();
    private MessageAdapter adapter;
    private LinearLayoutManager layoutManager;
    private Button btn_send;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
       // initMessage();
        //add menu
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(adapter);
        btn_send = (Button) findViewById(R.id.btn_send);
        editText = (EditText) findViewById(R.id.edit);









        //非空判断

//            LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)editText.getLayoutParams();
//            LinearLayout.LayoutParams layoutParams2=(LinearLayout.LayoutParams)btn_send.getLayoutParams();
//
//
//            layoutParams.weight=1;
//            layoutParams2.weight=0;
//            editText.setLayoutParams(layoutParams);
//            btn_send.setLayoutParams(layoutParams2);
//
//

      //  }
//        else {
//            //显示btn
//            LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)editText.getLayoutParams();
//            LinearLayout.LayoutParams layoutParams2=(LinearLayout.LayoutParams)btn_send.getLayoutParams();
//
//
//            layoutParams.weight=7;
//            layoutParams2.weight=3;
//            editText.setLayoutParams(layoutParams);
//            btn_send.setLayoutParams(layoutParams2);
//            Toast.makeText(getApplicationContext(), "不空", Toast.LENGTH_SHORT).show();
//            btn_send.setVisibility(View.VISIBLE);
//
//        }
        btn_send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                String present_message = editText.getText().toString();
               // Log.d("1:",present_message);
                if (present_message.length()!=0) {
                    Message presentMessage = new Message(present_message, R.drawable.avatar);
                  //  Toast.makeText(getApplicationContext(), presentMessage.getContent(), Toast.LENGTH_SHORT).show();
                    sendMessage(presentMessage);
                    //清空内容
                    editText.setText("");
                }
                else{
                  //  Toast.makeText(getApplicationContext(), "空！", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }
//        else{
//            //隐藏发送按钮
//            btn_send.setVisibility(View.INVISIBLE);
//           // layoutParams.weight=1;
//
//        }

    // }

    public void init() {
        this.setSupportActionBar(toolbar);
        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        toolbar.inflateMenu(R.menu.menu);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer_layout);


        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
//
//
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        mActionBarDrawerToggle.setHomeAsUpIndicator(R.drawable.list);
        mActionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        mActionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mActionBarDrawerToggle);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_home:
                        //  Toast.makeText(MainActivity.this , "Home" , Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_gallery:
                        //  Toast.makeText(MainActivity.this , "logout" , Toast.LENGTH_LONG).show();
                        //   drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_send:
                        // Toast.makeText(MainActivity.this , "notification" , Toast.LENGTH_LONG).show();
                        //  drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_share:
                        //   Toast.makeText(MainActivity.this , "setting" , Toast.LENGTH_LONG).show();
                        //  drawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }

    public void initMessage() {

        Message m1 = new Message("你好", R.drawable.avatar);
        messageList.add(m1);
        Message m2 = new Message("你好2", R.drawable.avatar);
        messageList.add(m2);

    }

    public void sendMessage(Message message) {

        //发送方头像是确定的
        adapter.addData(messageList.size(), message);
        //跳转到最最后一条消息
        adapter.moveToPresent(recyclerView);


    }

    public void about(MenuItem item) {
        Intent intent=new Intent(this,Main2Activity_about.class);
        startActivity(intent);

    }

    public void exit(MenuItem item) {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:

                Toast.makeText(getApplicationContext(), "已随机添加一部电影!\n", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:

                    Toast.makeText(getApplicationContext(), "不能再删了！", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
