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

//    @OneToOne
//    @JoinColumn(name = "auth_id", referencedColumnName = "id")
//    private Auth auth;
    @Column(unique = true)
    private String username;

    private String password;

    @Column(name = "last_login")
    private Timestamp lastLogin;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", lastLogin=" + lastLogin +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", workDays='" + workDays + '\'' +
                ", workStartHour='" + workStartHour + '\'' +
                ", workEndHour='" + workEndHour + '\'' +
                ", cage=" + cage +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';

    }
}
//ADMIN USER
/*
{
    "id": 0,
    "username": "admin",
    "password": "ZootrekkerAdmin",
    "lastLogin": null,
    "firstName": "Admin",
    "lastName": "Admin",
    "role": 0,
    "position": "Admin",
    "salary": 0.0,
    "workDays": "H-V",
    "workStartHour": "24:00",
    "workEndHour": "0:00",
    "cage": [],
    "createdAt": null,
    "updatedAt": null
}
        */