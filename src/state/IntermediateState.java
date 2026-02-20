package state;

public class IntermediateState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Advanced training...");
        character.addExperience(30);

        if (character.getExperience() >= 250) {
            System.out.println("You advanced to Expert level!");
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditating...");
        character.addHealth(15);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting not available at Intermediate level.");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }
}