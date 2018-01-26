package me.maiz.common.validation;

import com.google.common.collect.Maps;
import me.maiz.common.exceptions.ValidationException;
import me.maiz.common.web.BaseForm;

import javax.validation.ConstraintViolation;
import java.util.Map;
import java.util.Set;

/**
 * Created by Lucas on 2017-03-03.
 */
public class ValidateUtil {

    /**
     * 验证Form
     *
     * @param form
     * @return
     */
    public static void validate(BaseForm form) {
        Map<String, String> result = Maps.newHashMap();
        Set<ConstraintViolation<BaseForm>> constraintViolations = DCValidatorFactory.getValidator().validate(form);
        if(!constraintViolations.isEmpty()) {
            for (ConstraintViolation v : constraintViolations) {
                result.put(v.getPropertyPath().toString(), v.getMessage());
            }
            throw new ValidationException(result);
        }
    }

}
