package hu.unideb.inf.zootrekker.entity;

import hu.unideb.inf.zootrekker.enums.ESubstance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Substances")
public class Substance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private ESubstance type;
    private String name;
    private String unit;
    private Integer stock;
    @CreationTimestamp
    @Column(name="created_at", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;
    @Column(name="updated_at")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;
}
