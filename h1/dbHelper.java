package com.example.my_database_application;
import android.content.ContentValues; import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase; import
        android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DBHelper extends SQLiteOpenHelper { public DBHelper(@Nullable
                                                                         Context context){
    super(context, "userdata.db",null,1);
}
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Userdetails(name TEXT primary key,contact TEXT, age TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { db.execSQL("drop Table if exists Userdetails");
    }
    public boolean insertdata(String name,String contact, String age){ SQLiteDatabase db =
            this.getWritableDatabase();
        ContentValues contentValues = new ContentValues(); contentValues.put("name",name);
        contentValues.put("contact",contact); contentValues.put("age",age);
        long result = db.insert("Userdetails",null,contentValues); if(result == -1)
            return false; else return true;
    }
    public boolean updateData(String name,String contact,String age){ SQLiteDatabase db =
            this.getWritableDatabase(); ContentValues contentValues = new ContentValues();
        contentValues.put("contact",contact); contentValues.put("age",age);
        Cursor cursor = db.rawQuery("Select * from Userdetails where name=?",new String[]{name});
        if(cursor.getCount()>0)
        {
            long result = db.update("Userdetails",contentValues,"name=?",new String[]{name});
            if(result==-1) return false;
            else return true;
        }else return false;
    }
    public boolean deleteData(String name){ SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = db.rawQuery("Select * from Userdetails where name=?",new String[]{name});
        if(cursor.getCount()>0){
            long result = db.delete("Userdetails","name=?",new String[]{name}); if(result==-1)
                return false; else return true;
        }else return false;
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Userdetails",null); return cursor;
    }
}
