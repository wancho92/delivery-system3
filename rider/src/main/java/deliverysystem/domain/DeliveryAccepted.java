package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryAccepted extends AbstractEvent {

    private Long id;
    private String status;
    private Long orderId;
    private String name;
    private Integer tel;
    private String addr;

    public DeliveryAccepted(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryAccepted(){
        super();
    }
}
