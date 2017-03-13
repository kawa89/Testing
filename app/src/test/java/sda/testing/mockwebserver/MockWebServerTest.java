package sda.testing.mockwebserver;

import com.google.mockwebserver.MockResponse;
import com.google.mockwebserver.MockWebServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.assertThat;

/**
 * Created by kawa on 13.03.2017.
 */

public class MockWebServerTest {

    private MockWebServer mServer;

    @Before
    public void setUp() throws Exception {
        mServer = new MockWebServer();
        mServer.play();
        mServer.enqueue(new MockResponse().setBody("myString"));
    }

    @Test
    public void test1() throws Exception {
        String response = getResponse(new URL("http://www.android.com/"));
        assertThat(response, startsWith("<HTML>"));
    }

    @Test
    public void test2() throws Exception {
        String response = getResponse(mServer.getUrl("/"));
        assertThat(response, equalTo("myString"));
    }

    private String getResponse(URL url) {
        try {
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                InputStream it = new BufferedInputStream(urlConnection.getInputStream());
                InputStreamReader read = new InputStreamReader(it);
                BufferedReader buff = new BufferedReader(read);
                final StringBuilder dta = new StringBuilder();
                String chunks;
                while ((chunks = buff.readLine()) != null) {
                    dta.append(chunks);
                }
                return dta.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @After
    public void tearDown() throws Exception {
        mServer.shutdown();
    }
}
