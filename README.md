# Proyector-Pangel 🏎️

**Proyector-Pangel** es una aplicación de simulación de la temporada 2007 de Fórmula 1, desarrollada en Java con Swing y persistencia SQL en MySQL (phpMyAdmin + XAMPP). Permite a los usuarios moverse por la gestión y simulación de equipos y pilotos de F1. 🏁

---

## Tabla de contenidos 📚

- [Características](#características)
- [Instalación y configuración](#instalación-y-configuración)
- [Ejecución en Eclipse](#ejecución-en-eclipse)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Base de datos](#base-de-datos)
- [Notas](#notas)
- [Licencia](#licencia)

---

## Características ✨

- Simulación completa y visual de la temporada 2007.
- Gestión y edición de equipos y pilotos, con búsqueda y filtrado.
- Resultados almacenados y recuperados con MySQL (phpMyAdmin/XAMPP).
- Interfaz gráfica moderna con Java Swing.
- Opciones para reiniciar temporada, consultar resultados y personalizar la parrilla.

---

## Instalación y configuración 🛠️

### Prerrequisitos

- Java 8 o superior ☕
- Eclipse IDE 🖥️
- XAMPP (MySQL y phpMyAdmin) 🗃️
- Git 🔗

### Pasos

1. **Clona el repositorio**  
   (Usa `git clone https://github.com/PabloBg19/Proyector-Pangel.git`)

2. **Importa en Eclipse**
   - `File > Import > Existing Projects into Workspace`
   - Selecciona la carpeta del proyecto clonado.

3. **Configura XAMPP/MySQL**
   - Inicia Apache y MySQL en XAMPP.
   - Entra a [phpMyAdmin](http://localhost/phpmyadmin).
   - Crea la base de datos `formula_1` (o la que uses en el código).
   - Importa el script SQL o crea las tablas según el código.

4. **Ajusta la conexión SQL**
   - Verifica el usuario (`root`), contraseña (vacía por defecto) y nombre de la base de datos en la clase `ConexionMySQL`.

---

## Ejecución en Eclipse ▶️

- Abre el paquete `View` en `src`.
- Ejecuta `App.java` (`Run As > Java Application`).
- Desde la ventana principal accede a gestión y simulación.

---

## Estructura del proyecto 🗂️

- `View/`: Ventanas y menús Swing.
- `Model/`: Clases de dominio (piloto, equipo, carrera...).
- `DAO/` o clases de conexión: Acceso y operaciones SQL.
- `App.java`: Lanzador y menú principal.

---

## Base de datos 🗄️

Tablas típicas:
- `equipo` (Id, Nombre, Motor, País, Potencia, Aerodinámica, Fiabilidad)
- `piloto` (Id, Nombre, Equipo, Habilidad, Nacionalidad, Edad, Experiencia)
- `carreras` (Id, Nombre, Fecha, indice_actual, ...)
- `resultados` (IdCarrera, IdPiloto, Posicion, Puntos, ...)

---

## Notas 📝

- Puedes realizar cambios en la parrilla y estadísticas antes de la simulación.
- Si no existe un script SQL, revisa los métodos de acceso a datos para deducir la estructura.
- El proyecto puede ampliarse para añadir nuevas temporadas, reglas o funcionalidades.

---

## Licencia 📄

MIT License.

## Creadores 🤝

- PabloBg
- Angel

---

**¡Disfruta gestionando y simulando la temporada 2007 de F1!** 🚦🏆
