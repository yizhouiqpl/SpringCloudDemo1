package cn.yizhouiqpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @BelongsProject: SpringCloudDemo1
 * @BelongsPackage: cn.yizhouiqpl.controller
 * @Author: huangyufeng
 * @CreateTime: 2022-08-14 12:34
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("consumer/payment")
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("zk")
    public String paymentInfo() {
        String result = restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
        System.out.println("消费者调用支付服务（zookeeper）---> result:" + result);
        return result;
    }
}
