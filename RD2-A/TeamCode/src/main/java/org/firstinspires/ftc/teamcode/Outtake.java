//region imports
package org.firstinspires.ftc.teamcode;
import static org.firstinspires.ftc.teamcode.FileWrite.writeToFile;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;
//endregion

public class Outtake {
    private HardwareInit rd1;
    private Telemetry telemetry;

    private long lastActionTime = 0;
    private int step = 0;
    private boolean isActive = false;
    private long lastActionTime1 = 0;
    private int step1 = 0;
    private boolean isActive1 = false;
    private long lastActionTime2 = 0;
    private int step2 = 0;
    private boolean isActive2 = false;

    public Outtake(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
        rd1.clawServoOuttake.setPosition(0.483);
        rd1.clawPivotShort.setPosition(1);
    }

    public void clawOuttakeServoController(Gamepad _gamepad2) {
//        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
//        telemetry.update();
        if (_gamepad2.a) {
            rd1.clawServoOuttake.setPosition(0.4789);
//            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
//            telemetry.update();
        }
        else if (_gamepad2.y) {
            rd1.clawServoOuttake.setPosition(0.5);
//            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
//            telemetry.update();
        }
//        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
//        telemetry.update();
    }

    public void clawPivotShortController(Gamepad _gamepad2) {
//        telemetry.addData("Incheietura plasata la pozitia: ", rd1.clawPivotShort.getPosition());
//        telemetry.update();
        if (_gamepad2.x) {
            //795
            rd1.clawPivotShort.setPosition(1);
//            telemetry.addData("Incheietura deschisa, plasata la pozitia: ", rd1.clawPivotShort.getPosition());
//            telemetry.update();
        } else if (_gamepad2.b) {
            rd1.clawPivotShort.setPosition(0.76);
//            telemetry.addData("Incheietura inchisa, plasata la pozitia: ", rd1.clawPivotShort.getPosition());
//            telemetry.update();
        }
//        telemetry.addData("Incheietura plasata la pozitia: ", rd1.clawPivotShort.getPosition());
//        telemetry.update();
    }

//    public void clawPivotLongController(Gamepad _gamepad2) {
//        if (_gamepad2.dpad_left) {
//            rd1.clawPivotLong.setPosition(0.485);
//            telemetry.addData("Joint inchis, plasat la pozitia: ", rd1.clawPivotLong.getPosition());
//            telemetry.update();
//        } else if (_gamepad2.dpad_right) {
//                rd1.clawPivotLong.setPosition(0.56);
//
//            telemetry.addData("Joint deschis, plasat la pozitia: ", rd1.clawPivotLong.getPosition());
//            telemetry.update();
//        }
////        telemetry.addData("Joint plasat la pozitia: ", rd1.clawPivotLong.getPosition());
////        telemetry.update();
//    }

    private double currentPosition = 0.485; // Starting position (you can set this based on initial servo state)
    private double targetPosition = currentPosition; // Target position initialized to current position
    private double stepSize = 0.003; // Increment step for the servo (you can adjust this value for faster/slower movement)
    private long lastUpdateTime = System.nanoTime(); // Time reference to control speed

    public void clawPivotLongController(Gamepad _gamepad2) {
        long currentTime = System.nanoTime();
        if (_gamepad2.dpad_left) {
            targetPosition = 0.485; // Target position when button is pressed
        } else if (_gamepad2.dpad_right) {
            targetPosition = 0.56; // Target position when button is pressed
        }

        // If the current time exceeds the time interval for movement, update the position
        if (currentTime - lastUpdateTime >= 1) {  // Control the update frequency (e.g., every 20ms)
            lastUpdateTime = currentTime;

            // Gradually move the servo to the target position
            if (currentPosition < targetPosition) {
                currentPosition += stepSize;  // Move towards target position
                if (currentPosition > targetPosition) {  // Prevent overshooting
                    currentPosition = targetPosition;
                }
            } else if (currentPosition > targetPosition) {
                currentPosition -= stepSize;  // Move towards target position
                if (currentPosition < targetPosition) {  // Prevent overshooting
                    currentPosition = targetPosition;
                }
            }

            // Set the new position to the servo
            rd1.clawPivotLong.setPosition(currentPosition);

            // Telemetry updates
            telemetry.addData("Claw Pivot Position: ", currentPosition);
            telemetry.update();
        }
    }


    public void outtakeFromIntakeController(Gamepad _gamepad2) {
        if (_gamepad2.left_bumper && !isActive) {
            isActive = true;
            lastActionTime = System.currentTimeMillis();
            step = 0;
        }
        if (!isActive) {
            return;
        }
        long currentTime = System.currentTimeMillis();
        if (step == 0 && currentTime - lastActionTime >= 0) {
            rd1.clawServoOuttake.setPosition(0.51);
            lastActionTime = currentTime;
            step++;
        } else if (step == 1 && currentTime - lastActionTime >= 100) {
            rd1.clawServo.setPosition(0.35);
            lastActionTime = currentTime;
            step++;
        } else if (step == 2 && currentTime - lastActionTime >= 100) {
            rd1.clawPivotLong.setPosition(0.56);
            rd1.clawPivotShort.setPosition(0.57);
            isActive = false; // End the sequence
        }
    }

public void outtakeCloseController(Gamepad _gamepad2) {
    if (_gamepad2.dpad_down && !isActive1) {
        // Start the sequence
        isActive1 = true;
        lastActionTime1 = System.currentTimeMillis();
        step1 = 0;
    }
    if (!isActive1) {
        return;
    }
    long currentTime1 = System.currentTimeMillis();
    if (step1 == 0 && currentTime1 - lastActionTime1 >= 0) {
        rd1.clawServoOuttake.setPosition(0.5);
        lastActionTime1 = currentTime1;
        step1++;}
    else if (step1 == 1 && currentTime1 - lastActionTime1 >= 100){
        rd1.clawPivotLong.setPosition(0.486);
        rd1.clawPivotShort.setPosition(0.795);
        step1++;
    }
     else if (step1 == 2 && currentTime1 - lastActionTime1 >= 100) {
        rd1.armLifterMotorLeft.setTargetPosition(20);
        rd1.armLifterMotorRight.setTargetPosition(-20);
        rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rd1.armLifterMotorLeft.setPower(-1);
        rd1.armLifterMotorRight.setPower(1);
        rd1.clawServoOuttake.setPosition(0.4789);
        step1++;
    }else if (step1 == 3 && currentTime1 - lastActionTime1 >= 100) {
        rd1.clawPivotLong.setPosition(0.485);
        isActive1 = false; // End the sequence
    }
    if(rd1.armLifterMotorLeft.getCurrentPosition()<=20 && rd1.armLifterMotorRight.getCurrentPosition()>=-20){
        rd1.armLifterMotorLeft.setPower(0);
        rd1.armLifterMotorRight.setPower(0);
    }
}

    public void outtakeSpecimenController(Gamepad _gamepad2) {
        if (_gamepad2.dpad_up && !isActive2) {
            // Start the sequence
            isActive2 = true;
            lastActionTime2 = System.currentTimeMillis();
            step2 = 0;

            // Set the target positions for the sliders

        }

        if (!isActive2) {
            return; // Do nothing if the sequence is not active
        }

        long currentTime2 = System.currentTimeMillis();

        if (step2 == 0 && currentTime2 - lastActionTime1 >= 0) {
            rd1.armLifterMotorLeft.setTargetPosition(900);
            rd1.armLifterMotorRight.setTargetPosition(-900);
            rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rd1.armLifterMotorLeft.setPower(-0.8);
            rd1.armLifterMotorRight.setPower(0.8);
            rd1.clawPivotShort.setPosition(0.795);
                lastActionTime2 = currentTime2;
                step2++;
        }
        else if (step2 == 1 && currentTime2 - lastActionTime2 >= 900) {
            rd1.clawServoOuttake.setPosition(0.4789); // Open the claw
            step2++;
        }
         else if (step2 == 2 && currentTime2 - lastActionTime2 >= 600) {
            rd1.clawServoOuttake.setPosition(0.5);
            step2++;
        }
        else if (step2 == 3 && currentTime2 - lastActionTime2 >= 100) {
            rd1.clawPivotShort.setPosition(0.795);
            rd1.clawPivotLong.setPosition(0.486);
            step2++;
        }
        else if (step2 == 4 && currentTime2 - lastActionTime2 >= 100) {
            rd1.clawPivotLong.setPosition(0.485);
            step2++;
        }
        else if (step2 == 5 && currentTime2 - lastActionTime2 >= 100) {
            rd1.clawServoOuttake.setPosition(0.4789);
            isActive2 = false; // End the sequence
        }
    }

}
