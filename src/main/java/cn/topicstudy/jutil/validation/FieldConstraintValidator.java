package cn.topicstudy.jutil.validation;

import cn.topicstudy.jutil.basic.text.StringUtil;
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
    public List<ConstraintUnsatisfiedInfo> validate(Object obj) {
        List<ConstraintUnsatisfiedInfo> unsatisfiedInfoList = new ArrayList();
        try {
            if (obj == null) {
                return null;
            }
            Class<?> cls = obj.getClass();
            Field[] fields = cls.getDeclaredFields();
            if (fields == null || fields.length == 0) {
                return null;
            }
            for (Field field : fields) {
                field.setAccessible(true);
                List<ConstraintUnsatisfiedInfo> fieldUnsatisfiedInfoList = validateField(field, obj);
                if (fieldUnsatisfiedInfoList != null) {
                    unsatisfiedInfoList.addAll(fieldUnsatisfiedInfoList);
                }
            }
            return unsatisfiedInfoList;
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private List<ConstraintUnsatisfiedInfo> validateField(Field field, Object obj) throws IllegalAccessException {
        if (field == null) {
            return null;
        }

        List<ConstraintUnsatisfiedInfo> unsatisfiedInfoList = new ArrayList<>();

        Annotation[] annotations = field.getAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        Object fieldVal = field.get(obj);
        String fieldName = field.getName();
        for (Annotation annotation : annotations) {
            ConstraintUnsatisfiedInfo unsatisfiedInfo = validateFieldByConstraint(fieldName, fieldVal, annotation);
            if (unsatisfiedInfo != null) {
                unsatisfiedInfoList.add(unsatisfiedInfo);
            }
        }
        return unsatisfiedInfoList;
    }

    private ConstraintUnsatisfiedInfo validateFieldByConstraint(String fieldName, Object fieldVal, Annotation annotation) {
        if (annotation instanceof NotNull) {
            NotNull a = (NotNull) annotation;
            if (fieldVal == null) {
                return new ConstraintUnsatisfiedInfo(fieldName, null, a.message());
            }
        } else if (annotation instanceof NotBlank) {
            NotBlank a = (NotBlank) annotation;
            String value = (String) fieldVal;
            if (StringUtil.isBlank(value)) {
                return new ConstraintUnsatisfiedInfo(fieldName, value, a.message());
            }
        } else if (annotation instanceof NotEmpty) {
            NotEmpty a = (NotEmpty) annotation;
            Collection value = (Collection) fieldVal;
            if (value == null || value.isEmpty()) {
                return new ConstraintUnsatisfiedInfo(fieldName, value, a.message());
            }
        } else if (annotation instanceof Range) {
            Range a = (Range) annotation;
            long MIN_VALUE = a.min();
            long MAX_VALUE = a.max();
            Number value = (Number) fieldVal;
            // 如果需要校验null，加上@NotNull
            if (value == null) {
                return null;
            }
            if (value.longValue() < MIN_VALUE) {
                String msg = StringUtil.isBlank(a.message()) ? "不可小于最小值：" + MIN_VALUE : a.message();
                return new ConstraintUnsatisfiedInfo(fieldName, value, msg);
            }
            if (value.longValue() > MAX_VALUE) {
                String msg = StringUtil.isBlank(a.message()) ? "不可大于最大值：" + MAX_VALUE : a.message();
                return new ConstraintUnsatisfiedInfo(fieldName, value, msg);
            }
        } else if (annotation instanceof Length) {
            Length a = (Length) annotation;
            long MIN_LENGTH = a.min();
            long MAX_LENGTH = a.max();
            String value = (String) fieldVal;
            if (value == null) {
                return null;
            }
            if (value.length() < MIN_LENGTH) {
                String msg = StringUtil.isBlank(a.message()) ? "不可小于最小长度：" + MIN_LENGTH : a.message();
                return new ConstraintUnsatisfiedInfo(fieldName, value, msg);
            }
            if (value.length() > MAX_LENGTH) {
                String msg = StringUtil.isBlank(a.message()) ? "不可大于最大长度：" + MAX_LENGTH : a.message();
                return new ConstraintUnsatisfiedInfo(fieldName, value, msg);
            }
        }

        return null;
    }
}
