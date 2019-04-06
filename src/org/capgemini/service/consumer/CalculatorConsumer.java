package org.capgemini.service.consumer;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.capgemini.calcy.service.Calculator;

public class CalculatorConsumer {

	public static void main(String[] args) {
		try {
			String wsdl = "http://localhost:5051/calcy?wsdl";
			URL url = new URL(wsdl);
			String namespace = "http://service.calcy.capgemini.org/";
			String serviceName = "CalculatorImplService";
			QName qname = new QName(namespace,serviceName);
			Service service = Service.create(url ,qname);
			Calculator endPoint = service.getPort(Calculator.class);
			int result = endPoint.add(450, 450);
			long mul = endPoint.multi(4, 5);
			System.out.println("Addition Result: "+result);
			System.out.println("Multiply Result: "+mul);
			
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL");
			e.printStackTrace();

		}
	}

}
