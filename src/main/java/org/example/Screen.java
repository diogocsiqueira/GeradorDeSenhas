package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Screen extends javax.swing.JFrame {

    PasswordGenerator pg = new PasswordGenerator();

    private final JLabel jLabel1 = new JLabel("Senha gerada:");
    private final JTextField jTextField1 = new JTextField();
    private final JCheckBox jCheckBox1 = new JCheckBox("Incluir letras maiúsculas");
    private final JCheckBox jCheckBox2 = new JCheckBox("Incluir letras minusculas");
    private final JCheckBox jCheckBox3 = new JCheckBox("Incluir números");
    private final JCheckBox jCheckBox4 = new JCheckBox("Incluir símbolos");

    public Screen() {
        setTitle("Gerador de Senhas");
        setSize(700, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        // Título
        JLabel titleLabel = new JLabel("Gerador de Senhas Personalizado");
        titleLabel.setBounds(150, 20, 300, 30);
        titleLabel.setFont(titleLabel.getFont().deriveFont(16.0f));
        add(titleLabel);

        // Label do comprimento da senha
        JLabel lengthLabel = new JLabel("Comprimento da senha:");
        lengthLabel.setBounds(50, 70, 200, 30);
        add(lengthLabel);

        // TextField para o comprimento da senha
        jTextField1.setBounds(250, 70, 80, 30);
        add(jTextField1);

        // Checkboxes para opções
        jCheckBox1.setBounds(50, 120, 300, 30);
        add(jCheckBox1);

        jCheckBox2.setBounds(50, 160, 300, 30);
        add(jCheckBox2);

        jCheckBox3.setBounds(50, 200, 300, 30);
        add(jCheckBox3);

        jCheckBox4.setBounds(50, 240, 300, 30);
        add(jCheckBox4);

        // Botão para gerar senha
        JButton button = new JButton("Gerar");
        button.setBounds(250, 300, 100, 30);
        button.addActionListener(this::gerarSenha);
        add(button);

        // Label para exibir a senha gerada
        jLabel1.setBounds(50, 350, 500, 30);
        add(jLabel1);

        // Botão para copiar para area de transferencia
        JButton jButton2 = new JButton("Copiar");
        jButton2.setBounds(400, 300, 100, 30);
        jButton2.addActionListener(this::copiarSenha);
        add(jButton2);

        setVisible(true);
    }

    private void gerarSenha(ActionEvent actionEvent) {
        boolean insertUppercase = jCheckBox1.isSelected();
        boolean insertLowercase = jCheckBox2.isSelected();
        boolean insertNumbers = jCheckBox3.isSelected();
        boolean insertSymbols = jCheckBox4.isSelected();
        String passwordGenerated;

        try {
            int length = Integer.parseInt(jTextField1.getText());

            if (length <= 0){
                jLabel1.setText("Digite um valor maior que 0");
            }else {
                passwordGenerated = pg.generatePassword(length, insertUppercase, insertLowercase, insertNumbers, insertSymbols);
                jLabel1.setText(passwordGenerated);
            }

        }catch (NumberFormatException e){
            jLabel1.setText("Por favor, digite um número válido");

        }

    }

    private void copiarSenha(ActionEvent actionEvent) {
        pg.copyPasswordToClipboard(jLabel1.getText());
    }
}
