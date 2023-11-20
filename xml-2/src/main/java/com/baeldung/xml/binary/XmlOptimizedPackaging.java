package com.baeldung.xml.binary;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;


public class XmlOptimizedPackaging {

    private byte[] binaryData;

    public XmlOptimizedPackaging(byte[] binaryData) {
        this.binaryData = binaryData;
    }

    public String marshalToXml() throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        // Root element
        Element rootElement = document.createElement("XmlOptimizedPackaging");
        document.appendChild(rootElement);

        // Binary data element
        Element binaryDataElement = document.createElement("BinaryData");
        binaryDataElement.setTextContent(new String(binaryData, "UTF-8"));
        rootElement.appendChild(binaryDataElement);

        // Convert the DOM document to a string
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(new DOMSource(document), result);

        return writer.toString();
    }
}
