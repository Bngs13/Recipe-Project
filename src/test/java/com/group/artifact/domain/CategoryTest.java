package com.group.artifact.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//20190103, Creating JUnit test
public class CategoryTest {

    Category category;

    @Before //20190103, this method is running before each test method is executed
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() throws Exception{
        Long id=4l;
        category.setId(id);
        assertEquals(id,category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipe() {
    }
}