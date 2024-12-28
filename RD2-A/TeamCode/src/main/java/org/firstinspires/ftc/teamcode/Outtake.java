//region imports
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
//endregion

public class Outtake {
    private HardwareInit rd1;
    private Telemetry telemetry;
    private double t1 = 0.5;
    private double t2 = 0.5;
    private double t3 = 0.30;
    private double t4 = 0.5;
    private double t5 = 0.30;
    private double t6 = 0.5;

    private boolean a = false;
    public boolean b = false;
    public boolean c = false;
    private boolean d = false;
    public boolean e = false;
    public boolean f = false;
    private boolean g = false;

    public Outtake(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
    }

    public void clawOuttakeServoController(Gamepad _gamepad1) {
        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
        telemetry.update();
        if (_gamepad1.dpad_up) {
            a = true;
            b = true;
            c = true;
            d = true;
            e = true;
            f = true;
            g = true;
        }
        if (_gamepad1.dpad_down) {
            if (c) {
                t1 -= 0.009;
                t2 -= 0.009;
                t3 -= 0.009;
                t4 -= 0.009;
                t5 -= 0.009;
                t6 -= 0.009;

            }
        }
        if (_gamepad1.a) {
            if (a) {
                rd1.clawServoOuttake.setPosition(t1);
                t1 += 0.003;
                a = false;
                telemetry.addData("T1: ", t1);
            }
            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServoOuttake.getPosition());
            telemetry.update();
        } else if (_gamepad1.y) {
            if (b) {
            rd1.clawServoOuttake.setPosition(t2);
            t2 += 0.003;
            b = false;
            telemetry.addData("T2: ", t2);
        }
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
            if (d) {
                rd1.clawPivotShort.setPosition(t3);
                t3 += 0.003;
                d = false;
                telemetry.addData("T3: ", t3);
            }
            telemetry.addData("Incheietura deschisa, plasata la pozitia: ", rd1.clawPivotShort.getPosition());
            telemetry.update();
        } else if (_gamepad1.b) {
            if (e) {
                rd1.clawPivotShort.setPosition(t4);
                t4 += 0.003;
                e = false;
                telemetry.addData("T4: ", t4);
            }
            telemetry.addData("Incheietura inchisa, plasata la pozitia: ", rd1.clawPivotShort.getPosition());
            telemetry.update();
        }
        telemetry.addData("Incheietura plasata la pozitia: ", rd1.clawPivotShort.getPosition());
        telemetry.update();
    }

    public void clawPivotLongController(Gamepad _gamepad1) {
        telemetry.addData("Joint plasat la pozitia: ", rd1.clawPivotLong.getPosition());
        telemetry.update();
        if (_gamepad1.x) {
            if (f) {
                rd1.clawPivotLong.setPosition(t5);
                t5 += 0.003;
                f = false;
                telemetry.addData("T5: ", t5);
            }
            telemetry.addData("Joint deschis, plasat la pozitia: ", rd1.clawPivotLong.getPosition());
            telemetry.update();
        } else if (_gamepad1.b) {
            if (g) {
                rd1.clawPivotLong.setPosition(t6);
                t6 += 0.003;
                g = false;
                telemetry.addData("T6: ", t6);
            }
            telemetry.addData("Joint inchis, plasat la pozitia: ", rd1.clawPivotLong.getPosition());
            telemetry.update();
        }
        telemetry.addData("Joint plasat la pozitia: ", rd1.clawPivotLong.getPosition());
        telemetry.update();
    }
}
