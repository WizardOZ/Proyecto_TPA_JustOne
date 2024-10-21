package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterFrame extends JFrame {

    // Constructor para inicializar la ventana de registro
    public RegisterFrame() {
        setTitle("Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null); // Centrar la ventana

        // Panel para organizar los elementos
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        // Crear los componentes de la interfaz
        JLabel userLabel = new JLabel("Nuevo Usuario:");
        JTextField userText = new JTextField();
        JLabel passwordLabel = new JLabel("Nueva Contraseña:");
        JPasswordField passwordText = new JPasswordField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailText = new JTextField();
        JLabel phoneLabel = new JLabel("Telefono:");
        JPasswordField phoneText = new JPasswordField();


        // Botón de registro
        JButton registerButton = new JButton("Registrar");

        // Añadir los componentes al panel
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(emailLabel);
        panel.add(emailText);
        panel.add(phoneLabel);
        panel.add(phoneText);
        panel.add(new JLabel());  // Espacio vacío
        panel.add(registerButton);

        // Añadir el panel a la ventana
        add(panel);
        setVisible(true);

        // Acción al hacer clic en el botón de registrar
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newUser = userText.getText();
                String newPassword = new String(passwordText.getPassword());

                // Simular el registro
                if (!newUser.isEmpty() && !newPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Registro exitoso.");
                    // Redirigir de nuevo al Login
                    new LoginFrame();
                    dispose(); // Cierra la ventana de registro
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}

