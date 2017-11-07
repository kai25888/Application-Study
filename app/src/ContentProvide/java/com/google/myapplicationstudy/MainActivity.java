package com.google.myapplicationstudy;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by tiankai on 2017/11/6.
 */
public class MainActivity extends Activity {
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.list_view)
    ListView listView;

    private List<String> contentList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contentprovide_main);
        ButterKnife.bind(this);
        //获取联系人
        getContacts();
    }

    private void getContacts() {
        contentList = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, contentList);
        listView.setAdapter(arrayAdapter);
        readContacts();
    }

    private void readContacts() {
        System.out.println("readContacts");
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            while (cursor.moveToNext()) {
                //get name
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                //get number
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                contentList.add(name + "\n" + number);
                System.out.println(name + "\n" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null)
                cursor.close();
        }
    }
}
