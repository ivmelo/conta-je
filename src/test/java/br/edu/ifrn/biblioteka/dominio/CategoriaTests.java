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
 * Teste da classe Categoria.
 *
 * @author Pedro Paulo Figueiredo.
 */
public class CategoriaTests {
	private static final String CATEGORIA1 = "Suspense";
	private static final String CATEGORIA2 = "Romanse";
	private static final String CATEGORIA3 = "Aventura";

	private static final String ISBN1 = "9788439711111";
	private static final String ISBN2 = "9788439722222";
	private static final String ISBN3 = "9788439733333";

	@Test
	public void mesmoCategoriaNomesIguais() {
		assertThat(Categoria.builder().nome(CATEGORIA1).build())
				.isEqualTo(Categoria.builder().nome(CATEGORIA1).build());
	}

	@Test
	public void categoriaDiferenteNomesDiferentes() {
		assertThat(Categoria.builder().nome(CATEGORIA1).build())
				.isNotEqualTo(Categoria.builder().nome(CATEGORIA2).build());
	}

	@Test
	public void mesmoNomeLivrosIguais() {
		Set<Livro> livros1 = new HashSet<>();
		livros1.add(Livro.builder().isbn(ISBN1).build());
		livros1.add(Livro.builder().isbn(ISBN2).build());

		// Criar segundo set de livros.
		Set<Livro> livros2 = new HashSet<>();
		livros2.add(Livro.builder().isbn(ISBN1).build());
		livros2.add(Livro.builder().isbn(ISBN2).build());

		// Cria objetos com mesmo nome e mesmo set de livros.
		Categoria a1 = Categoria.builder().nome(CATEGORIA1).build();
		a1.setLivros(livros1);

		Categoria a2 = Categoria.builder().nome(CATEGORIA1).build();
		a2.setLivros(livros2);

		assertThat(a1).isEqualTo(a2);
	}

	@Test
	public void mesmoNomeLivrosDiferentes() {
		// Criar o primeiro set de livros.
		Set<Livro> livros1 = new HashSet<>();
		livros1.add(Livro.builder().isbn(ISBN1).build());
		livros1.add(Livro.builder().isbn(ISBN2).build());

		// Criar segundo set de livros.
		Set<Livro> livros2 = new HashSet<>();
		livros2.add(Livro.builder().isbn(ISBN3).build());

		// Cria objetos com mesmo nome, porém, com set de livros diferentes.
		Categoria a1 = Categoria.builder().nome(CATEGORIA1).build();
		a1.setLivros(livros1);

		Categoria a2 = Categoria.builder().nome(CATEGORIA1).build();
		a2.setLivros(livros2);

		assertThat(a1).isNotEqualTo(a2);
	}

	@Test
	public void compareTo() {
		Set<Categoria> categorias = new TreeSet<>();

		Categoria romanse = Categoria.builder().nome(CATEGORIA2).build();
		Categoria aventura = Categoria.builder().nome(CATEGORIA3).build();

		categorias.add(romanse);
		categorias.add(aventura);

		assertThat(categorias.iterator().next()).isEqualTo(aventura);
	}
}
