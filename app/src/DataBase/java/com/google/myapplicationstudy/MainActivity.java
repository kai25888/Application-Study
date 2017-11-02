package com.google.myapplicationstudy;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.utils.DataBaseHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    @Bind(R.id.onCreateDataBase)
    Button onCreateDataBase;
    @Bind(R.id.onCreatTable)
    Button onCreatTable;
    @Bind(R.id.insert)
    Button insert;
    @Bind(R.id.query)
    Button query;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.delete)
    Button delete;

    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase sqLiteDatabase;
    private ContentValues contentValues;


    //    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_main);
        ButterKnife.bind(this);
        System.out.println(title.getText());
    }

    @OnClick(R.id.onCreateDataBase)
    public void onOnCreateDataBaseClicked() {
        title.setText("onCreateDataBase");
        System.out.println("onCreateDataBase");
        dataBaseHelper = new DataBaseHelper(this, "mydata_base");
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
    }

    @OnClick(R.id.onCreatTable)
    public void onCreatTableClicked() {
        title.setText("onCreatTable");
        System.out.println("onCreatTable");
        dataBaseHelper = new DataBaseHelper(this, "mydata_base");
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        sqLiteDatabase.execSQL("create table user(id int,name verchar(20))");
    }

    @OnClick(R.id.insert)
    public void onInsertClicked() {
        title.setText("Insert");
        System.out.println("insert");
        dataBaseHelper = new DataBaseHelper(this, "mydata_base");
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("id", 1);
        contentValues.put("name", "张三");
        sqLiteDatabase.insert("user", null, contentValues);
        contentValues.put("id", 2);
        contentValues.put("name", "李四");
        sqLiteDatabase.insert("user", null, contentValues);
        contentValues.put("id", 3);
        contentValues.put("name", "朱七");
        sqLiteDatabase.insert("user", null, contentValues);
        contentValues.put("id", 4);
        contentValues.put("name", "陈八");
        sqLiteDatabase.insert("user", null, contentValues);
    }

    @OnClick(R.id.delete)
    public void onViewClicked() {
        System.out.println("delete");
        dataBaseHelper = new DataBaseHelper(this, "mydata_base");
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        sqLiteDatabase.execSQL("drop table user");
        sqLiteDatabase.close();
    }

    @OnClick(R.id.update)
    public void onupdateClicked() {
        title.setText("update");
        System.out.println("update");
        dataBaseHelper = new DataBaseHelper(this, "mydata_base");
        sqLiteDatabase = dataBaseHelper.getWritableDatabase();
        contentValues = new ContentValues();
        contentValues.put("name", "赵五");
        sqLiteDatabase.update("user", contentValues, "id=?", new String[]{"1"});
    }

    @OnClick(R.id.query)
    public void onQueryClicked() {
        title.setText("Query");
        System.out.println("query");
        dataBaseHelper = new DataBaseHelper(this, "mydata_base");
        sqLiteDatabase = dataBaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query("user", new String[]{"id", "name"}, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            System.out.println("quer.........." + name);
        }
    }

    @Override
    protected void onDestroy() {
        System.out.println("finish");
        super.onDestroy();
    }

}
