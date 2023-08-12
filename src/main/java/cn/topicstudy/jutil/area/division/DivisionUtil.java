package cn.topicstudy.jutil.area.division;

import cn.topicstudy.jutil.basic.text.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class DivisionUtil {
    private static List<Division> divisions = new ArrayList<>();

    static {
        try {
            initDivisions();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void initDivisions() throws IOException {
        InputStream inputStream = DivisionUtil.class.getClassLoader().getResourceAsStream("cn/topicstudy/jutil/area/division/chinaDivision2020.properties");
        Properties properties = new Properties();
        // 不用reader的话中文会乱码
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        properties.load(bufferedReader);
        Set<String> propertyNames = properties.stringPropertyNames();
        for (String propertyName : propertyNames) {
            String divisionCode = propertyName;
            Division division = new Division(divisionCode, properties.getProperty(propertyName), getDivisionTypeByCode(divisionCode));
            divisions.add(division);
        }
    }

    public static List<Division> allDivisions() {
        return divisions;
    }

    /**
     * @param divisionCode 六位的code 例如：130000 河北省, 130100 石家庄市,130102 长安区
     */
    public static DivisionTypeEnum getDivisionTypeByCode(String divisionCode) {
        if (StringUtil.isBlank(divisionCode)) throw new RuntimeException("divisionCode is blank");
        String c2 = divisionCode.charAt(2) + "";
        String c3 = divisionCode.charAt(3) + "";
        String c4 = divisionCode.charAt(4) + "";
        String c5 = divisionCode.charAt(5) + "";
        if ("0".equals(c2) && "0".equals(c3) && "0".equals(c4) && "0".equals(c5)) return DivisionTypeEnum.PROVINCE;
        else if ("0".equals(c4) && "0".equals(c5)) return DivisionTypeEnum.CITY;
        else return DivisionTypeEnum.DISTRICT;
    }

    public static Division getDivisionByCode(String divisionCode) {
        if (StringUtil.isBlank(divisionCode)) return null;
        return divisions.stream().filter(d -> divisionCode.equals(d.getCode())).findFirst().get();
    }

    public static Division getDivisionByName(String divisionName) {
        if (StringUtil.isBlank(divisionName)) return null;
        return divisions.stream().filter(d -> d.getName().equals(divisionName)).findFirst().get();
    }
}
