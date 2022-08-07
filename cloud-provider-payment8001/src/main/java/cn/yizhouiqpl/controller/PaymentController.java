package cn.yizhouiqpl.controller;

import cn.yizhouiqpl.entities.CommonResult;
import cn.yizhouiqpl.entities.Payment;
import cn.yizhouiqpl.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("create")
    public CommonResult<Object> create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("插入操作返回的结果：{}", i);
        if (i > 0) {
            return new CommonResult<>(200, "插入数据库成功", i);
        } else {
            return new CommonResult<>(444, "插入数据库失败", null);
        }
    }

    @GetMapping("get/{id}")
    public CommonResult<Object> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：{}", payment);
        if (Objects.isNull(payment))
            return new CommonResult<>(444, "没有对应记录，查询ID：" + id, null);
        return new CommonResult<>(200, "查询成功", payment);
    }

}
