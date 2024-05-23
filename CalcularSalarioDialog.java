import javax.swing.*;  // Importa todas as classes do pacote javax.swing para criar a interface gráfica
import java.awt.*;  // Importa todas as classes do pacote java.awt para componentes de GUI e layouts
import java.awt.event.ActionEvent;  // Importa a classe ActionEvent para tratar eventos de ação
import java.awt.event.ActionListener;  // Importa a interface ActionListener para receber notificações de ação

// A classe CalcularSalarioDialog estende JDialog para criar uma janela de diálogo personalizada
public class CalcularSalarioDialog extends JDialog {
    // Campo de texto para entrada do CPF do funcionário
    private JTextField txtCpf;
    // Referência ao gerenciador de funcionários para buscar o funcionário
    private GerenciadorFuncionarios gerenciador;
    // Referência à gestão financeira para calcular o salário líquido
    private GestaoFinanceira gestaoFinanceira;

    // Construtor da classe CalcularSalarioDialog
    public CalcularSalarioDialog(Frame owner, GerenciadorFuncionarios gerenciador, GestaoFinanceira gestaoFinanceira) {
        // Chama o construtor da superclasse JDialog, definindo o título e a modalidade
        super(owner, "Calcular Salário Líquido", true);
        this.gerenciador = gerenciador;
        this.gestaoFinanceira = gestaoFinanceira;

        // Define o layout da janela de diálogo como um GridLayout com 2 linhas e 2 colunas
        setLayout(new GridLayout(2, 2));
        // Define o tamanho da janela
        setSize(300, 100);
        // Define a localização da janela relativa à janela principal
        setLocationRelativeTo(owner);

        // Adiciona componentes de etiqueta e campo de texto para CPF
        add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        add(txtCpf);

        // Cria um botão para calcular o salário
        JButton btnCalcular = new JButton("Calcular");
        // Adiciona um ActionListener ao botão para tratar o evento de clique
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chama o método calcularSalario quando o botão é clicado
                calcularSalario();
            }
        });
        // Adiciona o botão à janela
        add(btnCalcular);
    }

    // Método para calcular o salário líquido de um funcionário
    private void calcularSalario() {
        // Obtém o CPF do campo de texto
        String cpf = txtCpf.getText();
        // Busca o funcionário pelo CPF usando o gerenciador de funcionários
        Funcionario funcionario = gerenciador.buscarFuncionarioPorCpf(cpf);
        // Se o funcionário for encontrado, calcula e exibe o salário líquido
        if (funcionario != null) {
            gestaoFinanceira.aplicarDescontos(funcionario);
            double salarioLiquido = gestaoFinanceira.calcularSalarioLiquido(funcionario);
            JOptionPane.showMessageDialog(this, "Salário Líquido de " + funcionario.getNome() + ": " + salarioLiquido);
        } else {
            // Se o funcionário não for encontrado, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Funcionário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        // Fecha a janela de diálogo
        dispose();
    }
}
