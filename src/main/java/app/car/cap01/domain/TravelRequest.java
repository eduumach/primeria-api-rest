package app.car.cap01.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TravelRequest {

    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    Passenger passenger;
    String origin;
    String destination;
}
