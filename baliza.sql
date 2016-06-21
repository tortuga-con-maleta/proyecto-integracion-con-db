-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-06-2016 a las 22:12:30
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 5.6.21

CREATE DATABASE `baliza`;
USE `baliza`

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `baliza`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `baliza`
--

CREATE TABLE `baliza` (
  `id_baliza` int(11) NOT NULL,
  `cod_baliza` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `fk_zona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `baliza`
--

INSERT INTO `baliza` (`id_baliza`, `cod_baliza`, `fk_zona`) VALUES
(1, 'perf_01', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `visita`
--

CREATE TABLE `visita` (
  `id_visita` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `fk_baliza` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `visita`
--

INSERT INTO `visita` (`id_visita`, `fecha`, `fk_baliza`, `id_cliente`) VALUES
(1, '2016-06-20', 1, 1231),
(2, '2016-06-02', 1, 1231);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zona`
--

CREATE TABLE `zona` (
  `id_zona` int(11) NOT NULL,
  `nombre_zona` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `zona`
--

INSERT INTO `zona` (`id_zona`, `nombre_zona`) VALUES
(2, 'perfumeria'),
(3, 'NuevaZona'),
(4, 'nuevanuevazona'),
(5, 'la zona de peligro'),
(6, 'Electrónica');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `baliza`
--
ALTER TABLE `baliza`
  ADD PRIMARY KEY (`id_baliza`),
  ADD KEY `fk_zona` (`fk_zona`);

--
-- Indices de la tabla `visita`
--
ALTER TABLE `visita`
  ADD PRIMARY KEY (`id_visita`),
  ADD KEY `fk_baliza` (`fk_baliza`);

--
-- Indices de la tabla `zona`
--
ALTER TABLE `zona`
  ADD PRIMARY KEY (`id_zona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `baliza`
--
ALTER TABLE `baliza`
  MODIFY `id_baliza` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `visita`
--
ALTER TABLE `visita`
  MODIFY `id_visita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `zona`
--
ALTER TABLE `zona`
  MODIFY `id_zona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `baliza`
--
ALTER TABLE `baliza`
  ADD CONSTRAINT `baliza_ibfk_1` FOREIGN KEY (`fk_zona`) REFERENCES `zona` (`id_zona`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `visita`
--
ALTER TABLE `visita`
  ADD CONSTRAINT `visita_ibfk_1` FOREIGN KEY (`fk_baliza`) REFERENCES `baliza` (`id_baliza`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
