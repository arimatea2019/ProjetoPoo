import java.util.ArrayList;  // Importa a classe ArrayList do pacote java.util para listas dinâmicas
import java.util.List;  // Importa a interface List do pacote java.util para definir listas

// A classe GerenciadorFuncionarios gerencia uma lista de objetos Funcionario
public class GerenciadorFuncionarios {
    // Lista de funcionários gerenciados
    private List<Funcionario> funcionarios;

    // Construtor da classe GerenciadorFuncionarios
    public GerenciadorFuncionarios() {
        // Inicializa a lista de funcionários como uma nova ArrayList
        this.funcionarios = new ArrayList<>();
    }

    // Método para adicionar um funcionário à lista
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    // Método para remover um funcionário da lista
    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }

    // Método para buscar um funcionário pelo CPF
    public Funcionario buscarFuncionarioPorCpf(String cpf) {
        // Itera sobre a lista de funcionários
        for (Funcionario funcionario : funcionarios) {
            // Verifica se o CPF do funcionário atual é igual ao CPF buscado
            if (funcionario.getCpf().equals(cpf)) {
                return funcionario;  // Retorna o funcionário se encontrado
            }
        }
        return null; // Retorna null se não encontrar o funcionário
    }

    // Método para listar todos os funcionários
    public List<Funcionario> listarTodosFuncionarios() {
        // Retorna uma nova ArrayList contendo todos os funcionários
        return new ArrayList<>(funcionarios);
    }

    // Sobrescreve o método toString para fornecer uma representação em string do objeto GerenciadorFuncionarios
    @Override
    public String toString() {
        return "GerenciadorFuncionarios{" +
                "funcionarios=" + funcionarios +
                '}';
    }
}
