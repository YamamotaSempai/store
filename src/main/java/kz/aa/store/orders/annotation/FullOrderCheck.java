package kz.aa.store.orders.annotation;

import kz.aa.store.orders.annotation.validator.FullOrderCheckValidator;
import org.springframework.messaging.handler.annotation.Payload;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FullOrderCheckValidator.class)
public @interface FullOrderCheck {
    Class<? extends Payload>[] payload() default {};
    String message() default "";
    Class<?>[] groups() default {};
}
