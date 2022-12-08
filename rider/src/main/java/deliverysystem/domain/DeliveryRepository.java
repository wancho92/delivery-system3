package deliverysystem.domain;

import java.util.*;
import deliverysystem.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="deliveries", path="deliveries")
public interface DeliveryRepository extends PagingAndSortingRepository<Delivery, Long>{
    Optional<Delivery> findByOrderId(Long orderId);
}
