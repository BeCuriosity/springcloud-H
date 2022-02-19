package com.cxw.springcloud.dao;

import com.cxw.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentDao
 * @Author xuwen_chen
 * @Date 2022-02-17 1:08
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getById(@Param("id") Long id);
}
