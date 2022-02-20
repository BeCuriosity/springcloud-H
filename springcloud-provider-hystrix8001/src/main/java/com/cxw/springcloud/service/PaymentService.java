package com.cxw.springcloud.service;

import com.cxw.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentService
 * @Author xuwen_chen
 * @Date 2022-02-17 1:32
 * @Version 1.0
 */
public interface PaymentService {

     Payment getById(@Param("id") Long id);


     String isNotOK(@Param("id") Long id);

     String isOk(@Param("id") Long id);
}
