package one.digitalinnovation.personapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity//define ser entidade
@Data//aplica conceitos de lombok (get e set automatico)
@Builder//inicia
@AllArgsConstructor
@NoArgsConstructor
public class Belongings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//gera id auto incrementavel
    private Long id;

    //@Enumerated(EnumType.STRING)
    @Column(nullable = false)//indica ser campo obrigatorio no banco de dados
    private String type;

    @Column(nullable = false, unique = true)
    private String number;
}
