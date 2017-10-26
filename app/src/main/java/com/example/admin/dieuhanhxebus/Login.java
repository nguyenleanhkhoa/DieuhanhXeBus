package com.example.admin.dieuhanhxebus;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import DatabaseAdapter.DatabaseAdapter;

public class Login extends AppCompatActivity {
    Button btnSignIn;
    EditText edtUserMail, editUserPassword;

    String DATABASE_NAME="BusManager.sqlite";
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            }
        });
    }
    private void initialize(){

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        edtUserMail = (EditText) findViewById(R.id.txtUserEmail);
        editUserPassword = (EditText) findViewById(R.id.txtPassword);
    }
    public int GetAdminId(String email){
        int mx=-1;
        try{
            database=DatabaseAdapter.initDatabase(Login.this,DATABASE_NAME);
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
    public String GetPassword(String email){
        String mx="";
        try{
            database=DatabaseAdapter.initDatabase(Login.this,DATABASE_NAME);
            Cursor cursor=database.rawQuery("select admin_Password\n" +
                    "from Admin\n" +
                    "where Admin.admin_Email like'"+email+"'",new String [] {});
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
    private void SignIn(){

        database=DatabaseAdapter.initDatabase(Login.this,DATABASE_NAME);
        if(edtUserMail.length() == 0 || editUserPassword.length() == 0){
            Toast.makeText(this, "Hãy ?i?n Email ho?c m?t kh?u", Toast.LENGTH_SHORT).show();
        }
        else {
            String email = edtUserMail.getText().toString();
            String password = editUserPassword.getText().toString();

            Cursor cursorAdmin = database.rawQuery("SELECT admin_Email, admin_Password FROM Admin " +
                    "WHERE admin_Email like '" + email+"'" +
                    " AND admin_Password = " + password, null);

            Cursor cursorEmployer = database.rawQuery("SELECT employer_Email, employer_Password FROM Employer " +
                    "WHERE employer_Email like '" + email+"'" +
                    " AND employer_Password = " + password, null);

            while (cursorAdmin.moveToNext()) {

                if (cursorAdmin.getString(cursorAdmin.getColumnIndex("admin_Email")) != null) {

                }
            }

            while (cursorEmployer.moveToNext()) {

                if (cursorEmployer.getString(cursorEmployer.getColumnIndex("employer_Email")) != null) {

                    Intent intent=new Intent(Login.this,Notification.class);
                    intent.putExtra("EmailLogin",edtUserMail.getText().toString());
                    intent.putExtra("adminId",""+GetAdminId(edtUserMail.getText().toString()));
                    intent.putExtra("adminPass",GetPassword(edtUserMail.getText().toString()));
                    startActivity(intent);
                    finish();


                }
            }

        }
    }
}
