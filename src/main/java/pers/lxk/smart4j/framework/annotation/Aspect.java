package pers.lxk.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * @Description: 切面注解 P143
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    Class<? extends Annotation> value();
}
