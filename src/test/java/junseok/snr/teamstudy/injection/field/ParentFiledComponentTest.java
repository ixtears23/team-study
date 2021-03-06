package junseok.snr.teamstudy.injection.field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParentFiledComponentTest {

    private ParentFiledComponent parentFiledComponent;

    @BeforeEach
    void setUp() {
        parentFiledComponent = new ParentFiledComponent();
    }

    @Test
    void calculateTest() {
        parentFiledComponent.calculate(3, 5, 6);
        final int parentResult = parentFiledComponent.getParentResult();

        assertEquals(14, parentResult);
    }
}