package cn.topicstudy.jutil.area.division;

enum DivisionTypeEnum {
    PROVINCE("PROVINCE", "省"),
    CITY("CITY", "市"),
    DISTRICT("DISTRICT", "区");

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    DivisionTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
