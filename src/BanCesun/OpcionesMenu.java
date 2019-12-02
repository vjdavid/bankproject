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
public class OpcionesMenu {
     
    //Menu Banquero
    public static void CrearCuenta()
    {
      String NombreBanco, Titular, Direccion, FechaNacimiento, Telefono, Correo;
      int NumeroCuenta, Edad;
      double Saldo;
      boolean Estado;

      NombreBanco     = LeerString("Por favor introduzca el nombre del Banco: ");
      Titular         = LeerString("Por favor introduzca el titular de la cuenta: ");

      do {
        Saldo = LeerDouble("Por favor introduzca la cantidad de apertura: ");
      } while (!montoMinimo(Saldo));

      NumeroCuenta    = LeerInt("Por favor introduzca la cuenta: ");
      Direccion       = LeerString("Por favor introduzca la direccion: ");

      do {
        Edad = LeerInt("Por favor introduzca la edad");
      } while (!mayorDeEdad(Edad));

      FechaNacimiento = LeerString("Por favor introduzca la fecha de nacimiento");
      Telefono        = LeerString("Introduzca el numero de telefono: ");
      Correo          = LeerString("Introduzca el correo eletronico: ");
      Estado          = LeerBoolean("Introduzca el estado de la cuenta: ");
                
      Banco.abrirCuenta(NombreBanco, Titular, Saldo, NumeroCuenta, Direccion, Edad, FechaNacimiento, Telefono, Correo, Estado);
    }
    
    public static void BuscarCuentaTitular()
    {
      String CuentaTitular;              
      CuentaTitular = LeerString("Por favor introduzca el titular de la cuenta: ");       
      Cuenta cuenta = Banco.buscarCuentaPorTitular(CuentaTitular);
      
      if (cuenta == null) {
          System.out.println("Cuenta no encontrada");
      } else {
          System.out.print(cuenta.getInfo());
      }
    }
    
    public static void EliminarCuentaTitular()
    {
      String CuentaTitularEliminar;
              
      CuentaTitularEliminar = LeerString("Por favor introduzca el titular de la cuenta: ");
      Banco.borrarCuenta(CuentaTitularEliminar);     
    }
    
    public static void ActualizarCuenta()
    {
      String NombreBanco, Titular, Direccion, FechaNacimiento, Telefono, Correo;
      int NumeroCuenta, Edad;
      double Saldo;
      boolean Estado;
      
      Titular = LeerString("Ingrese el nombre de la cuenta del titular que desea acutalizar: ");                
      Cuenta cuenta = Banco.buscarCuentaPorTitular(Titular);
      
      Titular = LeerString("Ingrese el nuevo titular, de lo contrario presione enter: ");
      if (!Titular.isEmpty()){
          cuenta.setTitular(Titular);
      }
      
      Direccion = LeerString("Ingrese la nueva direccion, de lo contrario presione enter: ");
      if (!Direccion.isEmpty()){
          cuenta.setDireccion(Direccion);
      }
      
      FechaNacimiento = LeerString("Ingrese la nueva fecha de nacimiento, de lo contrario presione enter: ");
      if (!FechaNacimiento.isEmpty()){
          cuenta.setFechaNacimiento(FechaNacimiento);
      }
      
      Telefono = LeerString("Por favor introduzca el nuevo numero de telefono, de lo contrario presione enter: ");
      if (!Telefono.isEmpty()){
          cuenta.setTelefono(Telefono);
      }
      
      Correo = LeerString("Por favor introduzca el nuevo correo, de lo contrario presione enter: ");
      if (!Correo.isEmpty()){
          cuenta.setCorreo(Correo);
      }
    }
    
    //Menu CuentaHabiente
    public static void DepositarCuenta()
    {
      String Titular;
      double Cantidad;
              
      Titular  = LeerString("Ingrese el titular de la cuenta: ");
      Cantidad = LeerDouble("Ingrese la cantidad que desea depositar: ");
        
      Cuenta.depositarSaldo(Titular, Cantidad);
    }
    
    public static void DisposicionCuenta()
    {
      String Titular;
      double Cantidad;
      
      Titular  = LeerString("Ingrese el titular de la cuenta: ");
      Cantidad = LeerDouble("Ingrese la cantidad que desea retirar: ");
      
      Cuenta.disposicionSaldo(Titular, Cantidad);
    }
    
    public static void ConsultarSaldo()
    {
      String Titular;
      
      Titular = LeerString("Ingrese el titular de la cuenta, para consultar su saldo: ");
      Cuenta.consultarSaldo(Titular);
    }
    
    public static void DepositoABeneficiario()
    {
      String Titular, Beneficiario;
      double Cantidad;
      
      Titular      = LeerString("Ingrese el titular de la cuenta, que desea retirar: ");
      Beneficiario = LeerString("Ingrese el beneficiario que desea realizar el deposito: ");
      Cantidad     = LeerDouble("Ingrese la cantidad a depositar: ");
      
      Cuenta.transaccionDeposito(Titular, Beneficiario, Cantidad);
    }

    //Validations
    public static boolean mayorDeEdad(int Edad)
    {
        return Edad >= 18;
    }
    
    public static boolean montoMinimo(double Monto)
    {
        return Monto >= 2500 && Monto <= 160000;
    }
    
    //Metodos para leer tipos de datos
    public static String LeerString(String texto) 
    {
        Scanner Entrada = new Scanner(System.in);
        System.out.println(texto);       
        return Entrada.nextLine();
    }
    
    public static int LeerInt(String texto) 
    {
        Scanner Entrada = new Scanner(System.in);
        System.out.println(texto);       
        return Entrada.nextInt();
    }
    
    public static double LeerDouble(String texto) 
    {
        Scanner Entrada = new Scanner(System.in);
        System.out.println(texto);       
        return Entrada.nextDouble();
    }
    
    public static boolean LeerBoolean(String texto)
    {
        Scanner Entrada = new Scanner(System.in);
        System.out.println(texto);
        return Entrada.nextBoolean();
    }
    
}
