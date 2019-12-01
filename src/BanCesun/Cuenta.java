/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BanCesun;
import java.util.HashMap;
import BanCesun.Banco;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author david
 */
public class Cuenta {
    private double Saldo;
    private int NumeroCuenta, Edad;
    private String Titular, Direccion, FechaNacimiento, Telefono, Correo;
    private Boolean Estado;
    public static HashMap<Cuenta, Banco> cuentas = new HashMap<Cuenta, Banco>();
    
    public Cuenta(String Titular, double Saldo, int NumeroCuenta, String Direccion, int Edad, String FechaNacimiento, String Telefono, String Correo, Boolean Estado)
    {
        this.Titular = Titular;
        this.Saldo = Saldo;
        this.NumeroCuenta = NumeroCuenta;
        this.Direccion = Direccion;
        this.Edad = Edad;
        this.FechaNacimiento = FechaNacimiento;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Estado = Estado;
    }

    //Validations
    public boolean esMayorDeEdad()
    {
        return (getEdad()) >= 18;
    }
    
    public boolean montoMinimo()
    {
        return getSaldo() >= 25000 && getSaldo() <= 500000;
    }
    
    public boolean limiteCuenta()
    {
        return getSaldo() <= 500000;
    }
    
    public boolean limiteDisposicion(int Disposicion)
    {
        return Disposicion < getSaldo();  
    }
    
    public boolean restriccionDisposicion(int Disposicion) 
    {
        return Disposicion <= 100 && Disposicion >= 7500;
    }

    //tested method
    public static void clientesEnSaldoCero()
    {
        //ArrayList<String> listadoClientes = new ArrayList<String>();

        System.out.println("Cuentas en Cero");
        cuentas.keySet().forEach((cliente) -> {
            if(cliente.getSaldo() == 0 ) {
                System.out.println(cliente.getInfo());
            }
        });
        System.out.println("Fin de cuentas en cero");
        

        //return listadoClientes;
    }

    //tested method
    public static void clientesConDireccionCentro()
    {
        //ArrayList<String> listadoClientes = new ArrayList<String>();

        System.out.println("Clientes con direccion centro");
        cuentas.keySet().forEach((cliente) -> {
            if ("Centro".equals(cliente.getDireccion())) {
                System.out.println(cliente.getInfo());
                //listadoClientes.add(cliente.toString() + " \n");
            }
        });
        
        System.out.println("Fin clientes con direccion centro");

        //return listadoClientes;
    }
    
    public static void ClienteConMayorSaldo()
    {
        Cuenta cuenta = Collections.max(Cuenta.cuentas.keySet(), Comparator.comparing(c -> c.getSaldo()));
        cuenta.getInfo();
    }
    
    //tested method
    public String getInfo(){
        String informacionDeCuenta = "El titular de la cuenta es: " + getTitular() + "\n" +
        "La cuenta tiene un saldo de " + getSaldo() + "\n" +
        "La cuenta tiene el numero de cuenta " + getNumeroCuenta() + "\n" +
        "La cuenta tiene la direccion de  " + getDireccion() + "\n" +
        "El titular de la cuetna tiene la edad de " + getEdad() + "años de edad \n" + 
        "La titular tiene la fecha de nacimiento " + getFechaNacimiento() + "\n" +
        "El titular tiene el telefono " + getTelefono() + "\n" +
        "El titular tiene el correo " + getCorreo() + "\n" +
        "La cuenta tiene un estado de " + getEstado() + "\n" + 
        "\n";
        
        return informacionDeCuenta;
    }
    
    public static void consultarSaldo(String Titular) 
    {
        Cuenta cuentaConsultar = Banco.buscarCuentaPorTitular(Titular);
        cuentaConsultar.getSaldo();
    }
    
    public static void depositarSaldo(String Titular, double Cantidad)
    {
        Cuenta cuentaDepositar = Banco.buscarCuentaPorTitular(Titular);
        double saldoDeposito = cuentaDepositar.getSaldo() + Cantidad;

        cuentaDepositar.setSaldo(saldoDeposito);
    }

    public static void disposicionSaldo(String Titular, double Cantidad) 
    {
        Cuenta cuentaRetiro = Banco.buscarCuentaPorTitular(Titular);

        if ((cuentaRetiro != null && Cantidad <= cuentaRetiro.getSaldo()) && (Cantidad >= 100 && Cantidad <= 7500)) {
            System.out.println("Su saldo es de: " + cuentaRetiro.getSaldo());

            cuentaRetiro.setSaldo(cuentaRetiro.getSaldo() - Cantidad);
        }
    }

    public static void transaccionDeposito(String Titular, String Beneficiario, double Cantidad)
    {
        disposicionSaldo(Titular, Cantidad);
        depositarSaldo(Beneficiario, Cantidad);
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String Titular) {
        this.Titular = Titular;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public int getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setEstado(Boolean Estado) {
        this.Estado = Estado;
    }

    public Boolean getEstado() {
        return Estado;
    }

    public void setNumeroCuenta(int NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
}