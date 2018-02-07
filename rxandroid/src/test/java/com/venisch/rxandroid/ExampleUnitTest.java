package com.venisch.rxandroid;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

    }

    @Test
    public void testRxJava() {
        Flowable.just("Hello world").subscribe(System.out::println);

        Flowable.just("Hello rxJava!").subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });

        Flowable.range(1, 10).observeOn(Schedulers.computation()).map(integer -> integer * integer).blockingSubscribe(integer -> System.out.println(String.valueOf(integer)));

        Flowable.range(1, 10).observeOn(Schedulers.computation()).map(integer -> integer * integer).subscribe(integer -> System.out.println(String.valueOf(integer)));
    }

    @Test
    public void testTxJava2() {
        Flowable.range(1, 10)
                .flatMap(v ->
                        Flowable.just(v)
                                .subscribeOn(Schedulers.computation())
                                .map(w -> w * w)
                )
                .blockingSubscribe(System.out::println);
    }
}