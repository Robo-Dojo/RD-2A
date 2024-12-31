//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
//endregion

// the class that controls the entire robot arm
public class  Intake {
    private HardwareInit rd1;
    private Telemetry telemetry;

    public Intake(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
        rd1.clawServo.setPosition(0.35);
       // rd1.twisterServo.setPosition(0.5048);
    }

    public void clawServoController(Gamepad _gamepad2) {
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo.getPosition());
        telemetry.update();
        if (_gamepad2.a) {
            rd1.clawServo.setPosition(0.35);
            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServo.getPosition());
            telemetry.update();
        } else if (_gamepad2.y) {
            rd1.clawServo.setPosition(0.6);
            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServo.getPosition());
            telemetry.update();
        }
        //telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo.getPosition());
        //telemetry.update();
    }

//    // control glisiere orizontale
//    public void intakeController(Gamepad _gamepad2) {
//    // telemetry.addData("IntakeLeft la pozitia: ", rd1.intakeLeft.getPosition());
//    // telemetry.addData("IntakeRight la pozitia: ", rd1.intakeRight.getPosition());
//    // telemetry.update();
//    //if (_gamepad1.dpad_right) {
//        //rd1.intakeLeft.setPosition(0.48);
//        //rd1.intakeRight.setPosition(0.505);
//        // telemetry.addData("IntakeLeft la pozitia: ", rd1.intakeLeft.getPosition());
//        // telemetry.addData("IntakeRight la pozitia: ", rd1.intakeRight.getPosition());
//        // telemetry.update();
//    //} else
//    if (_gamepad2.right_bumper) {
//        rd1.intakeLeft.setPosition(0.54);
//        rd1.intakeRight.setPosition(0.435);
//        // telemetry.addData("IntakeLeft la pozitia: ", rd1.intakeLeft.getPosition());
//        // telemetry.addData("IntakeRight la pozitia: ", rd1.intakeRight.getPosition());
//        // telemetry.update();
//    }
//    }
//
//    public void twisterServoController(Gamepad _gamepad2) {
//        telemetry.addData("Gheara plasata la pozitia: ", rd1.twisterServo.getPosition());
//        telemetry.update();
//        if (_gamepad2.dpad_left) {
//            rd1.twisterServo.setPosition(0.48);
//            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.twisterServo.getPosition());
//            telemetry.update();
//
//        } else if (_gamepad2.dpad_up) {
//            rd1.twisterServo.setPosition(0.5048);
//            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.twisterServo.getPosition());
//            telemetry.update();
//        } else if (_gamepad2.dpad_right) {
//            rd1.twisterServo.setPosition(0.525);
//
//        }
//        //telemetry.addData("Gheara plasata la pozitia: ", rd1.twisterServo.getPosition());
//        //telemetry.update();
//
//    }
//
//        public void servoJointController(Gamepad _gamepad2) {
//        telemetry.addData("Joint plasat la pozitia: ", rd1.clawServoJoint.getPosition());
//        telemetry.update();
//        //if (_gamepad2.x) {
//            //rd1.clawServoJoint.setPosition(0.462);
//            //telemetry.addData("Joint inchis, plasat la pozitia: ", rd1.clawServoJoint.getPosition());
//            //telemetry.update();
//        //} else
//        if (_gamepad2.b) {
//            rd1.clawServoJoint.setPosition(0.568);
//            telemetry.addData("Joint deschis, plasat la pozitia: ", rd1.clawServoJoint.getPosition());
//            telemetry.update();
//        }
//        //telemetry.addData("Joint plasat la pozitia: ", rd1.clawServoJoint.getPosition());
//        //telemetry.update();
//    }
//
//    public void intakeClose(Gamepad _gamepad2){
//        while(_gamepad2.dpad_down) {
//            rd1.clawServoJoint.setPosition(0.54);
//            rd1.twisterServo.setPosition(0.56);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//            rd1.intakeLeft.setPosition(0.48);
//            rd1.intakeRight.setPosition(0.505);
//            rd1.clawServoJoint.setPosition(0.462);
//            rd1.twisterServo.setPosition(0.5048);
//        }
//    }
    }



