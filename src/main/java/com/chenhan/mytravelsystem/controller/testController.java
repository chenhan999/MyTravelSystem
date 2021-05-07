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


    @PostMapping(value = "submit" ,produces ="text/html; charset=UTF-8")
    @ResponseBody
    public String test(NiceSubmitModel niceSubmitModel) throws UnsupportedEncodingException {

        if(niceSubmitModel.getMinTouristNum()>niceSubmitModel.getMaxTouristNum()){
            return "王雅君 @.@ 认真工作,你家最少人数比最多人数多蛮";
        }

        StringBuffer stringBuffer = new StringBuffer();

        List<String> dayNumList = niceSubmitModel.getDayNumList();

        stringBuffer.append("出发时间：").append(niceSubmitModel.getDepartureTime());
        stringBuffer.append("<br>").append("游客数量：").append(niceSubmitModel.getMinTouristNum()).append("~").append(niceSubmitModel.getMaxTouristNum());
        stringBuffer.append("<br>").append("房：<br>   ");
        List<String> list = niceSubmitModel.getList();
        for (int i = 0; i < list.size(); i++) {
            String hotleStr = list.get(i);
            String replace = hotleStr.replace("[" , "").replace("]" , "").replace("\"" , "");

            String dayNum = dayNumList.get(i);
            String numReplace = dayNum.replace("[" , "").replace("]" , "").replace("\"" , "");
            String[] split = replace.split(";");
            stringBuffer.append(split[0]).append(" &nbsp &nbsp &nbsp").append(split[1]).append(" &nbsp;&nbsp;&nbsp; ").append(split[3]).append("元/间&nbsp;&nbsp;").append("*&nbsp;&nbsp;").append(numReplace).append("晚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;").append(split[4]).append("<br>");
        }


        //拼接 车费





        String result = URLDecoder.decode(stringBuffer.toString(), "UTF-8");
        System.out.println(result);
        return result;
    }

    @PostMapping("getHotelName")
    @ResponseBody
    public List<String> getHotelName() {
        List<HotelModel> hotelInfoByName = hotelService.getHotelInfoByName();
        ArrayList<String> strings = new ArrayList<>();
        for (HotelModel hotelModel : hotelInfoByName) {
            strings.add(hotelModel.getRegion() + ";" +hotelModel.getHotelName()+";" +hotelModel.getPrice() + ";" +hotelModel.getPriceNum() + ";"+hotelModel.getComment());
        }
        return strings;
    }


}
