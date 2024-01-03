import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Admin.
 * Time 2023/12/12 14:41
 * Desc 文件描述
 */
@Slf4j
public class TestV2 {


    /**
     * 手机格式后面运营商可能会改, 不用那么复杂, 就判断1开头, 是否为10位数字即可
     */
    private final static Pattern PHONE_PATTERN = Pattern.compile("^1[0-9]{10}$");




    @Test
    public void paoLiVay(){
        String logAllFilePath = "C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\excel\\channid.txt";


        List<String> lines2 = readLinesFromFile(logAllFilePath);

        String channIds = lines2.stream().findFirst().get();

        String[] split = channIds.split(",");



        System.err.println(Arrays.stream(split).count());


    }


    @Test
    public void userName(){

        String ss = desensitize("155189890ss");

        String s = desensitizeForCustomer(ss);

        System.err.println(s);

    }

    /**
     * *手机号名称设置
     * @param name
     * @return
     */
    private static String desensitize(String name) {
        String mobileRegex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
        Pattern p = Pattern.compile(mobileRegex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(name);
        if (m.matches()) {
            String endStr = name.substring(name.length() - 4);
            return "手机尾号" + endStr + "用户";
        }
        return name;
    }





    /**
     * *读取资源并关闭
     * // try-with-resources 语句中创建reader2的实例。BufferedReader当执行退出try块时，
     * // 会自动调用close()每个实例的方法，释放关联的资源。BufferedReader
     * //        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
     * //             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {
     * //            // Code to read and compare lines
     * //        } catch (IOException e) {
     * //            e.printStackTrace();
     * //        }
     * @param filePath
     * @return
     */
    private static List<String> readLinesFromFile(String filePath) {
        List<String> lines = new ArrayList<>();

        // try-with-resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }


    /**
     * C端脱敏用户信息
     * 1.用户名称
     * - 字符数为 1-3 位时，脱敏后显示为 4 位字符，保留第 1 位字符，后 3 位字符使用“*”补充或替代，如：“有”或“有赞”脱敏为“有***”。
     * - 字符数大于 3 位时，脱敏后显示为 4 位字符，保留第 1 位和最后 1 位字符，其他字符使用“*”替换，如：“有赞服务”或“有赞云服务”脱敏为“有**务”
     *
     * 2.手机号码脱敏规则
     * - 一般情况，隐藏手机号的第 4 位至第 7 位，共 4 位数字，如：135 **** 9865。
     *
     * 详见: https://design.youzan.com/strategy/data-formats.html#%E6%95%B0%E6%8D%AE%E8%84%B1%E6%95%8F%E8%A7%84%E5%88%99
     * @return
     */
    public static String desensitizeForCustomer(String userName){
        if(StringUtils.isEmpty(userName)){
            return StringUtils.EMPTY;
        }

        try {
            Matcher matcher = PHONE_PATTERN.matcher(userName);

            //手机号隐藏第4-7位
            if(matcher.matches()){
                return userName.substring(0, 3) + "****" + userName.substring(7, 11);
            }

            return desensitizeName(userName);
        } catch (Exception e){
            log.warn("用户信息脱敏异常, username:{}.", userName,  e);
            return userName;
        }
    }


    /**
     * 脱敏手机号  支持带区号的
     * @param mobileWithCode
     * @return
     */
    public static String desensitizePhoneWithCode(String mobileWithCode) {
        if(StringUtils.isEmpty(mobileWithCode)){
            return StringUtils.EMPTY;
        }
        try {
            int index = mobileWithCode.indexOf('-');
            String mobile = mobileWithCode;
            String code = "";
            if (index != -1) {
                code = mobileWithCode.substring(0, index + 1);
                mobile = mobileWithCode.substring(index + 1);
            }
            Matcher matcher = PHONE_PATTERN.matcher(mobile);
            //手机号隐藏第4-7位
            if(matcher.matches()){
                return code + mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
            }
            return mobileWithCode;
        } catch (Exception e) {
            log.warn("手机脱敏异常, mobile:{}.", mobileWithCode,  e);
            return mobileWithCode;
        }
    }

    public static String desensitizeForCustomerMobileMode2(String userName){
        if(StringUtils.isEmpty(userName)){
            return StringUtils.EMPTY;
        }

        try {
            Matcher matcher = PHONE_PATTERN.matcher(userName);

            //手机号隐藏第4-7位
            if(matcher.matches()){
                return  "手机尾号" + userName.substring(userName.length()-4) + "用户";
            }

            return desensitizeName(userName);
        } catch (Exception e){
            log.warn("用户信息脱敏异常, username:{}.", userName,  e);
            return userName;
        }
    }

    private static String desensitizeName(String userName){
        StringBuilder sb = new StringBuilder();
        int codePointLength = userName.codePointCount(0, userName.length());
        String firstStr = fixedSubString(userName,0, 1);
        String lastStr = fixedSubString(userName, codePointLength-1, codePointLength);
        sb.append(firstStr);

        //当字符数为1-3位时，保留第1位字符
        if (codePointLength <=3) {
            userName = sb.append("***").toString();
        } else {
            userName = sb.append("**").append(lastStr).toString();
        }
        return userName;
    }

    private static String fixedSubString(String source, int start, int end) {
        String result;
        try {
            result = source.substring(source.offsetByCodePoints(0, start),
                    source.offsetByCodePoints(0, end));
        } catch (Exception e) {
            log.warn("截取字符串失败, source:{}, start:{}, end:{}.", source, start, end, e);
            result = "*";
        }
        return result;
    }





}
