drop schema ims;
CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims`;

CREATE TABLE IF NOT EXISTS `ims`.`customers`(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(40) NULL DEFAULT NULL,
	`surname` VARCHAR(40) NULL DEFAULT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`items`(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR(40) NOT NULL,
	`item_price` DECIMAL(5,2) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `ims`.`orders`(
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`cust_id` INT(11) NOT NULL,
	PRIMARY KEY(`id`),
	FOREIGN KEY(`cust_id`)
		REFERENCES `ims`.`customers`(`id`) ON DELETE CASCADE,
		`value` DOUBLE
);

CREATE TABLE IF NOT EXISTS `ims`.`orderItems`(
	`id` INT (11) NOT NULL AUTO_INCREMENT,
	`order_id` INT(11) NOT NULL,
	`item_id` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `fk_orderItem_1` FOREIGN KEY (`order_id`)
		REFERENCES `ims`.`orders`(`id`) ON DELETE CASCADE,
	CONSTRAINT `fk_orderItem_2` FOREIGN KEY (`item_id`)
		REFERENCES `ims`.`items`(`id`) ON DELETE CASCADE
	
	
);
		
