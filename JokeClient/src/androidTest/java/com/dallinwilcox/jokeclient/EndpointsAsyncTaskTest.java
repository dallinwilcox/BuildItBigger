package com.dallinwilcox.jokeclient;

import android.content.Context;
import android.os.AsyncTask;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;


import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by dcwilcox on 4/19/2016.
 * referenced
 *  - http://developer.android.com/training/testing/unit-testing/instrumented-unit-tests.html
 *  - http://stackoverflow.com/a/5722193/2169923
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class EndpointsAsyncTaskTest extends InstrumentationTestCase{


    public void testSomeAsyncTask () throws Throwable {
        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);
        final  EndpointsAsyncTask TestEndpointsAsyncTask = new EndpointsAsyncTask() {

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

            /* This is the key, normally you would use some type of listener
             * to notify your activity that the async call was finished.
             *
             * In your test method you would subscribe to that and signal
             * from there instead.
             */
                signal.countDown();
            }
        };
        // Execute the async task on the UI thread! THIS IS KEY!
        runTestOnUiThread(new Runnable() {

            @Override
            public void run() {
                new EndpointsAsyncTask().execute(getInstrumentation().getContext());
            }
        });

    /* The testing thread will wait here until the UI thread releases it
     * above with the countDown() or 30 seconds passes and it times out.
     */
        signal.await(30, TimeUnit.SECONDS);

        // The task is done, and now you can assert some things!
        assertNotNull(result, true);
    }
}
