package deliverysystem.infra;
import deliverysystem.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class CookHateoasProcessor implements RepresentationModelProcessor<EntityModel<Cook>>  {

    @Override
    public EntityModel<Cook> process(EntityModel<Cook> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/acceptcook").withRel("acceptcook"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/cancelcook").withRel("cancelcook"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/finishcook").withRel("finishcook"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/startcook").withRel("startcook"));

        
        return model;
    }
    
}
