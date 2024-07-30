package dio.projeto_padros_spring.service;

import dio.projeto_padros_spring.model.Cliente;
import org.springframework.stereotype.Service;

// Definição da interface ClienteService. Esta interface será usada para definir os métodos
// que serão implementados pela classe de serviço que gerencia clientes.
public interface ClienteService {

    // Método para buscar todos os clientes. Retorna um Iterable de objetos Cliente.
    Iterable<Cliente> buscarTodos();

    // Método para buscar um cliente específico pelo seu ID. Retorna um objeto Cliente.
    Cliente buscarPorId(Long id);

    // Método para inserir um novo cliente. Recebe um objeto Cliente como parâmetro.
    void inserir(Cliente cliente);

    // Método para atualizar as informações de um cliente existente. Recebe o ID do cliente
    // a ser atualizado e um objeto Cliente com as novas informações.
    void atualizar(Long id, Cliente cliente);

    // Método para deletar um cliente pelo seu ID.
    void deletar(Long id);
}
