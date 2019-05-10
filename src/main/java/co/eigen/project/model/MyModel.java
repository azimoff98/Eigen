package co.eigen.project.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "MyTable")
public class MyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "value")
    private Float value;

    @Column(name = "engineering_unit")
    private String engineeringUnit;

    @Column(name = "quality")
    private Boolean quality;
}
