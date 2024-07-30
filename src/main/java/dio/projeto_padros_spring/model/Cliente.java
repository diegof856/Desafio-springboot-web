package dio.projeto_padros_spring.model;

import jakarta.persistence.*;

// Anotação @Entity indica que esta classe é uma entidade JPA que será mapeada para uma tabela no banco de dados
@Entity
public class Cliente {

    // Anotação @Id indica que este campo é a chave primária da entidade
    // Anotação @GeneratedValue configura a estratégia de geração automática do valor da chave primária
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cliente;

    // Campo nome do cliente
    private String nome;

    // Anotação @ManyToOne indica um relacionamento muitos-para-um com a entidade Endereco
    @ManyToOne
    private Endereco endereco;

    // Getter para o campo id_cliente
    public Long getId_cliente() {
        return id_cliente;
    }

    // Setter para o campo id_cliente
    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    // Getter para o campo nome
    public String getNome() {
        return nome;
    }

    // Setter para o campo nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para o campo endereco
    public Endereco getEndereco() {
        return endereco;
    }

    // Setter para o campo endereco
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
