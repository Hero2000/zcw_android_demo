package com.xiangxue.network.base;

import android.app.Application;

/**
 
 * 保留所有版权，未经允许请不要分享到互联网和其他人
 */
public interface INetworkRequiredInfo {
    String getAppVersionName();
    String getAppVersionCode();
    boolean isDebug();
    Application getApplicationContext();
}
