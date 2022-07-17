package junseok.snr.teamstudy.injection.setter;

import org.springframework.stereotype.Component;

@Component
public class AChildBean implements ChildBean {
    @Override
    public String getName() {
        return AChildBean.class.getName();
    }
}
