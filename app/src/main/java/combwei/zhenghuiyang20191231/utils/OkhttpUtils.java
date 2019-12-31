package combwei.zhenghuiyang20191231.utils;

import android.os.Handler;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkhttpUtils {
    private OkHttpClient okHttpClient;
    private static OkhttpUtils okhttpUtils;
    private Handler handler=new Handler();

    private OkhttpUtils(){
        okHttpClient=new OkHttpClient.Builder()
                //拦截器
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    public static OkhttpUtils getInstance() {
        if (okhttpUtils==null){
            synchronized (OkhttpUtils.class){
                if (okhttpUtils==null){
                    okhttpUtils=new OkhttpUtils();
                }
            }
        }
        return okhttpUtils;
    }


    public void doGet(String url,OkhttpUtilCallback okhttpUtilCallback){
        Request request=new Request.Builder()
                .url(url)
                .get()
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //忘记写什么
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        okhttpUtilCallback.fialure(e);
                    }
                });
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {


            }
        });


    }




    //回调接口

    public interface OkhttpUtilCallback{
        void success(String result);
        void fialure(Throwable throwable);
    }


}
