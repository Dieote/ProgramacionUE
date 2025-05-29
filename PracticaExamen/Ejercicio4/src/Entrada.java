public class Entrada {

    public static void main(String[] args) {

        String ruta = "src/resources/Ejer3.txt";
        int totalLetras = 0;
        int totalPalabras = 0;

        try (BufferedReader bf = new BufferedReader(new FileReader(ruta))) {
            String linea;
            System.out.println("Contenido del fichero: ");

            while ((linea = bf.readLine()) != null) {
                System.out.println(linea);

                for (char item : linea.toCharArray()) {
                    if (Character.isLetter(item)) {
                        totalLetras++;
                    }
                }

                // Contar palabras (separadas por espacios)
                String[] palabras = linea.trim().split("\\s+");
                if (!linea.trim().isEmpty()) {
                    totalPalabras += palabras.length;
                }
            }
            System.out.println("\nNumero total de letras: " + totalLetras);
            System.out.println("\nNumero total de palabras: " + totalPalabras);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + e.getMessage());
        }

    }
     }