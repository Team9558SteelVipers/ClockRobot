package frc.robot;

import static frc.robot.Constants.operatorConstants.*;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class OI {

    public static CommandXboxController driverController;

    public OI(){
        driverController = new CommandXboxController(clockControllerPort);
    }

    public CommandXboxController getDriverController() {
        return driverController;
    }
}