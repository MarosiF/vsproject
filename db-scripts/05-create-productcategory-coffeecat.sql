-- -----------------------------------------------------
-- Schema coffeecatproductcategory
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `coffeecatproductcategory`;

CREATE SCHEMA `coffeecatproductcategory`;
USE `coffeecatproductcategory` ;

-- -----------------------------------------------------
-- Table `coffeecatproductcategory`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeecatproductcategory`.`product_category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Categories
-- -----------------------------------------------------
INSERT INTO PRODUCT_CATEGORY(CATEGORY_NAME) VALUES ('Coffee');
INSERT INTO PRODUCT_CATEGORY(CATEGORY_NAME) VALUES ('Coffee Mugs');
INSERT INTO PRODUCT_CATEGORY(CATEGORY_NAME) VALUES ('Tea');
INSERT INTO PRODUCT_CATEGORY(CATEGORY_NAME) VALUES ('Books');
INSERT INTO PRODUCT_CATEGORY(CATEGORY_NAME) VALUES ('Cat Stuff');
