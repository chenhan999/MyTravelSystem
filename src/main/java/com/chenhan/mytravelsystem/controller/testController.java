package com.chenhan.mytravelsystem.controller;

import com.chenhan.mytravelsystem.model.HotelModel;
import com.chenhan.mytravelsystem.model.NiceSubmitModel;
import com.chenhan.mytravelsystem.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author Han HA Chen
 * @Date 27/04/2021 15:41
 **/

@Controller
public class testController {


    @Autowired
    HotelService hotelService;

    @GetMapping("test")
    public String index() {
        return "index";
    }


    @PostMapping(value = "ajaxtest" ,produces ="text/html; charset=UTF-8")
    @ResponseBody
    public String test(NiceSubmitModel niceSubmitModel) throws UnsupportedEncodingException {

        StringBuffer stringBuffer = new StringBuffer();

        //拼接行程一
        String[] split = niceSubmitModel.getHotelOne().split(";");
        stringBuffer.append("出发时间：").append(niceSubmitModel.getDepartureTime());
        stringBuffer.append("<br>").append("游客数量：").append(niceSubmitModel.getMaxTouristNum());
        stringBuffer.append("<br>").append("房：<br>   ").append(split[0]).append("  ").append(split[1]).append("    ").append(split[3]).append("元/间").append("*").append(niceSubmitModel.getHotelOneNum()).append("晚     ").append(split[4]);

        //拼接行程二

        String[] split2 = niceSubmitModel.getHotelTwo().split(";");
        stringBuffer.append("<br>").append("       ").append(split2[0]).append("  ").append(split2[1]).append("    ").append(split2[3]).append("元/间").append("*").append(niceSubmitModel.getHotelTwoNum()).append("晚     ").append(split[4]);

        //拼接行程三

        String[] split3 = niceSubmitModel.getHotelThree().split(";");
        stringBuffer.append("<br>").append("       ").append(split3[0]).append("  ").append(split3[1]).append("    ").append(split3[3]).append("元/间").append("*").append(niceSubmitModel.getHotelThreeNum()).append("晚     ").append(split[4]);



        //拼接 车费





        String result = URLDecoder.decode(stringBuffer.toString(), "UTF-8");
        System.out.println(result);
        return result;
    }

    @PostMapping("getHotelName")
    @ResponseBody
    public List<String> getHotelName(String name) {
        List<HotelModel> hotelInfoByName = hotelService.getHotelInfoByName();
        ArrayList<String> strings = new ArrayList<>();
        for (HotelModel hotelModel : hotelInfoByName) {
            strings.add(hotelModel.getRegion() + ";" +hotelModel.getHotelName()+";" +hotelModel.getPrice() + ";" +hotelModel.getPriceNum() + ";"+hotelModel.getComment());
        }
        return strings;
    }


}
