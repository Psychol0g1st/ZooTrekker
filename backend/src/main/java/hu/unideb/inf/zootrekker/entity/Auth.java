package hu.unideb.inf.zootrekker.entity;

import hu.unideb.inf.zootrekker.enums.EWeekdays;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Auth")
public class Auth {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String password;
    private Boolean verified;
    // TODO private timestamp;
}
