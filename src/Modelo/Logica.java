package Modelo;

import Vista.ConsultaRegistros;
import Vista.RegistrarServicio;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Logica {

    public Logica() {
    }

    public void cambiarPestana(JPanel panel1, JPanel panel2) {
        panel1.setVisible(true);
        panel2.setVisible(false);
    }

    // registrar servicio 
    public void generarRecibo(RegistrarServicio servicio) {
        String nombre = servicio.jtextFuncionario.getText();
        String tipoServicio = servicio.jcomboTipoServicio.getSelectedItem().toString();
        String tipoAuto = servicio.jcomboTipoVehiculo.getSelectedItem().toString();
        String fecha = servicio.jtextFecha.getText();
        double valor = generarPrecio(servicio);
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("src//datos.txt", true);
            pw = new PrintWriter(fichero);

            String datos = fecha + ";" + nombre + ";" + tipoServicio + ";" + tipoAuto + ";" + valor;
            pw.println(datos);
            fichero.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String datos = "------------------------------------------------"
                + "\n////\n////     Fecha: " + fecha                   +"|"
                + "\n////     Funcionario: " + nombre                  +"|"
                + "\n////\n////     Tipo de Servicio: " + tipoServicio +"|"
                + "\n////     Tipo de vehiculo: " + tipoAuto           +"|"
                + "\n////\n////     Precio total: $ " + valor          +"|"
                + "\n////\n---------------------------------------------";
        servicio.jtextRecibo.setText(datos);
    }

    public double generarPrecio(RegistrarServicio servicio) {
        String[] servicios = new String[servicio.jcomboTipoServicio.getItemCount()];
        int[] precios = {20000, 35000, 15000, 30000, 45000, 60000, 85000};
        int precio = precios[servicio.jcomboTipoServicio.getSelectedIndex()];
        if (servicio.jcomboTipoVehiculo.getSelectedIndex() == 0) {
            return precio - (precio * 0.05);
        } else {
            return precio - (precio * 0.1) + 10000;
        }
    }

    // consultar registros
    private ArrayList leerArchivo() {
        ArrayList<Object[]> datos = new ArrayList<Object[]>();

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).

            File archivo = new File("src//datos.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] dato = linea.split(";");
                int n = dato.length;
                datos.add(dato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datos;
    }

    public void llenarTabla(ConsultaRegistros consulta) {
        ArrayList<Object[]> lista = leerArchivo();
        JTable tabla = consulta.jtableResultados;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        int n = lista.size();
        for (int i = 0; i < n; i++) {
            modelo.addRow(lista.get(i));
        }
        tabla.setModel(modelo);
    }

    public void hacerBusqueda(ConsultaRegistros consulta) {
        ArrayList<Object[]> lista = leerArchivo();
        JTable tabla = consulta.jtableResultados;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);
        int n = lista.size();
        int m = lista.get(0).length;
        String busqueda = consulta.jtextBusqueda1.getText();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(lista.get(i)[j].toString().equals(busqueda)) {
                    modelo.addRow(lista.get(i));
                }
            }
        }
        tabla.setModel(modelo);
    }

}
