package com.bwei.lib_core.interceptor;


import com.blankj.utilcode.util.SPUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();//请求对象，原始请求对象，用户名密码

        Request.Builder builder = request.newBuilder();
        //
        builder.addHeader("userId", SPUtils.getInstance().getString("userId"));
        builder.addHeader("sessionId", SPUtils.getInstance().getString("sessionId"));
        Request newRequest = builder.build();//修改过的request对象

        Response response = chain.proceed(newRequest);//响应对象
        return response;
    }
}
