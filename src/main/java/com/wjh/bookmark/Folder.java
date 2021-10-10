package com.wjh.bookmark;

import java.util.ArrayList;
import java.util.List;

@Deprecated
public class Folder {
    private String name;// 即dlp的text
    private List<Page> pages = new ArrayList<>();

    public Folder(String name, List<Page> pages) {
        this.name = name;
        this.pages = pages;
    }

    public Folder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }


    @Override
    public String toString() {
        return "Folder{" +
                ", name='" + name + '\'' +
                ", pages=" + pages +
                '}';
    }
}
