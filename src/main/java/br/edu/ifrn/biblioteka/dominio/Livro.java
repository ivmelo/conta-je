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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
@EqualsAndHashCode(exclude = {"id", "descricao"})
@SequenceGenerator(sequenceName = "seq_livro", name = "ID_SEQUENCE", allocationSize = 1)
@Builder
@Entity
public class Livro implements Comparable<Livro> {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_SEQUENCE")
    private long id;
    
    @Column(nullable = false, unique = true)
    private String titulo;
    
    @Column(nullable = false, unique = true)
    private String isbn;
    
//    @Singular
//    @ManyToMany(mappedBy = "livro")
//    private Set<Autor> autores;
    
//    @Singular
//    @ManyToMany(mappedBy = "livros")
//    private Set<Categoria> categorias;
    
    @Column(nullable = false, unique = false)
    private int paginas;
    
    @Column(nullable = false, unique = false)
    private int edicao;
    
    @Column(nullable = false, unique = false)
    private int ano;
    
    @Column(nullable = false, unique = false)
    private String localizacao;
    
    @Column(nullable = true, unique = false)
    private int descricao;
    
    @Override
    public int compareTo(Livro l) {
        return this.isbn.compareTo(l.isbn);
    }
    
}
