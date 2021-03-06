package Rabbirmq2;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yanshilong
 * @Date: 18-12-10 下午1:18
 * @Version 1.0
 */
public class MagProducer {
    public static void publishMsg(String exchange, BuiltinExchangeType exchangeType, String toutingKey, String message)
            throws IOException, TimeoutException {
        ConnectionFactory factory = RabbitUtil.getfactory();

        //创建连接
        Connection connection = factory.newConnection();

        //创建消息通道
        Channel channel = connection.createChannel();

        // 声明exchange中的消息为可持久化，不自动删除
        channel.exchangeDeclare(exchange, exchangeType, true, false, null);

        // 发布消息
        channel.basicPublish(exchange, toutingKey, null, message.getBytes());

        channel.close();
        connection.close();
    }


}
