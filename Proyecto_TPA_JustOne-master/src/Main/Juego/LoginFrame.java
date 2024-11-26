package Juego;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginFrame extends JFrame {

    private JTextField userText;
    private JPasswordField passwordText;

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
        userText = new JTextField(15); // Definimos el tamaño del campo de texto
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordText = new JPasswordField(15); // Definimos el tamaño de la contraseña

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
        loginButton.addActionListener(e -> iniciarSesion());

        // Acción al hacer clic en el botón de registrarse
        registerButton.addActionListener(e -> {
            new RegisterFrame();  // Crea la ventana de registro
            dispose(); // Cierra la ventana actual de login
        });
    }

    private void iniciarSesion() {
        String user = userText.getText();
        String password = new String(passwordText.getPassword());

        // Validar las credenciales desde archivo txt
        boolean loginExitoso = false;  // Variable para comprobar el éxito del login
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("Leyendo línea: " + linea);  // Mensaje de depuración para ver si lee correctamente
                String[] datos = linea.split(",");
                if (datos.length >= 2) {  // Asegurarse de que la línea tenga suficientes datos
                    String usuarioGuardado = datos[0];
                    String passwordGuardada = datos[1];

                    if (user.equals(usuarioGuardado) && password.equals(passwordGuardada)) {
                        loginExitoso = true;
                        break;  // Salir del bucle una vez que se encuentra la coincidencia
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al leer los datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Salir de la función si hay un error
        }

        // Mostrar el resultado del login después de procesar el archivo
        if (loginExitoso) {
            JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso.");
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new LoginFrame());
    }
}
