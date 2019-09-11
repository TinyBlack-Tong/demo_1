package com.example.demo_1;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private Button b2;
    private EditText u_id;
    private EditText u_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个普通的对话框").setTitle("对话框");

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"您按下了确定按钮",Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"您按下了取消按钮",Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"您按下了忽略按钮",Toast.LENGTH_LONG).show();

                    }
                });

                builder.show();

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater=getLayoutInflater();
                View v=inflater.inflate(R.layout.login,null);
                u_id=v.findViewById(R.id.u_id);
                u_pwd=v.findViewById(R.id.u_pwd);
                builder.setView(v)
                .setTitle("登录")
                .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(u_id.getText().toString().equals("abc")&&u_pwd.getText().toString().equals("123")){
                            Log.d("MainActivity",u_id.getText().toString());
                            Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                        }
                       else{
                            Toast.makeText(MainActivity.this,"登录失败哦",Toast.LENGTH_LONG).show();

                        }
                    }
                })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"您选择了取消按钮",Toast.LENGTH_LONG).show();

                            }
                        });
                builder.show();




            }
        });



    }
}
