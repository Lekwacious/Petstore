package com.petstore.repository;

import com.petstore.models.Pet;
import com.petstore.models.PetType;
import com.petstore.models.Petsex;
import com.petstore.models.Store;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Sql(scripts = {"classpath:db/insert_store.sql"})
class StoreRepositoryTest {
    Logger log = Logger.getLogger(getClass().getName() );

    @Autowired
    StoreRepository storeRepository;
    Store testStore;

    @BeforeEach
    void setUp() {
        testStore = storeRepository.findById(102).orElse(null);
        assertThat(testStore).isNotNull();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void  createNewStoreTest(){
        Store londonstore = new Store();
        londonstore.setStoreName("londonstore");
        londonstore.setState("Lagos");
        londonstore.setStoreNumber(1234);
        londonstore.setAddress("124 London street");
        londonstore.setCity("Yaba");
        londonstore.setCountry("Nigeria");

        assertThat(londonstore.getId()).isNull();

        londonstore = storeRepository.save(londonstore);
        log.info("store object after saving---->" + londonstore);
        assertThat(londonstore.getId()).isNotNull();



    }

    @Test
    void whenAddPetsToStore_thensaveTest(){
        Pet pet = new Pet();
        pet.setName("Jack");
        pet.setBreed("Bull Dog");
        pet.setTypes(PetType.DOG);
        pet.setSex(Petsex.MALE);
        pet.setAge(5);
        pet.setPetStore(testStore);
        testStore.addPet(pet);

        testStore = storeRepository.save(testStore);
        log.info("Added pets to the the store ---->" + testStore);


    }
    @Test
    void whenStoneIsRetrieved_thenRetrievedStoredPet() {
        Pet pet1 = new Pet();
        pet1.setName("Jack");
        pet1.setBreed("Bull Dog");
        pet1.setTypes(PetType.DOG);
        pet1.setSex(Petsex.MALE);
        pet1.setAge(5);
        pet1.setPetStore(testStore);


        Pet pet2 = new Pet();
        pet2.setName("Jack");
        pet2.setBreed("Bull Dog");
        pet2.setTypes(PetType.DOG);
        pet2.setSex(Petsex.MALE);
        pet2.setAge(5);
        pet2.setPetStore(testStore);

        testStore.addPet(pet1);
        testStore.addPet(pet2);

        testStore = storeRepository.save(testStore);

        log.info("Store object saved to the db --->" + testStore);

        Store savedStore = storeRepository.findById(testStore.getId()).orElse(null);
        assertThat(savedStore.getPets()).isNotNull();
        assertThat(savedStore.getPets()).hasSize(2);

    }


}