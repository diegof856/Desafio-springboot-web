package dio.projeto_padros_spring.service.impl;

import dio.projeto_padros_spring.model.Cliente;
import dio.projeto_padros_spring.model.ClienteRepository;
import dio.projeto_padros_spring.model.Endereco;
import dio.projeto_padros_spring.model.EnderecoRepository;
import dio.projeto_padros_spring.service.ClienteService;
import dio.projeto_padros_spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepo;
    @Autowired
    private EnderecoRepository enderecoRepo;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepo.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
   salvarCliente(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepo.findById(id);
        if(clienteBd.isPresent()){
            salvarCliente(clienteBd.get());
        }
    }
    private void salvarCliente(Cliente cliente){
        Long id = cliente.getEndereco().getId_endereco();
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepo.findById(id).orElseGet(()->{
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepo.save(novoEndereco);

            return novoEndereco;
        });
    }

    @Override
    public void deletar(Long id) {
    clienteRepo.deleteById(id);
    }
}
