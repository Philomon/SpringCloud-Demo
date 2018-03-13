# SpringCloud-Demo

## 工程说明
<br />
”microservice-discovery-eureka-ha“  和 ”microservice-discovery-eureka“  为双节点服务注册发现中心
<br />
”microservice-simple-consumer-movie-feign“ 为采用feign，ribbon的服务消费者，调用用户服务提供者
<br />
”microservice-simple-provider-user","microservice-simple-provider-user2" 是两个不同端口模拟不同服务器的用户服务提供者，两个服务提供者可供测试ribbon的负载均衡
<br />

## 如何运行？
<br />

”microservice-discovery-eureka-ha“  和 ”microservice-discovery-eureka“ 为SpringCloud的服务注册中心，这里采用模拟双节点注册模式 
<br /><br />
在IDE导入两个工程后，执行”mvn clean package -Dmaven.test.skip=true“ 编译成功会生成项目根目录生成target目录，找到target目录下的jar包，在命令行中执行运行jar包的命令<br /><br />
成功执行之后。访问本机地址http://peer1:8761/ （在此之前需要在本机注册主机名pee1以及pee2）即可看到其中一个节点的注册中心
<br /><br />

同理，”microservice-simple-consumer-movie-feign“，”microservice-simple-provider-user","microservice-simple-provider-user2"
<br />按照上面方式运行，即可在http://peer1:8761/ （服务注册中心）列表中看到以上组件成功运行


