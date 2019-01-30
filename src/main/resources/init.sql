
# Dump of table book
# ------------------------------------------------------------

use douban;
DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `score` decimal(3, 1) NOT NULL,
  `image` varchar(256) NOT NULL,
  `originUrl`varchar(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

