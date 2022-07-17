package junseok.snr.teamstudy.injection.construct;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ParentConstructComponent {

    private int parentResult;

    private final ChildConstructComponent childConstructComponent;

    public void calculate(int first, int second, int third) {
        childConstructComponent.add(first);
        add(first);
        childConstructComponent.add(second);
        add(second);
        childConstructComponent.add(third);
        add(third);
    }

    public void add(int number) {
        this.parentResult += number;
    }

    public int getParentResult() {
        return this.parentResult;
    }

}
