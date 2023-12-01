package persistance;

import database.domain.Word;
import database.persistance.WordPersistence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6BDDAssertions.then;


public class WordPersistance_GetById_Test {

    private final WordPersistence wordPersistence = new WordPersistence();

    @Test
    @DisplayName("getById method is passed")
    public void getByIdTest() {
        Word word = wordPersistence.getById(1);
        then(word).isNotNull();
        then(word.getWord()).isEqualTo("Max");
        then(word.getDef()).isEqualTo("my name is");
    }
}