//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
//endregion

// the class that controls the entire robot arm
public class Intake1 {
    private HardwareInit rd1;
    private Telemetry telemetry;

    public Intake1(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
        rd1.clawServo1.setPosition(0.44);
        rd1.clawServo2.setPosition(0.378);
        //rd1.clawOuttake.setPosition(0.6);
    }


    public void clawServo1(Gamepad _gamepad2) {  //cleste orizontal
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo1.getPosition());
        telemetry.update();
        if (_gamepad2.a) {
            rd1.clawServo1.setPosition(0.44);

            //rd1.clawServo.resetDeviceConfigurationForOpMode();
            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServo1.getPosition());
            telemetry.update();
        } else if (_gamepad2.y) {
            rd1.clawServo1.setPosition(0.475);
            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServo1.getPosition());
            telemetry.update();
        }
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo1.getPosition());
        telemetry.update();
    }


    public void clawServo2(Gamepad _gamepad2) {   //joint orizontal
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo2.getPosition());
        telemetry.update();
        if (_gamepad2.x) {
            rd1.clawServo2.setPosition(0.378);

            //rd1.clawServo.resetDeviceConfigurationForOpMode();
            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServo2.getPosition());
            telemetry.update();
        } else if (_gamepad2.b) {
            rd1.clawServo2.setPosition(0.487);
            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServo2.getPosition());
            telemetry.update();
        }
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo2.getPosition());
        telemetry.update();
    }


    public void intake(Gamepad _gamepad2) {    //glisiere orizontale
        telemetry.addData("IntakeLeft la pozitia: ", rd1.intakeLeft.getPosition());
        telemetry.addData("IntakeRight la pozitia: ", rd1.intakeRight.getPosition());
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo2.getPosition());
        telemetry.update();
        if (_gamepad2.dpad_right) {
            rd1.intakeLeft.setPosition(1.0);
            rd1.intakeRight.setPosition(0.0);
            //rd1.clawServo2.setPosition(0.487);
            //rd1.clawServo.resetDeviceConfigurationForOpMode();
            telemetry.addData("IntakeLeft la pozitia: ", rd1.intakeLeft.getPosition());
            telemetry.addData("IntakeRight la pozitia: ", rd1.intakeRight.getPosition());
            telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo2.getPosition());
            telemetry.update();
        } else if (_gamepad2.dpad_left) {
            rd1.intakeLeft.setPosition(0.0);
            rd1.intakeRight.setPosition(1.0);
            //rd1.clawServo2.setPosition(0.375);
            telemetry.addData("IntakeLeft la pozitia: ", rd1.intakeLeft.getPosition());
            telemetry.addData("IntakeRight la pozitia: ", rd1.intakeRight.getPosition());
            telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo2.getPosition());
            telemetry.update();
        }

        telemetry.addData("IntakeLeft la pozitia: ", rd1.intakeLeft.getPosition());
        telemetry.addData("IntakeRight la pozitia: ", rd1.intakeRight.getPosition());
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo2.getPosition());
        telemetry.update();}


    public void clawIntake(Gamepad _gamepad2) {   //joint outtake
        telemetry.addData("Intake la pozitia: ", rd1.clawIntake.getPosition());
        telemetry.update();
        if (_gamepad2.right_stick_y>0){
            rd1.clawIntake.setPosition(0.8);
            telemetry.addData("Intake la pozitia: ", rd1.clawIntake.getPosition());
            telemetry.update();
        } else if (_gamepad2.right_stick_y<0) {
            rd1.clawIntake.setPosition(0.4);
            telemetry.addData("Intake la pozitia: ", rd1.clawIntake.getPosition());
            telemetry.update();
        }

        telemetry.addData("Intake la pozitia: ", rd1.clawIntake.getPosition());
        telemetry.update();}

    public void clawOuttake(Gamepad _gamepad2) {    //cleste outtake
        telemetry.addData("Intake la pozitia: ", rd1.clawOuttake.getPosition());
        telemetry.update();
        if (_gamepad2.dpad_up){
            rd1.clawOuttake.setPosition(0.53);
            telemetry.addData("Intake la pozitia: ", rd1.clawOuttake.getPosition());
            telemetry.update();
        } else if (_gamepad2.dpad_down) {
            rd1.clawOuttake.setPosition(0.57);
            telemetry.addData("Intake la pozitia: ", rd1.clawOuttake.getPosition());
            telemetry.update();
        }

        telemetry.addData("Intake la pozitia: ", rd1.clawOuttake.getPosition());
        telemetry.update();}

}


