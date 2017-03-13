package sda.testing;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kawa on 13.03.2017.
 */

public class MockitoTestGood {

    @Test
    public void content_withCache_notForced_mock() throws Exception {
        // when
        Service service = mock(Service.class);
        when(service.getContent()).thenReturn("some_value");
        GoodRepository sut = new GoodRepository(service);

        // given
        sut.getContent(false);
        String content = sut.getContent(false);

        // then
        assertThat(content, equalTo("some_value"));
        verify(service, times(1)).getContent();
    }

    @Test
    public void content_withCache_notForced_spy() throws Exception {
        // when
        Service service = spy(new Service());
        GoodRepository sut = new GoodRepository(service);

        // given
        sut.getContent(false);
        String content = sut.getContent(false);

        // then
        assertThat(content, equalTo("fresh_content"));
        verify(service, times(1)).getContent();
    }

    @Test
    public void content_withCache_forced() throws Exception {
        // when
        Service service = mock(Service.class);
        GoodRepository sut = new GoodRepository(service);

        // given
        sut.getContent(false);
        sut.getContent(true);

        // then
        verify(service, times(2)).getContent();
    }

    private class GoodRepository {
        Service service;
        String cache;

        GoodRepository(Service service) {
            this.service = service;
        }

        String getContent(Boolean force) {
            if (force || cache == null) {
                cache = service.getContent();
            }
            return cache;
        }
    }

    private class Service {
        String getContent() {
            return "fresh_content";
        }
    }
}
