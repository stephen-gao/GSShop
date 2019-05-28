package com.gao.base.utils;

/**
 * @Author gs
 * @Date created time 2019/5/28 12:55
 * @Description
 */


import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yutao on 2015/9/14.
 */
public class PatternUtil {

    /*
        三大运营商最新号段 合作版
        移动号段：134 135 136 137 138 139  147   150 151 152 157 158 159    178       182 183 184 187 188
        联通号段：130 131 132              145   155 156                    175 176   185 186
        电信号段：133                            153                        177       180 181 189
        虚拟运营商:                                                         170
    */
    public static final String MOBILE_PATTERN = "^((13[0-9])|(14[5|7])|(15[^4,\\D])|(18[0-9])|(17[0-9]))\\d{8}$";

    public static final String EMAIL_PATTERN = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    //身份证正则表达式(15位)
    public static final String IDCARD_15_PATTERN = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
    //身份证正则表达式(18位)
    public static final String IDCARD_18_PATTERN = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$";
    //身份证为15位或者18位，15位的全为数字，18位的前17位为数字，最后一位为数字或者大写字母”X“。
    public static final String IDCARD_15_18_PATTERN = "(^\\d{15}$)|(^\\d{17}([0-9]|X|x)$)";
    public static final String HUZHAO_PATTERN = "(P\\d{7}|G\\d{8}|S\\d{7,8}|D\\d+|1[4,5]\\d{7}|N\\d{7})";

    public static boolean isEmail(String email) {
        if (StringUtils.isNotBlank(email)) {
            Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
            Matcher emailMatcher = emailPattern.matcher(email.trim());
            if (emailMatcher.matches()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMobile(String mobile) {
        if (StringUtils.isNotBlank(mobile)) {
            Pattern mobilePattern = Pattern.compile(MOBILE_PATTERN);
            Matcher mobileMatcher = mobilePattern.matcher(mobile.trim());
            if (mobileMatcher.matches()) {
                return true;
            }
        }

        return false;
    }

    public static boolean isHuzhao(String huzhao) {
        if (StringUtils.isNotBlank(huzhao)) {
            Pattern huzhaoPattern = Pattern.compile(HUZHAO_PATTERN);
            Matcher huzhaoMatcher = huzhaoPattern.matcher(huzhao.trim());
            if(huzhaoMatcher.find()){
                System.out.println(huzhaoMatcher.group());
            }
            if (huzhaoMatcher.matches()) {
                return true;
            }
        }

        return false;
    }

    /**
     * 身份证
     *
     * @param idCard
     * @return
     */
    public static boolean isIdCard(String idCard) {
        if (StringUtils.isNotBlank(idCard)) {
            if (Pattern.compile(IDCARD_18_PATTERN).matcher(idCard.trim()).matches()) {
                return true;
            } else if (Pattern.compile(IDCARD_15_PATTERN).matcher(idCard.trim()).matches()) {
                return true;
            } else if (Pattern.compile(IDCARD_15_18_PATTERN).matcher(idCard.trim()).matches()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHuzhao("身份证： N2725178joli"));
    }

    public static boolean isUrl(String str) {
        return match(URL_PATTERN, str);
    }

    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static final String URL_PATTERN = "(https?|ftp|mms):\\/\\/([A-z0-9]+[_\\-]?[A-z0-9]+\\.)*[A-z0-9]+\\-?[A-z0-9]+\\.[A-z]{2,}(\\/.*)*\\/?";

    public static String getRegString(String str) {
        Pattern pattern = Pattern.compile(URL_PATTERN);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new RuntimeException("为找到匹配字符串url");
        }
    }
}
