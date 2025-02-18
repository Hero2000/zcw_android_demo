package com.xiangxue.network.commoninterceptor;

import com.xiangxue.network.base.INetworkRequiredInfo;
import com.xiangxue.network.utils.TecentUtil;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CommonRequestInterceptor implements Interceptor {
    private final INetworkRequiredInfo requiredInfo;
    public CommonRequestInterceptor(INetworkRequiredInfo requiredInfo){
        this.requiredInfo = requiredInfo;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        //builder.cacheControl(CacheControl.FORCE_CACHE);
        builder.addHeader("os", "android");
        builder.addHeader("appVersion",this.requiredInfo.getAppVersionCode());
        return chain.proceed(builder.build());
    }
}
