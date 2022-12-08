package deliverysystem.domain;

import deliverysystem.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Cook_table")
@Data

public class Cook  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String status;
    
    
    
    
    
    private Long foodId;
    
    
    
    
    
    private Long orderId;
    
    
    
    
    
    private String option;
    
    
    
    
    
    private Long storeId;
    
    
    
    
    
    private String cntn;

    @PostPersist
    public void onPostPersist(){
    }

    public static CookRepository repository(){
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(CookRepository.class);
        return cookRepository;
    }



    public void acceptCook(){
        CookAccepted cookAccepted = new CookAccepted(this);
        cookAccepted.publishAfterCommit();

    }
    public void cancelCook(){
        CookCanceled cookCanceled = new CookCanceled(this);
        cookCanceled.publishAfterCommit();

    }
    public void finishCook(){
        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();

    }
    public void startCook(){
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

    }

    public static void registerOrder(OrderPlaced orderPlaced){

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

        
    }
    public static void updateStatus(PayAccepted payAccepted){

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(payAccepted.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

        
    }
    public static void updateStatus(PayCanceled payCanceled){

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(payCanceled.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

        
    }
    public static void updateRequest(OrderAddRequested orderAddRequested){

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderAddRequested.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

        
    }


}
