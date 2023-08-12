package cn.topicstudy.jutil.area.division;

import lombok.Data;

@Data
public class Division {
    private String code;
    private String name;
    private DivisionTypeEnum divisionType;

    public Division(String code, String name, DivisionTypeEnum divisionType) {
        this.code = code;
        this.name = name;
        this.divisionType = divisionType;
    }
}
