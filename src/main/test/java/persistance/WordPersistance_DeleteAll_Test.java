package persistance;

import database.domain.Word;
import database.persistance.WordPersistence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6BDDAssertions.then;

public class WordPersistance_DeleteAll_Test {
    private final WordPersistence wordPersistence = new WordPersistence();

    @Test
    @DisplayName("deleteAll method is passed")
    public void deleteAllTes() {
        wordPersistence.putWord("Alex", "love football"); // id = 1
        wordPersistence.putWord("Max", "love hockey");
        wordPersistence.deleteAll();

        Word word = wordPersistence.getById(1);
        then(word.getWord()).isNull();
        then(word.getDef()).isNull();

        Word word2 = wordPersistence.getById(2);
        then(word2.getWord()).isNull();
        then(word2.getDef()).isNull();

    }
}
