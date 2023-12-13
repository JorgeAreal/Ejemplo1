package com.mycompany.calculadoradepropina;

import javax.swing.JButton;
import javax.swing.JLabel;

public class IdiomaHelper {

    // Variable para el idioma de los resultados
    private static String resultadoIdioma = "español";

    // Método para cambiar el idioma de la interfaz y sus componentes
    public static void cambiarIdioma(JButton cambiarIdiomaButton, boolean esIngles, JLabel precioLabel, JLabel porcentajeLabel, JButton calcularButton, JButton borrarButton, JButton salirButton, JButton ajustesButton) {

        // Actualizo los textos según el idioma seleccionado
        resultadoIdioma = esIngles ? "inglés" : "español";

        // Utilizao matrices unidimensionales para almacenar cadenas de texto en diferentes idiomas.
        // Si la variable boolean 'esIngles' es verdadero, se elige el texto en inglés (índice 0); de lo contrario, se elige el texto en español (índice 1).
        String[] textosPrecio = {"Price (€): ", "Precio (€): "};
        String[] textosPorcentaje = {"Percentage (%): ", "Porcentaje (%): "};
        String[] textosCalcular = {"Calculate", "Calcular"};
        String[] textosBorrar = {"Clear", "Borrar"};
        String[] textosSalir = {"Exit", "Salir"};
        String[] textosAjustes = {"Settings", "Ajustes"};

        /* Asigno los textos correspondientes a cada componente según el idioma.
        Para ello utilizo el operador ternario (matriz[condición ? expresiónSiCierto : expresiónSiFalso]) 
        cuya funcion es seleccionar uno de los dos índices de la matriz segun si 'esIngles' es verdadero o falso */
        precioLabel.setText(textosPrecio[esIngles ? 0 : 1]);
        porcentajeLabel.setText(textosPorcentaje[esIngles ? 0 : 1]);
        calcularButton.setText(textosCalcular[esIngles ? 0 : 1]);
        borrarButton.setText(textosBorrar[esIngles ? 0 : 1]);
        salirButton.setText(textosSalir[esIngles ? 0 : 1]);
        ajustesButton.setText(textosAjustes[esIngles ? 0 : 1]);

    }

    // Método para obtener el idioma de los resultados
    public static String getResultadoIdioma() {
        return resultadoIdioma;
    }
}