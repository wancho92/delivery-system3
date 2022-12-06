package deliverysystem.domain;

import deliverysystem.domain.OrderPlaced;
import deliverysystem.domain.OrderCanceled;
import deliverysystem.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long foodId;
    
    
    
    
    
    private Integer qty;
    
    
    
    @ElementCollection
    
    private List<String> option;
    
    
    
    
    
    private String name;
    
    
    
    
    
    private Integer tel;
    
    
    
    
    
    private Integer price;
    
    
    
    
    
    private String addr;
    
    
    
    
    
    private Long storeId;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private String foodNm;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.


        deliverysystem.external.Pay pay = new deliverysystem.external.Pay();
        // mappings goes here
        OrderApplication.applicationContext.getBean(deliverysystem.external.PayService.class)
            .acceptPay(pay);


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PreRemove
    public void onPreRemove(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
