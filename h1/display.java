package com.example.sqlite;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class Display extends AppCompatActivity {
    TextView text ;
    dbhelper dbHelper;
    private static final String dbName="studentdb";
    private static final int dbVersion = 1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        text = findViewById(R.id.textview) ;
        dbHelper = new dbhelper(Display.this, dbName, null, dbVersion);
        String out=dbHelper.displayuser(Display.this);
        text.setText(out);
    } }