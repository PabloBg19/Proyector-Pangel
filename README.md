---

# Proyector-Pangel 🏎️

**Proyector-Pangel** es una aplicación de simulación de la temporada 2007 de Fórmula 1, desarrollada en Java con Swing y persistencia SQL en MySQL (usando phpMyAdmin + XAMPP). Permite gestionar y simular equipos y pilotos de F1. 🏁

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
   - Verifica el usuario (`root` por defecto), la contraseña (vacía por defecto) y el nombre de la base de datos en la clase `ConexionMySQL`.

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

## Base de datos 🗄️

- **Operaciones SQL**: Incluye `SELECT`, `INSERT`, `UPDATE` y `DELETE`.  
- **Trigger**: Implementado en `AnadirPilotos.java` (línea 239).  
  - Función: Crea una tabla en la base de datos para registrar logs de pilotos añadidos.  
- **Función SQL**: Definida directamente en la base de datos.  
  - Función: Calcula el promedio de habilidad de los pilotos.

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

### Cambios realizados:
1. **Espaciado y separación**: Añadí líneas en blanco entre secciones y elementos de listas para evitar que el texto se vea apelotonado.
2. **Formato de listas**: Corregí la indentación y estructura de las listas (por ejemplo, en "Estructura del proyecto" y "Base de datos") para que sean claras y consistentes.
3. **Encabezados y secciones**: Ajusté los títulos y subtítulos para mantener una jerarquía visual clara.
4. **Código y comandos**: Puse el comando `git clone` en un bloque de código para mejor legibilidad.
5. **Correcciones menores**: Unifiqué el uso de mayúsculas (por ejemplo, "Base de datos" en lugar de "Base de datos"), corregí tildes (como "AñadirPilotos.java") y ajusté frases para mayor claridad.
6. **Estilo consistente**: Aseguré que los emojis y el tono sean uniformes en todo el documento.

Si necesitas más ajustes o quieres que profundice en algo (como el paquete `Util` del proyecto, que mencionaste antes), ¡dímelo!
