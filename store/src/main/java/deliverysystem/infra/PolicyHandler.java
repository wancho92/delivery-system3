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
    @Autowired CookRepository cookRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderPlaced'")
    public void wheneverOrderPlaced_RegisterOrder(@Payload OrderPlaced orderPlaced){

        OrderPlaced event = orderPlaced;
        System.out.println("\n\n##### listener RegisterOrder : " + orderPlaced + "\n\n");


        

        // Sample Logic //
        Cook.registerOrder(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayAccepted'")
    public void wheneverPayAccepted_UpdateStatus(@Payload PayAccepted payAccepted){

        PayAccepted event = payAccepted;
        System.out.println("\n\n##### listener UpdateStatus : " + payAccepted + "\n\n");


        

        // Sample Logic //
        Cook.updateStatus(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='PayCanceled'")
    public void wheneverPayCanceled_UpdateStatus(@Payload PayCanceled payCanceled){

        PayCanceled event = payCanceled;
        System.out.println("\n\n##### listener UpdateStatus : " + payCanceled + "\n\n");


        

        // Sample Logic //
        Cook.updateStatus(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='OrderAddRequested'")
    public void wheneverOrderAddRequested_UpdateRequest(@Payload OrderAddRequested orderAddRequested){

        OrderAddRequested event = orderAddRequested;
        System.out.println("\n\n##### listener UpdateRequest : " + orderAddRequested + "\n\n");


        

        // Sample Logic //
        Cook.updateRequest(event);
        

        

    }

}


