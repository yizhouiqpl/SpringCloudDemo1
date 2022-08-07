package cn.yizhouiqpl.dao;

import cn.yizhouiqpl.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//@Mapper  //import org.apache.ibatis.annotations.Mapper;
public interface PaymentDao {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}