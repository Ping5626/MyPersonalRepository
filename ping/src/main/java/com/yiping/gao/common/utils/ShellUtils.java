package com.yiping.gao.common.utils;

import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * @Author: 高一平
 * @Date: 2019/9/16 15:17
 * @Description: Java代码中执行Linux命令
 **/
public class ShellUtils {

    public static String runShell(String command) {
        try {
            String[] commands = isLinux() ? new String[]{"/bin/sh", "-c", command} : new String[]{"cmd", "/c", command};
            Process process = Runtime.getRuntime().exec(commands);
            InputStreamReader ir = new InputStreamReader(process.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String ln;
            StringBuilder result = new StringBuilder();
            while ((ln = input.readLine()) != null) {
                result.append(ln);
                result.append("\n");
            }
            input.close();
            ir.close();
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isLinux() {
        String os = System.getProperty("os.name").toLowerCase();
        if (null != os && os.contains("windows")) {
            return false;
        }
        return true;
    }

}
