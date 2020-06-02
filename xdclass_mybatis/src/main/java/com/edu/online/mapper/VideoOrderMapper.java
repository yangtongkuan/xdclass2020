package com.edu.online.mapper;

import com.edu.online.domain.User;
import com.edu.online.domain.VideoOrder;

import java.util.List;

/**
 * video mapper 订单
 */
public interface VideoOrderMapper {

    /**
     * 查询全部订单，关联用户信息
     *
     * @return
     */
    List<VideoOrder> queryVideoOrderList();

    /**
     * 查询所有用户的对应的订单信息
     * 一对多关联 collection 映射应用
     *
     * @return
     */
    List<User> queryUserOrderList();
}
