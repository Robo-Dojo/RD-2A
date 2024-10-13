package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Config
@Autonomous(name = "AutoPresentation", group = "Autonomous")
public class AutoPresentation extends LinearOpMode {

    HardwareInit rd1 = new HardwareInit();

    @Override
    public void runOpMode() {

//        rd1.frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
//        rd1.rearLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
//        rd1.rearRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//        rd1.frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

//        In caz de autonomia ignora HardwareInit, linile 79-83

        rd1.init(hardwareMap, true);

        waitForStart();

        if (opModeIsActive()) {
            rd1.frontLeftMotor.setPower(1);
            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(1);
            rd1.rearRightMotor.setPower(1);

            sleep(440);  // Move forward for 0.44 seconds, towards front limit

            rd1.frontLeftMotor.setPower(-1);
            rd1.frontRightMotor.setPower(-1);
            rd1.rearLeftMotor.setPower(-1);
            rd1.rearRightMotor.setPower(-1);

            sleep(880); // Move backwards for 0.88 seconds, towards back limit

            rd1.frontLeftMotor.setPower(1);
            rd1.frontRightMotor.setPower(-1);
            rd1.rearLeftMotor.setPower(-1);
            rd1.rearRightMotor.setPower(1);

            sleep(440);  // Move forward for 0.44 seconds, returns to starting point

            rd1.frontLeftMotor.setPower(-1);
            rd1.frontRightMotor.setPower(-1);
            rd1.rearLeftMotor.setPower(-1);
            rd1.rearRightMotor.setPower(-1);

            sleep(440);  // Move right for 0.44 seconds, towards right limit

            rd1.frontLeftMotor.setPower(-1);
            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(1);
            rd1.rearRightMotor.setPower(-1);

            sleep(880); // Move left for 0.88 seconds, towards left limit

            rd1.frontLeftMotor.setPower(-1);
            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(1);
            rd1.rearRightMotor.setPower(-1);

            sleep(440);  // Move right for 0.44 seconds, returns to starting point

            rd1.frontLeftMotor.setPower(-1);
            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(1);
            rd1.rearRightMotor.setPower(-1);

            sleep(440);  // Move forward for 0.44 seconds, towards upper right limit

            rd1.frontLeftMotor.setPower(1);
            rd1.rearRightMotor.setPower(1);

            sleep(880); // Move backwards for 0.88 seconds, towards lower left limit

            rd1.frontLeftMotor.setPower(-1);
            rd1.rearRightMotor.setPower(-1);

            sleep(440);  // Move forward for 0.44 seconds, returns to starting point

            rd1.frontLeftMotor.setPower(1);
            rd1.rearRightMotor.setPower(1);

            sleep(440);  // Move forward for 0.44 seconds, towards upper left limit

            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(1);

            sleep(880); // Move backwards for 0.88 seconds, towards lower right limit

            rd1.frontRightMotor.setPower(-1);
            rd1.rearLeftMotor.setPower(-1);

            sleep(440);  // Move forward for 0.44 seconds, returns to starting point

            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(1);

            sleep(2000); // Will rotate for 2 seconds

            rd1.frontLeftMotor.setPower(1);
            rd1.frontRightMotor.setPower(-1);
            rd1.rearLeftMotor.setPower(1);
            rd1.rearRightMotor.setPower(-1);

            sleep(1000); // Motors stop

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);


        }
    }
}