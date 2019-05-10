package co.eigen.project.resources;


import co.eigen.project.dao.MyModelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;


@RestController
@RequestMapping("/data")
public class DataResource {


    @Autowired
    private MyModelDao myModelDao;

    @PostConstruct
    public void createSimulatedData(){
         myModelDao.createData();
    }

}
