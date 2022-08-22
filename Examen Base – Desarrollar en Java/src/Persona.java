import java.util.Random;

public class Persona {

    public int calcularIMC(double peso, double altura, char sexo) {
        double IMC = peso / (altura * altura);
        int ideal = 0;
        if (sexo == 'M') {
            if (IMC < 19) {
                ideal = -1;
            }
            if (IMC > 24) {
                ideal = 1;
            }
        }
        if (sexo == 'H') {
            if (IMC < 20) {
                ideal = -1;
            }
            if (IMC > 25) {
                ideal = 1;
            }
        }
        return ideal;
    }

    public boolean esMayorDeEdad(int edad) {
        boolean result = false;
        if (edad >= 18) {
            result = true;
        }
        return result;
    }

    public boolean comprobarSexo(char sexo) {
        boolean result = false;
        if (sexo == 'M') {
            result = true;
        }
        if (sexo == 'H') {
            result = true;
        }
        return result;
    }

    public String generaNSS () { 
        String NSS = "";
        for (int i = 0; i < 3; i++) {
            NSS = RandomChar() + RandomNumber();            
        }
        return NSS;
    }

    private String RandomChar () {
        Random random = new Random();
        char charRandom = (char) (random.nextInt(26) + 'a');
        String charAString = Character.toString(charRandom);
        return charAString;
    }

    private String RandomNumber () {
        int min = 1;
		int max = 10;
        int intRandom = 0;
		for(int i = min; i <=max; i++) {
			intRandom = (int) (Math.random()*(max-min)) + min;
        }
        String intAString = String.valueOf(intRandom);
        return intAString;
    }

}

