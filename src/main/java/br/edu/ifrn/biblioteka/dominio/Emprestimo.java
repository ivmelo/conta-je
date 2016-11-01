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

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@EqualsAndHashCode
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Emprestimo implements Comparable<Emprestimo> {

	private Exemplar exemplar;
	private Usuario usuario;
	private Date dataRetirada;
	private Date dataEntrega;
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
