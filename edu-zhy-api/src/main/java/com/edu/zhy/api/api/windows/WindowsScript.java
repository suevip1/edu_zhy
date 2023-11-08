package com.edu.zhy.api.api.windows;

import com.edu.zhy.api.api.windows.util.UrlManager;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Map;
import java.util.Properties;

/**
 ** 脚本本地执行
 */
@Slf4j
public class WindowsScript {

    private static String userName;

    private static String password;

    public static void readAccount(){
        try {
            File file = new File("src/main/resources/application.properties");
            InputStream in = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(in);
            userName = properties.getProperty("user.name");
            password = properties.getProperty("user.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //执行脚本命令
    public static String execute(String command){
        //这里windows可能cmd命令不一样
        String[] cmd = {"/bin/bash"};
        Runtime rt = Runtime.getRuntime();
        Process proc = null;
        try {
            proc = rt.exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 打开流
        OutputStream os = proc.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        String result = null;

        try {
            bw.write(command);
            bw.flush();
            bw.close();
            result = readConsole(proc);
            proc.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result != null && (result.contains("invalid header") || result.contains("ops-jwt-auth"))) {
            // 重新刷新token
            readAccount();
            String rootDir = execute("cd ../../\npwd") + "/C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\windows\\util\\UrlManager.java";
            Map<String, String> param = OpsCasComponent.refreshCookie(userName, password);
            execute("sed -i  '' 's/" + UrlManager.authorization + "/" + param.get("jwt_token") + "/g' " + rootDir);
            log.warn("cookie过期，已自动刷新，请重新调用");
            return "cookie过期，已自动刷新，请重新调用";
        }
        if (result != null && (result.contains("302 Found") || result.contains("https://funeng.qima-inc.com/"))) {
            readAccount();
            // https://funeng.qima-inc.com/ 过期需要重新登录
            String rootDir = execute("cd ../../\npwd") + "/C:\\Users\\Admin\\IdeaProjects\\edu_zhy\\edu-zhy-api\\src\\main\\java\\com\\edu\\zhy\\api\\api\\windows\\util\\UrlManager.java";
            Map<String, String> param = OpsCasComponent.refreshDubboCookie(userName, password);
            String replaceContent = "KDTSESSIONID=" + param.get("KDTSESSIONID") + ";TSID=" + param.get("TSID");
            execute("sed -i  '' 's/" + UrlManager.cookie + "/" + replaceContent + "/g' " + rootDir);
            log.warn("cookie过期，已自动刷新，请重新调用");
            return "cookie过期，已自动刷新，请重新调用";
        }
        return result;
    }




    /**
     * 读取控制命令的输出结果
     */
    public static String readConsole(Process process) {
        StringBuilder cmdOut = new StringBuilder();
        InputStream fis = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        try {
            while ((line = br.readLine()) != null) {
                cmdOut.append(line).append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//       System.out.println("执行系统命令后的控制台输出为：\n" + cmdOut);
        return cmdOut.toString().trim();
    }



}
