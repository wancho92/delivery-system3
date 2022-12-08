package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;
    private String status;
    private Long foodId;
    private Long orderId;
    private String option;
    private Long storeId;
}


