import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterFrame extends JFrame {

    private JTextField userText;
    private JPasswordField passwordText;
    private JTextField emailText;
    private JTextField phoneText;

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
        userText = new JTextField();
        JLabel passwordLabel = new JLabel("Nueva Contraseña:");
        passwordText = new JPasswordField();
        JLabel emailLabel = new JLabel("Email:");
        emailText = new JTextField();
        JLabel phoneLabel = new JLabel("Telefono:");
        phoneText = new JTextField();

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
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        String newUser = userText.getText();
        String newPassword = new String(passwordText.getPassword());
        String email = emailText.getText();
        String phone = phoneText.getText();

        if (!newUser.isEmpty() && !newPassword.isEmpty() && !email.isEmpty() && !phone.isEmpty()) {
            // Guardar los datos en un archivo de texto
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
                writer.write(newUser + "," + newPassword + "," + email + "," + phone);
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Registro exitoso.");
                new LoginFrame(); // Redirigir de nuevo al Login
                dispose(); // Cerrar la ventana de registro
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar los datos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, rellene todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
