package cn.topicstudy.bookmark;

@Deprecated
public class Page {
    private String name;
    private String href;

    public Page(String name, String href) {
        this.name = name;
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "Page{" +
                "name='" + name + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
