package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeClaw {

    private HardwareInit rd1;
    private Telemetry telemetry;

    public IntakeClaw(HardwareInit rd1, Telemetry telemetry) {
        this.rd1 = rd1;
        this.telemetry = telemetry;
         rd1.joint.setPosition(0.145);
    }

    public void joint(Gamepad _gamepad2){

        telemetry.addData("Gheara plasata la pozitia: ", rd1.joint.getPosition());
        telemetry.update();
        if (_gamepad2.dpad_up) {
            rd1.joint.setPosition(0.09);
            //rd1.clawServo.resetDeviceConfigurationForOpMode();
            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.joint.getPosition());
            telemetry.update();
        } else if (_gamepad2.dpad_down) {
            rd1.joint.setPosition(0.145);
            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.joint.getPosition());
            telemetry.update();
        }
        telemetry.addData("Gheara plasata la pozitia: ", rd1.joint.getPosition());
        telemetry.update();
    }
}
