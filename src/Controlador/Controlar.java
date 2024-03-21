package Controlador;

import Modelo.Logica;
import Vista.ConsultaRegistros;
import Vista.Interfaz;
import Vista.RegistrarServicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Controlar implements ActionListener {

    private Interfaz view;
    private Logica model;
    private RegistrarServicio panelRegistrar;
    private ConsultaRegistros panelConsulta;

    public Controlar(Interfaz view, Logica model) {
        this.view = view;
        this.model = model;
        initComponent();
    }

    public Interfaz getView() {
        return view;
    }

    public Logica getModel() {
        return model;
    }

    public void setView(Interfaz view) {
        this.view = view;
    }

    public void setModel(Logica model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // realizar el cambio entre paneles
        if (e.getSource() == view.jbuttonRegistrarServicio) {
            model.cambiarPestana(panelRegistrar, panelConsulta);
        } else if (e.getSource() == view.jbuttonConsultarServicio) {
            model.llenarTabla(panelConsulta);
            model.cambiarPestana(panelConsulta, panelRegistrar);
        }

        if (e.getSource() == panelRegistrar.jbuttonGenerarRecibo) {
            if (!panelRegistrar.jtextFuncionario.getText().equals("")) {
                model.generarRecibo(panelRegistrar);
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un Funcionario");
            }
        }

        if (e.getSource() == panelConsulta.jbuttonBuscar) {
            
            model.hacerBusqueda(panelConsulta);
        }

        if (e.getSource() == panelConsulta.jcomboBusqueda) {
            if (panelConsulta.jcomboBusqueda.getSelectedIndex() == 2) {
                panelConsulta.jtextBusqueda2.setVisible(true);
                view.setSize(view.getWidth(), view.getHeight()-2);
            } else {
                panelConsulta.jtextBusqueda2.setVisible(false);
            }
        }

    }

    private void initComponent() {
        // colocar paneles principales en la ventana
        panelRegistrar = new RegistrarServicio();
        panelConsulta = new ConsultaRegistros();
        view.add(panelRegistrar);
        view.add(panelConsulta);
        panelRegistrar.setBounds(0, 120, 830, 360);
        panelRegistrar.setVisible(true);
        panelConsulta.setBounds(0, 120, 830, 360);
        panelConsulta.jtextBusqueda2.setVisible(false);
        panelConsulta.setVisible(false);
        view.setLocationRelativeTo(null);
        view.setVisible(true);
        // eventos para hacer el cambio entre paneles
        view.jbuttonConsultarServicio.addActionListener(this);
        view.jbuttonRegistrarServicio.addActionListener(this);
        // eventos para registrar un servicio
        Calendar fecha = Calendar.getInstance();
        String dia = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(fecha.get(Calendar.MONTH) + 1);
        String anio = String.valueOf(fecha.get(Calendar.YEAR));
        panelRegistrar.jtextFecha.setText(dia + "/" + mes + "/" + anio);
        panelRegistrar.jbuttonGenerarRecibo.addActionListener(this);

        // eventos para consultar
        panelConsulta.jbuttonBuscar.addActionListener(this);
        panelConsulta.jcomboBusqueda.addActionListener(this);
    }

}
