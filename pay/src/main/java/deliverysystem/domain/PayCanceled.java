package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class PayCanceled extends AbstractEvent {

    private Long id;
    private String status;
    private Long orderId;

    public PayCanceled(Pay aggregate){
        super(aggregate);
    }
    public PayCanceled(){
        super();
    }
}
