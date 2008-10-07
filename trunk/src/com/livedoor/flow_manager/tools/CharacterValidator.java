package com.livedoor.flow_manager.tools;

public class CharacterValidator
{
   
    public static boolean isEmpty(String s) {
        return s == null || s.equals("");
    }

    public static boolean isSpace(char c) {
        return isHalfWidthSpace(c) || isFullWidthSpace(c);
    }

    public static boolean isSpace(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isSpace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHalfWidthSpace(char c) {
        return c == 0x0020;
    }

    public static boolean isHalfWidthSpace(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isHalfWidthSpace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFullWidthSpace(char c) {
        return c == 0x3000;
    }

    public static boolean isFullWidthSpace(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isFullWidthSpace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
//    /**
//     * Digit
//     */
//    public boolean isDigit(char c) // '0' ~ '9' || '?O' ~ '?X'
//    {
//        return isHalfWidthDigit(c) || isFullWidthDigit(c);
//    }
//
//    public boolean isDigit(String s) {
//        if (s == null || s.length() == 0)
//            return false;
//        for (int i = 0, len = s.length(); i < len; i++) {
//            if (!isDigit(s.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
//    }
//
    public static boolean isHalfWidthDigit(char c) // '0' ~ '9'
    {
        return (c >= 0x0030 && c <= 0x0039);
    }

    public static boolean isHalfWidthDigit(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isHalfWidthDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFullWidthDigit(char c) // '?O' ~ '?X'
    {
        return (c >= 0xFF10 && c <= 0xFF19);
    }

    public static boolean isFullWidthDigit(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isFullWidthDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
//    /**
//     * Alpha
//     */
    public static  boolean isAlpha(char c) // A~Z || a~z || ?` ~ ?y || ?? ~ ??
    {
        return isHalfWidthAlpha(c) || isFullWidthAlpha(c);
    }

    public static boolean isAlpha(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isAlpha(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
    public static boolean isHalfWidthAlpha(char c) // A~Z || a~z
    {
        return isHalfWidthAlphaLower(c) || isHalfWidthAlphaUpper(c);
    }
//
    public static boolean isHalfWidthAlpha(String s) {
        if (s == null)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isHalfWidthAlpha(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
    public static boolean isFullWidthAlpha(char c) // ?` ~ ?y || ?? ~ ??
    {
        return isFullWidthAlphaLower(c) || isFullWidthAlphaUpper(c);
    }

    public static boolean isFullWidthAlpha(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isFullWidthAlpha(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
    public static boolean isHalfWidthAlphaLower(char c) // a~z
    {
        return (c >= 0x0061 && c <= 0x007A);
    }
//
    public static boolean isHalfWidthAlphaLower(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isHalfWidthAlphaLower(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
    public static boolean isFullWidthAlphaLower(char c) // ?? ~ ??
    {
        return (c >= 0xFF41 && c <= 0xFF5A);
    }

    public static boolean isFullWidthAlphaLower(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isFullWidthAlphaLower(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
    public static boolean isHalfWidthAlphaUpper(char c) // A~Z
    {
        return (c >= 0x0041 && c <= 0x005A);
    }

    public static boolean isHalfWidthAlphaUpper(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isHalfWidthAlphaUpper(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
    public static boolean isFullWidthAlphaUpper(char c) // ?` ~ ?y
    {
        return (c >= 0xFF21 && c <= 0xFF3A);
    }

    public static boolean isFullWidthAlphaUpper(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isFullWidthAlphaUpper(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//    
    /**
     * Latin
     */
    public static boolean isLatin(char c) {
        return (c >= 0x0020 && c <= 0x009F);
    }

    public static boolean isLatin(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isLatin(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Hiragana
     */
    public static boolean isHiragana(char c) {
        return (c >= 0x3040 && c <= 0x309F);
    }

    public static boolean isHiragana(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isHiragana(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
    /**
     * Kana
     */
    public static boolean isKana(char c) {
        return isHalfWidthKana(c) || isFullWidthKana(c);
    }

    public static boolean isKana(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isKana(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
    public static boolean isHalfWidthKana(char c) {
        return (c >= 0xff61 && c <= 0xff9f);
    }

    public static boolean isHalfWidthKana(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isHalfWidthKana(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
    public static boolean isFullWidthKana(char c) {
        return (c >= 0x30a0 && c <= 0x30ff);
    }

    public static boolean isFullWidthKana(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isFullWidthKana(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//    
    /**
     * Kanji
     */
    public static boolean isKanji(char c) {
        return (c >= 0x2E80 && c <= 0x2EFF) // CJK Radicals Supplement
                || (c >= 0x2F00 && c <= 0x2FDF) // Kangxi Radicals
                || (c >= 0x3100 && c <= 0x312F) // Bopomofo
                || (c >= 0x31A0 && c <= 0x31BF) // Bopomofo Extended
                || (c >= 0x3400 && c <= 0x4DBF) // CJK Unified Ideographs
                || (c >= 0x4E00 && c <= 0x9FAF) // CJK Unified Ideographs
                || (c >= 0xf900 && c <= 0xFAFF); // CJK Compatibility Ideographs
    }

    public static boolean isKanji(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isKanji(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

//    /**
//     * Full/Half width
//     */
    public static boolean isHalfWidth(char c) {
        return isLatin(c) || isHalfWidthKana(c);
    }
//
    public static boolean isHalfWidth(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isHalfWidth(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//
    public static boolean isFullWidth(char c) {
        return isFullWidthSpace(c) || isFullWidthDigit(c)
                || isFullWidthAlpha(c) || isFullWidthKana(c) || isKanji(c)
                || isHiragana(c);
    }
//
    public static boolean isFullWidth(String s) {
        if (s == null || s.length() == 0)
            return false;
        for (int i = 0, len = s.length(); i < len; i++) {
            if (!isHalfWidth(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
//    
//    public static void main(String[] args) {
//		System.out.println("isKanji:"+isKanji("??????????"));
//		System.out.println("isKanji:"+isKanji("?A?C?E?G?I"));
//		
//		System.out.println("isKanji:"+isKanji("??"));
//		
//	}
	
	 public static boolean isDigit(char c)
	    {
	        return c >= '0' && c <= '9';
	    }

	    public static boolean isDigit(String value)
	    {
	        int len = value.length();
	        char chars[] = value.toCharArray();
	        for(int i = 0; i < len; i++)
	        {
	            char c = chars[i];
	            if(!isDigit(c))
	                return false;
	        }

	        return true;
	    }

	    public static boolean isAlphabet(char c)
	    {
	        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
	    }

	    public static boolean isAlnum(char c)
	    {
	        return isDigit(c) || isAlphabet(c);
	    }

	    public static boolean isAlnum(String value)
	    {
	        int len = value.length();
	        char chars[] = value.toCharArray();
	        for(int i = 0; i < len; i++)
	        {
	            char c = chars[i];
	            if(!isAlnum(c))
	                return false;
	        }

	        return true;
	    }

	    public static boolean isAscii(char c)
	    {
	        return c < '\177' && c >= ' ';
	    }

	    public static boolean isAscii(String value)
	    {
	        int len = value.length();
	        char chars[] = value.toCharArray();
	        for(int i = 0; i < len; i++)
	        {
	            char c = chars[i];
	            if(!isAscii(c))
	                return false;
	        }

	        return true;
	    }

	    public static boolean isHalfKana(char c)
	    {
	        return c > '\uFF60' && c <= '\uFF9F';
	    }

	    public static boolean isHalfKana(String value)
	    {
	        int len = value.length();
	        char chars[] = value.toCharArray();
	        for(int i = 0; i < len; i++)
	        {
	            char c = chars[i];
	            if(!isHalfKana(c))
	                return false;
	        }

	        return true;
	    }

	    public static boolean isFullKana(char c)
	    {
	        return c > '\u30A0' && c <= '\u30FF';
	    }

	    public static boolean isFullKana(String value)
	    {
	        int len = value.length();
	        char chars[] = value.toCharArray();
	        for(int i = 0; i < len; i++)
	        {
	            char c = chars[i];
	            if(!isFullKana(c) && c != '\u3000')
	                return false;
	        }

	        return true;
	    }

//	    public static boolean isHiragana(char c)
//	    {
//	        return c > '\u3040' && c <= '\u309F';
//	    }

//	    public static boolean isHiragana(String value)
//	    {
//	        int len = value.length();
//	        char chars[] = value.toCharArray();
//	        for(int i = 0; i < len; i++)
//	        {
//	            char c = chars[i];
//	            if(!isHiragana(c) && c != '\u3000')
//	                return false;
//	        }
//
//	        return true;
//	    }

	    public static boolean isFull(String value)
	    {
	        byte bstr[] = value.getBytes();
	        int len = value.length();
	        return bstr.length == len * 2;
	    }

	    public static boolean isHalf(String value)
	    {
	        byte bstr[] = value.getBytes();
	        int len = value.length();
	        return bstr.length == len;
	    }
	    
	  
}