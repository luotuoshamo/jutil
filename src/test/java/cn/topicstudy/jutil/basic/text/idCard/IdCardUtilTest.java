package cn.topicstudy.jutil.basic.text.idCard;

import cn.topicstudy.jutil.common.enums.GenderEnum;
import cn.topicstudy.jutil.area.division.ProvinceEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class IdCardUtilTest {
    private String idcard_Blank, idCart_NotLegal, idCart_BeijingMale, idCart_Hunan_Female;

    @Before
    public void setup() {
        idcard_Blank = "";
        idCart_NotLegal = "12345678";
        idCart_BeijingMale = "110101199003070273";
        idCart_Hunan_Female = "430102200503077806";
    }

    @Test
    public void isLegal() {
        assertThrows("身份证号码不可为空", RuntimeException.class, () -> IdCardUtil.isLegal(idcard_Blank));
        assertThrows("只支持18位身份证号码", RuntimeException.class, () -> IdCardUtil.isLegal(idCart_NotLegal));
    }

    @Test
    public void getGender() {
        Assert.assertEquals(IdCardUtil.getGender(idCart_BeijingMale), GenderEnum.MALE);
        Assert.assertEquals(IdCardUtil.getGender(idCart_Hunan_Female), GenderEnum.FEMALE);
    }

    @Test
    public void getBirthday() {
        assertEquals(IdCardUtil.getBirthday(idCart_BeijingMale), "19900307");
    }

    @Test
    public void getProvince() {
        Assert.assertEquals(IdCardUtil.getProvince(idCart_BeijingMale), ProvinceEnum.BEI_JING);
        Assert.assertEquals(IdCardUtil.getProvince(idCart_Hunan_Female), ProvinceEnum.HU_NAN);
    }
}
