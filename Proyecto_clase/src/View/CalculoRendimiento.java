package View;

import java.util.Random;

public class CalculoRendimiento {
    // Clase para representar un piloto (basada en la tabla piloto)
    static class Piloto {
        int id;
        String nombre;
        int habilidad;
        int consistencia;
        String equipo;

        Piloto(int id, String nombre, int habilidad, int consistencia, String equipo) {
            this.id = id;
            this.nombre = nombre;
            this.habilidad = habilidad;
            this.consistencia = consistencia;
            this.equipo = equipo;
        }
    }

    // Clase para representar un equipo (basada en la tabla equipo)
    static class Equipo {
        int id;
        String nombre;
        int potencia;
        int aerodinamica;
        int fiabilidad;

        Equipo(int id, String nombre, int potencia, int aerodinamica, int fiabilidad) {
            this.id = id;
            this.nombre = nombre;
            this.potencia = potencia;
            this.aerodinamica = aerodinamica;
            this.fiabilidad = fiabilidad;
        }
    }

    // Método para calcular el RendimientoTotal
    public static double calcularRendimientoTotal(Piloto piloto, Equipo equipo) {
        Random random = new Random();

        // Parte 1: Cálculo basado en el piloto (Habilidad y Consistencia)
        // Calcular el rango del factor aleatorio basado en la Consistencia
        double maxRandomHabilidadPorcentaje = 15.0 - (10.0 * (piloto.consistencia / 100.0));
        // Generar un factor aleatorio entre 0 y maxRandomHabilidadPorcentaje (en porcentaje)
        double factorAleatorioHabilidad = random.nextDouble() * maxRandomHabilidadPorcentaje / 100.0;
        // Ajustar la habilidad
        double habilidadAjustada = piloto.habilidad + (piloto.habilidad * factorAleatorioHabilidad);

        // Parte 2: Cálculo basado en el equipo (Potencia, Aerodinamica y Fiabilidad)
        // Suma base de Potencia y Aerodinamica
        double sumaBase = equipo.potencia + equipo.aerodinamica;
        // Calcular el rango del factor aleatorio basado en la Fiabilidad
        double maxRandomEquipoPorcentaje = 20.0 - (15.0 * (equipo.fiabilidad / 100.0));
        // Generar un factor aleatorio entre 0 y maxRandomEquipoPorcentaje (en porcentaje)
        double factorAleatorioEquipo = random.nextDouble() * maxRandomEquipoPorcentaje / 100.0;
        // Ajustar la suma de Potencia y Aerodinamica
        double sumaAjustada = sumaBase + (sumaBase * factorAleatorioEquipo);

        // Calcular el RendimientoTotal
        double rendimientoTotal = habilidadAjustada + sumaAjustada;

        return rendimientoTotal;
    }

    // Método main para probar el cálculo
    public static void main(String[] args) {
        // Crear un piloto de ejemplo (Fernando Alonso)
        Piloto piloto = new Piloto(1, "Fernando Alonso", 95, 92, "McLaren");

        // Crear un equipo de ejemplo (McLaren)
        Equipo equipo = new Equipo(1, "McLaren", 860, 800, 97);

        // Calcular el RendimientoTotal
        double rendimientoTotal = calcularRendimientoTotal(piloto, equipo);

        // Mostrar el resultado
        System.out.printf("Piloto: %s, Equipo: %s, RendimientoTotal: %.2f%n",
                piloto.nombre, equipo.nombre, rendimientoTotal);
    }
}