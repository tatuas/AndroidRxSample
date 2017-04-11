package com.tatuas.android.retrofit2sample;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

import static org.junit.Assert.assertEquals;

public class MyObservableTest {

    @Test
    public void sampleObservable4() {
        final TestObserver<String> t4 = new TestObserver<>();
        final Observable<String> o4 = MyObservable.sampleObservable4();
        t4.assertNotSubscribed();
        o4.subscribe(t4);
        t4.assertNoErrors();
        t4.assertSubscribed();
        assertEquals(0, t4.errors().size());
        final List<String> values = new ArrayList<>();
        values.add("one");
        values.add("two");
        values.add("three");
        values.add("four");
        values.add("five");
        assertEquals(values, t4.values());
    }
}
