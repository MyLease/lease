package com.mcmc.controller.location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import com.mcmc.common.utils.location.ListIp;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by wangyongkang on 2017/11/18.
 */
@Controller
@RequestMapping("/Place")
public class GetPlaceByIp {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    public  JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject();
            json.put("This user's goods:", jsonText);
            return json;

    }
@RequestMapping("/getPlace")
@ResponseBody
    public JSONObject getPlace(HttpSession session, HttpServletResponse response) throws IOException, JSONException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        //获取外网ip
        ListIp listIp=new ListIp();
        String ip=listIp.getV4IP();
        //这里调用百度的ip定位api服务 详见 http://api.map.baidu.com/lbsapi/cloud/ip-location-api.htm
        JSONObject json = readJsonFromUrl("http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip="+ip);
        System.out.println("11"+json);
        return json;
        //System.out.println(json.toString());
        //System.out.println("22"+((JSONObject) json.get("content")).get("address"));
    }
}
