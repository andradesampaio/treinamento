package br.org.demotdd.service;

import br.org.demotdd.exceptions.LocationException;
import br.org.demotdd.exceptions.MovieNotStockException;
import br.org.demotdd.model.Location;
import br.org.demotdd.model.Movie;
import br.org.demotdd.model.User;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LocationServiceTests {

    @Test
    public void contextLoads() throws MovieNotStockException, LocationException {
        LocationService service = new LocationService();
        User user = new User(1L, "Usuario 1");
        List<Movie> movies = Arrays.asList(
                new  Movie("Filme 1", 1, 5.0)
        );

        //acao
        Location location = service.rentMovie(user, movies);

        LocalDateTime now = LocalDateTime.now();

        Boolean equals = Objects.equals(location.getDateReturn(), now.minusDays(1).getDayOfMonth());

        //verificacao
        //Assert.assertTrue(location.getPrice() == 5.0);
        Assert.assertThat(location.getMovie().get(0).getPreciLocation(), CoreMatchers.is(5.0));

        Assert.assertTrue(Objects.equals(location.getDateLocation().getDayOfMonth(), now.getDayOfMonth()));
        Assert.assertTrue(Objects.equals(location.getDateReturn().getDayOfMonth(), now.plusDays(1).getDayOfMonth()));
    }

    @Test(expected = MovieNotStockException.class)
    public void testLocation_movieNotStock() throws MovieNotStockException, LocationException {

        LocationService service = new LocationService();
        User user = new User(1L, "Usuario 1");
        List<Movie> movies = Arrays.asList(
                new  Movie("Filme 1", 0, 4.0)
        );

        //verificacao
        service.rentMovie(user, movies);

    }

    @Test
    public void testLocation_movieNotStock_2() {

        LocationService service = new LocationService();
        User user = new User(1L, "Usuario 1");
        List<Movie> movies = Arrays.asList(
                new  Movie("Filme 1", 1, 4.0)
        );


        try {
         //verificacao
            service.rentMovie(user, movies);
        } catch (RuntimeException | LocationException | MovieNotStockException e) {
            Assert.assertThat(e.getMessage(), CoreMatchers.is("Movie have not stock"));
        }

    }

    @Test
    public void devePagar75PctNo3Filme() throws MovieNotStockException, LocationException {
        LocationService service = new LocationService();
        User user = new User(1L, "Usuario 1");
        List<Movie> movies = Arrays.asList(
               new  Movie("Filme 1", 1, 2.0),
               new  Movie("Filme 2", 1, 3.0),
               new  Movie("Filme 3", 1, 1.0)
          );

       Location result = service.rentMovie(user, movies);

       Assert.assertThat(result.getPrice(), CoreMatchers.is(5.75));


    }

    @Test
    public void devePagar50PctNo4Filme() throws MovieNotStockException, LocationException {
        LocationService service = new LocationService();
        User user = new User(1L, "Usuario 1");
        List<Movie> movies = Arrays.asList(
                new  Movie("Filme 1", 1, 2.0),
                new  Movie("Filme 2", 1, 3.0),
                new  Movie("Filme 3", 1, 1.0),
                new  Movie("Filme 4", 1, 1.0)
        );

        Location result = service.rentMovie(user, movies);

        Assert.assertThat(result.getPrice(), CoreMatchers.is(6.25));


    }
    @Test
    public void devePagar75PctNo5Filme() throws MovieNotStockException, LocationException {
        LocationService service = new LocationService();
        User user = new User(1L, "Usuario 1");
        List<Movie> movies = Arrays.asList(
                new  Movie("Filme 1", 1, 2.0),
                new  Movie("Filme 2", 1, 3.0),
                new  Movie("Filme 3", 1, 1.0),
                new  Movie("Filme 4", 1, 1.0),
                new  Movie("Filme 5", 1, 1.0)
        );

        Location result = service.rentMovie(user, movies);

        Assert.assertThat(result.getPrice(), CoreMatchers.is(6.50));


    }

    @Test
    public void devePagar100PctNo6Filme() throws MovieNotStockException, LocationException {
        LocationService service = new LocationService();
        User user = new User(1L, "Usuario 1");
        List<Movie> movies = Arrays.asList(
                new  Movie("Filme 1", 1, 2.0),
                new  Movie("Filme 2", 1, 3.0),
                new  Movie("Filme 3", 1, 1.0),
                new  Movie("Filme 4", 1, 1.0),
                new  Movie("Filme 5", 1, 1.0),
                new  Movie("Filme 6", 1, 1.0)
        );
        Location result = service.rentMovie(user, movies);
        Assert.assertThat(result.getPrice(), CoreMatchers.is(6.50));
    }
}
