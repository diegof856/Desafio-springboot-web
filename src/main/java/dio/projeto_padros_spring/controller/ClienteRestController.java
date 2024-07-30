package dio.projeto_padros_spring.controller; // Define o pacote onde o controlador ClienteRestController está localizado

import dio.projeto_padros_spring.model.Cliente; // Importa a classe Cliente do pacote model
import dio.projeto_padros_spring.service.ClienteService; // Importa a classe ClienteService do pacote service
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação Autowired do Spring
import org.springframework.http.ResponseEntity; // Importa a classe ResponseEntity do Spring para encapsular respostas HTTP
import org.springframework.web.bind.annotation.*; // Importa as anotações do Spring para mapear endpoints HTTP

@RestController // Anotação que define esta classe como um controlador REST, onde os métodos retornam objetos que serão automaticamente convertidos para JSON ou XML
@RequestMapping("clientes") // Define a URL base para todos os endpoints deste controlador
public class ClienteRestController {

    @Autowired // Injeção de dependência automática do clienteService
    private ClienteService clienteService; // Instância do serviço ClienteService que será utilizada para manipular dados de clientes

    @GetMapping // Mapeia requisições HTTP GET para o endpoint "/clientes"
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        // Chama o método buscarTodos do serviço para obter todos os clientes e retorna uma resposta HTTP 200 OK com a lista de clientes
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}") // Mapeia requisições HTTP GET para o endpoint "/clientes/{id}", onde {id} é um parâmetro de caminho
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        // Chama o método buscarPorId do serviço para obter um cliente específico pelo ID e retorna uma resposta HTTP 200 OK com o cliente
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping // Mapeia requisições HTTP POST para o endpoint "/clientes"
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        // Chama o método inserir do serviço para adicionar um novo cliente e retorna uma resposta HTTP 200 OK com o cliente adicionado
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}") // Mapeia requisições HTTP PUT para o endpoint "/clientes/{id}", onde {id} é um parâmetro de caminho
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        // Chama o método atualizar do serviço para atualizar um cliente existente pelo ID e retorna uma resposta HTTP 200 OK com o cliente atualizado
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}") // Mapeia requisições HTTP DELETE para o endpoint "/clientes/{id}", onde {id} é um parâmetro de caminho
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        // Chama o método deletar do serviço para remover um cliente pelo ID e retorna uma resposta HTTP 200 OK sem conteúdo
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
