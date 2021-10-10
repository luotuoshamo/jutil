package com.wjh.bookmark;

import com.wjh.basic.text.StringUtil;
import com.wjh.basic.text.html.HtmlUtil;
import com.wjh.basic.text.html.SingleLayerHtmlTag;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/**
 * 浏览器收藏夹-只能解析只有一层文件夹的收藏夹，对于文件夹中有文件夹的情况不支持
 */
public class BookmarkUtil {

    /**
     * @return
     * @ bk :
     * <DT><A HREF="https://www.baidu.com/" ADD_DATE="1633596305">百度一下，你就知道</A>
     * <DT><A HREF="https://live.baidu.com/" ADD_DATE="1633596325">百度直播</A>
     * <DT><H3 ADD_DATE="1633596393" LAST_MODIFIED="1633596413">study</H3>
     * <DL><p>
     * -----<DT><A HREF="https://github.com/" ADD_DATE="1633596375">GitHub</A>
     * -----<DT><A HREF="https://mail.yahoo.com/" ADD_DATE="1633596413">Yahoo Mail</A>
     * </DL><p>
     * <DT><H3 ADD_DATE="1633579173" LAST_MODIFIED="1633601614">购物</H3>
     * <DL><p>
     * -----<DT><A HREF="https://www.vip.com/" ADD_DATE="1633579240" ICON="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAAcUlEQVQ4jWO8wd3DQApggrPUv+Srf8lHlsMUYWBgYIFIEG8DC6YQpj0Qxk2eiVg0QKQhcshsnDagSWMBN7h7/v//TSS6wd3DguYATEvQHUapDfjZDMgRh+l1rPGDXQMegCXikC0hQQMDjnBjJD+1EgkA15SJFYP9X5QAAAAASUVORK5CYII=">国庆特卖节</A>
     * -----<DT><A HREF="https://www.jd.com/?cu=true&utm_source=baidu-pinzhuan&utm_medium=cpc&utm_campaign=t_288551095_baidupinzhuan&utm_term=0f3d30c8dba7459bb52f2eb5eba8ac7d_0_269230f277824152b7312760b67bfc22" ADD_DATE="1633579221" ICON="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAA8klEQVQ4jWM8IarEQApgIkk1ORpYkDnssjLsctKfjp7kszaHC369cv3vx0/YNYhGBEuX5p0UU9Zcvwwu+PfjpxezFjzpnkjASU+7J50UU77s5PPp2Enp0jz5lhqi/PDtyvVb8Rnvt++WSEskSgMEvF6xloGBAeIxojT8/YTwNFEa2GVlGBgY/nz8hK6BS0cTOQQhgJmfT7o07+fjJ9+uXGeABCszPx+flbmgp6ugpyvEuQwMDGyy0nzW5nxWFiIRQeyyMrfiM6AGnBBVuhYQ+f///z8fPr5avua0isEJUaX/SODdtl3XAiJPiCpBEOPgS3wA205g359INNYAAAAASUVORK5CYII=">京东(JD.COM)-正品低价、品质保障、配送及时、轻松购物！</A>
     * -----<DT><A HREF="https://www.dinghuale.com/?s=bdpc&p=12xhxyc&kw=xianhua&e_creative=40682873684&e_keywordid=182063588998&bd_vid=11352367127877714948" ADD_DATE="1633581548" ICON="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAADOElEQVQ4jW1TW2hcVRRde59z79yZyTQxIQlTGppUIaWJEtv4SEzBWvqjpGp12oIIimh9VRQVH/i4VBH7F7TU1BK1IFQ6lNoEq7TBRFFEjKhQQ6ugsUkTSHQmmXTmztzHPn4MRYmur/2x12LvxVoKK3GzqzE1LgCQad33fFft1jPrU5s3NBXaTk3hx2jlOl0e2vd/lbLSTa+z0jdGxnzG07MDnQdGvxTNnRqMUiB3nJh99eTv/avXt43MnrvMY2SMAgDVULvHqql7QiqlbsuyX4na0seDGucTjiIBkcBE1/m7E283J+mnubuangUAF2AGssCxjILiPyKvCLYcjrxLsHR8y9l9mQSVy8MGDq9O5usKkdpRCsUm0L1jgHYBYWR3RtiZjSbv78iGXu5hifxBUs5RFIoLTPqBxetbv/c9/1JHw/RFgnISmiAW3t8ChAZgAoA1Qwf3Kta7xS+tAps8aXsyFqRmYnW9fanJi0v1b4557/S/W98Yk/6lUA4HZ6JPfeHKlfmFU9QyeOAlVZN4TcplkAg44YCcBIpL3nzgmxMq3zl6ZPixdM+6qdu9eR6tTCBNTHsNgTiMtmko2iWeJyYIAk46Ma9IP1iFhQ+3rxnnep7p6b16/q++w7lK7pc4JDIvXmGrVFEEvjFRyFJWqe23xph5m4rZdsmPDd6XPjS0Y93puxtrcg81oPzdbX/W932TTh5sGV866ztcqQjmFGEiQPTCVfn851UPDg3cUFRp/XLLMy0ccz7QTiy2UAgmHlxOfNSQ0G8slpfb03eem/pP6AAwXPDMnie/HVi7azrUyfe8MltBEIpN8nGj1r1OjbJtjt9iAPo5A9sAZAA2AAMAZzaA4Lo8I+2PWzbFYYzvBwibfX2hFMnGYjEyIHoUx8AdWfhUja8QINULAMB1hUlsrQEjxgYZaiYsG1CqUIwQ02rTYnzTfgAwK1/IZqpKThxvlT05H1+lBYKhtfniFyEZsRSbZU9CED2dO9l1EwHGmH86xKCq6FObf/0tLHk9zLj2ua3nH7nmngt5S+N0bVIxYEQRQYSc/zOyin+pui7YADR3tKs1N7Lx69xwtyyNdB8Zc6FX0v4G4npmz/lFiQ4AAAAASUVORK5CYII=">订花乐 - 鲜花店_订花_送花_鲜花配送</A>
     * -----<DT><A HREF="https://www.hua.com/?sid=bda-j069-PC-22843876248&utm_source=baidua&utm_medium=cpc&utm_term=PC-22843876248-A069-%E4%B8%8A%E6%B5%B7%E7%BD%91%E4%B8%8A%E9%B2%9C%E8%8A%B1%E9%A2%84%E8%AE%A2&bd_vid=11305448690340143439" ADD_DATE="1633581535" ICON="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAACNklEQVQ4jX2SS0hVURSGv7XPUe+9PjCvNyGKyoSkC+FAdNSgHNSgh0lIIElNcpQgEU4KLJoFTZJQDKVQInuMoiAKokGD0sIIKk2EhDSuniwf971XA2/vgxsW7P2x97//9bMEnzX8nDIK8m8CDcBj60j70ZrkuN9d4wfJDxQB1YAD7BXLmYEpAnqZYLybzdpL3toCwYSH8vrnUZRDJTG3Lh6gLePyZNHSsqZAc5Ql68o1BG+VaCSYliYrtALbRGj9OkApgKtdmLkYNcawGyUkwpyFiZU7yXcvDuZ3Zx06EExBkvUqlOf+mCtNkQJwvRj1xtAHRBFQyAosFy7weddwauRDvTM0U+k+KJbUS6BJLK0a51ZsEqMgMt/OBZSzgPjmoZwPd9MFoMM4CyOcsnFaVJhFuGhUSQDW9zEgwvKvfTNZjRMCakXZj9JoHMsQ0A9MA16uvgBjahg0FeQt9VEBMDhByadq41jDK2AceC8AU8cJFIbY6AgREYy1eFrEt4IttIjhtMDobJlzY3Sb2yDovtCCXqq7m74dieH59w0s9nAE6AHCojAddp69qXKiooQRRpPWPXCsdmXGdw6+X2U7wjkgnEMJdXUKRHPBVgWM3QE+g6RduBhOouz8nSQzaUfuoTqfIxmbzSQA3P+sb6BSLI1/icLDEi/7iE2mHJUO0KcSyoz5OiBDBbDuD/JWLL1bT5CQj+nrSGpPUNOdzVGWVs3966CfCCmuAIcRJlXpLG7jvgjql9cPAD3SLc1SCokAAAAASUVORK5CYII=">鲜花网|花礼网-鲜花礼品网,领先鲜花速递网站,网上订花送花上门,同城鲜花快递网上花店</A>
     * -----<DT><A HREF="https://uland.taobao.com/sem/tbsearch?refpid=mm_26632258_3504122_32538762&keyword=%E5%A5%B3%E8%A3%85&clk1=2533eecd5030bcba67e913d852fe406f&upsId=2533eecd5030bcba67e913d852fe406f" ADD_DATE="1633579211" ICON="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAABK0lEQVQ4jZWTv07DMBDGf0bpzBLGSn2DdiBs5QEQa3iCSKiVyFqJnSFrBqpIeQGUNYqY2zELK1ulspGFGSQzGMf5YyP4JMuW7+67785nASD3hWRX8C9chohlKEQbfP+kDOsFPL6YswPN8YC/yfHYFfD2CkhAgDcxXt4E0rofWWXwnONPZzRJhNca4gu1p7VyurpV5zjoE2jCcqt2+XAj5WouW9ydq2VD9341l+/Xp/LEWuAwcxyMlfzAEKwXSrqW2K09rce90G2y3upsOsiRva8AVOPiwJ7NocAQ6Le3wREMuoRu8NdnvxdgBkr7VdmAYOhYbs07DxNUWc8m5L6QTRLhT2fuEizQoyxAfaYmiQBaouZ4+JXA3+SIZShGBj1hf1VincSz8mPM7MA3ERmaQnFl1eEAAAAASUVORK5CYII=">热卖PC搜索</A>
     * -----<DT><A HREF="https://www.pinduoduo.com/" ADD_DATE="1633579265" ICON="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAACp0lEQVQ4jT2SX0iVdxjHv8/vz3l9z6seNzUFMyt2YTRTV7K0rbbWVkJtCLIGLbpadwoOFkVddVFdxOguigi6KJoLspsxCPavbCsWYpkbm2ejDCrNjmXn5Pu+v9/z7ELZ5+pz8fnefSne8L4ABEApEAECz4sCApGQImFhBkCAYccEiNYyV+Q0JWspDEkYEFEGpaKkjqxBNgvvhaAPNDSxwM/M4M3V9FmvlOb5wSSTYhFfKEhrK3p7pFjifF4yGSbS++uWiojq+di91W42vYMd3cnkQzU7KyK09SPevFG3tWDDejFGJv5Fmur9VbXo7Aj2Dbw6eUbX17mRUWx5T08XWKvM0cN+aprG/4wvfCtbP9RBIHfG9L6aertnl/tlWIVl5t0uHYZ8acjf+wOe/d0x296mm5spdbh/37zd4X6+ZpghU09dVaVZ1picPe+v/mh277Q7utVrr7vrN0pf9OnNG826dsqGbDT7VAlpmX2uMwFyuXT4t3TqCerrEViOyqihgZ/OuJ+usTXCLv1rgpnocdPq6OsjvvBMReUUZJJTZ6WujqKslEcykVe2LOjb62/doupqVVNb/PKgHijLqRWNhlTp6g9BVyeLk6pc/M2V9Obv2c8/hdGelAlDrFzhRkaT4V+NaBsPfc9r1wTbPjAdbT6djy8ORscOYT5JbtzUQWCXN1I2TEfH48HLXoQml7VIHAu74JPtVB5RuQ2iClZWL28UpVz+b370zL+Yi4e+Q8aqIDDeORgD0aXBKygWowP9AMQY09oSj97xhZfF0+dgLVVWQMSnjv5ZsorEg0BKQWk3PWXXran8qp+8vDh+Irk9ZpbUioCYRQQA5WveWDzmAsbI3ByMgVJIUqqI4DwRLdQADPOCCYEASJIijCAMAUIriQNAhP8H/wEk302miuBtcgAAAABJRU5ErkJggg==">拼多多 新电商开创者</A>
     * </DL><p>
     */
    @Deprecated
    public static Bookmark parse(File bookmarkHtmlFile) throws IOException {
        if (bookmarkHtmlFile == null || !bookmarkHtmlFile.isFile() || !bookmarkHtmlFile.exists()) {
            return null;
        }
        String bk = bookmarkFileToString(bookmarkHtmlFile);
        if (StringUtil.isBlank(bk)) return null;

        // 去掉无用部分
        bk = removeUseless(bk);
        if (StringUtil.isBlank(bk)) return null;

        // folders
        List<Folder> folders = new ArrayList();
        while (bk.contains("<DT><H3")) {
            int idx1 = bk.indexOf("<DT><H3");
            int idx2 = bk.indexOf("</DL><p>");

            String dth3 = bk.substring(idx1, idx2 + 8);
            String h3 = dth3.substring(4, dth3.indexOf("</H3>") + 5);
            SingleLayerHtmlTag h3HtmlTag = HtmlUtil.parseSingleLayerHtmlTag(h3, "H3", true);
            String h3Text = h3HtmlTag.getText();
            bk = bk.replaceFirst("<DT>" + h3, "");

            String dlp = dth3.substring(dth3.indexOf("<DL><p>"));
            List<Page> pages = getPagesFromDlp(dlp);
            folders.add(new Folder(h3Text, pages));
            bk = bk.replaceFirst(dlp, "");
        }

        // pages
        List<Page> pages = getPagesFromDlp(bk);
        Bookmark bookmark = new Bookmark(pages, folders);
        return bookmark;
    }

    /**
     * 去掉收藏夹中的无用部分:
     * <!DOCTYPE NETSCAPE-Bookmark-file-1>
     * <META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=UTF-8">
     * <TITLE>Bookmarks</TITLE>
     * <H1>Bookmarks</H1>
     * <DL><p>
     * *****<DT><H3 ADD_DATE="1633522352" LAST_MODIFIED="1633596398" PERSONAL_TOOLBAR_FOLDER="true">Bookmarks bar</H3>
     * *****<DL><p>...
     *
     * @param bk
     * @return
     */
    private static String removeUseless(String bk) {
        if (StringUtil.isBlank(bk)) return bk;

        // 去掉前后无用部分
        bk = bk.replaceFirst("<DL><p>", "");
        int idx = bk.indexOf("<DL><p>");
        bk = bk.substring(idx + 7);

        // 去掉后面无用部分
        bk = StringUtil.replaceLast(bk, "</DL><p>", "");
        bk = StringUtil.replaceLast(bk, "</DL><p>", "");

        return bk;
    }

    /**
     * @param dlp: <DL><p>
     *             <DT><A HREF="https://github.com/" ADD_DATE="1633596375" ICON="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAACrElEQVQ4jW2SzWucVRTGf+fe9847SW2n+WioIdZkJkzGWLMsQvBjpRv1H1BcqSB166aUbgQXLkpEEGnF7ty5Edw0orULtS5DjNOZ5qvEKkMzEUuS6bz33tPFvCNj6LM653LO8/A85wpHUJmbW0QKbwMvAU8BCHpXkZshhK+2mmu3BudloC5UagsfI7wvIsOooqoKID2gqvuqfLFeX7kAdPsEBmZdea74beLcKxoj+R4iPf7BXozBZ9n1jdudN+BOZgEtV5/8pJAW3/JZ90ZU/UiF0yAnVbWpUVvAMLASo7+oUYuFQvrqiRFT2NttLctUtXouleIN62whZNm19dur7wLFiZmzpdbmahvQyWr15L2Dg312dg5n5s5+6lzhvPfZQ59lLyapce+IkSGNkSjaASzQaW2udvrh3Gs07ud2LUqmMVhrzLA4+55RNS+IqsYYO91u+AwIvVz+F3C/DkEffh5i3FdFwSwaEaYUBKT950Z9Ox+MgA4QaL+/22xuCWzl708bwGkv6mMj5XLxiPJRCJOTRYXx3pw6A9wRVRUjpZIZej5Xso+xkAB65lhp0YhM5H9k3ajqrxgD8MAm5sp0tVrLczhqwZ+ZfXbeJckSoGJEUH42MYQvUZXgw5Kq3nRu+I/KMwvLM9X5c/3tqXLtuUpt4WuXyC+CzANRo4audq/Yf9r3d0pjp0atTT7M/OGbxpg9VE5nofPNv+32HsDQ+MgTqXVXRSRV5dAmNo3eL2036tekf7JKbeEngbEY/QcKDzYba7/9Z2B6ulhJj2+LkQljLD5k1zfq8XVY8yY/WVivr7wcNf5oE/e9Mcmt0dnZE/398TR1COMi4n3wlzfqq6/BWheIdiCouLfb+u742KllVP/+q+l/gHYAONgdkdHRxIbgL202fr+aiwLwCG7VPT6fvRxuAAAAAElFTkSuQmCC">GitHub</A>
     *             <DT><A HREF="https://mail.yahoo.com/" ADD_DATE="1633596413" ICON="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAjklEQVQ4jWNgGPKAkYGBgSGB8fJJBob/ZiRqPbXgv645A8SAS/9JBQmMl/4zMDAwMMHMmxTw6MLXd/8uELL367t/FyYFPIKrY4S5ACZg6Md/IXmeDAO3EJMBusa5SU8Yzm/6CBdf8F+PEcMAdIMYGBgY0DUSZQAxYMF/PUYmwsrwg0FjAOMp0rWSo2dQAgCf02ZjpPA4zAAAAABJRU5ErkJggg==">Yahoo Mail</A>
     *             </DL><p>
     * @return
     */
    private static List<Page> getPagesFromDlp(String dlp) {
        if (StringUtil.isBlank(dlp)) return null;
        ArrayList pages = new ArrayList();

        while (dlp.contains("<DT><A")) {
            int idx1 = dlp.indexOf("<DT><A");
            int idx2 = dlp.indexOf("</A>");
            String dta = dlp.substring(idx1, idx2 + 4);
            String a = dlp.substring(idx1 + 4, idx2 + 4);
            SingleLayerHtmlTag htmlTag = HtmlUtil.parseSingleLayerHtmlTag(a, "A", true);
            pages.add(new Page(htmlTag.getText(), htmlTag.getAttribute("HREF")));
            dlp = dlp.replaceFirst(dta, "");
        }

        return pages;
    }

    /**
     * 将收藏夹解析成String
     */
    private static String bookmarkFileToString(File bookmarkHtmlFile) throws IOException {
        StringBuffer lines = new StringBuffer();
        FileReader fr = new FileReader(bookmarkHtmlFile);
        BufferedReader br = new BufferedReader(fr);

        while (true) {
            String line = br.readLine();
            if (line == null) break;
            lines.append(line);
        }
        if (br != null) br.close();
        if (fr != null) fr.close();
        return lines.toString();
    }
}

