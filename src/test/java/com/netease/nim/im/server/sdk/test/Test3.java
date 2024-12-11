package com.netease.nim.im.server.sdk.test;

import com.netease.nim.im.server.sdk.core.endpoint.*;
import com.netease.nim.im.server.sdk.core.trace.ApiVersion;
import com.netease.nim.im.server.sdk.core.YunxinApiHttpClient;

/**
 * Created by caojiajun on 2024/12/10
 */
public class Test3 {

    public static void main(String[] args) {
        // 初始化
        String appkey = "xx";
        String appsecret = "xx";
        int timeoutMillis = 5000;
        // EndpointSelector可以自定义
        EndpointSelector endpointSelector = new DynamicEndpointSelector(new DynamicEndpointFetcher(appkey, ApiVersion.V1));
        //
        YunxinApiHttpClient client = new YunxinApiHttpClient.Builder(appkey, appsecret)
                .timeoutMillis(timeoutMillis)
                .endpointSelector(endpointSelector)
                .build();

        //
    }
}
