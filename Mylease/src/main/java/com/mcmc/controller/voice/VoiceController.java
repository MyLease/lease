package com.mcmc.controller.voice;

import com.mcmc.common.utils.voice.VTT;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author: software-liuwang
 * @time: 2017/11/17 21:34
 * @description :
 */
@Controller
@RequestMapping(value = "/VoiceController")
public class VoiceController {

    @RequestMapping(value = "voiceToText")
    @ResponseBody
    public JSONObject voiceToText(@RequestParam("data") byte[] data, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        JSONObject json = new JSONObject();

        json = VTT.vtt(data);

        return json;
    }

}
