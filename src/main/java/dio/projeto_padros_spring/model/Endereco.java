package dio.projeto_padros_spring.model; // Define o pacote onde a classe Endereco está localizada

import jakarta.persistence.Entity; // Importa a anotação Entity do Jakarta Persistence
import jakarta.persistence.GeneratedValue; // Importa a anotação GeneratedValue do Jakarta Persistence
import jakarta.persistence.GenerationType; // Importa a enumeração GenerationType do Jakarta Persistence
import jakarta.persistence.Id; // Importa a anotação Id do Jakarta Persistence

@Entity // Anotação que indica que esta classe é uma entidade JPA, mapeada para uma tabela no banco de dados
public class Endereco {
    @Id // Anotação que define o campo id_endereco como a chave primária da entidade
    @GeneratedValue(strategy = GenerationType.AUTO) // Define que o valor da chave primária será gerado automaticamente pelo provedor de persistência
    private Long id_endereco; // Campo para armazenar o identificador único da entidade Endereco

    private String cep; // Campo para armazenar o CEP (Código de Endereçamento Postal)
    private String logradouro; // Campo para armazenar o nome do logradouro (rua, avenida, etc.)
    private String complemento; // Campo para armazenar informações adicionais do endereço (ex: apartamento, bloco)
    private String bairro; // Campo para armazenar o bairro
    private String localidade; // Campo para armazenar a localidade (cidade ou município)
    private String uf; // Campo para armazenar a Unidade Federativa (estado)
    private String ibge; // Campo para armazenar o código do IBGE (Instituto Brasileiro de Geografia e Estatística)
    private String gia; // Campo para armazenar o código da GIA (Guia de Informação de Apuração do ICMS)
    private String ddd; // Campo para armazenar o código DDD (Discagem Direta à Distância) do telefone
    private String siafi; // Campo para armazenar o código SIAFI (Sistema de Administração dos Recursos de Tecnologia da Informação)

    // Métodos getters e setters para acessar e modificar os campos da entidade
    public Long getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(Long id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getSiafi() {
        return siafi;
    }

    public void setSiafi(String siafi) {
        this.siafi = siafi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }
}
