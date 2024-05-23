import java.util.List;  // Importa a interface List do pacote java.util para definir listas

// A classe GestaoFinanceira contém métodos para calcular salários e gerar a folha de pagamento
public class GestaoFinanceira {

    // Método para calcular o salário líquido de um funcionário
    public double calcularSalarioLiquido(Funcionario funcionario) {
        // Calcula os descontos com base no salário base do funcionário
        double descontos = calcularDescontos(funcionario.getSalarioBase());
        // Retorna o salário base subtraído dos descontos
        return funcionario.getSalarioBase() - descontos;
    }

    // Método para calcular descontos de um funcionário
    public double calcularDescontos(double salarioBruto) {
        // Calcula 8% do salário bruto para o FGTS
        double fgts = salarioBruto * 0.08;
        // Calcula o INSS com base no salário bruto
        double inss = calcularInss(salarioBruto);
        // Retorna a soma do FGTS e do INSS
        return fgts + inss;
    }

    // Método para calcular o INSS com base na tabela de alíquotas progressivas
    public double calcularInss(double salarioBruto) {
        double inss = 0.0;
        // Calcula o INSS de acordo com a faixa salarial do funcionário
        if (salarioBruto <= 1412.00) {
            inss = salarioBruto * 0.075;
        } else if (salarioBruto <= 2666.68) {
            inss = 1412.00 * 0.075 + (salarioBruto - 1412.00) * 0.09;
        } else if (salarioBruto <= 4000.03) {
            inss = 1412.00 * 0.075 + (2666.68 - 1412.00) * 0.09 + (salarioBruto - 2666.68) * 0.12;
        } else if (salarioBruto <= 7786.02) {
            inss = 1412.00 * 0.075 + (2666.68 - 1412.00) * 0.09 + (4000.03 - 2666.68) * 0.12 + (salarioBruto - 4000.03) * 0.14;
        } else {
            inss = 1412.00 * 0.075 + (2666.68 - 1412.00) * 0.09 + (4000.03 - 2666.68) * 0.12 + (7786.02 - 4000.03) * 0.14;
        }
        return inss;
    }

    // Método para aplicar descontos a um funcionário
    public void aplicarDescontos(Funcionario funcionario) {
        // Calcula os descontos com base no salário base do funcionário
        double descontos = calcularDescontos(funcionario.getSalarioBase());
        // Define os descontos calculados no funcionário
        funcionario.setDescontos(descontos);
    }

    // Método para gerar a folha de pagamento de uma lista de funcionários
    public String gerarFolhaPagamento(List<Funcionario> funcionarios) {
        // Usa um StringBuilder para construir a folha de pagamento
        StringBuilder folha = new StringBuilder();
        folha.append("Folha de Pagamento\n");
        folha.append("===================\n");

        // Itera sobre a lista de funcionários
        for (Funcionario funcionario : funcionarios) {
            folha.append("Nome: ").append(funcionario.getNome()).append("\n");
            folha.append("CPF: ").append(funcionario.getCpf()).append("\n");
            folha.append("Cargo: ").append(funcionario.getCargo()).append("\n");
            folha.append("Salário Base: ").append(funcionario.getSalarioBase()).append("\n");
            // Aplica os descontos ao funcionário
            aplicarDescontos(funcionario);
            folha.append("Descontos: ").append(funcionario.getDescontos()).append("\n");
            // Calcula e adiciona o salário líquido do funcionário
            folha.append("Salário Líquido: ").append(calcularSalarioLiquido(funcionario)).append("\n");
            folha.append("-------------------\n");
        }

        // Retorna a folha de pagamento como uma string
        return folha.toString();
    }
}
