-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ott 12, 2021 alle 00:06
-- Versione del server: 10.4.20-MariaDB
-- Versione PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinica`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `medici`
--

CREATE TABLE `medici` (
  `id_medico` int(11) NOT NULL,
  `id_reparto` int(11) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `Cognome` varchar(50) NOT NULL,
  `numero_cellulare` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `medici`
--

INSERT INTO `medici` (`id_medico`, `id_reparto`, `nome`, `Cognome`, `numero_cellulare`, `email`, `password`) VALUES
(1, 1, 'Rocco ', 'Giordano', '03767544598', 'RoccoGiordano@teleworm.us', 'iengeiHo0na'),
(2, 2, 'Abelardo ', 'Gallo', '03982781859', 'AbelardoGallo@dayrep.com', 'Che1loonoo'),
(3, 3, 'Danilo ', 'Beneventi', '03521712366', 'DaniloBeneventi@armyspy.com', 'hi7goopaN4'),
(4, 4, 'Arcangela ', 'Giordano', '03200114162', 'ArcangelaGiordano@teleworm.us', 'Bic3ic3zei'),
(5, 5, 'Alfredo ', 'Milano', '03447072089', 'AlfredoMilano@jourrapide.com', 'Mohpoomei6'),
(6, 1, 'Nora ', 'Baresi', '03497603824', 'NoraBaresi@armyspy.com', 'ohthiu7Ie6'),
(7, 2, 'Ernesta ', 'Napolitano', '03943296474', 'ErnestaNapolitano@rhyta.com', 'aekaigahRi1'),
(8, 3, 'Marco', 'Lisi', '34659874568', 'marco.lisi@gmail.com', 'MarcoLisi!'),
(9, 4, 'Antonio', 'Parchi', '3214567898', 'antonio.parchi@gmail.com', 'AntonioParchi!'),
(10, 5, 'Alessandro', 'Borghesi', '3659874562', 'alessandro.borghesi@gmail.com', 'AlessandroBorghesi!');

-- --------------------------------------------------------

--
-- Struttura della tabella `pazienti`
--

CREATE TABLE `pazienti` (
  `id_paziente` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cognome` varchar(50) NOT NULL,
  `indirizzo` varchar(50) DEFAULT NULL,
  `localita` varchar(50) DEFAULT NULL,
  `cap` varchar(5) DEFAULT NULL,
  `numero_cellulare` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `pazienti`
--

INSERT INTO `pazienti` (`id_paziente`, `nome`, `cognome`, `indirizzo`, `localita`, `cap`, `numero_cellulare`, `email`, `password`) VALUES
(1, 'Virgilio', 'Lullo', 'Via Piave, 147', 'Fossacesia Marina', '66020', '03232507519', 'VirgilioColombo@dayrep.com', 'fio2uCeecha'),
(2, 'Cosma', 'Umbolo', 'Via Longhena, 27', 'Madonna Della Pace', '00020', '03477112566', 'CosmaLucchesi@teleworm.us', 'EiH4maza'),
(3, 'Gilberto', 'Ognon', 'Stradone Antonio Provolo, 37', 'Fabro Scalo', '05010', '0345136824', 'GilbertoNapolitani@rhyta.com', 'gahJah3su'),
(4, 'Rolando ', 'Puppo', 'Via Donnalbina, 89', 'Pella', '28010', '03363063138', 'RolandoArcuri@rhyta.com', 'pa7ooN5aiR'),
(5, 'Rufino', 'Caforo', 'Via Galvani, 43', 'Torricola', '00178', '03392567662', 'RufinoCapon@rhyta.com', 'aokai8Ohc');

-- --------------------------------------------------------

--
-- Struttura della tabella `reparti`
--

CREATE TABLE `reparti` (
  `id_reparto` int(11) NOT NULL,
  `reparto` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `reparti`
--

INSERT INTO `reparti` (`id_reparto`, `reparto`) VALUES
(1, 'Oculistica'),
(2, 'Gastroenterologia'),
(3, 'Ginecologia'),
(4, 'Urologia'),
(5, 'Cardiologia');

-- --------------------------------------------------------

--
-- Struttura della tabella `visite`
--

CREATE TABLE `visite` (
  `id_visite` int(11) NOT NULL,
  `id_paziente` int(11) DEFAULT NULL,
  `id_medico` int(11) DEFAULT NULL,
  `data_prenotazione` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `visite`
--

INSERT INTO `visite` (`id_visite`, `id_paziente`, `id_medico`, `data_prenotazione`) VALUES
(1, 2, 4, '2021-10-27 15:30:00');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `medici`
--
ALTER TABLE `medici`
  ADD PRIMARY KEY (`id_medico`),
  ADD KEY `id_reparto` (`id_reparto`);

--
-- Indici per le tabelle `pazienti`
--
ALTER TABLE `pazienti`
  ADD PRIMARY KEY (`id_paziente`);

--
-- Indici per le tabelle `reparti`
--
ALTER TABLE `reparti`
  ADD PRIMARY KEY (`id_reparto`);

--
-- Indici per le tabelle `visite`
--
ALTER TABLE `visite`
  ADD PRIMARY KEY (`id_visite`),
  ADD KEY `paziente` (`id_paziente`),
  ADD KEY `medico` (`id_medico`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `medici`
--
ALTER TABLE `medici`
  MODIFY `id_medico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT per la tabella `pazienti`
--
ALTER TABLE `pazienti`
  MODIFY `id_paziente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `reparti`
--
ALTER TABLE `reparti`
  MODIFY `id_reparto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `visite`
--
ALTER TABLE `visite`
  MODIFY `id_visite` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `medici`
--
ALTER TABLE `medici`
  ADD CONSTRAINT `medici_ibfk_1` FOREIGN KEY (`id_reparto`) REFERENCES `reparti` (`id_reparto`);

--
-- Limiti per la tabella `visite`
--
ALTER TABLE `visite`
  ADD CONSTRAINT `medico` FOREIGN KEY (`id_medico`) REFERENCES `medici` (`id_medico`),
  ADD CONSTRAINT `paziente` FOREIGN KEY (`id_paziente`) REFERENCES `pazienti` (`id_paziente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
