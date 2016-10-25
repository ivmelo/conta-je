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

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author ivanilson
 */
@Entity
class Categoria {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
        
    // Trocar por anotação @Getter
    public Long getId() {
        return id;
    }
    
    // Trocar por anotação @Setter
    public void setId(Long id) {
        this.id = id;
    }
}
