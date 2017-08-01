package name.kangjun.xjc.httpUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import name.kangjun.xjc.interfaces.HttpService;
import name.kangjun.xjc.xjcApplication;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * Created by Kangjun on 2017/7/13.
 */

public class RetrofitAPIManager {
    private static final String SERVER_URL = RetrofitClient.BASEURL + RetrofitClient.DACU_APP;

    public static HttpService provideClientApi() {
        Gson gson = new GsonBuilder().setLenient().serializeNulls().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(genericClient())
                .build();
        return retrofit.create(HttpService.class);
    }


    private static OkHttpClient genericClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("Content-Type", "application/json; charset=UTF-8")
                                .addHeader("Connection", "keep-alive")
                                .addHeader("Accept", "*/*")
                                .addHeader("User-Agent", xjcApplication.strUserAgent)
                                .build();
                        return chain.proceed(request);
                    }
                })
                .build();
    }
}
