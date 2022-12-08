package deliverysystem.domain;

import deliverysystem.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class CookFinished extends AbstractEvent {

    private Long id;
    private String status;
    private Long foodId;
    private Long orderId;
    private String option;
    private Long storeId;
}
