package com.mi.dpay.beans;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class Test {

    /**
     * get请求及非json POST请求签名
     *
     * @param params
     * @return
     */
    public static String getSignature(Map<String, String> params,
                                      String timestamp) {
        params.put("timestamp", timestamp);
        String client_secret = "bjWoMailQt81";//WebUtils.getConfigProperties("client_secret");
        String paramsStr = sortAndJoinParams(params) + client_secret;
        params.remove("timestamp");
        // MD5摘要后转为十六进制
        String signature = md5(paramsStr).toUpperCase();
        return signature;
    }

    /**
     * 将Map中的元素  按照key 的 字典排序 ，然后 使用"="连接 键和值，使用"&"连接元素，返回连接后的字符串
     * 例如： key1=value1&key2=value2
     *
     * @param params
     * @return
     */
    public static String sortAndJoinParams(Map<String, String> params) {
        String[] keyBuffer = new String[params.size()];
        Object[] objs = params.keySet().toArray();
        for (int i = 0; i < objs.length; i++) {
            keyBuffer[i] = (String) objs[i];
        }
        StringBuilder sb = new StringBuilder();
        keyBuffer = sort(keyBuffer);
        for (int i = 0; i < params.size(); i++) {
            sb.append(keyBuffer[i] + "=" + params.get(keyBuffer[i]) + (i == params.size() - 1 ? "" : "&"));
        }
        return sb.toString();
    }

    /**
     * 发送https get请求
     *
     * @param url     请求URL
     * @param params  请求参数
     * @param header  请求头
     * @param endPath URL末端拼接串
     * @return
     * @throws Exception
     */
    public static String sendGetHttps(String url, Map<String, String> params,
                                      Map<String, String> header, String... endPath) throws Exception {

        //忽略证书
        /*trustAllHttpsCertificates();
        HttpsURLConnection.setDefaultHostnameVerifier(hv);*/

        //url = appendParamsToUrl(url, params, endPath);
        System.out.println(url);
        URL requestUrl = new URL(url);
        HttpURLConnection  con = HttpURLConnection .class.cast(requestUrl.openConnection());
        con.setRequestMethod("POST");

        for (Entry<String, String> entry : header.entrySet()) {
            con.addRequestProperty(entry.getKey(), entry.getValue());
        }
        con.connect();

        InputStream input = con.getInputStream();
        String result = "";
        byte[] buffer = new byte[1024 * 8];
        int index = -1;
        while ((index = input.read(buffer)) != -1) {
            result += new String(buffer, 0, index);
        }
        input.close();
        con.disconnect();
        return result;
    }


    /**
     * 将参数拼接到url后边
     *
     * @param url
     * @param params
     * @param endPath 末端自定义path
     * @return
     */
    public static String appendParamsToUrl(String url,
                                           Map<String, String> params, String... endPath) {
        url += "?";
        int i = 0;
        for (String key : params.keySet()) {
            url += i == 0 ? key + "=" + params.get(key) : "&" + key + "="
                    + params.get(key);
            i++;
        }
        if (endPath != null && endPath.length != 0) {
            for (int j = 0; j < endPath.length; j++) {
                url += endPath[j];
            }
        }
        return url;
    }

    public static String md5(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(text.getBytes("utf-8"));
            StringBuilder buf = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                String b = Integer.toHexString(0xFF & digest[i]);
                if (b.length() == 1)
                    buf.append('0');
                buf.append(b);
            }
            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return text;
    }


    /**
     * 对字符串数据进行升序排序  忽略大小写
     *
     * @param arrays
     * @return
     */
    public static String[] sort(String[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length - i - 1; j++) {
                if (arrays[j].compareToIgnoreCase(arrays[j + 1]) > 0) {
                    String buffer = arrays[j];
                    arrays[j] = arrays[j + 1];
                    arrays[j + 1] = buffer;
                }
            }
        }
        return arrays;
    }


    public static void main(String args[]) {
        try {
            String url = "http://120.52.146.243/authorization/client_credentials_mail_hd";
            Map<String, String> params = new HashMap<String, String>();
            Map<String, String> header = new HashMap<String, String>();
            long timestamp = System.currentTimeMillis();
            params.put("client_id", "bjWoMailQt81");
            params.put("logon","18610599536");
            params.put("grant_type","client_credentials");
            params.put("deviceid","client_credentials");

            String sign = getSignature(params, timestamp + "");
            System.out.println(sign);
            System.out.println(timestamp);

            header.put("x-wocloud-version-v", "3.0:");
            header.put("x-wocloud-net-access",  "ETHER");
            header.put("channel",  "womail");
            header.put("hdflag",  "womail500M");


            String abc = sendGetHttps(url, params, header);
            System.out.println(abc);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}