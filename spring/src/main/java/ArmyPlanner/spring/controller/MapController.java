package ArmyPlanner.spring.controller;

import ArmyPlanner.spring.Dto.LikedPlaceDto;
import ArmyPlanner.spring.domain.LikedPlace;
import ArmyPlanner.spring.domain.Member;
import ArmyPlanner.spring.repository.MemberRepository;
import ArmyPlanner.spring.service.LikedPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;

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
        String serviceKey = "*";
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
        String serviceKey = "*";
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
        String serviceKey = "*";
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

    @GetMapping("armyPreferentialplaceView/getPocheonApi/{count}")
    @ResponseBody
    public String getPocheonApi(@PathVariable String count) throws IOException {

        String baseurl = "https://api.odcloud.kr/";
        String service = "api/15106202/v1/uddi:d6cc329d-8ac0-4471-b958-e9912dfade8f";
        String serviceKey = "*";
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

    @GetMapping("armyPreferentialplaceView/getNonsanApi/{count}")
    @ResponseBody
    public String getNonsanApi(@PathVariable String count) throws IOException {

        String baseurl = "https://api.odcloud.kr/";
        String service = "api/3073444/v1/uddi:2ba183cb-e8eb-44b7-9964-a5e09e0655bb_202004010952";
        String serviceKey = "*";
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

    @GetMapping("armyPreferentialplaceView/getYeongcheonApi/{count}")
    @ResponseBody
    public String getYeongcheonApi(@PathVariable String count) throws IOException {

        String baseurl = "https://api.odcloud.kr/";
        String service = "api/15044647/v1/uddi:c0773d85-712c-413f-a37a-ee6adf13bce3";
        String serviceKey = "*";
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

    @GetMapping("armyPreferentialplaceView/getChangwonApi/{count}")
    @ResponseBody
    public String getChangwonApi(@PathVariable String count) throws IOException {

        String baseurl = "https://api.odcloud.kr/";
        String service = "api/15055435/v1/uddi:6f90b74d-5f2e-4646-a9e6-8dee13833e46";
        String serviceKey = "*";
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

    private final LikedPlaceService likedPlaceService;
    private final MemberRepository memberRepository;

    @PostMapping(value = "place_like")
    @ResponseBody
    public void place_like(@RequestBody LikedPlaceDto likedPlaceDto, Principal principal) throws Exception {

        String title = likedPlaceDto.getTitle();
        String roadAddressName = likedPlaceDto.getRoadAddressName();
        String x = likedPlaceDto.getX();
        String y = likedPlaceDto.getY();

        String username = principal.getName();
        Member member = memberRepository.findByEmail(username);

        LikedPlace likedPlace = LikedPlaceDto.builder()
                .title(title)
                .roadAddressName(roadAddressName)
                .x(x)
                .y(y)
                .member(member)
                .build().toEntity();

        likedPlaceService.saveLikedPlace(likedPlace);
    }

}
