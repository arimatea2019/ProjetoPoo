public class Funcionario {
    // Atributos privados da classe Funcionario
    private String nome;
    private String cpf;
    private double salarioBase;
    private double descontos;
    private String cargo;

    // Construtor da classe Funcionario
    // Recebe os parâmetros nome, cpf, salarioBase, descontos e cargo
    public Funcionario(String nome, String cpf, double salarioBase, double descontos, String cargo) {
        // Inicializa os atributos da classe com os valores passados como parâmetros
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
        this.descontos = descontos;
        this.cargo = cargo;
    }

    // Métodos Getters e Setters para acessar e modificar os atributos privados

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getDescontos() {
        return descontos;
    }

    public void setDescontos(double descontos) {
        this.descontos = descontos;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método para calcular o salário líquido
    // Retorna o salário base subtraído dos descontos
    public double calcularSalarioLiquido() {
        return salarioBase - descontos;
    }

    // Sobrescreve o método toString para fornecer uma representação em string do objeto Funcionario
    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +  // Obtém o nome do funcionário
                ", cpf='" + cpf + '\'' +  // Obtém o CPF do funcionário
                ", salarioBase=" + salarioBase +  // Obtém o salário base do funcionário
                ", descontos=" + descontos +  // Obtém os descontos do funcionário
                ", cargo='" + cargo + '\'' +  // Obtém o cargo do funcionário
                '}';
    }
}
