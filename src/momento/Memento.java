package momento;


import java.time.LocalDateTime;

public class Memento implements IMemento {
    private final int[] options;
    private final boolean isSelected;
    private final LocalDateTime time;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // safe copy
        this.isSelected = isSelected;
        this.time = LocalDateTime.now();
    }

    public int[] getOptions() {
        return options.clone(); // safe copy
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String getDescription() {
        return "Time: " + time.toLocalTime().withNano(0)
                + " | Colors: [" + options[0] + "," + options[1] + "," + options[2] + "]"
                + " | Checkbox: " + isSelected;
    }
}