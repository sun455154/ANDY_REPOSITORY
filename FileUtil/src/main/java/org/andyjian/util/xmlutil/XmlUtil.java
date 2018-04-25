package org.andyjian.util.xmlutil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

/**
 * The Class XmlUtil.
 */
public class XmlUtil {

	/**
	 * 建立doc物件.
	 *
	 * @param file the file
	 * @return the document
	 */
	public static Document createDocument(File file) {
		Document xmldoc = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			xmldoc = db.parse(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmldoc;
	}
	
	/**
	 * 取得該xml某個同標籤的所有屬性.
	 *
	 * @param doc物件
	 * @param 標籤名
	 * @return the node attr
	 */
	public static List<NamedNodeMap> getNodeAttr(Document xmldoc, String tagName) {
		List<NamedNodeMap> mapList = new ArrayList<>();
		Element root = xmldoc.getDocumentElement();
		NodeList list = root.getElementsByTagName(tagName);
		for (int i = 0; i < list.getLength(); i++) {
			mapList.add(list.item(i).getAttributes());
		}
		return mapList;
	}

	/**
	 * Select nodes.
	 *
	 * @param express the express
	 * @param source the source
	 * @return the node list
	 */
	public static NodeList selectNodes(String express, Object source) {
		NodeList result = null;
		XPathFactory xPathFactory = XPathFactory.newInstance();
		XPath xpath = xPathFactory.newXPath();
		try {
			result = (NodeList) xpath.evaluate(express, source, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return result;
	}
}
