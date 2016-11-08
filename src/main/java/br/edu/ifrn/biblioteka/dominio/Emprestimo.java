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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * Emprestimo entity.
 *
 * @author Ivanilson Melo.
 * @author Pedro Paulo.
 * @author Luana Lima.
 * @author Vítor Souza.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"exemplar", "usuario", "dataRetirada"})
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
@SequenceGenerator(sequenceName = "seq_lancamento", name = "ID_SEQUENCE", allocationSize = 1)
public class Emprestimo implements Comparable<Emprestimo>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
	private Long id;

	@ManyToOne
	@NonNull
	@JoinColumn(name = "id", foreignKey = @ForeignKey(name = "EMPRESTIMO_ID_FK"))
	private Exemplar exemplar;

	@ManyToOne
	@NonNull
	@JoinColumn(name = "id", foreignKey = @ForeignKey(name = "EMPRESTIMO_ID_FK"))
	private Usuario usuario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, unique = false)
	private Date dataRetirada;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, unique = false)
	private Date dataEntrega;

	@Column(nullable = false, unique = false)
	private boolean entregue;

	@Override
	public int compareTo(Emprestimo e) {
		int result = this.exemplar.compareTo(e.exemplar);

		if (result == 0) {
			this.dataRetirada.compareTo(e.dataRetirada);
		}

		if (result == 0) {
			result = this.dataEntrega.compareTo(e.dataEntrega);
		}

		if (result == 0) {
			result = this.usuario.compareTo(e.usuario);
		}

		if (result == 0 && this.entregue != e.entregue) {
			result = -1;
		}

		return result;
	}

}
