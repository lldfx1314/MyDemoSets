package com.luoli.contactlist;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.luoli.contactlist.readcontacts.ContactListActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.button1:
//                Toast.makeText(this,"哈哈",Toast.LENGTH_SHORT).show();
                startActivityForResult(new Intent(
                        Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI), 0);
                textView.setText("这世界真好！！！");
                break;
            case R.id.button2:
//                Toast.makeText(this,"哈哈",Toast.LENGTH_SHORT).show();
                startActivityForResult(new Intent(MainActivity.this, ContactListActivity.class),1);
                textView.setText("这世界真好！！！");
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK&&data!=null) {
            ContentResolver reContentResolverol = getContentResolver();
            Uri contactData = data.getData();
            @SuppressWarnings("deprecation")
            Cursor cursor = managedQuery(contactData, null, null, null, null);
            cursor.moveToFirst();
            String username = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phone = reContentResolverol.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,
                    null,
                    null);
            while (phone.moveToNext()) {
                String usernumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                textView.setText(usernumber +" ("+ username +")");
            }

        }
        if(resultCode == 1&&data!=null){
            String userName = data.getStringExtra("user");
            String userNumber = data.getStringExtra("num");
            textView.setText(userName +" ("+ userNumber +")");
        }
    }
}
