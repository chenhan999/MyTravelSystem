package com.chenhan.mytravelsystem.model;

import lombok.Data;

/**
 * @Description:
 * @Author Han HA Chen
 * @Date 29/04/2021 14:18
 **/
@Data
public class HotelModel {

    private int id ;

    private String region;

    private String hotelName ;

    private String price;

    private String time;

    private String comment;

    private int priceNum;



}
