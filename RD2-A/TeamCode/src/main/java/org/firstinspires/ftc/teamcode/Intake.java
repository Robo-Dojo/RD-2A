//region imports
package org.firstinspires.ftc.teamcode;
import com.acmerobotics.roadrunner.SleepAction;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
//endregion

// the class that controls the entire robot arm
public class Intake {
    private HardwareInit rd1;
    private Telemetry telemetry;

    public Intake(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
        rd1.clawServo1.setPosition(0.35);
        //rd1.clawOuttake.setPosition(0.6);
    }

        public void clawServo1(Gamepad _gamepad1) {
            telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo1.getPosition());
            telemetry.update();
            if (_gamepad1.a) {
                rd1.clawServo1.setPosition(0.35);
                telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServo1.getPosition());
                telemetry.update();
            } else if (_gamepad1.y) {
                rd1.clawServo1.setPosition(0.6);
                telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServo1.getPosition());
                telemetry.update();
            }
            telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo1.getPosition());
            telemetry.update();
        }

        public void intake(Gamepad _gamepad1) {    //glisiere orizontale
        //telemetry.addData("IntakeLeft la pozitia: ", rd1.intakeLeft.getPosition());
        //telemetry.addData("IntakeRight la pozitia: ", rd1.intakeRight.getPosition());
        telemetry.update();
        if (_gamepad1.dpad_right) {
//            rd1.intakeLeft.setPosition(0.48);
            rd1.intakeRight.setPosition(0.505);

            //telemetry.addData("IntakeLeft la pozitia: ", rd1.intakeLeft.getPosition());
            //telemetry.addData("IntakeRight la pozitia: ", rd1.intakeRight.getPosition());
            telemetry.update();
        } else if (_gamepad1.dpad_left) {
//            rd1.intakeLeft.setPosition(0.54);
            rd1.intakeRight.setPosition(0.435);

           // telemetry.addData("IntakeLeft la pozitia: ", rd1.intakeLeft.getPosition());
           // telemetry.addData("IntakeRight la pozitia: ", rd1.intakeRight.getPosition());

            telemetry.update();
        }
    }

    public void clawServo2(Gamepad _gamepad2) {
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo2.getPosition());
        telemetry.update();
        if (_gamepad2.dpad_left) {
            rd1.clawServo2.setPosition(0.48);
            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServo2.getPosition());
            telemetry.update();

        } else if (_gamepad2.dpad_up) {
            rd1.clawServo2.setPosition(0.5048);
            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServo2.getPosition());
            telemetry.update();
        } else if (_gamepad2.dpad_right) {
            rd1.clawServo2.setPosition(0.525);

        }
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo2.getPosition());
        telemetry.update();

    }
}

//    public void clawServo2(Gamepad _gamepad1) {
//        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo2.getPosition());
//        telemetry.update();
//        if (_gamepad1.a) {
//            rd1.clawServo2.setPosition(0.4);
//            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServo2.getPosition());
//            telemetry.update();
//        } else if (_gamepad1.y) {
//            rd1.clawServo2.setPosition(0.6);
//            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServo2.getPosition());
//            telemetry.update();
//        }
//        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo2.getPosition());
//        telemetry.update();
//    }

//}

