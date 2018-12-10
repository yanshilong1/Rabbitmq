package Rabbirmq2;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yanshilong
 * @Date: 18-12-10 下午1:24
 * @Version 1.0
 */
public class MsgCustomer {
    public static void consumerMsg(String exchange, final String queue, String routingKey)
            throws IOException, TimeoutException {
        ConnectionFactory factory = RabbitUtil.getfactory();
        //创建连接
        Connection connection = factory.newConnection();

        //创建消息信道
        final Channel channel = connection.createChannel();

        //消息队列
        channel.queueDeclare(queue, true, false, false, null);
        //绑定队列到交换机
        channel.queueBind(queue, exchange, routingKey);
        System.out.println("[*] Waiting for message. To exist press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
                                       byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                try {
                    System.out.println(queue +"  Received '" + message);
                } finally {
                    System.out.println(queue+"  Done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        };

        // 取消自动ack
        channel.basicConsume(queue, false, consumer);
    }


}
