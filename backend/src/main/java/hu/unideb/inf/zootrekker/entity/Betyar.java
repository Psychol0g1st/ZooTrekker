package hu.unideb.inf.zootrekker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="betyars")
public class Betyar {
    @Id
    @GeneratedValue
    private long id;
    private String nev;
    private Boolean isStrong;
    private Float orr; //Orr átmérő (cm)
    private LocalDate birthDate;
    private Timestamp xd;
    public void setOrr(float n) throws Exception
    {
        if (n > -1 && n < 1) this.orr = n;
        else throw new Exception();
    }
}
