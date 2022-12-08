package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryPicked extends AbstractEvent {

    private Long id;
    private String status;
    private Long orderId;
    private String name;
    private Integer tel;
    private String addr;

    public DeliveryPicked(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryPicked(){
        super();
    }
}
