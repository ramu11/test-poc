package io.fabric8.quickstarts.camel;
import org.apache.qpid.jms.JmsConnectionFactory;
import javax.jms.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.concurrent.CountDownLatch;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;
public class AmqpsslExample {
    
    
   // private static final broker_service_url = "amqps://ex-aao-ss-0.ex-aao-hdls-svc.new-message-project.svc.cluster.local:5672";
            
          
    
    JmsConnectionFactory activeMQConnectionFactory = new JmsConnectionFactory("k4YM6rob","x5AZ35Yk","amqps://ex-aao-ss-0.ex-aao-hdls-svc.new-message-project.svc.cluster.local:5672?" +
            "transport.trustStoreLocation=/home/jboss/client.ts&transport.keyStoreLocation=//home/jboss/broker.ks" +
            "&transport.trustStorePassword=artemis7&transport.keyStorePassword=artemis7&transport.verifyHost=false");

    public void amqpTest() throws Exception{

       
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        MessageProducer messageProducer = session.createProducer(session.createQueue("test_q"));
        Message message = session.createTextMessage("this is amqp two way ssl testing");
        messageProducer.send(message);
        connection.close();
    }
    
    public void amqpTestConsumer() throws Exception{

        
        Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        // Step 5. create a moving receiver, this means the message will be removed from the queue
        MessageConsumer consumer = session.createConsumer(session.createQueue("test_q"));

        // Step 7. receive the simple message
        TextMessage m = (TextMessage) consumer.receive(5000);
        System.out.println("message = " + m.getText());
        connection.close();
    }
    
    static {
        try {
            InputStream fis = AmqpsslExample.class.getClassLoader().getResourceAsStream("client.ts");
            InputStream fis2 = AmqpsslExample.class.getClassLoader().getResourceAsStream("broker.ks");
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            FileOutputStream fos = new FileOutputStream("/home/jboss/client.ts");
            fos.write(bytes);
            
            byte[] bytes2 = new byte[fis2.available()];
            fis2.read(bytes2);
            FileOutputStream fos2 = new FileOutputStream("/home/jboss/broker.ks");
            fos2.write(bytes2);
            
            fos.flush();
            fos.close();
            fis.close();
            
            fos2.flush();
            fos2.close();
            fis2.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
