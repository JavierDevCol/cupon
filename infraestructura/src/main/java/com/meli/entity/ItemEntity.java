package com.meli.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class ItemEntity {

    @Id
    private String id;
    private String title;
    private Double price;
    private String site_id;
    @Column(name = "quantity")
    private Long quantitySold;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ItemEntity that = (ItemEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void aumentarQuantitySold(){
        if (Objects.isNull(this.quantitySold))
            this.quantitySold = 0l;
    }
}
