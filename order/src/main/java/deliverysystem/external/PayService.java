package deliverysystem.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name = "pay", url = "${api.url.pay}")
public interface PayService {
    @RequestMapping(method= RequestMethod.PUT, path="/pays/{id}/acceptcook")
    public void acceptPay(@PathVariable("id") Long id);
}
