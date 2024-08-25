package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import repository.UsuarioRepository;

public class TelaDeEntradaDoPG extends JFrame {
    private JTextField txtFacalogin;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    public UsuarioRepository usuarioRepository;

    public TelaDeEntradaDoPG() {
        usuarioRepository = new UsuarioRepository();
        setTitle("Tela de Login");
        setSize(2000, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Adiciona a imagem de fundo primeiro
        ImageIcon backgroundIcon = new ImageIcon("C:/Users/USER/IdeaProjects/ProjetoSimples/src/resources/Instagram Post Consultório Médico Simples Verde.png");
        Image image = backgroundIcon.getImage(); // transforma o ícone em imagem
        Image scaledImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH); // redimensiona a imagem
        backgroundIcon = new ImageIcon(scaledImage); // cria um novo ImageIcon com a imagem redimensionada

        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backgroundLabel);

        // Adiciona os componentes da interface por cima do background
        JLabel lblFacalogin = new JLabel("FAÇA SEU LOGIN");
        lblFacalogin.setBounds(320, 500, 200, 40);
        backgroundLabel.add(lblFacalogin);

        JLabel lblUsuario = new JLabel("Usuário:");
        lblUsuario.setBounds(235, 545, 80, 25);
        backgroundLabel.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(285, 545, 165, 25);
        backgroundLabel.add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(242, 580, 80, 25);
        backgroundLabel.add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(285, 580, 165, 25);
        backgroundLabel.add(txtSenha);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(322, 615, 80, 25);
        backgroundLabel.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String senha = new String(txtSenha.getPassword());

                if (usuario.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.");
                } else if (usuarioRepository.validarLogin(usuario, senha)) {
                    dispose();  // Fecha a tela de login
                    SwingUtilities.invokeLater(() -> {
                        ProgramaGUI programaGUI = new ProgramaGUI();
                        programaGUI.setVisible(true);
                    });
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaDeEntradaDoPG loginScreen = new TelaDeEntradaDoPG();
            loginScreen.setVisible(true);
        });
    }
}

