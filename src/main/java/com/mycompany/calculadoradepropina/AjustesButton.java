package com.mycompany.calculadoradepropina;

import javax.swing.*;
import java.awt.*;

public class AjustesButton {

    // Declaro las variables para controlar el modo oscuro y el idioma
    private static boolean modoOscuro = false; // Variable para controlar el modo oscuro
    private static boolean esIngles = false; // Variable para controlar el idioma

    public static void gestionarAjustes(JFrame frame, JPanel panel, JLabel precioLabel, JLabel porcentajeLabel, JButton calcularButton, JButton borrarButton, JButton salirButton, JButton ajustesButton) {

        // Defino un ActionListener usando una expresión lambda bajo la variable "ajustes" para el botón 'ajustesButton' que gestiona toda la ventana de ajustes
        ajustesButton.addActionListener(ajustes -> {
        
            // Creacion de una ventana exclusivamente para los ajustes
            JDialog dialog = new JDialog(frame, "Ajustes", true); // Creo un diálogo modal con título "Ajustes"
            dialog.setSize(200, 200); // Establezco el tamaño de la ventana
            dialog.setLocationRelativeTo(frame); // Ubico el diálogo en relación a la ventana principal, de esta forma la ventana de ajustes saldrá centrada con repsecto a la ventana principal
        
            JPanel dialogPanel = new JPanel(new GridLayout(2, 0, 0, 0)); // Creo un panel para los elementos y botones de la ventana con 2 filas y sin espacio entre celdas
        
            JButton modoOscuroButton = new JButton(); // Botón para cambiar el modo oscuro
            dialogPanel.add(modoOscuroButton); // Agrego el botón al panel
        
            JButton cambiarIdiomaButton = new JButton(); // Botón para cambiar el idioma
            dialogPanel.add(cambiarIdiomaButton); // Agrego el botón al panel
        
            /* Cada vez que se abre la ventana de ajustes, se invoca el fichero 'TextoAjustesHelper' para actualizar los textos de los botones en la ventana de ajustes. Esta clase
            administra qué texto debe aparecer sobre cada botón según la configuración de modo e idioma presente en ese momento segun lo seleccionado por el usuario. */
            TextoAjustesHelper.actualizarBotonesIdioma(cambiarIdiomaButton, modoOscuroButton, esIngles, modoOscuro);
        
            // ActionListener para el botón de cambio de modo oscuro.
            modoOscuroButton.addActionListener(oscuro -> {

                // En el momento que se presione el boton de cambio de modo de apariencia, se realizaran las siguientes acciones:

                modoOscuro = !modoOscuro; // Cambio el estado de la variable boolean 'modoOscuro'. Esto permite a las clases dependientes conocer y ajustarse al modo actual de visualización.
                
                // Invoco al fichero CambiarModoHelper, el cual se encarga de actualizar la interfaz para reflejar el cambio al modo pertinente.
                CambiarModoHelper.cambiarModo(frame,  panel, modoOscuro);
                
                // Actualizo los textos de los botones a tiempo real en el diálogo de ajustes según la configuración actual de idioma y modo.
                TextoAjustesHelper.actualizarBotonesIdioma(cambiarIdiomaButton, modoOscuroButton, esIngles, modoOscuro);
            });
                
        
            // ActionListener para el botón de cambio de idioma.
            cambiarIdiomaButton.addActionListener(idioma -> {

                // En el momento que se presione el boton de cambio de idioma, se realizaran las siguientes acciones:

                esIngles = !esIngles; // Cambio el estado de la variable boolean 'esIngles'. Utiliza el mismo mecanismo que la variable 'modoOscuro', pero en este caso 'esIngles' es aplicado en el cambio de idioma.

                // Invoco al fichero CambiarModoHelper, el cual se encarga de actualizar los textos de la interfaz al idioma pertinente.
                IdiomaHelper.cambiarIdioma(cambiarIdiomaButton, esIngles, precioLabel, porcentajeLabel, calcularButton, borrarButton, salirButton, ajustesButton);

                // Actualizo los textos de los botones a tiempo real en el diálogo de ajustes según la configuración actual de idioma y modo.
                TextoAjustesHelper.actualizarBotonesIdioma(cambiarIdiomaButton, modoOscuroButton, esIngles, modoOscuro);
            });

            dialog.getContentPane().add(dialogPanel); // Agrego el panel al contenido principal de la ventana de diálogo (dialog). Al añadirlo al 'contentPane' (el contenedor principal), el panel se mostrará dentro de la ventana de ajustes.
            dialog.setVisible(true); // Aquí establezco la visibilidad del diálogo (dialog) en 'true'.
        });
    }   
}
