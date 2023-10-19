package hu.unideb.inf.zootrekker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "climate")
public class Climate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "climate")
    private List<Cage> cages;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;

    private Float humidity;
    private Float temperature;
    private String name;
}
