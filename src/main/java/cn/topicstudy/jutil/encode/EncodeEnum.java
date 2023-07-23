package cn.topicstudy.jutil.encode;

/**
 * 编码类型
 */
public enum EncodeEnum {
    MD5("MD5"), SHA128(""), BASE64("BASE64");
    private String value;

    EncodeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
