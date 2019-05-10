package co.eigen.project.dao;

import co.eigen.project.model.MyModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface MyModelDao extends CrudRepository<MyModel, Long> {


    @Query(value = "select * from my_table order by date desc limit 1", nativeQuery = true)
    @Transactional
    MyModel getLatestValue();

    @Query(value =  "select value from my_table where date > :from and date < :to", nativeQuery = true)
    List<Float> getAverageValue(@Param("from") Date from, @Param("to") Date to);

    @Query(value = "select value from my_table where date > :from and date < :to and quality = true", nativeQuery = true)
    List<Float> getGoodValues(@Param("from") Date from, @Param("to") Date to);

    @Modifying
    @Query(value = "INSERT INTO my_table (date, engineering_unit, quality, value)\n" +
            "values  ('2015-12-23', 'Engineering Unit A', false, 42.6),\n" +
            "        ('2014-02-06', 'Engineering Unit B', true, 14.9),\n" +
            "        ('2012-04-15', 'Engineering Unit C', false, 20.6),\n" +
            "        ('2005-12-11', 'Engineering Unit D', false,31.9),\n" +
            "        ('2010-10-10', 'Engineering Unit E', true, 16.2),\n" +
            "        ('2017-05-17', 'Engineering Unit F', true, 27.1),\n" +
            "        ('2019-02-23', 'Engineering Unit G', false, 34.5);", nativeQuery = true)
    @Transactional
    void createData();



}
