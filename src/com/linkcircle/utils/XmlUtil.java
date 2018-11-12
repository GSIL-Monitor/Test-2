package com.linkcircle.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import com.linkcircle.entity.XmlNumberEntity;

public class XmlUtil {
	/**
	 * @Title: getUrlandNumberList
	 * @Description: 号码解析客户使用1007测试时客户接口对接
	 * @return
	 * @return: List<XmlNumberEntity>
	 */
	public static List<XmlNumberEntity> getUrlandNumberList(String dataSource) {
		List<XmlNumberEntity> list = new ArrayList<XmlNumberEntity>();
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("/home/smp/vccid_default_number.xml"));
			Element root = doc.getRootElement();
			Element foo;
			XmlNumberEntity entity = null;
			for (Iterator<?> i = root.elementIterator("number"); i.hasNext();) {
				foo = (Element) i.next();
				entity = new XmlNumberEntity();
				entity.setVccid(foo.attribute("vccid").getData().toString());
				entity.setId(foo.attribute("id").getData().toString());
				entity.setNumbers(foo.getTextTrim());
				entity.setDataSource(dataSource);
				list.add(entity);
			}
			return list;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	/**
	 * @Title: deleteUrlandNumberById
	 * @Description: 删除客户侧url
	 * @param id
	 * @return
	 * @return: boolean
	 */
	public static boolean deleteUrlandNumberById(String id) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("/home/smp/vccid_default_number.xml"));
			Element root = doc.getRootElement();
			Element foo;
			for (Iterator<?> i = root.elementIterator("number"); i.hasNext();) {
				foo = (Element) i.next();
				if (id.equals(foo.attribute("id").getData().toString())) {
					foo.getParent().remove(foo);
					break;
				}
			}
			// 设置XML文档格式
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			// 设置XML编码方式,即是用指定的编码方式保存XML文档到字符串(String),这里也可以指定为GBK或是ISO8859-1
			outputFormat.setEncoding("UTF-8");
			outputFormat.setSuppressDeclaration(true); // 是否生产xml头
			outputFormat.setIndent(true); // 设置是否缩进
			outputFormat.setIndent("    "); // 以四个空格方式实现缩进
			outputFormat.setNewlines(true); // 设置是否换行
			XMLWriter output = new XMLWriter(new FileWriter(new File("/home/smp/vccid_default_number.xml")),
					outputFormat);
			output.write(doc);
			output.close();
			return true;
		} catch (Exception e) {
		}
		return false;
	}
	/**
	 * @Title: addUrlByNumber
	 * @Description: 添加号码解析客户侧url
	 * @param entity
	 * @return
	 * @return: boolean
	 */
	public static boolean addUrlByNumber(XmlNumberEntity entity) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("/home/smp/vccid_default_number.xml"));
			Element root = doc.getRootElement();
			Element element = root.addElement("number");
			element.addAttribute("id", entity.getId());
			element.addAttribute("vccid", entity.getVccid());
			element.setText(entity.getNumbers());
			// 设置XML文档格式
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			// 设置XML编码方式,即是用指定的编码方式保存XML文档到字符串(String),这里也可以指定为GBK或是ISO8859-1
			outputFormat.setEncoding("UTF-8");
			outputFormat.setSuppressDeclaration(true); // 是否生产xml头
			outputFormat.setIndent(true); // 设置是否缩进
			outputFormat.setIndent("    "); // 以四个空格方式实现缩进
			outputFormat.setNewlines(true); // 设置是否换行
			XMLWriter output = new XMLWriter(new FileWriter(new File("/home/smp/vccid_default_number.xml")),
					outputFormat);
			output.write(doc);
			output.close();
			return true;
		} catch (Exception e) {
		}
		return false;
	}
	/**
	 * @Title: updateUrlByNumber
	 * @Description: 更新对应节点的数据
	 * @param entity
	 * @return
	 * @return: boolean
	 */
	public static boolean updateUrlByNumberById(XmlNumberEntity entity) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(new File("/home/smp/vccid_default_number.xml"));
			Element root = doc.getRootElement();
			Element foo;
			for (Iterator<?> i = root.elementIterator("number"); i.hasNext();) {
				foo = (Element) i.next();
				if (entity.getId().equals(foo.attribute("id").getData().toString())) {
					foo.setAttributeValue("vccid", entity.getVccid());
					foo.setText(entity.getNumbers());
					break;
				}
			}
			// 设置XML文档格式
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			// 设置XML编码方式,即是用指定的编码方式保存XML文档到字符串(String),这里也可以指定为GBK或是ISO8859-1
			outputFormat.setEncoding("UTF-8");
			outputFormat.setSuppressDeclaration(true); // 是否生产xml头
			outputFormat.setIndent(true); // 设置是否缩进
			outputFormat.setIndent("    "); // 以四个空格方式实现缩进
			outputFormat.setNewlines(true); // 设置是否换行
			XMLWriter output = new XMLWriter(new FileWriter(new File("/home/smp/vccid_default_number.xml")),
					outputFormat);
			output.write(doc);
			output.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	   /**
     * JavaBean转换成xml 默认编码UTF-8
     * 
     * @param obj
     * @param writer
     * @return
     */
    public static String convertToXml(Object obj) {
        return convertToXml(obj, "UTF-8");
    }

    /**
     * JavaBean转换成xml
     * 
     * @param obj
     * @param encoding
     * @return
     */
    public static String convertToXml(Object obj, String encoding) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);

            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * xml转换成JavaBean
     * 
     * @param xml
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T converyToJavaBean(String xml, Class<T> c) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }
}
