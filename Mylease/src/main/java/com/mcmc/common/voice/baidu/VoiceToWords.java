package com.mcmc.common.voice.baidu;

import com.mcmc.common.utils.voice.FileToByte;
import com.mcmc.common.utils.voice.VTT;
import org.json.JSONObject;

import java.io.File;

/**
 * @author: software-liuwang
 * @time: 2017/11/17 20:12
 * @description :
 */
public class VoiceToWords {

    public static void main(String[] args) {
        File file = new File("D:\\workspace\\project\\lease\\voice\\REC004.amr");
        byte[] data = FileToByte.getFileToByte(file);

        JSONObject json = VTT.vtt(data);

        System.out.println(json);

    }

}
