package org.sys;

public class ReplaceStrAlgorithm {

    /**
     *(非必须）判断字符串是否为空，为空直接返回空字符串
     * 1.取出第0个字符，并赋值给prev
     * 2.开始循环，递增下标，依次和prev比较。
     * 如果相等，count（用来标识已经相等的数量，值初始化1）++
     * 如果不等，确认count值是否小于3，小于3的话在结果字符串sb后添加count个prev，并将新值赋值给prev
     * 3.循环结束后，还剩余count个prev未处理，如果count大于3，不添加，如果count小于3，将count个prev添加到sb
     * 4.比较初始字符串string和sb的长度，如果相等，标志结束。如果不等，重复上述步骤。
     */
    public static String removeConsecutiveStr(String string) {

        if (string.isEmpty()) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        // 连续字符的长度
        int count = 1;
        // 前一个字符
        char prev = string.charAt(0);

        for (int i = 1; i < string.length(); i++) {
            char current = string.charAt(i);
            if (current == prev) {
                count++;
            } else {
                if (count < 3) {
                    //添加count长度的字符prev
                    for (int j = 0; j < count; j++) {
                        sb.append(prev);
                    }
                }
                prev = current;
                count = 1;
            }
        }

        // 判断最后的字符，如果小于三，依次添加。大于3，直接跳过
        if (count < 3) {
            for (int j = 0; j < count; j++) {
                sb.append(prev);
            }
        }

        if (sb.isEmpty()) {
            return "";
        }

        // 如果初始字符串长度减少，说明有删减，开始再次筛选
        if (sb.length() < string.length()) {
            return removeConsecutiveStr(sb.toString());
        } else {
            // 如果初始字符串长度没变，说明循环结束，不做处理

            return sb.toString() ;


        }
    }

    /**
     *(非必须）判断字符串是否为空，为空直接返回空字符串
     * 1.取出第0个字符，并赋值给prev
     * 2.开始循环，递增下标，依次和prev比较。
     * 如果相等，count（用来标识已经相等的数量，值初始化1）++
     * 如果不等，确认count值是否小于3，小于3的话在结果字符串sb后添加count个prev，并将新值赋值给prev
     * 大于等于3的话，在sb后添加1个prev前一位字符，并将新的char赋值给prev
     * 3.循环结束后，还剩余count个prev未处理，如果count大于等于3，添加1个prev前一位，如果count小于3，将count个prev添加到sb
     * 4.比较初始字符串string和sb的长度，如果相等，标志结束。如果不等，重复上述步骤。
     */

    public static String replaceConsecutiveChars(String input) {
        if (input.isEmpty()) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        // 连续字符的长度
        int count = 1;
        // 前一个字符
        char prev = input.charAt(0);

        for (int i = 1; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == prev) {
                count++;
            } else {
                if (count < 3) {
                    //添加count长度的字符prev
                    for (int j = 0; j < count; j++) {
                        sb.append(prev);
                    }
                } else {
                    sb.append(preChar(prev));
                }
                prev = current;
                count = 1;
            }
        }

        // 判断最后的字符，如果小于三，依次添加。大于3，添加前一位值
        if (count < 3) {
            for (int j = 0; j < count; j++) {
                sb.append(prev);
            }
        } else {
            sb.append(preChar(prev));
        }

        if (sb.isEmpty()) {
            return "";
        }

        // 如果初始字符串长度减少，说明有删减，开始再次筛选
        if (sb.length() < input.length()) {
            return replaceConsecutiveChars(sb.toString());
        } else {
            // 如果初始字符串长度没变，说明循环结束，不做处理

                return sb.toString() ;

        }

    }

    /**
     *
     * @param c 输入字符
     * @return 如果c是a，前一位为z，其他值为c-1
     */
    public static String preChar(char c) {

        if (c == 'a') {
            return "";
        } else {
            return String.valueOf((char)(c - 1));
        }
    }

    public static void main(String[] args) {

        //初始值为"aabcccbbad",删减过后应该为d
        String input1 = "aabcccbbad";
        String output1 = removeConsecutiveStr(input1);
        System.out.println("Output1: " + output1);//d


        String input2 = "abcccbad";
        String output2 = replaceConsecutiveChars(input2);
        System.out.println("Output2: " + output2);//d

        String input3 = "";
        String output3 = replaceConsecutiveChars(input3);
        System.out.println("Output3: " + output3);
    }
}