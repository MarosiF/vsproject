-- -----------------------------------------------------
-- Schema coffeecatshoppingcart
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `coffeecatshoppingcart`;

CREATE SCHEMA `coffeecatshoppingcart`;
USE `coffeecatshoppingcart` ;

-- -----------------------------------------------------
-- Table `coffeecatshoppingcart`.`shoppingcart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeecatshoppingcart`.`shoppingcart` (
  `id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  `product_id` BIGINT(20) NOT NULL,
  `amount` INT(2) NOT NULL,
PRIMARY KEY (`id`))
ENGINE=InnoDB;

-- -----------------------------------------------------
-- User
-- -----------------------------------------------------
INSERT INTO SHOPPINGCART(ID, USER_ID, PRODUCT_ID, AMOUNT) VALUES (1,1,1,1);
INSERT INTO SHOPPINGCART(ID, USER_ID, PRODUCT_ID, AMOUNT) VALUES (2,1,2,2);
INSERT INTO SHOPPINGCART(ID, USER_ID, PRODUCT_ID, AMOUNT) VALUES (3,2,4,3);
INSERT INTO SHOPPINGCART(ID, USER_ID, PRODUCT_ID, AMOUNT) VALUES (4,3,3,3);
INSERT INTO SHOPPINGCART(ID, USER_ID, PRODUCT_ID, AMOUNT) VALUES (5,2,2,1);
INSERT INTO SHOPPINGCART(ID, USER_ID, PRODUCT_ID, AMOUNT) VALUES (6,1,1,2);
INSERT INTO SHOPPINGCART(ID, USER_ID, PRODUCT_ID, AMOUNT) VALUES (7,3,4,1);


