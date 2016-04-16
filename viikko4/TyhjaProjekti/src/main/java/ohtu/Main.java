package ohtu;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "014168501";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2016.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);
        
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        int hourSum = 0;
        int tehavaSum = 0;
        System.out.println("opiskelijanumero " + studentNr);
        for (Submission submission : subs) {
            System.out.println("   " + submission);
            hourSum += submission.getHours();
            tehavaSum += submission.tehdytTehtavatSum();
        }
        System.out.println("yhteensä: " + tehavaSum + " tehtävää " + hourSum + " tuntia");

    }
}