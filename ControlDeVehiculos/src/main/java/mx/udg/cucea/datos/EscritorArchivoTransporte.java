package mx.udg.cucea.datos;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import mx.udg.cucea.vehiculos.Automovil;
import mx.udg.cucea.vehiculos.Macrobus;
import mx.udg.cucea.vehiculos.Motocicleta;
import mx.udg.cucea.vehiculos.Transporte;
import mx.udg.cucea.vehiculos.TransporteDeCarga;
import mx.udg.cucea.vehiculos.TransportePublico;
import mx.udg.cucea.vehiculos.TrenLigero;

public class EscritorArchivoTransporte extends FileWriter{
    //Creacion de variable transporte de tipo Transporte
    private Transporte transporte;

    //Constructor FileWriter recibe String
    public EscritorArchivoTransporte(Transporte t) throws IOException {
        super(t.getPlacas()+".txt");
        //Inicializamos la variable con lo que se mande de Transporte
        this.transporte = t;
    }
    
    public void escribirArchivo() throws IOException{
        //Append solo recibe Strings
        append(transporte.getPropietario());
        append(System.lineSeparator());
        append(transporte.getMarca());
        append(System.lineSeparator());  
        append(transporte.getModelo());
        append(System.lineSeparator());   
        append(String.valueOf(transporte.getAño()));
        append(System.lineSeparator());
        append(String.valueOf(transporte.getNumeroDeSerie()));
        append(System.lineSeparator());  
        append(String.valueOf(transporte.getNumeroDePuertas()));
        append(System.lineSeparator());  
        append(String.valueOf(transporte.getNumeroDeMotor()));
        append(System.lineSeparator()); 
        append(transporte.getTipoDeCombustible());  
        if(transporte instanceof Automovil){
            //Creacion de objeto de tipo automovil y convertimos a nuestro transporte
            Automovil a = (Automovil) transporte;
            append(System.lineSeparator());
            append(a.getTransmision()); 
            append(System.lineSeparator());
            append(String.valueOf(a.getNumeroDeCilindros()));
            append(System.lineSeparator());
            append(a.getColor().toString());
        }
        else if (transporte instanceof Macrobus){
            //Creacion de objeto de tipo Macrobus y convertimos a nuestro transporte
            Macrobus macro = (Macrobus) transporte;
            append(System.lineSeparator());
            append(String.valueOf(macro.getTipo()));         
            append(System.lineSeparator());
            append(String.valueOf(macro.getNumeroDeRemolques()));         
            append(System.lineSeparator());
            append(String.valueOf(macro.getNumeroDeEjes()));         
            append(System.lineSeparator());
            append(String.valueOf(macro.getNumeroDeEstaciones()));         
        }
        else if (transporte instanceof Motocicleta){
            //Creacion de objeto de tipo Motocicleta y convertimos a nuestro transporte
            Motocicleta moto = (Motocicleta) transporte;
            append(System.lineSeparator());
            append(moto.getColor().toString());
            append(System.lineSeparator());
            append(moto.getTransmision());
            append(System.lineSeparator());
            append(String.valueOf(moto.getNumeroDeCilindros()));
            append(System.lineSeparator());
            append(String.valueOf(moto.getPotencia()));
            append(System.lineSeparator());
            append(moto.getTipoDeLlantas());
        }
        else if (transporte instanceof TransporteDeCarga){
            //Creacion de objeto de tipo TransporteDeCarga y convertimos a nuestro transporte
            TransporteDeCarga carga = (TransporteDeCarga) transporte;
            append(System.lineSeparator());
            append(String.valueOf(carga.getToneladas()));
            append(System.lineSeparator());
            append(carga.getTipoDeCarga());
            append(System.lineSeparator());
            append(carga.getEmpresa());
            append(System.lineSeparator());
            append(String.valueOf(carga.getNumeroDeRemolques()));
            append(System.lineSeparator());
            append(String.valueOf(carga.getNumeroDeEjes()));
            append(System.lineSeparator());
            append(String.valueOf(carga.getCilindraje()));
            append(System.lineSeparator());
            append(String.valueOf(carga.getNumeroDeCabinas()));
            append(System.lineSeparator());
            append(String.valueOf(carga.getNumeroDeFilas()));
        }
        else if (transporte instanceof TransportePublico){
            //Creacion de objeto de tipo TransportePublico y convertimos a nuestro transporte
            TransportePublico publico = (TransportePublico) transporte;
            append(System.lineSeparator());
            append(publico.getRuta());
            append(System.lineSeparator());
            append(String.valueOf(publico.getCantidadMaximaDePasajeros()));
            append(System.lineSeparator());
            append(publico.getChofer());
            append(System.lineSeparator());
            append(String.valueOf(publico.getNumeroDeUnidad()));
            append(System.lineSeparator());
            append(String.valueOf(publico.getCosto()));
        }
        else if (transporte instanceof TrenLigero){
            //Creacion de objeto de tipo TrenLigero y convertimos a nuestro transporte
            TrenLigero tren = (TrenLigero) transporte;
            append(System.lineSeparator());
            append(String.valueOf(tren.getNumeroDeTren()));
            append(System.lineSeparator());
            append(tren.getSistemaDeManejo());            
            append(System.lineSeparator());
            append(String.valueOf(tren.getNumeroDeVagones()));              
        }
    }
}