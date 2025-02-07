package cn.topicstudy.jutil.validation;

import cn.topicstudy.jutil.basic.error.BizException;
import com.alibaba.fastjson2.JSON;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldConstraintValidatorTest extends TestCase {
    FieldConstraintValidator fieldConstraintValidator = new FieldConstraintValidator();
    CreateUserParam param = new CreateUserParam();
    String ERROR_CODE = "ERROR_CODE_001";

    public void setUp() throws Exception {
        super.setUp();
        param.setObjectForTestNull(new Object());
        param.setStringForTestBlank("1");
        param.setIntForTestRange(101);
        param.setListForTestEmpty(new ArrayList() {{
            add(1);
        }});
        param.setStringForTestLength("33");
        param.setDateForTestDateFormat("2020-03-04 13:02");
    }

    public void tearDown() throws Exception {
    }


    public void testValidate() {

        try {
            fieldConstraintValidator.validate(param, "ERROR_CODE_001");
        } catch (BizException bizException) {
            System.out.println(bizException.getErrorCode() + "," + bizException.getErrorMsg());
        }
    }

    public void testNotNull() {
        BizException exception = null;

        // null
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setObjectForTestNull(null);
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals(exception.getErrorCode(), ERROR_CODE);

        // not null
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setObjectForTestNull(new Object());
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
            exception = null;
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNull(exception);
    }


    public void testNotBlank() {
        BizException exception = null;

        // Blank
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setStringForTestBlank(null);
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals(exception.getErrorCode(), ERROR_CODE);

        // not blank
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setStringForTestBlank("t");
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
            exception = null;
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNull(exception);
    }

    public void testNotEmpty() {
        BizException exception = null;

        // empty
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setListForTestEmpty(new ArrayList());
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals(exception.getErrorCode(), ERROR_CODE);

        // not empty
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setListForTestEmpty(Arrays.asList(1,2));
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
            exception = null;
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNull(exception);
    }

    public void testRange() {
        BizException exception = null;

        // out of range
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setIntForTestRange(1);
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals(exception.getErrorCode(), ERROR_CODE);

        // in the range
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setIntForTestRange(100);
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
            exception = null;
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNull(exception);
    }


    public void testLength() {
        BizException exception = null;

        // out of range
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setStringForTestLength("11111");
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals(exception.getErrorCode(), ERROR_CODE);

        // in the range
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setStringForTestLength("11");
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
            exception = null;
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNull(exception);
    }

    public void testDateFormat() {
        BizException exception = null;

        // Failed
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setDateForTestDateFormat("2022");
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNotNull(exception);
        Assert.assertEquals(exception.getErrorCode(), ERROR_CODE);

        // OK
        try {
            CreateUserParam createUserParam = JSON.parseObject(JSON.toJSONString(param), CreateUserParam.class);
            createUserParam.setDateForTestDateFormat("2020-03-22 08:15");
            fieldConstraintValidator.validate(createUserParam, "ERROR_CODE_001");
            exception = null;
        } catch (BizException bizException) {
            exception = bizException;
        }
        Assert.assertNull(exception);
    }


}
