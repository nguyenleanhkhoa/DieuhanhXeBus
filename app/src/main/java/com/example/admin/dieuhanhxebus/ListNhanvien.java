package com.example.admin.dieuhanhxebus;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.AdapterEmployer;
import DatabaseAdapter.DatabaseAdapter;
import Model.Employer;

public class ListNhanvien extends AppCompatActivity {
    ArrayList<Employer> listnhanvien;
    AdapterEmployer adapterEmployer;

    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;

    AutoCompleteTextView autoSearchText;
    ListView listNV;

    ArrayList<String> tennv;
    ArrayAdapter<String>adapterauto;
    Button btnSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nhanvien);
        Addcontrol();
        AddEvent();
        GetNhanVien();
        listNV.setAdapter(adapterEmployer);
        autoSearchText.setAdapter(adapterauto);
    }



    public int GetMaxidthongbao(){
        int mx=-1;
        try{
            database=DatabaseAdapter.initDatabase(ListNhanvien.this,DATABASE_NAME);
            Cursor cursor=database.rawQuery("SELECT max(employer_Id) from Employer",new String [] {});
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

        tennv=new ArrayList<>();
        adapterauto=new ArrayAdapter<String>(ListNhanvien.this,android.R.layout.simple_list_item_1,tennv);
        listnhanvien=new ArrayList<>();
        adapterEmployer=new AdapterEmployer(ListNhanvien.this,R.layout.item_nhanvien,listnhanvien);
        GetDataNhanvienContext();


      btnSearch.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
             if(!TextUtils.isEmpty(autoSearchText.getText().toString())){
                 adapterEmployer.clear();
                 GetDataNhanvienContextPosition(autoSearchText.getText().toString());
             }
             else{
                 adapterEmployer.clear();
                 GetDataNhanvienContext();
             }
          }
      });


        listNV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Employer nv=listnhanvien.get(position);
                final int manv=nv.getEml_Id();
                final String tennhanvien=nv.getEml_Name();
                final int nhanvienid=nv.getEml_Id();
                final int chucvuNv=nv.getDepartment_Id();

                final Dialog diaDel=new Dialog(ListNhanvien.this);
                diaDel.setContentView(R.layout.dialogxoa);
                diaDel.show();
                Button btnxoa=diaDel.findViewById(R.id.btnXoa);
                Button btnxemlich=diaDel.findViewById(R.id.btnXemlich);

                btnxoa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final AlertDialog.Builder thongbaoXoa=new AlertDialog.Builder(ListNhanvien.this);
                        thongbaoXoa.setTitle("Th?ng báo");
                        thongbaoXoa.setMessage("B?n có mu?n xóa nhân viên này ?");
                        thongbaoXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                database.delete("Employer","employer_Id=?",new String[]{String.valueOf(manv)});
                                adapterEmployer.clear();
                                GetDataNhanvienContext();
                                dialog.dismiss();
                            }
                        });
                        thongbaoXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        thongbaoXoa.create().show();
                    }
                });

                btnxemlich.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentlich=new Intent(ListNhanvien.this,Lichlamnhanvien.class);
                        intentlich.putExtra("tennhanv",tennhanvien);
                        intentlich.putExtra("nhanvienid",nhanvienid);
                        intentlich.putExtra("chucvuNV",chucvuNv);
                        startActivity(intentlich);
                        diaDel.dismiss();
                    }
                });



                return false;
            }
        });
    }

    private void GetDataNhanvienContext() {
        database=DatabaseAdapter.initDatabase(ListNhanvien.this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM Employer",null);
        while(cursor.moveToNext()){
            int maNV=cursor.getInt(0);
            String passNV=cursor.getString(1);
            String tenNV=cursor.getString(2);
            String BirthNV=cursor.getString(3);
            String sdtNv=cursor.getString(4);
            String emailNv=cursor.getString(5);
            String diachiNv=cursor.getString(6);
            int ChucVuNV=cursor.getInt(7);
            int adminNV=cursor.getInt(8);
            Employer employer=new Employer(maNV,tenNV,passNV,BirthNV,sdtNv,emailNv,diachiNv,ChucVuNV,adminNV);
            listnhanvien.add(employer);
        }
        adapterEmployer.notifyDataSetChanged();
    }
    private void GetDataNhanvienContextPosition(String name) {
        database=DatabaseAdapter.initDatabase(ListNhanvien.this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM Employer Where Employer.employer_Name like '"+name+"'",null);
        while(cursor.moveToNext()){
            int maNV=cursor.getInt(0);
            String passNV=cursor.getString(1);
            String tenNV=cursor.getString(2);
            String BirthNV=cursor.getString(3);
            String sdtNv=cursor.getString(4);
            String emailNv=cursor.getString(5);
            String diachiNv=cursor.getString(6);
            int ChucVuNV=cursor.getInt(7);
            int adminNV=cursor.getInt(8);
            Employer employer=new Employer(maNV,tenNV,passNV,BirthNV,sdtNv,emailNv,diachiNv,ChucVuNV,adminNV);
            listnhanvien.add(employer);
        }
        adapterEmployer.notifyDataSetChanged();
    }

    private void Addcontrol() {
        btnSearch= (Button) findViewById(R.id.btntim);
        autoSearchText= (AutoCompleteTextView) findViewById(R.id.autoSearch);
        listNV= (ListView) findViewById(R.id.listNhanvien);
    }
    public void GetNhanVien(){
        database=DatabaseAdapter.initDatabase(ListNhanvien.this,DATABASE_NAME);
        Cursor cursornv=database.rawQuery("SELECT employer_Name FROM Employer ",null);
        while(cursornv.moveToNext()){
            String ten=cursornv.getString(cursornv.getColumnIndex("employer_Name"));
            tennv.add(ten);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        adapterEmployer.clear();
        GetDataNhanvienContext();
        listNV.setAdapter(adapterEmployer);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
        GetDataNhanvienContext();
        listNV.setAdapter(adapterEmployer);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
