package Juego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    // Constructor para inicializar la ventana de login
    public LoginFrame() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Panel para organizar los elementos
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2)); // Organiza los elementos en un grid

        // Crear los componentes de la interfaz
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userText = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordText = new JPasswordField();

        // Botón de login
        JButton loginButton = new JButton("Iniciar sesión");

        // Añadir los componentes al panel
        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(new JLabel());  // Espacio vacío
        panel.add(loginButton);

        // Añadir el panel a la ventana
        add(panel);
        setVisible(true);

        // Acción al hacer clic en el botón de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                String password = new String(passwordText.getPassword());

                // Usuario y contraseña predefinidos
                String predefinedUser = "admin";
                String predefinedPassword = "1234";

                // Validar las credenciales
                if (user.equals(predefinedUser) && password.equals(predefinedPassword)) {
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                    // Aquí puedes continuar con la lógica de tu aplicación
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
