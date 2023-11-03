-- Insert data into the `users` table
INSERT INTO `netify`.`users` (`login`, `password`, `first_name`, `surname`, `phone_number`, `email`, `balance`, `creation_date`)
VALUES ('admin', '123', 'John', 'Smith', '1234567890', 'johnsmith@example.com', 100, '2023-01-01');

-- Insert data into the `users_roles` table
INSERT INTO `netify`.`users_roles` (`user_id`, `role`)
VALUES (1, 'admin');

-- Insert data into the `users_adresses` table
INSERT INTO `netify`.`users_adresses` (`user_id`, `city`, `street`, `home`, `flat`)
VALUES (1, 'New York', 'Main Street', '123', 4);

-- Insert data into the `tariffs` table
INSERT INTO `netify`.`tariffs` (`type`, `name`, `cost`)
VALUES ('mobile', 'Mobile Plan 1', 50);

-- Insert data into the `mobile_tariffs` table
INSERT INTO `netify`.`mobile_tariffs` (`tariff_id`, `megabytes_includes`, `incoming_minutes`, `outgoing_minutes`)
VALUES (1, 5000, 500, 1000);

-- Insert data into the `home_tariffs` table
INSERT INTO `netify`.`home_tariffs` (`tariff_id`, `speed_limit`)
VALUES (1, 100);

-- Insert data into the `tariff_equipment` table
INSERT INTO `netify`.`tariff_equipment` (`tariff_id`, `equipment`)
VALUES (1, 'Router');

-- Insert data into the `tariff_services` table
INSERT INTO `netify`.`tariff_services` (`tariff_id`, `service`)
VALUES (1, 'Technical Support');

-- Insert data into the `connection_applications` table
INSERT INTO `netify`.`connection_applications` (`user_id`, `tariff_id`, `submission_date`, `closing_date`, `status`)
VALUES (1, 1, '2023-01-01', '2023-01-05', 'new');

-- Insert data into the `payments` table
INSERT INTO `netify`.`payments` (`user_id`, `tariff_id`, `payment_date`, `cost`)
VALUES (1, 1, '2023-01-05', 50);

-- Insert data into the `users_connections` table
INSERT INTO `netify`.`users_connections` (`user_id`, `tariff_id`, `connection_date`, `status`)
VALUES (1, 1, '2023-01-05', 'active');