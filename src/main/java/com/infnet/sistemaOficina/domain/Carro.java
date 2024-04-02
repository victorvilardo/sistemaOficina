package com.infnet.sistemaOficina.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("CARRO")
public class Carro extends Veiculo {

    private int quantidadePortas;
    private boolean arCondicionado;

}