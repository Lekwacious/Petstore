SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE pet_animals;
TRUNCATE TABLE  store;

INSERT INTO store(`id`, `store_name`, `store_number`, `address`, `city`, `state`, `country`)
VALUES (102, 'Ibadan', 15, '212 Lagos', 'Yaba', 'Lagos', 'Nigeria'),
(105, 'Ibadan', 12, '212 Lagos', 'Yaba', 'Lagos', 'Nigeria'),
(106, 'Spars', 12, '212 Lagos', 'Mainland','Lagos', 'Nigeria'),
(109, 'Shoprite', 12, '212 Lagos', 'Yaba', 'Lagos', 'Nigeria'),
(104, 'Ibadan', 12, '212 Lagos', 'Shomolu', 'Lagos', 'Nigeria');

SET FOREIGN_KEY_CHECKS = 1;