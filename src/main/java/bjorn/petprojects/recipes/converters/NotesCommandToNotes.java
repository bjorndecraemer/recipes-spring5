package bjorn.petprojects.recipes.converters;

import bjorn.petprojects.recipes.commands.NotesCommand;
import bjorn.petprojects.recipes.domain.Notes;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    @Override
    @Nullable
    @Synchronized
    public Notes convert(NotesCommand source) {
        if(source == null){
            return null;
        }
        final Notes notes = new Notes();
        notes.setId(source.getId());
        notes.setRecipeNotes(source.getRecipeNotes());
        return notes;
    }
}
