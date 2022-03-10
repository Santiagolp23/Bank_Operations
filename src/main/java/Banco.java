
import java.util.Scanner;
import java.time.LocalDate;

class DatosBancarios {

    private int numeroCuenta;
    private String nombre;
    private String apellido;
    private String tipoCuenta;
    private float balance;
    private int porcentaje;
    private LocalDate antiguedad;
    private boolean empleado;
    int operacion;
    Scanner scan = new Scanner(System.in);


    public void abrirCuenta() throws Exception {
        System.out.println("Ingrese el número de cuenta: ");
        numeroCuenta = scan.nextInt();
        System.out.println("Ingrese el tipo de cuenta: " + '\n' + "1. Ahorros o 2. Inversión");
        operacion = scan.nextInt();
        
        switch (operacion) {
            case 1: {
                tipoCuenta = "Ahorros";
                break;
            }
            case 2: {
                tipoCuenta = "Inversión";
                break;
            }
            default: {
                System.out.println("Tipo de cuenta inválida, por favor intente de nuevo.");
                System.exit(0);
            }
        }
        System.out.println("Ingrese su primer nombre: ");
        nombre = scan.next();
        System.out.println("Ingrese su apellido paterno: ");
        apellido = scan.next();
        
        
        System.out.println("Es usted empleado del banco?");
        System.out.println("Escriba 1 para SÍ o 2 para NO");
        operacion = 0;
        operacion = scan.nextInt();     
        
        switch (operacion) {

            case 1: {
                empleado = true;
                break;
                }

            case 2:{
                empleado = false;
                break;
        } default: {
            System.out.println("Por favor ingrese una opción válida.");
            System.exit(0);
        }
        } 

        switch (tipoCuenta) {

            case "Ahorros":
                System.out.println("Ingrese el porcentaje de ahorro anual: ");
                porcentaje = scan.nextInt();
                System.out.println("Deposite $1000 de balance inicial: ");
                balance = scan.nextFloat();
                while (balance != 1000) {
                    System.out.println("Por favor deposite exactamente de $1000");
                    balance = 0;
                    balance = scan.nextFloat();
                }
                System.out.println("Cuenta creada con éxito.");
                antiguedad = LocalDate.now();

            case "Inversión":
                System.out.println("Por favor deposite el monto inicial de $25.000 para abrir la cuenta de Inversión");
                balance = scan.nextFloat();
                while (balance != 25000) {
                    System.out.println("Por favor deposite exactamente $25000");
                    balance = 0;
                    balance = scan.nextFloat();
                }
                System.out.println("Cuenta creada con éxito.");
                antiguedad = LocalDate.now();
        }

    }
    
    public void mostrarDatos() {
        if (empleado = false) {
            System.out.println("El nombre del dueño de la cuenta bancaria es:" + nombre + " " + apellido);
            System.out.println("El número de cuenta es:" + numeroCuenta);
            System.out.println("El tipo de cuenta es:" + tipoCuenta);
            System.out.println("Balance:" + balance);
            System.out.println("Su cuenta fué creada en: " + antiguedad);
        } else {
            System.out.println("Hola estimado empleado de nuestro banco.");
            System.out.println("El nombre del dueño de la cuenta bancaria es:" + nombre + " " + apellido);
            System.out.println("El número de cuenta es:" + numeroCuenta);
            System.out.println("El tipo de cuenta es:" + tipoCuenta);
            System.out.println("Balance:" + balance);
            System.out.println("Su cuenta fué creada en: " + antiguedad);
        }
    }

    public void depositar() {
        float ingreso;
        System.out.println("Ingrese la cantidad a depositar: ");
        ingreso = scan.nextFloat();
        balance = balance + ingreso;
    }

    public void retirar() {
        float retiro;
        System.out.println("Ingrese la cantidad a retirar: ");
        switch (tipoCuenta) {

            case "Ahorros": {
                retiro = scan.nextFloat();
                if (balance >= retiro) {
                    if ((balance - retiro) < 500) {
                        System.out.println("En la cuenta deben quedar al menos $500, por favor retire menos dinero.");
                        System.exit(0);
                    } else {
                        balance = balance - retiro;
                        System.out.println("El nuevo balance es: $" + balance);
                    }
                } else {
                    System.out.println("El balance es menor a " + retiro + " , la transacción falló.");
                }
            }

            case "Inversión": {
                retiro = scan.nextFloat();
                if (balance >= retiro) {
                    if ((balance - retiro) < 25000) {
                        System.out.println("En la cuenta deben quedar al menos $2500, por favor retire menos dinero.");
                        System.exit(0);
                    } else {
                        balance = balance - retiro;
                        System.out.println("El nuevo balance es: $" + balance);
                    }
                } else {
                    System.out.println("El balance es menor a " + retiro + " , la transacción falló.");
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
                DatosBancarios estatico = new DatosBancarios
        
        System.out.println("Bienvenido al Banco Taza de Café");
        System.out.println("Por favor cree su cuenta antes de continuar:");
        estatico.abrirCuenta();
        System.out.println("Seleccione la operación que desea realizar: \n" + "1. Hacer depósito de dinero \n" +"2. Hacer retiro de dinero \n" + "3. Mostrar datos de la cuenta");
        operacion = scan.nextInt();
    }

}
