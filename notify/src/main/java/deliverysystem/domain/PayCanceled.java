package deliverysystem.domain;

import deliverysystem.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class PayCanceled extends AbstractEvent {

    private Long id;
    private String status;
    private Long orderId;
}
