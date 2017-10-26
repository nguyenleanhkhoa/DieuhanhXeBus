package com.example.admin.dieuhanhxebus;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import Adapter.AdapterNotification;
import DatabaseAdapter.DatabaseAdapter;
import Model.Notify;

public class Notification extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;


    ListView listView;
    ArrayList<Notify> listnotificaition;
    AdapterNotification adapternoti;
    TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        AddControl();
        AddEvent();
        getDatabaseNotification();
        listView.setAdapter(adapternoti);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog chucnang=new Dialog(Notification.this);
                chucnang.setContentView(R.layout.dialogthem);
                chucnang.show();
                Button btnthemthongbao=chucnang.findViewById(R.id.btnthemthongbao);
                Button btnthemnhanvien=chucnang.findViewById(R.id.btnthemnhanvien);
                Button btnthemxeBus=chucnang.findViewById(R.id.btnthemxeBus);
                btnthemthongbao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentthongbao=new Intent(Notification.this,Vietthongbao.class);
                        intentthongbao.putExtra("idAdmin",getIntent().getStringExtra("adminId"));
                        startActivity(intentthongbao);
                        chucnang.dismiss();
                    }
                });
                btnthemnhanvien.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intentnhanvien=new Intent(Notification.this,ThemNhanvien.class);
                        intentnhanvien.putExtra("idAdmin",getIntent().getStringExtra("adminId"));
                        startActivity(intentnhanvien);
                        chucnang.dismiss();
                    }
                });
                btnthemxeBus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });




            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        

    }
    public int GetMaxidthongbao(){
        int mx=-1;
        try{
            database=DatabaseAdapter.initDatabase(Notification.this,DATABASE_NAME);
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
    private void AddControl() {

        listView= (ListView) findViewById(R.id.listBus);
    }

    private void AddEvent() {
        listnotificaition=new ArrayList<>();
        adapternoti=new AdapterNotification(Notification.this,R.layout.item_notification,listnotificaition);
    }
    public void getDatabaseNotification(){
        database= DatabaseAdapter.initDatabase(Notification.this,DATABASE_NAME);
        Cursor cursor=database.rawQuery("SELECT * FROM Notification ",null);
        while (cursor.moveToNext()){
            int sothongbao=cursor.getInt(0);
            String datethongbao=cursor.getString(1);
            String noidungthongbao=cursor.getString(2);
            int admin_id=cursor.getInt(3);
            Notify thongbao=new Notify(sothongbao,datethongbao,noidungthongbao,admin_id);
            listnotificaition.add(thongbao);
            adapternoti.notifyDataSetChanged();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notification, menu);
        return true;
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


         if (id == R.id.nav_myProfile) {
            Intent intentProF=new Intent(Notification.this,Thongtincanhan.class);
            intentProF.putExtra("EmailPro",getIntent().getStringExtra("EmailLogin"));
            intentProF.putExtra("adminPassW",getIntent().getStringExtra("adminPass"));
            startActivity(intentProF);

        } else if (id == R.id.nav_Logout) {
             finish();

        }else if(id == R.id.nav_dsnhanvien){
            Intent intentnhanvien =new Intent(Notification.this,ListNhanvien.class);
            startActivity(intentnhanvien);

        } else if(id == R.id.nav_dsXeBus){
            Intent intentdsBus=new Intent(Notification.this,Bus_List.class);
            startActivity(intentdsBus);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        adapternoti.clear();
        getDatabaseNotification();
        listView.setAdapter(adapternoti);

    }

    @Override
    protected void onResume() {
        super.onResume();

        adapternoti.clear();
        getDatabaseNotification();
        listView.setAdapter(adapternoti);
    }
}
