package com.example.lifecycle;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt_p,bt_n;
    Button alertButton,listButton ;
    ImageView iv;
    boolean flag;
    int images[] = {R.drawable._1, R.drawable._2,R.drawable._3,R.drawable._4};
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        CharSequence text = "App just created ";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = makeText(context, text, duration);
        toast.show();
        iv = (ImageView) findViewById(R.id.img);
        bt_p = (Button) findViewById(R.id.button_previous);
        bt_n = (Button) findViewById(R.id.button_next);
        flag = true;
        bt_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = (i-1) % images.length;
                if(i<0)
                    i += images.length;
                iv.setImageResource(images[i]);
            }
        });
        bt_n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i = (i+1) % images.length;
                iv.setImageResource(images[i]);
            }
        });
        alertButton = findViewById(R.id.alert) ;
        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new
                        AlertDialog.Builder(MainActivity.this) ;
                builder.setIcon(R.drawable.ic_launcher_background) ;
                builder.setTitle("Alert Title") ;
                builder.setMessage("Shall I Close this window, Y/N?") ;
                builder.setPositiveButton("Yes", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "You have pressed yes",
                                        Toast.LENGTH_SHORT).show();
                            }
                        });
                builder.setNegativeButton("No", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish() ;
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
        makeText(this, "ACTIVITY STARTED", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        makeText(this, "ACTIVITY RESUMED", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        makeText(this, "ACTIVITY PAUSED", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        makeText(this, "ACTIVITY STOP", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeText(this, "ACTIVITY DESTROYED", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        makeText(this, "ACTIVITY RESTART", Toast.LENGTH_SHORT).show();
    }
}