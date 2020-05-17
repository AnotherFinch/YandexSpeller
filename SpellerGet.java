import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class SpellerGet {
    static String sURL = "https://speller.yandex.net/services/spellservice";

    public static void main(String[] args) {
        CloseableHttpResponse rp1 = null;
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(sURL + "/checkText?text=что+сдесь+может+быть+не+так");
            rp1 = httpclient.execute(httpGet);
            System.out.println(EntityUtils.toString(rp1.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert rp1 != null;
                rp1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}