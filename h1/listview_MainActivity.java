package com.example.listview;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    ListView myList;
    String countryList[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = findViewById(R.id.list);
        countryList = getResources().getStringArray(R.array.country)
        ;
        ArrayAdapter<String> arrayAdapter = new
                ArrayAdapter<String>(this, R.layout.list,
                countryList);
        myList.setAdapter(arrayAdapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long id) {
                Toast.makeText(MainActivity.this, "You have clicked:" + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
