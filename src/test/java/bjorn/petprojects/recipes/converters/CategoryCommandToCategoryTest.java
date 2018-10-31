package bjorn.petprojects.recipes.converters;

import bjorn.petprojects.recipes.commands.CategoryCommand;
import bjorn.petprojects.recipes.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryCommandToCategoryTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }
    @Test
    public void nullInput(){
        assertNull(converter.convert(null));
    }
    @Test
    public void emptyObject(){
        assertNotNull(converter.convert(new CategoryCommand()));
    }
    @Test
    public void convert(){
        //Given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(LONG_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        // When
        Category category = converter.convert(categoryCommand);

        // Then
        assertNotNull(category);
        assertEquals(LONG_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}