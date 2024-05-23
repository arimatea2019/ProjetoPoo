import java.util.ArrayList;  // Importa a classe ArrayList do pacote java.util para listas dinâmicas
import java.util.List;  // Importa a interface List do pacote java.util para definir listas

// A classe Coordenador herda da classe Funcionario
public class Coordenador extends Funcionario {
    // Lista de supervisores que o coordenador gerencia
    private List<Supervisor> supervisores;

    // Construtor da classe Coordenador
    // Recebe os parâmetros nome, cpf, salarioBase, descontos e cargo
    public Coordenador(String nome, String cpf, double salarioBase, double descontos, String cargo) {
        // Chama o construtor da classe pai (Funcionario) para inicializar os atributos herdados
        super(nome, cpf, salarioBase, descontos, cargo);
        // Inicializa a lista de supervisores como uma nova ArrayList
        this.supervisores = new ArrayList<>();
    }

    // Método para adicionar um supervisor à lista de supervisores
    public void adicionarSupervisor(Supervisor supervisor) {
        supervisores.add(supervisor);
    }

    // Método para remover um supervisor da lista de supervisores
    public void removerSupervisor(Supervisor supervisor) {
        supervisores.remove(supervisor);
    }

    // Método para obter a lista de supervisores
    public List<Supervisor> getSupervisores() {
        return supervisores;
    }

    // Sobrescreve o método toString para fornecer uma representação em string do objeto Coordenador
    @Override
    public String toString() {
        return "Coordenador{" +
                "nome='" + getNome() + '\'' +  // Obtém o nome do coordenador
                ", cpf='" + getCpf() + '\'' +  // Obtém o CPF do coordenador
                ", salarioBase=" + getSalarioBase() +  // Obtém o salário base do coordenador
                ", descontos=" + getDescontos() +  // Obtém os descontos do coordenador
                ", cargo='" + getCargo() + '\'' +  // Obtém o cargo do coordenador
                ", supervisores=" + supervisores +  // Obtém a lista de supervisores gerenciados pelo coordenador
                '}';
    }
}
