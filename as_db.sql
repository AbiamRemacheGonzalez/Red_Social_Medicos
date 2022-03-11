-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-03-2022 a las 02:31:45
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
(1, 1),
(1, 4),
(1, 2),
(1, 6);

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
-- Estructura de tabla para la tabla `posts`
--

CREATE TABLE `posts` (
  `postId` int(255) NOT NULL,
  `communityId` int(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `postTitle` varchar(255) NOT NULL,
  `postDescription` longtext NOT NULL,
  `creationDate` datetime NOT NULL,
  `postEvaluation` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `posts`
--

INSERT INTO `posts` (`postId`, `communityId`, `userId`, `postTitle`, `postDescription`, `creationDate`, `postEvaluation`) VALUES
(1, 6, 3, 'Tipos de cereales buenos para desayunar', 'Los cereales sin azúcar y con frutas. Si podéis usad leche de almendras.', '2022-03-08 00:02:54', 0),
(2, 6, 3, 'Hablando de desayunos...', 'Quiero saber cuales la mejor fruta para el desayuno. Algún miembro de la comunidad tiene opciones interesantes.', '2022-03-09 12:48:52', 0),
(3, 6, 6, 'Comida para veganos', 'Si eres de las personas que eligen una alimentación vegana, también puedes realizar una comida de forma saludable y variada. En Cocina Casera y Fácil son muchas las recetas que hemos preparado pensando en personas veganas. Por ello, aquí te dejo una selec', '2022-03-10 00:39:48', 0),
(4, 6, 2, '¿Cuáles son las mejores tortillas?', 'Se dice que la inventó el bar Néstor de San Sebastián allá por los 80. Néstor y su esposa solo preparaban dos al día, las cortaban en porciones y las entregaban únicamente a quienes llegaban antes de la hora de apertura del local para apuntarse en una lista. Desde entonces, los españoles se pueden clasificar en dos: Los que prefieren la tortilla con cebolla o los que la prefieren sin. Es así de simple o de complejo, según se mire. Esta cuestión (ríete tú de la política) ha roto parejas, amistades y daría de sí para eternos referéndum. ¿Quieres sumar un punto en la discusión? La de Néstor SÍ llevaba cebolla.\r\n\r\nEn cualquier caso, con cebolla, sin cebolla o con algún que otro aderezo, hemos cometido la osadía de elegir algunas que podrían superar a las de tu madre. De acuerdo, no la hemos probado, o tal vez sí, pero son diez que en nuestra humilde opinión, y tras algunos sondeos, merecen estar en este ranking. Atención a polemistas: El orden es rigurosamente alfabético.', '2022-03-10 00:43:40', 0),
(5, 2, 4, 'Grado en Biomedicina', 'La biomedicina es la ciencia que combina conocimientos de biología y de medicina para investigar el funcionamiento y comportamiento del cuerpo humano desde un enfoque multidisciplinar.\r\n\r\nActualmente, nuestra sociedad demanda expertos en el ámbito de la salud que sean capaces de estudiar las bases moleculares del organismo para comprender qué ocurre cuando enferma y desarrollar nuevas técnicas para el diagnóstico y el tratamiento de las enfermedades.', '2022-03-10 01:22:05', 0),
(7, 4, 2, 'Ojos rojos y llorosos', 'En general, los ojos rojos son causados por alergia, fatiga ocular, uso exagerado de lentes de contacto o infecciones oculares comunes, tales como conjuntivitis. No obstante, el enrojecimiento ocular algunas veces puede ser signo de un trastorno o enfermedad más grave en los ojos; la uveítis o el glaucoma, por ejemplo.', '2022-03-11 00:17:14', 0),
(8, 4, 1, 'Ojos resecos', 'Los ojos secos son consecuencia del uso excesivo de sal en la dieta. Puedes poner esto a prueba, especialmente cuando te levantes en la noche para ir al baño. Si tus ojos están secos, toma unos 350 ml de agua. Fíjate si tus ojos se alivian inmediatamente. Si es así, entonces reduce la sal en tu dieta y mantente hidratado.', '2022-03-11 00:18:52', 0),
(9, 2, 1, '¿Dónde y cómo estudiar la carrera sanitaria con más empleo?', 'Según el programa de estudios de la Universidad de Sevilla, el grado en Biomedicina combina los conocimientos de la Biología y de la Medicina. El estudiante adquiere conocimientos y desarrolla competencias orientadas al estudio de las bases biológicas de la salud y las enfermedades humanas. La aplicación de la investigación biológica básica en la Medicina es necesaria para profundizar en el conocimiento de la vida humana y de nuevas estrategias para el diagnóstico y el tratamiento de las enfermedades.', '2022-03-11 00:28:14', 0);

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
-- Indices de la tabla `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`postId`),
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
-- AUTO_INCREMENT de la tabla `posts`
--
ALTER TABLE `posts`
  MODIFY `postId` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

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

--
-- Filtros para la tabla `posts`
--
ALTER TABLE `posts`
  ADD CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`),
  ADD CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`communityId`) REFERENCES `communities` (`communityId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
