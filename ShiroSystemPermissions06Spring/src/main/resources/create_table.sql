-- --------------------------------------------------------
-- ����:                           127.0.0.1
-- �������汾:                        5.6.26 - MySQL Community Server (GPL)
-- ����������ϵͳ:                      Win64
-- HeidiSQL �汾:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- ���� test �����ݿ�ṹ
USE `test`;

-- ����  �� test.tb_resource �ṹ
DROP TABLE IF EXISTS `tb_resource`;
CREATE TABLE IF NOT EXISTS `tb_resource` (
  `resourceId` bigint(20) NOT NULL AUTO_INCREMENT,
  `resourceName` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resourceId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ���ڵ�����  test.tb_resource �����ݣ�~18 rows (��Լ)
/*!40000 ALTER TABLE `tb_resource` DISABLE KEYS */;
INSERT INTO `tb_resource` (`resourceId`, `resourceName`, `status`, `url`) VALUES
	(4, 'admin:*', 0, 'xxx.png'),
	(5, 'admin:list', 0, 'xxx.png'),
	(6, 'admin:get', 0, 'xxx.png'),
	(7, 'admin:remove', 0, 'xxx.png'),
	(8, 'admin:save', 0, 'xxx.png'),
	(9, 'admin:edit', 0, 'xxx.png'),
	(10, 'student:*', 0, 'xxx.png'),
	(11, 'student:list', 0, 'xxx.png'),
	(12, 'student:get', 0, 'xxx.png'),
	(13, 'student:remove', 0, 'xxx.png'),
	(14, 'student:save', 0, 'xxx.png'),
	(15, 'student:edit', 0, 'xxx.png'),
	(16, 'teacher:*', 0, 'xxx.png'),
	(17, 'teacher:list', 0, 'xxx.png'),
	(18, 'teacher:get', 0, 'xxx.png'),
	(19, 'teacher:remove', 0, 'xxx.png'),
	(20, 'teacher:save', 0, 'xxx.png'),
	(21, 'teacher:edit', 0, 'xxx.png');
/*!40000 ALTER TABLE `tb_resource` ENABLE KEYS */;

-- ����  �� test.tb_role �ṹ
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE IF NOT EXISTS `tb_role` (
  `roleId` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ���ڵ�����  test.tb_role �����ݣ�~3 rows (��Լ)
/*!40000 ALTER TABLE `tb_role` DISABLE KEYS */;
INSERT INTO `tb_role` (`roleId`, `roleName`, `status`, `url`) VALUES
	(1, 'admin', 0, 'xxx.png'),
	(2, 'student', 0, 'xxx.png'),
	(3, 'teacher', 0, 'xxx.png');
/*!40000 ALTER TABLE `tb_role` ENABLE KEYS */;

-- ����  �� test.tb_role_resource �ṹ
DROP TABLE IF EXISTS `tb_role_resource`;
CREATE TABLE IF NOT EXISTS `tb_role_resource` (
  `t_roleId` bigint(20) NOT NULL,
  `t_resourceId` bigint(20) NOT NULL,
  PRIMARY KEY (`t_resourceId`,`t_roleId`),
  KEY `FK_o95ig7dean4fi2hpv25pbc6no` (`t_roleId`),
  CONSTRAINT `FK_m2o8ydxirxpprfunbwk36jdct` FOREIGN KEY (`t_resourceId`) REFERENCES `tb_resource` (`resourceId`),
  CONSTRAINT `FK_o95ig7dean4fi2hpv25pbc6no` FOREIGN KEY (`t_roleId`) REFERENCES `tb_role` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ���ڵ�����  test.tb_role_resource �����ݣ�~12 rows (��Լ)
/*!40000 ALTER TABLE `tb_role_resource` DISABLE KEYS */;
INSERT INTO `tb_role_resource` (`t_roleId`, `t_resourceId`) VALUES
	(1, 4),
	(1, 10),
	(1, 16),
	(2, 10),
	(2, 11),
	(3, 16);
/*!40000 ALTER TABLE `tb_role_resource` ENABLE KEYS */;

-- ����  �� test.tb_user �ṹ
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE IF NOT EXISTS `tb_user` (
  `userId` bigint(20) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ���ڵ�����  test.tb_user �����ݣ�~3 rows (��Լ)
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` (`userId`, `userName`, `password`, `status`) VALUES
	(8, 'jack', '123456', 0),
	(9, 'arvin', '123456', 0),
	(10, 'mike', '123456', 0);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;

-- ����  �� test.tb_user_role �ṹ
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE IF NOT EXISTS `tb_user_role` (
  `t_userId` bigint(20) NOT NULL,
  `t_roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`t_roleId`,`t_userId`),
  KEY `FK_s7thve8mq1lfoo2upg3rbt28j` (`t_userId`),
  CONSTRAINT `FK_1j5hreuhhyrxadfxo48s4reon` FOREIGN KEY (`t_roleId`) REFERENCES `tb_role` (`roleId`),
  CONSTRAINT `FK_s7thve8mq1lfoo2upg3rbt28j` FOREIGN KEY (`t_userId`) REFERENCES `tb_user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ���ڵ�����  test.tb_user_role �����ݣ�~0 rows (��Լ)
/*!40000 ALTER TABLE `tb_user_role` DISABLE KEYS */;
INSERT INTO `tb_user_role` (`t_userId`, `t_roleId`) VALUES
	(8, 2),
	(9, 1),
	(10, 3);
/*!40000 ALTER TABLE `tb_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
