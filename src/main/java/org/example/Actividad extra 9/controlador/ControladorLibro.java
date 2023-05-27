package org.example.controlador;

import org.example.modelo.ModeloTabla;
import org.example.vista.VentanaLibro;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ControladorLibro extends MouseAdapter {
    private VentanaLibro view;

    public ControladorLibro(VentanaLibro view) {
        this.view = view;
        modelo = new ModeloTabla();
        this.view.getTblLibro().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.getBtnCargar()){

            modelo.cargarDatos();
            this.view.getTblLibro().setModel(modelo);
            this.view.getTblLibro().updateUI();

        }
        if(e.getSource() = = this.view.getBtnCargar()){
            Libro libro = new Libro();
            libro.setId(0);
            libro.setTitulo(this.view.getTxtTitulo().getText());
            libro.setAutor(this.view.getTxtAutor().getText());
            if (modelo.agregarLibro(Libro)){
                JOptionPane.showMessageDialog(view, "Se agrego correctamente",
                        "Aviso",JOptionPane.INFORMATION_MESSAGE);
          this.view.getTblLibro().updateUI();
            }else{
                JOptionPane.showMessageDialog(view,
                        "No se pudo agregar la base de datos. Por favor revise su conexión"
                , "Error al insertar", JOptionPane.ERROR_MESSAGE);
            }
            this.view.limpiar();

        }

    }
}
