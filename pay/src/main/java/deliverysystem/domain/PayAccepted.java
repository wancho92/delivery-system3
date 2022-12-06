package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PayAccepted extends AbstractEvent {

    private Long id;
    private String status;
    private Long orderId;

    public PayAccepted(Pay aggregate){
        super(aggregate);
    }
    public PayAccepted(){
        super();
    }
}
