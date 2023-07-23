package cn.topicstudy.jutil.basic.text.idCard;

import cn.topicstudy.jutil.basic.text.StringUtil;
import cn.topicstudy.jutil.common.enums.GenderEnum;
import cn.topicstudy.jutil.area.division.ProvinceEnum;

/**
 * 该类只支持18身份证号码
 * <p>
 * 18位身份证号码：
 * (1）第1、2位：省份
 * （2）第3、4位：城市
 * （3）第5、6位：区县
 * （4）第7~14位：出生年、月、日
 * （5）第15、16位：户口所在地派出所的号码
 * （6）第17位：性别，奇数表示男，偶数表示女
 * （7）第18位：校检码，是根据前十七位数字计算出来的
 */
public class IdCardUtil {
    /**
     * 校验是否是合法的身份证号码
     */
    public static boolean isLegal(String idCardNo) {
        if (StringUtil.isBlank(idCardNo)) throw new RuntimeException("身份证号码不可为空");
        else if (idCardNo.length() != 18) throw new RuntimeException("只支持18位身份证号码");
        return true;
    }

    /**
     * 获取性别
     */
    public static GenderEnum getGender(String idCardNo) {
        isLegal(idCardNo);
        return Integer.parseInt(idCardNo.charAt(16) + "") % 2 == 0
                ? GenderEnum.FEMALE : GenderEnum.MALE;
    }

    /**
     * 获取生日
     *
     * @return 例如 "20050126"
     */
    public static String getBirthday(String idCardNo) {
        isLegal(idCardNo);
        return idCardNo.substring(6, 14);
    }

    /**
     * 通过省份证号码获取省
     */
    public static ProvinceEnum getProvince(String idCardNo) {
        isLegal(idCardNo);
        return ProvinceEnum.getProvinceByCode(idCardNo.substring(0, 2));
    }
}
