package app.car.cap01.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Driver {

    @Id
    @GeneratedValue
    private
    Long id;
    String name;
    Date birthData;
}
