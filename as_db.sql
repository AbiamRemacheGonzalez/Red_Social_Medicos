-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-04-2022 a las 20:27:23
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
-- Estructura de tabla para la tabla `aditionaluserinfo`
--

CREATE TABLE `aditionaluserinfo` (
  `userInfoId` int(25) NOT NULL,
  `userId` int(255) NOT NULL,
  `userAge` int(255) NOT NULL,
  `userSex` int(255) NOT NULL,
  `userNationality` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `aditionaluserinfo`
--

INSERT INTO `aditionaluserinfo` (`userInfoId`, `userId`, `userAge`, `userSex`, `userNationality`) VALUES
(1, 1, 21, 0, 'Alemania'),
(2, 2, 34, 0, 'Ucrania'),
(3, 3, 22, 0, 'Inglaterra'),
(4, 4, 18, 0, 'Noruega'),
(5, 5, 43, 0, 'Croacia'),
(6, 6, 25, 1, 'España'),
(7, 9, 29, 0, 'Portugal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comment`
--

CREATE TABLE `comment` (
  `commentId` int(255) NOT NULL,
  `postId` int(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `comment` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `community`
--

CREATE TABLE `community` (
  `communityId` int(255) NOT NULL,
  `communityName` varchar(255) NOT NULL,
  `communityDescription` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `community`
--

INSERT INTO `community` (`communityId`, `communityName`, `communityDescription`) VALUES
(1, 'Enfermería', 'Esta rama de la medicina se especializa en las necesidades básicas de la salud de una persona, de manera independiente a las funciones de un médico.'),
(2, 'Biomedicina', 'Esta disciplina se define como el estudio de los rasgos biológicos de la medicina. Su campo de conocimiento y práctica es muy amplio, por ejemplo: los mecanismos moleculares, celulares, bioquímicos y/o genéticos. Estos estudios están encaminados a desarro'),
(3, 'Odontología', 'Esta rama de la medicina se encarga exclusivamente de la salud bucal a través del diagnóstico, el tratamiento y la prevención de enfermedades de dientes, encías, tejido periodontal, etc.'),
(4, 'Oftalmología', 'La oftalmología es la especialidad médico-quirúrgica que se encarga del estudio y tratamiento de las enfermedades de los ojos.'),
(5, 'Psiquiatría', 'La psiquiatría es una especialidad de la medicina, que se dedica al estudio y promoción de la salud mental, así como al diagnóstico y tratamiento de los trastornos mentales.'),
(6, 'Nutrición', 'La nutrición es el proceso biológico en el que los organismos asimilan los alimentos sólidos y líquidos necesarios para el funcionamiento, el crecimiento y el mantenimiento de sus funciones vitales');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluation`
--

CREATE TABLE `evaluation` (
  `evaluationId` int(255) NOT NULL,
  `postId` int(255) NOT NULL,
  `userId` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `evaluation`
--

INSERT INTO `evaluation` (`evaluationId`, `postId`, `userId`) VALUES
(8, 11, 1),
(15, 10, 1),
(17, 10, 4),
(18, 24, 4),
(19, 10, 9),
(41, 24, 1),
(43, 25, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `member`
--

CREATE TABLE `member` (
  `memberId` int(11) NOT NULL,
  `userId` int(255) NOT NULL,
  `communityId` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `member`
--

INSERT INTO `member` (`memberId`, `userId`, `communityId`) VALUES
(4, 1, 3),
(5, 1, 4),
(6, 1, 5),
(7, 3, 6),
(14, 1, 1),
(16, 1, 6),
(17, 4, 3),
(18, 9, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `moderator`
--

CREATE TABLE `moderator` (
  `userId` int(255) NOT NULL,
  `communityId` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `moderator`
--

INSERT INTO `moderator` (`userId`, `communityId`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `post`
--

CREATE TABLE `post` (
  `postId` int(255) NOT NULL,
  `communityId` int(255) NOT NULL,
  `userId` int(255) NOT NULL,
  `postTitle` varchar(255) NOT NULL,
  `postDescription` longtext NOT NULL,
  `creationDate` datetime NOT NULL,
  `postEvaluation` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `post`
--

INSERT INTO `post` (`postId`, `communityId`, `userId`, `postTitle`, `postDescription`, `creationDate`, `postEvaluation`) VALUES
(1, 6, 3, 'Tipos de cereales buenos para desayunar', 'Los cereales sin azúcar y con frutas. Si podéis usad leche de almendras.', '2022-03-08 00:02:54', 0),
(2, 6, 3, 'Hablando de desayunos...', 'Quiero saber cuales la mejor fruta para el desayuno. Algún miembro de la comunidad tiene opciones interesantes.', '2022-03-09 12:48:52', 0),
(3, 6, 6, 'Comida para veganos', 'Si eres de las personas que eligen una alimentación vegana, también puedes realizar una comida de forma saludable y variada. En Cocina Casera y Fácil son muchas las recetas que hemos preparado pensando en personas veganas. Por ello, aquí te dejo una selec', '2022-03-10 00:39:48', 0),
(4, 6, 2, '¿Cuáles son las mejores tortillas?', 'Se dice que la inventó el bar Néstor de San Sebastián allá por los 80. Néstor y su esposa solo preparaban dos al día, las cortaban en porciones y las entregaban únicamente a quienes llegaban antes de la hora de apertura del local para apuntarse en una lista. Desde entonces, los españoles se pueden clasificar en dos: Los que prefieren la tortilla con cebolla o los que la prefieren sin. Es así de simple o de complejo, según se mire. Esta cuestión (ríete tú de la política) ha roto parejas, amistades y daría de sí para eternos referéndum. ¿Quieres sumar un punto en la discusión? La de Néstor SÍ llevaba cebolla.\r\n\r\nEn cualquier caso, con cebolla, sin cebolla o con algún que otro aderezo, hemos cometido la osadía de elegir algunas que podrían superar a las de tu madre. De acuerdo, no la hemos probado, o tal vez sí, pero son diez que en nuestra humilde opinión, y tras algunos sondeos, merecen estar en este ranking. Atención a polemistas: El orden es rigurosamente alfabético.', '2022-03-10 00:43:40', 0),
(5, 2, 4, 'Grado en Biomedicina', 'La biomedicina es la ciencia que combina conocimientos de biología y de medicina para investigar el funcionamiento y comportamiento del cuerpo humano desde un enfoque multidisciplinar.\r\n\r\nActualmente, nuestra sociedad demanda expertos en el ámbito de la salud que sean capaces de estudiar las bases moleculares del organismo para comprender qué ocurre cuando enferma y desarrollar nuevas técnicas para el diagnóstico y el tratamiento de las enfermedades.', '2022-03-10 01:22:05', 0),
(7, 4, 2, 'Ojos rojos y llorosos', 'En general, los ojos rojos son causados por alergia, fatiga ocular, uso exagerado de lentes de contacto o infecciones oculares comunes, tales como conjuntivitis. No obstante, el enrojecimiento ocular algunas veces puede ser signo de un trastorno o enfermedad más grave en los ojos; la uveítis o el glaucoma, por ejemplo.', '2022-03-11 00:17:14', 0),
(8, 4, 1, 'Ojos resecos', 'Los ojos secos son consecuencia del uso excesivo de sal en la dieta. Puedes poner esto a prueba, especialmente cuando te levantes en la noche para ir al baño. Si tus ojos están secos, toma unos 350 ml de agua. Fíjate si tus ojos se alivian inmediatamente. Si es así, entonces reduce la sal en tu dieta y mantente hidratado.', '2022-03-11 00:18:52', 0),
(9, 2, 1, '¿Dónde y cómo estudiar la carrera sanitaria con más empleo?', 'Según el programa de estudios de la Universidad de Sevilla, el grado en Biomedicina combina los conocimientos de la Biología y de la Medicina. El estudiante adquiere conocimientos y desarrolla competencias orientadas al estudio de las bases biológicas de la salud y las enfermedades humanas. La aplicación de la investigación biológica básica en la Medicina es necesaria para profundizar en el conocimiento de la vida humana y de nuevas estrategias para el diagnóstico y el tratamiento de las enfermedades.', '2022-03-11 00:28:14', 0),
(10, 3, 1, 'Me duele la boca', 'Me gustaría saber que tengo que ahcer para arreglar este dolor', '2022-03-11 18:26:03', 0),
(11, 5, 1, 'El otro día via a un gato muerto', 'Este tipo de cosas me afectan mucho alquien me puede ayudar', '2022-03-11 19:35:37', 0),
(24, 3, 9, 'Dolor de muelas', 'Se dice que el dolor de muelas es doloros.', '2022-04-08 01:50:18', 0),
(25, 6, 5, 'La Creatina es buena', 'Es proteina pura mientras no tomes mucha azucar todo bien.', '2022-04-08 01:52:14', 0),
(26, 4, 4, '¿Como hago para regular las gafas?', 'Se pueden comprar ciertas herramientas en la pagina web www.oftalmología.com', '2022-04-08 01:53:33', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `userId` int(255) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `userPassword` varchar(255) NOT NULL,
  `emailDomain` varchar(255) NOT NULL,
  `emailUser` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`userId`, `userName`, `userPassword`, `emailDomain`, `emailUser`) VALUES
(1, 'Abiam', '1234', 'gmail.com', 'abm'),
(2, 'Pedro', '1234', 'gmail.com', 'pdr'),
(3, 'Alejandro', '1234', 'gmail.com', 'aljdr'),
(4, 'Noah', '1234', 'gmail.com', 'nh'),
(5, 'Javier', '1234', 'gmail.com', 'jvr'),
(6, 'Cintia', '1234', 'gmail.com', 'cnt'),
(9, 'hector', '1234', 'gmail.com', 'hct');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aditionaluserinfo`
--
ALTER TABLE `aditionaluserinfo`
  ADD PRIMARY KEY (`userInfoId`),
  ADD KEY `userId` (`userId`);

--
-- Indices de la tabla `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`commentId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `postId` (`postId`);

--
-- Indices de la tabla `community`
--
ALTER TABLE `community`
  ADD PRIMARY KEY (`communityId`);

--
-- Indices de la tabla `evaluation`
--
ALTER TABLE `evaluation`
  ADD PRIMARY KEY (`evaluationId`),
  ADD KEY `postId` (`postId`),
  ADD KEY `userId` (`userId`);

--
-- Indices de la tabla `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`memberId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `communityId` (`communityId`);

--
-- Indices de la tabla `moderator`
--
ALTER TABLE `moderator`
  ADD KEY `userId` (`userId`),
  ADD KEY `communityId` (`communityId`);

--
-- Indices de la tabla `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`postId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `communityId` (`communityId`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aditionaluserinfo`
--
ALTER TABLE `aditionaluserinfo`
  MODIFY `userInfoId` int(25) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `comment`
--
ALTER TABLE `comment`
  MODIFY `commentId` int(255) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `community`
--
ALTER TABLE `community`
  MODIFY `communityId` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `evaluation`
--
ALTER TABLE `evaluation`
  MODIFY `evaluationId` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- AUTO_INCREMENT de la tabla `member`
--
ALTER TABLE `member`
  MODIFY `memberId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `post`
--
ALTER TABLE `post`
  MODIFY `postId` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `userId` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aditionaluserinfo`
--
ALTER TABLE `aditionaluserinfo`
  ADD CONSTRAINT `aditionaluserinfo_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`);

--
-- Filtros para la tabla `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`);

--
-- Filtros para la tabla `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`postId`) REFERENCES `post` (`postId`),
  ADD CONSTRAINT `evaluation_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`);

--
-- Filtros para la tabla `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `member_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  ADD CONSTRAINT `member_ibfk_2` FOREIGN KEY (`communityId`) REFERENCES `community` (`communityId`);

--
-- Filtros para la tabla `moderator`
--
ALTER TABLE `moderator`
  ADD CONSTRAINT `moderator_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  ADD CONSTRAINT `moderator_ibfk_2` FOREIGN KEY (`communityId`) REFERENCES `community` (`communityId`);

--
-- Filtros para la tabla `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `post_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`),
  ADD CONSTRAINT `post_ibfk_2` FOREIGN KEY (`communityId`) REFERENCES `community` (`communityId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
