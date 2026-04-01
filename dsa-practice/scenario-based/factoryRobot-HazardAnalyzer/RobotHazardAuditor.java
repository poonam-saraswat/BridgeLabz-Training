public class RobotHazardAuditor{
    public boolean isValidArmPrecision(double armPrecision) throws RobotSafetyException{
        if(!(armPrecision >= 0.0 && armPrecision <= 1.0)){
            throw new RobotSafetyException("Error: Arm precision must be 0.0 - 1.0.");
        }

        return true;
    }

    public boolean isValidWorkerDensity(int workerDensity) throws RobotSafetyException{
        if(!(workerDensity >= 1 && workerDensity <= 20)){
            throw new RobotSafetyException("Error: Worker density must be 1 - 20.");
        }

        return true;
    }

    public boolean isValidMachineryState(String machineryState) throws RobotSafetyException{
        if(!(machineryState.equalsIgnoreCase("worn") || machineryState.equalsIgnoreCase("faulty") || machineryState.equalsIgnoreCase("critical"))){
            throw new RobotSafetyException("Error: Unsupported machinery state.");
        }

        return true;
    }
    public double CalculateHazardRisk(double armPrecision, int workerDensity, String machineryState){
        double machineRiskFactor = calculateMachineRiskFactor(machineryState);
        double hazardRisk = ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);

        return hazardRisk;
    }

    private double calculateMachineRiskFactor(String machineryState){
        if(machineryState.equalsIgnoreCase("Worn")){
            return 1.3;
        }
        else if(machineryState.equalsIgnoreCase("Faulty")){
            return 2.0;
        }
        else if(machineryState.equalsIgnoreCase("Critical")){
            return 3.0;
        }

        return 0;
    }
}