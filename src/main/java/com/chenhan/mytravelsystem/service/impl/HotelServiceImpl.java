package com.chenhan.mytravelsystem.service.impl;

import com.chenhan.mytravelsystem.dao.HotelMapper;
import com.chenhan.mytravelsystem.model.HotelModel;
import com.chenhan.mytravelsystem.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author Han HA Chen
 * @Date 29/04/2021 14:31
 **/

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelMapper hotelMapper;

    @Override
    public List<HotelModel> getHotelInfoByName() {
        return hotelMapper.getHotelInfoByName();
    }
}
