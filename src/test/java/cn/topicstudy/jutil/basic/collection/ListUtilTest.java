package cn.topicstudy.jutil.basic.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListUtilTest {
    private List<String> list = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        list.add("Tom");
        list.add("Jerry");
        list.add("IuSong");
        list.add("Loi");
        list.add("KouilRoy");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shuffle() {
        List shuffledList = ListUtil.shuffle(list,3);

        // shuffledList和list不完全一样就通过
        boolean success = false;
        for (int i = 0; i < shuffledList.size(); i++) {
            if (!shuffledList.get(i).equals(list.get(i))) success = true;
        }
        Assert.assertTrue(success);
    }
}
