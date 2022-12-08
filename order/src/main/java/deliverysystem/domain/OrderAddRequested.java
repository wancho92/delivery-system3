package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderAddRequested extends AbstractEvent {

    private Long id;
    private String cntn;

    public OrderAddRequested(Order aggregate){
        super(aggregate);
    }
    public OrderAddRequested(){
        super();
    }
}
