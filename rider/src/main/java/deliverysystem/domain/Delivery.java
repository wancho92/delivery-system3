package deliverysystem.domain;

import deliverysystem.RiderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String name;
    
    
    
    
    
    private Integer tel;
    
    
    
    
    
    private String addr;

    @PostPersist
    public void onPostPersist(){
    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }



    public void pickCook(){
        System.out.println("@@@ Delivery.pickCook ==> 배송시작");
        setStatus("배송시작");
        DeliveryPicked deliveryPicked = new DeliveryPicked(this);
        deliveryPicked.publishAfterCommit();
    }
    public void acceptDelivery(){
        System.out.println("@@@ Delivery.acceptDelivery ==> 배송완료");
        setStatus("배송완료");
        DeliveryAccepted deliveryAccepted = new DeliveryAccepted(this);
        deliveryAccepted.publishAfterCommit();
    }
    public static void registerOrder(OrderPlaced orderPlaced){
        System.out.println("@@@ Delivery.registerOrder in.. @@");
        System.out.println("@@@ Delivery.registerOrder.orderId=" + orderPlaced.getId());
        System.out.println("@@@ Delivery.registerOrder.name=" + orderPlaced.getName());
        System.out.println("@@@ Delivery.registerOrder.tel=" + orderPlaced.getTel());
        System.out.println("@@@ Delivery.registerOrder.addr=" + orderPlaced.getAddr());

        Delivery delivery = new Delivery();
        delivery.setOrderId(orderPlaced.getId());
        delivery.setName(orderPlaced.getName());
        delivery.setTel(orderPlaced.getTel());
        delivery.setAddr(orderPlaced.getAddr());
        delivery.setStatus("주문완료");
        repository().save(delivery);
    }

    public static void updateStatus(CookFinished cookFinished){
        System.out.println("@@@ Delivery.updateStatus in.. @@");
        System.out.println("@@@ Delivery.updateStatus.orderId=" + cookFinished.getOrderId());
               
        repository().findByOrderId(cookFinished.getOrderId()).ifPresent(delivery->{
            System.out.println("@@@ Delivery.updateStatus ==> 조리완료");

            delivery.setStatus("조리완료");
            repository().save(delivery);
         });       
    }

}
