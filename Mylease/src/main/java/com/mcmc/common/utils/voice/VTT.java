package com.mcmc.common.utils.voice;

import com.baidu.aip.speech.AipSpeech;
import org.json.JSONObject;


/**
 * @author: software-liuwang
 * @time: 2017/11/17 21:28
 * @description : 语音转换成文字 - 语音需为amr格式且小于1MB
 */
public class VTT {

    //设置APPID/AK/SK
    public static final String APP_ID = "10376136";
    public static final String API_KEY = "ieRNkanfPsDxjqvDLCgrRsMT";
    public static final String SECRET_KEY = "4c3240710864ee8b34631667dcc9a10a";


    public static JSONObject vtt(byte[] data) {

        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);



        // 调用接口
        JSONObject res = null;
            res = client.asr(data, "amr", 8000, null);

        return res;

    }

}
