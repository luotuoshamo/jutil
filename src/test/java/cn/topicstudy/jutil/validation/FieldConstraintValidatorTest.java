package cn.topicstudy.jutil.validation;

import cn.topicstudy.jutil.basic.error.BizException;
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
        try{
            fieldConstraintValidator.validate(param, "ERROR_CODE_001");

        }catch (BizException bizException){
            System.out.println(bizException.getErrorCode()+","+bizException.getErrorMsg());
        }
    }
}
