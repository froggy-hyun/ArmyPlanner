package ArmyPlanner.spring.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Slf4j
@Controller
public class UserController {

    @GetMapping("/user/home")
    public String userHome() {
        return "userHome/userHome";
    }

    @GetMapping("user/getWeatherApi/{stnId}/{tmFc}")
    @ResponseBody
    public String getWeatherApi(@PathVariable String stnId, @PathVariable String tmFc) throws IOException {
        String baseurl = "http://apis.data.go.kr/";
        String service = "1360000/MidFcstInfoService/getMidFcst";
        String serviceKey = "YfVszWFGgZBtStWJ429k2RIkV3b1vpS4obo/KLxcU15enrSNaCvSNO3TLZKnGjaAfL3trm9jk6X7jFG86kpm6Q==";
        String pageNo = "1";
        String dataType = "json";
        String string_url = baseurl + service + "?" + "serviceKey=" + serviceKey + "&" + "pageNo=" + pageNo + "&"
                + "dataType=" + dataType + "&" + "stnId=" + stnId + "&" + "tmFc=" + tmFc;
        URL url = new URL(string_url);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        BufferedReader rd;

        // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        return sb.toString();
    }
}
