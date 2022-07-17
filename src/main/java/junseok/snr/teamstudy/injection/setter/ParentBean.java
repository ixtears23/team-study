package junseok.snr.teamstudy.injection.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ParentBean {

    private ChildBean childBean;

    @Qualifier(value = "AChildBean")
    @Autowired
    public void setChildBean(ChildBean childBean) {
        this.childBean = childBean;
    }

    public String getChildBeanName() {
        return childBean.getName();
    }
}
