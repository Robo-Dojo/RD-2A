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

    public Outtake(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
        rd1.clawServoOuttake.setPosition(0.4789);
        rd1.clawPivotShort.setPosition(0.76);
    }

    public void clawOuttakeServoController(Gamepad _gamepad1) {
//        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
//        telemetry.update();
        if (_gamepad1.a) {
            rd1.clawServoOuttake.setPosition(0.4789);
//            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
//            telemetry.update();
        }
        else if (_gamepad1.y) {
            rd1.clawServoOuttake.setPosition(0.5);
//            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
//            telemetry.update();
        }
//        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
//        telemetry.update();
    }

    public void clawPivotShortController(Gamepad _gamepad1) {
//        telemetry.addData("Incheietura plasata la pozitia: ", rd1.clawPivotShort.getPosition());
//        telemetry.update();
        if (_gamepad1.x) {
            rd1.clawPivotShort.setPosition(0.77);
//            telemetry.addData("Incheietura deschisa, plasata la pozitia: ", rd1.clawPivotShort.getPosition());
//            telemetry.update();
        } else if (_gamepad1.b) {
            rd1.clawPivotShort.setPosition(0.52);
//            telemetry.addData("Incheietura inchisa, plasata la pozitia: ", rd1.clawPivotShort.getPosition());
//            telemetry.update();
        }
//        telemetry.addData("Incheietura plasata la pozitia: ", rd1.clawPivotShort.getPosition());
//        telemetry.update();
    }


    public void clawPivotLongController(Gamepad _gamepad1) {
        if (_gamepad1.dpad_left) {
            rd1.clawPivotLong.setPosition(0.577);
            telemetry.addData("Joint deschis, plasat la pozitia: ", rd1.clawPivotLong.getPosition());
            telemetry.update();
        } else if (_gamepad1.dpad_right) {
                rd1.clawPivotLong.setPosition(0.504);

            telemetry.addData("Joint inchis, plasat la pozitia: ", rd1.clawPivotLong.getPosition());
            telemetry.update();
        }
//        telemetry.addData("Joint plasat la pozitia: ", rd1.clawPivotLong.getPosition());
//        telemetry.update();
    }

    public void outtakeFromIntakeController(Gamepad _gamepad2) {
        if (_gamepad2.left_trigger>0 && !isActive) {
            // Start the sequence
            isActive = true;
            lastActionTime = System.currentTimeMillis();
            step = 0;
        }

        if (!isActive) {
            return; // Do nothing if the sequence is not active
        }

        long currentTime = System.currentTimeMillis();

        // Execute the sequence step-by-step
        if (step == 0 && currentTime - lastActionTime >= 0) {
            rd1.clawServoOuttake.setPosition(0.51);
            lastActionTime = currentTime;
            step++;
        } else if (step == 1 && currentTime - lastActionTime >= 100) {
            rd1.clawServo.setPosition(0.35);
            lastActionTime = currentTime;
            step++;
        } else if (step == 2 && currentTime - lastActionTime >= 100) {
            rd1.clawPivotLong.setPosition(0.577);
            rd1.clawPivotShort.setPosition(0.52);
            isActive = false; // End the sequence
        }
    }

//    public void outtakeController(Gamepad _gamepad2) {
//        if (_gamepad2.right_trigger>0 && !isActive) {
//            // Start the sequence
//            isActive = true;
//            lastActionTime = System.currentTimeMillis();
//            step = 0;
//        }
//
//        if (!isActive) {
//            return; // Do nothing if the sequence is not active
//        }
//
//        long currentTime = System.currentTimeMillis();
//
//        // Execute the sequence step-by-step
//        if (step == 0 && currentTime - lastActionTime >= 0) {
//            rd1.armLifterMotorLeft.setTargetPosition(50);
//            rd1.armLifterMotorRight.setTargetPosition(-50);
//            rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
//            rd1.armLifterMotorLeft.setPower(-0.8);
//            rd1.armLifterMotorRight.setPower(0.8);
//            if(Math.abs(rd1.armLifterMotorLeft.getCurrentPosition() - 2200) <= 10 && Math.abs(rd1.armLifterMotorRight.getCurrentPosition() + 2200) <= 10) {
//                rd1.clawServoOuttake.setPosition(0.4789);
//            }
//            lastActionTime = currentTime;
//            step++;
//        } else if (step == 1 && currentTime - lastActionTime >= 100) {
//            rd1.clawPivotShort.setPosition(0.77);
//            rd1.clawPivotLong.setPosition(0.504);
//            isActive = false; // End the sequence
//        }
//    }
public void outtakeCloseController(Gamepad _gamepad2) {

    if (_gamepad2.dpad_down && !isActive) {
        // Start the sequence
        isActive = true;
        lastActionTime = System.currentTimeMillis();
        step = 0;
    }

    if (!isActive) {
        return; // Do nothing if the sequence is not active
    }

    long currentTime = System.currentTimeMillis();

    // Execute the sequence step-by-step
    if (step == 0 && currentTime - lastActionTime >= 0) {
        rd1.clawPivotLong.setPosition(0.504);
        rd1.clawPivotShort.setPosition(0.77);
        lastActionTime = currentTime;
        step++;
    } else if (step == 1 && currentTime - lastActionTime >= 100) {
        rd1.armLifterMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rd1.armLifterMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rd1.armLifterMotorLeft.setTargetPosition(50);
        rd1.armLifterMotorRight.setTargetPosition(-50);
        rd1.armLifterMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rd1.armLifterMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rd1.armLifterMotorLeft.setPower(-0.8);
        rd1.armLifterMotorRight.setPower(0.8);
        if(rd1.armLifterMotorLeft.getCurrentPosition()<=50 && rd1.armLifterMotorRight.getCurrentPosition()>=-50){
            rd1.armLifterMotorLeft.setPower(0);
            rd1.armLifterMotorRight.setPower(0);
        }
        isActive = false; // End the sequence
    }
}

}
