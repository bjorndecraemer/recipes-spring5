package bjorn.petprojects.recipes.converters;

import bjorn.petprojects.recipes.commands.UnitOfMeasureCommand;
import bjorn.petprojects.recipes.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp(){
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }
    @Test
    public void testNullParameter() throws Exception{
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception{
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    public void convert() {
        // Given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //When
        UnitOfMeasure uom = converter.convert(command);

        //Then
        assertNotNull(uom);
        assertEquals(LONG_VALUE,uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}