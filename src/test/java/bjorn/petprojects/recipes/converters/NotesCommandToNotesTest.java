package bjorn.petprojects.recipes.converters;

import bjorn.petprojects.recipes.commands.NotesCommand;
import bjorn.petprojects.recipes.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotesCommandToNotesTest {

    public final Long ID_VALUE = 1L;
    public final String NOTES = "recipe-notes";

    NotesCommandToNotes converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullValue(){
        assertNull(converter.convert(null));
    }
    @Test
    public void emptyValue(){
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convert() {
        //Given
        NotesCommand command = new NotesCommand();
        command.setId(ID_VALUE);
        command.setRecipeNotes(NOTES);

        //When
        Notes notes = converter.convert(command);

        //Then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(NOTES, notes.getRecipeNotes());
    }
}