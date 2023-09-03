package cn.topicstudy.jutil.validation;

import cn.topicstudy.jutil.validation.constraint.Length;
import cn.topicstudy.jutil.validation.constraint.NotBlank;
import cn.topicstudy.jutil.validation.constraint.Range;
import lombok.Data;

@Data
public class CreateUserParam {
    @NotBlank
    @Length(max = 3, min = 2, message = "用户名必须是2-3个字符")
    private String name;

    @Range(min = 0, max = 300)
    private int length;
}
