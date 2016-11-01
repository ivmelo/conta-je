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
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Teste da classe Usuario.
 *
 * @author Luana Carla.
 */
public class UsuarioTests {

	// Autor 1 
	public static final String A1_NOME = "Pedro Paulo";
	public static final String A1_EMAIL = "pedro@email.com";
	public static final int A1_CPF = 432412421;
	public static final String A1_SENHA = "SENHA123";
	public static final String A1_TELEFONE = "24152314";
	

	// Autor 2
	public static final String A2_NOME = "Vitor";
	public static final String A2_EMAIL = "vitor@email.com";
	public static final int A2_CPF = 533434521;
	public static final String A2_SENHA = "123SENHA";
	public static final String A2_TELEFONE = "1342545133";

	@Test
	public void atributosIguais() {

		Usuario u1 = Usuario.builder()
				.nome(A1_NOME)
				.email(A1_EMAIL)
				.cpf(A1_CPF)
				.senha(A1_SENHA)
				.telefone(A1_TELEFONE).build();
				

		Usuario u2 = Usuario.builder()
				.nome(A1_NOME)
				.email(A1_EMAIL)
				.cpf(A1_CPF)
				.senha(A1_SENHA)
				.telefone(A1_TELEFONE).build();
		
		assertThat(u1).isEqualTo(u2);
	}

	@Test
	public void atributosIguaisCpfsDiferentes() {


		Usuario u1 = Usuario.builder()
				.nome(A1_NOME)
				.email(A1_EMAIL)
				.cpf(A1_CPF)
				.senha(A1_SENHA)
				.telefone(A1_TELEFONE).build();
				

		Usuario u2 = Usuario.builder()
				.nome(A1_NOME)
				.email(A1_EMAIL)
				.cpf(A2_CPF)
				.senha(A1_SENHA)
				.telefone(A1_TELEFONE).build();

		assertThat(u1).isNotEqualTo(u2);
	}

	@Test
	public void atributosIguaisSenhasDiferentes() {

		Usuario u1 = Usuario.builder()
				.nome(A1_NOME)
				.email(A1_EMAIL)
				.cpf(A1_CPF)
				.senha(A1_SENHA)
				.telefone(A1_TELEFONE).build();
				

		Usuario u2 = Usuario.builder()
				.nome(A1_NOME)
				.email(A1_EMAIL)
				.cpf(A1_CPF)
				.senha(A2_SENHA)
				.telefone(A1_TELEFONE).build();

		assertThat(u1).isNotEqualTo(u2);
	}

	@Test
	public void atributosIguaisEmailsDiferentes() {

		Usuario u1 = Usuario.builder()
				.nome(A1_NOME)
				.email(A1_EMAIL)
				.cpf(A1_CPF)
				.senha(A1_SENHA)
				.telefone(A1_TELEFONE).build();
				

		Usuario u2 = Usuario.builder()
				.nome(A1_NOME)
				.email(A2_EMAIL)
				.cpf(A1_CPF)
				.senha(A1_SENHA)
				.telefone(A1_TELEFONE).build();

		assertThat(u1).isNotEqualTo(u2);
	}


	@Test
	public void compareTo() {

		Set<Usuario> usuarios = new TreeSet<>();

		Usuario pedro1 = Usuario.builder()
				.nome(A1_NOME)
				.cpf(A1_CPF).build();

		Usuario pedro2 = Usuario.builder()
				.nome(A1_NOME)
				.cpf(A1_CPF).build();

		Usuario vitor = Usuario.builder()
				.nome(A2_NOME)
				.cpf(A2_CPF).build();

		usuarios.add(pedro2);
		usuarios.add(vitor);
		usuarios.add(pedro1);

		// It should order by Title, followed by ISBN.
		assertThat(usuarios.toArray()[0]).isEqualTo(pedro1);
		assertThat(usuarios.toArray()[1]).isEqualTo(pedro2);
		assertThat(usuarios.toArray()[2]).isEqualTo(vitor);
	}

	

}
