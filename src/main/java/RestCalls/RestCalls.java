package RestCalls;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class RestCalls {


    public void getHttpClient() throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient();
        Request req = new Request.Builder()
                .url("https://gorest.co.in/public/v2/users")
                .get()
                .addHeader("cache-control","no-cache")
                .build();
        Response res = okHttpClient.newCall(req).execute();
        System.out.println(res);
        System.out.println(res.body().toString());


    }

    public void getRestTemplate() {
        return;
    }
}