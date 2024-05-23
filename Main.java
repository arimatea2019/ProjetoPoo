import javax.swing.SwingUtilities;  // Importa a classe SwingUtilities do pacote javax.swing para manipulação de threads na GUI

// Classe principal que contém o método main para iniciar a aplicação
public class Main {
    public static void main(String[] args) {
        // Usa SwingUtilities.invokeLater para garantir que a criação e manipulação da GUI ocorram na thread de despacho de eventos do Swing
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Cria uma nova instância de MainFrame e a torna visível
                new MainFrame().setVisible(true);
            }
        });
    }
}
