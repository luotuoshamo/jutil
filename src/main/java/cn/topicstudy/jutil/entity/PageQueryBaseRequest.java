package cn.topicstudy.jutil.entity;

import lombok.Data;

@Data
public class PageQueryBaseRequest extends BaseDTO {
    private boolean isPage;
    private int currentPage;
    private int pageSize;
}
