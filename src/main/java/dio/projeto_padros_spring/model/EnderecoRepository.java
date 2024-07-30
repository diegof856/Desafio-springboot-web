package dio.projeto_padros_spring.model; // Define o pacote onde a interface EnderecoRepository está localizada

import org.springframework.data.repository.CrudRepository; // Importa a interface CrudRepository do Spring Data
import org.springframework.stereotype.Repository; // Importa a anotação Repository do Spring

@Repository // Anotação que indica que esta interface é um repositório, permitindo que o Spring a gerencie como um componente de persistência
public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
    // A interface EnderecoRepository estende CrudRepository, que fornece métodos CRUD (Create, Read, Update, Delete) padrão para a entidade Endereco
    // O primeiro parâmetro, Endereco, é a entidade que será gerenciada pelo repositório
    // O segundo parâmetro, Long, é o tipo do identificador da entidade (chave primária)
}
