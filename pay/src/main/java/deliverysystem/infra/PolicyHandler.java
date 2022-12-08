package deliverysystem.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import deliverysystem.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import deliverysystem.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired PayRepository payRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderCanceled'")
    public void wheneverOrderCanceled_CancelPay(@Payload OrderCanceled orderCanceled){
        OrderCanceled event = orderCanceled;
        System.out.println("\n\n##### listener CancelPay : " + orderCanceled + "\n\n");

        // Sample Logic //
        Pay.cancelPay(event);
    }

}


