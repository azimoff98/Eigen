package co.eigen.project.resources;

import co.eigen.project.dto.MyModelDto;
import co.eigen.project.model.MyModel;
import co.eigen.project.service.MyModelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class MyModelResource {


    private static final Logger log = LoggerFactory.getLogger(MyModelResource.class);

    @Autowired
    private MyModelService myModelService;


    @GetMapping("/model/latest")
    public MyModelDto getLatest(){
        log.debug("~~~Rest request for latest record");
        return myModelService.getLatestValue();
    }

    @GetMapping("/model/goods")
    public List<Float> getGoodValues(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date from,
                                     @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")Date to){
        log.debug("~~~Rest request for good values between two dates");
        return myModelService.getGoodValues(from,to);

    }


    @GetMapping("/model/average")
    public Float getAverageValue(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date from,
                                 @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy")Date to){
        log.debug("~~~Rest request for average value between two dates");
        return myModelService.getAverageValue(from, to);
    }


    @GetMapping("/model/{id}")
    public MyModel findById(@PathVariable Long id){
        log.debug("~~~Rest request for model with id {}:" + id);
        return myModelService.findById(id);
    }

    @GetMapping("/model/all")
    public List<MyModel> findAll(){
        log.debug("~~~Rest request for all models");
        return myModelService.findAll();
    }

    @PostMapping("/model/save")
    public void save(@RequestBody MyModel myModel){
        log.debug("~~~Rest request for saving new model");
        myModelService.save(myModel);
    }

    @PutMapping("/model/update")
    public MyModel update(@RequestBody MyModel myModel){
        log.debug("~~~Rest request for updating model with id: {}" + myModel.getId());
        return myModelService.update(myModel);
    }

    @DeleteMapping("/model/{id}")
    public void deleteById(@PathVariable Long id){
        log.debug("~~~Rest request for deleting model with id: {}" + id);
        myModelService.deleteById(id);
    }

    @DeleteMapping("/model/all")
    public void deleteAll(){
        log.debug("~~~Rest request for deleting all models.");
        myModelService.deleteAll();
    }
}
