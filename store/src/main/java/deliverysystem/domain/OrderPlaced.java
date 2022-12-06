package deliverysystem.domain;

import deliverysystem.domain.*;
import deliverysystem.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long foodId;
    private Integer qty;
    private Object option;
    private String name;
    private Integer tel;
    private Integer price;
    private String addr;
    private Long storeId;
    private String status;
    private String foodNm;
}


