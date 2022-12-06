package deliverysystem.infra;
import deliverysystem.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/pays")
@Transactional
public class PayController {
    @Autowired
    PayRepository payRepository;



    @RequestMapping(value = "pays/{id}/acceptcook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Pay acceptPay(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /pay/acceptPay  called #####");
            Optional<Pay> optionalPay = payRepository.findById(id);
            
            optionalPay.orElseThrow(()-> new Exception("No Entity Found"));
            Pay pay = optionalPay.get();
            pay.acceptPay();
            
            payRepository.save(pay);
            return pay;
            
    }
    



}
