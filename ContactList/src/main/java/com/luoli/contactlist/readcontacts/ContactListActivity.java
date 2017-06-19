package com.luoli.contactlist.readcontacts;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.luoli.contactlist.R;
import com.luoli.contactlist.readcontacts.adapter.ContactAdapter;
import com.luoli.contactlist.readcontacts.bean.GoodMan;
import com.luoli.contactlist.readcontacts.utils.Utils;
import com.luoli.contactlist.readcontacts.view.SlideBar;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by LUOLI on 2017/5/4.
 */
public class ContactListActivity extends AppCompatActivity {

    private static final String TAG = "ContactListActivity";
    private ContactAdapter adapter;
    private ListView listView;
    private TextView SlideBarText;
    private SlideBar slideBar;
    private ArrayList<GoodMan> oriList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        oriList = new ArrayList<>();
        initView();
        initEvent();
        readContacts();
        inintListener();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listView);
        SlideBarText = (TextView) findViewById(R.id.SlideBar_text);
        slideBar = (SlideBar) findViewById(R.id.slideBar);
        slideBar.setAlpha(0);
    }

    private void initEvent() {
        adapter = new ContactAdapter(this, oriList);
        listView.setAdapter(adapter);
    }

    private void inintListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.setPosition(position);
                adapter.notifyDataSetChanged();
                GoodMan goodMan = oriList.get(position);
                Log.d(TAG, "itemClick: 获取到姓名：" + goodMan.getName() + "+手机号：" + goodMan.getNumber());

                showToast(goodMan.getName(), goodMan.getNumber());
                Intent intent = new Intent();
                intent.putExtra("user",goodMan.getName());
                intent.putExtra("num",goodMan.getNumber());
                setResult(1,intent);
                finish();
            }
        });

        slideBar.setOnTouchLetterChangeListenner(new SlideBar.OnTouchLetterChangeListenner() {
            @Override
            public void onTouchLetterChange(boolean isTouched, String s) {
                SlideBarText.setText(s);
                if (isTouched) {
                    SlideBarText.setVisibility(View.VISIBLE);
                    slideBar.setAlpha(1);
                } else {
                    SlideBarText.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            SlideBarText.setVisibility(View.GONE);
                            slideBar.setAlpha(0);
                        }
                    }, 100);
                }
                //----------------------优雅的分割线：定位到listview的相应条目上面---------------------
                if (oriList != null) {
                    for (int i = 0; i < oriList.size(); i++) {
                        GoodMan Man = oriList.get(i);
                        String firstLetter = Man.getPinyin().charAt(0) + "";
                        if (TextUtils.equals(s, firstLetter)) {
                            listView.setSelection(i);
                            break;
                        }
                    }
                }

//                int position = array.indexOf(s);
//                mListView.setSelection(position);
            }
        });
    }
    private Toast toast = null;
    private void showToast(String name, String number) {

        if (toast == null) {
            toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        }
        toast.setText("手机号：" + number);
        toast.setGravity(Gravity.BOTTOM,10,50);
//        ImageView imageView = new ImageView(this);
//        imageView.setImageResource(R.drawable.progress);
//        toast.setView(imageView);
        toast.show();
    }

    private void readContacts() {


        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null
            );
            while (cursor.moveToNext()) {
                String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                if (Utils.judgePhoneNumber(number.replaceAll(" ", ""))) {

                    oriList.add(new GoodMan(displayName, number));
//                        list.add(builder.toString());
                }
//                Log.i(TAG, "readContacts: number:"+number);
//                Log.i(TAG, "readContacts: displayName:"+displayName);
//                Log.i(TAG, "readContacts: 你大爷:" + builder.toString());
            }
            //排序
            Collections.sort(oriList);

            // 拿到联系人列表后按照字母大小排序
//            for (int i = 0; i < oriList.size(); i++) {
//                String[] split = oriList.get(i).split("|");
//                if (split[0] != null) {
//                    // 号码有名字，拿到号码的第一个字母，按照字母排序
//
////                    split[0];
//                } else {
//                    // 号码没有名字
//
//                }
//
//            }
//            Log.i(TAG, "readContacts: 集合长度:" + list.size());
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (cursor != null) {
                cursor.close();
            }
        }
    }


}
