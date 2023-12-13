package com.mycompany.calculadoradepropina;

import javax.swing.*;
import java.awt.*;

public class CambiarModoHelper {

    // Método para cambiar entre el modo oscuro y el modo claro de la interfaz
    public static void cambiarModo(JFrame frame, JPanel panel, boolean modoOscuro) {
        // Define colores para el modo oscuro y el modo claro
        Color colorFondo = modoOscuro ? Color.DARK_GRAY : Color.WHITE; // Color de fondo
        Color colorTexto = Color.BLACK; // Color del texto
        Color colorBackground = modoOscuro ? Color.GRAY : Color.WHITE; // Color de fondo para ciertos elementos
        Color colorForeground = modoOscuro ? colorTexto : Color.BLACK; // Color de primer plano para ciertos elementos
    
        // Actualizo los colores de la interfaz llamando al método privado 'actualizarColores'
        actualizarColores(frame, panel, colorFondo, colorTexto, colorBackground, colorForeground);
    
        // Establezco los colores para los componentes de los diálogos emergentes (JOptionPane)
        UIManager.put("OptionPane.background", colorFondo);
        UIManager.put("Panel.background", colorFondo);
        UIManager.put("OptionPane.messageForeground", colorTexto);
    }
    

    // Método privado para actualizar los colores de los componentes en la interfaz
    private static void actualizarColores(JFrame frame, JPanel panel, Color colorFondo, Color colorTexto, Color colorBackground, Color colorForeground) {
        // Actualiza el color de fondo del JFrame y JPanel
        frame.getContentPane().setBackground(colorFondo);
        panel.setBackground(colorFondo);
    
        // Obtengo los componentes del panel y actualizo sus colores según el tipo de componente
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel || component instanceof JButton) {
                // Si el componente es una etiqueta (JLabel) o un botón (JButton):
                component.setForeground(colorTexto); // Actualizo el color de texto para etiquetas y botones
            } else if (component instanceof JTextField) {
                // Si el componente es un campo de texto (JTextField):
                component.setBackground(colorBackground); // Actualizo el color de fondo para campos de texto
                component.setForeground(colorForeground); // Actualizo el color de texto para campos de texto
            }
        }
    }
}