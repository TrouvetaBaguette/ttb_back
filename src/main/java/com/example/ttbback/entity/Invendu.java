package com.example.ttbback.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Invendu {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String label;
    private double prix;
    private boolean reservable;
    private int quantité;

    public UUID getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPrix() {
        return prix;
    }

    public boolean isReservable() {
        return reservable;
    }

    public int getQuantité() {
        return quantité;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setReservable(boolean reservable) {
        this.reservable = reservable;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }
}
