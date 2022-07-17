package junseok.snr.teamstudy.injection.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParentFiledComponent {

    private int parentResult;

    @Autowired
    private ChildFieldComponent childFieldComponent;

    public void calculate(int first, int second, int third) {
        childFieldComponent.add(first);
        add(first);
        childFieldComponent.add(second);
        add(second);
        childFieldComponent.add(third);
        add(third);
    }

    public void add(int number) {
        this.parentResult += number;
    }

    public int getParentResult() {
        return this.parentResult;
    }

}
