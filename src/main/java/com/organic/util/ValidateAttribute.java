package com.organic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateAttribute {

    public static boolean isValidMobileNumber(String phoneNum){
        Pattern pat = Pattern.compile("^09\\d{8}$");
        Matcher mat = pat.matcher(phoneNum);

        return (mat.find() && mat.group().equals(phoneNum));
    }
}
