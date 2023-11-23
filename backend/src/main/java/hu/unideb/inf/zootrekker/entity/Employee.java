package hu.unideb.inf.zootrekker.entity;

import hu.unideb.inf.zootrekker.enums.ERole;
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
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "auth_id", referencedColumnName = "id")
    private Auth auth;

    private String firstName;

    private String lastName;

    private ERole role;

    private String position;

    private Float salary;

    private String workDays; // separated by commas :

    private String workStartHour;

    private String workEndHour;

    @ManyToMany( fetch = FetchType.LAZY)
    @JoinColumn(name = "cage_id")
    private List<Cage> cage;

    @CreationTimestamp
    @Column(name="created_at", updatable = false, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Column(name="updated_at")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;
}
