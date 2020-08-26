package com.petstore.repository;

import com.petstore.models.Pet;
import com.petstore.models.PetType;
import com.petstore.models.Petsex;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"classpath:db/insert_pet.sql"})
class PetRepositoryTest {

    Logger log = Logger.getLogger(getClass().getName() );
    @Autowired
    PetRepository petRepository;

        Pet testPetDate;
    @BeforeEach
    void setUp() {
        testPetDate = petRepository.findById(200).orElse(null);
        assertThat(testPetDate).isNotNull();
        log.info("Test part data retrieved from database --->" + testPetDate);
    }

    @AfterEach
    void tearDown() {
    }

@Test
    void creatPetObject_thensaveindataBase(){
        Pet pet = new Pet();
        pet.setAge(5);
        pet.setName("Lucky");
        pet.setSex(Petsex.MALE);
        pet.setTypes(PetType.DOG);
        pet.setBreed("Bull Dog");
        pet.setBirthDate(new Date());

        log.info("created pet object ---->" + pet);
                assertThat(pet.getId()).isNull();

                //save object in DB
                pet = petRepository.save(pet);
                log.info("after saving pete object ---->" + pet);
                assertThat(pet.getId()).isNotNull();

    }
    @Test
    void whenFindAllPetIsCalled_thenRetrivedPetList(){
        List<Pet>allPet = petRepository.findAll();
        assertThat(allPet.size()).isEqualTo(7);
        log.info("all pets retrieved from the database --> " + allPet);


    }
    @Test

    void whenPetDetailsIsUpdated(){
        assertThat(testPetDate.getName() =="booby");
        testPetDate.setName("Bully");

        testPetDate = petRepository.save(testPetDate);
        assertThat(testPetDate.getName()).isEqualTo("Bully");
    }

    @Test
    void whenDeleteIsCalled_thenDeletePetDateTest(){
        List<Pet> allPets = petRepository.findAll();
        assertThat(allPets).isNotNull();
        assertThat(allPets.size()).isEqualTo(7);

        Pet savePet = petRepository.findById(203).orElse(null);
        assertThat(savePet).isNotNull();
        petRepository.deleteById(203);


        Pet deletedPet = petRepository.findById(203).orElse(null);
        assertThat(deletedPet).isNull();

        allPets = petRepository.findAll();
        assertThat(allPets).isNotNull();
        assertThat(allPets.size()).isEqualTo(6);




    }
}