package cn.topicstudy.jutil.basic.text.html;

import cn.topicstudy.jutil.basic.text.StringUtil;

public class HtmlUtil {
    /**
     * 解析单层html标签
     *
     * @param singleLayerHtmlTag 例如：<A HREF="https://www.zhihu.com/question/336108123" ICON="data:image/png;ba..”>知乎</A>
     * @return
     */
    public static SingleLayerHtmlTag parseSingleLayerHtmlTag(String singleLayerHtmlTag, String tagName, Boolean closed) {
        if (StringUtil.isBlank(singleLayerHtmlTag)) return null;
        if (StringUtil.isBlank(tagName)) return null;

        SingleLayerHtmlTag htmlTag = new SingleLayerHtmlTag();
        htmlTag.setTagName(tagName);
        htmlTag.setClosed(closed);

        // text
        if (closed) {
            String text = singleLayerHtmlTag.substring(singleLayerHtmlTag.indexOf(">"), singleLayerHtmlTag.lastIndexOf("<"));
            htmlTag.setText(text);
        }

        // attributeMap
        // <A HREF="https://www.zhihu.com/question/336108123" ICON="data:image/png;ba..”>
        String left = singleLayerHtmlTag.substring(0, singleLayerHtmlTag.indexOf(">") + 1);
        String[] attrs = left.split("\\s");// \s匹配空白
        for (String attr : attrs) {// 匹配不到时返回left,所以attrs一定非null
            // attrs is:
            //<A
            //HREF="https://www.zhihu.com/question/336108123"
            //ICON="data:image/png;ba..”>
            if (!attr.contains("=")) continue;
            String[] kv = attr.split("=");
            String k = kv[0];
            String v = kv[1];
            htmlTag.getAttributeMap().put(k, v);
        }
        return htmlTag;
    }
}
