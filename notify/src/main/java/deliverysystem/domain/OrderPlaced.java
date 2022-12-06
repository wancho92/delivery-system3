package deliverysystem.domain;

import deliverysystem.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long foodId;
    private Integer qty;
    private List<String> option;
    private String name;
    private Integer tel;
    private Integer price;
    private String addr;
    private Long storeId;
    private String status;
    private String foodNm;
}
