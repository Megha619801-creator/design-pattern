package state;

public class ExpertState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Elite training...");
        character.addExperience(40);

        if (character.getExperience() >= 500) {
            System.out.println("You reached MASTER level!");
            character.setState(new MasterState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Deep meditation...");
        character.addHealth(20);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting a strong enemy...");
        character.reduceHealth(25);
        character.addExperience(50);
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }
}