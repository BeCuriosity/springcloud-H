package com.cxw.springcloud.dao;

import com.cxw.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName OrderDao
 * @Author xuwen_chen
 * @Date 2022-03-01 23:02
 * @Version 1.0
 */
@Mapper
public interface OrderDao {

    //下订单
    void create(Order order);

    //修改状态
    int update(@Param("userId") Long userId, @Param("status") Integer status);
}
