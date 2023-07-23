package cn.topicstudy.jutil.common.enums;

/**
 * 性别
 */
public enum GenderEnum {
    FEMALE("0", "女"),
    MALE("1", "男");


    private String value;
    private String desc;

    GenderEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
