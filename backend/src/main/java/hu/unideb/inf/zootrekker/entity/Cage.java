package hu.unideb.inf.zootrekker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Cage")
public class Cage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Climate climate;
    @Column(unique = true)
    private String name;
    private float positionX;
    private float positionY;
}
