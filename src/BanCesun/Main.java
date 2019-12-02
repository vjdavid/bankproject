/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BanCesun;

import java.util.Scanner;

/**
 *
 * @author david
 */
public class Main extends OpcionesMenu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        int opcion = 0;
        Scanner Leer = new Scanner(System.in);
        
        Banco.abrirCuenta("santander", "hugo", 200, 1, "av madero", 22, "23 de diciembre", "1234567", "hugo@gmail.com", true);
        Banco.abrirCuenta("bancomer", "paco", 400, 2, "av camcion", 23, "24 de diciembre", "1234567", "pago@gmail.com", true);
        Banco.abrirCuenta("scotia", "luis", 600, 3, "jeje", 24, "25 de diciembre", "1234567", "luis@gmail.com", true);
        
        do {
          System.out.println("-- Login --");
          System.out.println("Ingrese la opcion que desea ejecutar: ");
          System.out.print("1.. Inciar como Banquero \n2.. Inciar como Cuentahabiente \n3.. Salir del programa..");
          
          opcion = Leer.nextInt();
          switch(opcion){
              case 1:
                  menu();
                  break;
              case 2:
                  menuCuentaAbiente();
                  break;
              case 3:
                  break;
              default:
                  System.out.println("Opcion no dispoinible");
                  break;              
          }
        } while(opcion != 3);     
    }

    public static void menu() {
        int opcion = 0;        
        Scanner Leer = new Scanner(System.in);
                           
        do {
        System.out.println("Menu  Principal: Banquero");
        System.out.println("Elija la opcion que desea ejecutar: ");
        System.out.print("1.. Abrir una Cuenta \n2.. Buscar una cuenta por Titular \n3.. Eliminar una cuenta por Nombre \n4.. Actualizar datos de una Cuenta \n5.. Listar todas las cuentas \n6.. Borrar todas las cuentas \nPresione 7 para ir al siguiente menu \nPresione 8 para salir del programa...");   
            
        opcion = Leer.nextInt();
        
            switch (opcion) {
            case 1:
              CrearCuenta();
              break;
            case 2:
              BuscarCuentaTitular();
              break;
            case 3:
              EliminarCuentaTitular();
              break;
            case 4:
              ActualizarCuenta();
              break;
            case 5:
              Banco.consultarCuentas();            
              break;
            case 6:
              Banco.borrarCuentas();
              System.out.println("Cuentas eliminadas correctamente");
              break;
            case 7:
              subMenu();
              break;
            case 8:
              break;
            default:
              System.out.println("El numero que escribio es incorrecto");
              break;
          }
        } while(opcion != 8);
    }

    public static void subMenu() {
        int opcion = 0;
        Scanner Leer = new Scanner(System.in);        
        
        do {
        System.out.println("SubMenu: Banquero");
        System.out.println("Elija la opcion que desea ejecutar: ");
        System.out.print("1.. Clientes con saldo en 0  \n2.. Clientes con saldo mayor \n3.. Cuentas de la colonia Centro \n4.. Regresar al menu anterior \nPulsa 7 para salir...");                        
        
        opcion = Leer.nextInt();
        
            switch (opcion) {
            case 1:
              Cuenta.clientesEnSaldoCero();
              break;
            case 2:
              Cuenta.ClienteConMayorSaldo();
              break;
            case 3:
              Cuenta.clientesConDireccionCentro();
              break;
            case 4:
              menu();
              break;
            case 7:
              break;
            default:
              System.out.println("El numero que escribio es incorrecto");
              break;
          }
        } while(opcion != 7);
    }

    public static void menuCuentaAbiente() {
      int opcion = 0;
      Scanner Leer = new Scanner(System.in);
      
        do {
            System.out.println("Menu: Cuentabiente");
            System.out.println("Ingrese la opcion que desea ejecutar: ");
            System.out.print("1.. Depositar a una Cuenta \n2.. Retirar Efectivo \n3.. Consultar Saldo \n4.. Realizar transaccion a otra cuenta \nPulsa 7 para salir...");
            
            opcion = Leer.nextInt();
            
            switch (opcion) {
            case 1:
              DepositarCuenta();
              break;
            case 2:
              DisposicionCuenta();
              break;
            case 3:
              ConsultarSaldo();
              break;
            case 4:
              DepositoABeneficiario();
              break;
            case 5:
              Banco.consultarCuentas();            
              break;
            case 7:
              break;
            default:
              System.out.println("El numero que escribio es incorrecto");
              break;
          }
        } while(opcion != 7);
    }    
}