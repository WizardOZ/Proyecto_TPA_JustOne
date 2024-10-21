package Juego;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    // Constructor para inicializar la ventana de login
    public LoginFrame() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer que el frame ocupe toda la pantalla
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza el JFrame a pantalla completa

        // Panel para organizar los elementos
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout()); // Usamos GridBagLayout para centrar los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Para que los componentes mantengan su tamaño

        // Crear los componentes de la interfaz
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userText = new JTextField(15); // Definimos el tamaño del campo de texto
        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordText = new JPasswordField(15); // Definimos el tamaño de la contraseña

        // Botones
        JButton loginButton = new JButton("Iniciar sesión");
        JButton registerButton = new JButton("Registrarse");

        // Agregar los componentes al panel de forma centrada
        gbc.insets = new Insets(5, 5, 5, 5); // Espacio entre componentes

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Hacer que el botón ocupe dos columnas
        panel.add(loginButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Hacer que el botón ocupe dos columnas
        panel.add(registerButton, gbc);

        // Añadir el panel a la ventana y centrarlo dentro del frame
        add(panel, BorderLayout.CENTER);

        setVisible(true);

        // Acción al hacer clic en el botón de login
        loginButton.addActionListener(e -> {
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
        });

        // Acción al hacer clic en el botón de registrarse
        registerButton.addActionListener(e -> {
            // Abrir el nuevo formulario de registro
            new RegisterFrame();  // Crea la ventana de registro
            dispose(); // Cierra la ventana actual de login
        });
    }


}
