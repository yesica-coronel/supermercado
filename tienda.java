import java.util.Scanner;

public class tienda {
    private static final int MAX_PRODUCTOS = 100;  
    private static String[] nombres = new String[MAX_PRODUCTOS];
    private static int[] cantidades = new int[MAX_PRODUCTOS];
    private static double[] precios = new double[MAX_PRODUCTOS];
    private static int contadorProductos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    actualizarCantidadProducto(scanner);
                    break;
                case 3:
                    mostrarInventario();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("menu");
        System.out.println("1. Agregar producto");
        System.out.println("2. Actualizar cantidad de producto");
        System.out.println("3. Mostrar inventario");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarProducto(Scanner scanner) {
        if (contadorProductos >= MAX_PRODUCTOS) {
            System.out.println("No se pueden agregar más productos. Capacidad máxima alcanzada.");
            return;
        }

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la cantidad del producto: ");
        int cantidad = scanner.nextInt();
        System.out.print("Ingrese el precio por unidad del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();  // Limpiar el buffer

        nombres[contadorProductos] = nombre;
        cantidades[contadorProductos] = cantidad;
        precios[contadorProductos] = precio;
        contadorProductos++;

        System.out.println("Producto agregado correctamente.");
    }

    private static void actualizarCantidadProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String nombre = scanner.nextLine();

        for (int i = 0; i < contadorProductos; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                System.out.print("Ingrese la nueva cantidad del producto: ");
                int nuevaCantidad = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer
                cantidades[i] = nuevaCantidad;
                System.out.println("Cantidad actualizada correctamente.");
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }

    private static void mostrarInventario() {
        System.out.println("\n--- Inventario de Productos ---");
        double valorTotalInventario = 0.0;

        for (int i = 0; i < contadorProductos; i++) {
            double valorProducto = cantidades[i] * precios[i];
            valorTotalInventario += valorProducto;

            System.out.println("Producto: " + nombres[i] + " | Cantidad: " + cantidades[i] + " | Precio por unidad: " + precios[i] + " | Valor Total: " + valorProducto);
        }

        System.out.println("Valor total del inventario: " + valorTotalInventario);
    }
}
