package com.example.admin.dieuhanhxebus;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import DatabaseAdapter.DatabaseAdapter;

public class ThemNhanvien extends AppCompatActivity {
    EditText edtID,edtusername,edtemail,edtpass,edtbirthday,edtaddress,edtphone;
    Button btnthem,btnthoat;
    String adminid="";
    String departmentId="";
    ArrayAdapter<String> spinAdapter;
    Spinner spinDepart;

    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nhanvien);
        Addcontrol();
        AddEvent();
        adminid=getIntent().getStringExtra("idAdmin");
        Toast.makeText(this, adminid, Toast.LENGTH_SHORT).show();
    }
    public int GetDepartment_Id(String depart){
        int mx=-1;
        try{
            database= DatabaseAdapter.initDatabase(ThemNhanvien.this,DATABASE_NAME);
            Cursor cursor=database.rawQuery("SELECT department_Id \n" +
                    "FROM Department\n" +
                    "WHERE department like '"+depart+"'",new String [] {});
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

        String []depart=new String[]{"Lái xe","Thu vé"};
        spinAdapter =new ArrayAdapter<String>(ThemNhanvien.this,R.layout.support_simple_spinner_dropdown_item,depart);
        spinDepart.setAdapter(spinAdapter);



        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                database=DatabaseAdapter.initDatabase(ThemNhanvien.this,DATABASE_NAME);


                AlertDialog.Builder thongbao=new AlertDialog.Builder(ThemNhanvien.this);
                thongbao.setTitle("Thông báo");
                thongbao.setMessage("B?n mu?n thêm nhân viên");
                thongbao.setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String id=edtID.getText().toString();
                        String name=edtusername.getText().toString();
                        String Depart = spinDepart.getSelectedItem().toString();
                        String Email=edtemail.getText().toString();
                        String password=edtpass.getText().toString();
                        String birtday=edtbirthday.getText().toString();
                        String phone=edtphone.getText().toString();
                        String addree=edtaddress.getText().toString();


                        ContentValues content=new ContentValues();
                        content.put("employer_Id",id);
                        content.put("employer_Password",password);
                        content.put("employer_Name",name);
                        content.put("employer_Birthday",birtday);
                        content.put("employer_Phone",phone);
                        content.put("employer_Email",Email);
                        content.put("employer_Address",addree);
                        content.put("admin_id",adminid);
                        content.put("department_Id",GetDepartment_Id(Depart));
                        database.insert("Employer",null,content);

                    }
                });
                thongbao.setNegativeButton("kHÔNG", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                thongbao.create().show();





            }
        });

    }
    public int GetAdminId(String email){
        int mx=-1;
        try{
            database= DatabaseAdapter.initDatabase(ThemNhanvien.this,DATABASE_NAME);
            Cursor cursor=database.rawQuery("select admin_Id\n" +
                    "from Admin\n" +
                    "where Admin.admin_Email like"+ "'"+email+"'",new String [] {});
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
    private void Addcontrol() {
        edtID= (EditText) findViewById(R.id.edtIdEmpl);
        edtusername= (EditText) findViewById(R.id.edtusernameEmpl);
        edtemail= (EditText) findViewById(R.id.edtemailEmpl);
        edtpass= (EditText) findViewById(R.id.edtpasswordEmpl);

        edtbirthday= (EditText) findViewById(R.id.edtbirthdayEmpl);
        edtaddress= (EditText) findViewById(R.id.edtaddressEmpl);
        edtphone= (EditText) findViewById(R.id.edtphoneEmpl);
        btnthem= (Button) findViewById(R.id.btncreateEmpl);
        btnthoat= (Button) findViewById(R.id.btncancelEmpl);
        spinDepart= (Spinner) findViewById(R.id.spinDepart);

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
