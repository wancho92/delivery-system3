package deliverysystem.infra;

import deliverysystem.domain.*;
import deliverysystem.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDashboardViewHandler {

    @Autowired
    private OrderDashboardRepository orderDashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            OrderDashboard orderDashboard = new OrderDashboard();
            // view 객체에 이벤트의 Value 를 set 함
            orderDashboard.setId(orderPlaced.getId());
            orderDashboard.setStatus("주문됨");
            // view 레파지 토리에 save
            orderDashboardRepository.save(orderDashboard);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayAccepted_then_UPDATE_1(@Payload PayAccepted payAccepted) {
        try {
            if (!payAccepted.validate()) return;
                // view 객체 조회
            Optional<OrderDashboard> orderDashboardOptional = orderDashboardRepository.findById(payAccepted.getOrderId());

            if( orderDashboardOptional.isPresent()) {
                 OrderDashboard orderDashboard = orderDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDashboard.setStatus("결재됨");    
                // view 레파지 토리에 save
                 orderDashboardRepository.save(orderDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPayCanceled_then_UPDATE_2(@Payload PayCanceled payCanceled) {
        try {
            if (!payCanceled.validate()) return;
                // view 객체 조회
            Optional<OrderDashboard> orderDashboardOptional = orderDashboardRepository.findById(payCanceled.getOrderId());

            if( orderDashboardOptional.isPresent()) {
                 OrderDashboard orderDashboard = orderDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDashboard.setStatus("결재취소됨");    
                // view 레파지 토리에 save
                 orderDashboardRepository.save(orderDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookAccepted_then_UPDATE_3(@Payload CookAccepted cookAccepted) {
        try {
            if (!cookAccepted.validate()) return;
                // view 객체 조회
            Optional<OrderDashboard> orderDashboardOptional = orderDashboardRepository.findById(cookAccepted.getOrderId());

            if( orderDashboardOptional.isPresent()) {
                 OrderDashboard orderDashboard = orderDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDashboard.setStatus("주문승인됨");    
                // view 레파지 토리에 save
                 orderDashboardRepository.save(orderDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookCanceled_then_UPDATE_4(@Payload CookCanceled cookCanceled) {
        try {
            if (!cookCanceled.validate()) return;
                // view 객체 조회
            Optional<OrderDashboard> orderDashboardOptional = orderDashboardRepository.findById(cookCanceled.getOrderId());

            if( orderDashboardOptional.isPresent()) {
                 OrderDashboard orderDashboard = orderDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDashboard.setStatus("주문취소됨");    
                // view 레파지 토리에 save
                 orderDashboardRepository.save(orderDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryPicked_then_UPDATE_5(@Payload DeliveryPicked deliveryPicked) {
        try {
            if (!deliveryPicked.validate()) return;
                // view 객체 조회
            Optional<OrderDashboard> orderDashboardOptional = orderDashboardRepository.findById(deliveryPicked.getOrderId());

            if( orderDashboardOptional.isPresent()) {
                 OrderDashboard orderDashboard = orderDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDashboard.setStatus("배달시작됨");    
                // view 레파지 토리에 save
                 orderDashboardRepository.save(orderDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryAccepted_then_UPDATE_6(@Payload DeliveryAccepted deliveryAccepted) {
        try {
            if (!deliveryAccepted.validate()) return;
                // view 객체 조회
            Optional<OrderDashboard> orderDashboardOptional = orderDashboardRepository.findById(deliveryAccepted.getOrderId());

            if( orderDashboardOptional.isPresent()) {
                 OrderDashboard orderDashboard = orderDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDashboard.setStatus("배달완료됨");    
                // view 레파지 토리에 save
                 orderDashboardRepository.save(orderDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_7(@Payload CookStarted cookStarted) {
        try {
            if (!cookStarted.validate()) return;
                // view 객체 조회
            Optional<OrderDashboard> orderDashboardOptional = orderDashboardRepository.findById(cookStarted.getOrderId());

            if( orderDashboardOptional.isPresent()) {
                 OrderDashboard orderDashboard = orderDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                // view 레파지 토리에 save
                 orderDashboardRepository.save(orderDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_8(@Payload CookFinished cookFinished) {
        try {
            if (!cookFinished.validate()) return;
                // view 객체 조회
            Optional<OrderDashboard> orderDashboardOptional = orderDashboardRepository.findById(cookFinished.getOrderId());

            if( orderDashboardOptional.isPresent()) {
                 OrderDashboard orderDashboard = orderDashboardOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderDashboard.setStatus(""조리완료됨");    
                // view 레파지 토리에 save
                 orderDashboardRepository.save(orderDashboard);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }


}

