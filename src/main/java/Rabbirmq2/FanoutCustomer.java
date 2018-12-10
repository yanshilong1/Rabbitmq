package Rabbirmq2;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: yanshilong
 * @Date: 18-12-10 下午1:54
 * @Version 1.0
 */
public class FanoutCustomer {

    private static final String EXCHANGE_NAME = "fanout.exchange";
    public void msgCustomer(String queueName,String routingkey){

        try {
            MsgCustomer.consumerMsg(EXCHANGE_NAME,queueName,routingkey);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        FanoutCustomer Customer=new FanoutCustomer();
        String []routoingkey=new String[]{"aaa","bbb"};
        String []quenename=new String[]{"qa","qb"};
        for(int i=0;i<1;i++){
          Customer.msgCustomer(quenename[i],routoingkey[i]);
        }

        try {
            Thread.sleep(1000*10*60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
