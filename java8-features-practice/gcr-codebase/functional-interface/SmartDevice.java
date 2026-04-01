interface SmartDevices {
    void turnOn();
    void turnOff();
}

class Lights implements SmartDevices{

    @Override
    public void turnOn(){
        System.out.println("Turning On Lights!");
    }

    @Override
    public void turnOff(){
        System.out.println("Turning Off Lights!");
    }
}

class Ac implements SmartDevices{

    @Override
    public void turnOn(){
        System.out.println("Turning On Air conditioner!");
    }

    @Override
    public void turnOff(){
        System.out.println("Turning Off Air Conditioner!");
    }
}

class Tv implements SmartDevices{
    @Override
    public void turnOn(){
        System.out.println("Turning On Television!");
    }

    @Override
    public void turnOff(){
        System.out.println("Turning Off Television!");
    }
}

public class SmartDevice{
    public static void main(String[] args){
        SmartDevices lights = new Lights();
        SmartDevices ac = new Ac();
        SmartDevices tv = new Tv();

        lights.turnOn();
        lights.turnOff();

        ac.turnOn();
        ac.turnOff();

        tv.turnOn();
        tv.turnOff();
    }
}
