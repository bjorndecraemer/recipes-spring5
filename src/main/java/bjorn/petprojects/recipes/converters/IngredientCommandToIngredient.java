package bjorn.petprojects.recipes.converters;

import bjorn.petprojects.recipes.commands.IngredientCommand;
import bjorn.petprojects.recipes.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureToUnitOfMeasureCommand;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    @Null
    @Synchronized
    public Ingredient convert(IngredientCommand source) {
        if(source == null){
            return null;
        }

        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setUom(unitOfMeasureToUnitOfMeasureCommand.convert(source.getUnitOfMeasure()));
        return ingredient;
    }
}
