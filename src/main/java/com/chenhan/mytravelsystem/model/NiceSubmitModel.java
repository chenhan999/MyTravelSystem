package com.chenhan.mytravelsystem.model;

import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @Author Han HA Chen
 * @Date 29/04/2021 13:25
 **/
@Data
public class NiceSubmitModel {



    //出行时间
    private String departureTime;

    //最多游客数量
    private int maxTouristNum;

    //最少游客数量
    private int minTouristNum;

    //hotelList
    private List<String> list;

    //Hotel Day Num
    private List<String> dayNumList;


}
