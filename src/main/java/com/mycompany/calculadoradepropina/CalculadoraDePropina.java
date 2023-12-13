/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadoradepropina;

/**
 *
 * @author Jorge Areal Alberich
 */
import javax.swing.*;
import java.awt.*;

public class CalculadoraDePropina {

    // Declaro las variables asociadas a los elementos de la interfaz de usuario
    private static JLabel precioLabel;
    private static JLabel porcentajeLabel;
    private static JButton calcularButton;
    private static JButton borrarButton;
    private static JButton salirButton;
    private static JButton ajustesButton;

    public static void main(String[] args) {
        // Creacion y configuracion de la ventana principal
        JFrame frame = new JFrame("Calculadora de Propina"); // Creo una nueva ventana con el título "Calculadora de Propina"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establezco la operación de cierre cuando se cierra la ventana principal
        frame.setSize(400, 300); // Establezco el tamaño de la ventana principal en píxeles (ancho x alto)
        frame.setLocationRelativeTo(null); // Centro la ventana principal en el centro de la pantalla

        // Creacion de un panel para organizar los elementos
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10)); // Creo un panel con un diseño de rejilla de 4 filas, 2 columnas, con espacios de 10 píxeles entre celdas para hacer un diseño claro
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Establezco un borde vacío con márgenes de 20 píxeles en cada lado del panel        

        // Creacion de los campos de texto para ingresar precio y porcentaje
        JTextField precioField = new JTextField();
        JTextField porcentajeField = new JTextField();

        // Creacion de los botones y las etiquetas con su respectivo texto inicial
        precioLabel = new JLabel("Precio (€): ", SwingConstants.RIGHT); // Creo una etiqueta con el texto "Precio (€)" alineado a la derecha
        porcentajeLabel = new JLabel("Porcentaje (%): ", SwingConstants.RIGHT); // Creo una etiqueta con el texto "Porcentaje (%)" alineado a la derecha
        calcularButton = new JButton("Calcular"); // Creo un botón con el texto "Calcular". Asi sucesivamente con el resto de botones de la ventana principal
        borrarButton = new JButton("Borrar");
        salirButton = new JButton("Salir");
        ajustesButton = new JButton("Ajustes");
        

        // Agrego los componentes al panel
        panel.add(precioLabel);
        panel.add(precioField);
        panel.add(porcentajeLabel);
        panel.add(porcentajeField);
        panel.add(calcularButton);
        panel.add(borrarButton);
        panel.add(salirButton);
        panel.add(ajustesButton);

        // Agrego el panel a la ventana principal
        frame.getContentPane().add(panel);
        frame.setVisible(true);

        // Llamo al fichero "AjustesWindow" que se encarga de administrar la ventana de ajustes y todas sus funcionalidades.
        AjustesButton.gestionarAjustes(frame, panel, precioLabel, porcentajeLabel, calcularButton, borrarButton, salirButton, ajustesButton);

        // Llamo al fichero "CalcularButton" que se encarga de obtener y calcular los datos escritos por el usuario y mostrarlos por pantalla.
        CalcularButton.gestionarCalculos(calcularButton, precioField, porcentajeField, frame);

        // Defino un ActionListener usando una expresión lambda para el botón 'borrarButton'
        borrarButton.addActionListener(borrar -> {
            precioField.setText(""); // Establece el campo de texto del precio como vacío
            porcentajeField.setText(""); // Establece el campo de texto del porcentaje como vacío
        });

        // Defino un ActionListener usando una expresión lambda para el botón 'salirButton'
        salirButton.addActionListener(salir -> System.exit(0)); // Sale del programa con código de salida 0 (el codigo 0 indica al sistema operativo que la ejecución fue exitosa)
    }
}
