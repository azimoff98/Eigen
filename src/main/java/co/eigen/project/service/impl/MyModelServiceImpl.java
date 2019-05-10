package co.eigen.project.service.impl;


import co.eigen.project.dao.MyModelDao;
import co.eigen.project.dto.MyModelDto;
import co.eigen.project.model.MyModel;
import co.eigen.project.service.MyModelService;
import co.eigen.project.util.RoundingUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MyModelServiceImpl implements MyModelService {


    private static final Logger log = LoggerFactory.getLogger(MyModelServiceImpl.class);

    @Autowired
    private MyModelDao myModelDao;


    @Override
    public List<Float> getGoodValues(Date startDate, Date endDate) {
        return myModelDao.getGoodValues(startDate, endDate);
    }

    @Override
    public MyModelDto getLatestValue() {
        MyModel myModel = myModelDao.getLatestValue();
        MyModelDto myModelDto = new MyModelDto();
        myModelDto.setDate(myModel.getDate());
        myModelDto.setQuality(myModel.getQuality());
        myModelDto.setValue(myModel.getValue());
        return myModelDto;
    }

    @Override
    public Float getAverageValue(Date startDate, Date endDate) {
        List<Float> values = myModelDao.getAverageValue(startDate, endDate);
        Float sum = 0F;
        for (int i = 0; i < values.size(); i++) {
            log.debug(values.toString());
            sum = sum + values.get(i);
        }

        return RoundingUtils.round(sum/values.size());
    }

    @Override
    public void save(MyModel myModel) {
        if(Objects.isNull(myModel)){
            throw new RuntimeException("Null value cannot be added");
        }
        if(Objects.isNull(myModel.getDate())){
            myModel.setDate(new Date());
        }
        myModelDao.save(myModel);
    }

    @Override
    public MyModel findById(Long id) {
        return myModelDao.findById(id).orElse(null);
    }

    @Override
    public List<MyModel> findAll() {
        return (List<MyModel>) myModelDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        myModelDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        myModelDao.deleteAll();
    }

    @Override
    public MyModel update(MyModel myModel) {
        if(Objects.isNull(myModel) || Objects.isNull(myModel.getId())){
            throw new RuntimeException("There is no such model to update");
        }
        Optional<MyModel> last = myModelDao.findById(myModel.getId());
        if(last.isPresent()){
            MyModel lastModel = last.get();

            Date date = myModel.getDate();
            Float value = myModel.getValue();
            String engineeringUnit = myModel.getEngineeringUnit();
            Boolean quality = myModel.getQuality();

            if(Objects.nonNull(date)){
                lastModel.setDate(date);
            }
            if(Objects.nonNull(value)){
                lastModel.setValue(value);
            }
            if(Objects.nonNull(engineeringUnit)){
                lastModel.setEngineeringUnit(engineeringUnit);
            }
            if(Objects.nonNull(quality)){
                lastModel.setQuality(quality);
            }

            myModelDao.save(lastModel);
        }

        return null;
    }
}
