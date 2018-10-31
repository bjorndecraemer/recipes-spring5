package bjorn.petprojects.recipes.converters;

import bjorn.petprojects.recipes.commands.CategoryCommand;
import bjorn.petprojects.recipes.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryToCategoryCommandTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = new Long(1L);

    CategoryToCategoryCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryToCategoryCommand();
    }
    @Test
    public void nullInput(){
        assertNull(converter.convert(null));
    }
    @Test
    public void emptyObject(){
        assertNotNull(converter.convert(new Category()));
    }
    @Test
    public void convert(){
        //Given
        Category category = new Category();
        category.setId(LONG_VALUE);
        category.setDescription(DESCRIPTION);

        // When
        CategoryCommand command = converter.convert(category);

        // Then
        assertNotNull(command);
        assertEquals(LONG_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}