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

    public static void clientesEnSaldoCero()
    {
        cuentas.keySet().forEach((cliente) -> {
            if(cliente.getSaldo() == 0 ) {
                System.out.println(cliente.getInfo());
            }
        });
    }

    public static void clientesConDireccionCentro()
    {
        cuentas.keySet().forEach((cliente) -> {
            if ("Centro".equals(cliente.getDireccion())) {
                System.out.println(cliente.getInfo());
            }
        });
    }
    
    public static void ClienteConMayorSaldo()
    {
        Cuenta cuenta = Collections.max(Cuenta.cuentas.keySet(), Comparator.comparing(c -> c.getSaldo()));
        if(cuenta != null){
            System.out.println(cuenta.getInfo());
        }
    }
    
    public String getInfo(){
        String informacionDeCuenta = "Titular de la cuenta: " + getTitular() + "\n" +
        "Saldo: " + getSaldo() + "\n" +
        "Numero de cuenta: " + getNumeroCuenta() + "\n" +
        "Direccion: " + getDireccion() + "\n" +
        "Edad: " + getEdad() + " años de edad \n" + 
        "Fecha de Nacimiento: " + getFechaNacimiento() + "\n" +
        "Telefono: " + getTelefono() + "\n" +
        "Correo Electronico: " + getCorreo() + "\n" +
        "La cuenta esta: " + getEstado() + "\n" + 
        "\n";
        
        return informacionDeCuenta;
    }
    
    public static void consultarSaldo(String Titular) 
    {
        Cuenta cuentaConsultar = Banco.buscarCuentaPorTitular(Titular);

        if (cuentaConsultar != null){
            System.out.println(cuentaConsultar.getSaldo());
        }
    }
    
    public static void depositarSaldo(String Titular, double Cantidad)
    {
        Cuenta cuentaDepositar = Banco.buscarCuentaPorTitular(Titular);

        if (cuentaDepositar != null){
            double saldoDepositar = cuentaDepositar.getSaldo() + Cantidad;

            if (saldoDepositar <= 500000){
                cuentaDepositar.setSaldo(saldoDepositar);
            } else {
                System.out.println("La cuenta ha superado el limite de saldo");
            }
        } else {
            System.out.println("La cuenta no existe");
        }
    }

    public static void disposicionSaldo(String Titular, double Cantidad) 
    {
        Cuenta cuentaRetiro = Banco.buscarCuentaPorTitular(Titular);

        if ((cuentaRetiro != null && Cantidad <= cuentaRetiro.getSaldo()) && (Cantidad >= 100 && Cantidad <= 7500)) {
            System.out.println("Su saldo actual es de: " + cuentaRetiro.getSaldo());
            cuentaRetiro.setSaldo(cuentaRetiro.getSaldo() - Cantidad);
            System.out.println("Su nuevo saldo es de: " + cuentaRetiro.getSaldo());
        } else {
            System.out.println("Operacion no permitida");
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