package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repo = new ProductRepository();
    Book grace = new Book(1, "java", 100, "grace");
    Book gracer = new Book(3, "java", 100, "grace");
    Book HP1 = new Book(4, "HP1", 100, "JR");
    Book HP2 = new Book(5, "HP2", 100, "JR");

    @BeforeEach
    public void setUp() {
        repo.save(grace);
        repo.save(gracer);
        repo.save(HP1);
        repo.save(HP2);

    }

    @Test
    public void notFoundExceptionTest() {

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(10);
        });
    }


    @Test
    public void FoundItemTest() {
        repo.removeById(1);

        Product[] expected = {gracer, HP1, HP2};
        Product[] actual = repo.findAll();
        assertArrayEquals(actual, expected);
    }

}