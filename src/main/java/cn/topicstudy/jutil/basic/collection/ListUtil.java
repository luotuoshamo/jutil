package cn.topicstudy.jutil.basic.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListUtil {
    /**
     * 打乱list中元素的顺序
     * 不改变原list
     */
    public static List shuffle(List list) {
        if (list == null) return null;
        int size = list.size();
        if (size == 1 || size == 0) return list;

        List resList = new ArrayList(list);
        Random random = new Random();
        for (int i = 0; i < size * 3; i++) {// 打乱次数=list长度*10次
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);
            if (index1 == index2) continue;
            Collections.swap(resList, index1, index2);
        }
        return resList;
    }
}
