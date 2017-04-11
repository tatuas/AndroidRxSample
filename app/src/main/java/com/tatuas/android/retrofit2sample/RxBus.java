package com.tatuas.android.retrofit2sample;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

public final class RxBus {

    private static volatile RxBus instance;

    @NonNull
    private final PublishSubject<Object> bus = PublishSubject.create();

    @NonNull
    public static RxBus getInstance() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }

    public void send(final Object event) {
        bus.onNext(event);
    }

    @NonNull
    public <T> Observable<T> toObservable(Class<T> aClass) {
        return bus.ofType(aClass);
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }
}
