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
import java.util.Collection;

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
//        String fieldName = field.getName();
        for (Annotation annotation : annotations) {
            validateFieldByConstraint(fieldVal, annotation, errorCode);
        }
    }

    private void validateFieldByConstraint(Object fieldVal, Annotation annotation, String errorCode) {
        if (annotation instanceof NotNull) {
            NotNull a = (NotNull) annotation;
            String errCode = StringUtil.isNotBlank(errorCode) ? errorCode : a.errorCode();
            CommonAssertUtil.throwException(fieldVal == null, errCode, a.message());
        } else if (annotation instanceof NotBlank) {
            NotBlank a = (NotBlank) annotation;
            String errCode = StringUtil.isNotBlank(errorCode) ? errorCode : a.errorCode();
            String value = (String) fieldVal;
            CommonAssertUtil.throwException(StringUtil.isBlank(value), errCode, a.message());
        } else if (annotation instanceof NotEmpty) {
            NotEmpty a = (NotEmpty) annotation;
            String errCode = StringUtil.isNotBlank(errorCode) ? errorCode : a.errorCode();
            Collection value = (Collection) fieldVal;
            CommonAssertUtil.throwException(CollectionUtil.isEmpty(value), errCode, a.message());
        } else if (annotation instanceof Range) {
            Range a = (Range) annotation;
            String errCode = StringUtil.isNotBlank(errorCode) ? errorCode : a.errorCode();
            long MIN_VALUE = a.min();
            long MAX_VALUE = a.max();
            Number value = (Number) fieldVal;
            boolean isInRange = value != null
                    && (value.longValue() >= MIN_VALUE && value.longValue() < MAX_VALUE);
            CommonAssertUtil.throwException(!isInRange, errCode, a.message());
        } else if (annotation instanceof Length) {
            Length a = (Length) annotation;
            long MIN_LENGTH = a.min();
            long MAX_LENGTH = a.max();
            String value = (String) fieldVal;
            boolean isSuitable = value != null && (value.length() >= MIN_LENGTH && value.length() < MAX_LENGTH);
            String errCode = StringUtil.isNotBlank(errorCode) ? errorCode : a.errorCode();
            CommonAssertUtil.throwException(!isSuitable, errCode, a.message());
        }
    }
}
