DROP TABLE `orderItems`;
DROP TABLE `orders`;
DROP TABLE `items`;
DROP TABLE `customers`;

CREATE TABLE `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `items` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`item_name` VARCHAR(40) NOT NULL,
	`item_price` DOUBLE NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `orders` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `cust_id` INT(11) NOT NULL,
    `value` DOUBLE NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_orders` FOREIGN KEY (`cust_id`) REFERENCES customers(`id`) ON DELETE CASCADE 
);

CREATE TABLE `orderItems` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `order_id` INT(11) NOT NULL,
    `item_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_orderitems_1` FOREIGN KEY (`order_id`) REFERENCES orders(`id`) ON DELETE CASCADE,
    CONSTRAINT `fk_orderitems_2` FOREIGN KEY (`item_id`) REFERENCES items(`id`) ON DELETE CASCADE
);

