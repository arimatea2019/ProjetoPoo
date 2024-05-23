import javax.swing.*;  // Importa todas as classes do pacote javax.swing para criar a interface gráfica
import java.awt.event.ActionEvent;  // Importa a classe ActionEvent para tratar eventos de ação
import java.awt.event.ActionListener;  // Importa a interface ActionListener para receber notificações de ação
import java.util.List;  // Importa a interface List do pacote java.util para definir listas

// A classe MainFrame estende JFrame para criar a janela principal da aplicação
public class MainFrame extends JFrame {
    // Declaração dos atributos gerenciador e gestaoFinanceira
    private GerenciadorFuncionarios gerenciador;
    private GestaoFinanceira gestaoFinanceira;

    // Construtor da classe MainFrame
    public MainFrame() {
        // Inicializa os atributos gerenciador e gestaoFinanceira
        gerenciador = new GerenciadorFuncionarios();
        gestaoFinanceira = new GestaoFinanceira();

        // Configurações da janela principal
        setTitle("Gerenciamento de Funcionários");  // Define o título da janela
        setSize(400, 300);  // Define o tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Define a operação padrão ao fechar a janela
        setLocationRelativeTo(null);  // Centraliza a janela na tela
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));  // Define o layout como BoxLayout na direção Y

        // Criação dos botões para cada funcionalidade
        JButton btnAdicionarFuncionario = new JButton("Adicionar Funcionário");
        JButton btnListarFuncionarios = new JButton("Listar Funcionários");
        JButton btnBuscarFuncionario = new JButton("Buscar Funcionário por CPF");
        JButton btnRemoverFuncionario = new JButton("Remover Funcionário");
        JButton btnCalcularSalario = new JButton("Calcular Salário Líquido");
        JButton btnGerarFolha = new JButton("Gerar Folha de Pagamento");

        // Adiciona ActionListeners aos botões para tratar eventos de clique

        btnAdicionarFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre o diálogo para adicionar funcionário quando o botão é clicado
                new AdicionarFuncionarioDialog(MainFrame.this, gerenciador).setVisible(true);
            }
        });

        btnListarFuncionarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lista todos os funcionários quando o botão é clicado
                listarFuncionarios();
            }
        });

        btnBuscarFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre o diálogo para buscar funcionário quando o botão é clicado
                new BuscarFuncionarioDialog(MainFrame.this, gerenciador).setVisible(true);
            }
        });

        btnRemoverFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre o diálogo para remover funcionário quando o botão é clicado
                new RemoverFuncionarioDialog(MainFrame.this, gerenciador).setVisible(true);
            }
        });

        btnCalcularSalario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abre o diálogo para calcular o salário líquido quando o botão é clicado
                new CalcularSalarioDialog(MainFrame.this, gerenciador, gestaoFinanceira).setVisible(true);
            }
        });

        btnGerarFolha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Gera a folha de pagamento quando o botão é clicado
                gerarFolhaPagamento();
            }
        });

        // Adiciona os botões à janela
        add(btnAdicionarFuncionario);
        add(btnListarFuncionarios);
        add(btnBuscarFuncionario);
        add(btnRemoverFuncionario);
        add(btnCalcularSalario);
        add(btnGerarFolha);
    }

    // Método para listar todos os funcionários
    private void listarFuncionarios() {
        // Obtém a lista de todos os funcionários
        List<Funcionario> funcionarios = gerenciador.listarTodosFuncionarios();
        // Usa um StringBuilder para construir a string de saída
        StringBuilder sb = new StringBuilder();
        for (Funcionario f : funcionarios) {
            sb.append(f).append("\n");  // Adiciona cada funcionário à string de saída
        }
        // Exibe a lista de funcionários em uma mensagem
        JOptionPane.showMessageDialog(this, sb.toString(), "Lista de Funcionários", JOptionPane.INFORMATION_MESSAGE);
    }

    // Método para gerar a folha de pagamento
    private void gerarFolhaPagamento() {
        // Obtém a lista de todos os funcionários
        List<Funcionario> funcionarios = gerenciador.listarTodosFuncionarios();
        // Gera a folha de pagamento como uma string
        String folhaPagamento = gestaoFinanceira.gerarFolhaPagamento(funcionarios);
        // Exibe a folha de pagamento em uma mensagem
        JOptionPane.showMessageDialog(this, folhaPagamento, "Folha de Pagamento", JOptionPane.INFORMATION_MESSAGE);
    }
}
