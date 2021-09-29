package mx.udg.cucea.estructurasDeControl;

/**
 *
 * @author murillo
 */
public class EstructurasDeControl {

    // 'psvm': ctrl + space Genera siguiente linea (Netbeans)
    public static void main(String[] args) {
        // System.out.println("Shortcut  Netbeans"); // 'sout' (netbeans)
        //Definicion de 'args' pasando parametros desde el exterior
        System.out.println(args.length);
        for(int i=0; i< args.length; i++){
            System.out.println(args[i]);
        }
        //--IF
            // int numero = 1;
            // System.out.println("ESTRUCTURA IF:");
            // if (numero > 1) {
            //     System.out.println(numero + " es mayor que 1");
            // }else if (numero == 1) {
            //     System.out.println(numero + " es igual que 1");
            // } else {
            //     System.out.println(numero + " es menor que 1");
            // }
        //--WHILE (Puede no ejecutarse, si no se cumple la condicion)
            // int contador = 1000;
            // while (contador >= 0) {
            //     System.out.println(contador);
            //     contador-=1;
            // }
        //--DO-WHILE (Se ejecuta al menos una vez)
            // int contador = 1000;
            // do {
                //     System.out.println(contador);
                //     contador--;
                // } while (contador >= 0);
        //--FOR
            // for( int counter = 100; counter >0; counter--){
            //     System.out.println(counter);
            // }
        //--FOR
            // for( int counter = 1000; counter >0; counter-=2){
            //     System.out.println(counter);
            // }

    }
}
        