package com.wjh.basic.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CollectionUtilTest {
    private List<String> stringList = new ArrayList<>();
    private List<String> emptyStringList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        stringList.add("Tom");
        stringList.add("Jerry");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(CollectionUtil.isEmpty(emptyStringList));
    }

    @Test
    public void isNotEmpty() {
        Assert.assertTrue(CollectionUtil.isNotEmpty(stringList));
    }
}