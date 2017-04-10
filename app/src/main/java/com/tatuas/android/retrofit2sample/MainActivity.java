package com.tatuas.android.retrofit2sample;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.squareup.moshi.Moshi;
import com.tatuas.android.retrofit2sample.structure.Repo;

import org.json.JSONObject;

import java.util.List;
import java.util.concurrent.Callable;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv1)
    TextView tv1;

    @BindView(R.id.tv2)
    TextView tv2;

    @BindView(R.id.tv3)
    TextView tv3;

    @BindView(R.id.tv4)
    TextView tv4;

    @BindView(R.id.tv5)
    TextView tv5;

    @BindView(R.id.tv6)
    TextView tv6;

    @BindView(R.id.tv7)
    TextView tv7;

    @BindView(R.id.tv8)
    TextView tv8;

    @BindView(R.id.tv9)
    TextView tv9;

    @BindView(R.id.tv10)
    TextView tv10;

    @BindView(R.id.tv11)
    TextView tv11;

    @BindView(R.id.tv12)
    TextView tv12;

    private CompositeDisposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        disposable = new CompositeDisposable();

        final GitHubService gitHub = new Retrofit.Builder()
                .baseUrl("http://api.github.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(new Moshi.Builder().build()))
                .build()
                .create(GitHubService.class);

        final Observable<String> sampleObservable = Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                final JSONObject json = new JSONObject("{hello:\"bye\"}");
                return json.getString("sss0");
            }
        });

        disposable.add(sampleObservable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onNext(String value) {
                        Log.d("sdf", "ss" + value);
                        Log.d("sdf", "ssonNext");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d("sdf", "ssonError");
                        Log.d("sdf", "ssbecause:" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("sdf", "ssonComplete");
                    }
                }));

        disposable.add(gitHub.listRepos2("tatuas")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Repo>>() {
                    @Override
                    public void onNext(List<Repo> value) {
                        tv1.setText(String.valueOf(value.get(0).isPrivate));
                        tv2.setText(String.valueOf(value.get(0).archiveUrl));
                        tv3.setText(String.valueOf(value.get(0).cloneUrl));
                        Log.d("sdf", "next");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("sdf", "because:" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("sdf", "complete");
                    }
                }));

        disposable.add(gitHub.listRepos("tatuas")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<Response<List<Repo>>>() {
                    @Override
                    public void onSuccess(Response<List<Repo>> value) {
                        if (value.isSuccessful()) {
                            tv1.setText(String.valueOf(value.body().get(0).isPrivate));
                            tv2.setText(String.valueOf(value.body().get(0).archiveUrl));
                            tv3.setText(String.valueOf(value.body().get(0).cloneUrl));
                        } else {
                            try {
                                new AlertDialog.Builder(MainActivity.this).setMessage(value.errorBody().string()).show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("sdf", "because:" + e.toString());
                    }
                }));
    }

    @Override
    public void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
