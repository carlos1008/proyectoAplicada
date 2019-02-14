-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 12-02-2019 a las 21:14:29
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
  `dep_id` int(2) NOT NULL,
  `dep_nombre` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `reg_tipo` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `usa_id` int(4) NOT NULL,
  `usa_nombre` varchar(150) NOT NULL,
  `usa_apellido` varchar(150) NOT NULL,
  `usa_email` varchar(150) NOT NULL,
  `usa_codigo` varchar(4) NOT NULL,
  `usa_cedula` varchar(13) NOT NULL,
  `usa_departamento` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  ADD PRIMARY KEY (`reg_id`);

--
-- Indices de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`usa_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_departamento`
--
ALTER TABLE `tbl_departamento`
  MODIFY `dep_id` int(2) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_registro`
--
ALTER TABLE `tbl_registro`
  MODIFY `reg_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `usa_id` int(4) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
