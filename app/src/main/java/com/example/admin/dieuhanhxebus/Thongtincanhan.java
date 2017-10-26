package com.example.admin.dieuhanhxebus;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.file.attribute.DosFileAttributes;

import DatabaseAdapter.DatabaseAdapter;

public class Thongtincanhan extends AppCompatActivity {
    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;
    EditText edtidpro,edttenpro,edtemailpro,edtdiachipro,edtPhonepro;
    Button btnchinhsua,btnluu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtincanhan);
        AddControl();
        AddEvent();
        String email=getIntent().getStringExtra("EmailPro");
        Toast.makeText(this, ""+email, Toast.LENGTH_SHORT).show();

        showInfor(email);


    }
    public void showInfor(String email){
        database=DatabaseAdapter.initDatabase(Thongtincanhan.this, DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM Admin Where Admin.admin_Email like "+"'"+email+"'",null );
        while(cursor.moveToNext()){
            String idEmp=cursor.getString(0);
            String name=cursor.getString(2);
            String Phone=cursor.getString(4);
            String Email=cursor.getString(5);
            String Address=cursor.getString(3);

            edtidpro.setText(idEmp);
            edttenpro.setText(name);
            edtemailpro.setText(Email);
            edtdiachipro.setText(Address);
            edtPhonepro.setText(Phone);

            EnableInfor(false);
        }
    }


    public void EditTextInfo(){

        btnchinhsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnableInfor(true);


            }
        });

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder thongbao=new AlertDialog.Builder(Thongtincanhan.this);
                thongbao.setTitle("Thông báo");
                thongbao.setMessage("Bạn có muốn cập nhật các thông tin này ?");
                thongbao.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ContentValues content=new ContentValues();
                        content.put("admin_Id",edtidpro.getText().toString());
                        content.put("admin_Password",getIntent().getStringExtra("adminPassW"));
                        content.put("admin_Phone",edtPhonepro.getText().toString());
                        content.put("admin_Address",edtdiachipro.getText().toString());
                        content.put("admin_Name",edttenpro.getText().toString());
                        content.put("admin_Email",edtemailpro.getText().toString());
                        database.update("Admin",content,"admin_Id=?",new String[]{String.valueOf(Integer.parseInt(edtidpro.getText().toString()))});
                        Toast.makeText(Thongtincanhan.this, "Đã cập nhật thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                thongbao.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                thongbao.create().show();
            }
        });


    }
    public void EnableInfor(boolean bool){
        edtidpro.setEnabled(bool);
        edttenpro.setEnabled(bool);
        edtemailpro.setEnabled(bool);
        edtdiachipro.setEnabled(bool);
        edtPhonepro.setEnabled(bool);
    }

    private void AddEvent() {
        EditTextInfo();
    }

    private void AddControl() {
        edtidpro= (EditText) findViewById(R.id.edtEmplID);
        edttenpro= (EditText) findViewById(R.id.edtEmplName);
        edtemailpro= (EditText) findViewById(R.id.edtEmplEmail);
        edtdiachipro= (EditText) findViewById(R.id.edtEmplAddr);
        edtPhonepro= (EditText) findViewById(R.id.edtEmplPhone);
        btnchinhsua= (Button) findViewById(R.id.btnedit);
        btnluu= (Button) findViewById(R.id.btnEmplCancel);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
