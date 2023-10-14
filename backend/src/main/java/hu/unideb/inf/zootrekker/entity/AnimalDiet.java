package hu.unideb.inf.zootrekker.entity;

import hu.unideb.inf.zootrekker.enums.EWeekdays;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="AnimalDiet")
public class AnimalDiet {
    @Id
    @GeneratedValue
    private int id;
    private int substanceId; // ?
    private EWeekdays weekdays;
    // TODO private List<String> hours;
    private Float amount;
}
