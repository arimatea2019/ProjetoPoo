import javax.swing.*;  // Importa todas as classes do pacote javax.swing para criar a interface gráfica
import java.awt.*;  // Importa todas as classes do pacote java.awt para componentes de GUI e layouts
import java.awt.event.ActionEvent;  // Importa a classe ActionEvent para tratar eventos de ação
import java.awt.event.ActionListener;  // Importa a interface ActionListener para receber notificações de ação

// A classe AdicionarFuncionarioDialog estende JDialog para criar uma janela de diálogo personalizada
public class AdicionarFuncionarioDialog extends JDialog {
    // Campos de texto para entrada de dados do funcionário
    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtSalarioBase;
    private JTextField txtCargo;
    // Referência ao gerenciador de funcionários para adicionar o novo funcionário
    private GerenciadorFuncionarios gerenciador;

    // Construtor da classe AdicionarFuncionarioDialog
    public AdicionarFuncionarioDialog(Frame owner, GerenciadorFuncionarios gerenciador) {
        // Chama o construtor da superclasse JDialog, definindo o título e a modalidade
        super(owner, "Adicionar Funcionário", true);
        this.gerenciador = gerenciador;

        // Define o layout da janela de diálogo como um GridLayout com 5 linhas e 2 colunas
        setLayout(new GridLayout(5, 2));
        // Define o tamanho da janela
        setSize(300, 200);
        // Define a localização da janela relativa à janela principal
        setLocationRelativeTo(owner);

        // Adiciona componentes de etiqueta e campo de texto para nome
        add(new JLabel("Nome:"));
        txtNome = new JTextField();
        add(txtNome);

        // Adiciona componentes de etiqueta e campo de texto para CPF
        add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        add(txtCpf);

        // Adiciona componentes de etiqueta e campo de texto para salário base
        add(new JLabel("Salário Base:"));
        txtSalarioBase = new JTextField();
        add(txtSalarioBase);

        // Adiciona componentes de etiqueta e campo de texto para cargo
        add(new JLabel("Cargo (Coordenador/Supervisor/Operador):"));
        txtCargo = new JTextField();
        add(txtCargo);

        // Cria um botão para adicionar o funcionário
        JButton btnAdicionar = new JButton("Adicionar");
        // Adiciona um ActionListener ao botão para tratar o evento de clique
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chama o método adicionarFuncionario quando o botão é clicado
                adicionarFuncionario();
            }
        });
        // Adiciona o botão à janela
        add(btnAdicionar);
    }

    // Método para adicionar um funcionário
    private void adicionarFuncionario() {
        // Obtém os dados dos campos de texto
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        double salarioBase = Double.parseDouble(txtSalarioBase.getText());
        String cargo = txtCargo.getText();

        // Declara uma variável para o novo funcionário
        Funcionario funcionario;
        // Cria um novo funcionário com base no cargo especificado
        if (cargo.equalsIgnoreCase("Coordenador")) {
            funcionario = new Coordenador(nome, cpf, salarioBase, 0.0, cargo);
        } else if (cargo.equalsIgnoreCase("Supervisor")) {
            funcionario = new Supervisor(nome, cpf, salarioBase, 0.0, cargo);
        } else {
            funcionario = new Operador(nome, cpf, salarioBase, 0.0, cargo);
        }

        // Adiciona o novo funcionário ao gerenciador de funcionários
        gerenciador.adicionarFuncionario(funcionario);
        // Exibe uma mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Funcionário adicionado com sucesso!");
        // Fecha a janela de diálogo
        dispose();
    }
}
