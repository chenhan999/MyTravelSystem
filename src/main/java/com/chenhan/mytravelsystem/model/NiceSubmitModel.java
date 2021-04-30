package com.chenhan.mytravelsystem.model;

import lombok.Data;

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



    //行程段 酒店信息
    private String hotelOne;

    private String hotelTwo;

    private String hotelThree;

    //行程段天数
    private int hotelOneNum;

    private int hotelTwoNum;

    private int hotelThreeNum;


}
