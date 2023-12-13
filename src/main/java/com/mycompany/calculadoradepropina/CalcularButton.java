package com.mycompany.calculadoradepropina;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CalcularButton {
    public static void gestionarCalculos(JButton calcularButton, JTextField precioField, JTextField porcentajeField, JFrame frame) {

        // Defino un ActionListener usando una expresión lambda para el botón 'calcularButton'
        calcularButton.addActionListener(calcular -> {
            // Obtengo el idioma actual de la interfaz
            String idiomaResultado = IdiomaHelper.getResultadoIdioma();

            // Verifico si los campos de texto están vacíos antes de intentar convertir su contenido en números
            if (precioField.getText().isEmpty() || porcentajeField.getText().isEmpty()) {
                if (idiomaResultado.equals("inglés")) {
                    JOptionPane.showMessageDialog(frame, "Please enter both price and percentage.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, introduzca tanto el precio como el porcentaje.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                return; // Sale del método si uno de los campos está vacío para que no salgan varios avisos
            }

            try {
                // Obtengo los valores de los campos de texto (precio y porcentaje) y se almacenan en variables
                double precio = Double.parseDouble(precioField.getText());
                double porcentaje = Double.parseDouble(porcentajeField.getText());

                // Verifico si el porcentaje o el precio es cero y se muestra un mensaje de error si es así
                if (porcentaje <= 0 || precio <= 0) {
                    if (idiomaResultado.equals("inglés")) {
                        // Mensaje de error en caso de porcentaje o precio cero (inglés)
                        JOptionPane.showMessageDialog(frame, "The percentage and price must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Mensaje de error en caso de porcentaje o precio cero (español)
                        JOptionPane.showMessageDialog(frame, "El porcentaje y el precio deben ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    return; // Sale del método si hay un error en el porcentaje
                }

                // Calculo la propina y el total a pagar
                double propina = precio * (porcentaje / 100);
                double total = precio + propina;

                // Muestro los resultados según el idioma seleccionado
                if (idiomaResultado.equals("inglés")) {
                    // Resultados en inglés
                    String mensajeIngles = String.format("Tip: %.2f euros | Total to pay: %.2f euros", propina, total);
                    JOptionPane.showMessageDialog(frame, mensajeIngles, "Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Resultados en español
                    String mensajeEspañol = String.format("Propina: %.2f euros | Total a pagar: %.2f euros", propina, total);
                    JOptionPane.showMessageDialog(frame, mensajeEspañol, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                // Capturo excepción si los campos de texto no contienen números válidos
                if (idiomaResultado.equals("inglés")) {
                    // Mensaje de error si los números ingresados no son válidos (inglés)
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Mensaje de error si los números ingresados no son válidos (español)
                    JOptionPane.showMessageDialog(frame, "Por favor, introduzca números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}