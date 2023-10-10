package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private boolean isStrong;
    private float orr; //Orr átmérő (cm)

    public void setOrr(float n) throws Exception
    {
        if (n > -1 && n < 1) this.orr = n;
        else throw new Exception();
    }
}
