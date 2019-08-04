package br.org.demotdd.service;

import br.org.demotdd.model.Movie;
import br.org.demotdd.model.Location;
import br.org.demotdd.model.User;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;


public class LocationService {

    public Location rentMovie(User user, Movie movie) {

       if(movie.getStock() ==0 ){
           throw new RuntimeException("Movie have not stock");

       }

        Location location = new Location();
        location.setMovie(movie);
        location.setUser(user);
        location.setDateLocation(LocalDateTime.now());
        location.setPrice(movie.getPreciLocation());

        //Entrega no dia seguinte
        location.setDateReturn(LocalDateTime.now().plusDays(1));

        //Salvando a locacao...
        //TODO adicionar método para salvar

        return location;
    }


}