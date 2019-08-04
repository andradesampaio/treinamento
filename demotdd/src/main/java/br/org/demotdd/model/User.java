package br.org.demotdd.model;


import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;

	@OneToMany
	Location location;

	public User(Long id, String nome){
		this.id = id;
		this.nome = nome;

	}
	

}