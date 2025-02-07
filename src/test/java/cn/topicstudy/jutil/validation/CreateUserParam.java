package cn.topicstudy.jutil.validation;

import cn.topicstudy.jutil.validation.constraint.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CreateUserParam {
    @NotNull
    private Object objectForTestNull;

    @NotBlank
    private String stringForTestBlank;

    @NotEmpty
    private List listForTestEmpty;

    @Length(max = 3, min = 2, message = "the length of name must between 2 to 3")
    private String stringForTestLength;

    @Range(min = "100", max = "300", numberType = Integer.class)
    private int intForTestRange;

    @DateFormat(format = "yyyy-MM-dd HH:mm")
    private String dateForTestDateFormat;

}
