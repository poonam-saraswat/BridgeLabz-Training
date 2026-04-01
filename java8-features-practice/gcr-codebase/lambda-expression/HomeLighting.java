@FunctionalInterface
interface LightAction {
    void activate();
}

public class HomeLighting {
    public static void main(String[] args) {

        LightAction motionTrigger = () -> System.out.println("Motion triggers!");

        LightAction nightTrigger = () -> System.out.println("Time of the day trigger: Night!");

        LightAction voiceTrigger = () -> System.out.println("Voice command trigger!");

        motionTrigger.activate();
        nightTrigger.activate();
        voiceTrigger.activate();
    }
}
