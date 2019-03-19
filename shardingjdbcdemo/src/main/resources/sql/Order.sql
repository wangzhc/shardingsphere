-- auto Generated on 2019-03-18 13:40:23 
-- DROP TABLE IF EXISTS `order`; 
CREATE TABLE `order`(
    `order_id` BIGINT (19) NOT NULL AUTO_INCREMENT COMMENT 'orderId',
    `user_id` BIGINT (19) NOT NULL DEFAULT 0 COMMENT 'userId',
    `description` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'description',
    `create_time` DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
    PRIMARY KEY (`order_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`order`';
