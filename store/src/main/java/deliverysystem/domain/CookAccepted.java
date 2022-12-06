package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookAccepted extends AbstractEvent {

    private Long id;
    private String status;
    private Long foodId;
    private Long orderId;
    private String option;
    private Long storeId;

    public CookAccepted(Cook aggregate){
        super(aggregate);
    }
    public CookAccepted(){
        super();
    }
}
