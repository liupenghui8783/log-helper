/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redick.example.httpclient;

import com.redick.support.httpclient.TraceIdHttpRequestInterceptor;
import com.redick.support.httpclient.TraceIdHttpResponseInterceptor;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * @author liupenghui
 *  2021/12/12 9:59 下午
 */
public class HttpClientUtil {

    private static final int CONNECT_TIMEOUT = 35000;

    private static final int CONNECTION_REQUEST_TIMEOUT = 35000;

    private static final int SOCKET_TIMEOUT = 60000;

    static CloseableHttpClient httpClient;

    static {
        httpClient = HttpClientBuilder
                .create()
                .addInterceptorFirst(new TraceIdHttpRequestInterceptor())
                .addInterceptorLast(new TraceIdHttpResponseInterceptor())
                .build();
    }

    public static String doGet(String url) {
        String result = "";
        // 为HttpClient添加拦截器TraceIdHttpClientInterceptor
        // 创建httpGet远程连接实例
        HttpGet httpGet = new HttpGet(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        // 为httpGet实例设置配置
        httpGet.setConfig(requestConfig);
        // 执行get请求得到返回对象
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            // 通过返回对象获取返回数据
            HttpEntity entity = response.getEntity();
            // 通过EntityUtils中的toString方法将结果转换为字符串
            result = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String doPost(String url, String param) {
        String result = "";
        // 为HttpClient添加拦截器TraceIdHttpClientInterceptor
        HttpPost httpPost = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(CONNECT_TIMEOUT)
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
                .setSocketTimeout(SOCKET_TIMEOUT)
                .build();
        httpPost.setConfig(requestConfig);
        StringEntity stringEntity = new StringEntity(param, "UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        httpPost.addHeader("Content-Type", "application/json");
        httpPost.setEntity(stringEntity);
        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            // 通过EntityUtils中的toString方法将结果转换为字符串
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
