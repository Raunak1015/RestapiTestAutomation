package com.qa.test;



import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.parser.ParseException;

public class Guixml {

	@Test
	public void guiXMLResponse() throws ParseException, org.json.simple.parser.ParseException{
		Fetch_Bearer_Token token=new Fetch_Bearer_Token();


		// 1:-Send GET Request along with Bearer Token
		RestAssured.baseURI = "https://hclconnectordev.dev.verify.ibmcloudsecurity.com/appcatalog/v1.0/templates/3/guixml";
		RequestSpecification getRequest = RestAssured.given();
		getRequest.header("Authorization", "Bearer " + token.getToken()).header("Content-Type", "application/json");

		// 2:-Store GET response (JSON Response) in response type Object
		Response guixmlResponse = getRequest
				.get("https://hclconnectordev.dev.verify.ibmcloudsecurity.com/appcatalog/v1.0/templates/3/guixml");

		//3:-Print Response
		//guixmlResponse.prettyPrint();

		//3: Verify Status Code
		int statusCode=guixmlResponse.statusCode();
		System.out.println(statusCode);
		AssertJUnit.assertEquals(200, guixmlResponse.statusCode());
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

		try
		{

			DocumentBuilder builder=factory.newDocumentBuilder();
			//Document doc=builder.parse(guixmlResponse.getBody().asString());


			Document doc= DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(
					new InputSource(new StringReader(guixmlResponse.getBody().asString())));



			doc.getDocumentElement().normalize();
			//System.out.println("Hi......");
			//System.out.println(doc.getDocumentElement().getTagName());


			System.out.println("Root Elements:" +doc.getDocumentElement().getNodeName());
			//read array of <pageinfo> this array is called Nodelist
			NodeList PageTitle=doc.getElementsByTagName("PageTitle");
			for(int i=0;i<PageTitle.getLength();i++)
			{
				Node node=PageTitle.item(i);
				//System.out.println("Node Name:" +node.getNodeName() + "" +(i+1));
				if(node.getNodeType()==node.ELEMENT_NODE)
				{
					Element element=(Element)node;
					System.out.println("textLabel:" +element.getAttribute("textLabel"));

				}
			}

			NodeList value=doc.getElementsByTagName("HashItem");
			for(int i=0;i<value.getLength();i++)
			{
				Node node=value.item(i);
				//System.out.println("Node Name:" +node.getNodeName() + "" +(i+1));
				if(node.getNodeType()==node.ELEMENT_NODE)
				{
					Element element=(Element)node;
					if(element.getAttribute("value").equalsIgnoreCase("3"))
					{
						System.out.println("Value:" +element.getAttribute("value"));
					}

				}
			}
			NodeList name=doc.getElementsByTagName("HashItem");
			for(int i=0;i<name.getLength();i++)
			{
				Node node=name.item(i);
				//System.out.println("Node Name:" +node.getNodeName() + "" +(i+1));
				if(node.getNodeType()==node.ELEMENT_NODE)
				{
					Element element=(Element)node;
					if(element.getAttribute("value").equalsIgnoreCase("Salesforce"))
					{
						System.out.println("name:" +element.getAttribute("value"));
					}

				}
			}
			NodeList Description=doc.getElementsByTagName("Description");
			for(int i=0;i<Description.getLength();i++)
			{
				Node node=Description.item(i);
				//System.out.println("Node Name:" +node.getNodeName() + "" +(i+1));
				if(node.getNodeType()==node.ELEMENT_NODE)
				{
					Element element=(Element)node;
					if(element.getAttribute("textLabel").equalsIgnoreCase("Basic information about the application."))
					{
						System.out.println("text label in description: " +element.getAttribute("textLabel"));
						break;
					}

				}
			}
			NodeList PageLayout=doc.getElementsByTagName("PageLayout");
			for(int i=0;i<PageLayout.getLength();i++)
			{
				Node node=PageLayout.item(i);
				//System.out.println("Node Name:" +node.getNodeName() + "" +(i+1));
				if(node.getNodeType()==node.ELEMENT_NODE)
				{
					Element element=(Element)node;
					if(element.getAttribute("textLabel").equalsIgnoreCase("General"))
					{
						System.out.println("text label in PageLayout: " +element.getAttribute("textLabel"));
						break;
					}

				}
			}
			NodeList ComponentLabel=doc.getElementsByTagName("ComponentLabel");
			for(int i=0;i<ComponentLabel.getLength();i++)
			{
				Node node=ComponentLabel.item(i);
				//System.out.println("Node Name:" +node.getNodeName() + "" +(i+1));
				if(node.getNodeType()==node.ELEMENT_NODE)
				{
					Element element=(Element)node;
					if(element.getAttribute("textLabel").equalsIgnoreCase("Company name"))
					{
						System.out.println("text label in ComponentLabel: " +element.getAttribute("textLabel"));
						break;
					}

				}
			}
			NodeList Description2=doc.getElementsByTagName("Description");
			for(int i=0;i<Description2.getLength();i++)
			{
				Node node=Description2.item(i);
				//System.out.println("Node Name:" +node.getNodeName() + "" +(i+1));
				if(node.getNodeType()==node.ELEMENT_NODE)
				{
					Element element=(Element)node;
					if(element.getAttribute("textLabel").equalsIgnoreCase("Use the value of the domain name from the Salesforce 'My Domain' page. If your Salesforce domain name is 'myHostName.my.salesforce.com', use myHostName as the value for 'Host name'."))
					{
						System.out.println("text label in description: " +element.getAttribute("textLabel"));
						break;
					}

				}
				
			}
			NodeList Description3=doc.getElementsByTagName("Description");
			for(int i=0;i<Description3.getLength();i++)
			{
				Node node=Description3.item(i);
				//System.out.println("Node Name:" +node.getNodeName() + "" +(i+1));
				if(node.getNodeType()==node.ELEMENT_NODE)
				{
					Element element=(Element)node;
					if(element.getAttribute("textLabel").equalsIgnoreCase("Display the following links to the user"))
					{
						System.out.println("text label in description: " +element.getAttribute("textLabel"));
						break;
					}

				}

			}

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());

		}


	}

}



