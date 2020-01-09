public class Persona {

    //Atributos
    private String nombre;
    private int edad;
    private char sexo;
    private double peso;
    private double altura;

    //Constructores
    public Persona() {
        this.nombre = "";
        this.edad = 0;
        this.sexo = ('H');
        this.peso = 0;
        this.altura = 0;
    }

    private void sexo(char H) {
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = "";
        this.edad = 0;
        this.sexo = ('H');
        this.peso = 0;
        this.altura = 0;
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.sexo = sexo;
        comprobarSexo();
    }

    //Constantes
    private final static char SEXO_DEF = 'H';
    public static final int INFRAPESO = -1;
    public static final int PESO_IDEAL = 0;
    public static final int SOBREPESO = 1;

    //Calcular el IMC
    public int calcularIMC() {
        final int DebajoPesoIdeal = -1;
        final int PesoIdeal = 0;
        final int SobrePeso = 1;
        double imc;
        imc = peso / (Math.pow(altura, 2));

        if (imc >= 20 && imc <= 25) {
            return PESO_IDEAL;
        } else if (imc < 20) {
            return INFRAPESO;
        } else {
            return SOBREPESO;
        }
    }

    public boolean esMayorDeEdad() {
        boolean mayor = false;
        if (edad >= 18) {
            mayor = true;
        }
        return mayor;
    }

    //Métodos
    private void comprobarSexo() {

        if (sexo != 'H' && sexo != 'M') {
            this.sexo = SEXO_DEF;
        }
    }
    //Devuelve toda la informacion del objeto

    public String toString() {
        String sexo;
        if (this.sexo == 'H') {
            sexo = "hombre";
        } else sexo = "mujer";

        return "Informacion de la persona:\n"
                + nombre + "/" + sexo + "/" + edad + "años/" + "" + peso + " kg/" + altura + " metros";
    }

    /*
     * Declara letras posibles de las cedulas NIcaraguenses
     * */
    private final String letras = "ABCDEFGHJKLMNPQRSTUVWXY";//NO se usa la I, O y la Z
    private final int total_letras = 23;

    /*
     * Este metodo genera la letra correcta de una cedula a partir de un numero de 13 digitos
     * El numero pasado por parametro no lleva guiones y se le agrega una letra l al final para definir el tipo Long
     * Ejemplo 4861806890001
     * */
    public String CedulaConLetra(Long numero) {
        String cedula = "";
        /*Validar si el numero tiene una longitud de 13 caracteres*/
        String numero_texto = String.valueOf(numero);
        if (numero_texto.length() == 13) {
            /*Esta es la regla para generar la cedula nicaraguense
             * El 23 significa la cantidad total de letras posibles
             * Math.floor lo que hace es redondear un numero decimal a numero entero
             * La formula para calcular la letra es
             * letra = numero - ((numero/23) * 23);
             * */
            //Primero divido
            double division = Math.floor((double) numero / total_letras);
            //Luego multiplico
            double multiplicacion = division * total_letras;
            //Luego hago la resta para saber cual de las 23 letras es la que corresponde
            double posicion = numero - multiplicacion;
            /*Crear la cedula uniendo el numero mas la letra: la variable posicion determina cual letra es la que se usa de las 23 disponibles*/
            cedula = numero + "" + letras.charAt((int) posicion);
        } else {
            cedula = "El número no cumple con la longitud adecuada.";
        }
        return cedula;
    }
    //Genera Una Cedula
    /*
     * Mostrar la cedula con guiones
     * */
    public String CedulaConGuiones(long numero) {
        String cedula = "";
        /*Validar si el numero tiene una longitud de 13 caracteres. Conviertiendo el numero a string*/
        String numero_texto = String.valueOf(numero);
        if (numero_texto.length() == 13) {
            /*Llamar al metodo que agrega la letra: el numero de cedula y la letra l al final. La l es para definir un tipo long*/
            cedula = this.CedulaConLetra(numero);
            /*Extraer el sufijo de la posicion 0 a la 3*/
            String sufijo = cedula.substring(0, 3);
            /*Extraer la fecha de la posicion 3 a la 9*/
            String fecha = cedula.substring(3, 9);
            /*Extraer el prefijo y letra de la posicion 9 a la 14*/
            String prefijo = cedula.substring(9, 14);
            cedula = sufijo + "-" + fecha + "-" + prefijo;
        }
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}




