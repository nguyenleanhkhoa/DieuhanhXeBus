package com.example.admin.dieuhanhxebus;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.AdapterEmloyerSchedule;
import Adapter.AdapterLichlam;
import DatabaseAdapter.DatabaseAdapter;
import Model.EmployerSchedule;

public class Lichlamnhanvien extends AppCompatActivity {
    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;
    ListView listlichlm;
    ArrayList<EmployerSchedule>listlich;
    AdapterLichlam adapterEmloyerSchedule;

    TextView txttennv,txtchucvunv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lichlamnhanvien);
        Addcontrol();
        AddEvent();
        txttennv.setText("Tên nhân viên :"+getIntent().getStringExtra("tennhanv"));
        txtchucvunv.setText("Ch?c v? : "+GetDepartment(getIntent().getIntExtra("chucvuNV",0)));


        GetlichlamDataContext(getIntent().getIntExtra("nhanvienid",0));
        listlichlm.setAdapter(adapterEmloyerSchedule);



    }

    public String GetDepartment(int depart){
        String mx="";
        try{
            database= DatabaseAdapter.initDatabase(Lichlamnhanvien.this,DATABASE_NAME);
            Cursor cursor=database.rawQuery("SELECT department \n" +
                    "FROM Department\n" +
                    "WHERE department_Id = '"+depart+"'",new String [] {});
            if (cursor != null)
                if(cursor.moveToFirst())
                {
                    mx= cursor.getString(0);
                }
            //  cursor.close();
            return mx;
        }
        catch(Exception e){

            return "null";
        }
    }
    public void GetlichlamDataContext(int employ_Id){
        database=DatabaseAdapter.initDatabase(Lichlamnhanvien.this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT bus_Id,date\n" +
                "FROM EmployeeSchedule ES\n" +
                "WHERE ES.employee_Id ="+employ_Id,null);
        while(cursor.moveToNext()){
            int soxeBus=cursor.getInt(cursor.getColumnIndex("bus_Id"));
            String ngaylam=cursor.getString(cursor.getColumnIndex("date"));
            EmployerSchedule emplSc=new EmployerSchedule(soxeBus,ngaylam);
            listlich.add(emplSc);
        }
        adapterEmloyerSchedule.notifyDataSetChanged();
    }
    private void AddEvent() {
        listlich=new ArrayList<>();
        adapterEmloyerSchedule=new AdapterLichlam(Lichlamnhanvien.this,R.layout.item_lichlam,listlich);

    }

    private void Addcontrol() {
        txttennv= (TextView) findViewById(R.id.lichtenNv);
        txtchucvunv= (TextView) findViewById(R.id.lichchucvu);
        listlichlm= (ListView) findViewById(R.id.listlichlamviec);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
