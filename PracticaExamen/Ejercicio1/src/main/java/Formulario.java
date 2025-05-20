import Excepciones.*;

import java.util.Scanner;

    public class Formulario {

        private static String nombre = null;
        private static String apellidos = null;
        private static String dni = null;
        private static String email = null;

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("\n--- MENÚ ---");
                System.out.println("1. Rellenar nombre.");
                System.out.println("2. Rellenar apellidos.");
                System.out.println("3. Rellenar DNI.");
                System.out.println("4. Rellenar e-mail.");
                System.out.println("5. Finalizar.");
                System.out.print("Elige una opción: ");
                opcion = input.nextInt();
                input.nextLine();

                try {
                    switch (opcion) {
                        case 1:
                            System.out.print("Introduce el nombre: ");
                            String inputNombre = input.nextLine();
                            // nombre = inputNombre; no sirve porque necesitamos validar
                            rellenarNombre(inputNombre);
                            break;
                        case 2:
                            System.out.print("Introduce los apellidos: ");
                            String inputApellidos = input.nextLine();
                            rellenarApellidos(inputApellidos);
                            break;
                        case 3:
                            System.out.print("Introduce el DNI: ");
                            String inputDni = input.nextLine();
                            rellenarDNI(inputDni);
                            break;
                        case 4:
                            System.out.print("Introduce el email: ");
                            String inputEmail = input.nextLine();
                            rellenarEmail(inputEmail);
                            break;
                        case 5:
                            if (nombre == null || apellidos == null || dni == null || email == null) {
                                System.out.println("Faltan datos por rellenar. No se puede finalizar.");
                                //return; no sirve porque termina el programa
                                opcion = 0;
                            } else {
                                mostrarForm();
                            }
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } while (opcion != 5);

            input.close();
        }

        private static void mostrarForm() {
            System.out.println("\n--- RESUMEN DEL FORMULARIO ---");
            System.out.println("Nombre: " + nombre);
            System.out.println("Apellidos: " + apellidos);
            System.out.println("DNI: " + dni);
            System.out.println("Email: " + email);
            System.out.println("Gracias por completar el formulario.");
        }


    private static void rellenarNombre(String input) throws TipoDatoIncorrectoException {
        for (char caracter : input.toCharArray()) {
            if (!Character.isLetter(caracter) && caracter != ' ') {
                throw new TipoDatoIncorrectoException("El nombre solo puede contener letras.");
            }
        }
        nombre = input;
    }

    private static void rellenarApellidos(String input) throws TipoDatoIncorrectoException {
        for (char caracter : input.toCharArray()) {
            if (!Character.isLetter(caracter) && caracter != ' ') {
                throw new TipoDatoIncorrectoException("Los apellidos solo pueden contener letras.");
            }
        }
        apellidos = input;
    }

    private static void rellenarDNI(String input) throws
            LongitudDNINoValidaException,
            UltimoDigitoNoLetraException,
            NumeracionContieneLetrasException {

        if (input.length() != 9) {
            throw new LongitudDNINoValidaException("El DNI debe tener exactamente 9 caracteres.");
        }

        String numeros = input.substring(0, 8);
        char letra = input.charAt(8);

        for (char caracter : numeros.toCharArray()) {
            if (!Character.isDigit(caracter)) {
                throw new NumeracionContieneLetrasException("Los primeros 8 caracteres del DNI deben ser números.");
            }
        }

        if (!Character.isLetter(letra)) {
            throw new UltimoDigitoNoLetraException("El último carácter del DNI debe ser una letra.");
        }
        dni = input;
    }

    private static void rellenarEmail(String input) throws EmailIncorrectoException {
        if (!input.contains("@") || !input.contains(".")) {
            throw new EmailIncorrectoException("El email debe contener '@' y '.'");
        }
        email = input;
    }
}