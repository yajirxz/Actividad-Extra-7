package org.example.controlador;

import org.example.modelo.ModeloTabla;
import org.example.vista.VentanaLibro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorLibro extends MouseAdapter {
    private VentanaLibro view;

    public ControladorLibro(VentanaLibro view) {
        this.view = view;
    this.view.getBtnCargar().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.getBtnCargar()){
            modelo = new ModeloTabla();
            modelo.cargarDatos();
            this.view.getTblLibro().setModel(modelo);
            this.view.getTblLibro().updateUI();

        }
    }
}
