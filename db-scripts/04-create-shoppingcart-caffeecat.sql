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
  `id` BIGINT(20) NOT NULL, -- AUTO_INCREMENT,
  `product_id` BIGINT(20) NOT NULL,
PRIMARY KEY (`id`, `product_id`))
ENGINE=InnoDB;
-- AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- User
-- -----------------------------------------------------
INSERT INTO SHOPPINGCART(ID, PRODUCT_ID) VALUES (1,1);
INSERT INTO SHOPPINGCART(ID, PRODUCT_ID) VALUES (1,11);
INSERT INTO SHOPPINGCART(ID, PRODUCT_ID) VALUES (2,8);
INSERT INTO SHOPPINGCART(ID, PRODUCT_ID) VALUES (2,16);
INSERT INTO SHOPPINGCART(ID, PRODUCT_ID) VALUES (3,5);
INSERT INTO SHOPPINGCART(ID, PRODUCT_ID) VALUES (3,14);
