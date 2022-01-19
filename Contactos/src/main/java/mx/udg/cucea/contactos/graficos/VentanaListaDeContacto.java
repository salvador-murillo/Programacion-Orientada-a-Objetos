package mx.udg.cucea.contactos.graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import mx.udg.cucea.archivos.EscritorArchivoContacto;
import mx.udg.cucea.baseDeDatos.AdministradorBD;
//import mx.udg.cucea.archivos.LeerArchivoContacto;
import mx.udg.cucea.datos.Contacto;

//Extiende de JFrame para poder crear ventanas
public class VentanaListaDeContacto extends JFrame {

    private JButton botonAgregar;
    private JButton botonEditar;
    private JButton botonBorrar;
    private DefaultListModel<Contacto> modeloDeLista;
    private JList lista;
    private JLabel itemNoSeleccionado;

    //Constructor
    public VentanaListaDeContacto() {
        setLayout(null);
        inicializar();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 800);
        setVisible(true);
    }

    private void inicializar() {
        //--AGREGAR
        botonAgregar = new JButton("Agregar");
        botonAgregar.setBounds(500, 100, 250, 100);
        //CLICK AGREGAR//Accion Escuchar 
        botonAgregar.addActionListener(new ActionListener() {
            @Override
            //Metodo (Accion Realizada)
            public void actionPerformed(ActionEvent e) {
                itemNoSeleccionado.setText("");
                //Al presionar el boton agregar, llama la ventana detalles, y oculta la actual
                new VentanaDetalles(VentanaListaDeContacto.this); //PREGUNTAR
                setVisible(false);
            }
        });
        add(botonAgregar);

        //--EDITAR---
        botonEditar = new JButton("Editar");
        botonEditar.setBounds(500, 300, 250, 100);
        //CLICK  EDITAR//Accion Escuchar 
        botonEditar.addActionListener(new ActionListener() {
            //Metodo (Accion Realizada)
            public void actionPerformed(ActionEvent e) {
                //Si hay un elemento de la lista seleccionado, realiza la accion
                if (lista.getSelectedValue() != null) {
                    itemNoSeleccionado.setText("");
                    //Convertimos el item seleccionado a contacto y lo guardamos
                    Contacto contactoAEditar = (Contacto) lista.getSelectedValue();
                    //Mandamos llamar la ventana detalles pasandole el contacto a editar
                    new VentanaDetalles(VentanaListaDeContacto.this, contactoAEditar);
                    setVisible(false);
                }else{
                    itemNoSeleccionado.setText("Selecciona un contacto de la lista para editar");
                }
            }
        });
        add(botonEditar);

        //--BORRAR---
        botonBorrar = new JButton("Borrar");
        botonBorrar.setBounds(500, 500, 250, 100);
        //CLICK BORRAR//Accion Escuchar 
        botonBorrar.addActionListener(new ActionListener() {
            @Override
            //Metodo (Accion Realizada)
            public void actionPerformed(ActionEvent e) {
                //Si hay un elemento de la lista seleccionado, realiza la accion
                if (lista.getSelectedValue() != null) {
                    AdministradorBD abd = new AdministradorBD();
                    Contacto c = (Contacto) lista.getSelectedValue();
                    //Se crea objeto a borrar pasandole la ubicacion
                    //File archivoABorrar = new File(EscritorArchivoContacto.CARPETA + c.getTelefonoMovil());
                    //Se borra archivo
                    abd.borrarContacto(c); //Con BD
                    //archivoABorrar.delete(); //Con file
                    //Se actualiza la lista
                    actualizarModeloDeLista();
                }else{
                    itemNoSeleccionado.setText("Selecciona un contacto de la lista para borrar");
                }
            }
        });
        add(botonBorrar);

        itemNoSeleccionado = new JLabel("");
        itemNoSeleccionado.setBounds(100, 30, 500, 60);
        itemNoSeleccionado.setForeground(Color.red);
        add(itemNoSeleccionado);
        
        //Crea el modelo de lista de objetos contacto
        modeloDeLista = new DefaultListModel<Contacto>();
        //Crea una lista nueva pasandole el modelo
        lista = new JList(modeloDeLista);
        actualizarModeloDeLista();
        lista.setBounds(100, 100, 350, 500);
        add(lista);
        //lista.setBackground(Color.DARK_GRAY.darker());

    }

    //Metodo que actualiza el modelo de lista de contactos
    public void actualizarModeloDeLista() {
        //Limpia el modelo
        modeloDeLista.clear();
        //LeerArchivoContacto lac = new LeerArchivoContacto(); //
        AdministradorBD lac = new AdministradorBD();  //Usando BD 
        //Nuevo arreglo de contactos, se llenan por el objeto lac y el metodo leer contactos
        ArrayList<Contacto> contactos = lac.leerContactos();
        //Se agrega el arreglo al modelo de lista
        modeloDeLista.addAll(contactos);
    }

    public static void main(String[] args) {
        new VentanaListaDeContacto();
    }
}
