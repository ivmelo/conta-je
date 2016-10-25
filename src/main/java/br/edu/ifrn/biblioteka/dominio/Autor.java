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

package br.edu.ifrn.biblioteka;

import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

/**
 * Autor entity.
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Autor implements Comparable<Autor> {

	private String nome;

	@Override
	public int compareTo(Categoria o) {
		int result = 0;
		if (this.nome != null && o.nome != null) {
			result = this.nome.compareTo(o.nome);
		}
		else if (this.nome == null && o.nome == null) {
			result = 0;
		}
		else if (this.nome == null) {
			result = -1;
		}
		else {
			result = +1;
		}
		return result;
	}

}
