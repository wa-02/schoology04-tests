package org.example.core;

import org.junit.Assert;
import org.junit.Test;

public class JsonHelperTest {

    @Test
    public void getJsonObject() {
        Assert.assertEquals("value",
                JsonHelper.getJsonObject("src/test/resources/unittest/MyJson.json").read("key"));
    }

    @Test
    public void getJsonObjectNestedValues() {
        Assert.assertEquals("nestedValue",
                JsonHelper.getJsonObject("src/test/resources/unittest/MyJson.json").read("nested.key"));
    }

    @Test
    public void getJsonObjectNotExistFile() {
        RuntimeException runtimeException = Assert.assertThrows(RuntimeException.class,
                () -> JsonHelper.getJsonObject("NotExistFile.json"));
        Assert.assertEquals(JsonHelper.MSG_NOT_POSSIBLE_TO_READ_JSON, runtimeException.getMessage());
    }
}
