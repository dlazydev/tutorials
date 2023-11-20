package com.baeldung.xml.binary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XmlOptimizedPackagingTest {

    @Test
    public void marshalToXmlShouldConvertBinaryDataToXml() throws Exception {
        byte[] binaryData = "TestBinaryData".getBytes();
        XmlOptimizedPackaging xmlOptimizedPackaging = new XmlOptimizedPackaging(binaryData);
        String xmlContent = xmlOptimizedPackaging.marshalToXml();

        // Assert that the XML content contains the expected binary data
        assertTrue(xmlContent.contains("TestBinaryData"));
    }
}
