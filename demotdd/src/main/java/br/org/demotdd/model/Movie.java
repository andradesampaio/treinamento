package br.org.demotdd.model;

import lombok.*;

import javax.persistence.Entity;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Movie {

	private String name;
	private Integer stock;
	private Double preciLocation;

}