package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryPicked extends AbstractEvent {

    private Long id;

    public DeliveryPicked(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryPicked(){
        super();
    }
}
