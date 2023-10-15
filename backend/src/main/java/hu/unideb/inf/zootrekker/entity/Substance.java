package hu.unideb.inf.zootrekker.entity;

import hu.unideb.inf.zootrekker.enums.ESubstance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Substances")
public class Substance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private ESubstance type;
    String name;
    String unit;
    Integer stock;
}
