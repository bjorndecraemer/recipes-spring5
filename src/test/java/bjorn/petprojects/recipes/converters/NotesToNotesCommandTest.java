package bjorn.petprojects.recipes.converters;

import bjorn.petprojects.recipes.commands.NotesCommand;
import bjorn.petprojects.recipes.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesToNotesCommandTest {

    public final Long ID_VALUE = 1L;
    public final String NOTES = "recipe-notes";

    NotesToNotesCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesToNotesCommand();
    }

    @Test
    public void testNullValue(){
        assertNull(converter.convert(null));
    }
    @Test
    public void emptyValue(){
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    public void convert() {
        //Given
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipeNotes(NOTES);

        //When
        NotesCommand command = converter.convert(notes);

        //Then
        assertNotNull(command);
        assertEquals(ID_VALUE, command.getId());
        assertEquals(NOTES, command.getRecipeNotes());
    }
}