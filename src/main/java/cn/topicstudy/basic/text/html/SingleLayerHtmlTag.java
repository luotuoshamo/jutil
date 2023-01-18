package cn.topicstudy.basic.text.html;

import java.util.HashMap;
import java.util.Map;

/**
 * 单层html标签，例如：<A HREF="https://www.zhihu.com/question/336108123" ICON="data:image/png;ba..”>知乎</A>
 */
public class SingleLayerHtmlTag {
    private String text;
    private Map<String, String> attributeMap = new HashMap();
    private String tagName;// 标签名称，例如：A
    private Boolean closed;// 是否有结束标签

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, String> getAttributeMap() {
        return attributeMap;
    }

    public void setAttributeMap(Map<String, String> attributeMap) {
        this.attributeMap = attributeMap;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getAttribute(String attributeName) {
        return attributeMap.get(attributeName);
    }

    @Override
    public String toString() {
        return "SingleLayHtmlTag{" +
                "text='" + text + '\'' +
                ", attributeMap=" + attributeMap +
                ", tagName='" + tagName + '\'' +
                ", closable=" + closed +
                '}';
    }
}
