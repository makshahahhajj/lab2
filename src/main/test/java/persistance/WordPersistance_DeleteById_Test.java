package persistance;

import database.domain.Word;
import database.persistance.WordPersistence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WordPersistance_DeleteById_Test {
    private final WordPersistence wordPersistence = new WordPersistence();

    @Test
    @DisplayName("deleteById method is passed")
    public void deleteByIdTest() {
        wordPersistence.putWord("Alex", "love football"); // id = 1
        wordPersistence.putWord("Max", "love hockey");
        wordPersistence.deleteById(1);

        Word word = wordPersistence.getById(1);
        then(word.getWord()).isNull();
        then(word.getDef()).isNull();

        Word word2 = wordPersistence.getById(2);
        then(word).isNotNull();
        then(word2.getWord()).isEqualTo("Max");
        then(word2.getDef()).isEqualTo("love hockey");

    }
}
