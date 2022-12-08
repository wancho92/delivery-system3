package deliverysystem.external;

import lombok.Data;
import java.util.Date;
@Data
public class Order {

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
    private String cntn;
}


