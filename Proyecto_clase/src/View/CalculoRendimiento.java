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
            this.habilidad = Math.max(0, habilidad); // Asegurar que Habilidad no sea negativa
            this.consistencia = Math.min(Math.max(0, consistencia), 100); // Consistencia entre 0 y 100
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
            this.potencia = Math.max(0, potencia); // Asegurar que Potencia no sea negativa
            this.aerodinamica = Math.max(0, aerodinamica); // Asegurar que Aerodinamica no sea negativa
            this.fiabilidad = Math.min(Math.max(0, fiabilidad), 100); // Fiabilidad entre 0 y 100
        }
    }

    // Método para calcular el RendimientoTotal
    public static double calcularRendimientoTotal(Piloto piloto, Equipo equipo) {
        Random random = new Random();

        // Parte 1: Cálculo basado en el piloto (Habilidad y Consistencia)
        System.out.println("Piloto: " + piloto.nombre);
        System.out.println("Habilidad inicial: " + piloto.habilidad + ", Consistencia: " + piloto.consistencia);
        // Calcular la penalización basada en la Consistencia (10% a 50%)
        double maxPenalizacionHabilidadPorcentaje = 10.0 + (40.0 * (1.0 - (piloto.consistencia / 100.0)));
        double randomValue = random.nextDouble(); // Valor aleatorio entre 0 y 1
        System.out.println("Valor random (0 a 1): " + randomValue);
        double penalizacionHabilidad = randomValue * maxPenalizacionHabilidadPorcentaje / 100.0;
        System.out.println("Penalización habilidad (calculada): " + (penalizacionHabilidad * 100) + "%");
        // Ajustar la habilidad (restar penalización)
        double habilidadAjustada = piloto.habilidad - (piloto.habilidad * penalizacionHabilidad);
        // Asegurar que no sea negativa
        habilidadAjustada = Math.max(0, habilidadAjustada);
        System.out.println("Habilidad ajustada: " + habilidadAjustada);

        // Parte 2: Cálculo basado en el equipo (Potencia, Aerodinamica y Fiabilidad)
        System.out.println("Equipo: " + equipo.nombre);
        System.out.println("Potencia: " + equipo.potencia + ", Aerodinamica: " + equipo.aerodinamica + ", Fiabilidad: " + equipo.fiabilidad);
        double sumaBase = equipo.potencia + equipo.aerodinamica;
        System.out.println("Suma base (Potencia + Aerodinamica): " + sumaBase);
        
        // Calcular la penalización basada en la Fiabilidad (0% a 20%)
        double maxPenalizacionEquipoPorcentaje = 20.0 * (1.0 - (equipo.fiabilidad / 100.0));
        double penalizacionEquipo = random.nextDouble() * maxPenalizacionEquipoPorcentaje / 100.0;
        System.out.println("Penalización equipo: " + (penalizacionEquipo * 100) + "%");
        // Ajustar la suma (restar penalización)
        double sumaAjustada = sumaBase - (sumaBase * penalizacionEquipo);
        // Asegurar que no sea negativa
        sumaAjustada = Math.max(0, sumaAjustada);
        System.out.println("Suma ajustada: " + sumaAjustada);

        // Calcular el RendimientoTotal
        double rendimientoTotal = habilidadAjustada + sumaAjustada;
        System.out.println("RendimientoTotal: " + rendimientoTotal);
        System.out.println("--------------------------------");

        return rendimientoTotal;
    }

    // Método main para probar el cálculo
    public static void main(String[] args) {
        // Crear un piloto de ejemplo (Fernando Alonso)
        Piloto piloto = new Piloto(1, "Fernando Alonso", 95, 95, "McLaren");

        // Crear un equipo de ejemplo (McLaren)
        Equipo equipo = new Equipo(1, "McLaren", 860, 800, 95); // Fiabilidad a 50 para probar

        // Calcular el RendimientoTotal
        double rendimientoTotal = calcularRendimientoTotal(piloto, equipo);

        // Mostrar el resultado final
        System.out.printf("Piloto: %s, Equipo: %s, RendimientoTotal: %.2f%n",
                piloto.nombre, equipo.nombre, rendimientoTotal);
    }
}