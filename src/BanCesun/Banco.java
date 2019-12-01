/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BanCesun;

/**
 *
 * @author david
 */
public class Banco {
    private String Nombre;
    private int NumeroSucursal, NumeroCuenta;
    private static int cuentasAbiertas = 0;
    
    public Banco(String nombre) 
    {
        this.Nombre = nombre;
        cuentasAbiertas++;
        this.NumeroCuenta = cuentasAbiertas;
    }
    
    public static int getNumeroDeCuentas()
    {
        return cuentasAbiertas;
    }
    
    public static void abrirCuenta(String NombreBanco, String Titular, double Saldo, int NumeroCuenta, String Direccion, int Edad, String FechaNacimiento, String Telefono, String Correo, Boolean Estado)
    {
        Banco nuevaCuentaBanco = new Banco(NombreBanco);
        Cuenta nuevaCuenta = new Cuenta(Titular, Saldo, NumeroCuenta, Direccion, Edad, FechaNacimiento, Telefono, Correo, Estado);
        
        Cuenta.cuentas.put(nuevaCuenta, nuevaCuentaBanco);
    }

    public static void cerrarCuenta(String Titular)
    {      
        Cuenta cuentaEncontrada = buscarCuentaPorTitular(Titular);
        
        if(cuentaEncontrada != null) {
            cuentaEncontrada.setEstado(false);
        }
    }

    public static void borrarCuenta(String Titular)
    {
        Cuenta cuentaEncontrada = buscarCuentaPorTitular(Titular);  
        Cuenta cuentaEliminar = null;
        
        for(Cuenta cuenta : Cuenta.cuentas.keySet()){
            if(cuentaEncontrada.getTitular().equals(cuenta.getTitular())) {
                cuentaEliminar = cuenta;
            }  
        }

        Cuenta.cuentas.remove(cuentaEliminar);
    }
    
    //tested method
    public static Cuenta buscarCuentaPorTitular(String Titular)
    {                
        Cuenta cuentaEncontrada = null;
        
        for(Cuenta cuenta : Cuenta.cuentas.keySet()){
            if (cuenta.getTitular().equals(Titular)) {
                cuentaEncontrada = cuenta;
            }
        }
        
        return cuentaEncontrada;
    }
    
    public static void actualizarCuenta(String Titular)
    {
        Cuenta cuentaEncontrada = buscarCuentaPorTitular(Titular);
        cuentaEncontrada.setTitular("");
        cuentaEncontrada.setSaldo(300);
        cuentaEncontrada.setNumeroCuenta(900);
        cuentaEncontrada.setDireccion("");
        cuentaEncontrada.setEdad(40);
        cuentaEncontrada.setFechaNacimiento("");
        cuentaEncontrada.setTelefono("9000");
        cuentaEncontrada.setCorreo("vjdavid621@gmail.com");
        cuentaEncontrada.setEstado(true);
    }
    
    //tested method
    public static void borrarCuentas()
    {
        System.out.println("Las cuentas se borraron con exito");
        Cuenta.cuentas.clear();
    }

    //tested method
    public static void consultarCuentas() 
    {
        //ArrayList<String> listadoCuentas = new ArrayList<String>();

        Cuenta.cuentas.keySet().forEach((cuenta) -> {
            System.out.println(cuenta.getInfo());
            //listadoCuentas.add();
        });

        //return listadoCuentas;
    }
}