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
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
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
 * Usuario entity.
 *
 * @author Ivanilson Melo.
 * @author Pedro Paulo.
 * @author Luana Lima.
 * @author Vítor Souza.
 */
@Getter
@Setter
@EqualsAndHashCode(of = {"cpf", "nome"})
@ToString
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
@SequenceGenerator(sequenceName = "seq_usuario", name = "ID_SEQUENCE", allocationSize = 1)
public class Usuario implements Comparable<Usuario>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private long id;

	@NaturalId
	@Column(nullable = false, unique = true)
	private int cpf;

	@Column(nullable = false, unique = false)
	private String nome;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = true, unique = false)
	private String senha;

	@Column(nullable = false, unique = false)
	private String telefone;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataNascimento;

	@Singular
	@OneToMany(mappedBy = "usuario")
	private Set<Emprestimo> emprestimos;

	@Override
	public int compareTo(Usuario u) {
		int status = this.nome.compareTo(u.nome);

		if (status == 0) {
			status = this.cpf - u.cpf;
		}

		return status;
	}

}
