package cn.yizhouiqpl.service.impl;

import cn.yizhouiqpl.dao.PaymentDao;
import cn.yizhouiqpl.entities.Payment;
import cn.yizhouiqpl.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
