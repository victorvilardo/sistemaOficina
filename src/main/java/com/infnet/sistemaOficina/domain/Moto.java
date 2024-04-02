package com.infnet.sistemaOficina.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("MOTO")
public class Moto extends Veiculo {

    private int cilindradas;
    private boolean partidaEletrica;

}