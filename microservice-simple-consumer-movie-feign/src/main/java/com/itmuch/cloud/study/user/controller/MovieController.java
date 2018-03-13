package com.itmuch.cloud.study.user.controller;

import com.itmuch.cloud.study.user.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.study.user.entity.User;

@RestController
public class MovieController {

  private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserFeignClient userFeignClient;

  @Autowired
  private LoadBalancerClient loadBalancerClient;

//  @GetMapping("/user/{id}")
//  public User findById(@PathVariable Long id) {
//      //当 Ribbon 和 Eureka 配合使用时，会自动将虚拟主机名映射成微服务的网络地址
//    return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
//  }

  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) {
    //当 Ribbon 和 Eureka 配合使用时，会自动将虚拟主机名映射成微服务的网络地址
    return this.userFeignClient.findById(id);
  }


  @GetMapping("/log-user-instance")
  public void logUserInstance() {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
    // 打印当前选择的是哪个节点
    MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
  }
}
