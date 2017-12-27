import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static spark.Spark.*;
import static spark.Spark.get;

import spark.Request;
import spark.Response;
import spark.Route;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Main {
    public static void main(String[] args) {
        // get("/hello", (req, res) -> "Hello World");


        get("/numSeatsAvailable/", new Route() {
            @Override
            public Object handle(Request request, Response response) {
                return  "Number of Seats: 297";
            }
        })


    }
    private static final String ACCEPT = "application/json";
    @Test
    public void aptTesting() throws Exception {
        try {
            URL url = new URL(“http://localhost:/numSeatsAvailable");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(“GET”);
            conn.setRequestProperty(“Accept”, ACCEPT);

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException(”HTTP error code : ”+ conn.getResponseCode());
            }

            conn.disconnect();
            }

     catch (MalformedURLException e) {
        e.printStackTrace();

    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
