package com.example.sqlite;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class Update extends AppCompatActivity {
    EditText uname;
    EditText upass ;
    Button update;
    dbhelper dbHelper;
    private static final String dbName="studentdb";
    private static final String tbName="student" ;
    private static final int dbVersion = 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update); uname =
                findViewById(R.id.uuname) ; upass = findViewById(R.id.uupass) ;
        update = findViewById(R.id.updatebtn);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper = new dbhelper(Update.this, dbName, null,
                        dbVersion) ;
                dbHelper.update(uname.getText().toString(),
                        upass.getText().toString()); Intent it = new
                        Intent(Update.this, MainActivity.class); startActivity(it);
            }
        });
    } }