package deliverysystem.domain;

import java.util.*;
import deliverysystem.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="cooks", path="cooks")
public interface CookRepository extends PagingAndSortingRepository<Cook, Long>{
    Optional<Cook> findByOrderId(Long orderId);
}
