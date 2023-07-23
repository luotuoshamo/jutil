package cn.topicstudy.jutil.area.division;

public class Division {
    private String code;
    private String name;
    private DivisionTypeEnum divisionType;

    public Division(String code, String name, DivisionTypeEnum divisionType) {
        this.code = code;
        this.name = name;
        this.divisionType = divisionType;
    }

    public Division() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DivisionTypeEnum getDivisionType() {
        return divisionType;
    }

    public void setDivisionType(DivisionTypeEnum divisionType) {
        this.divisionType = divisionType;
    }

    @Override
    public String toString() {
        return "Division{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", divisionType=" + divisionType +
                '}';
    }
}
