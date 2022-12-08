package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderAddRequested extends AbstractEvent {

    private Long id;
    private String cntn;
}


