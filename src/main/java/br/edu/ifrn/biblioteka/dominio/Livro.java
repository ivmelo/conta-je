/*
 * Copyright 2016-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.edu.ifrn.biblioteka.dominio;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import org.hibernate.annotations.NaturalId;

/**
 * Livro entity.
 *
 * @author Ivanilson Melo.
 * @author Pedro Paulo.
 * @author Luana Lima.
 * @author Vítor Souza.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"isbn", "titulo"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(sequenceName = "seq_livro", name = "ID_SEQUENCE", allocationSize = 1)
public class Livro implements Comparable<Livro>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@NaturalId
	@Column(nullable = false, unique = true)
	private String isbn;

	@Column(nullable = false, unique = false)
	private String titulo;

	@Singular
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Autor> autores;

	@Singular
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Categoria> categorias;

	@Singular
	@OneToMany(mappedBy = "livro")
	private Set<Exemplar> exemplares;

	@Column(nullable = true, unique = false)
	private int paginas;

	@Column(nullable = true, unique = false)
	private int edicao;

	@Column(nullable = true, unique = false)
	private int ano;

	@Column(nullable = true, unique = false)
	private String localizacao;

	@Column(nullable = true, unique = false)
	private String descricao;

	@Override
	public int compareTo(Livro l) {
		int status;

		status = this.titulo.compareTo(l.titulo);

		if (status == 0) {
			status = this.isbn.compareTo(l.isbn);
		}

		return status;
	}

}
