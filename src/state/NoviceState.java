package state;

public class NoviceState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Training hard...");
        character.addExperience(20);

        if (character.getExperience() >= 100) {
            System.out.println("You advanced to Intermediate level!");
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditation not available at Novice level.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting not available at Novice level.");
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }
}