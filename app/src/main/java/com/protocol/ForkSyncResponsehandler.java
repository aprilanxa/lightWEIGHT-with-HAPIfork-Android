package com.protocol;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


import android.os.Handler;

public class ForkSyncResponsehandler extends DefaultResponseHandler {

	protected Handler handler;
	protected boolean isError = false;
	String tempString;
	final String TAG_MESSAGE="message";
	final String TAG_ERRORCOUNT="error_count";
	Object response;
	String message;
	/*<api_response xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	 * <message>Successful</message>
	 * <error_count>0</error_count>
	 * </api_response>*/

	public ForkSyncResponsehandler(Handler handler){
		super(handler);
		this.handler = handler;

	}


	@Override
	public void startDocument() throws SAXException{
		super.startDocument();

	}


	@Override
	public void endDocument() throws SAXException{
		//
		response = message;

		super.endDocument();
	}


	@Override
	public void endElement(String uri, String localName,String elementName) throws SAXException{

		if (elementName.equals(TAG_MESSAGE)){
			if (tempString!=null && tempString.length()>0){
				//TODO:
				System.out.println("MESSAGE"+tempString);
				message = tempString;
				response = new String(message);
			}

		}
	}


	@Override
	public void startElement(String uri, String localName, String elementName, Attributes attrs) throws SAXException{


	}


	@Override
	public void characters(char ch[], int start, int length) {
		// get all text value inside the element tag
		tempString = new String(ch, start, length);
		tempString = tempString.trim(); // remove all white-space characters
	}


	@Override
	public Object getResponse() {
		// TODO Auto-generated method stub
		return response;
	}




}
