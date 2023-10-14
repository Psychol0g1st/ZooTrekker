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
@Table(name="Auth")
public class Auth {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;

    private String password;
    private Boolean verified;
    private Timestamp lastLogin;
    private Timestamp verifiedAt;
}
