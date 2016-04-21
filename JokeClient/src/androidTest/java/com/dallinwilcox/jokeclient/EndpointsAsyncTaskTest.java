package com.dallinwilcox.jokeclient;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.InstrumentationTestCase;
import android.util.Log;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by dcwilcox on 4/19/2016.
 * referenced
 *  - http://developer.android.com/training/testing/unit-testing/instrumented-unit-tests.html
 *  - http://stackoverflow.com/a/5722193/2169923
 *  - http://stackoverflow.com/questions/3678959
 *  answered
 *  - http://stackoverflow.com/a/36758968/2169923
 */
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest extends InstrumentationTestCase{
    private Instrumentation instrumentation;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
   }

    @Test
    public void exerciseEndpointsAsyncTask () throws Throwable {
        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);
        final  EndpointsAsyncTask testEndpointsAsyncTask = new EndpointsAsyncTask() {

            @Override
            protected void onPostExecute(String joke) {
                //overriding result since we want to validate result instead of launching an activity
                assertNotNull(joke);
                signal.countDown();
            }
        };
        // Execute the async task on the UI thread! THIS IS KEY!
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                testEndpointsAsyncTask.execute(InstrumentationRegistry.getInstrumentation().getTargetContext());
            }
        });

    /* The testing thread will wait here until the UI thread releases it
     * above with the countDown() or 30 seconds passes and it times out.
     */
        signal.await(30, TimeUnit.SECONDS);
    }
}
