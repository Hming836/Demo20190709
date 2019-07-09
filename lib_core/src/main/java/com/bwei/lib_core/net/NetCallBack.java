package com.bwei.lib_core.net;

/**
 * @Auther :Hming
 * @Date : 2019/7/9  20:32
 * @Description: ${DESCRIPTION}
 */
public interface NetCallBack {

    void error(String msg);  //服务器请求失败：断网，服务器宕机等等因素

    void success(Object object);//数据合法

}
