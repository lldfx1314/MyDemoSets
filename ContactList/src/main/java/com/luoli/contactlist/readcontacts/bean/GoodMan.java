package com.luoli.contactlist.readcontacts.bean;


import com.luoli.contactlist.readcontacts.utils.PinyinUtils;

/**
 * Created by Administrator on 2016/7/25.
 */
public class GoodMan implements Comparable<GoodMan> {
    private String pinyin;

    private String name;

    private String number;

    public GoodMan(String name, String number) {
        this.name = name;
        this.number = number;
        this.pinyin = PinyinUtils.hanZiToPinyin(name);
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(GoodMan another) {
        return this.pinyin.compareTo(another.pinyin);
    }
}
