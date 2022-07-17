package junseok.snr.teamstudy.injection;

import junseok.snr.teamstudy.injection.construct.ParentConstructComponent;
import junseok.snr.teamstudy.injection.field.ParentFiledComponent;
import junseok.snr.teamstudy.injection.setter.BeanType;
import junseok.snr.teamstudy.injection.setter.ChildBean;
import junseok.snr.teamstudy.injection.setter.ParentBean;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/injection")
@RestController
public class InjectionController {

    private final ApplicationContext applicationContext;
    private final ParentBean parentBean;
    private final ParentFiledComponent parentFiledComponent;
    private final ParentConstructComponent parentConstructComponent;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void getChildBean(@RequestParam("bean") String beanName) {
        final Object bean = getBean(beanName);
        log.debug(">>> bean class name ::: {}", bean.getClass().getName());
        log.debug(">>> bean class simple name ::: {}", bean.getClass().getSimpleName());
        log.debug(">>> childBean name ::: {}", parentBean.getChildBeanName());
    }

    private Object getBean(String beanName) {
        final BeanType beanType = BeanType.getMatchingBeanType(beanName);
        return applicationContext.getBean(beanName, beanType.geType());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void inject(@RequestParam("bean") String beanName) {
        parentBean.setChildBean((ChildBean) getBean(beanName));
        log.debug(">>> childBean name ::: {}", parentBean.getChildBeanName());
    }


    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void field() {
        parentConstructComponent.calculate(1, 2, 3);
        log.debug(">>> parentConstructComponent :: {}", parentConstructComponent.getParentResult());
        parentFiledComponent.calculate(1, 2, 3);
        log.debug(">>> parentFiledComponent :: {}", parentFiledComponent.getParentResult());
    }

    @ExceptionHandler
    public void handleException(Exception exception) {
        log.error(exception.getMessage(), exception);
    }
}
