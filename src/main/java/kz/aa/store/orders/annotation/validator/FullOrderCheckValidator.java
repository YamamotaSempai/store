package kz.aa.store.orders.annotation.validator;

import kz.aa.store.orders.annotation.FullOrderCheck;
import kz.aa.store.orders.model.dto.OrderDto;
import kz.aa.store.orders.model.dto.OrderItem;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public class FullOrderCheckValidator implements ConstraintValidator<FullOrderCheck, OrderDto> {

    @Override
    public boolean isValid(OrderDto orderDto, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        if (orderDto.getAddress() == null) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Адрес не должен быть пустым")
                    .addConstraintViolation();
            return false;
        }
        if (orderDto.getPaymentType() == null) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Укажите тип оплаты")
                    .addConstraintViolation();
            return false;
        }
        if (orderDto.getOrderItemList() == null || checkAllOrderItem(orderDto.getOrderItemList())) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Проверьте заполненные данные")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

    private boolean checkAllOrderItem(List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getId() == null)
                return true;
        }

        return false;
    }
}
