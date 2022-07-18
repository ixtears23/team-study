package junseok.snr.teamstudy.injection.field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReflectionParentFieldComponentTest {

    private ParentFiledComponent parentFiledComponent;

    @BeforeEach
    void setUp() throws IllegalAccessException, NoSuchFieldException {
        parentFiledComponent = new ParentFiledComponent();
        final Field field = parentFiledComponent.getClass().getDeclaredField("childFieldComponent");
        field.setAccessible(true);
        field.set(parentFiledComponent, new ChildFieldComponent());
    }


    @Test
    void calculateTest() {
        parentFiledComponent.calculate(3, 5, 6);
        final int parentResult = parentFiledComponent.getParentResult();

        assertEquals(14, parentResult);
    }
}
