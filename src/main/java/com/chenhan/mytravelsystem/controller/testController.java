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


    @PostMapping("ajaxtest")
    @ResponseBody
    public String test(NiceSubmitModel niceSubmitModel) {

        System.out.println("test");
        return "index";
    }

    @PostMapping("getHotelName")
    @ResponseBody
    public List<String> getHotelName(String name) {
        List<HotelModel> hotelInfoByName = hotelService.getHotelInfoByName();
        ArrayList<String> strings = new ArrayList<>();
        for (HotelModel hotelModel : hotelInfoByName) {
            strings.add(hotelModel.getRegion() + "," +hotelModel.getHotelName()+"," +hotelModel.getPrice() + "," +hotelModel.getComment());
        }
        return strings;
    }


}
