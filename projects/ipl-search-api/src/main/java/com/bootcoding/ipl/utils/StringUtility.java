package com.bootcoding.ipl.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtility {

    public String removeDoubleQuote(String text){
        return text.replace("\"", "");
    }

    public String extractFromSquareBrackets(String text, boolean isFirst){
        if(text.contains("[")){
            String substring = "";
            if(isFirst) {
                substring = text.substring(text.indexOf("[") + 1, text.indexOf("]"));
            }else{
                substring = text.substring(text.lastIndexOf("[") + 1, text.lastIndexOf("]"));
            }
            return substring;
        }
        return text;
    }
}
