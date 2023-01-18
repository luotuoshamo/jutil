package cn.topicstudy.area.division;

import cn.topicstudy.basic.text.StringUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DivisionUtil {
    private static List<Division> divisions = new ArrayList<>();

    /**
     * 解析 chinaDivision2020.txt
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        initDivisions();
    }

    public static void initDivisions() throws IOException {
        FileReader fr = new FileReader("./src/main/java/com/wjh/area/division/chinaDivision2020.txt");
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            line = StringUtil.deepTrim(line);
            String[] arr = line.split("\t");
            String divisionCode = arr[0].trim();
            String divisionName = arr[1].trim();
            Division division = new Division(divisionCode, divisionName, getDivisionTypeByCode(divisionCode));
            divisions.add(division);
        }

        //String s = JSON.toJSONString(divisions);
        //FileWriter fw = new FileWriter("./src/main/java/com/wjh/area/division/chinaDivision2020.json");
        //fw.write(s);
        //fw.flush();//否则write buffer中有残留，导致json文件不完整
    }

    public static List<Division> allDivisions(){
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
