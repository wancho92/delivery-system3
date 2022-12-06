package deliverysystem.infra;
import deliverysystem.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class DeliveryHateoasProcessor implements RepresentationModelProcessor<EntityModel<Delivery>>  {

    @Override
    public EntityModel<Delivery> process(EntityModel<Delivery> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/pickcook").withRel("pickcook"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/acceptdelivery").withRel("acceptdelivery"));

        
        return model;
    }
    
}
