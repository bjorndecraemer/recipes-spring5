package bjorn.petprojects.recipes.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@NoArgsConstructor
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

    @Setter
    @ManyToOne
    private Recipe recipe;

    public UnitOfMeasure getUnitOfMeasure() {
        return uom;
    }
}
