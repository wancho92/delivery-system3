package deliverysystem.domain;

import deliverysystem.domain.PayAccepted;
import deliverysystem.domain.PayCanceled;
import deliverysystem.PayApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Pay_table")
@Data

public class Pay  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private Integer price;

    @PostPersist
    public void onPostPersist(){
        System.out.println("@@@ Pay.onPostPersist in.. @@");
        System.out.println("@@@ Pay.onPostPersist.id=" + id);
        System.out.println("@@@ Pay.onPostPersist.price=" + price);
        System.out.println("@@@ Pay.onPostPersist.status=" + status);
        
        if("주문완료".equals(status)) {
            PayAccepted payAccepted = new PayAccepted(this);
            payAccepted.publishAfterCommit();
        }
        else if("주문취소".equals(status)) {
            PayCanceled payCanceled = new PayCanceled(this);
            payCanceled.publishAfterCommit();
        }
    }

    public static PayRepository repository(){
        PayRepository payRepository = PayApplication.applicationContext.getBean(PayRepository.class);
        return payRepository;
    }




    public static void cancelPay(OrderCanceled orderCanceled){
        repository().findByOrderId(orderCanceled.getId()).ifPresent(pay->{
            pay.setStatus("주문취소");
            repository().save(pay);

            PayCanceled payCanceled = new PayCanceled(pay);
            payCanceled.publishAfterCommit();
         });      
    }


}
