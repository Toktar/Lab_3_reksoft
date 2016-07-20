package client;

import client.demo.GetLocationRequest;
import client.demo.GetLocationResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class RunClient {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SoapClientConfig.class);

        LocationClient client = context.getBean(LocationClient.class);
        LocationService locationService = context.getBean(LocationService.class);

        GetLocationRequest request = new GetLocationRequest();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Please, input phone number");
            String phone = in.next();
            request.setPhone(phone);
            if(phone.equals("end")) return;
            GetLocationResponse resp = client.getLocation(request);
            String outMessage;
            if(resp.getLocation()==null) {
                outMessage = "Sorry, location for this number is not found.";
            } else {
                outMessage = locationService.locationToString(resp.getLocation());
            }
            System.out.println(outMessage);
        }
    }



}
