package com.vmc.interview.marriott;

public class RepeatChars {
    public static void main(String[] args) {
        String str="2[x3[z]]";
        for (int i=0;i<str.length();i++){
             int times=0;
             String remainStr="";
             if(isOpenBracket(str.charAt(i))){
                 times=str.charAt(i-1)-48;
                 remainStr=str.substring(i+1,str.length());
                 System.out.println("open bracket times:"+times+",remainStr:"+remainStr);
             }
             String repeatedString=repeatString(remainStr,times);
             System.out.println(repeatedString);
        }
    }

    private static String repeatString(String remainStr, int times) {
        String repeatedString="";
        for (int i=0;i<remainStr.length();i++){
            if(!isCloseBracket(remainStr.charAt(i))){
                repeatedString=repeatedString+remainStr.charAt(i);
            }
        }
        return repeatedString.repeat(times);
    }

    private static boolean isOpenBracket( char c) {
        return '['==c;
    }
    private static boolean isCloseBracket( char c) {
        return ']'==c;
    }
}
