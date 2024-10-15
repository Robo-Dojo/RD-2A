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
            sleep(400);  // Move forward for 0.4 seconds, towards front limit

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontLeftMotor.setPower(-1);
            rd1.frontRightMotor.setPower(-1);
            rd1.rearLeftMotor.setPower(-1);
            rd1.rearRightMotor.setPower(-1);
            sleep(800); // Move backwards for 0.5 seconds, towards back limit

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontLeftMotor.setPower(1);
            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(1);
            rd1.rearRightMotor.setPower(1);
            sleep(400);  // Move forward for 0.4 seconds, returns to starting point

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontLeftMotor.setPower(1);
            rd1.frontRightMotor.setPower(-1);
            rd1.rearLeftMotor.setPower(-1);
            rd1.rearRightMotor.setPower(1);
            sleep(400);  // Move right for 0.4 seconds, towards right limit

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontLeftMotor.setPower(-1);
            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(1);
            rd1.rearRightMotor.setPower(-1);
            sleep(800); // Move left for 0.8 seconds, towards left limit

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontLeftMotor.setPower(1);
            rd1.frontRightMotor.setPower(-1);
            rd1.rearLeftMotor.setPower(-1);
            rd1.rearRightMotor.setPower(1);
            sleep(400);  // Move right for 0.4 seconds, returns to starting point

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontLeftMotor.setPower(1);
            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(1);
            rd1.rearRightMotor.setPower(1);
            sleep(400);  // Move forward for 0.4 seconds, towards upper right limit

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontLeftMotor.setPower(-1);
            rd1.rearRightMotor.setPower(-1);
            sleep(800); // Move backwards for 0.8 seconds, towards lower left limit

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontLeftMotor.setPower(1);
            rd1.rearRightMotor.setPower(1);
            sleep(200);  // Move forward for 0.4 seconds, returns to starting point

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(1);
            sleep(200);  // Move forward for 0.4 seconds, towards upper left limit

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontRightMotor.setPower(-1);
            rd1.rearLeftMotor.setPower(-1);
            sleep(800); // Move backwards for 0.8 seconds, towards lower right limit

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(1);
            sleep(200);  // Move forward for 0.4 seconds, returns to starting point

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

            rd1.frontLeftMotor.setPower(-1);
            rd1.frontRightMotor.setPower(1);
            rd1.rearLeftMotor.setPower(-1);
            rd1.rearRightMotor.setPower(1);
            sleep(1800); // Will rotate for 2 seconds

            rd1.frontLeftMotor.setPower(0);
            rd1.frontRightMotor.setPower(0);
            rd1.rearLeftMotor.setPower(0);
            rd1.rearRightMotor.setPower(0);
            sleep(300);

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