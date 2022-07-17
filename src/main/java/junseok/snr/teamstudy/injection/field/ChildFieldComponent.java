package junseok.snr.teamstudy.injection.field;

import org.springframework.stereotype.Component;

@Component
public class ChildFieldComponent {

    private int result = 0;

    public void add(int number) {
        this.result += number;
    }

    public int getResult() {
        return this.result;
    }

}
