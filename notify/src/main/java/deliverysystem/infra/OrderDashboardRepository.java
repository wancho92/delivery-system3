package deliverysystem.infra;

import deliverysystem.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="orderDashboards", path="orderDashboards")
public interface OrderDashboardRepository extends PagingAndSortingRepository<OrderDashboard, Long> {

    

    
}
