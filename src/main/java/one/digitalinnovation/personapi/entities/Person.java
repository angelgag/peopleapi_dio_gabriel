package one.digitalinnovation.personapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    //unique indica que cpf tem que ser unico
    //(não pode ter mais de uma pessoa com o mesmo cpf)
    @Column(nullable = false, unique = true)
    private String cpf;

    private LocalDate birthDate;

    //Lazy faz juncao de dados ou colocando os dados em uma transacao
    //ou colocando na tela e fazendo um tal de joinFetch.
    // Em resumo, torna a comunicacao entre as tabelas mais performatica
    //cascade faz com que não seja obrigatorio cadastrar
    //um phone para cadastrar uma pessoa
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private  List<Belongings> belongs = new ArrayList<>();
}
