package dio.projeto_padros_spring.service;

import dio.projeto_padros_spring.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Definição da interface ViaCepService. Esta interface usa o FeignClient para consumir a API do ViaCep.
// O nome do cliente é "viacep" e a URL base é "https://viacep.com.br/ws".
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

    // Mapeia uma requisição HTTP GET para a URL "/{cep}/json/", onde "{cep}" é um parâmetro de caminho.
    // Este método consulta o CEP (Código de Endereçamento Postal) fornecido e retorna um objeto Endereco.
    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
