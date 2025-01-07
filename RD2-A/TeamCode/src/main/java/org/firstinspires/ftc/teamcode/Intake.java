//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
//endregion

// the class that controls the entire robot arm
public class  Intake {
    private HardwareInit rd1;
    private Telemetry telemetry;


    private long lastActionTime = 0;
    private int step = 0;
    private boolean isActive = false;
    private double intakeTwisterIncrementor = 0;
    private double middleAngleTwisterPosition = 0.5048;
    private boolean isIntakeClosing = false;

    public Intake(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
        rd1.clawServo.setPosition(0.25);
        rd1.twisterServo.setPosition(0.5048);
        intakeTwisterIncrementor = 0;
        middleAngleTwisterPosition = 0.5048;


    }

    private boolean isClawOpen = true; // Track whether the claw is open

    public void clawServoController(Gamepad _gamepad1) {
        if (_gamepad1.right_bumper) {
            if (isClawOpen) {
                rd1.clawServo.setPosition(0.55); // Close the claw
                isClawOpen = false;
            } else {
                rd1.clawServo.setPosition(0.25); // Open the claw
                isClawOpen = true;
            }

            // Debounce to avoid rapid toggling if the button is held
            while (_gamepad1.right_bumper) {
                // Wait for the button to be released
            }
        }
    }


    // control glisiere orizontale
    private boolean isIntakeOpen = false; // Track whether the intake is open

    public void intakeController(Gamepad _gamepad1) {
        // Check for right bumper press to toggle intake state
        if (_gamepad1.left_bumper) {
            if (isIntakeOpen) {
                // Close the intake
                rd1.intakeLeft.setPosition(0.435);
                rd1.intakeRight.setPosition(0.54);
                isIntakeOpen = false; // Update state
            } else {
                // Open the intake
                rd1.intakeLeft.setPosition(0.505);
                rd1.intakeRight.setPosition(0.48);
                isIntakeOpen = true; // Update state
            }

            // Debounce to prevent rapid toggling if the bumper is held
            while (_gamepad1.left_bumper) {
                // Wait for the button to be released
            }
        }
    }


//    public void twisterServoController(Gamepad _gamepad2) {
//        telemetry.addData("Gheara plasata la pozitia: ", rd1.twisterServo.getPosition());
//        telemetry.update();
//        if (_gamepad2.dpad_right) {
//            rd1.twisterServo.setPosition(0.48);
////            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.twisterServo.getPosition());
////            telemetry.update();
//
//        } else if (_gamepad2.dpad_up) {
//            rd1.twisterServo.setPosition(0.5048);
////            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.twisterServo.getPosition());
////            telemetry.update();
//        } else if (_gamepad2.dpad_left) {
//            rd1.twisterServo.setPosition(0.525);
//
//        }
//        //telemetry.addData("Gheara plasata la pozitia: ", rd1.twisterServo.getPosition());
//        //telemetry.update();
//
//    }

    public void twisterServoController(Gamepad _gamepad1) {
        if (isIntakeClosing) return; // Prevent adjustments while intake is closing

        telemetry.addData("Rotatie gheara la pozitia: ", rd1.twisterServo.getPosition());
        telemetry.update();
        if (_gamepad1.dpad_right && (middleAngleTwisterPosition + intakeTwisterIncrementor < 0.57)) {
            intakeTwisterIncrementor += 0.001;
            telemetry.addData("Rotatie gheara la pozitia: ", rd1.twisterServo.getPosition());
            telemetry.update();
        } else if (_gamepad1.dpad_up) {
            rd1.twisterServo.setPosition(middleAngleTwisterPosition);
            intakeTwisterIncrementor = 0;
        } else if (_gamepad1.dpad_left && middleAngleTwisterPosition + intakeTwisterIncrementor > 0.4463) {
            intakeTwisterIncrementor -= 0.001;
        }
        rd1.twisterServo.setPosition(middleAngleTwisterPosition + intakeTwisterIncrementor);

        telemetry.addData("Rotatie gheara la pozitia: ", rd1.twisterServo.getPosition());
        telemetry.update();
    }




    public void servoJointController(Gamepad _gamepad1) {
        telemetry.addData("Joint plasat la pozitia: ", rd1.clawServoJoint.getPosition());
        telemetry.update();
        if (_gamepad1.b) {
            rd1.clawServoJoint.setPosition(0.52);
            //52
//            telemetry.addData("Joint inchis, plasat la pozitia: ", rd1.clawServoJoint.getPosition());
//            telemetry.update();
        } else
        if (_gamepad1.y) {
            rd1.clawServoJoint.setPosition(0.566);
            //568
//            telemetry.addData("Joint deschis, plasat la pozitia: ", rd1.clawServoJoint.getPosition());
//            telemetry.update();
        }
        //telemetry.addData("Joint plasat la pozitia: ", rd1.clawServoJoint.getPosition());
        //telemetry.update();
    }

    public void intakeClose(Gamepad _gamepad1) {
        if (_gamepad1.dpad_down && !isActive) {
            // Start the sequence
            isActive = true;
            isIntakeClosing = true; // Lock the twister controller
            lastActionTime = System.currentTimeMillis();
            step = 0;
        }

        if (!isActive) return;

        long currentTime = System.currentTimeMillis();

        // Execute the sequence step-by-step
        if (step == 0 && currentTime - lastActionTime >= 0) {
            rd1.clawServoJoint.setPosition(0.52);
            lastActionTime = currentTime;
            step++;
        } else if (step == 1 && currentTime - lastActionTime >= 100) {
            rd1.twisterServo.setPosition(0.56);
            lastActionTime = currentTime;
            step++;
        } else if (step == 2 && currentTime - lastActionTime >= 100) {
            rd1.intakeLeft.setPosition(0.505);
            rd1.intakeRight.setPosition(0.48);
            lastActionTime = currentTime;
            step++;
        } else if (step == 3 && currentTime - lastActionTime >= 700) {
            rd1.clawServoJoint.setPosition(0.465);
            rd1.twisterServo.setPosition(middleAngleTwisterPosition); // Move to the middle position
            intakeTwisterIncrementor = 0; // Reset incrementor to ensure proper middle position
            isActive = false; // End the sequence
            isIntakeClosing = false; // Unlock the twister controller
        }
    }

}