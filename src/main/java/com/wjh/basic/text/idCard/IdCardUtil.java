package com.wjh.basic.text.idCard;

import com.wjh.basic.text.StringUtil;
import com.wjh.basic.entity.Result;

/**
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
     * 暂时这么写...
     */
    public static Result isLegal(String idCardNo) {
        if (StringUtil.isBlank(idCardNo)) {
            return new Result(false, "身份证号码不可为空");
        } else if (idCardNo.length() != 18) {
            return new Result(false, "只支持18位身份证号码");
        }
        return new Result(true, "身份证合法");
    }

    /**
     * 获取性别
     */
    public static String getGender(String idCardNo) {
        return Integer.parseInt(idCardNo.charAt(16) + "") % 2 == 0 ? "female" : "male";
    }

    /**
     * 获取生日
     *
     * @return
     */
    public static String getBirthday(String idCardNo) {
        isLegal(idCardNo);
        return idCardNo.substring(6, 14);
    }

    /**
     * 通过省份证号码获取省
     */
    public static String getProvince(String idCardNo){
        isLegal(idCardNo);
        return ProvinceUtil.getProvinceNameByCode(idCardNo.substring(0, 2));
    }

    public static void main(String[] args) {
        String sfz = "140105199003073870";//山西
        System.out.println(getBirthday(sfz));
    }
}
