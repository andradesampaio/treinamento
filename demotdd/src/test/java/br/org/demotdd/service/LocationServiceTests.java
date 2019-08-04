package br.org.demotdd.service;

import br.org.demotdd.model.Location;
import br.org.demotdd.model.Movie;
import br.org.demotdd.model.User;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceTests {

    @Test
    public void contextLoads() {
        LocationService service = new LocationService();
        User user = new User(1L, "Usuario 1");
        Movie movie = new Movie("Filme 1", 2, 5.0);

        //acao
        Location location = service.rentMovie(user, movie);

        LocalDateTime now = LocalDateTime.now();

        Boolean equals = Objects.equals(location.getDateReturn(), now.minusDays(1).getDayOfMonth());

        //verificacao
        //Assert.assertTrue(location.getPrice() == 5.0);
        Assert.assertThat(location.getPrice(), CoreMatchers.is(5.0));

        Assert.assertTrue(Objects.equals(location.getDateLocation().getDayOfMonth(), now.getDayOfMonth()));
        Assert.assertTrue(Objects.equals(location.getDateReturn().getDayOfMonth(), now.plusDays(1).getDayOfMonth()));
    }

    @Test(expected = RuntimeException.class)
    public void testLocation_movieNotStock() {

        LocationService service = new LocationService();
        User user = new User(1L, "Usuario 1");
        Movie movie = new Movie("Filme 1", 0, 5.0);

        //verificacao
        service.rentMovie(user, movie);

    }

    @Test
    public void testLocation_movieNotStock_2() {

        LocationService service = new LocationService();
        User user = new User(1L, "Usuario 1");
        Movie movie = new Movie("Filme 1", 1, 5.0);


        try {
         //verificacao
            service.rentMovie(user, movie);
        } catch (RuntimeException e) {
            Assert.assertThat(e.getMessage(), CoreMatchers.is("Movie have not stock"));
        }

    }

}
