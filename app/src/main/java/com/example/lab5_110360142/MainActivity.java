package com.example.lab5_110360142;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);     //初始化Activity
        setContentView(R.layout.activity_main); //連接main.xml畫面

        Button btn = findViewById(R.id.button); //連接Button元件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //Button點擊事件

                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this); //建立AlertDialog
                dialog.setTitle("請選擇功能");
                dialog.setMessage("請根據下方按鈕選擇要顯示的物件");

                dialog.setNeutralButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "dialog關閉", Toast.LENGTH_SHORT).show(); //使用makeText顯示訊息
                    }
                });

                dialog.setNegativeButton("自定義Toast", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast(); //執行副程式來顯示客製化Toast
                    }
                });

                dialog.setPositiveButton("顯示list", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showListDialog(); //執行副程式來顯示含列表的對話框
                    }
                });

                dialog.show();
            }
        });
    }

    private void showToast(){
        Toast toast = new Toast(MainActivity.this);  //Step1:初始化
        toast.setGravity(Gravity.TOP, 0, 50);               //Step2:Toast在畫面中顯示位置
        toast.setDuration(Toast.LENGTH_SHORT);              //Step3:Toast在畫面中顯示的持續時間
        LayoutInflater inflater = getLayoutInflater();      //Step4:取得自定義的時間
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.custom_toast_root));
        toast.setView(layout); //Step5:放入自定義的畫面(custom_toast.xml)
        toast.show();          //Step6:顯示畫面
    }

    private void showListDialog(){
        final String[] list = {"message1","message2","message3","message4","message5"}; //建立要顯示在列表世上的字串
        AlertDialog.Builder dialog_list = new AlertDialog.Builder(MainActivity.this);
        dialog_list.setTitle("使用LIST呈現");
        //建立AlertDialog物件
        dialog_list.setItems(list, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "你選的是" + list[i], Toast.LENGTH_SHORT).show(); //依照被點擊的項目用Toast顯示字串
            }
        });
        dialog_list.show();
    }

}