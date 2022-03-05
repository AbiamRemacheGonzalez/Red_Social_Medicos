-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-03-2022 a las 20:55:54
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `as_db`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `communities`
--

CREATE TABLE `communities` (
  `communityId` int(255) NOT NULL,
  `communityName` varchar(255) NOT NULL,
  `communityDescription` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `communities`
--

INSERT INTO `communities` (`communityId`, `communityName`, `communityDescription`) VALUES
(1, 'Enfermería', 'Esta rama de la medicina se especializa en las necesidades básicas de la salud de una persona, de manera independiente a las funciones de un médico.'),
(2, 'Biomedicina', 'Esta disciplina se define como el estudio de los rasgos biológicos de la medicina. Su campo de conocimiento y práctica es muy amplio, por ejemplo: los mecanismos moleculares, celulares, bioquímicos y/o genéticos. Estos estudios están encaminados a desarro'),
(3, 'Odontología', 'Esta rama de la medicina se encarga exclusivamente de la salud bucal a través del diagnóstico, el tratamiento y la prevención de enfermedades de dientes, encías, tejido periodontal, etc.'),
(4, 'Oftalmología', 'La oftalmología es la especialidad médico-quirúrgica que se encarga del estudio y tratamiento de las enfermedades de los ojos.'),
(5, 'Psiquiatría', 'La psiquiatría es una especialidad de la medicina, que se dedica al estudio y promoción de la salud mental, así como al diagnóstico y tratamiento de los trastornos mentales.'),
(6, 'Nutrición', 'La nutrición es el proceso biológico en el que los organismos asimilan los alimentos sólidos y líquidos necesarios para el funcionamiento, el crecimiento y el mantenimiento de sus funciones vitales');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `members`
--

CREATE TABLE `members` (
  `userId` int(255) NOT NULL,
  `communityId` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `members`
--

INSERT INTO `members` (`userId`, `communityId`) VALUES
(3, 1),
(6, 1),
(5, 1),
(2, 1),
(4, 1),
(7, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `moderators`
--

CREATE TABLE `moderators` (
  `userId` int(255) NOT NULL,
  `communityId` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `moderators`
--

INSERT INTO `moderators` (`userId`, `communityId`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `userId` int(255) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `userEmail` varchar(255) NOT NULL,
  `userPassword` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`userId`, `userName`, `userEmail`, `userPassword`) VALUES
(1, 'Abiam', 'abiam@gmail.com', '1234'),
(2, 'Pedro', 'pedro@gmail.com', '1234'),
(3, 'Alejandro', 'alejandro@gmail.com', '1234'),
(4, 'Noah', 'noah@gmail.com', '1234'),
(5, 'Javier', 'javier@gmail.com', '1234'),
(6, 'Cintia', 'cintia@gmail.com', '1234'),
(7, 'Sara', 'sara@gmail.com', '1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `communities`
--
ALTER TABLE `communities`
  ADD PRIMARY KEY (`communityId`);

--
-- Indices de la tabla `members`
--
ALTER TABLE `members`
  ADD KEY `userId` (`userId`),
  ADD KEY `communityId` (`communityId`);

--
-- Indices de la tabla `moderators`
--
ALTER TABLE `moderators`
  ADD KEY `userId` (`userId`),
  ADD KEY `communityId` (`communityId`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `communities`
--
ALTER TABLE `communities`
  MODIFY `communityId` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `members`
--
ALTER TABLE `members`
  ADD CONSTRAINT `members_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`),
  ADD CONSTRAINT `members_ibfk_2` FOREIGN KEY (`communityId`) REFERENCES `communities` (`communityId`);

--
-- Filtros para la tabla `moderators`
--
ALTER TABLE `moderators`
  ADD CONSTRAINT `moderators_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`),
  ADD CONSTRAINT `moderators_ibfk_2` FOREIGN KEY (`communityId`) REFERENCES `communities` (`communityId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
