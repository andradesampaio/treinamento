package br.org.demotdd.model;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Location {

    private User user;
    private List<Movie> movie;
    private LocalDateTime dateLocation;
    private LocalDateTime dateReturn;
    private Double price;


}