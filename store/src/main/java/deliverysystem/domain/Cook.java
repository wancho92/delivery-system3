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

    @PostPersist
    public void onPostPersist(){

    }

    public static CookRepository repository(){
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(CookRepository.class);
        return cookRepository;
    }



    public void acceptCook(){
        System.out.println("@@@ Cook.acceptCook ==> 주문승인");
        setStatus("주문승인");
        CookAccepted cookAccepted = new CookAccepted(this);
        cookAccepted.publishAfterCommit();
    }
    public void cancelCook(){
        System.out.println("@@@ Cook.cancelCook ==> 주문취소");
        setStatus("주문취소");
        CookCanceled cookCanceled = new CookCanceled(this);
        cookCanceled.publishAfterCommit();
    }
    public void finishCook(){
        System.out.println("@@@ Cook.finishCook ==> 조리완료");
        setStatus("조리완료");
        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }
    public void startCook(){
        System.out.println("@@@ Cook.startCook ==> 조리시작");
        setStatus("조리시작");
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();
    }
    public static void registerOrder(OrderPlaced orderPlaced){
        System.out.println("@@@ Cook.registerOrder in.. @@");
        System.out.println("@@@ Cook.registerOrder.orderId=" + orderPlaced.getId());
        System.out.println("@@@ Cook.registerOrder.foodId=" + orderPlaced.getFoodId());

        Cook cook = new Cook();
        cook.setOrderId(orderPlaced.getId());
        cook.setFoodId(orderPlaced.getFoodId());
        cook.setStatus("주문완료");
        repository().save(cook);
    }

    public static void updateStatus(PayAccepted payAccepted){
        System.out.println("@@@ Cook.updateStatus in.. @@");
        System.out.println("@@@ Cook.updateStatus.orderId=" + payAccepted.getId());

        repository().findByOrderId(payAccepted.getId()).ifPresent(cook->{
            System.out.println("@@@ Cook.updateStatus ==> 결재완료");

            cook.setStatus("결재완료");
            repository().save(cook);
        });
    }

    public static void updateStatus(PayCanceled payCanceled){
        System.out.println("@@@ Cook.updateStatus in.. @@");
        System.out.println("@@@ Cook.updateStatus.orderId=" + payCanceled.getOrderId());
        
        repository().findByOrderId(payCanceled.getOrderId()).ifPresent(cook->{
            System.out.println("@@@ Cook.updateStatus ==> 결재취소");
            
            cook.setStatus("결재취소");
            repository().save(cook);
        });
    }


}
