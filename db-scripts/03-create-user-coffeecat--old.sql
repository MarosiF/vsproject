-- -----------------------------------------------------
-- Schema coffeecatuser
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `coffeecatuser`;

CREATE SCHEMA `coffeecatuser`;
USE `coffeecatuser` ;

-- -----------------------------------------------------
-- Table `coffeecatuser`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `coffeecatuser`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `surename` VARCHAR(255) NULL DEFAULT NULL,

PRIMARY KEY (`id`))
ENGINE=InnoDB
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- User
-- -----------------------------------------------------
INSERT INTO USER(NAME, SURENAME) VALUES ('Elon','Musk');
INSERT INTO USER(NAME, SURENAME) VALUES ('Robin','Cat');
INSERT INTO USER(NAME, SURENAME) VALUES ('Hugo','Dog');

