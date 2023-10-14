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
@Table(name="animal_diet")
public class AnimalDiet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_animal_diet_Id", referencedColumnName = "id")
    private List<Substance> substance;
    private String weekdays;

    /*
     ;-vel elválasztva
     */
    private String hours;
    private Float amount;
}
