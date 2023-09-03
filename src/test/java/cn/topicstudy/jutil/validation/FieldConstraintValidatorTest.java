package cn.topicstudy.jutil.validation;

import junit.framework.TestCase;

import java.util.List;

public class FieldConstraintValidatorTest extends TestCase {
    FieldConstraintValidator fieldConstraintValidator = new FieldConstraintValidator();

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testValidate() {
        CreateUserParam param = new CreateUserParam();
        param.setName("张");
        param.setLength(500);
        List<ConstraintUnsatisfiedInfo> validate = fieldConstraintValidator.validate(param);
        System.out.println(validate);

    }
}
