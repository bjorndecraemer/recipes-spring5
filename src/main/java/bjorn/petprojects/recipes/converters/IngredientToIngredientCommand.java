package bjorn.petprojects.recipes.converters;

import bjorn.petprojects.recipes.commands.IngredientCommand;
import bjorn.petprojects.recipes.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    @Null
    @Synchronized
    public IngredientCommand convert(Ingredient source) {
        if(source == null){
            return null;
        }

        final IngredientCommand command = new IngredientCommand();
        command.setId(source.getId());
        command.setAmount(source.getAmount());
        command.setDescription(source.getDescription());
        command.setUnitOfMeasure(unitOfMeasureToUnitOfMeasureCommand.convert(source.getUom()));

        return command;
    }
}
