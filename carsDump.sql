-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.6.21-log - MySQL Community Server (GPL)
-- ОС Сервера:                   Win32
-- HeidiSQL Версия:              8.3.0.4796
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- Дамп данных таблицы carrenta.cars: ~2 rows (приблизительно)
DELETE FROM `cars`;
/*!40000 ALTER TABLE `cars` DISABLE KEYS */;
INSERT INTO `cars` (`id`, `image`, `group`, `enabled`, `name`, `marka`, `last_used`, `number`) VALUES
	(1, 'resourses', 1, 1, 'ferary gala', 'ferrary', NULL, '9867876'),
	(2, 'adda', 1, 1, 'Mersedes Agricol', 'Merseedes', '2015-01-21 15:42:48', '90897987');
/*!40000 ALTER TABLE `cars` ENABLE KEYS */;

-- Дамп данных таблицы carrenta.group: ~3 rows (приблизительно)
DELETE FROM `group`;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` (`id`, `name`) VALUES
	(1, 'premium'),
	(2, 'buisines'),
	(3, 'second');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;

-- Дамп данных таблицы carrenta.orders: ~0 rows (приблизительно)
DELETE FROM `orders`;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Дамп данных таблицы carrenta.roles: ~2 rows (приблизительно)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `name`) VALUES
	(1, 'admin'),
	(2, 'user');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Дамп данных таблицы carrenta.status: ~4 rows (приблизительно)
DELETE FROM `status`;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` (`id`, `name`) VALUES
	(1, 'created'),
	(2, 'in_progress'),
	(3, 'feiled'),
	(4, 'paid');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;

-- Дамп данных таблицы carrenta.users: ~4 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `avatar`, `email`, `passport`, `enabled`, `login`, `password`, `lastLogin`, `name`) VALUES
	(1, 'asdf', 'aasdfsd@mail,uis', 'mt234522', 1, 'Hroback', 'sadfgfdaf23', '2015-01-28 14:33:05', 'Damask'),
	(2, NULL, 'vova@milasdf', 'asdfasdf', 1, 'asdffff', NULL, '2015-01-28 20:56:48', 'aaaaaaddd'),
	(4, NULL, 'asdffff@milasdf1', NULL, 1, 'asdffff1', '123321', '2015-01-28 21:05:21', 'caran1'),
	(5, NULL, 'Roman', 'assfdsasdf', 1, 'Cola', 'sdfsdafdfasdf', '2015-01-29 16:45:43', 'asdfff');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
