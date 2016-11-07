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

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Teste da classe Usuario.
 *
 * @author Luana Carla.
 */
public class UsuarioTests {

	// Usuário 1
	public static final String U1_NOME = "Pedro Paulo";
	public static final String U1_EMAIL = "pedro@email.com";
	public static final int U1_CPF = 432412421;
	public static final String U1_SENHA = "SENHA123";
	public static final String U1_TELEFONE = "24152314";

	// Usuário 2
	public static final String U2_NOME = "Vitor";
	public static final String U2_EMAIL = "vitor@email.com";
	public static final int U2_CPF = 533434521;
	public static final String U2_SENHA = "123SENHA";
	public static final String U2_TELEFONE = "1342545133";

	@Test
	public void atributosIguais() {

		Usuario u1 = Usuario.builder()
				.nome(U1_NOME)
				.email(U1_EMAIL)
				.cpf(U1_CPF)
				.senha(U1_SENHA)
				.telefone(U1_TELEFONE).build();

		Usuario u2 = Usuario.builder()
				.nome(U1_NOME)
				.email(U1_EMAIL)
				.cpf(U1_CPF)
				.senha(U1_SENHA)
				.telefone(U1_TELEFONE).build();

		assertThat(u1).isEqualTo(u2);
	}

	@Test
	public void atributosIguaisCpfsDiferentes() {

		Usuario u1 = Usuario.builder()
				.nome(U1_NOME)
				.email(U1_EMAIL)
				.cpf(U1_CPF)
				.senha(U1_SENHA)
				.telefone(U1_TELEFONE).build();

		Usuario u2 = Usuario.builder()
				.nome(U1_NOME)
				.email(U1_EMAIL)
				.cpf(U2_CPF)
				.senha(U1_SENHA)
				.telefone(U1_TELEFONE).build();

		assertThat(u1).isNotEqualTo(u2);
	}

	@Test
	public void atributosIguaisNomesDiferentes() {

		Usuario u1 = Usuario.builder()
				.nome(U1_NOME)
				.email(U1_EMAIL)
				.cpf(U1_CPF)
				.senha(U1_SENHA)
				.telefone(U1_TELEFONE).build();

		Usuario u2 = Usuario.builder()
				.nome(U2_NOME)
				.email(U1_EMAIL)
				.cpf(U1_CPF)
				.senha(U1_SENHA)
				.telefone(U1_TELEFONE).build();

		assertThat(u1).isNotEqualTo(u2);
	}

	@Test
	public void nomeCpfIguaisAtributosDiferentes() {

		Usuario u1 = Usuario.builder()
				.nome(U1_NOME)
				.email(U1_EMAIL)
				.cpf(U1_CPF)
				.senha(U1_SENHA)
				.telefone(U1_TELEFONE).build();

		Usuario u2 = Usuario.builder()
				.nome(U1_NOME)
				.email(U2_EMAIL)
				.cpf(U1_CPF)
				.senha(U2_SENHA)
				.telefone(U2_TELEFONE).build();

		assertThat(u1).isEqualTo(u2);
	}

	@Test
	public void compareTo() {

		Set<Usuario> usuarios = new TreeSet<>();

		Usuario pedro = Usuario.builder()
				.nome(U1_NOME)
				.cpf(U1_CPF).build();

		Usuario vitor = Usuario.builder()
				.nome(U2_NOME)
				.cpf(U2_CPF).build();

		usuarios.add(vitor);
		usuarios.add(pedro);

		// It should order by name, followed by CPF.
		assertThat(usuarios.iterator().next()).isEqualTo(pedro);
	}

}
