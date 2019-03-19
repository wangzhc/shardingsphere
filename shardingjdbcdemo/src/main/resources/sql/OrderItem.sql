-- auto Generated on 2019-03-18 13:43:07 
-- DROP TABLE IF EXISTS `order_item`; 
CREATE TABLE `order_item`(
    `order_item_id` BIGINT (19) NOT NULL AUTO_INCREMENT COMMENT 'orderItemId',
    `order_id` BIGINT (19) NOT NULL DEFAULT 0 COMMENT 'orderId',
    `user_id` BIGINT (19) NOT NULL DEFAULT 0 COMMENT 'userId',
    `description` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'description',
    PRIMARY KEY (`order_item_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '`order_item`';
