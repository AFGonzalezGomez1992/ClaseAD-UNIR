import java.util.Scanner;

public class PeticionMenu {

    public void metodoMenu() {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("1. Añadir nuevo coche");
            System.out.println("2. Borrar coche por id");
            System.out.println("3. Consultar coche por id");
            System.out.println("4. Listado de coches");
            System.out.println("5. Salir");
            System.out.println("¿Qué opción quiere realizar?");

            switch (opcion){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Consultar coche por id");
                    System.out.println("Introduce id");
                    int numId = sc.nextInt();
                    consultaId(numId);
                    break;
                case 4:
                    break;

            }

        }while (opcion !=5);

    }
    private void consultaId(int numId){

    }
}
