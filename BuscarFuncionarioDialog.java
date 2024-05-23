import javax.swing.*;  // Importa todas as classes do pacote javax.swing para criar a interface gráfica
import java.awt.*;  // Importa todas as classes do pacote java.awt para componentes de GUI e layouts
import java.awt.event.ActionEvent;  // Importa a classe ActionEvent para tratar eventos de ação
import java.awt.event.ActionListener;  // Importa a interface ActionListener para receber notificações de ação

// A classe BuscarFuncionarioDialog estende JDialog para criar uma janela de diálogo personalizada
public class BuscarFuncionarioDialog extends JDialog {
    // Campo de texto para entrada do CPF do funcionário
    private JTextField txtCpf;
    // Referência ao gerenciador de funcionários para buscar o funcionário
    private GerenciadorFuncionarios gerenciador;

    // Construtor da classe BuscarFuncionarioDialog
    public BuscarFuncionarioDialog(Frame owner, GerenciadorFuncionarios gerenciador) {
        // Chama o construtor da superclasse JDialog, definindo o título e a modalidade
        super(owner, "Buscar Funcionário", true);
        this.gerenciador = gerenciador;

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

        // Cria um botão para buscar o funcionário
        JButton btnBuscar = new JButton("Buscar");
        // Adiciona um ActionListener ao botão para tratar o evento de clique
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chama o método buscarFuncionario quando o botão é clicado
                buscarFuncionario();
            }
        });
        // Adiciona o botão à janela
        add(btnBuscar);
    }

    // Método para buscar um funcionário pelo CPF
    private void buscarFuncionario() {
        // Obtém o CPF do campo de texto
        String cpf = txtCpf.getText();
        // Busca o funcionário pelo CPF usando o gerenciador de funcionários
        Funcionario funcionario = gerenciador.buscarFuncionarioPorCpf(cpf);
        // Se o funcionário for encontrado, exibe seus detalhes em uma mensagem
        if (funcionario != null) {
            JOptionPane.showMessageDialog(this, funcionario.toString(), "Detalhes do Funcionário", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Se o funcionário não for encontrado, exibe uma mensagem de erro
            JOptionPane.showMessageDialog(this, "Funcionário não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        // Fecha a janela de diálogo
        dispose();
    }
}
