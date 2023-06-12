package com.bootcoding.ipl.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtility {

    public String removeDoubleQuote(String text){
        return text.replace("\"", "");
    }

}
