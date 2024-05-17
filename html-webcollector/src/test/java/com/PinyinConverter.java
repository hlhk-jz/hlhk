package com;
import net.sourceforge.pinyin4j.PinyinHelper;

public class PinyinConverter {
    public static String convertPinyinToHanzi(String pinyin) {
        StringBuilder result = new StringBuilder();
        String[] pinyinArray = pinyin.split("\\s+");

        for (String pinyinItem : pinyinArray) {
            char[] charArray = pinyinItem.toCharArray();

            for (char c : charArray) {
                String[] pinyinWithTone = PinyinHelper.toHanyuPinyinStringArray(c);

                if (pinyinWithTone != null && pinyinWithTone.length > 0) {
                    result.append(pinyinWithTone[0]);
                } else {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String pinyin = "shanghai";
        String hanzi = convertPinyinToHanzi(pinyin);
        System.out.println(hanzi); // 输出：上海
    }
}