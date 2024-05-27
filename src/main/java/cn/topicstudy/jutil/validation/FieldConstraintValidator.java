package cn.topicstudy.jutil.validation;

import cn.topicstudy.jutil.basic.collection.CollectionUtil;
import cn.topicstudy.jutil.basic.error.BizException;
import cn.topicstudy.jutil.basic.error.CommonAssertUtil;
import cn.topicstudy.jutil.basic.text.StringUtil;
import cn.topicstudy.jutil.common.JutilErrorCodeEnum;
import cn.topicstudy.jutil.validation.constraint.*;
import lombok.Data;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class FieldConstraintValidator implements ConstraintValidator {
    @Override
    public void validate(Object obj, boolean isCheckAll) {
        List<ConstraintUnsatisfiedInfo> unsatisfiedInfoList = new ArrayList();
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
                validateField(field, obj);
            }
            return;
        } catch (BizException t) {
            throw t;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private void validateField(Field field, Object obj) throws IllegalAccessException {
        if (field == null) {
            return;
        }

        Annotation[] annotations = field.getAnnotations();

        // 没加注解的字段不校验
        if (annotations == null || annotations.length == 0) {
            return;
        }
        Object fieldVal = field.get(obj);
        String fieldName = field.getName();
        for (Annotation annotation : annotations) {
            validateFieldByConstraint(fieldName, fieldVal, annotation);
        }
    }

    private void validateFieldByConstraint(String fieldName, Object fieldVal, Annotation annotation) {
        if (annotation instanceof NotNull) {
            NotNull a = (NotNull) annotation;
            CommonAssertUtil.throwException(fieldVal == null, a.errorCode(), a.message());
        } else if (annotation instanceof NotBlank) {
            NotBlank a = (NotBlank) annotation;
            String value = (String) fieldVal;
            CommonAssertUtil.throwException(StringUtil.isBlank(value), a.errorCode(), a.message());
        } else if (annotation instanceof NotEmpty) {
            NotEmpty a = (NotEmpty) annotation;
            Collection value = (Collection) fieldVal;
            CommonAssertUtil.throwException(CollectionUtil.isEmpty(value), a.errorCode(), a.message());
        } else if (annotation instanceof Range) {
            Range a = (Range) annotation;
            long MIN_VALUE = a.min();
            long MAX_VALUE = a.max();
            Number value = (Number) fieldVal;
            // null的话也是不满足范围的
            String msg = String.format("参数值为null，不满足范围：%s~%s", MIN_VALUE, MAX_VALUE);
            CommonAssertUtil.throwException(value == null, a.errorCode(), msg);
            msg = StringUtil.isBlank(a.message()) ? "不可小于最小值：" + MIN_VALUE : a.message();
            CommonAssertUtil.throwException(value.longValue() < MIN_VALUE, a.errorCode(), msg);
            msg = StringUtil.isBlank(a.message()) ? "不可大于最大值：" + MAX_VALUE : a.message();
            CommonAssertUtil.throwException(value.longValue() > MAX_VALUE, a.errorCode(), msg);
        } else if (annotation instanceof Length) {
            Length a = (Length) annotation;
            long MIN_LENGTH = a.min();
            long MAX_LENGTH = a.max();
            String value = (String) fieldVal;
            String msg = String.format("参数值为null，不满足长度范围：%s~%s", MIN_LENGTH, MAX_LENGTH);
            CommonAssertUtil.throwException(value == null, a.errorCode(), msg);
            msg = StringUtil.isBlank(a.message()) ? "不可小于最小长度：" + MIN_LENGTH : a.message();
            CommonAssertUtil.throwException(value.length() < MIN_LENGTH, a.errorCode(), msg);
            msg = StringUtil.isBlank(a.message()) ? "不可大于最大长度：" + MAX_LENGTH : a.message();
            CommonAssertUtil.throwException(value.length() > MAX_LENGTH, a.errorCode(), msg);
        }
    }
}
