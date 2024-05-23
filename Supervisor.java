import java.util.ArrayList;  // Importa a classe ArrayList do pacote java.util para listas dinâmicas
import java.util.List;  // Importa a interface List do pacote java.util para definir listas

// A classe Supervisor herda da classe Funcionario
public class Supervisor extends Funcionario {
    // Lista de operadores que o supervisor gerencia
    private List<Operador> operadores;

    // Construtor da classe Supervisor
    // Recebe os parâmetros nome, cpf, salarioBase, descontos e cargo
    public Supervisor(String nome, String cpf, double salarioBase, double descontos, String cargo) {
        // Chama o construtor da classe pai (Funcionario) para inicializar os atributos herdados
        super(nome, cpf, salarioBase, descontos, cargo);
        // Inicializa a lista de operadores como uma nova ArrayList
        this.operadores = new ArrayList<>();
    }

    // Método para adicionar um operador à lista de operadores
    public void adicionarOperador(Operador operador) {
        operadores.add(operador);
    }

    // Método para remover um operador da lista de operadores
    public void removerOperador(Operador operador) {
        operadores.remove(operador);
    }

    // Método para obter a lista de operadores
    public List<Operador> getOperadores() {
        return operadores;
    }

    // Sobrescreve o método toString para fornecer uma representação em string do objeto Supervisor
    @Override
    public String toString() {
        return "Supervisor{" +
                "nome='" + getNome() + '\'' +  // Obtém o nome do supervisor
                ", cpf='" + getCpf() + '\'' +  // Obtém o CPF do supervisor
                ", salarioBase=" + getSalarioBase() +  // Obtém o salário base do supervisor
                ", descontos=" + getDescontos() +  // Obtém os descontos do supervisor
                ", cargo='" + getCargo() + '\'' +  // Obtém o cargo do supervisor
                ", operadores=" + operadores +  // Obtém a lista de operadores gerenciados pelo supervisor
                '}';
    }
}
