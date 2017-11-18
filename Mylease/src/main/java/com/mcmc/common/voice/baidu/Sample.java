package com.mcmc.common.voice.baidu;

import com.baidu.aip.speech.AipSpeech;
import org.json.JSONObject;

/**
 * @author: software-liuwang
 * @time: 2017/11/17 20:12
 * @description :
 */
public class Sample {

    //设置APPID/AK/SK
    public static final String APP_ID = "10376136";
    public static final String API_KEY = "ieRNkanfPsDxjqvDLCgrRsMT";
    public static final String SECRET_KEY = "4c3240710864ee8b34631667dcc9a10a";

    public static void main(String[] args) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        JSONObject res = client.asr("D:\\workspace\\project\\lease\\voice\\REC004.amr", "amr", 8000, null);
        System.out.println(res);

    }

}
