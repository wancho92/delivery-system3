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
// @RequestMapping(value="/cooks")
@Transactional
public class CookController {
    @Autowired
    CookRepository cookRepository;



    @RequestMapping(value = "cooks/{id}/acceptcook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Cook acceptCook(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /cook/acceptCook  called #####");
            Optional<Cook> optionalCook = cookRepository.findById(id);
            
            optionalCook.orElseThrow(()-> new Exception("No Entity Found"));
            Cook cook = optionalCook.get();
            cook.acceptCook();
            
            cookRepository.save(cook);
            return cook;
            
    }
    



    @RequestMapping(value = "cooks/{id}/cancelcook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Cook cancelCook(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /cook/cancelCook  called #####");
            Optional<Cook> optionalCook = cookRepository.findById(id);
            
            optionalCook.orElseThrow(()-> new Exception("No Entity Found"));
            Cook cook = optionalCook.get();
            cook.cancelCook();
            
            cookRepository.save(cook);
            return cook;
            
    }
    



    @RequestMapping(value = "cooks/{id}/finishcook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Cook finishCook(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /cook/finishCook  called #####");
            Optional<Cook> optionalCook = cookRepository.findById(id);
            
            optionalCook.orElseThrow(()-> new Exception("No Entity Found"));
            Cook cook = optionalCook.get();
            cook.finishCook();
            
            cookRepository.save(cook);
            return cook;
            
    }
    



    @RequestMapping(value = "cooks/{id}/startcook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Cook startCook(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /cook/startCook  called #####");
            Optional<Cook> optionalCook = cookRepository.findById(id);
            
            optionalCook.orElseThrow(()-> new Exception("No Entity Found"));
            Cook cook = optionalCook.get();
            cook.startCook();
            
            cookRepository.save(cook);
            return cook;
            
    }
    



}
