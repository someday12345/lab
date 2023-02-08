package com.example.sqlite;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class Delete extends AppCompatActivity {
    EditText uname;
    Button delete;
    dbhelper dbHelper;
    private static final String dbName="studentdb";
    private static final String tbName="student" ;
    private static final int dbVersion = 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete); uname =
                findViewById(R.id.dname) ; delete = findViewById(R.id.deletebtn);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new dbhelper(Delete.this, dbName,null,
                        dbVersion) ;
                dbHelper.deleteuser(uname.getText().toString());
                Intent it = new Intent(Delete.this, MainActivity.class);
                startActivity(it);
            }
        });
    } }