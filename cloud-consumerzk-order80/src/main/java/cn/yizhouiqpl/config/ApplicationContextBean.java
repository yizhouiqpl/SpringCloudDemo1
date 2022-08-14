package cn.yizhouiqpl.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @BelongsProject: SpringCloudDemo1
 * @BelongsPackage: cn.yizhouiqpl.config
 * @Author: huangyufeng
 * @CreateTime: 2022-08-14 12:32
 * @Description: TODO
 * @Version: 1.0
 */
@Configuration
public class ApplicationContextBean {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
