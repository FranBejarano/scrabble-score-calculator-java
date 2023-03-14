public class Scrabble {

    String input;
    int totalPoints;
    public Scrabble(String word){

        this.input = word;
    }

    public Scrabble (String word, Character[] doubleLetter, Character[] tripleLetter, boolean doubleWord, boolean tripleWord){

        if (doubleWord) this.input = word.concat(word);
        if (tripleWord) this.input = word.concat(word).concat(word);
        if (doubleLetter.length > 0) this.input = calculateDoubleLetter(word, doubleLetter);
        if (tripleLetter.length > 0) this.input = calculateTripleLetter(word, tripleLetter);
        if (doubleLetter.length > 0 && tripleLetter.length > 0) this.input = calculateTripleLetter(calculateDoubleLetter(word, doubleLetter),tripleLetter);

    }

    public int score(){
        totalPoints = 0;

        if (input != null){
            input = input.toUpperCase();
            for (int i = 0; i < input.length(); i++){
                totalPoints += Alphabet.getPoints(String.valueOf(input.charAt(i)));
            };
        };
        return totalPoints;
    };

    public String calculateDoubleLetter(String word, Character[] doublePointedLetters) {

        for (Character doublePointedLetter : doublePointedLetters) {
            word = word.concat(doublePointedLetter.toString().toUpperCase());

        }

        return word;
    };

    public String calculateTripleLetter(String word, Character[] triplePointedLetters) {

        for (Character triplePointedLetter : triplePointedLetters) {
            word = word.concat(triplePointedLetter.toString().toUpperCase()).concat(triplePointedLetter.toString().toUpperCase());
        }

        return word;
    };
}
