package com.rd.soapservice;

/**
 * Created at 15.03.2023
 *
 * @author Rıdvan DOĞAN
 */

import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class SOAPConnector extends WebServiceGatewaySupport {

    public Object callWebService(String url, Object request, WebServiceMessageCallback webServiceMessageCallback) {
        return getWebServiceTemplate().marshalSendAndReceive(url, request, webServiceMessageCallback);
    }
}
