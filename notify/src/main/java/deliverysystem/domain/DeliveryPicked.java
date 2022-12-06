package deliverysystem.domain;

import deliverysystem.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class DeliveryPicked extends AbstractEvent {

    private Long id;
}
