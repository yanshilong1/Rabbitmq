package Rabbirmq2;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: yanshilong
 * @Date: 18-12-10 下午1:16
 * @Version 1.0
 */
public class RabbitUtil {
    public static ConnectionFactory getfactory(){
        ConnectionFactory factory=new ConnectionFactory();//设置参数
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("test");
        factory.setPassword("123");
        factory.setVirtualHost("/");
        return factory;
    }
}
