package cn.topicstudy.jutil.basic.map;

import cn.topicstudy.jutil.common.User;
import cn.topicstudy.jutil.common.enums.GenderEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapUtilTest {
    private Map<String, Object> str_obj_map = new HashMap();
    private User user = new User();
    private String queryStr = "k1=v1&k2=v2";

    @Before
    public void setUp() {
        str_obj_map.put("id", "1");
        str_obj_map.put("name", "juicy");
        str_obj_map.put("pwd", "111");
        str_obj_map.put("gender", GenderEnum.FEMALE);

        user.setId("2");
        user.setName("iuSong");
        user.setPwd("888");
        user.setGender(GenderEnum.FEMALE);
    }

    @Test
    public void reverseKV() {
        Map<Object, Object> m = new HashMap<>();
        m.put("name", "wjh");
        m.put("age", 10);
        Map<Object, Object> m2 = MapUtil.reverseKV(m);
        Assert.assertEquals(m2.get("wjh"), "name");
        Assert.assertEquals(m2.get(10), "age");
    }

    @Test
    public void mapToBean() throws Exception {
        User user = MapUtil.mapToBean(str_obj_map, User.class);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getName(), "juicy");
        Assert.assertEquals(user.getGender(), GenderEnum.FEMALE);
    }

    @Test
    public void beanToMap() throws Exception {
        Map<String, Object> map = MapUtil.beanToMap(user, User.class);
        Assert.assertNotNull(map);
        Assert.assertEquals(map.get("id"), "2");
        Assert.assertEquals(map.get("pwd"), "888");
        Assert.assertEquals(map.get("gender"), GenderEnum.FEMALE);
    }

    @Test
    public void queryStr2Map() {
        Map<String, String> map = MapUtil.queryStr2Map(queryStr);
        Assert.assertNotNull(map);
        Assert.assertEquals(map.get("k1"), "v1");
        Assert.assertEquals(map.get("k2"), "v2");
    }

    @Test
    public void map2QueryStr() {
        HashMap<String, String> map = new HashMap() {{
            put("k1", "v1");
            put("k2", "v2");
        }};
        String queryStr = MapUtil.map2QueryStr(map);
        Assert.assertEquals(queryStr, "k1=v1&k2=v2");
    }
}
