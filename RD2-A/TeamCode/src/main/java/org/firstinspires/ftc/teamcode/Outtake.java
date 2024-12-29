//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;
//endregion

public class Outtake {
    private HardwareInit rd1;
    private Telemetry telemetry;

    public Outtake(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
        rd1.clawServoOuttake.setPosition(0.4789);
    }

    public void clawOuttakeServoController(Gamepad _gamepad1) {
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
        telemetry.update();
        if (_gamepad1.a) {
            rd1.clawServoOuttake.setPosition(0.4789);
            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
            telemetry.update();
        } else if (_gamepad1.y) {
            rd1.clawServoOuttake.setPosition(0.62);
            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
            telemetry.update();
        }
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
        telemetry.update();
    }

    public void clawPivotShortController(Gamepad _gamepad1) {
        telemetry.addData("Incheietura plasata la pozitia: ", rd1.clawPivotShort.getPosition());
        telemetry.update();
        if (_gamepad1.x) {
            rd1.clawPivotShort.setPosition(0.57);
            telemetry.addData("Incheietura deschisa, plasata la pozitia: ", rd1.clawPivotShort.getPosition());
            telemetry.update();
        } else if (_gamepad1.b) {
            rd1.clawPivotShort.setPosition(0.74);
            telemetry.addData("Incheietura inchisa, plasata la pozitia: ", rd1.clawPivotShort.getPosition());
            telemetry.update();
        }
        telemetry.addData("Incheietura plasata la pozitia: ", rd1.clawPivotShort.getPosition());
        telemetry.update();
    }

//    public void clawPivotLongController(Gamepad _gamepad1) {
//        telemetry.addData("Joint plasat la pozitia: ", rd1.clawPivotLong.getPosition());
//        telemetry.update();
//        if (_gamepad1.dpad_left) {
//            rd1.clawPivotLong.setPosition(0.61);
//            telemetry.addData("Joint deschis, plasat la pozitia: ", rd1.clawPivotLong.getPosition());
//            telemetry.update();
//        } else if (_gamepad1.dpad_right) {
//            rd1.clawPivotLong.setPosition(0.95);
//            telemetry.addData("Joint inchis, plasat la pozitia: ", rd1.clawPivotLong.getPosition());
//            telemetry.update();
//        }
//        telemetry.addData("Joint plasat la pozitia: ", rd1.clawPivotLong.getPosition());
//        telemetry.update();
//    }
}
