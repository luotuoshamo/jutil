package com.wjh.bookmark;

import java.util.List;

public class Bookmark {
    private List<Page> pages;
    private List<Folder> folders;

    public Bookmark(List<Page> pages, List<Folder> folders) {
        this.pages = pages;
        this.folders = folders;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    @Override
    public String toString() {
        return "Bookmark{" +
                "pages=" + pages +
                ", folders=" + folders +
                '}';
    }
}
