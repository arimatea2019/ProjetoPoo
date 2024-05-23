// A classe Operador herda da classe Funcionario
public class Operador extends Funcionario {
    // Construtor da classe Operador
    // Recebe os parâmetros nome, cpf, salarioBase, descontos e cargo
    public Operador(String nome, String cpf, double salarioBase, double descontos, String cargo) {
        // Chama o construtor da classe pai (Funcionario) para inicializar os atributos herdados
        super(nome, cpf, salarioBase, descontos, cargo);
    }

    // Sobrescreve o método toString para fornecer uma representação em string do objeto Operador
    @Override
    public String toString() {
        return "Operador{" +
                "nome='" + getNome() + '\'' +  // Obtém o nome do operador
                ", cpf='" + getCpf() + '\'' +  // Obtém o CPF do operador
                ", salarioBase=" + getSalarioBase() +  // Obtém o salário base do operador
                ", descontos=" + getDescontos() +  // Obtém os descontos do operador
                ", cargo='" + getCargo() + '\'' +  // Obtém o cargo do operador
                '}';
    }
}
