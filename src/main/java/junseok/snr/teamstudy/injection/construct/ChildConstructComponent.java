package junseok.snr.teamstudy.injection.construct;

import org.springframework.stereotype.Component;

@Component
public class ChildConstructComponent {

    private int result = 0;

    public void add(int number) {
        this.result += number;
    }

    public int getResult() {
        return this.result;
    }

}
