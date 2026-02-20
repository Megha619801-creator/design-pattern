package state;

public class MasterState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("You are already a Master!");
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Master meditation...");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Masters choose their battles wisely.");
    }

    @Override
    public String getLevelName() {
        return "Master";
    }
}