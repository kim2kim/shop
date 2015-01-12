
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE DATABASE `myshopnshare8878` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `myshopnshare8878`;



DROP TABLE IF EXISTS `accept_person`;
CREATE TABLE IF NOT EXISTS `accept_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `event_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA50FAA6C1DC9F682` (`event_id`),
  KEY `FKA50FAA6C51EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `postalCode` varchar(255) DEFAULT NULL,
  `primaryAddress` bit(1) NOT NULL,
  `stateOrProvince` varchar(255) DEFAULT NULL,
  `street1` varchar(255) DEFAULT NULL,
  `street2` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `unitNumber` varchar(255) DEFAULT NULL,
  `visibility` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`),
  KEY `FKBB979BF451EC8A23` (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `address` (`id`, `active`, `create_date`, `flags`, `version`, `city`, `country`, `postalCode`, `primaryAddress`, `stateOrProvince`, `street1`, `street2`, `type`, `unitNumber`, `visibility`, `person_id`) VALUES
(1, b'1', '2011-05-07 15:35:24', 0, NULL, 'long beach', 'US', '90887', b'1', 'CA', '123 ar st', '', 'WORK', '', 'PUBLIC', 1);



DROP TABLE IF EXISTS `ads`;
CREATE TABLE IF NOT EXISTS `ads` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `age_range` int(11) DEFAULT NULL,
  `clicks` int(11) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `description` varchar(10000) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `sponsor_site` varchar(255) DEFAULT NULL,
  `glimpse_id` bigint(20) DEFAULT NULL,
  `icon_id` bigint(20) DEFAULT NULL,
  `sponsor_id` bigint(20) DEFAULT NULL,
  `thumbnail_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK178B049E96B2A` (`icon_id`),
  KEY `FK178B0A5AC5E4A` (`glimpse_id`),
  KEY `FK178B04A1F003E` (`sponsor_id`),
  KEY `FK178B0D2F81DD7` (`thumbnail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `ads_tag`;
CREATE TABLE IF NOT EXISTS `ads_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `ads_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBC628F8BC6A693D1` (`ads_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `advice`;
CREATE TABLE IF NOT EXISTS `advice` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAB3E7CF851EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_expired` bit(1) NOT NULL default 0,
  `account_locked` bit(1) NOT NULL default 0,
  `address` varchar(150) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `postal_code` varchar(15) DEFAULT NULL,
  `province` varchar(100) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL, 
  `credentials_expired` bit(1) NOT NULL default 0,
  `enabled` bit(1) NOT NULL default 0,
  `password` varchar(255) NOT NULL,
  `username` varchar(50) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

-- password is password

INSERT INTO `users` (`id`, `account_expired`, `account_locked`, `address`, `city`, `country`, `postal_code`, `province`, `credentials_expired`, `email`, `enabled`, `password`, `username`, `version`) VALUES
(1, b'0', b'0', NULL, NULL, NULL, NULL, NULL, b'0', 'kim2kim@gmail.com', b'1', '$2a$10$g9ciTLcpCML0EMiNXW7.WOGrtakszt9H56N6CQXiQB7tmbNU5uWdu', 'kim2kim@gmail.com', 0);



DROP TABLE IF EXISTS `authorities`;
CREATE TABLE IF NOT EXISTS `authorities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `authority` varchar(50) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `authorities` (`id`, `active`, `create_date`, `flags`, `version`, `authority`, `username`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, 'ROLE_MERCHANT', 'kim2kim@gmail.com');



DROP TABLE IF EXISTS `balance`;
CREATE TABLE IF NOT EXISTS `balance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `paid` bit(1) NOT NULL default 0,
  `start_date` datetime DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEBC86EDC51EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `bank`;
CREATE TABLE IF NOT EXISTS `bank` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `discounts` int(11) DEFAULT NULL,
  `last_loggedin` datetime DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2E063C51EC8A23` (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `bank` (`id`, `active`, `create_date`, `flags`, `version`, `balance`, `discounts`, `last_loggedin`, `points`, `person_id`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, 1000, 0, '2011-05-07 15:35:44', 0, 1);



DROP TABLE IF EXISTS `cart_item`;
CREATE TABLE IF NOT EXISTS `cart_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `shoppingCart_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCADACD2E1EF524B` (`item_id`),
  KEY `FKCADACD251EC8A23` (`person_id`),
  KEY `FKCADACD2DCB2C2A3` (`shoppingCart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `comment`;
CREATE TABLE IF NOT EXISTS `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `message` varchar(1000) DEFAULT NULL,
  `securityLevel` varchar(255) DEFAULT NULL,
  `commenter_id` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK38A5EE5F4ED1AECC` (`commenter_id`),
  KEY `FK38A5EE5FCFF017A3` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `commercial`;
CREATE TABLE IF NOT EXISTS `commercial` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `file_format` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK35C8BB4ACFF017A3` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `commercial_tag`;
CREATE TABLE IF NOT EXISTS `commercial_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `commercial_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6132F5255A941D83` (`commercial_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `confirm_email`;
CREATE TABLE IF NOT EXISTS `confirm_email` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `authority` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `random_key` varchar(255) NOT NULL,
  `emailAddress_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `random_key` (`random_key`),
  UNIQUE KEY `email` (`email`),
  KEY `FK2277855D616C4463` (`emailAddress_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `confirm_email` (`id`, `active`, `create_date`, `flags`, `version`, `authority`, `email`, `password`, `random_key`, `emailAddress_id`) VALUES
(1, b'1', '2011-05-07 15:35:24', 0, NULL, 'ROLE_MERCHANT', 'kim2kim@gmail.com', '1111', '210563586', 1);



DROP TABLE IF EXISTS `considering_person`;
CREATE TABLE IF NOT EXISTS `considering_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `event_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK87D798CB1DC9F682` (`event_id`),
  KEY `FK87D798CB51EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `contact`;
CREATE TABLE IF NOT EXISTS `contact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `message` varchar(2000) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `counter`;
CREATE TABLE IF NOT EXISTS `counter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `count` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `counter` (`id`, `active`, `create_date`, `flags`, `version`, `count`, `name`) VALUES
(1, b'1', '2011-05-07 15:13:12', 0, NULL, 11, 'GENERAL');



DROP TABLE IF EXISTS `credit_card`;
CREATE TABLE IF NOT EXISTS `credit_card` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `card_name` varchar(255) DEFAULT NULL,
  `expiration_date` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `security_code` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `cardAddress_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEDE47C9651EC8A23` (`person_id`),
  KEY `FKEDE47C9645FEA0E1` (`cardAddress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `customize`;
CREATE TABLE IF NOT EXISTS `customize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `background_color` varchar(255) DEFAULT NULL,
  `background_image` varchar(255) DEFAULT NULL,
  `skin` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK600E8C4351EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `decline_person`;
CREATE TABLE IF NOT EXISTS `decline_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `event_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK683414BE1DC9F682` (`event_id`),
  KEY `FK683414BE51EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `education`;
CREATE TABLE IF NOT EXISTS `education` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `end_year` varchar(255) DEFAULT NULL,
  `graduation_date` datetime DEFAULT NULL,
  `institution_name` varchar(255) DEFAULT NULL,
  `institutionType` int(11) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `start_year` varchar(255) DEFAULT NULL,
  `institution_id` bigint(20) DEFAULT NULL,
  `profile_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEEAB67A8E2250FD1` (`institution_id`),
  KEY `FKEEAB67A89771E1B1` (`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `email_address`;
CREATE TABLE IF NOT EXISTS `email_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `primaryEmail` bit(1) NOT NULL default 0,
  `type` varchar(255) DEFAULT NULL,
  `visibility` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `FKD222325151EC8A23` (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `email_address` (`id`, `active`, `create_date`, `flags`, `version`, `email`, `primaryEmail`, `type`, `visibility`, `person_id`) VALUES
(1, b'1', '2011-05-07 15:35:24', 0, NULL, 'kim2kim@gmail.com', b'1', NULL, 'PRIVATE', 1);



DROP TABLE IF EXISTS `employer`;
CREATE TABLE IF NOT EXISTS `employer` (
  `company_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4722E6BB1F11FCF9` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `employer` (`company_name`, `description`, `id`) VALUES
('Sleekswap', 'Cool', 1);



DROP TABLE IF EXISTS `employment`;
CREATE TABLE IF NOT EXISTS `employment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `division` varchar(255) DEFAULT NULL,
  `emloyer_name` varchar(255) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `employer_id` bigint(20) DEFAULT NULL,
  `profile_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKA07A3EC5900A23` (`employer_id`),
  KEY `FKA07A3EC9771E1B1` (`profile_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `event_tag`;
CREATE TABLE IF NOT EXISTS `event_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `event_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1E484751DC9F682` (`event_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `event_visibility`;
CREATE TABLE IF NOT EXISTS `event_visibility` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `event_id` bigint(20) DEFAULT NULL,
  `visibilityDomain_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK339081D71DC9F682` (`event_id`),
  KEY `FK339081D7543B3363` (`visibilityDomain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `events`;
CREATE TABLE IF NOT EXISTS `events` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `host` varchar(255) DEFAULT NULL,
  `listVisibility` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB307E11951EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `events_comment`;
CREATE TABLE IF NOT EXISTS `events_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL,
  `event_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK217B4D391DC9F682` (`event_id`),
  KEY `FK217B4D3951EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `face`;
CREATE TABLE IF NOT EXISTS `face` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `caption` varchar(256) DEFAULT NULL,
  `default_face` bit(1) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `glimpse_id` bigint(20) DEFAULT NULL,
  `icon_id` bigint(20) DEFAULT NULL,
  `mini_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `thumbnail_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2FD65D27AF0E8C` (`mini_id`),
  KEY `FK2FD65D49E96B2A` (`icon_id`),
  KEY `FK2FD65DA5AC5E4A` (`glimpse_id`),
  KEY `FK2FD65D51EC8A23` (`person_id`),
  KEY `FK2FD65DD2F81DD7` (`thumbnail_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `face` (`id`, `active`, `create_date`, `flags`, `version`, `caption`, `default_face`, `type`, `glimpse_id`, `icon_id`, `mini_id`, `person_id`, `thumbnail_id`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, NULL, b'1', 'BUSINESS_SERVICE', 1, 2, 3, 1, 4);



DROP TABLE IF EXISTS `favorite_ad`;
CREATE TABLE IF NOT EXISTS `favorite_ad` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `default_favorite` bit(1) DEFAULT NULL,
  `ads_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8D65F1A651EC8A23` (`person_id`),
  KEY `FK8D65F1A6C6A693D1` (`ads_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `friend`;
CREATE TABLE IF NOT EXISTS `friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `friend_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB4860A9E51EC8A23` (`person_id`),
  KEY `FKB4860A9ED9A0EA3A` (`friend_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `friend_visibility`;
CREATE TABLE IF NOT EXISTS `friend_visibility` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `friend_id` bigint(20) DEFAULT NULL,
  `visibilityDomain_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC0687F53C9435983` (`friend_id`),
  KEY `FKC0687F53543B3363` (`visibilityDomain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `group_person`;
CREATE TABLE IF NOT EXISTS `group_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `permissionVisibility_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEE47251551EC8A23` (`person_id`),
  KEY `FKEE47251591EC3F03` (`permissionVisibility_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `guest_person`;
CREATE TABLE IF NOT EXISTS `guest_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `event_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9912A79C1DC9F682` (`event_id`),
  KEY `FK9912A79C51EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `headline`;
CREATE TABLE IF NOT EXISTS `headline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `headline` varchar(500) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBD898DD451EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `institution`;
CREATE TABLE IF NOT EXISTS `institution` (
  `description` varchar(255) DEFAULT NULL,
  `institution_name` varchar(255) DEFAULT NULL,
  `institution_type` int(11) DEFAULT NULL,
  `mascot` varchar(255) DEFAULT NULL,
  `school_district` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3529A5B81F11FCF9` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;





DROP TABLE IF EXISTS `ipaddress`;
CREATE TABLE IF NOT EXISTS `ipaddress` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `last_loggedin` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `counter_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFE2CC4EDE7541CD1` (`counter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `external_link` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `resource_link` varchar(255) DEFAULT NULL,
  `subscribed` bit(1) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `visited` int(11) DEFAULT NULL,
  `yes_no` bit(1) DEFAULT NULL,
  `glimpse_id` bigint(20) DEFAULT NULL,
  `icon_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `thumbnail_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK317B1349E96B2A` (`icon_id`),
  KEY `FK317B13A5AC5E4A` (`glimpse_id`),
  KEY `FK317B1351EC8A23` (`person_id`),
  KEY `FK317B13D2F81DD7` (`thumbnail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `item_category`;
CREATE TABLE IF NOT EXISTS `item_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1A2438AACFF017A3` (`item_id`),
  KEY `FK1A2438AA51EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `item_order_detail`;
CREATE TABLE IF NOT EXISTS `item_order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `invoice` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tracking_number` varchar(255) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `orderDetail_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9112200EE1EF524B` (`item_id`),
  KEY `FK9112200E51EC8A23` (`person_id`),
  KEY `FK9112200E926F6E91` (`orderDetail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `item_rating`;
CREATE TABLE IF NOT EXISTS `item_rating` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE67A2849CFF017A3` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `item_tag`;
CREATE TABLE IF NOT EXISTS `item_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4634A86ECFF017A3` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `item_visibility_domain`;
CREATE TABLE IF NOT EXISTS `item_visibility_domain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `visibilityDomain_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK90CE1C65CFF017A3` (`item_id`),
  KEY `FK90CE1C65543B3363` (`visibilityDomain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `journal`;
CREATE TABLE IF NOT EXISTS `journal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `entry` varchar(1000) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAB64AF3751EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `journal_tag`;
CREATE TABLE IF NOT EXISTS `journal_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `journal_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFEA92A92D0C44EF1` (`journal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `journal_visibility`;
CREATE TABLE IF NOT EXISTS `journal_visibility` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `journal_id` bigint(20) DEFAULT NULL,
  `visibilityDomain_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD9E7311A543B3363` (`visibilityDomain_id`),
  KEY `FKD9E7311AD0C44EF1` (`journal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `line_item_detail`;
CREATE TABLE IF NOT EXISTS `line_item_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `balance_id` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD5414F32CFF017A3` (`item_id`),
  KEY `FKD5414F322902F0D1` (`balance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `merchant`;
CREATE TABLE IF NOT EXISTS `merchant` (
  `merchant_name` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE1E1C9C81F11FCF9` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;





DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  `message` varchar(2000) DEFAULT NULL,
  `world` bit(1) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK338AD351EC8A23` (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `news` (`id`, `active`, `create_date`, `flags`, `version`, `action`, `message`, `world`, `person_id`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, 'NEW_EMPLOYER', '<ul><li><img src="../faces/default/icons/icon-myshopnshare-biz.png" alt="Sleekswap" title="SleekSwap has a new business, Sleekswap"/></a></li><li><a style="clear: both; float: none;" href="friendPage.do?friendId=1">Sleekswap</a></li></ul><span style="vertical-align: top;padding-left: 5px;"><p style="width: 400px;"> SleekSwap has a new business, Sleekswap</p></span>', b'1', 1);



DROP TABLE IF EXISTS `news_comment`;
CREATE TABLE IF NOT EXISTS `news_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `message` varchar(500) DEFAULT NULL,
  `security_level` varchar(255) DEFAULT NULL,
  `commenter_id` bigint(20) DEFAULT NULL,
  `news_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFAA69CF34ED1AECC` (`commenter_id`),
  KEY `FKFAA69CF3BFD8FFA3` (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `news_visibility_domain`;
CREATE TABLE IF NOT EXISTS `news_visibility_domain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `news_id` bigint(20) DEFAULT NULL,
  `visibilityDomain_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8FD3BC25BFD8FFA3` (`news_id`),
  KEY `FK8FD3BC25543B3363` (`visibilityDomain_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;


INSERT INTO `news_visibility_domain` (`id`, `active`, `create_date`, `flags`, `version`, `news_id`, `visibilityDomain_id`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 9),
(2, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 1);



DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `buyer_id` bigint(20) DEFAULT NULL,
  `payment_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK23AE5A621CDB2891` (`payment_id`),
  KEY `FK23AE5A6251EC8A23` (`person_id`),
  KEY `FK23AE5A62E4BD1F05` (`buyer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `page_viewed`;
CREATE TABLE IF NOT EXISTS `page_viewed` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `count` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC8049DB451EC8A23` (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `page_viewed` (`id`, `active`, `create_date`, `flags`, `version`, `count`, `name`, `person_id`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, 0, NULL, 1);



DROP TABLE IF EXISTS `payment`;
CREATE TABLE IF NOT EXISTS `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `billingAddress_id` bigint(20) DEFAULT NULL,
  `contact_id` bigint(20) DEFAULT NULL,
  `creditCards_id` bigint(20) DEFAULT NULL,
  `paypalAccount_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `shippingAddress_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKD11C32067C849221` (`paypalAccount_id`),
  KEY `FKD11C320651EC8A23` (`person_id`),
  KEY `FKD11C32063B002B22` (`creditCards_id`),
  KEY `FKD11C3206F0920D5F` (`contact_id`),
  KEY `FKD11C320699363E8C` (`billingAddress_id`),
  KEY `FKD11C3206B99ED5FF` (`shippingAddress_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `permission`;
CREATE TABLE IF NOT EXISTS `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE125C5CF51EC8A23` (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;


INSERT INTO `permission` (`id`, `active`, `create_date`, `flags`, `version`, `type`, `person_id`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, 'SCRIBBLE', 1),
(2, b'1', '2011-05-07 15:35:44', 0, NULL, 'WANT', 1),
(3, b'1', '2011-05-07 15:35:44', 0, NULL, 'ADVICE', 1),
(4, b'1', '2011-05-07 15:35:44', 0, NULL, 'SELLING', 1),
(5, b'1', '2011-05-07 15:35:44', 0, NULL, 'BOUGHT', 1),
(6, b'1', '2011-05-07 15:35:44', 0, NULL, 'RECOMMEND', 1),
(7, b'1', '2011-05-07 15:35:44', 0, NULL, 'SERVICE', 1),
(8, b'1', '2011-05-07 15:35:44', 0, NULL, 'NEWS', 1),
(9, b'1', '2011-05-07 15:35:44', 0, NULL, 'JOURNAL', 1),
(10, b'1', '2011-05-07 15:35:44', 0, NULL, 'EVENT', 1),
(11, b'1', '2011-05-07 15:35:44', 0, NULL, 'FRIENDS', 1);



DROP TABLE IF EXISTS `permission_permissionvisibility`;
CREATE TABLE IF NOT EXISTS `permission_permissionvisibility` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  `permissionVisibility_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6092CE9191EC3F03` (`permissionVisibility_id`),
  KEY `FK6092CE91C63C5363` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `permission_visibility`;
CREATE TABLE IF NOT EXISTS `permission_visibility` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `group_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `permissionvisibility_person`;
CREATE TABLE IF NOT EXISTS `permissionvisibility_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `friend_id` bigint(20) DEFAULT NULL,
  `permissionVisibility_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFE7FAF3391EC3F03` (`permissionVisibility_id`),
  KEY `FKFE7FAF33D9A0EA3A` (`friend_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `online` int(11) DEFAULT NULL,
  `subscribed` bit(1) NOT NULL default 0,
  `subscriptionType` varchar(255) DEFAULT NULL,
  `user_type` varchar(255) DEFAULT NULL,
  `username` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC4E39B552302BA74` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `person` (`id`, `active`, `create_date`, `flags`, `version`, `birthday`, `first_name`, `gender`, `last_name`, `online`, `subscribed`, `subscriptionType`, `user_type`, `username`) VALUES
(1, b'1', '2011-05-07 15:35:24', 0, NULL, '2008-05-07 00:00:00', 'khim', NULL, 'ung', NULL, b'0', 'DEFAULT', 'BUSINESS_SERVICE', 1);



DROP TABLE IF EXISTS `person_tag`;
CREATE TABLE IF NOT EXISTS `person_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2878D7B051EC8A23` (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;


INSERT INTO `person_tag` (`id`, `active`, `create_date`, `flags`, `version`, `description`, `tag`, `person_id`) VALUES
(1, b'1', '2011-05-07 15:35:24', 0, NULL, NULL, 'Sleekswap', 1),
(2, b'1', '2011-05-07 15:35:24', 0, NULL, NULL, 'Cool', 1);



DROP TABLE IF EXISTS `person_visibility_domain`;
CREATE TABLE IF NOT EXISTS `person_visibility_domain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `visibilityDomain_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9F25702751EC8A23` (`person_id`),
  KEY `FK9F257027543B3363` (`visibilityDomain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `phone`;
CREATE TABLE IF NOT EXISTS `phone` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `country_code` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `primary_phone` bit(1) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `visibility` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK65B3D6E51EC8A23` (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `photo`;
CREATE TABLE IF NOT EXISTS `photo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `content` longblob,
  `path` varchar(255) DEFAULT NULL,
  `system` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;


INSERT INTO `photo` (`id`, `active`, `create_date`, `flags`, `version`, `content`, `path`, `system`) VALUES
(1, b'1', '2011-05-07 15:25:39', 0, NULL, NULL, 'faces/default/glimpses/glimpse-myshopnshare-biz.png', 'Local'),
(2, b'1', '2011-05-07 15:25:39', 0, NULL, NULL, 'faces/default/icons/icon-myshopnshare-biz.png', 'Local'),
(3, b'1', '2011-05-07 15:25:39', 0, NULL, NULL, 'faces/default/minis/mini-myshopnshare-biz.png', 'Local'),
(4, b'1', '2011-05-07 15:25:39', 0, NULL, NULL, 'faces/default/thumbs/thumb-myshopnshare-biz.png', 'Local');



DROP TABLE IF EXISTS `photo_category`;
CREATE TABLE IF NOT EXISTS `photo_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `photo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK782A886B9C47E2D1` (`photo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `point_item`;
CREATE TABLE IF NOT EXISTS `point_item` (
  `price` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `redeemable_points` int(11) DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `shipping` float DEFAULT NULL,
  `tax` float DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4B74D86251CD6AF7` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;





DROP TABLE IF EXISTS `point_item_order_detail`;
CREATE TABLE IF NOT EXISTS `point_item_order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `invoice` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tracking_number` varchar(255) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `orderDetail_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK305F1B1F50DE2961` (`item_id`),
  KEY `FK305F1B1F51EC8A23` (`person_id`),
  KEY `FK305F1B1F926F6E91` (`orderDetail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `profile`;
CREATE TABLE IF NOT EXISTS `profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `about` varchar(500) DEFAULT NULL,
  `activities` varchar(500) DEFAULT NULL,
  `aim` varchar(255) DEFAULT NULL,
  `expertise` varchar(500) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKED8E89A951EC8A23` (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `profile` (`id`, `active`, `create_date`, `flags`, `version`, `about`, `activities`, `aim`, `expertise`, `language`, `person_id`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, NULL, NULL, NULL, NULL, NULL, 1);



DROP TABLE IF EXISTS `rating`;
CREATE TABLE IF NOT EXISTS `rating` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC815B19D51EC8A23` (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `rating` (`id`, `active`, `create_date`, `flags`, `version`, `count`, `rating`, `person_id`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 5, 1);



DROP TABLE IF EXISTS `request_friend`;
CREATE TABLE IF NOT EXISTS `request_friend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `confirm_friend` bit(1) DEFAULT NULL,
  `expired` bit(1) NOT NULL default 0,
  `reject_friend` bit(1) DEFAULT NULL,
  `request_date` datetime DEFAULT NULL,
  `potentialFriend_id` bigint(20) DEFAULT NULL,
  `requester_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK841AE64E3EF06BDC` (`potentialFriend_id`),
  KEY `FK841AE64E6D13C89C` (`requester_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `reward_cart`;
CREATE TABLE IF NOT EXISTS `reward_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `shoppingCart_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK35870A3050DE2961` (`item_id`),
  KEY `FK35870A3051EC8A23` (`person_id`),
  KEY `FK35870A30DCB2C2A3` (`shoppingCart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(64) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;


INSERT INTO `role` (`id`, `description`, `name`) VALUES
(1, '', 'ROLE_ADMIN'),
(2, '', 'ROLE_USER'),
(3, 'ROLE_MERCHANT', 'ROLE_MERCHANT'),
(4, '', 'ROLE_ADS');



DROP TABLE IF EXISTS `scribble`;
CREATE TABLE IF NOT EXISTS `scribble` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `has_read` bit(1) DEFAULT NULL,
  `message` varchar(1000) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `scribbler_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKE7AE36C051EC8A23` (`person_id`),
  KEY `FKE7AE36C0837C0AA6` (`scribbler_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `scribble_tag`;
CREATE TABLE IF NOT EXISTS `scribble_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `tag` varchar(255) DEFAULT NULL,
  `scribble_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6461C59B5A105003` (`scribble_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `scribble_visibility_domain`;
CREATE TABLE IF NOT EXISTS `scribble_visibility_domain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `scribble_id` bigint(20) DEFAULT NULL,
  `visibilityDomain_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK82D626D25A105003` (`scribble_id`),
  KEY `FK82D626D2543B3363` (`visibilityDomain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE IF NOT EXISTS `shopping_cart` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9DB7E39751EC8A23` (`person_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;


INSERT INTO `shopping_cart` (`id`, `active`, `create_date`, `flags`, `version`, `person_id`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, 1);



DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK143BF46A84E95BCD` (`role_id`),
  KEY `FK143BF46A2A141FAD` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 3);



DROP TABLE IF EXISTS `vendor`;
CREATE TABLE IF NOT EXISTS `vendor` (
  `company_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCF1EA5481F11FCF9` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;





DROP TABLE IF EXISTS `vendor_item`;
CREATE TABLE IF NOT EXISTS `vendor_item` (
  `clearance_percentage` int(11) DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `rebate_amount` int(11) DEFAULT NULL,
  `redeemable_points` int(11) DEFAULT NULL,
  `refuberish` bit(1) NOT NULL default 0,
  `serial_number` varchar(255) DEFAULT NULL,
  `shipping` float DEFAULT NULL,
  `tax` float DEFAULT NULL,
  `used` bit(1) NOT NULL default 0,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3899BAA51CD6AF7` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;





DROP TABLE IF EXISTS `vendor_item_visibility_domain`;
CREATE TABLE IF NOT EXISTS `vendor_item_visibility_domain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `visibilityDomain_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9DDE53CE1EF524B` (`item_id`),
  KEY `FK9DDE53C543B3363` (`visibilityDomain_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;





DROP TABLE IF EXISTS `visibility_domain`;
CREATE TABLE IF NOT EXISTS `visibility_domain` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `activity_type` varchar(255) DEFAULT NULL,
  `default_visibility` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `visibility` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;


INSERT INTO `visibility_domain` (`id`, `active`, `create_date`, `flags`, `version`, `activity_type`, `default_visibility`, `name`, `visibility`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, 'ALL', b'1', 'DEFAULT', 'PUBLIC'),
(2, b'1', '2011-05-07 15:35:44', 0, NULL, 'SCRIBBLE', b'0', 'DEFAULT', 'CUSTOM'),
(3, b'1', '2011-05-07 15:35:44', 0, NULL, 'WANT', b'0', 'DEFAULT', 'CUSTOM'),
(4, b'1', '2011-05-07 15:35:44', 0, NULL, 'ADVICE', b'0', 'DEFAULT', 'CUSTOM'),
(5, b'1', '2011-05-07 15:35:44', 0, NULL, 'SELLING', b'0', 'DEFAULT', 'CUSTOM'),
(6, b'1', '2011-05-07 15:35:44', 0, NULL, 'BOUGHT', b'0', 'DEFAULT', 'CUSTOM'),
(7, b'1', '2011-05-07 15:35:44', 0, NULL, 'RECOMMEND', b'0', 'DEFAULT', 'CUSTOM'),
(8, b'1', '2011-05-07 15:35:44', 0, NULL, 'SERVICE', b'0', 'DEFAULT', 'CUSTOM'),
(9, b'1', '2011-05-07 15:35:44', 0, NULL, 'NEWS', b'0', 'DEFAULT', 'CUSTOM'),
(10, b'1', '2011-05-07 15:35:44', 0, NULL, 'JOURNAL', b'0', 'DEFAULT', 'CUSTOM'),
(11, b'1', '2011-05-07 15:35:44', 0, NULL, 'EVENT', b'0', 'DEFAULT', 'CUSTOM'),
(12, b'1', '2011-05-07 15:35:44', 0, NULL, 'FRIENDS', b'0', 'DEFAULT', 'CUSTOM');



DROP TABLE IF EXISTS `visibilitydomain_person`;
CREATE TABLE IF NOT EXISTS `visibilitydomain_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `visibilityDomain_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBA2A495E51EC8A23` (`person_id`),
  KEY `FKBA2A495E543B3363` (`visibilityDomain_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;


INSERT INTO `visibilitydomain_person` (`id`, `active`, `create_date`, `flags`, `version`, `person_id`, `visibilityDomain_id`) VALUES
(1, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 1),
(2, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 2),
(3, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 3),
(4, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 4),
(5, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 5),
(6, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 6),
(7, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 7),
(8, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 8),
(9, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 9),
(10, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 10),
(11, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 11),
(12, b'1', '2011-05-07 15:35:44', 0, NULL, 1, 12);



DROP TABLE IF EXISTS `vote`;
CREATE TABLE IF NOT EXISTS `vote` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL default 0,
  `create_date` datetime DEFAULT NULL,
  `flags` int(11) DEFAULT NULL,
  `version` bigint(20) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `advice_id` bigint(20) DEFAULT NULL,
  `item_id` bigint(20) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3752EACFF017A3` (`item_id`),
  KEY `FK3752EA51EC8A23` (`person_id`),
  KEY `FK3752EAE23F0343` (`advice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;




ALTER TABLE `accept_person`
  ADD CONSTRAINT `FKA50FAA6C1DC9F682` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  ADD CONSTRAINT `FKA50FAA6C51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `address`
  ADD CONSTRAINT `FKBB979BF451EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `ads`
  ADD CONSTRAINT `FK178B049E96B2A` FOREIGN KEY (`icon_id`) REFERENCES `photo` (`id`),
  ADD CONSTRAINT `FK178B04A1F003E` FOREIGN KEY (`sponsor_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK178B0A5AC5E4A` FOREIGN KEY (`glimpse_id`) REFERENCES `photo` (`id`),
  ADD CONSTRAINT `FK178B0D2F81DD7` FOREIGN KEY (`thumbnail_id`) REFERENCES `photo` (`id`);

ALTER TABLE `ads_tag`
  ADD CONSTRAINT `FKBC628F8BC6A693D1` FOREIGN KEY (`ads_id`) REFERENCES `ads` (`id`);

ALTER TABLE `advice`
  ADD CONSTRAINT `FKAB3E7CF851EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `balance`
  ADD CONSTRAINT `FKEBC86EDC51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `bank`
  ADD CONSTRAINT `FK2E063C51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `cart_item`
  ADD CONSTRAINT `FKCADACD251EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FKCADACD2DCB2C2A3` FOREIGN KEY (`shoppingCart_id`) REFERENCES `shopping_cart` (`id`),
  ADD CONSTRAINT `FKCADACD2E1EF524B` FOREIGN KEY (`item_id`) REFERENCES `vendor_item` (`id`);

ALTER TABLE `comment`
  ADD CONSTRAINT `FK38A5EE5F4ED1AECC` FOREIGN KEY (`commenter_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK38A5EE5FCFF017A3` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);

ALTER TABLE `commercial`
  ADD CONSTRAINT `FK35C8BB4ACFF017A3` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);

ALTER TABLE `commercial_tag`
  ADD CONSTRAINT `FK6132F5255A941D83` FOREIGN KEY (`commercial_id`) REFERENCES `commercial` (`id`);

ALTER TABLE `confirm_email`
  ADD CONSTRAINT `FK2277855D616C4463` FOREIGN KEY (`emailAddress_id`) REFERENCES `email_address` (`id`);

ALTER TABLE `considering_person`
  ADD CONSTRAINT `FK87D798CB1DC9F682` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  ADD CONSTRAINT `FK87D798CB51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `credit_card`
  ADD CONSTRAINT `FKEDE47C9645FEA0E1` FOREIGN KEY (`cardAddress_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `FKEDE47C9651EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `customize`
  ADD CONSTRAINT `FK600E8C4351EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `decline_person`
  ADD CONSTRAINT `FK683414BE1DC9F682` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  ADD CONSTRAINT `FK683414BE51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `education`
  ADD CONSTRAINT `FKEEAB67A89771E1B1` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`),
  ADD CONSTRAINT `FKEEAB67A8E2250FD1` FOREIGN KEY (`institution_id`) REFERENCES `institution` (`id`);

ALTER TABLE `email_address`
  ADD CONSTRAINT `FKD222325151EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `employer`
  ADD CONSTRAINT `FK4722E6BB1F11FCF9` FOREIGN KEY (`id`) REFERENCES `person` (`id`);

ALTER TABLE `employment`
  ADD CONSTRAINT `FKA07A3EC5900A23` FOREIGN KEY (`employer_id`) REFERENCES `employer` (`id`),
  ADD CONSTRAINT `FKA07A3EC9771E1B1` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`);

ALTER TABLE `event_tag`
  ADD CONSTRAINT `FK1E484751DC9F682` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`);

ALTER TABLE `event_visibility`
  ADD CONSTRAINT `FK339081D71DC9F682` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  ADD CONSTRAINT `FK339081D7543B3363` FOREIGN KEY (`visibilityDomain_id`) REFERENCES `visibility_domain` (`id`);

ALTER TABLE `events`
  ADD CONSTRAINT `FKB307E11951EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `events_comment`
  ADD CONSTRAINT `FK217B4D391DC9F682` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  ADD CONSTRAINT `FK217B4D3951EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `face`
  ADD CONSTRAINT `FK2FD65D27AF0E8C` FOREIGN KEY (`mini_id`) REFERENCES `photo` (`id`),
  ADD CONSTRAINT `FK2FD65D49E96B2A` FOREIGN KEY (`icon_id`) REFERENCES `photo` (`id`),
  ADD CONSTRAINT `FK2FD65D51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK2FD65DA5AC5E4A` FOREIGN KEY (`glimpse_id`) REFERENCES `photo` (`id`),
  ADD CONSTRAINT `FK2FD65DD2F81DD7` FOREIGN KEY (`thumbnail_id`) REFERENCES `photo` (`id`);

ALTER TABLE `favorite_ad`
  ADD CONSTRAINT `FK8D65F1A651EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK8D65F1A6C6A693D1` FOREIGN KEY (`ads_id`) REFERENCES `ads` (`id`);

ALTER TABLE `friend`
  ADD CONSTRAINT `FKB4860A9E51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FKB4860A9ED9A0EA3A` FOREIGN KEY (`friend_id`) REFERENCES `person` (`id`);

ALTER TABLE `friend_visibility`
  ADD CONSTRAINT `FKC0687F53543B3363` FOREIGN KEY (`visibilityDomain_id`) REFERENCES `visibility_domain` (`id`),
  ADD CONSTRAINT `FKC0687F53C9435983` FOREIGN KEY (`friend_id`) REFERENCES `friend` (`id`);

ALTER TABLE `group_person`
  ADD CONSTRAINT `FKEE47251551EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FKEE47251591EC3F03` FOREIGN KEY (`permissionVisibility_id`) REFERENCES `permission_visibility` (`id`);

ALTER TABLE `guest_person`
  ADD CONSTRAINT `FK9912A79C1DC9F682` FOREIGN KEY (`event_id`) REFERENCES `events` (`id`),
  ADD CONSTRAINT `FK9912A79C51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `headline`
  ADD CONSTRAINT `FKBD898DD451EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `institution`
  ADD CONSTRAINT `FK3529A5B81F11FCF9` FOREIGN KEY (`id`) REFERENCES `person` (`id`);

ALTER TABLE `ipaddress`
  ADD CONSTRAINT `FKFE2CC4EDE7541CD1` FOREIGN KEY (`counter_id`) REFERENCES `counter` (`id`);

ALTER TABLE `item`
  ADD CONSTRAINT `FK317B1349E96B2A` FOREIGN KEY (`icon_id`) REFERENCES `photo` (`id`),
  ADD CONSTRAINT `FK317B1351EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK317B13A5AC5E4A` FOREIGN KEY (`glimpse_id`) REFERENCES `photo` (`id`),
  ADD CONSTRAINT `FK317B13D2F81DD7` FOREIGN KEY (`thumbnail_id`) REFERENCES `photo` (`id`);

ALTER TABLE `item_category`
  ADD CONSTRAINT `FK1A2438AA51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK1A2438AACFF017A3` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);

ALTER TABLE `item_order_detail`
  ADD CONSTRAINT `FK9112200E51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK9112200E926F6E91` FOREIGN KEY (`orderDetail_id`) REFERENCES `order_detail` (`id`),
  ADD CONSTRAINT `FK9112200EE1EF524B` FOREIGN KEY (`item_id`) REFERENCES `vendor_item` (`id`);

ALTER TABLE `item_rating`
  ADD CONSTRAINT `FKE67A2849CFF017A3` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);

ALTER TABLE `item_tag`
  ADD CONSTRAINT `FK4634A86ECFF017A3` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);

ALTER TABLE `item_visibility_domain`
  ADD CONSTRAINT `FK90CE1C65543B3363` FOREIGN KEY (`visibilityDomain_id`) REFERENCES `visibility_domain` (`id`),
  ADD CONSTRAINT `FK90CE1C65CFF017A3` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);

ALTER TABLE `journal`
  ADD CONSTRAINT `FKAB64AF3751EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `journal_tag`
  ADD CONSTRAINT `FKFEA92A92D0C44EF1` FOREIGN KEY (`journal_id`) REFERENCES `journal` (`id`);

ALTER TABLE `journal_visibility`
  ADD CONSTRAINT `FKD9E7311A543B3363` FOREIGN KEY (`visibilityDomain_id`) REFERENCES `visibility_domain` (`id`),
  ADD CONSTRAINT `FKD9E7311AD0C44EF1` FOREIGN KEY (`journal_id`) REFERENCES `journal` (`id`);

ALTER TABLE `line_item_detail`
  ADD CONSTRAINT `FKD5414F322902F0D1` FOREIGN KEY (`balance_id`) REFERENCES `balance` (`id`),
  ADD CONSTRAINT `FKD5414F32CFF017A3` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`);

ALTER TABLE `merchant`
  ADD CONSTRAINT `FKE1E1C9C81F11FCF9` FOREIGN KEY (`id`) REFERENCES `person` (`id`);

ALTER TABLE `news`
  ADD CONSTRAINT `FK338AD351EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `news_comment`
  ADD CONSTRAINT `FKFAA69CF34ED1AECC` FOREIGN KEY (`commenter_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FKFAA69CF3BFD8FFA3` FOREIGN KEY (`news_id`) REFERENCES `news` (`id`);

ALTER TABLE `news_visibility_domain`
  ADD CONSTRAINT `FK8FD3BC25543B3363` FOREIGN KEY (`visibilityDomain_id`) REFERENCES `visibility_domain` (`id`),
  ADD CONSTRAINT `FK8FD3BC25BFD8FFA3` FOREIGN KEY (`news_id`) REFERENCES `news` (`id`);

ALTER TABLE `order_detail`
  ADD CONSTRAINT `FK23AE5A621CDB2891` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`),
  ADD CONSTRAINT `FK23AE5A6251EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK23AE5A62E4BD1F05` FOREIGN KEY (`buyer_id`) REFERENCES `person` (`id`);

ALTER TABLE `page_viewed`
  ADD CONSTRAINT `FKC8049DB451EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `payment`
  ADD CONSTRAINT `FKD11C32063B002B22` FOREIGN KEY (`creditCards_id`) REFERENCES `credit_card` (`id`),
  ADD CONSTRAINT `FKD11C320651EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FKD11C32067C849221` FOREIGN KEY (`paypalAccount_id`) REFERENCES `email_address` (`id`),
  ADD CONSTRAINT `FKD11C320699363E8C` FOREIGN KEY (`billingAddress_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `FKD11C3206B99ED5FF` FOREIGN KEY (`shippingAddress_id`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `FKD11C3206F0920D5F` FOREIGN KEY (`contact_id`) REFERENCES `phone` (`id`);

ALTER TABLE `permission`
  ADD CONSTRAINT `FKE125C5CF51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `permission_permissionvisibility`
  ADD CONSTRAINT `FK6092CE9191EC3F03` FOREIGN KEY (`permissionVisibility_id`) REFERENCES `permission_visibility` (`id`),
  ADD CONSTRAINT `FK6092CE91C63C5363` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`);

ALTER TABLE `permissionvisibility_person`
  ADD CONSTRAINT `FKFE7FAF3391EC3F03` FOREIGN KEY (`permissionVisibility_id`) REFERENCES `permission_visibility` (`id`),
  ADD CONSTRAINT `FKFE7FAF33D9A0EA3A` FOREIGN KEY (`friend_id`) REFERENCES `person` (`id`);

ALTER TABLE `person`
  ADD CONSTRAINT `FKC4E39B552302BA74` FOREIGN KEY (`username`) REFERENCES `users` (`id`);

ALTER TABLE `person_tag`
  ADD CONSTRAINT `FK2878D7B051EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `person_visibility_domain`
  ADD CONSTRAINT `FK9F25702751EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK9F257027543B3363` FOREIGN KEY (`visibilityDomain_id`) REFERENCES `visibility_domain` (`id`);

ALTER TABLE `phone`
  ADD CONSTRAINT `FK65B3D6E51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `photo_category`
  ADD CONSTRAINT `FK782A886B9C47E2D1` FOREIGN KEY (`photo_id`) REFERENCES `photo` (`id`);

ALTER TABLE `point_item`
  ADD CONSTRAINT `FK4B74D86251CD6AF7` FOREIGN KEY (`id`) REFERENCES `item` (`id`);

ALTER TABLE `point_item_order_detail`
  ADD CONSTRAINT `FK305F1B1F50DE2961` FOREIGN KEY (`item_id`) REFERENCES `point_item` (`id`),
  ADD CONSTRAINT `FK305F1B1F51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK305F1B1F926F6E91` FOREIGN KEY (`orderDetail_id`) REFERENCES `order_detail` (`id`);

ALTER TABLE `profile`
  ADD CONSTRAINT `FKED8E89A951EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `rating`
  ADD CONSTRAINT `FKC815B19D51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `request_friend`
  ADD CONSTRAINT `FK841AE64E3EF06BDC` FOREIGN KEY (`potentialFriend_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK841AE64E6D13C89C` FOREIGN KEY (`requester_id`) REFERENCES `person` (`id`);

ALTER TABLE `reward_cart`
  ADD CONSTRAINT `FK35870A3050DE2961` FOREIGN KEY (`item_id`) REFERENCES `point_item` (`id`),
  ADD CONSTRAINT `FK35870A3051EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK35870A30DCB2C2A3` FOREIGN KEY (`shoppingCart_id`) REFERENCES `shopping_cart` (`id`);

ALTER TABLE `scribble`
  ADD CONSTRAINT `FKE7AE36C051EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FKE7AE36C0837C0AA6` FOREIGN KEY (`scribbler_id`) REFERENCES `person` (`id`);

ALTER TABLE `scribble_tag`
  ADD CONSTRAINT `FK6461C59B5A105003` FOREIGN KEY (`scribble_id`) REFERENCES `scribble` (`id`);

ALTER TABLE `scribble_visibility_domain`
  ADD CONSTRAINT `FK82D626D2543B3363` FOREIGN KEY (`visibilityDomain_id`) REFERENCES `visibility_domain` (`id`),
  ADD CONSTRAINT `FK82D626D25A105003` FOREIGN KEY (`scribble_id`) REFERENCES `scribble` (`id`);

ALTER TABLE `shopping_cart`
  ADD CONSTRAINT `FK9DB7E39751EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`);

ALTER TABLE `user_role`
  ADD CONSTRAINT `FK143BF46A2A141FAD` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FK143BF46A84E95BCD` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

ALTER TABLE `vendor`
  ADD CONSTRAINT `FKCF1EA5481F11FCF9` FOREIGN KEY (`id`) REFERENCES `person` (`id`);

ALTER TABLE `vendor_item`
  ADD CONSTRAINT `FK3899BAA51CD6AF7` FOREIGN KEY (`id`) REFERENCES `item` (`id`);

ALTER TABLE `vendor_item_visibility_domain`
  ADD CONSTRAINT `FK9DDE53C543B3363` FOREIGN KEY (`visibilityDomain_id`) REFERENCES `visibility_domain` (`id`),
  ADD CONSTRAINT `FK9DDE53CE1EF524B` FOREIGN KEY (`item_id`) REFERENCES `vendor_item` (`id`);

ALTER TABLE `visibilitydomain_person`
  ADD CONSTRAINT `FKBA2A495E51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FKBA2A495E543B3363` FOREIGN KEY (`visibilityDomain_id`) REFERENCES `visibility_domain` (`id`);

ALTER TABLE `vote`
  ADD CONSTRAINT `FK3752EA51EC8A23` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  ADD CONSTRAINT `FK3752EACFF017A3` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  ADD CONSTRAINT `FK3752EAE23F0343` FOREIGN KEY (`advice_id`) REFERENCES `advice` (`id`);
