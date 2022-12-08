package deliverysystem.domain;

import deliverysystem.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class DeliveryAccepted extends AbstractEvent {

    private Long id;
    private String status;
    private Long orderId;
    private String name;
    private Integer tel;
    private String addr;
}
