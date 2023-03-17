package cn.topicstudy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class BaseDTO implements Serializable {
    // 防止序列化问题
    private static final long serialVersionUID = 0L;

    Map<String, String> extMap = new HashMap<>();
}
