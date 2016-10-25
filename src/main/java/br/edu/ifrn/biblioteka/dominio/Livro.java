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

import java.util.Set;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

/**
 *
 * @author ivanilson
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"descricao"})
@Builder
public class Livro implements Comparable<Livro> {
        
    private String titulo;
    
    private String isbn;
    
    @Singular
    private Set<Autor> autores;
    
    @Singular
    private Set<Categoria> categorias;
    
    private int paginas;
    
    private int edicao;
    
    private int ano;
    
    private String localizacao;
    
    private int descricao;
    
    @Override
    public int compareTo(Livro l) {
        return this.isbn.compareTo(l.isbn);
    }
    
}
