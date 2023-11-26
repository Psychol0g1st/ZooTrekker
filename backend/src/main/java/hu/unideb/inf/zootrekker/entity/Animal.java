package hu.unideb.inf.zootrekker.entity;

import hu.unideb.inf.zootrekker.enums.EGender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_species_id", referencedColumnName = "id")
    private Species species;

    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_climate_id", referencedColumnName = "id")
    private Climate climate;

    @ManyToOne
    @JoinColumn(name = "fk_cage_id", referencedColumnName = "id")
    private Cage cage;

    private Timestamp dateOfBirth;

    private Timestamp dateOfArrival;

    private EGender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_diets_id", referencedColumnName = "id")
    private List<AnimalDiet> diets;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_health_records_id", referencedColumnName = "id")
    private List<HealthRecord> healthRecords;

    @CreationTimestamp
    @Column(name="created_at", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;
}
