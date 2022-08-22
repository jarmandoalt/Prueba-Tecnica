import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
    private JPanel panel;
    private JTextField nombre;
    private JTextField edad;
    private JTextField sexo;
    private JTextField peso;
    private JTextField altura;


    public Ventana() {
        setSize(400,400);
        setTitle("Datos para expediente medico");
        setLocationRelativeTo(null);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes () {
        panel = new JPanel();
        obtenerNombre();
        obtenerEdad();
        obtenerSexo();
        obtenerPeso();
        obtenerAltura();
        colocarBtn();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void obtenerNombre() {
        nombre = new JTextField();
        JLabel tagNombre = new JLabel("Nombre");
        nombre.setBounds(100,20,220,40);
        tagNombre.setBounds(50, 20, 50, 40);
        panel.add(tagNombre);
        panel.add(nombre);
    }

    private void obtenerEdad() {
        edad = new JTextField();
        JLabel tagEdad = new JLabel("Edad");
        edad.setBounds(90,70,90,40);
        tagEdad.setBounds(50, 70, 50, 40);
        panel.add(edad);
        panel.add(tagEdad);
    }

    private void obtenerSexo() {
        sexo = new JTextField();
        JLabel tagSexo = new JLabel("Sexo (H/M)");
        sexo.setBounds(260,70,60,40);
        tagSexo.setBounds(190, 70, 100, 40);
        panel.add(sexo);
        panel.add(tagSexo);
    }

    private void obtenerPeso() {
        peso = new JTextField();
        JLabel tagPeso = new JLabel("Peso (Kg)");
        peso.setBounds(110,120,70,40);
        tagPeso.setBounds(50, 120, 65, 40);
        panel.add(peso);
        panel.add(tagPeso);
    }

    private void obtenerAltura() {
        altura = new JTextField();
        JLabel tagAltura = new JLabel("Altura (m)");
        altura.setBounds(250,120,70,40);
        tagAltura.setBounds(190, 120, 65, 40);
        panel.add(altura);
        panel.add(tagAltura);
    }

    private void colocarBtn() {
        JButton boton = new JButton("Procesar datos");
        boton.setBounds(100, 170, 200, 40);
        panel.add(boton);
        JLabel imc = new JLabel();
        imc.setBounds(80, 220, 240, 40);
        panel.add(imc);
        JLabel mayorDeEdad = new JLabel();
        mayorDeEdad.setBounds(100, 240, 200, 40);
        panel.add(mayorDeEdad);
        JLabel showNombre = new JLabel();
        showNombre.setBounds(100, 260, 200, 40);
        panel.add(showNombre);
        JLabel showEdad = new JLabel();
        showEdad.setBounds(100, 280, 90, 40);
        panel.add(showEdad);
        JLabel showSexo = new JLabel();
        showSexo.setBounds(200, 280, 90, 40);
        panel.add(showSexo);
        JLabel showPeso = new JLabel();
        showPeso.setBounds(100, 300, 90, 40);
        panel.add(showPeso);
        JLabel showAltura = new JLabel();
        showAltura.setBounds(200, 300, 90, 40);
        panel.add(showAltura);

        ActionListener oyente = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Persona pe = new Persona();
                int IMC = pe.calcularIMC(stringAdouble(peso.getText()) ,stringAdouble(altura.getText()), sexo.getText().charAt(0));
                String strIMC = Integer.toString(IMC);
                String comprobacionMayoriaDeEdad = mayorEdad(pe.esMayorDeEdad(Integer.parseInt(edad.getText())));
                imc.setText("Indice de Masa Corporal:     " + convertidor(strIMC));
                mayorDeEdad.setText(comprobacionMayoriaDeEdad);
                showNombre.setText("Nombre: " + nombre.getText());
                showEdad.setText("Edad: " + edad.getText());
                showSexo.setText("Sexo: " + sexo.getText());
                showPeso.setText("Peso: " + peso.getText());
                showAltura.setText("Altura: " + altura.getText());


            }
        };

        boton.addActionListener(oyente);
    }

    private double stringAdouble (String aux) {
        double aDouble = Double.parseDouble(aux);
        return aDouble;
    }

    private String convertidor (String aux) {
        String resultado = "Ideal";

        switch (aux) {
            case "1": 
                resultado = "por Encima";
                break;
                case "-1": 
                resultado = "por Abajo";
                break;
            default:
                break;
        }

        return resultado;
    }

    private String mayorEdad (boolean aux) {
        String resultado = "Usted es mayor de edad";
        if (aux == false) {
            resultado = "Usted es menor de edad";
        }

        return resultado;
    }

}
