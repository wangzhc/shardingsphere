-- auto Generated on 2019-03-18 11:52:02 
-- DROP TABLE IF EXISTS `user`; 
CREATE TABLE `user`(
    `user_id` BIGINT (19) NOT NULL AUTO_INCREMENT COMMENT 'userId',
    `name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
    `age` INT (11) NOT NULL DEFAULT 0 COMMENT 'age',
    `address` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'address',
    PRIMARY KEY (`user_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`user`';
