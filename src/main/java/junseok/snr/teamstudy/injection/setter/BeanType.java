package junseok.snr.teamstudy.injection.setter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum BeanType {
    A_CHILD("AChildBean") {
        @Override
        public Class<AChildBean> geType() {
            return AChildBean.class;
        }
    },
    B_CHILD("BChildBean") {
        @Override
        public Class<BChildBean> geType() {
            return BChildBean.class;
        }
    },
    PARENT("parentBean") {
        @Override
        public Class<ParentBean> geType() {
            return ParentBean.class;
        }
    };

    private final String name;
    public abstract Class<?> geType();

    public static BeanType getMatchingBeanType(String beanName) {
        return Stream.of(BeanType.values())
                .filter(beanType -> beanType.getName().equals(beanName))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
