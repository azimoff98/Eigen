package co.eigen.project.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class MyModelDto {
    private Float value;
    private Date date;
    private Boolean quality;


}
