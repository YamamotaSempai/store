package kz.aa.store.orders.annotation.validator;

import kz.aa.store.orders.annotation.FullOrderCheck;
import kz.aa.store.orders.model.dto.OrderDto;
import kz.aa.store.orders.model.dto.OrderItemDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
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
        if (orderDto.getOrderItemDtoList() == null || checkAllOrderItem(orderDto.getOrderItemDtoList())) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Проверьте заполненные данные")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }

    private boolean checkAllOrderItem(List<OrderItemDto> orderItemDtos) {
        for (OrderItemDto orderItemDto : orderItemDtos) {
            if (orderItemDto.getId() == null)
                return true;
        }

        return false;
    }
}
