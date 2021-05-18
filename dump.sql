-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 18 mai 2021 à 18:37
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet-e-billet`
--

-- --------------------------------------------------------

--
-- Structure de la table `acceuil`
--

DROP TABLE IF EXISTS `acceuil`;
CREATE TABLE IF NOT EXISTS `acceuil` (
  `e_id` bigint(20) NOT NULL,
  `l_id` bigint(20) NOT NULL,
  `date` date DEFAULT NULL,
  PRIMARY KEY (`e_id`,`l_id`),
  KEY `FK5g5eju4p2cejun9s2ahaiewjt` (`l_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `acceuil`
--

INSERT INTO `acceuil` (`e_id`, `l_id`, `date`) VALUES
(1, 2, '2021-04-21'),
(2, 2, '2021-04-07'),
(3, 2, NULL),
(4, 2, '2021-04-07'),
(144, 1, '2021-05-05'),
(145, 1, '2021-05-07'),
(146, 2, '2021-05-29'),
(148, 2, '2021-05-30');

-- --------------------------------------------------------

--
-- Structure de la table `achat`
--

DROP TABLE IF EXISTS `achat`;
CREATE TABLE IF NOT EXISTS `achat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `b_id` bigint(20) DEFAULT NULL,
  `u_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK19wa3esf3lfg1qmfmy7l3qhla` (`b_id`),
  KEY `FKqmh26lkaddjx85axsvo0xem5i` (`u_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `achat`
--

INSERT INTO `achat` (`id`, `date`, `quantite`, `b_id`, `u_id`) VALUES
(1, '2021-05-16', 1, 1, 0),
(2, '2021-05-16', 1, 1, 1),
(3, '2021-05-18', 1, 1, 1),
(4, '2021-05-18', 1, 1, 1),
(5, '2021-05-18', 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `billet`
--

DROP TABLE IF EXISTS `billet`;
CREATE TABLE IF NOT EXISTS `billet` (
  `b_id` bigint(20) NOT NULL,
  `b_critere` varchar(255) DEFAULT NULL,
  `b_tarif` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `e_id` bigint(20) DEFAULT NULL,
  `restriction_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`b_id`),
  KEY `FK4dw9pbodaoaofb8132qebhxy5` (`restriction_id`),
  KEY `FKq7j8fo0gnra4ev2kala0ghgop` (`e_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `billet`
--

INSERT INTO `billet` (`b_id`, `b_critere`, `b_tarif`, `stock`, `e_id`, `restriction_id`) VALUES
(1, 'Critere1', 10, 95, 1, NULL),
(2, 'Critere2', 5, 100, 2, NULL),
(141, NULL, NULL, NULL, NULL, NULL),
(142, 'zerze', 12, 100, 2, NULL),
(143, 'azer', 12, 100, 2, NULL),
(147, 'Critere3', 12, 100, 2, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `e_id` bigint(20) NOT NULL,
  `e_name` varchar(255) DEFAULT NULL,
  `t_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`e_id`),
  KEY `FKtbl6rro49fn27d8h1qmq706nv` (`t_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`e_id`, `e_name`, `t_id`) VALUES
(1, 'Evenement1', 1),
(2, 'Evenement2', 2);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(150);

-- --------------------------------------------------------

--
-- Structure de la table `lieu`
--

DROP TABLE IF EXISTS `lieu`;
CREATE TABLE IF NOT EXISTS `lieu` (
  `l_id` bigint(20) NOT NULL,
  `l_address` varchar(255) DEFAULT NULL,
  `l_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`l_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `lieu`
--

INSERT INTO `lieu` (`l_id`, `l_address`, `l_name`) VALUES
(1, 'LieuAdress1', 'lieu1'),
(2, 'LieuAdress2', 'Lieu2');

-- --------------------------------------------------------

--
-- Structure de la table `requiert`
--

DROP TABLE IF EXISTS `requiert`;
CREATE TABLE IF NOT EXISTS `requiert` (
  `b_id` bigint(20) NOT NULL,
  `restriction_id` bigint(20) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`b_id`,`restriction_id`),
  KEY `FKpocypqt032j9bldxva6hvtkpd` (`restriction_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `requiert`
--

INSERT INTO `requiert` (`b_id`, `restriction_id`, `value`) VALUES
(104, 1, NULL),
(105, 106, NULL),
(107, 1, '10'),
(108, 109, ''),
(114, 1, '100'),
(115, 116, ''),
(131, 2, '10'),
(132, 2, '10'),
(133, 1, '10'),
(134, 2, '10'),
(135, 2, '10'),
(136, 1, '10'),
(137, 1, '100'),
(138, 1, '100'),
(139, 2, '100'),
(140, 2, '8'),
(141, 2, '10'),
(142, 2, '25'),
(143, 1, '10'),
(147, 1, '12'),
(149, 1, '12');

-- --------------------------------------------------------

--
-- Structure de la table `restriction`
--

DROP TABLE IF EXISTS `restriction`;
CREATE TABLE IF NOT EXISTS `restriction` (
  `restriction_id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`restriction_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `restriction`
--

INSERT INTO `restriction` (`restriction_id`, `nom`) VALUES
(1, 'AgeMin'),
(2, 'AgeMax');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `r_id` bigint(20) NOT NULL,
  `r_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`r_id`, `r_name`) VALUES
(0, 'user'),
(1, 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
  `t_id` bigint(20) NOT NULL,
  `t_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`t_id`, `t_name`) VALUES
(1, 'TypeCool'),
(2, 'TypeOkTier');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `u_id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `solde` double DEFAULT NULL,
  `u_firstname` varchar(255) DEFAULT NULL,
  `u_lastname` varchar(255) DEFAULT NULL,
  `u_mail` varchar(255) DEFAULT NULL,
  `r_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`u_id`),
  KEY `FK7r5uojvlv9i44om29uf4nsxw1` (`r_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`u_id`, `password`, `solde`, `u_firstname`, `u_lastname`, `u_mail`, `r_id`) VALUES
(1, 'userPass', 9950, 'user1', 'user1Last', 'osef@osef.o', 0),
(2, 'adminpass', 100, 'admin', 'adminLast', 'idk@idk.i', 1),
(0, 'azeazeaz', NULL, NULL, NULL, NULL, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
