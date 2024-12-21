package cn.topicstudy.jutil.entity;

import lombok.Data;

@Data
public class PageQueryBaseRequest extends BaseDTO {
    private boolean isPage;
    private int currentPage;
    private int pageSize;

    public int getOffset() {
        return (currentPage - 1) * pageSize;
    }

    /**
     * 否则spring controller赋值时赋值不了
     */
    public boolean setIsPage() {
        return isPage;
    }

    public void getIsPage(boolean page) {
        isPage = page;
    }
}
