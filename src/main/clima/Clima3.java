

package main.clima;

import javax.swing.SwingUtilities;
import interfaceclima.GUI.clima_interface;


public class Clima3 {

    public static void main(String[] args) {
      // Inicializa a interface gráfica
        SwingUtilities.invokeLater(() -> {
            clima_interface app = new clima_interface();
            app.setVisible(true);
            app.setResizable(false); 
        });
    }
}
