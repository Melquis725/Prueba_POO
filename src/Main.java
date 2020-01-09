import java.util.Scanner;

    public class Main {
        public static void main (String [] args) {

            Scanner teclado= new Scanner(System.in);

            //Introducir datos
            System.out.println("Introducir nombre:");
            String nombre = teclado.next();
            System.out.println("Introducir edad:");
            int edad = teclado.nextInt();
            System.out.println("Introducir sexo:");
            char sexo = teclado.next().charAt(0);
            System.out.println("Introducir peso:");
            double peso = teclado.nextDouble();
            System.out.println("Introduce altura:");
            double altura = teclado.nextDouble();

            //Creacion de objetos
            Persona p1 = new Persona();
            p1.setNombre("Melquis");
            p1.setEdad(19);
            p1.setSexo('H');
            p1.setPeso(65);
            p1.setAltura(1.63);

            System.out.println("Persona1");
            MuestraMensajePeso(p1);
            MuestraMayorDeEdad(p1);
            System.out.println(p1.toString());

            Persona p2 = new Persona(nombre, edad, sexo);
            p2.setPeso(70.21);
            p2.setAltura(1.75);

            System.out.println("Persona2");
            MuestraMensajePeso(p2);
            MuestraMayorDeEdad(p2);
            System.out.println(p2.toString());

            Persona p3 = new Persona(nombre, edad, sexo, peso, altura);
            System.out.println("Persona3");
            MuestraMensajePeso(p3);
            MuestraMayorDeEdad(p3);
            System.out.println(p3.toString());

            Persona cedula = new Persona ();
            System.out.println("Cedula");
            System.out.println( cedula . CedulaConGuiones ( 4861806890001l ));
        }

        public static void MuestraMensajePeso(Persona p) {
            int IMC = p.calcularIMC();
            switch (IMC) {
                case Persona.PESO_IDEAL:
                    System.out.println("El peso de la persona es ideal");
                    break;
                case Persona.INFRAPESO:
                    System.out.println("El peso de la persona esta por debajo de lo ideal");
                    break;
                case Persona.SOBREPESO:
                    System.out.println("El peso de la persona esta por encima de lo ideal");
                    break;
            }
        }

        public static void MuestraMayorDeEdad(Persona p) {

            if (p.esMayorDeEdad()) {
                System.out.println("La persona es mayor de edad");
            } else {
                System.out.println("La persona no es mayor de edad");
            }
        }
}
