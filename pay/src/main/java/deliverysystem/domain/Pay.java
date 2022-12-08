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


        PayAccepted payAccepted = new PayAccepted(this);
        payAccepted.publishAfterCommit();



        PayCanceled payCanceled = new PayCanceled(this);
        payCanceled.publishAfterCommit();

    }

    public static PayRepository repository(){
        PayRepository payRepository = PayApplication.applicationContext.getBean(PayRepository.class);
        return payRepository;
    }




    public static void cancelPay(OrderCanceled orderCanceled){

        /** Example 1:  new item 
        Pay pay = new Pay();
        repository().save(pay);

        PayCanceled payCanceled = new PayCanceled(pay);
        payCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(pay->{
            
            pay // do something
            repository().save(pay);

            PayCanceled payCanceled = new PayCanceled(pay);
            payCanceled.publishAfterCommit();

         });
        */

        
    }
    public static void cancelPay(CookCanceled cookCanceled){

        /** Example 1:  new item 
        Pay pay = new Pay();
        repository().save(pay);

        PayCanceled payCanceled = new PayCanceled(pay);
        payCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookCanceled.get???()).ifPresent(pay->{
            
            pay // do something
            repository().save(pay);

            PayCanceled payCanceled = new PayCanceled(pay);
            payCanceled.publishAfterCommit();

         });
        */

        
    }


}
