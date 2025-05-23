-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2025 a las 09:26:05
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `formula_1`
--

DELIMITER $$
--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `CalcularPromedioHabilidad` () RETURNS DECIMAL(5,2) DETERMINISTIC BEGIN
    DECLARE promedio DECIMAL(5,2);
    SELECT AVG(Habilidad) INTO promedio FROM piloto;
    RETURN promedio;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carreras`
--

CREATE TABLE `carreras` (
  `Carrera` varchar(50) NOT NULL,
  `Año` int(30) NOT NULL,
  `Posicion` int(30) NOT NULL,
  `indice_actual` int(11) DEFAULT -1,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carreras`
--

INSERT INTO `carreras` (`Carrera`, `Año`, `Posicion`, `indice_actual`, `id`) VALUES
('Albert Park', 2007, 1, 2, 1),
('Brasil', 2007, 10, 2, 10),
('Barein', 2007, 2, 2, 12),
('España', 2007, 3, 2, 13),
('Monaco', 2007, 4, 2, 14),
('Silverstone', 2007, 5, 2, 15),
('Monza', 2007, 6, 2, 16),
('Spa', 2007, 7, 2, 17),
('Suzuka', 2007, 8, 2, 18),
('China', 2007, 9, 2, 19);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `Id` varchar(4) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Motor` varchar(30) NOT NULL,
  `Pais` varchar(40) NOT NULL,
  `Potencia` int(30) NOT NULL,
  `Aerodinamica` int(30) NOT NULL,
  `Fiabilidad` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`Id`, `Nombre`, `Motor`, `Pais`, `Potencia`, `Aerodinamica`, `Fiabilidad`) VALUES
('E1', 'Mclaren', 'Mercedes', 'Reino Unido', 856, 743, 85),
('E10', 'Super Aguri', 'Honda', 'Japon', 841, 721, 75),
('E11', 'Spyker', 'Ferrari', 'Holanda', 840, 720, 74),
('E2', 'Ferrari', 'Ferrari', 'Italia', 864, 740, 84),
('E3', 'BMW Sauber', 'BMW', 'Alemania', 856, 735, 82),
('E4', 'Renault', 'Renault', 'Francia', 852, 734, 83),
('E5', 'Williams', 'Toyota', 'Reino Unido', 853, 728, 78),
('E6', 'Red Bull', 'Renault', 'Francia', 848, 730, 76),
('E7', 'Toyota', 'Toyota', 'Japon', 853, 725, 76),
('E8', 'Toro Rosso', 'Ferrari', 'Italia', 845, 723, 81),
('E9', 'Honda', 'Honda', 'Japon', 841, 722, 76);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `piloto`
--

CREATE TABLE `piloto` (
  `Id` varchar(11) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Edad` int(11) NOT NULL,
  `Nacionalidad` varchar(40) NOT NULL,
  `Temporada` int(30) NOT NULL,
  `Equipo` varchar(40) NOT NULL,
  `Habilidad` int(11) NOT NULL,
  `Consistencia` int(3) NOT NULL,
  `Puntos` int(11) NOT NULL,
  `Campeonato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `piloto`
--

INSERT INTO `piloto` (`Id`, `Nombre`, `Edad`, `Nacionalidad`, `Temporada`, `Equipo`, `Habilidad`, `Consistencia`, `Puntos`, `Campeonato`) VALUES
('P1', 'Fernando Alonso', 25, 'España', 2007, 'Mclaren', 95, 91, 18, 2),
('P10', 'Alexander Wurz', 33, 'Reino Unido', 2007, 'Williams', 82, 78, 0, 0),
('P11', 'Rubens Barrichello', 34, 'Brasil', 2007, 'Honda', 81, 81, 0, 0),
('P12', 'Jenson Button', 27, 'Reino Unido', 2007, 'Honda', 83, 82, 0, 0),
('P13', 'Sebastian Vettel', 19, 'Alemania', 2007, 'Red Bull', 88, 85, 1, 0),
('P14', 'Mark Webber', 30, 'Australia', 2007, 'Red Bull', 82, 78, 0, 0),
('P15', 'Ralf Schumacher', 31, 'Alemania', 2007, 'Toyota', 81, 75, 0, 0),
('P16', 'Jarno Trulli', 32, 'Italia', 2007, 'Toyota', 82, 77, 0, 0),
('P17', 'Anthony Davidson', 27, 'Reino Unido', 2007, 'Super Aguri', 79, 74, 0, 0),
('P18', 'Takuma Sato', 30, 'Japon', 2007, 'Super Aguri', 82, 75, 0, 0),
('P19', 'Vitantonio Liuzzi', 25, 'Italia', 2007, 'Toro Rosso', 81, 73, 0, 0),
('P2', 'Lewis Hamilton', 22, 'Reino Unido', 2007, 'Mclaren', 94, 93, 13, 0),
('P20', 'Scott Speed', 24, 'Estados Unidos', 2007, 'Toro Rosso', 79, 72, 0, 0),
('P21', 'Adrian Sutil', 24, 'Uruguay', 2007, 'Spyker', 78, 76, 0, 0),
('P22', 'Christijan Albers', 28, 'Holanda', 2007, 'Spyker', 77, 75, 0, 0),
('P3', 'Kimi Raikkonen', 28, 'Finlandia', 2007, 'Ferrari', 93, 93, 15, 0),
('P4', 'Felipe Massa', 25, 'Brasil', 2007, 'Ferrari', 92, 90, 12, 0),
('P5', 'Giancarlo Fisichella', 33, 'Italia', 2007, 'Renault', 83, 81, 1, 0),
('P6', 'Heikki Kovalainen', 25, 'Finlandia', 2007, 'Renault', 85, 83, 4, 0),
('P7', 'Nick Heidfeld', 29, 'Polonia', 2007, 'BMW Sauber', 88, 88, 7, 0),
('P8', 'Robert Kubica', 22, 'Polonia', 2007, 'BMW Sauber', 87, 86, 7, 0),
('P9', 'Nico Rosberg', 21, 'Alemania', 2007, 'Williams', 84, 80, 0, 0);

--
-- Disparadores `piloto`
--
DELIMITER $$
CREATE TRIGGER `after_piloto_insert` AFTER INSERT ON `piloto` FOR EACH ROW BEGIN     INSERT INTO piloto_log (        piloto_id, nombre, edad, nacionalidad, temporada,         equipo, habilidad, consistencia, puntos, campeonato    )     VALUES (        NEW.Id, NEW.Nombre, NEW.Edad, NEW.Nacionalidad, NEW.Temporada,         NEW.Equipo, NEW.Habilidad, NEW.Consistencia, NEW.Puntos, NEW.Campeonato    );END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `piloto_log`
--

CREATE TABLE `piloto_log` (
  `log_id` int(11) NOT NULL,
  `piloto_id` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `nacionalidad` varchar(255) DEFAULT NULL,
  `temporada` varchar(255) DEFAULT NULL,
  `equipo` varchar(255) DEFAULT NULL,
  `habilidad` int(11) DEFAULT NULL,
  `consistencia` int(11) DEFAULT NULL,
  `puntos` int(11) DEFAULT NULL,
  `campeonato` varchar(255) DEFAULT NULL,
  `log_timestamp` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `piloto_log`
--

INSERT INTO `piloto_log` (`log_id`, `piloto_id`, `nombre`, `edad`, `nacionalidad`, `temporada`, `equipo`, `habilidad`, `consistencia`, `puntos`, `campeonato`, `log_timestamp`) VALUES
(1, 'P21', 'Adrian Sutil', 24, 'Uruguay', '2007', 'Spyker', 78, 76, 0, '0', '2025-05-21 09:30:01'),
(2, 'P20', 'Scott Speed', 24, 'Estados Unidos', '2007', 'Toro Rosso', 79, 72, 0, '0', '2025-05-21 09:30:01'),
(3, 'P22', 'Christijan Albers', 28, 'Holanda', '2007', 'Spyker', 77, 75, 0, '0', '2025-05-21 09:30:01'),
(4, 'P1', 'Fernando Alonso', 25, 'España', '2007', 'Mclaren', 95, 91, 79, '2', '2025-05-21 09:30:01'),
(5, 'P2', 'Lewis Hamilton', 22, 'Reino Unido', '2007', 'Mclaren', 94, 93, 70, '0', '2025-05-21 09:30:01'),
(6, 'P3', 'Michael Schumacher', 37, 'Alemania', '2007', 'Ferrari', 95, 93, 102, '7', '2025-05-21 09:30:01'),
(7, 'P4', 'Felipe Massa', 25, 'Brasil', '2007', 'Ferrari', 92, 90, 68, '0', '2025-05-21 09:30:01'),
(8, 'P5', 'Giancarlo Fisichella', 33, 'Italia', '2007', 'Renault', 83, 81, 3, '0', '2025-05-21 09:30:01'),
(9, 'P6', 'Heikki Kovalainen', 25, 'Finlandia', '2007', 'Renault', 85, 83, 22, '0', '2025-05-21 09:30:01'),
(10, 'P7', 'Nick Heidfeld', 29, 'Polonia', '2007', 'BMW Sauber', 88, 88, 37, '0', '2025-05-21 09:30:01'),
(11, 'P8', 'Robert Kubica', 22, 'Polonia', '2007', 'BMW Sauber', 87, 86, 39, '0', '2025-05-21 09:30:01'),
(12, 'P9', 'Nico Rosberg', 21, 'Alemania', '2007', 'Williams', 84, 80, 0, '0', '2025-05-21 09:30:01'),
(13, 'P96', 'Rubens Barrichello', 37, 'Brasil', '2007', 'Ferrari', 87, 82, 0, '0', '2025-05-21 09:30:01'),
(14, 'P98', 'Michael Schumacher', 37, 'Alemania', '2007', 'Ferrari', 95, 93, 0, '7', '2025-05-21 09:30:01'),
(15, 'P10', 'Alexander Wurz', 33, 'Reino Unido', '2007', 'Williams', 82, 78, 0, '0', '2025-05-21 09:30:01'),
(16, 'P97', 'Juan Pablo Montoya', 36, 'Colombia', '2007', 'BMW Sauber', 91, 84, 0, '0', '2025-05-21 09:30:01'),
(17, 'P12', 'Jenson Button', 27, 'Reino Unido', '2007', 'Honda', 83, 82, 0, '0', '2025-05-21 09:30:01'),
(18, 'P11', 'Rubens Barrichello', 34, 'Brasil', '2007', 'Honda', 81, 81, 0, '0', '2025-05-21 09:30:01'),
(19, 'P14', 'Mark Webber', 30, 'Australia', '2007', 'Red Bull', 82, 78, 0, '0', '2025-05-21 09:30:01'),
(20, 'P13', 'Sebastian Vettel', 19, 'Alemania', '2007', 'Red Bull', 88, 85, 9, '0', '2025-05-21 09:30:01'),
(21, 'P16', 'Jarno Trulli', 32, 'Italia', '2007', 'Toyota', 82, 77, 0, '0', '2025-05-21 09:30:01'),
(22, 'P15', 'Ralf Schumacher', 31, 'Alemania', '2007', 'Toyota', 81, 75, 0, '0', '2025-05-21 09:30:01'),
(23, 'P18', 'Takuma Sato', 30, 'Japon', '2007', 'Super Aguri', 82, 75, 0, '0', '2025-05-21 09:30:01'),
(24, 'P17', 'Anthony Davidson', 27, 'Reino Unido', '2007', 'Super Aguri', 79, 74, 0, '0', '2025-05-21 09:30:01'),
(25, 'P19', 'Vitantonio Liuzzi', 25, 'Italia', '2007', 'Toro Rosso', 81, 73, 0, '0', '2025-05-21 09:30:01'),
(26, 'P21', 'Adrian Sutil', 24, 'Uruguay', '2007', 'Spyker', 78, 76, 0, '0', '2025-05-21 09:30:16'),
(27, 'P20', 'Scott Speed', 24, 'Estados Unidos', '2007', 'Toro Rosso', 79, 72, 0, '0', '2025-05-21 09:30:16'),
(28, 'P22', 'Christijan Albers', 28, 'Holanda', '2007', 'Spyker', 77, 75, 0, '0', '2025-05-21 09:30:16'),
(29, 'P1', 'Fernando Alonso', 25, 'España', '2007', 'Mclaren', 95, 91, 79, '2', '2025-05-21 09:30:16'),
(30, 'P2', 'Lewis Hamilton', 22, 'Reino Unido', '2007', 'Mclaren', 94, 93, 70, '0', '2025-05-21 09:30:16'),
(31, 'P3', 'Michael Schumacher', 37, 'Alemania', '2007', 'Ferrari', 95, 93, 102, '7', '2025-05-21 09:30:16'),
(32, 'P4', 'Felipe Massa', 25, 'Brasil', '2007', 'Ferrari', 92, 90, 68, '0', '2025-05-21 09:30:16'),
(33, 'P5', 'Giancarlo Fisichella', 33, 'Italia', '2007', 'Renault', 83, 81, 3, '0', '2025-05-21 09:30:16'),
(34, 'P6', 'Heikki Kovalainen', 25, 'Finlandia', '2007', 'Renault', 85, 83, 22, '0', '2025-05-21 09:30:16'),
(35, 'P7', 'Nick Heidfeld', 29, 'Polonia', '2007', 'BMW Sauber', 88, 88, 37, '0', '2025-05-21 09:30:16'),
(36, 'P8', 'Robert Kubica', 22, 'Polonia', '2007', 'BMW Sauber', 87, 86, 39, '0', '2025-05-21 09:30:16'),
(37, 'P9', 'Nico Rosberg', 21, 'Alemania', '2007', 'Williams', 84, 80, 0, '0', '2025-05-21 09:30:16'),
(38, 'P96', 'Rubens Barrichello', 37, 'Brasil', '2007', 'Ferrari', 87, 82, 0, '0', '2025-05-21 09:30:16'),
(39, 'P98', 'Michael Schumacher', 37, 'Alemania', '2007', 'Ferrari', 95, 93, 0, '7', '2025-05-21 09:30:16'),
(40, 'P10', 'Alexander Wurz', 33, 'Reino Unido', '2007', 'Williams', 82, 78, 0, '0', '2025-05-21 09:30:16'),
(41, 'P97', 'Juan Pablo Montoya', 36, 'Colombia', '2007', 'BMW Sauber', 91, 84, 0, '0', '2025-05-21 09:30:16'),
(42, 'P12', 'Jenson Button', 27, 'Reino Unido', '2007', 'Honda', 83, 82, 0, '0', '2025-05-21 09:30:16'),
(43, 'P11', 'Rubens Barrichello', 34, 'Brasil', '2007', 'Honda', 81, 81, 0, '0', '2025-05-21 09:30:16'),
(44, 'P14', 'Mark Webber', 30, 'Australia', '2007', 'Red Bull', 82, 78, 0, '0', '2025-05-21 09:30:16'),
(45, 'P13', 'Sebastian Vettel', 19, 'Alemania', '2007', 'Red Bull', 88, 85, 9, '0', '2025-05-21 09:30:16'),
(46, 'P16', 'Jarno Trulli', 32, 'Italia', '2007', 'Toyota', 82, 77, 0, '0', '2025-05-21 09:30:16'),
(47, 'P15', 'Ralf Schumacher', 31, 'Alemania', '2007', 'Toyota', 81, 75, 0, '0', '2025-05-21 09:30:16'),
(48, 'P18', 'Takuma Sato', 30, 'Japon', '2007', 'Super Aguri', 82, 75, 0, '0', '2025-05-21 09:30:16'),
(49, 'P17', 'Anthony Davidson', 27, 'Reino Unido', '2007', 'Super Aguri', 79, 74, 0, '0', '2025-05-21 09:30:16'),
(50, 'P19', 'Vitantonio Liuzzi', 25, 'Italia', '2007', 'Toro Rosso', 81, 73, 0, '0', '2025-05-21 09:30:16'),
(51, 'P21', 'Adrian Sutil', 24, 'Uruguay', '2007', 'Spyker', 78, 76, 0, '0', '2025-05-21 12:29:04'),
(52, 'P20', 'Scott Speed', 24, 'Estados Unidos', '2007', 'Toro Rosso', 79, 72, 0, '0', '2025-05-21 12:29:04'),
(53, 'P22', 'Christijan Albers', 28, 'Holanda', '2007', 'Spyker', 77, 75, 0, '0', '2025-05-21 12:29:04'),
(54, 'P1', 'Fernando Alonso', 25, 'España', '2007', 'Mclaren', 95, 91, 79, '2', '2025-05-21 12:29:04'),
(55, 'P2', 'Lewis Hamilton', 22, 'Reino Unido', '2007', 'Mclaren', 94, 93, 70, '0', '2025-05-21 12:29:04'),
(56, 'P3', 'Michael Schumacher', 37, 'Alemania', '2007', 'Ferrari', 95, 93, 102, '7', '2025-05-21 12:29:04'),
(57, 'P4', 'Felipe Massa', 25, 'Brasil', '2007', 'Ferrari', 92, 90, 68, '0', '2025-05-21 12:29:04'),
(58, 'P5', 'Giancarlo Fisichella', 33, 'Italia', '2007', 'Renault', 83, 81, 3, '0', '2025-05-21 12:29:04'),
(59, 'P6', 'Heikki Kovalainen', 25, 'Finlandia', '2007', 'Renault', 85, 83, 22, '0', '2025-05-21 12:29:04'),
(60, 'P7', 'Nick Heidfeld', 29, 'Polonia', '2007', 'BMW Sauber', 88, 88, 37, '0', '2025-05-21 12:29:04'),
(61, 'P8', 'Robert Kubica', 22, 'Polonia', '2007', 'BMW Sauber', 87, 86, 39, '0', '2025-05-21 12:29:04'),
(62, 'P9', 'Nico Rosberg', 21, 'Alemania', '2007', 'Williams', 84, 80, 0, '0', '2025-05-21 12:29:04'),
(63, 'P96', 'Rubens Barrichello', 37, 'Brasil', '2007', 'Ferrari', 87, 82, 0, '0', '2025-05-21 12:29:04'),
(64, 'P98', 'Michael Schumacher', 37, 'Alemania', '2007', 'Ferrari', 95, 93, 0, '7', '2025-05-21 12:29:04'),
(65, 'P10', 'Alexander Wurz', 33, 'Reino Unido', '2007', 'Williams', 82, 78, 0, '0', '2025-05-21 12:29:04'),
(66, 'P97', 'Juan Pablo Montoya', 36, 'Colombia', '2007', 'BMW Sauber', 91, 84, 0, '0', '2025-05-21 12:29:04'),
(67, 'P12', 'Jenson Button', 27, 'Reino Unido', '2007', 'Honda', 83, 82, 0, '0', '2025-05-21 12:29:04'),
(68, 'P11', 'Rubens Barrichello', 34, 'Brasil', '2007', 'Honda', 81, 81, 0, '0', '2025-05-21 12:29:04'),
(69, 'P14', 'Mark Webber', 30, 'Australia', '2007', 'Red Bull', 82, 78, 0, '0', '2025-05-21 12:29:04'),
(70, 'P13', 'Sebastian Vettel', 19, 'Alemania', '2007', 'Red Bull', 88, 85, 9, '0', '2025-05-21 12:29:04'),
(71, 'P16', 'Jarno Trulli', 32, 'Italia', '2007', 'Toyota', 82, 77, 0, '0', '2025-05-21 12:29:04'),
(72, 'P15', 'Ralf Schumacher', 31, 'Alemania', '2007', 'Toyota', 81, 75, 0, '0', '2025-05-21 12:29:04'),
(73, 'P18', 'Takuma Sato', 30, 'Japon', '2007', 'Super Aguri', 82, 75, 0, '0', '2025-05-21 12:29:04'),
(74, 'P17', 'Anthony Davidson', 27, 'Reino Unido', '2007', 'Super Aguri', 79, 74, 0, '0', '2025-05-21 12:29:04'),
(75, 'P19', 'Vitantonio Liuzzi', 25, 'Italia', '2007', 'Toro Rosso', 81, 73, 0, '0', '2025-05-21 12:29:04'),
(76, 'P21', 'Adrian Sutil', 24, 'Uruguay', '2007', 'Spyker', 78, 76, 0, '0', '2025-05-21 12:42:20'),
(77, 'P20', 'Scott Speed', 24, 'Estados Unidos', '2007', 'Toro Rosso', 79, 72, 0, '0', '2025-05-21 12:42:20'),
(78, 'P22', 'Christijan Albers', 28, 'Holanda', '2007', 'Spyker', 77, 75, 0, '0', '2025-05-21 12:42:20'),
(79, 'P1', 'Fernando Alonso', 25, 'España', '2007', 'Mclaren', 95, 91, 79, '2', '2025-05-21 12:42:20'),
(80, 'P2', 'Lewis Hamilton', 22, 'Reino Unido', '2007', 'Mclaren', 94, 93, 70, '0', '2025-05-21 12:42:20'),
(81, 'P3', 'Michael Schumacher', 37, 'Alemania', '2007', 'Ferrari', 95, 93, 102, '7', '2025-05-21 12:42:20'),
(82, 'P4', 'Felipe Massa', 25, 'Brasil', '2007', 'Ferrari', 92, 90, 68, '0', '2025-05-21 12:42:20'),
(83, 'P5', 'Giancarlo Fisichella', 33, 'Italia', '2007', 'Renault', 83, 81, 3, '0', '2025-05-21 12:42:20'),
(84, 'P6', 'Heikki Kovalainen', 25, 'Finlandia', '2007', 'Renault', 85, 83, 22, '0', '2025-05-21 12:42:20'),
(85, 'P7', 'Nick Heidfeld', 29, 'Polonia', '2007', 'BMW Sauber', 88, 88, 37, '0', '2025-05-21 12:42:20'),
(86, 'P8', 'Robert Kubica', 22, 'Polonia', '2007', 'BMW Sauber', 87, 86, 39, '0', '2025-05-21 12:42:20'),
(87, 'P9', 'Nico Rosberg', 21, 'Alemania', '2007', 'Williams', 84, 80, 0, '0', '2025-05-21 12:42:20'),
(88, 'P96', 'Rubens Barrichello', 37, 'Brasil', '2007', 'Ferrari', 87, 82, 0, '0', '2025-05-21 12:42:20'),
(89, 'P98', 'Michael Schumacher', 37, 'Alemania', '2007', 'Ferrari', 95, 93, 0, '7', '2025-05-21 12:42:20'),
(90, 'P10', 'Alexander Wurz', 33, 'Reino Unido', '2007', 'Williams', 82, 78, 0, '0', '2025-05-21 12:42:20'),
(91, 'P97', 'Juan Pablo Montoya', 36, 'Colombia', '2007', 'BMW Sauber', 91, 84, 0, '0', '2025-05-21 12:42:20'),
(92, 'P12', 'Jenson Button', 27, 'Reino Unido', '2007', 'Honda', 83, 82, 0, '0', '2025-05-21 12:42:20'),
(93, 'P11', 'Rubens Barrichello', 34, 'Brasil', '2007', 'Honda', 81, 81, 0, '0', '2025-05-21 12:42:20'),
(94, 'P14', 'Mark Webber', 30, 'Australia', '2007', 'Red Bull', 82, 78, 0, '0', '2025-05-21 12:42:20'),
(95, 'P13', 'Sebastian Vettel', 19, 'Alemania', '2007', 'Red Bull', 88, 85, 9, '0', '2025-05-21 12:42:20'),
(96, 'P16', 'Jarno Trulli', 32, 'Italia', '2007', 'Toyota', 82, 77, 0, '0', '2025-05-21 12:42:20'),
(97, 'P15', 'Ralf Schumacher', 31, 'Alemania', '2007', 'Toyota', 81, 75, 0, '0', '2025-05-21 12:42:20'),
(98, 'P18', 'Takuma Sato', 30, 'Japon', '2007', 'Super Aguri', 82, 75, 0, '0', '2025-05-21 12:42:20'),
(99, 'P17', 'Anthony Davidson', 27, 'Reino Unido', '2007', 'Super Aguri', 79, 74, 0, '0', '2025-05-21 12:42:20'),
(100, 'P19', 'Vitantonio Liuzzi', 25, 'Italia', '2007', 'Toro Rosso', 81, 73, 0, '0', '2025-05-21 12:42:20'),
(101, 'P1', 'Fernando Alonso', 25, 'España', '2007', 'Mclaren', 95, 91, 0, '2', '2025-05-22 09:03:00'),
(102, 'P2', 'Lewis Hamilton', 22, 'Reino Unido', '2007', 'Mclaren', 94, 93, 0, '0', '2025-05-22 09:03:00'),
(103, 'P3', 'Kimi Raikkonen', 28, 'Finlandia', '2007', 'Ferrari', 92, 90, 0, '7', '2025-05-22 09:03:00'),
(104, 'P4', 'Felipe Massa', 25, 'Brasil', '2007', 'Ferrari', 92, 90, 0, '0', '2025-05-22 09:03:00'),
(105, 'P5', 'Giancarlo Fisichella', 33, 'Italia', '2007', 'Renault', 83, 81, 0, '0', '2025-05-22 09:03:00'),
(106, 'P6', 'Heikki Kovalainen', 25, 'Finlandia', '2007', 'Renault', 85, 83, 0, '0', '2025-05-22 09:03:00'),
(107, 'P7', 'Nick Heidfeld', 29, 'Polonia', '2007', 'BMW Sauber', 88, 88, 0, '0', '2025-05-22 09:03:00'),
(108, 'P8', 'Robert Kubica', 22, 'Polonia', '2007', 'BMW Sauber', 87, 86, 0, '0', '2025-05-22 09:03:00'),
(109, 'P9', 'Nico Rosberg', 21, 'Alemania', '2007', 'Williams', 84, 80, 0, '0', '2025-05-22 09:03:00'),
(110, 'P21', 'Adrian Sutil', 24, 'Uruguay', '2007', 'Spyker', 78, 76, 0, '0', '2025-05-22 09:03:00'),
(111, 'P10', 'Alexander Wurz', 33, 'Reino Unido', '2007', 'Williams', 82, 78, 0, '0', '2025-05-22 09:03:00'),
(112, 'P20', 'Scott Speed', 24, 'Estados Unidos', '2007', 'Toro Rosso', 79, 72, 0, '0', '2025-05-22 09:03:00'),
(113, 'P12', 'Jenson Button', 27, 'Reino Unido', '2007', 'Honda', 83, 82, 0, '0', '2025-05-22 09:03:00'),
(114, 'P22', 'Christijan Albers', 28, 'Holanda', '2007', 'Spyker', 77, 75, 0, '0', '2025-05-22 09:03:00'),
(115, 'P11', 'Rubens Barrichello', 34, 'Brasil', '2007', 'Honda', 81, 81, 0, '0', '2025-05-22 09:03:00'),
(116, 'P14', 'Mark Webber', 30, 'Australia', '2007', 'Red Bull', 82, 78, 0, '0', '2025-05-22 09:03:00'),
(117, 'P13', 'Sebastian Vettel', 19, 'Alemania', '2007', 'Red Bull', 88, 85, 0, '0', '2025-05-22 09:03:00'),
(118, 'P16', 'Jarno Trulli', 32, 'Italia', '2007', 'Toyota', 82, 77, 0, '0', '2025-05-22 09:03:00'),
(119, 'P15', 'Ralf Schumacher', 31, 'Alemania', '2007', 'Toyota', 81, 75, 0, '0', '2025-05-22 09:03:00'),
(120, 'P18', 'Takuma Sato', 30, 'Japon', '2007', 'Super Aguri', 82, 75, 0, '0', '2025-05-22 09:03:00'),
(121, 'P17', 'Anthony Davidson', 27, 'Reino Unido', '2007', 'Super Aguri', 79, 74, 0, '0', '2025-05-22 09:03:00'),
(122, 'P19', 'Vitantonio Liuzzi', 25, 'Italia', '2007', 'Toro Rosso', 81, 73, 0, '0', '2025-05-22 09:03:00'),
(123, 'P95', 'Javier', 20, 'España', '2007', 'Ferrari', 87, 80, 0, '0', '2025-05-22 10:54:26'),
(124, 'P1', 'Fernando Alonso', 25, 'España', '2007', 'Mclaren', 95, 91, 0, '2', '2025-05-22 12:53:33'),
(125, 'P2', 'Lewis Hamilton', 22, 'Reino Unido', '2007', 'Mclaren', 94, 93, 0, '0', '2025-05-22 12:53:33'),
(126, 'P3', 'Kimi Raikkonen', 28, 'Finlandia', '2007', 'Ferrari', 93, 93, 0, '0', '2025-05-22 12:53:33'),
(127, 'P4', 'Felipe Massa', 25, 'Brasil', '2007', 'Ferrari', 92, 90, 0, '0', '2025-05-22 12:53:33'),
(128, 'P5', 'Giancarlo Fisichella', 33, 'Italia', '2007', 'Renault', 83, 81, 0, '0', '2025-05-22 12:53:33'),
(129, 'P6', 'Heikki Kovalainen', 25, 'Finlandia', '2007', 'Renault', 85, 83, 0, '0', '2025-05-22 12:53:33'),
(130, 'P7', 'Nick Heidfeld', 29, 'Polonia', '2007', 'BMW Sauber', 88, 88, 0, '0', '2025-05-22 12:53:33'),
(131, 'P8', 'Robert Kubica', 22, 'Polonia', '2007', 'BMW Sauber', 87, 86, 0, '0', '2025-05-22 12:53:33'),
(132, 'P9', 'Nico Rosberg', 21, 'Alemania', '2007', 'Williams', 84, 80, 0, '0', '2025-05-22 12:53:33'),
(133, 'P21', 'Adrian Sutil', 24, 'Uruguay', '2007', 'Spyker', 78, 76, 0, '0', '2025-05-22 12:53:33'),
(134, 'P10', 'Alexander Wurz', 33, 'Reino Unido', '2007', 'Williams', 82, 78, 0, '0', '2025-05-22 12:53:33'),
(135, 'P20', 'Scott Speed', 24, 'Estados Unidos', '2007', 'Toro Rosso', 79, 72, 0, '0', '2025-05-22 12:53:33'),
(136, 'P12', 'Jenson Button', 27, 'Reino Unido', '2007', 'Honda', 83, 82, 0, '0', '2025-05-22 12:53:33'),
(137, 'P22', 'Christijan Albers', 28, 'Holanda', '2007', 'Spyker', 77, 75, 0, '0', '2025-05-22 12:53:33'),
(138, 'P11', 'Rubens Barrichello', 34, 'Brasil', '2007', 'Honda', 81, 81, 0, '0', '2025-05-22 12:53:33'),
(139, 'P14', 'Mark Webber', 30, 'Australia', '2007', 'Red Bull', 82, 78, 0, '0', '2025-05-22 12:53:33'),
(140, 'P13', 'Sebastian Vettel', 19, 'Alemania', '2007', 'Red Bull', 88, 85, 0, '0', '2025-05-22 12:53:33'),
(141, 'P16', 'Jarno Trulli', 32, 'Italia', '2007', 'Toyota', 82, 77, 0, '0', '2025-05-22 12:53:33'),
(142, 'P15', 'Ralf Schumacher', 31, 'Alemania', '2007', 'Toyota', 81, 75, 0, '0', '2025-05-22 12:53:33'),
(143, 'P18', 'Takuma Sato', 30, 'Japon', '2007', 'Super Aguri', 82, 75, 0, '0', '2025-05-22 12:53:33'),
(144, 'P17', 'Anthony Davidson', 27, 'Reino Unido', '2007', 'Super Aguri', 79, 74, 0, '0', '2025-05-22 12:53:33'),
(145, 'P19', 'Vitantonio Liuzzi', 25, 'Italia', '2007', 'Toro Rosso', 81, 73, 0, '0', '2025-05-22 12:53:33'),
(146, 'P1', 'Fernando Alonso', 25, 'España', '2007', 'Mclaren', 95, 91, 0, '2', '2025-05-22 13:01:25'),
(147, 'P2', 'Lewis Hamilton', 22, 'Reino Unido', '2007', 'Mclaren', 94, 93, 0, '0', '2025-05-22 13:01:25'),
(148, 'P3', 'Kimi Raikkonen', 28, 'Finlandia', '2007', 'Ferrari', 93, 93, 0, '0', '2025-05-22 13:01:25'),
(149, 'P4', 'Felipe Massa', 25, 'Brasil', '2007', 'Ferrari', 92, 90, 0, '0', '2025-05-22 13:01:25'),
(150, 'P5', 'Giancarlo Fisichella', 33, 'Italia', '2007', 'Renault', 83, 81, 0, '0', '2025-05-22 13:01:25'),
(151, 'P6', 'Heikki Kovalainen', 25, 'Finlandia', '2007', 'Renault', 85, 83, 0, '0', '2025-05-22 13:01:25'),
(152, 'P7', 'Nick Heidfeld', 29, 'Polonia', '2007', 'BMW Sauber', 88, 88, 0, '0', '2025-05-22 13:01:25'),
(153, 'P8', 'Robert Kubica', 22, 'Polonia', '2007', 'BMW Sauber', 87, 86, 0, '0', '2025-05-22 13:01:25'),
(154, 'P9', 'Nico Rosberg', 21, 'Alemania', '2007', 'Williams', 84, 80, 0, '0', '2025-05-22 13:01:25'),
(155, 'P21', 'Adrian Sutil', 24, 'Uruguay', '2007', 'Spyker', 78, 76, 0, '0', '2025-05-22 13:01:25'),
(156, 'P10', 'Alexander Wurz', 33, 'Reino Unido', '2007', 'Williams', 82, 78, 0, '0', '2025-05-22 13:01:25'),
(157, 'P20', 'Scott Speed', 24, 'Estados Unidos', '2007', 'Toro Rosso', 79, 72, 0, '0', '2025-05-22 13:01:25'),
(158, 'P12', 'Jenson Button', 27, 'Reino Unido', '2007', 'Honda', 83, 82, 0, '0', '2025-05-22 13:01:25'),
(159, 'P22', 'Christijan Albers', 28, 'Holanda', '2007', 'Spyker', 77, 75, 0, '0', '2025-05-22 13:01:25'),
(160, 'P11', 'Rubens Barrichello', 34, 'Brasil', '2007', 'Honda', 81, 81, 0, '0', '2025-05-22 13:01:25'),
(161, 'P14', 'Mark Webber', 30, 'Australia', '2007', 'Red Bull', 82, 78, 0, '0', '2025-05-22 13:01:25'),
(162, 'P13', 'Sebastian Vettel', 19, 'Alemania', '2007', 'Red Bull', 88, 85, 0, '0', '2025-05-22 13:01:25'),
(163, 'P16', 'Jarno Trulli', 32, 'Italia', '2007', 'Toyota', 82, 77, 0, '0', '2025-05-22 13:01:25'),
(164, 'P15', 'Ralf Schumacher', 31, 'Alemania', '2007', 'Toyota', 81, 75, 0, '0', '2025-05-22 13:01:25'),
(165, 'P18', 'Takuma Sato', 30, 'Japon', '2007', 'Super Aguri', 82, 75, 0, '0', '2025-05-22 13:01:25'),
(166, 'P17', 'Anthony Davidson', 27, 'Reino Unido', '2007', 'Super Aguri', 79, 74, 0, '0', '2025-05-22 13:01:25'),
(167, 'P19', 'Vitantonio Liuzzi', 25, 'Italia', '2007', 'Toro Rosso', 81, 73, 0, '0', '2025-05-22 13:01:25'),
(168, 'P1', 'Fernando Alonso', 25, 'España', '2007', 'Mclaren', 95, 91, 0, '2', '2025-05-22 13:04:43'),
(169, 'P2', 'Lewis Hamilton', 22, 'Reino Unido', '2007', 'Mclaren', 94, 93, 0, '0', '2025-05-22 13:04:43'),
(170, 'P3', 'Kimi Raikkonen', 28, 'Finlandia', '2007', 'Ferrari', 93, 93, 0, '0', '2025-05-22 13:04:43'),
(171, 'P4', 'Felipe Massa', 25, 'Brasil', '2007', 'Ferrari', 92, 90, 0, '0', '2025-05-22 13:04:43'),
(172, 'P5', 'Giancarlo Fisichella', 33, 'Italia', '2007', 'Renault', 83, 81, 0, '0', '2025-05-22 13:04:43'),
(173, 'P6', 'Heikki Kovalainen', 25, 'Finlandia', '2007', 'Renault', 85, 83, 0, '0', '2025-05-22 13:04:43'),
(174, 'P7', 'Nick Heidfeld', 29, 'Polonia', '2007', 'BMW Sauber', 88, 88, 0, '0', '2025-05-22 13:04:43'),
(175, 'P8', 'Robert Kubica', 22, 'Polonia', '2007', 'BMW Sauber', 87, 86, 0, '0', '2025-05-22 13:04:43'),
(176, 'P9', 'Nico Rosberg', 21, 'Alemania', '2007', 'Williams', 84, 80, 0, '0', '2025-05-22 13:04:43'),
(177, 'P21', 'Adrian Sutil', 24, 'Uruguay', '2007', 'Spyker', 78, 76, 0, '0', '2025-05-22 13:04:43'),
(178, 'P10', 'Alexander Wurz', 33, 'Reino Unido', '2007', 'Williams', 82, 78, 0, '0', '2025-05-22 13:04:43'),
(179, 'P20', 'Scott Speed', 24, 'Estados Unidos', '2007', 'Toro Rosso', 79, 72, 0, '0', '2025-05-22 13:04:43'),
(180, 'P12', 'Jenson Button', 27, 'Reino Unido', '2007', 'Honda', 83, 82, 0, '0', '2025-05-22 13:04:43'),
(181, 'P22', 'Christijan Albers', 28, 'Holanda', '2007', 'Spyker', 77, 75, 0, '0', '2025-05-22 13:04:43'),
(182, 'P11', 'Rubens Barrichello', 34, 'Brasil', '2007', 'Honda', 81, 81, 0, '0', '2025-05-22 13:04:43'),
(183, 'P14', 'Mark Webber', 30, 'Australia', '2007', 'Red Bull', 82, 78, 0, '0', '2025-05-22 13:04:43'),
(184, 'P13', 'Sebastian Vettel', 19, 'Alemania', '2007', 'Red Bull', 88, 85, 0, '0', '2025-05-22 13:04:43'),
(185, 'P16', 'Jarno Trulli', 32, 'Italia', '2007', 'Toyota', 82, 77, 0, '0', '2025-05-22 13:04:43'),
(186, 'P15', 'Ralf Schumacher', 31, 'Alemania', '2007', 'Toyota', 81, 75, 0, '0', '2025-05-22 13:04:43'),
(187, 'P18', 'Takuma Sato', 30, 'Japon', '2007', 'Super Aguri', 82, 75, 0, '0', '2025-05-22 13:04:43'),
(188, 'P17', 'Anthony Davidson', 27, 'Reino Unido', '2007', 'Super Aguri', 79, 74, 0, '0', '2025-05-22 13:04:43'),
(189, 'P19', 'Vitantonio Liuzzi', 25, 'Italia', '2007', 'Toro Rosso', 81, 73, 0, '0', '2025-05-22 13:04:43');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carreras`
--
ALTER TABLE `carreras`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `piloto`
--
ALTER TABLE `piloto`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `piloto_log`
--
ALTER TABLE `piloto_log`
  ADD PRIMARY KEY (`log_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carreras`
--
ALTER TABLE `carreras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `piloto_log`
--
ALTER TABLE `piloto_log`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=190;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
