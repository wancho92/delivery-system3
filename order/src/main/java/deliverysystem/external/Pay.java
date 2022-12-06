package deliverysystem.external;

import lombok.Data;
import java.util.Date;
@Data
public class Pay {

    private Long id;
    private String status;
    private Long orderId;
    private Integer price;
}


