/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.dallinwilcox.jokeserver;

import com.dallinwilcox.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "jokeserver.dallinwilcox.com",
    ownerName = "jokeserver.dallinwilcox.com",
    packagePath=""
  )
)
public class MyEndpoint {

    private JokeProvider jokeProvider = new JokeProvider();
    /** A simple endpoint method that returns a random joke */
    @ApiMethod(name="getRandomJoke")
    public MyBean getRandomJoke( ) {
        MyBean response = new MyBean();
        response.setData(jokeProvider.getRandomJoke());
        return response;
    }

}
