SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `netify` DEFAULT CHARACTER SET utf8 ;
USE `netify` ;

DROP TABLE IF EXISTS `netify`.`users`;
CREATE TABLE IF NOT EXISTS `netify`.`users` (
    `user_id` INT NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(45) NOT NULL,
    `password` VARCHAR(100) NOT NULL,
    `first_name` VARCHAR(45) NOT NULL,
    `surname` VARCHAR(45) NOT NULL,
    `phone_number` VARCHAR(45) NULL,
    `email` VARCHAR(45) NOT NULL,
    `balance` INT NULL DEFAULT 0,
    `creation_date` DATE NOT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE INDEX `login_UNIQUE` (`login` ASC),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC),
    UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ASC)
    ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `netify.users_roles`;
CREATE TABLE IF NOT EXISTS `netify`.`users_roles` (
    `user_id` INT NOT NULL,
    `role` VARCHAR(45) NOT NULL,
    INDEX `user_id_idx` (`user_id` ASC),
    PRIMARY KEY (`user_id`),
    CONSTRAINT `fk_user_id_roles`
    FOREIGN KEY (`user_id`)
    REFERENCES `netify`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `netify.users_adresses`;
CREATE TABLE IF NOT EXISTS `netify`.`users_adresses` (
    `user_id` INT NOT NULL,
    `city` VARCHAR(255) NOT NULL,
    `street` VARCHAR(255) NOT NULL,
    `home` VARCHAR(255) NOT NULL,
    `flat` INT NOT NULL,
    INDEX `user_id_idx` (`user_id` ASC),
    PRIMARY KEY (`user_id`),
    CONSTRAINT `fk_user_id_addresses`
    FOREIGN KEY (`user_id`)
    REFERENCES `netify`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `netify.tariffs`;
CREATE TABLE IF NOT EXISTS `netify`.`tariffs` (
    `tariff_id` INT NOT NULL AUTO_INCREMENT,
    `type` VARCHAR(255) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `cost` INT NOT NULL,
    PRIMARY KEY (`tariff_id`),
    UNIQUE INDEX `type_UNIQUE` (`type` ASC),
    UNIQUE INDEX `name_UNIQUE` (`name` ASC)
    ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `netify.mobile_tariffs`;
CREATE TABLE IF NOT EXISTS `netify`.`mobile_tariffs` (
    `tariff_id` INT NOT NULL,
    `megabytes_includes` INT NOT NULL,
    `incoming_minutes` INT NOT NULL,
    `outgoing_minutes` INT NOT NULL,
    PRIMARY KEY (`tariff_id`),
    CONSTRAINT `fk_tariff_id_mobile`
    FOREIGN KEY (`tariff_id`)
    REFERENCES `netify`.`tariffs` (`tariff_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `netify.home_tariffs`;
CREATE TABLE IF NOT EXISTS `netify`.`home_tariffs` (
    `tariff_id` INT NOT NULL,
    `speed_limit` INT NOT NULL,
    PRIMARY KEY (`tariff_id`),
    CONSTRAINT `fk_tariff_id_home`
    FOREIGN KEY (`tariff_id`)
    REFERENCES `netify`.`tariffs` (`tariff_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `netify.tariff_equipment`;
CREATE TABLE IF NOT EXISTS `netify`.`tariff_equipment` (
    `tariff_id` INT NOT NULL,
    `equipment` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`tariff_id`),
    CONSTRAINT `fk_tariff_id_equipment`
    FOREIGN KEY (`tariff_id`)
    REFERENCES `netify`.`home_tariffs` (`tariff_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `netify.tariff_services`;
CREATE TABLE IF NOT EXISTS `netify`.`tariff_services` (
   `tariff_id` INT NOT NULL,
   `service` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`tariff_id`),
    CONSTRAINT `fk_tariff_id_services`
    FOREIGN KEY (`tariff_id`)
    REFERENCES `netify`.`home_tariffs` (`tariff_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `netify.connection_applications`;
CREATE TABLE IF NOT EXISTS `netify`.`connection_applications` (
    `application_id` INT NOT NULL AUTO_INCREMENT,
     `user_id` INT NOT NULL,
    `tariff_id` INT NOT NULL,
    `submission_date` DATE NOT NULL,
    `closing_date` DATE NOT NULL,
    `status` VARCHAR(255) NOT NULL DEFAULT 'new',
    PRIMARY KEY (`application_id`),
    INDEX `user_id_idx` (`user_id` ASC),
    INDEX `tariff_id_idx` (`tariff_id` ASC),
    CONSTRAINT `fk_user_id_applications`
    FOREIGN KEY (`user_id`)
    REFERENCES `netify`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_tariff_id_applications`
    FOREIGN KEY (`tariff_id`)
    REFERENCES `netify`.`tariffs` (`tariff_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `netify.payments`;
CREATE TABLE IF NOT EXISTS `netify`.`payments` (
    `payment_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `tariff_id` INT NOT NULL,
    `payment_date` DATE NOT NULL,
    `cost` INT NOT NULL,
     PRIMARY KEY (`payment_id`),
    INDEX `user_id_idx` (`user_id` ASC),
    INDEX `tariff_id_idx` (`tariff_id` ASC),
    CONSTRAINT `fk_user_id_payments`
    FOREIGN KEY (`user_id`)
    REFERENCES `netify`.`users` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_tariff_id_payments`
    FOREIGN KEY (`tariff_id`)
    REFERENCES `netify`.`connection_applications` (`tariff_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `netify.users_connections`;
CREATE TABLE IF NOT EXISTS `netify`.`users_connections` (
    `connection_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `tariff_id` INT NOT NULL,
    `connection_date` DATE NULL,
    `status` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`connection_id`),
    INDEX `user_id_idx` (`user_id` ASC),
    INDEX `tariff_id_idx` (`tariff_id` ASC),
    CONSTRAINT `fk_user_id_connections`
    FOREIGN KEY (`user_id`)
    REFERENCES `netify`.`payments` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_tariff_id_connections`
    FOREIGN KEY (`tariff_id`)
    REFERENCES `netify`.`payments` (`tariff_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    ) ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;