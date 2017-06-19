package com.luoli.contactlist.readcontacts.utils;

import android.util.Log;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * Created by Administrator on 2016/7/25.
 */
public class PinyinUtils {
    private static HanyuPinyinOutputFormat format;
    public static String hanZiToPinyin(String hanZi){
        char[] chars = hanZi.toCharArray();
        if (format==null){
            //设置输出配置
            format=new HanyuPinyinOutputFormat();
        }
        //设置大写
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        //取消声调
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        StringBuilder sb=new StringBuilder();
        for (char aChar : chars) {
            if (Character.isWhitespace(aChar)){
                continue;
            }
            if (Character.toString(aChar).matches("[\\u4E00-\\u9FA5]")){
                //汉字
                try {
                    String letter = PinyinHelper.toHanyuPinyinStringArray(aChar, format)[0];
                    sb.append(letter);
                } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                    badHanyuPinyinOutputFormatCombination.printStackTrace();
                }
            }else{
                if (Character.isLetter(aChar)){//字母
                    sb.append(Character.toUpperCase(aChar));
                }else {//乱七八糟的不认识的字符%$^$
                    sb.append("#");
                }
            }
        }
        Log.i("test",sb.toString());
        return sb.toString();
    }
}
