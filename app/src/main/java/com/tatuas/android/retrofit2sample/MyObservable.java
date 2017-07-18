package com.tatuas.android.retrofit2sample;

import android.os.SystemClock;
import android.support.annotation.NonNull;

import org.json.JSONObject;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyObservable {

    // https://github.com/ReactiveX/RxJava/issues/4863
    // errorHandler を setup すれば問題ない
    @NonNull
    public static Observable<String> sampleObservable1() {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                final OkHttpClient client = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url("https://httpbin.org/delay/5")
                        .build();
                final Response response = client.newCall(request).execute();
                return response.body().string();
            }
        });
    }

    // Errorが発生してもしなくても8秒遅れて値を返却する
    // http://blog.danlew.net/2015/07/23/deferring-observable-code-until-subscription-in-rxjava/
    @NonNull
    public static Observable<String> sampleObservable2() {
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                SystemClock.sleep(8000);
                return Observable.just("one", "two", "three", "four", "five");
            }
        });
    }

    // Errorが発生した場合はdelayしないが、成功した場合には5秒delayする
    @NonNull
    public static Observable<String> sampleObservable3() {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                final JSONObject json = new JSONObject("{hello:\"bye\"}");
                return json.getString("sss0");
            }
        }).flatMap(new Function<String, ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> apply(String s) throws Exception {
                return Observable.just(s).delay(5, TimeUnit.SECONDS);
            }
        });
    }

    // Observableのテスト用
    @NonNull
    public static Observable<String> sampleObservable4() {
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                Thread.sleep(8000);
                return Observable.just("one", "two", "three", "four", "five");
            }
        });
    }
}
