-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 02. Mrz 2023 um 16:20
-- Server-Version: 10.4.21-MariaDB
-- PHP-Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `quizm151`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `category`
--

CREATE TABLE `category` (
  `id` int(9) NOT NULL,
  `name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Künstler'),
(2, 'Fussball'),
(3, 'Natur'),
(4, 'Berufe');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `difficulty`
--

CREATE TABLE `difficulty` (
  `id` int(9) NOT NULL,
  `name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `difficulty`
--

INSERT INTO `difficulty` (`id`, `name`) VALUES
(1, 'Einfach'),
(2, 'Mittel'),
(3, 'Schwierig');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `games`
--

CREATE TABLE `games` (
  `id` int(9) NOT NULL,
  `name` varchar(250) NOT NULL,
  `balance` int(9) NOT NULL,
  `numberOfRounds` int(9) NOT NULL,
  `start` varchar(250) DEFAULT NULL,
  `end` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `games`
--

INSERT INTO `games` (`id`, `name`, `balance`, `numberOfRounds`, `start`, `end`) VALUES
(50, 'e', 489, 3, 'Wed Mar 01 16:03:04 CET 2023', 'Wed Mar 01 16:04:25 CET 2023'),
(51, 'Edi', 1134, 5, 'Wed Mar 01 21:35:48 CET 2023', 'Wed Mar 01 21:42:04 CET 2023'),
(54, 'Test', 627, 2, 'Thu Mar 02 13:57:40 CET 2023', 'Thu Mar 02 13:59:41 CET 2023');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `phrases`
--

CREATE TABLE `phrases` (
  `id` int(9) NOT NULL,
  `phrase` varchar(250) NOT NULL,
  `timesFailed` int(9) NOT NULL,
  `id_category` int(9) NOT NULL,
  `id_difficulty` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `phrases`
--

INSERT INTO `phrases` (`id`, `phrase`, `timesFailed`, `id_category`, `id_difficulty`) VALUES
(2, 'Cristiano Ronaldo', 3, 2, 1),
(4, 'Felsformation', 3, 3, 2),
(6, 'Biodiversität', 1, 3, 2),
(8, 'Schneegipfel', 5, 3, 1),
(9, 'Morgentau', 2, 3, 1),
(12, 'Biolumineszenz', 1, 3, 3),
(15, 'Leonardo da Vinci', 6, 1, 1),
(19, 'Lionel Messi', 0, 2, 1),
(20, 'Kylian Mbappé', 0, 2, 2),
(21, 'Vincent van Gogh', 0, 1, 2),
(22, 'Pablo Picasso', 0, 1, 2),
(23, 'Kaufmann', 0, 4, 2),
(24, 'Informatiker', 0, 4, 2),
(25, 'Verkäufer', 0, 4, 2),
(26, 'Kraftfahrzeugmechatroniker', 0, 4, 3),
(27, 'Michelangelo Buonarroti', 0, 1, 3),
(28, 'Diego Maradona', 0, 2, 2),
(29, 'Elektroniker', 0, 4, 2),
(30, 'Astronaut', 0, 4, 1),
(31, 'Arzt', 0, 4, 1),
(32, 'Baumstamm', 0, 3, 1);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `difficulty`
--
ALTER TABLE `difficulty`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`id`);

--
-- Indizes für die Tabelle `phrases`
--
ALTER TABLE `phrases`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_category` (`id_category`),
  ADD KEY `fk_difficulty` (`id_difficulty`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `category`
--
ALTER TABLE `category`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT für Tabelle `difficulty`
--
ALTER TABLE `difficulty`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `games`
--
ALTER TABLE `games`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- AUTO_INCREMENT für Tabelle `phrases`
--
ALTER TABLE `phrases`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `phrases`
--
ALTER TABLE `phrases`
  ADD CONSTRAINT `fk_category` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`),
  ADD CONSTRAINT `fk_difficulty` FOREIGN KEY (`id_difficulty`) REFERENCES `difficulty` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
