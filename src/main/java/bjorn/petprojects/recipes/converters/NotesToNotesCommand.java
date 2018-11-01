package bjorn.petprojects.recipes.converters;

import bjorn.petprojects.recipes.commands.NotesCommand;
import bjorn.petprojects.recipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
    @Override
    @Nullable
    @Synchronized
    public NotesCommand convert(Notes source) {
        if(source == null){
            return null;
        }
        final NotesCommand command = new NotesCommand();
        command.setId(source.getId());
        command.setRecipeNotes(source.getRecipeNotes());
        return command;
    }
}
