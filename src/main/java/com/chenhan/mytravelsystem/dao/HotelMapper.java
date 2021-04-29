package com.chenhan.mytravelsystem.dao;

import com.chenhan.mytravelsystem.model.HotelModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HotelMapper {


    /**
     * 根据酒店名称查询
     * @return
     */
    List<HotelModel> getHotelInfoByName();

}
