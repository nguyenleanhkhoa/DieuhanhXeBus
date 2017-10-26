package com.example.admin.dieuhanhxebus;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import DatabaseAdapter.DatabaseAdapter;

public class Vietthongbao extends AppCompatActivity {
    Calendar calendar= Calendar.getInstance();
    SimpleDateFormat spddate=new SimpleDateFormat("dd/MM/yyyy");
    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;
    EditText edtngay,edtnhapthongbao,edtidthongbao;
    ImageButton btncalendar;
    Button btnPost,btnHuy;
    String id="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vietthongbao);
        Addcontrol();
        AddEvent();
        edtnhapthongbao.requestFocus();
        int idTB=GetMaxidthongbao();
        idTB++;
        edtidthongbao.setText(String.valueOf(idTB));
        Toast.makeText(this, ""+getIntent().getStringExtra("idAdmin"), Toast.LENGTH_SHORT).show();
        id=""+getIntent().getStringExtra("idAdmin");
    }
    public int GetMaxidthongbao(){
        int mx=-1;
        try{
            database=DatabaseAdapter.initDatabase(Vietthongbao.this,DATABASE_NAME);
            Cursor cursor=database.rawQuery("SELECT max(notification_id) from Notification  ",new String [] {});
            if (cursor != null)
                if(cursor.moveToFirst())
                {
                    mx= cursor.getInt(0);
                }
            //  cursor.close();
            return mx;
        }
        catch(Exception e){

            return -1;
        }
    }
    private void AddEvent() {
        btncalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker();
            }
        });
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database=DatabaseAdapter.initDatabase(Vietthongbao.this,DATABASE_NAME);
                AlertDialog.Builder thogbao=new AlertDialog.Builder(Vietthongbao.this);
                thogbao.setTitle("Thông báo");
                thogbao.setMessage("Bạn có muốn đăng thông báo");
                thogbao.setPositiveButton("có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String idthongbao= edtidthongbao.getText().toString();
                        String noidungthongbao=edtnhapthongbao.getText().toString();
                        String datethongbao=edtngay.getText().toString();

                        ContentValues content=new ContentValues();
                        content.put("notification_Id",idthongbao);
                        content.put("notification_Date",datethongbao);
                        content.put("notification",noidungthongbao);
                        content.put("admin_Id",id);
                        database.insert("Notification",null,content);


                    }
                });
                thogbao.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                thogbao.create().show();
            }

        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Addcontrol() {
        edtidthongbao= (EditText) findViewById(R.id.idthongbao);
        btncalendar= (ImageButton) findViewById(R.id.btncalendar);
        edtngay= (EditText) findViewById(R.id.edtngay);
        edtnhapthongbao= (EditText) findViewById(R.id.edtnhap);
        btnPost= (Button) findViewById(R.id.btnDangthongbao);
        btnHuy= (Button) findViewById(R.id.btnHuy);
    }

    private void datePicker() {
        DatePickerDialog.OnDateSetListener callback=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DATE,dayOfMonth);
                edtngay.setText(spddate.format(calendar.getTime()));


            }
        };
        DatePickerDialog datePickerDialog=new DatePickerDialog(
                Vietthongbao.this,
                callback,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE));
        datePickerDialog.show();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
