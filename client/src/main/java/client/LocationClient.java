package client;

import client.demo.GetLocationRequest;
import client.demo.GetLocationResponse;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class LocationClient extends WebServiceGatewaySupport {

    public GetLocationResponse getLocation(GetLocationRequest request){
        try {
            WebServiceTemplate temp = getWebServiceTemplate();
            GetLocationResponse resp = (GetLocationResponse) temp.marshalSendAndReceive(request);
            return resp;
        } catch (NullPointerException e) {
            return null;
        }

    }


}
