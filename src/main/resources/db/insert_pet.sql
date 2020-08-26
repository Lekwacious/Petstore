SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE  pet_animals;

INSERT INTO pet_animals(`id`, `name`, `breed`, `types`, `sex`, `age`)
VALUES (200, 'booby', 'german shepherd', 'DOG', 'MALE', 15),
(100, 'booby', 'german shepherd', 'DOG', 'MALE', 15),
(20, 'booby', 'german shepherd', 'GOAT', 'MALE', 15),
(110, 'booby', 'german shepherd', 'DOG', 'MALE', 15),
(22, 'booby', 'german shepherd', 'DOG', 'MALE', 15),
(23, 'booby', 'german shepherd', 'DOG', 'MALE', 15),
(203, 'Gregory', 'german shepherd', 'DOG', 'MALE', 15);

SET FOREIGN_KEY_CHECKS = 1;