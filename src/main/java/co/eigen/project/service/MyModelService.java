package co.eigen.project.service;


import co.eigen.project.dto.MyModelDto;
import co.eigen.project.model.MyModel;

import java.util.Date;
import java.util.List;

public interface MyModelService {
    MyModelDto getLatestValue();
    Float getAverageValue(Date startDate, Date endDate);
    List<Float> getGoodValues(Date startDate, Date endDate);
    void save(MyModel myModel);
    MyModel findById(Long id);
    List<MyModel> findAll();
    void deleteById(Long id);
    void deleteAll();
    MyModel update(MyModel myModel);

}
