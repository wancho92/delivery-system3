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
    
    
    
    
    
    private String cntn;

    @PostPersist
    public void onPostPersist(){
        deliverysystem.external.Pay pay = new deliverysystem.external.Pay();
        pay.setOrderId(id);
        pay.setPrice(price);
        pay.setStatus("주문완료");

        OrderApplication.applicationContext.getBean(deliverysystem.external.PayService.class)
            .acceptPay(pay);

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove(){
        if("주문승인".equals(status) || "조리시작".equals(status)){
            System.out.println(status + " 되었습니다. 주문취소는 불가능합니다.");
            return;
        }

        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.setStatus("주문취소");
        orderCanceled.publishAfterCommit();
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }



    public void addRequest(){
        OrderAddRequested orderAddRequested = new OrderAddRequested(this);
        orderAddRequested.publishAfterCommit();

    }



}
