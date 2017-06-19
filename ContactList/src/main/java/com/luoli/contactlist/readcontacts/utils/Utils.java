package com.luoli.contactlist.readcontacts.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LUOLI on 2017/5/4.
 */
public class Utils {
    /**
     * 判断手机号码是否合法
     */
    public static boolean judgePhoneNumber(String str) {
//        String regular_phone_number = "^[1]([3][0-9]{1}|45|47|50|51|52|53|55|56|57|58|59|70|71|76|77|78|80|81|82|83|84|85|86|87|88|89)[0-9]{8}$";
        String regular_phone_number = "^1[34578]\\d{9}$";

        //Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Pattern p = Pattern.compile(regular_phone_number);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
