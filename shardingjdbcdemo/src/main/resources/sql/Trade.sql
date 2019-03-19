-- auto Generated on 2019-03-18 11:38:51 
-- DROP TABLE IF EXISTS `trade`; 
CREATE TABLE `trade`(
    `id` BIGINT (19) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_id` BIGINT (19) NOT NULL DEFAULT 0 COMMENT 'userId',
    `score` INT (11) NOT NULL DEFAULT 0 COMMENT 'score',
    `create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`trade`';
