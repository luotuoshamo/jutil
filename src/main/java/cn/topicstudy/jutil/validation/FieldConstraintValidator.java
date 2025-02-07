package cn.topicstudy.jutil.validation;

import cn.topicstudy.jutil.basic.collection.CollectionUtil;
import cn.topicstudy.jutil.basic.error.BizException;
import cn.topicstudy.jutil.basic.error.CommonAssertUtil;
import cn.topicstudy.jutil.basic.text.StringUtil;
import cn.topicstudy.jutil.basic.error.JutilErrorCodeEnum;
import cn.topicstudy.jutil.validation.constraint.*;
import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Data
public class FieldConstraintValidator implements ConstraintValidator {
    @Deprecated
    @Override
    public void validate(Object obj) {
        try {
            CommonAssertUtil.throwException(obj == null, JutilErrorCodeEnum.VALIDATION_OBJ_IS_NULL);
            Class<?> cls = obj.getClass();
            Field[] fields = cls.getDeclaredFields();

            // 无任何字段
            if (fields == null || fields.length == 0) {
                return;
            }
            for (Field field : fields) {
                field.setAccessible(true);
                validateField(field, obj, null);
            }
            return;
        } catch (BizException t) {
            throw t;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    @Override
    public void validate(Object obj, String errorCode) {
        try {
            CommonAssertUtil.throwException(obj == null, JutilErrorCodeEnum.VALIDATION_OBJ_IS_NULL);
            Class<?> cls = obj.getClass();
            Field[] fields = cls.getDeclaredFields();

            if (fields == null || fields.length == 0) {
                return;
            }
            for (Field field : fields) {
                field.setAccessible(true);
                validateField(field, obj, errorCode);
            }
            return;
        } catch (BizException t) {
            throw t;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private void validateField(Field field, Object obj, String errorCode) throws IllegalAccessException {
        if (field == null) {
            return;
        }

        Annotation[] annotations = field.getAnnotations();

        if (annotations == null || annotations.length == 0) {
            return;
        }
        Object fieldVal = field.get(obj);
        String fieldName = field.getName();
        for (Annotation annotation : annotations) {
            validateFieldByConstraint(fieldName, fieldVal, annotation, errorCode);
        }
    }

    /**
     * @param fieldName
     * @param fieldVal   if it's null, I'll skip check, you can use @NotNull before.
     * @param annotation
     * @param errorCode
     */
    private void validateFieldByConstraint(String fieldName, Object fieldVal, Annotation annotation, String errorCode) {
        if (annotation instanceof NotNull) {
            NotNull a = (NotNull) annotation;
            String errCode = StringUtil.isNotBlank(a.errorCode()) ? a.errorCode() : errorCode;
            String errMsg = StringUtil.isNotBlank(a.message()) ? a.message() : fieldName + " is required";
            CommonAssertUtil.throwException(fieldVal == null, errCode, errMsg);
        } else if (annotation instanceof NotBlank) {
            NotBlank a = (NotBlank) annotation;
            String errCode = StringUtil.isNotBlank(a.errorCode()) ? a.errorCode() : errorCode;
            String errMsg = StringUtil.isNotBlank(a.message()) ? a.message() : fieldName + " is required";
            CommonAssertUtil.throwException(StringUtil.isBlank((String) fieldVal), errCode, errMsg);
        } else if (annotation instanceof NotEmpty) {
            NotEmpty a = (NotEmpty) annotation;
            String errCode = StringUtil.isNotBlank(a.errorCode()) ? a.errorCode() : errorCode;
            String errMsg = StringUtil.isNotBlank(a.message()) ? a.message() : fieldName + " is required";
            CommonAssertUtil.throwException(fieldVal != null && CollectionUtil.isEmpty((Collection) fieldVal), errCode, errMsg);
        } else if (annotation instanceof Range) {
            Range a = (Range) annotation;
            String errCode = StringUtil.isNotBlank(a.errorCode()) ? a.errorCode() : errorCode;
            CommonAssertUtil.throwException(a.numberType() == null, errCode, "numberType of @Range is required");

            Map<Class<? extends Number>, Function<String, ? extends Number>> converterMap = new HashMap<>();
            converterMap.put(Integer.class, Integer::parseInt);
            converterMap.put(Double.class, Double::parseDouble);
            converterMap.put(Long.class, Long::parseLong);
            converterMap.put(Float.class, Float::parseFloat);
            Function<String, ? extends Number> convertFunction = converterMap.get(a.numberType());
            CommonAssertUtil.throwException(convertFunction == null, errCode, "@Range can only be used for Integer, Long, Double, and Float");

            Number min = convertFunction.apply(a.min());
            Number max = convertFunction.apply(a.max());
            if (fieldVal != null) {
                Number value = (Number) fieldVal;
                boolean isOutOfRange = value.doubleValue() < min.doubleValue() ||
                        value.doubleValue() >= max.doubleValue();
                String errMsg = StringUtil.isNotBlank(a.message()) ? a.message() : String.format("%s value needs to be within the range [%s, %s)", fieldName, min, max);
                CommonAssertUtil.throwException(isOutOfRange, errCode, errMsg);
            }
        } else if (annotation instanceof Length) {
            Length a = (Length) annotation;
            long minLength = a.min();
            long maxLength = a.max();
            String errCode = StringUtil.isNotBlank(a.errorCode()) ? a.errorCode() : errorCode;
            if (fieldVal != null) {
                CommonAssertUtil.throwException(!(fieldVal instanceof String), errCode, fieldName + "@Length can only be used for String");
                String value = (String) fieldVal;
                boolean isSuitable = (value.length() >= minLength) && (value.length() < maxLength);
                String errMsg = StringUtil.isNotBlank(a.message()) ? a.message() : String.format("%s value's length needs to be within the range [%s, %s)", fieldName, minLength, maxLength);
                CommonAssertUtil.throwException(!isSuitable, errCode, errMsg);
            }
        } else if (annotation instanceof DateFormat) {
            DateFormat a = (DateFormat) annotation;
            String errCode = StringUtil.isNotBlank(a.errorCode()) ? a.errorCode() : errorCode;
            if (fieldVal != null) {
                CommonAssertUtil.throwException(!(fieldVal instanceof String), errCode, fieldName + "@DateFormat can only be used for String");
                String value = (String) fieldVal;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(a.format());
                try {
                    LocalDateTime.parse(value, formatter);
                } catch (DateTimeParseException e) {
                    try {
                        LocalDate.parse(value, formatter);
                    } catch (DateTimeParseException ee) {
                        e.printStackTrace();
                        String errMsg = StringUtil.isNotBlank(a.message()) ? a.message() : fieldName + " needs in the format " + a.format();
                        CommonAssertUtil.throwException(true, errCode, errMsg);
                    }
                }
            }
        }
    }
}
