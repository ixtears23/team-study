package junseok.snr.teamstudy.injection.setter;

import org.springframework.stereotype.Component;

@Component
public class BChildBean implements ChildBean {
    @Override
    public String getName() {
        return BChildBean.class.getName();
    }
}
