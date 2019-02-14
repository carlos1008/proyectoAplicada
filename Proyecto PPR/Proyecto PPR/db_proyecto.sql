-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-02-2019 a las 19:44:01
-- Versión del servidor: 10.1.34-MariaDB
-- Versión de PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_departamento`
--

CREATE TABLE `tbl_departamento` (
  `dep_id` int(11) NOT NULL,
  `dep_nombre` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tbl_departamento`
--

INSERT INTO `tbl_departamento` (`dep_id`, `dep_nombre`) VALUES
(3, 'Cobros'),
(4, 'Finanzas'),
(5, 'TTHH');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_registro`
--

CREATE TABLE `tbl_registro` (
  `reg_id` int(11) NOT NULL,
  `reg_usuario` int(4) NOT NULL,
  `reg_foto` varchar(256) NOT NULL,
  `reg_fecha` varchar(20) NOT NULL,
  `reg_hora` varchar(20) NOT NULL,
  `reg_tipo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tbl_registro`
--

INSERT INTO `tbl_registro` (`reg_id`, `reg_usuario`, `reg_foto`, `reg_fecha`, `reg_hora`, `reg_tipo`) VALUES
(1, 3, 'Fotos de Registro/null.jpg', '16:00:56.125', '16', 'Salida'),
(2, 3, 'Fotos de Registro/null.jpg', '16:10:59.978', '16', 'Salida');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `usa_id` int(4) NOT NULL,
  `usa_nombre` varchar(150) NOT NULL,
  `usa_apellido` varchar(150) NOT NULL,
  `usa_email` varchar(150) NOT NULL,
  `usa_codigo` varchar(150) NOT NULL,
  `usa_cedula` varchar(13) NOT NULL,
  `usa_departamento` int(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`usa_id`, `usa_nombre`, `usa_apellido`, `usa_email`, `usa_codigo`, `usa_cedula`, `usa_departamento`) VALUES
(3, 'juan', 'FLORES', 'j@gm.com', '2515', '84894', 3),
(4, 'kevin', 'RAMIREZ', 'kevinramirez8@hotmail.es', '9656', '123', 4),
(5, 'kevin', 'RAMIREZ', 'ker@hotmail.es', '1056', '0927816223', 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tbl_departamento`
--
ALTER TABLE `tbl_departamento`
  ADD PRIMARY KEY (`dep_id`);

--
-- Indices de la tabla `tbl_registro`
--
ALTER TABLE `tbl_registro`
  ADD PRIMARY KEY (`reg_id`),
  ADD KEY `reg_usuario` (`reg_usuario`);

--
-- Indices de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`usa_id`),
  ADD KEY `tbl_usuario_ibfk_1` (`usa_departamento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_departamento`
--
ALTER TABLE `tbl_departamento`
  MODIFY `dep_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tbl_registro`
--
ALTER TABLE `tbl_registro`
  MODIFY `reg_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `usa_id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tbl_registro`
--
ALTER TABLE `tbl_registro`
  ADD CONSTRAINT `tbl_registro_ibfk_1` FOREIGN KEY (`reg_usuario`) REFERENCES `tbl_usuario` (`usa_id`);

--
-- Filtros para la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD CONSTRAINT `tbl_usuario_ibfk_1` FOREIGN KEY (`usa_departamento`) REFERENCES `tbl_departamento` (`dep_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
