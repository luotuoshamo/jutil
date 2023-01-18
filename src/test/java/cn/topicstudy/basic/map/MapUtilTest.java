package cn.topicstudy.basic.map;

import cn.topicstudy.common.User;
import cn.topicstudy.common.enums.GenderEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapUtilTest {
    private Map<String, Object> str_obj_map = new HashMap();
    private User user = new User();

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
}
