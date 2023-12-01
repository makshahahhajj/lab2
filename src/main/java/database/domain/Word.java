package database.domain;

public class Word {
    private String word;
    private String definition;
    private int id;
    public Word(int id, String word, String definition) {
        this.word = word;
        this.definition = definition;
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public String getDef() {
        return definition;
    }

    public int getId() {
        return id;
    }

}
