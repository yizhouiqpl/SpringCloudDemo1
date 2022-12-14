package cn.yizhouiqpl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("zk")
    public String paymentzk() {
        System.out.println("8004...");
        return "SpringCloud with zookeeper:" + serverPort + "\t" + UUID.randomUUID();
    }
}
