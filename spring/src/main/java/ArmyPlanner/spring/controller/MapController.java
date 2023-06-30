package ArmyPlanner.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@RequiredArgsConstructor
@RequestMapping("/map")
public class MapController {

    @GetMapping("searchView")
    public String searchView(){
        return "map/searchView";
    }

    @GetMapping("armyFacilityView")
    public String armyFacilityView(){
        return "map/map_armyFacilityView";
    }

    @GetMapping("armyFacilityView/getArmyFacilityApi/{start}/{end}")
    @ResponseBody
    public String getArmyFacilityApi(@PathVariable Long start, @PathVariable Long end) throws IOException {
        String serviceKey = "3733313631313630353532323832313332";
        String resultType = "json";
        String service = "DS_WHLAM_WLFR_VCTNINSTLT";
        String string_url = "https://openapi.mnd.go.kr/" + serviceKey + "/" + resultType + "/" + service + "/" + start + "/" + end;
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

    @GetMapping("armyHospitalView")
    public String armyHospitalView(){
        return "map/map_armyHospitalView";
    }

    @GetMapping("armyHospitalView/getArmyHospitalApi/{start}/{end}")
    @ResponseBody
    public String getArmyHospitalApi(@PathVariable Long start, @PathVariable Long end) throws IOException {
        String serviceKey = "3733313631313630353532323832313332";
        String resultType = "json";
        String service = "DS_WHLNAT_ROKAHSPT_ADDR";
        String string_url = "https://openapi.mnd.go.kr/" + serviceKey + "/" + resultType + "/" + service + "/" + start + "/" + end;
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

    @GetMapping("armyTmoView")
    public String armyTmoView(){
        return "map/map_armyTmoView";
    }

    @GetMapping("armyTmoView/getArmyTmoApi/{start}/{end}")
    @ResponseBody
    public String getArmyTmoApi(@PathVariable Long start, @PathVariable Long end) throws IOException {
        String serviceKey = "3733313631313630353532323832313332";
        String resultType = "json";
        String service = "DS_TB_MND_TMO_INFO";
        String string_url = "https://openapi.mnd.go.kr/" + serviceKey + "/" + resultType + "/" + service + "/" + start + "/" + end;
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

    @GetMapping("armyPreferentialplaceView")
    public String armyPreferentialplaceView(){
        return "map/map_armyPreferentialplaceView";
    }

    @GetMapping("armyPreferentialplaceView/getArmyPreferentialplaceApi/{count}")
    @ResponseBody
    public String getArmyPreferentialplaceApi(@PathVariable String count) throws IOException {

        String baseurl = "https://api.odcloud.kr/";
        String service = "api/15106202/v1/uddi:d6cc329d-8ac0-4471-b958-e9912dfade8f";
        String serviceKey = "YfVszWFGgZBtStWJ429k2RIkV3b1vpS4obo/KLxcU15enrSNaCvSNO3TLZKnGjaAfL3trm9jk6X7jFG86kpm6Q==";
        String page = "1";
        String perPage = count;
        String string_url = baseurl + service + "?" + "page=" + page + "&" + "perPage=" + perPage + "&"
                + "serviceKey=" + serviceKey;
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
