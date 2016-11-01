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

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Teste da classe Autor.
 *
 * @author Ivanilson Melo.
 */
public class AutorTests {
	private static final String AUTOR1 = "Paulo Coelho";
	private static final String AUTOR2 = "J.K. Rowling";
	private static final String AUTOR3 = "Gillian Flynn";

	private static final String ISBN1 = "9788439711111";
	private static final String ISBN2 = "9788439722222";
	private static final String ISBN3 = "9788439733333";


	@Test
	public void mesmoAutorNomesIguais() {
		assertThat(Autor.builder().nome(AUTOR1).build())
				.isEqualTo(Autor.builder().nome(AUTOR1).build());
	}

	@Test
	public void autorDiferenteNomesDiferentes() {
		assertThat(Autor.builder().nome(AUTOR1).build())
				.isNotEqualTo(Autor.builder().nome(AUTOR2).build());
	}

	@Test
	public void mesmoNomeLivrosIguais() {
		// Criar primeiro set de livros.
		Livro l1 = Livro.builder().isbn(ISBN1).build();
		Livro l2 = Livro.builder().isbn(ISBN2).build();

		Set<Livro> livros1 = new HashSet<>();
		livros1.add(l1);
		livros1.add(l2);

		// Criar segundo set de livros.
		Set<Livro> livros2 = new HashSet<>();
		livros2.add(l1);
		livros2.add(l2);

		// Cria objetos com mesmo nome e mesmo set de livros.
		Autor a1 = Autor.builder().nome(AUTOR1).build();
		a1.setLivros(livros1);

		Autor a2 = Autor.builder().nome(AUTOR1).build();
		a2.setLivros(livros2);

		assertThat(a1).isEqualTo(a2);
	}

	@Test
	public void mesmoNomeLivrosDiferentes() {
		// Criar primeiro set de livros.
		Livro l1 = Livro.builder().isbn(ISBN1).build();
		Livro l2 = Livro.builder().isbn(ISBN2).build();

		Set<Livro> livros1 = new HashSet<>();
		livros1.add(l1);
		livros1.add(l2);

		// Criar segundo set de livros.
		Livro l3 = Livro.builder().isbn(ISBN3).build();
		Set<Livro> livros2 = new HashSet<>();
		livros2.add(l3);

		// Cria objetos com mesmo nome, porém, com set de livros diferentes.
		Autor a1 = Autor.builder().nome(AUTOR1).build();
		a1.setLivros(livros1);

		Autor a2 = Autor.builder().nome(AUTOR1).build();
		a2.setLivros(livros2);

		assertThat(a1).isNotEqualTo(a2);
	}

	@Test
	public void compareTo() {
		Set<Autor> autores = new TreeSet<>();

		Autor jkrowling = Autor.builder().nome(AUTOR2).build();
		Autor gillianflynn = Autor.builder().nome(AUTOR3).build();

		autores.add(jkrowling);
		autores.add(gillianflynn);

		assertThat(autores.iterator().next()).isEqualTo(gillianflynn);
	}
}
