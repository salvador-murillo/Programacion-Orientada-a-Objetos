package mx.udg.cucea.contactos.graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mx.udg.cucea.archivos.EscritorArchivoContacto;
import mx.udg.cucea.baseDeDatos.AdministradorBD;
import mx.udg.cucea.datos.Contacto;

//Extiende de JFrame para poder crear ventanas
public class VentanaDetalles extends JFrame {
    //Etiquetas y campos de texto
    private JLabel etiquetaNombres;
    private JLabel etiquetaApellidoPaterno;
    private JLabel etiquetaApellidoMaterno;
    private JLabel etiquetaTelefonoDeCasa;
    private JLabel etiquetaTelefonoDeOficina;
    private JLabel etiquetaTelefonoCelular;
    private JLabel etiquetaCorreoElectronico;
    private JLabel errores;

    private JTextField campoDeTextoNombres;
    private JTextField campoDeTextoApellidoPaterno;
    private JTextField campoDeTextoApellidoMaterno;
    private JTextField campoDeTextoTelefonoDeCasa;
    private JTextField campoDeTextoTelefonoDeOficina;
    private JTextField campoDeTextoTelefonoCelular;
    private JTextField campoDeTextoCorreoElectronico;
    
    //Botones
    private JButton botonAceptar;
    private JButton botonCancelar;
    
    private VentanaListaDeContacto vlc;
    private Contacto contactoAEditar;

    //Constructor (agregar)
    public VentanaDetalles(VentanaListaDeContacto vlc) {
        this.vlc = vlc;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initialize();
        setSize(1000, 800);
        setVisible(true);
    }
    
    //Constructor (editar)
    public VentanaDetalles(VentanaListaDeContacto vlc, Contacto contactoAEditar) {
        this.contactoAEditar = contactoAEditar;
        this.vlc = vlc;
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initialize();
        setSize(1000, 800);
        setVisible(true);
    }

    private void initialize() {
        //Crea las etiquetas, define tamaño y los agrega a la ventana
        etiquetaNombres = new JLabel("Nombres");
        etiquetaNombres.setBounds(50,100,200,50);
        add(etiquetaNombres);
        
        etiquetaApellidoPaterno = new JLabel("Apellido Paterno");
        etiquetaApellidoPaterno.setBounds(50,150,200,50);
        add(etiquetaApellidoPaterno);
        
        etiquetaApellidoMaterno = new JLabel("Apellido Materno");
        etiquetaApellidoMaterno.setBounds(50,200,200,50);
        add(etiquetaApellidoMaterno);        
               
        etiquetaTelefonoDeCasa = new JLabel("Telefono de Casa");
        etiquetaTelefonoDeCasa.setBounds(50,250,200,50);
        add(etiquetaTelefonoDeCasa);    
        
        etiquetaTelefonoDeOficina = new JLabel("Telefono de Oficina");
        etiquetaTelefonoDeOficina.setBounds(50,300,200,50);
        add(etiquetaTelefonoDeOficina);     
        
        etiquetaTelefonoCelular = new JLabel("Telefono Celular");
        etiquetaTelefonoCelular.setBounds(50,350,200,50);
        add(etiquetaTelefonoCelular);
        
        etiquetaCorreoElectronico = new JLabel("Correo Electronico");
        etiquetaCorreoElectronico.setBounds(50,400,200,50);
        add(etiquetaCorreoElectronico);
        
        errores = new JLabel("");
        errores.setBounds(200, 450, 500, 60);
        errores.setForeground(Color.red);
        add(errores);
        
        //Crea los campos de texto, define tamaño y los agrega a la ventana
        campoDeTextoNombres = new JTextField();
        campoDeTextoNombres.setBounds(350,100,500,50);
        add(campoDeTextoNombres);
        
        campoDeTextoApellidoPaterno = new JTextField();
        campoDeTextoApellidoPaterno.setBounds(350,150,500,50);
        add(campoDeTextoApellidoPaterno);        
        
        campoDeTextoApellidoMaterno = new JTextField();
        campoDeTextoApellidoMaterno.setBounds(350,200,500,50);
        add(campoDeTextoApellidoMaterno);      
        
        campoDeTextoTelefonoDeCasa = new JTextField();
        campoDeTextoTelefonoDeCasa.setBounds(350,250,500,50);
        add(campoDeTextoTelefonoDeCasa); 
        
        campoDeTextoTelefonoDeOficina = new JTextField();
        campoDeTextoTelefonoDeOficina.setBounds(350,300,500,50);
        add(campoDeTextoTelefonoDeOficina);         
        
        campoDeTextoTelefonoCelular = new JTextField();
        campoDeTextoTelefonoCelular.setBounds(350,350,500,50);
        add(campoDeTextoTelefonoCelular);                 
        
        campoDeTextoCorreoElectronico = new JTextField();
        campoDeTextoCorreoElectronico.setBounds(350,400,500,50);
        add(campoDeTextoCorreoElectronico);  
        
        //Crea el boton aceptar, define tamaño
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(350,550,200,80);
        
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errores.setText("");
                
                String nombres = campoDeTextoNombres.getText().trim();
                if(nombres.length() == 0){
                    errores.setText("El nombre no puede estar vacio");
                }
                String apellidoPaterno = campoDeTextoApellidoPaterno.getText().trim();
                String apellidoMaterno = campoDeTextoApellidoMaterno.getText().trim();
                long telefonoMovil = 0;
                long telefonoDeCasa = 0;
                long telefonoOficina = 0;
                try {
                    telefonoMovil = Long.parseLong(campoDeTextoTelefonoCelular.getText());
                }catch(NumberFormatException ex){
                    errores.setText("El telefono celular que ingresaste no es numerico");
                }
                try {
                    telefonoDeCasa = Long.parseLong(campoDeTextoTelefonoDeCasa.getText());
                }catch(NumberFormatException ex){
                    errores.setText("El telefono de casa que ingresaste no es numerico");
                }
                try {
                    telefonoOficina = Long.parseLong(campoDeTextoTelefonoDeOficina.getText());
                }catch(NumberFormatException ex){
                    errores.setText("El telefono de oficina que ingresaste no es numerico");
                }
                
                String correoElectronico = campoDeTextoCorreoElectronico.getText();
                Contacto contacto = new Contacto(nombres, telefonoMovil);
                contacto.setApellidoPaterno(apellidoPaterno);
                contacto.setApellidoMaterno(apellidoMaterno);
                contacto.setTelefonoDeCasa(telefonoDeCasa);
                contacto.setTelefonoDeOficina(telefonoOficina);
                contacto.setCorreoElectronico(correoElectronico);
                if(errores.getText().equals("")){
                    dispose();
                    vlc.setVisible(true);
                    
                    AdministradorBD abd = new AdministradorBD();
                    //EscritorArchivoContacto eac = new EscritorArchivoContacto(contacto);
                    if(contactoAEditar != null){
                        abd.actualizarContacto(contactoAEditar, contacto);
                        //eac.editarContacto(contactoAEditar);
                    } else {
                        abd.insertarContacto(contacto);
                        //eac.agregarContenido();
                    }
                    //eac.close();
                    vlc.actualizarModeloDeLista();
                }
            }
        });
        add(botonAceptar);  
        
        //Crea el boton cancelar, define tamaño
        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(570,550,200,80);
        
        botonCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                vlc.setVisible(true);
            }   
        });
        add(botonCancelar);        
        
        //Si se va a editar llena los campos de texto con el contacto a editar
        if (contactoAEditar != null){
            campoDeTextoNombres.setText(contactoAEditar.getNombres());
            campoDeTextoApellidoPaterno.setText(contactoAEditar.getApellidoPaterno());
            campoDeTextoApellidoMaterno.setText(contactoAEditar.getApellidoMaterno());
            campoDeTextoTelefonoCelular.setText(String.valueOf(contactoAEditar.getTelefonoMovil()));
            campoDeTextoTelefonoDeCasa.setText(String.valueOf(contactoAEditar.getTelefonoDeCasa()));
            campoDeTextoTelefonoDeOficina.setText(String.valueOf(contactoAEditar.getTelefonoDeOficina()));
            campoDeTextoCorreoElectronico.setText(contactoAEditar.getCorreoElectronico());    
        }
    }

}
