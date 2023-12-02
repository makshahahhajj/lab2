package persistance;

import database.domain.Word;
import database.persistance.WordPersistence;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6BDDAssertions.then;

public class WordPersistance_putWord_Test {
    private final WordPersistence wordPersistence = new WordPersistence();

    @Test
    @DisplayName("putWord method is passed")
    public void pusTes() {

        wordPersistence.putWord("Alex", "love football");
        Word word  = wordPersistence.getById(1);
        then(word).isNotNull();
        then(word.getId()).isEqualTo(1);
        then(word.getWord()).isEqualTo("Alex");
        then(word.getDef()).isEqualTo("love football");
    }
}
