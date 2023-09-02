package cn.topicstudy.jutil.basic.error;

import junit.framework.TestCase;

public class CommonAssertUtilTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testThrowException() {
        CommonAssertUtil.throwException(true, TestJUtilErrorCodeEnum.ERROR1, "参数1", "参数2");
    }


}
