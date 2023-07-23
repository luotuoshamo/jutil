package cn.topicstudy.jutil.basic.map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class PropertiesUtilTest {
    private File propertiesFile;

    @Before
    public void setUp() throws Exception {
        propertiesFile = new File("./src/test/java/com/wjh/basic/map/test.properties");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void parseToMap() throws IOException {
        Map<String, String> map = PropertiesUtil.parseToMap(propertiesFile);
        Assert.assertEquals("root", map.get("db.user"));
        Assert.assertEquals("111", map.get("db.pwd"));
        Assert.assertEquals("jdbc:mysql://ip:3306/test_db", map.get("db.url"));
    }
}
