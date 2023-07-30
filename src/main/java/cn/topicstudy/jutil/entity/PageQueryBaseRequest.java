package cn.topicstudy.jutil.entity;

import lombok.Data;

@Data
public class PageQueryBaseRequest extends BaseDTO {
    private boolean isPage = false;
    private int currentPage;
    private int pageSize;
}
