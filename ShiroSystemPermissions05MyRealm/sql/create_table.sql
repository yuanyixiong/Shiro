-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.26 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出  表 test.t_permission 结构
CREATE TABLE IF NOT EXISTS `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `permissionname` varchar(50) NOT NULL COMMENT '权限名',
  `role_id` int(11) DEFAULT NULL COMMENT '外键关联role',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- 正在导出表  test.t_permission 的数据：~8 rows (大约)
/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;
INSERT INTO `t_permission` (`id`, `permissionname`, `role_id`) VALUES
	(5, 'student:update', 5),
	(6, 'student:find', 5),
	(7, 'student:*', 6),
	(8, 'teacher:find', 6),
	(9, 'teacher:update', 6),
	(10, 'teacher:*', 4),
	(11, 'student:*', 4),
	(12, 'teacher:find', 5);
/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;

-- 导出  表 test.t_role 结构
CREATE TABLE IF NOT EXISTS `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `rolename` varchar(20) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- 正在导出表  test.t_role 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` (`id`, `rolename`) VALUES
	(4, 'admin'),
	(5, 'student'),
	(6, 'teacher');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;

-- 导出  表 test.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `role_id` int(11) DEFAULT NULL COMMENT '外键关联role表',
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- 正在导出表  test.t_user 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `username`, `password`, `role_id`) VALUES
	(4, 'jake', '123456', 4),
	(5, 'arvin', '123456', 5),
	(6, 'mike', '123456', 6),
	(7, 'david', '123456', 5);
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
