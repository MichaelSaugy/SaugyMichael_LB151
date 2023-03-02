-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 02. Mrz 2023 um 10:21
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
(51, 'Edi', 1134, 5, 'Wed Mar 01 21:35:48 CET 2023', 'Wed Mar 01 21:42:04 CET 2023');

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
(2, 'Cristiano Ronaldo', 2, 2, 1),
(4, 'Felsformation', 0, 3, 2),
(6, 'Biodiversität', 1, 3, 2),
(8, 'Schneegipfel', 3, 3, 1),
(9, 'Morgentau', 1, 3, 1),
(12, 'Biolumineszenz', 1, 3, 3),
(15, 'Leonardo da Vinci', 5, 1, 1);

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
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT für Tabelle `difficulty`
--
ALTER TABLE `difficulty`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `games`
--
ALTER TABLE `games`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT für Tabelle `phrases`
--
ALTER TABLE `phrases`
  MODIFY `id` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

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
