/*
 * Copyright 2016 Jovem Exemplar.
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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * @author Paulo Vitor Souza
 */

public class ExemplarTests {

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

    private Livro getTheAlchemistBookInstance() {
	Autor paulo = Autor.builder().nome(TA_AUTOR).build();
	Categoria adventure = Categoria.builder().nome(TA_CATEGORIA1).build();
	Categoria fantasy = Categoria.builder().nome(TA_CATEGORIA2).build();

	Set<Autor> autores = new HashSet<>();
	Set<Categoria> categorias = new HashSet<>();

	autores.add(paulo);
	categorias.add(adventure);
	categorias.add(fantasy);

	return Livro.builder()
		.titulo(TA_TITULO)
		.isbn(TA_ISBN)
		.autores(autores)
		.categorias(categorias)
		.paginas(TA_PAGINAS)
		.edicao(TA_EDICAO)
		.ano(TA_ANO)
		.localizacao(TA_LOCALIZACAO)
		.descricao(TA_DESCRICAO).build();
    }

    Livro l1 = getGoneGirlBookInstance();
    Livro l2 = getTheAlchemistBookInstance();

    @Test
    public void mesmoExemplarLivrosIguais() {

	Exemplar exemplar1 = Exemplar.builder()
		.livro(l1)
		.dataDeCompra(new Date())
		.emprestado(true).build();

	Exemplar exemplar2 = Exemplar.builder()
		.livro(l1)
		.dataDeCompra(new Date())
		.emprestado(true).build();

	assertThat(exemplar1).isEqualTo(exemplar2);
    }

    @Test
    public void exemplaresDiferentesLivrosDiferentes() {
	Exemplar exemplar1 = Exemplar.builder()
		.livro(l1)
		.dataDeCompra(new Date())
		.emprestado(true).build();

	Exemplar exemplar2 = Exemplar.builder()
		.livro(l2)
		.dataDeCompra(new Date())
		.emprestado(true).build();

	assertThat(exemplar1).isNotEqualTo(exemplar2);
    }

    @Test
    public void exemplaresDiferentesStatusDiferentes() {
	Exemplar exemplar1 = Exemplar.builder()
		.livro(l2)
		.dataDeCompra(new Date())
		.emprestado(true).build();

	Exemplar exemplar2 = Exemplar.builder()
		.livro(l2)
		.dataDeCompra(new Date())
		.emprestado(false).build();
    }

}
