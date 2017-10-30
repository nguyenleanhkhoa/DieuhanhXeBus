package com.example.admin.dieuhanhxebus;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

import Adapter.AdapterBusList;
import DatabaseAdapter.DatabaseAdapter;
import Model.Bus;
import ModelGroup.RouteBus;

public class Bus_List extends AppCompatActivity {
    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;
    ListView list_Bus;
    ArrayList<RouteBus> Buslist;
    AdapterBusList adapterBusList;

    AutoCompleteTextView autosearchBus;
    Button btntimbus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus__list);
        addControl();
        addEvent();
        GetBusDatabaseContext();



        list_Bus.setAdapter(adapterBusList);

    }

    private void addEvent() {

    }


    private void addControl() {
        autosearchBus= (AutoCompleteTextView) findViewById(R.id.autosearchbus);
        btntimbus= (Button) findViewById(R.id.btntimxeBus);
        list_Bus= (ListView) findViewById(R.id.listBus);
        Buslist=new ArrayList<>();
        adapterBusList=new AdapterBusList(Bus_List.this,R.layout.item_bus,Buslist);
        btntimbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(autosearchBus.getText().toString())){
                    adapterBusList.clear();
                    int maBus=Integer.parseInt(autosearchBus.getText().toString());
                    GetBusDatabaseContext(maBus);
                }else{
                    adapterBusList.clear();
                    GetBusDatabaseContext();
                }
            }
        });

    }
    public void GetBusDatabaseContext(){
        database= DatabaseAdapter.initDatabase(Bus_List.this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT b.Bus_id,b.Bus_number,b.Bus_sign,s.route_Id,s.time,r.route " +
                                        "FROM Bus b ,BusSchedule  s ,Route r " +
                                         "group by b.Bus_id  ",null);
        while (cursor.moveToNext()){
            int maXeBus=cursor.getInt(0);
            int soXeBus=cursor.getInt(1);
            int matuyen=cursor.getInt(2);
            String bienso=cursor.getString(3);
            String thoigian=cursor.getString(4);
            String tuyenduong=cursor.getString(5);
            Toast.makeText(this, ""+tuyenduong, Toast.LENGTH_SHORT).show();

            RouteBus bus=new RouteBus();
            bus.setMaXeBus(maXeBus);
            bus.setSoXeBus(soXeBus);
            bus.setMaTx(matuyen);
            bus.setBiensoxeBus(bienso);
            bus.setGioChay(thoigian);
            bus.setTuyenXe(tuyenduong);
            Buslist.add(bus);

        }
        adapterBusList.notifyDataSetChanged();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.seach_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.searchViewid);
        SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Tìm Xe bus....");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(!TextUtils.isEmpty(newText.toString())){
                    adapterBusList.clear();
                    GetBusDatabaseContext(Integer.parseInt(newText));
                    return true;
                }
                else{
                    adapterBusList.clear();
                    GetBusDatabaseContext();
                    return true;
                }
            }
        });
        return super.onCreateOptionsMenu(menu);
    }



    public void GetBusDatabaseContext(int busid){
        database= DatabaseAdapter.initDatabase(Bus_List.this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT b.Bus_id,b.Bus_number,b.Bus_sign,s.route_Id,s.time,r.route " +
                "FROM Bus b ,BusSchedule  s ,Route r " +
                "Where b.Bus_number ="+busid+"\n"+
                "group by b.Bus_id  ",null);
        while (cursor.moveToNext()){
            int maXeBus=cursor.getInt(0);
            int soXeBus=cursor.getInt(1);
            int matuyen=cursor.getInt(2);
            String bienso=cursor.getString(3);
            String thoigian=cursor.getString(4);
            String tuyenduong=cursor.getString(5);
            Toast.makeText(this, ""+tuyenduong, Toast.LENGTH_SHORT).show();

            RouteBus bus=new RouteBus();
            bus.setMaXeBus(maXeBus);
            bus.setSoXeBus(soXeBus);
            bus.setMaTx(matuyen);
            bus.setBiensoxeBus(bienso);
            bus.setGioChay(thoigian);
            bus.setTuyenXe(tuyenduong);
            Buslist.add(bus);

        }
        adapterBusList.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
