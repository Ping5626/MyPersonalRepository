package com.yiping.gao.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @Author: 高一平
 * @Date: 2019/9/11 11:28
 * @Description:
 **/
public class HttpUtils {

    private final static Logger log = LoggerFactory.getLogger(HttpUtils.class);
    private final static String CHARSET = "UTF-8";
    private final static String CONTENT_TYPE = "Content-Type";
    private CloseableHttpClient httpClient;

    /**
     * Http默认配置
     *
     * @return
     */
    private static RequestConfig getDefaultRequestConfig() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(10000)
                .setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000).build();
        return requestConfig;
    }

    /**
     * 主动发起HTTP的GET请求
     *
     * @param URL 请求路径
     * @return
     * @throws Exception
     */
    public String HTTP_GET(String URL) throws Exception {
        String result = HTTP_GET(URL, null);
        return result;
    }

    /**
     * 主动发起HTTP的GET请求
     *
     * @param URL     请求路径
     * @param HEADERS 配置请求头
     * @return
     * @throws Exception
     */
    public String HTTP_GET(String URL, Map<String, String> HEADERS) throws Exception {
        httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);
        httpGet.setConfig(getDefaultRequestConfig());
        // 设置请求头
        if (HEADERS != null && HEADERS.size() > 0) {
            for (Map.Entry<String, String> entry : HEADERS.entrySet()) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
        }
        // 发起请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        // 解析结果
        HttpEntity httpEntity = httpResponse.getEntity();
        String result = EntityUtils.toString(httpEntity, CHARSET);
        httpResponse.close();
        return result;
    }

    /**
     * 主动发起HTTP的POST请求
     *
     * @param URL    请求路径
     * @param PARAMS 请求参数
     * @return
     * @throws Exception
     */
    public String HTTP_POST(String URL, String PARAMS) throws Exception {
        String result = HTTP_POST(URL, PARAMS, null);
        return result;
    }

    /**
     * 主动发起HTTP的POST请求
     *
     * @param URL    请求路径
     * @param PARAMS 请求参数
     * @return
     * @throws Exception
     */
    public String HTTP_POST(String URL, JSONObject PARAMS) throws Exception {
        String result = HTTP_POST(URL, PARAMS.toJSONString());
        return result;
    }

    /**
     * 主动发起HTTP的POST请求
     *
     * @param URL    请求路径
     * @param PARAMS 请求参数
     * @return
     * @throws Exception
     */
    public String HTTP_POST(String URL, Map<String, String> PARAMS) throws Exception {
        String paramStr = getParamStr(PARAMS);
        String result = HTTP_POST(URL, paramStr);
        return result;
    }

    /**
     * 主动发起HTTP的POST请求
     *
     * @param URL          请求路径
     * @param PARAMS       请求参数
     * @param CONTENT_TYPE 报文类型
     * @return 请求结果
     * @throws Exception 请求失败
     */
    public String HTTP_POST(String URL, String PARAMS, String CONTENT_TYPE) throws Exception {
        String result = HTTP_POST(URL, PARAMS, CONTENT_TYPE, null);
        return result;
    }

    /**
     * 主动发起HTTP的POST请求
     *
     * @param URL          请求路径
     * @param PARAMS       请求参数
     * @param CONTENT_TYPE 报文类型
     * @return
     */
    public String HTTP_POST(String URL, JSONObject PARAMS, String CONTENT_TYPE) throws Exception {
        String result = HTTP_POST(URL, PARAMS.toJSONString(), CONTENT_TYPE);
        return result;
    }

    /**
     * 主动发起HTTP的POST请求
     *
     * @param URL          请求路径
     * @param PARAMS       请求参数
     * @param CONTENT_TYPE 报文类型
     * @return
     */
    public String HTTP_POST(String URL, Map<String, String> PARAMS, String CONTENT_TYPE) throws Exception {
        String paramStr = getParamStr(PARAMS);
        String result = HTTP_POST(URL, paramStr, CONTENT_TYPE);
        return result;
    }

    /**
     * 主动发起HTTP的POST请求
     *
     * @param URL          请求路径
     * @param PARAMS       请求参数
     * @param CONTENT_TYPE 报文类型
     * @param HEADERS      请求头设置
     * @return 请求结果
     * @throws Exception 请求失败
     */
    public String HTTP_POST(String URL, String PARAMS, String CONTENT_TYPE, Map<String, String> HEADERS) throws Exception {
        HttpResponse response = HTTP_POST_ORIGINAL(URL, PARAMS, CONTENT_TYPE, HEADERS);
        HttpEntity resEntity = response.getEntity();
        String result = EntityUtils.toString(resEntity, CHARSET);
        return result;
    }

    /**
     * 主动发起HTTP的POST请求
     *
     * @param URL
     * @param PARAMS
     * @param CONTENT_TYPE
     * @param HEADERS
     * @return
     * @throws Exception
     */
    public HttpResponse HTTP_POST_ORIGINAL(String URL, String PARAMS, String CONTENT_TYPE, Map<String, String> HEADERS) throws Exception {
        httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(URL);
        httpPost.setConfig(getDefaultRequestConfig());
        if (CONTENT_TYPE != null && !CONTENT_TYPE.isEmpty()) {
            httpPost.setHeader(HttpUtils.CONTENT_TYPE, CONTENT_TYPE);
        }
        if (HEADERS != null && HEADERS.size() > 0) {
            for (Map.Entry<String, String> entry : HEADERS.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        if (PARAMS != null && PARAMS.length() > 0) {
            StringEntity entity = new StringEntity(PARAMS, CHARSET);
            httpPost.setEntity(entity);
        }
        HttpResponse response = httpClient.execute(httpPost);
        return response;
    }

    /**
     * 主动发起HTTP的POST请求
     *
     * @param URL          请求路径
     * @param PARAMS       请求参数
     * @param CONTENT_TYPE 报文类型
     * @param HEADERS      请求头设置
     * @return 请求结果
     * @throws Exception 请求失败
     */
    public String HTTP_POST(String URL, JSONObject PARAMS, String CONTENT_TYPE, Map<String, String> HEADERS) throws Exception {
        String result = HTTP_POST(URL, PARAMS.toJSONString(), CONTENT_TYPE, HEADERS);
        return result;
    }

    /**
     * 主动发起HTTP的POST请求
     *
     * @param URL          请求路径
     * @param PARAMS       请求参数
     * @param CONTENT_TYPE 报文类型
     * @param HEADERS      请求头设置
     * @return 请求结果
     * @throws Exception 请求失败
     */
    public String HTTP_POST(String URL, Map<String, String> PARAMS, String CONTENT_TYPE, Map<String, String> HEADERS) throws Exception {
        String paramStr = getParamStr(PARAMS);
        String result = HTTP_POST(URL, paramStr, CONTENT_TYPE, HEADERS);
        return result;
    }

    /**
     * 原生方法发起HTTP请求
     *
     * @param URL            请求路径
     * @param REQUEST_METHOD 请求方式 POST/GET
     * @param PARAMS         请求参数
     * @param CONTENT_TYPE   报文类型
     * @return
     * @throws Exception
     */
    public String HTTP_ORIGINAL(String URL, String REQUEST_METHOD, String PARAMS, String CONTENT_TYPE) throws Exception {
        BufferedReader In = null;
        PrintWriter Out = null;
        HttpURLConnection HttpConn = null;
        try {
            URL url = new URL(URL);
            HttpConn = (HttpURLConnection) url.openConnection();
            HttpConn.setRequestMethod(REQUEST_METHOD);
            HttpConn.setRequestProperty(CONTENT_TYPE, CONTENT_TYPE);
            HttpConn.setDoInput(true);
            HttpConn.setDoOutput(true);

            Out = new PrintWriter(HttpConn.getOutputStream());
            Out.println(PARAMS);
            Out.flush();

            if (HttpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                StringBuffer content = new StringBuffer();
                String tempStr = "";
                In = new BufferedReader(new InputStreamReader(HttpConn.getInputStream()));
                while ((tempStr = In.readLine()) != null) {
                    content.append(tempStr);
                }
                In.close();
                return content.toString();
            } else {
                throw new Exception("HTTP_POST_ERROR_RETURN_STATUS：" + HttpConn.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Out.close();
            HttpConn.disconnect();
        }
        return null;
    }

    private String getParamStr(Map<String, String> PARAMS) {
        StringBuilder stringBuilder = new StringBuilder();
        if (PARAMS != null && PARAMS.size() > 0) {
            for (Map.Entry<String, String> entry : PARAMS.entrySet()) {
                stringBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        String paramStr = stringBuilder.toString();
        return paramStr;
    }

}
