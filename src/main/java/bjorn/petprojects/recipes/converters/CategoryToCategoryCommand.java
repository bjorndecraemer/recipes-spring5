package bjorn.petprojects.recipes.converters;

import bjorn.petprojects.recipes.commands.CategoryCommand;
import bjorn.petprojects.recipes.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    @Override
    @Nullable
    @Synchronized
    public CategoryCommand convert(Category source) {
        if(source == null){
            return null;
        }

        final CategoryCommand command = new CategoryCommand();
        command.setId(source.getId());
        command.setDescription(source.getDescription());
        return command;
    }
}
