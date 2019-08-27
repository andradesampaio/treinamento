package br.org.demotdd.service;


import br.org.demotdd.exceptions.LocationException;
import br.org.demotdd.exceptions.MovieNotStockException;
import br.org.demotdd.model.Movie;
import br.org.demotdd.model.Location;
import br.org.demotdd.model.User;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class LocationService {

    public Location rentMovie(User user, List<Movie> movies) throws LocationException, MovieNotStockException {


        if(user == null) {
            throw new LocationException("Usuario vazio");
        }

        if(movies == null || movies.isEmpty()) {
            throw new LocationException("Filme vazio");
        }

        for(Movie movie: movies) {
            if(movie.getStock() == 0) {
                throw new MovieNotStockException();
            }
        }

        Location location = new Location();
        location.setMovie(movies);
        location.setUser(user);
        location.setDateLocation(LocalDateTime.now());
        Double valorTotal = 0d;
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            Double valorFilme = movie.getPreciLocation();

            switch (i) {
                case 2: valorFilme = movie.getPreciLocation() * 0.75; break;
                case 3: valorFilme = movie.getPreciLocation() * 0.50; break;
                case 4: valorFilme = movie.getPreciLocation() * 0.25; break;
                case 5: valorFilme = 0.0;
            }
            valorTotal +=valorFilme;
        }
        location.setPrice(valorTotal);

        //Entrega no dia seguinte
        location.setDateReturn(LocalDateTime.now().plusDays(1));

        //Salvando a locacao...
        //TODO adicionar método para salvar

        return location;
    }


}