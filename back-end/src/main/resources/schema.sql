/*
 *--- General Rules ---
 *--- Use underscore_names
 *--- Table names should be plural
 *--- Spell out id fields (item_id instead of id)
 *--- don't use ambiguous column names
 *--- Name foreign key columns the same as the columns they refer to
 *--- Use caos for all SQL queries
 */

 CREATE SCHEMA IF NOT EXISTS developers;

SET NAMES 'UTF8MB4';
SET TIME_ZONE = EU;
SET TIME_ZONE = '+3:00';

USE developers;

DROP TABLE IF EXISTS Users;

CREATE TABLE User
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL ,
    email VARCHAR(100)NOT NULL,
    password VARCHAR(255)DEFAULT NULL,
    address VARCHAR(255)DEFAULT NULL,
    phone VARCHAR(30)DEFAULT NULL,
    title VARCHAR(30)DEFAULT NULL,
    bio VARCHAR(255)DEFAULT NULL,
    enabled BOOLEAN DEFAULT FALSE,
    non_locked BOOLEAN DEFAULT TRUE,
    using_mfa BOOLEAN DEFAULT FALSE,
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    image_url VARCHAR(255) DEFAULT 'Users\Never\Desktop\project\PinksiClub\back-end\account_default_icon.png',
    CONSTRAINT uq_Users_Email UNIQUE (email)
);

DROP TABLE IF EXISTS Roles;

CREATE TABLE Roles
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    permission VARCHAR(255) NOT NULL,
    CONSTRAINT UQ_Users_Email UNIQUE (name)
);

DROP TABLE IF EXISTS UserRoles;

CREATE TABLE Users
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    permission VARCHAR(255) NOT NULL,
    CONSTRAINT UQ_Users_Email UNIQUE (name)
);

DROP TABLE IF EXISTS UserRoles;

CREATE TABLE UserRoles
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL ,
    role_id BIGINT UNSIGNED NOT NULL ,
    FOREIGN KEY (user_id) REFERENCES User (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (role_id) REFERENCES Roles (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_UserRoles_User_id UNIQUE (user_id)
);

DROP TABLE IF EXISTS Events;

CREATE TABLE Events
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50) NOT NULL CHECK(type IN ('LOGIN_ATTEMPT','LOGIN_ATTEMPT_FAILURE','LOGIN_ATTEMPT_SUCCESS','PROFILE UPDATE','PROFILE_PICTURE_UPDATE','ROLE_UPDATE','ACCOUNT_SETTINGS_UPDATE','PASSWORD_UPDATE','MFA_UPDATE')),
    permission VARCHAR(255) NOT NULL,
    CONSTRAINT UQ_Users_Email UNIQUE (type)
);

DROP TABLE IF EXISTS UserEvents;

CREATE TABLE UserEvents
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    event_id BIGINT UNSIGNED NOT NULL ,
    device VARCHAR(100) DEFAULT NULL,
    ip_address VARCHAR(100)DEFAULT NULL,
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (event_id) REFERENCES Events (id) ON DELETE RESTRICT ON UPDATE CASCADE
);
DROP TABLE IF EXISTS UserEvents;

CREATE TABLE UserEvents
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    event_id BIGINT UNSIGNED NOT NULL ,
    device VARCHAR(100) DEFAULT NULL,
    ip_address VARCHAR(100)DEFAULT NULL,
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES Users (id) ON DELETE CASCADE ON UPDATE CASCADE ,
    FOREIGN KEY (event_id) REFERENCES Events (id) ON DELETE RESTRICT ON UPDATE CASCADE
);

DROP TABLE IF EXISTS AccountVerifications;

CREATE TABLE AccountVerifications
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    url VARCHAR(255) NOT NULL,
    -- date DATETIME NOT NULL,
   FOREIGN KEY (user_id)REFERENCES Users(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_AccountVerifications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_AccountVerifications_Url UNIQUE (url)
);

DROP TABLE IF EXISTS ResetPasswordVerifications;

CREATE TABLE ResetPasswordVerifications
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    url VARCHAR(255) NOT NULL,
     expiration_date DATETIME NOT NULL,
    FOREIGN KEY (user_id)REFERENCES Users(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_ResetPasswordVerifications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_ResetPasswordVerifications_Url UNIQUE (url)
);
DROP TABLE IF EXISTS TwoFactorVerifications;

CREATE TABLE TwoFactorVerifications
(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT UNSIGNED NOT NULL,
    code VARCHAR(255) NOT NULL,
    expiration_date DATETIME NOT NULL,
    FOREIGN KEY (user_id)REFERENCES Users(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT UQ_TwoFactorVerifications_User_Id UNIQUE (user_id),
    CONSTRAINT UQ_TwoFactorVerifications_Code UNIQUE (code )
);
DROP TABLE IF EXISTS 'customer';

CREATE TABLE 'customer'
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `created_at` DATETIME NULL,
    `updated_at` DATETIME NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `UK_email` (`email` ASC) VISIBLE)
    ENGINE = InnoDB;

DROP TABLE IF EXISTS 'table_tennis_registration' ;

CREATE TABLE 'table_tennis_registration'
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `customer_id` BIGINT NOT NULL,
    `registration_time` DATETIME NULL,
    `table_tennis_type` VARCHAR(255) NULL,
    PRIMARY KEY (`id`),
    INDEX `FK_customer_id` (`customer_id` ASC) VISIBLE,
    CONSTRAINT `FK_customer_id`
        FOREIGN KEY (`customer_id`)
            REFERENCES 'customer' (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION)
    ENGINE = InnoDB;
