package simCrawler.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class SimResponse {
    public static final List<URI> ALLURL = new ArrayList<>();
    public static final String SIMURL = "http://sim.whu.edu.cn";
    public static final String SIMLABURL = "http://simlab.whu.edu.cn";
    public static final String SIMYJSURL = "http://simyjs.whu.edu.cn";
    public static final String OURSIMURL = "http://oursim.whu.edu.cn";

    static {
        ALLURL.add(URI.create(SIMURL));
        ALLURL.add(URI.create(SIMLABURL));
        ALLURL.add(URI.create(SIMYJSURL));
        ALLURL.add(URI.create(OURSIMURL));
    }

    public static int getOneUrlResponse(URI url) {
        int responseCode = 0;
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpget = new HttpGet(url);
            CloseableHttpResponse response = httpclient.execute(httpget);
            responseCode = response.getStatusLine().getStatusCode();
//            if (responseCode == 200) {
//                System.out.println("--------------------------------");
//                HttpEntity resEntity = response.getEntity();
//                String message = EntityUtils.toString(resEntity, "utf-8");
//                System.out.println(message);
//            } else {
//                System.out.println("请求失败");
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(responseCode);
        return responseCode;
    }

    public static String getAllUrlResponse() {
        StringBuffer sb = new StringBuffer();
        for (URI uri : ALLURL) {
            int s = getOneUrlResponse(uri);
            if (s == 200) {
                sb.append(uri.toString() + " :运行状态良好<br/>");
            } else {
                sb.append(uri.toString() + " :宕机了<br/>");
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
//        new SimResponse().getOneUrlResponse(URI.create(SIMURL));
//        System.out.println(new SimResponse().getAllUrlResponse());;
    }

}
