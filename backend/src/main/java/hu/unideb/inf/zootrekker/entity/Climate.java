package hu.unideb.inf.zootrekker.entity;

import hu.unideb.inf.zootrekker.enums.EWeekdays;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Climate")
public class Climate {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;

    private float temperature;
    private float humidity;
}