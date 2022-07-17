package junseok.snr.teamstudy.injection.construct;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParentConstructComponentTest {

    private ParentConstructComponent parentConstructComponent;

    @BeforeEach
    void setUp() {
        parentConstructComponent = new ParentConstructComponent(new ChildConstructComponent());
    }

    @Test
    void calculateTest() {
        parentConstructComponent.calculate(1, 2, 3);

        final int parentResult = parentConstructComponent.getParentResult();

        assertEquals(6, parentResult);
    }
}