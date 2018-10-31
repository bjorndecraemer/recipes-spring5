package bjorn.petprojects.recipes.converters;

import bjorn.petprojects.recipes.commands.UnitOfMeasureCommand;
import bjorn.petprojects.recipes.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }
    @Test
    public void nullInput(){
        assertNull(converter.convert(null));
    }
    @Test
    public void emptyObject(){
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }
    @Test
    public void convert(){
        //Given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setId(LONG_VALUE);
        uom.setDescription(DESCRIPTION);

        // When
        UnitOfMeasureCommand command = converter.convert(uom);

        // Then
        assertNotNull(command);
        assertEquals(LONG_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}