package hu.unideb.inf.zootrekker.entity;

import hu.unideb.inf.zootrekker.enums.ESubstance;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    @GeneratedValue
    private int id;
    private ESubstance type;
    String name;
    String unit;
    Integer stock;
}
