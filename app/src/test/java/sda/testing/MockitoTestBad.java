package sda.testing;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by kawa on 13.03.2017.
 */
// don't write classes and tests like this!
public class MockitoTestBad {

    @Test
    public void content_withCache_notForced() throws Exception {
        //when
        BadRepository sut = new BadRepository();

        //given
        sut.getContent(false);
        String content = sut.getContent(false);

        //then
        assertThat(content, equalTo("fresh_content"));
    }

    @Test
    public void content_withCache_forced() throws Exception {
        //when
        BadRepository sut = new BadRepository();

        //given
        sut.getContent(false);
        String content = sut.getContent(true);

        //then
        // we don't check if the cache was updated!! bad test practise!
        assertThat(content, equalTo("fresh_content"));
    }

    //bad test practise!
    @Test
    public void content_withCache_forced_reflection() throws Exception {
        //when
        BadRepository sut = new BadRepository();

        Class<?> clazz = sut.getClass();
        Field field = clazz.getDeclaredField("cache");
        field.setAccessible(true);
        field.set(sut, "reflection_content");

        //given
        String content = sut.getContent(false);

        //then
        assertThat(content, equalTo("reflection_content"));

        //given
        content = sut.getContent(true);

        //then
        // we don't check if the cache was updated!! bad test practise!
        assertThat(content, equalTo("fresh_content"));
    }

    private class BadRepository {
        Service service;
        String cache;

        BadRepository() {
            this.service = new Service();
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