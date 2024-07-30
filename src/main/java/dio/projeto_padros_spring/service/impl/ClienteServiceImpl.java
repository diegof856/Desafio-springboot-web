package dio.projeto_padros_spring.service.impl;

import dio.projeto_padros_spring.model.Cliente;
import dio.projeto_padros_spring.model.ClienteRepository;
import dio.projeto_padros_spring.model.Endereco;
import dio.projeto_padros_spring.model.EnderecoRepository;
import dio.projeto_padros_spring.service.ClienteService;
import dio.projeto_padros_spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Anotação @Service indica que esta classe é um serviço do Spring
@Service
public class ClienteServiceImpl implements ClienteService {

    // Injeção de dependência dos repositórios e do serviço ViaCepService
    @Autowired
    private ClienteRepository clienteRepo;
    @Autowired
    private EnderecoRepository enderecoRepo;
    @Autowired
    private ViaCepService viaCepService;

    // Método para buscar todos os clientes
    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepo.findAll();
    }

    // Método para buscar um cliente pelo ID
    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepo.findById(id);
        return cliente.get(); // Retorna o cliente se encontrado
    }

    // Método para inserir um novo cliente
    @Override
    public void inserir(Cliente cliente) {
        salvarCliente(cliente); // Chama o método privado salvarCliente para salvar o cliente
    }

    // Método para atualizar um cliente existente
    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepo.findById(id);
        if(clienteBd.isPresent()){
            salvarCliente(clienteBd.get()); // Chama o método privado salvarCliente se o cliente existir no banco de dados
        }
    }

    // Método privado para salvar um cliente, verificando e salvando o endereço
    private void salvarCliente(Cliente cliente){
        Long id = cliente.getEndereco().getId_endereco();
        String cep = cliente.getEndereco().getCep();

        // Busca o endereço pelo ID, se não encontrado, consulta na API do ViaCep e salva o novo endereço
        Endereco endereco = enderecoRepo.findById(id).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepo.save(novoEndereco);
            return novoEndereco;
        });

        // Associa o endereço ao cliente e salva o cliente
        cliente.setEndereco(endereco);
        clienteRepo.save(cliente);
    }

    // Método para deletar um cliente pelo ID
    @Override
    public void deletar(Long id) {
        clienteRepo.deleteById(id);
    }
}
