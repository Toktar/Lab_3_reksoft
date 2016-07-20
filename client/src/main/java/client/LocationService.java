package client;

import client.demo.Location;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 * Created by toktar on 20.07.2016.
 */

public class LocationService {
    public String locationToString(Location location) {
        StringBuffer out = new StringBuffer();
        out.append("\nid: " + location.getId());
        out.append("\ncity: " + location.getCity());
        out.append("\ncountry: " + location.getCountry() + "\n");
        return out.toString();
    }
}
