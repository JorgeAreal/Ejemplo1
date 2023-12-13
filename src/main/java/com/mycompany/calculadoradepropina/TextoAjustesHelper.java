package com.mycompany.calculadoradepropina;

import javax.swing.JButton;

public class TextoAjustesHelper {

    // Método para actualizar los textos de los botones en el diálogo de ajustes
    public static void actualizarBotonesIdioma(JButton cambiarIdiomaButton, JButton modoOscuroButton, boolean esIngles, boolean modoOscuro) {
        
        // Actualizo el texto del botón de cambio de idioma según el idioma actual
        cambiarIdiomaButton.setText(esIngles ? "Switch to Spanish" : "Cambiar a Inglés");

        // Defino el texto del botón de cambio de modo (oscuro/claro) según el idioma y el modo actual
        String textoModoOscuro = esIngles ?
                (modoOscuro ? "Switch to Light Mode" : "Switch to Dark Mode") : // Texto en inglés
                (modoOscuro ? "Cambiar a Modo Claro" : "Cambiar a Modo Oscuro"); // Texto en español

        // Asigno el texto correspondiente al botón de cambio de modo
        modoOscuroButton.setText(textoModoOscuro);
    }
}