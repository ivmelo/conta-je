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
 * Teste da classe Livro.
 *
 * @author Ivanilson Melo.
 */
public class LivroTests {

	// Gone Girl by Gillian Flynn.
	public static final String GG_TITULO = "Gone Girl";
	public static final String GG_ISBN = "9780307588364";
	public static final String GG_ISBN2 = "9788439726821";
	public static final int GG_PAGINAS = 432;
	public static final int GG_EDICAO = 1;
	public static final int GG_ANO = 2012;
	public static final String GG_LOCALIZACAO = "BA123XFDK13-1";
	public static final String GG_DESCRICAO = "Gone Girl is a thriller novel by the writer Gillian Flynn. It was published by Crown Publishing Group in June 2012. The novel soon made the New York Times Best Seller list. The novel's suspense comes from the main character, Nick Dunne, and whether he is involved in the disappearance of his wife.";
	public static final String GG_AUTOR = "Gillian Flynn";
	public static final String GG_CATEGORIA = "Thriller";

	// The Alchemist by Paulo Coelho.
	public static final String TA_TITULO = "The Alchemist";
	public static final String TA_ISBN = "0062502174";
	public static final int TA_PAGINAS = 163;
	public static final int TA_EDICAO = 1;
	public static final int TA_ANO = 1993;
	public static final String TA_LOCALIZACAO = "BA123XZFX13-1";
	public static final String TA_DESCRICAO = "The Alchemist (Portuguese: O Alquimista) is a novel by Brazilian author Paulo Coelho which was first published in 1988. Originally written in Portuguese, it has been translated into at least 67 languages as of October 2009.[1] An allegorical novel, The Alchemist follows a young Andalusian shepherd in his journey to Egypt, after having a recurring dream of finding treasure there.";
	public static final String TA_AUTOR = "Paulo Coelho";
	public static final String TA_CATEGORIA1 = "Adventure";
	public static final String TA_CATEGORIA2 = "Fantasy";

	@Test
	public void atributosIguais() {

		Livro l1 = getGoneGirlBookInstance();

		Livro l2 = Livro.builder()
				.titulo(GG_TITULO)
				.isbn(GG_ISBN)
				.autores(l1.getAutores())
				.categorias(l1.getCategorias())
				.paginas(GG_PAGINAS)
				.edicao(GG_EDICAO)
				.ano(GG_ANO)
				.localizacao(GG_LOCALIZACAO)
				.descricao(GG_DESCRICAO).build();

		assertThat(l1).isEqualTo(l2);
	}

	@Test
	public void atributosIguaisDescricoesDiferentes() {


		Livro l1 = getGoneGirlBookInstance();

		Livro l2 = Livro.builder()
				.titulo(GG_TITULO)
				.isbn(GG_ISBN)
				.autores(l1.getAutores())
				.categorias(l1.getCategorias())
				.paginas(GG_PAGINAS)
				.edicao(GG_EDICAO)
				.ano(GG_ANO)
				.localizacao(GG_LOCALIZACAO)
				.descricao(TA_DESCRICAO).build();

		assertThat(l1).isEqualTo(l2);
	}

	@Test
	public void atributosIguaisLocalizacoesDiferentes() {

		Livro l1 = getGoneGirlBookInstance();

		Livro l2 = Livro.builder()
				.titulo(GG_TITULO)
				.isbn(GG_ISBN)
				.autores(l1.getAutores())
				.categorias(l1.getCategorias())
				.paginas(GG_PAGINAS)
				.edicao(GG_EDICAO)
				.ano(GG_ANO)
				.localizacao(TA_LOCALIZACAO)
				.descricao(GG_DESCRICAO).build();

		assertThat(l1).isEqualTo(l2);
	}

	@Test
	public void atributosIguaisIsbnsDiferentes() {

		Livro l1 = getGoneGirlBookInstance();

		Livro l2 = Livro.builder()
				.titulo(GG_TITULO)
				.isbn(TA_ISBN)
				.autores(l1.getAutores())
				.categorias(l1.getCategorias())
				.paginas(GG_PAGINAS)
				.edicao(GG_EDICAO)
				.ano(GG_ANO)
				.localizacao(GG_LOCALIZACAO)
				.descricao(GG_DESCRICAO).build();

		assertThat(l1).isNotEqualTo(l2);
	}

	@Test
	public void atributosIguaisAutoresDiferentes() {

		Livro l1 = getGoneGirlBookInstance();

		Livro l2 = Livro.builder()
				.titulo(GG_TITULO)
				.isbn(TA_ISBN)
				.categorias(l1.getCategorias())
				.paginas(GG_PAGINAS)
				.edicao(GG_EDICAO)
				.ano(GG_ANO)
				.localizacao(GG_LOCALIZACAO)
				.descricao(GG_DESCRICAO).build();

		assertThat(l1).isNotEqualTo(l2);
	}

	@Test
	public void compareTo() {

		Set<Livro> livros = new TreeSet<>();

		Livro gonegirl = Livro.builder()
				.titulo(GG_TITULO)
				.isbn(GG_ISBN).build();

		Livro gonegirl2 = Livro.builder()
				.titulo(GG_TITULO)
				.isbn(GG_ISBN2).build();

		Livro thealchemist = Livro.builder()
				.titulo(TA_TITULO)
				.isbn(TA_ISBN).build();

		livros.add(gonegirl2);
		livros.add(thealchemist);
		livros.add(gonegirl);

		// It should order by Title, followed by ISBN.
		assertThat(livros.toArray()[0]).isEqualTo(gonegirl);
		assertThat(livros.toArray()[1]).isEqualTo(gonegirl2);
		assertThat(livros.toArray()[2]).isEqualTo(thealchemist);
	}

	private Livro getGoneGirlBookInstance() {
		Autor gillian = Autor.builder().nome(GG_AUTOR).build();
		Categoria thriller = Categoria.builder().nome(GG_CATEGORIA).build();

		Set<Autor> autores = new HashSet<>();
		Set<Categoria> categorias = new HashSet<>();

		autores.add(gillian);
		categorias.add(thriller);

		return Livro.builder()
				.titulo(GG_TITULO)
				.isbn(GG_ISBN)
				.autores(autores)
				.categorias(categorias)
				.paginas(GG_PAGINAS)
				.edicao(GG_EDICAO)
				.ano(GG_ANO)
				.localizacao(GG_LOCALIZACAO)
				.descricao(GG_DESCRICAO).build();
	}

}
