package Rabbirmq2;

import com.rabbitmq.client.BuiltinExchangeType;

import javax.xml.crypto.Data;

/**
 * @Author: yanshilong
 * @Date: 18-12-10 下午1:27
 * @Version 1.0
 */
public class DirectProducer {
    public static final String EXCHANGE_NAME="direct_exchange";
    public  void publishMsg(String rotingKey,String msg){

            try {
                MagProducer.publishMsg(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, rotingKey, msg);
            } catch (Exception e) {
                e.printStackTrace();
            }
            }

    public static void main(String[] args) {
        DirectProducer directProducer=new DirectProducer();
        String [] rotingKey=new String[]{"aaa","bbb"};

        String msg=" hello ";
         for (int i=0;i<30;i++){
             directProducer.publishMsg(rotingKey[i%2],msg+i);
             System.out.println(msg+i);
         }
        System.out.println("生产者结束-----------");
    }

//    private static final String EXCHANGE_NAME = "fanout.exchange";
//
//    public void publishMsg(String routingKey, String msg) {
//        try {
//            MagProducer.publishMsg(EXCHANGE_NAME, BuiltinExchangeType.FANOUT, routingKey, msg);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        FanoutProducer directProducer = new FanoutProducer();
//        String[] routingKey = new String[]{"aaa", "bbb"};
//        String msg = "hello >>> ";
//
//
//        for (int i = 0; i < 30; i++) {
//            directProducer.publishMsg(routingKey[i % 2], msg + i);
//        }
//        System.out.println("----over-------");
//    }

}
