package cn.topicstudy.area.division;

import cn.topicstudy.basic.collection.CollectionUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionUtilTest {

    @Before
    public void setUp() throws Exception {
//        DivisionUtil.initDivisions();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void initDivisions() {
        Assert.assertTrue(CollectionUtil.isNotEmpty(DivisionUtil.allDivisions()));
    }

    @Test
    public void getDivisionTypeByCode() {
        Division zhejiangShen = DivisionUtil.getDivisionByCode("330000");
        Assert.assertNotNull(zhejiangShen);
        assertEquals(zhejiangShen.getDivisionType(), DivisionTypeEnum.PROVINCE);
    }

    @Test
    public void getDivisionByCode() {
        Division nanJingXuanwuQu = DivisionUtil.getDivisionByCode("320102");
        Assert.assertNotNull(nanJingXuanwuQu);
        assertEquals(nanJingXuanwuQu.getName(), "玄武区");
    }

    @Test
    public void getDivisionByName() {
        Division nanJingXuanwuQu = DivisionUtil.getDivisionByName("玄武区");
        Assert.assertNotNull(nanJingXuanwuQu);
        assertEquals(nanJingXuanwuQu.getCode(), "320102");
    }
}
