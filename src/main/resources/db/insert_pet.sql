SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE  pet_animal;

INSERT INTO pet_animal(`id`, `name`, `breed`, `types`, `sex`, `age`);
VALUE (200, 'booby', 'german shepherd', 'Dog', 'MALE', 15);
VALUE (100, 'booby', 'german shepherd', 'Dog', 'MALE', 15);
VALUE (20, 'booby', 'german shepherd', 'Dog', 'MALE', 15);
VALUE (110, 'booby', 'german shepherd', 'Dog', 'MALE', 15);
VALUE (22, 'booby', 'german shepherd', 'Dog', 'MALE', 15);
VALUE (23, 'booby', 'german shepherd', 'Dog', 'MALE', 15);
VALUE (203, 'Gregory', 'german shepherd', 'Dog', 'MALE', 15);

SET FOREIGN_KEY_CHECKS = 1;