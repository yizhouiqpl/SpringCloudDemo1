package cn.yizhouiqpl.controller;

import cn.yizhouiqpl.entities.CommonResult;
import cn.yizhouiqpl.entities.Payment;
import cn.yizhouiqpl.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("create")
    public CommonResult<Object> create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("插入操作返回的结果：{}", i);
        if (i > 0) {
            return new CommonResult<>(200, "插入数据库成功，返回结果" + i + "\t服务端口：" + serverPort, payment);
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
        return new CommonResult<>(200, "查询成功，服务端口：" + serverPort, payment);
    }

    @GetMapping(value = "discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
