package bjorn.petprojects.recipes.domain;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String description;
    @Setter
    private BigDecimal amount;

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    @Setter(AccessLevel.PACKAGE)
    @ManyToOne
    private Recipe recipe;

    public UnitOfMeasure getUnitOfMeasure() {
        return uom;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.uom = unitOfMeasure;
    }
}
