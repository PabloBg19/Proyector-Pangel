**Proyector-Pangel** es una aplicación de simulación de la temporada 2007 de Fórmula 1, desarrollada en **Java** con **Swing** y persistencia **SQL en MySQL** (usando **phpMyAdmin + XAMPP**).  
Permite gestionar y simular equipos y pilotos de F1. 🏁

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
- Almacenamiento y recuperación de resultados con MySQL (phpMyAdmin/XAMPP).
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

1. **Clonar el repositorio**  
   ```bash
   git clone https://github.com/PabloBg19/Proyector-Pangel.git
   ```

2. **Importar en Eclipse**  
   - Ve a `File > Import > Existing Projects into Workspace`.  
   - Selecciona la carpeta del proyecto clonado.

3. **Configurar XAMPP/MySQL**  
   - Inicia Apache y MySQL en XAMPP.  
   - Accede a [phpMyAdmin](http://localhost/phpmyadmin).  
   - Crea una base de datos llamada `formula_1` (o la que se use en el código).  
   - Importa el script SQL proporcionado o crea las tablas según el código.

4. **Ajustar la conexión SQL**
   -Control de Versiones: 
   - Verifica el usuario (`root` por defecto), la contraseña (vacía por defecto) y el nombre de la base de datos en la clase `ConexionMySQL`.
   - Inicia Apache y MySQL en XAMPP.  

---

## Ejecución en Eclipse ▶️

1. Abre el paquete `Dao` en `src`.  
2. Ejecuta `App.java` (`Run As > Java Application`).  
3. Desde la ventana principal, accede a las funciones de gestión y simulación.

---

## Estructura del proyecto 🗂️

- **`DAO/`**: Clases para conexión y operaciones SQL.  
  Contenido:  
  - `AnadirEquipo.java`  
  - `AñadirPilotos.java`  
  - `App.java`  
  - `Fia.java`  
  - `GestionarEquipos.java`  
  - `MenuDeGestion.java`  
  - `NuevaTemporada2007.java`  
  - `VerClasificacion.java`  
  - `VerPilotos.java`  

- **`image/`**: Almacena las imágenes usadas por la aplicación.  

- **`lib/`**: Librerías internas y dependencias.  

- **`Model/`**: Clases de dominio.  
  Contenido:  
  - `CalculoRendimiento.java`  

- **`Util/`**: Biblioteca de utilidades generales.  

- **`Test/`**: Carpeta de pruebas unitarias con JUnit.  
  Contenido:  
  - `NuevaTemporada2007Test.java`  

---
CONTENIDO

## Base de datos 🗄️

- **Diseño del Esquema y BBDD**: Esquema de relación de tablas incluido en captura junto con el archivo .mwb de workbench en la carpeta BBDD. También se incluye la base de datos en formato sql. 
- **Operaciones SQL**: Incluye `SELECT`, `INSERT`, `UPDATE` y `DELETE`.  
- **Trigger**: Implementado en `AnadirPilotos.java` (línea 239).  
  - Función: Crea una tabla en la base de datos para registrar logs de pilotos añadidos.  
- **Función SQL**: Definida directamente en la base de datos.  
  - Función: Calcula el promedio de habilidad de los pilotos.


---

## Entornos de Desarrollo 💻

- **Pruebas unitarias con Junit sin Maven**: Verifican el comportamiento de unidades específicas de código, como métodos o clases, asegurando que funcionen correctamente.
  - `En la carpeta ED se pueden encontrar capturas para probar que se pasaron todas las pruebas.`
  - `Asimismo se incluye la carpeta Test que contiene NuevaTemporada2007Test, la clase para realizar dichas pruebas.`
- **Depuración y Refactorización**: Proceso de reestructurar el código existente para mejorar su legibilidad y eficiencia. Se incluyen capturas dentro de la carpeta ED con ejemplos de cambios.
- **Control de Versiones**: Progreso compartido del proyecto mediante commits frecuentes.
- **Documentación**: JavaDoc generado para clases y métodos públicos.


---

## Programación 🖥️

- **Interfaz Gráfica (GUI):** Implementación de una interfaz de usuario utilizando Swing o JavaFX, que permita una interacción clara y sencilla para el usuario final.
- **Manejo de Eventos:** Programación de los controladores de eventos necesarios para gestionar las acciones del usuario sobre la interfaz.
- **Conexión a Base de Datos:** Establecimiento y gestión de la conexión con el SGBD elegido (Oracle o MySQL) mediante JDBC. 
   - `El driver JDBC correspondiente (ojdbc.jar para Oracle, mysql-connector-java.jar para MySQL) deberá ser gestionado manualmente (descargado y añadido al classpath del proyecto).`
- **Persistencia de Datos:** Implementación de la lógica necesaria para realizar operaciones CRUD sobre la base de datos, ejecutando sentencias SQL o llamadas a procedimientos/funciones almacenadas desde la aplicación Java.
- **Principios de POO:** Aplicación correcta de los principios de la Programación Orientada a Objetos (encapsulamiento, herencia si aplica, polimorfismo).


---
## Notas 📝

- Puedes modificar la parrilla y las estadísticas antes de iniciar la simulación.  
- Si no hay un script SQL, revisa los métodos de acceso a datos para deducir la estructura de la base de datos.  
- El proyecto es ampliable para incluir nuevas temporadas, reglas o funcionalidades.

---

## Licencia 📄

MIT License.

---

## Creadores 🤝

- PabloBg  
- Angel  

---

**¡Disfruta gestionando y simulando la temporada 2007 de F1!** 🚦🏆

---
