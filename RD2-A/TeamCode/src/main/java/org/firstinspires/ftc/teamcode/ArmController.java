//package org.firstinspires.ftc.teamcode;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Gamepad;
//import org.firstinspires.ftc.robotcore.external.Telemetry;
//import org.firstinspires.ftc.teamcode.HardwareInit;
//
//public class ArmController {
//
//    private HardwareInit rd1;
//    private Telemetry telemetry;
//
//    public ArmController(HardwareInit rd1, Telemetry telemetry) {
//        this.rd1 = rd1;
//        this.telemetry = telemetry;
//       // rd1.clawServo.setPosition(1.0);
//    }}
//
//
////    public void clawServo(Gamepad _gamepad2) {
////        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo.getPosition());
////        telemetry.update();
////        if (_gamepad2.a) {
////            rd1.clawServo.setPosition(0.96);
////            //rd1.clawServo.resetDeviceConfigurationForOpMode();
////            telemetry.addData("Gheara deschisa, plasata la pozitia: ", rd1.clawServo.getPosition());
////            telemetry.update();
////        } else if (_gamepad2.y) {
////            rd1.clawServo.setPosition(1.0);
////            telemetry.addData("Gheara inchisa, plasata la pozitia: ", rd1.clawServo.getPosition());
////            telemetry.update();
////        }
////        telemetry.addData("Gheara plasata la pozitia: ", rd1.clawServo.getPosition());
////        telemetry.update();
////    }
//
//
//    public void armHolder(Gamepad _gamepad2) {
//        telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//        telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//        telemetry.update();
//
//        if (_gamepad2.right_bumper) {
//            while (rd1.armLifterMotorLeft.getCurrentPosition() < 3340 && rd1.armLifterMotorRight.getCurrentPosition() > -3340) {
//                this.rd1.armLifterMotorLeft.setPower(0.80);
//                this.rd1.armLifterMotorRight.setPower(-0.80);
//                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//                telemetry.update();
//            }
////                this.rd1.armLifterMotorLeft.setPower(0);
////                this.rd1.armLifterMotorRight.setPower(0);
//        }
//        else if (_gamepad2.left_bumper) {
//            while (rd1.armLifterMotorLeft.getCurrentPosition() > 1000 && rd1.armLifterMotorRight.getCurrentPosition() < -1000) {
//                this.rd1.armLifterMotorLeft.setPower(-0.70);
//                this.rd1.armLifterMotorRight.setPower(0.70);
//                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//                telemetry.update();
//            }
//        }
//        if (_gamepad2.dpad_right) {  //trebuie rezolvat coborare lenta
//            while (rd1.armLifterMotorLeft.getCurrentPosition() > 0 && rd1.armLifterMotorRight.getCurrentPosition() < 0) {
//                this.rd1.armLifterMotorLeft.setPower(0.40);
//                this.rd1.armLifterMotorRight.setPower(-0.40);
//                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//                telemetry.update();
//            }
//
//        telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//        telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//        telemetry.update();
//    } else if (_gamepad2.left_bumper) {
//            while (rd1.armLifterMotorLeft.getCurrentPosition() > 0 && rd1.armLifterMotorRight.getCurrentPosition() < 0) {
//                this.rd1.armLifterMotorLeft.setPower(-0.70);
//                this.rd1.armLifterMotorRight.setPower(0.70);
//                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//                telemetry.update();
//            }
//        }
//    }
//
//
//
//    public void armLifter(Gamepad _gamepad2) {
//        telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//        telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//        telemetry.update();
//
//        if (_gamepad2.right_trigger > 0) {
//            while (rd1.armLifterMotorLeft.getCurrentPosition() < 3340 && rd1.armLifterMotorRight.getCurrentPosition() > -3340) {
//                this.rd1.armLifterMotorLeft.setPower(0.80);
//                this.rd1.armLifterMotorRight.setPower(-0.80);
//                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//                telemetry.update();
//            }
//                this.rd1.armLifterMotorLeft.setPower(0);
//                this.rd1.armLifterMotorRight.setPower(0);
//        }
//        else if (_gamepad2.left_trigger > 0) {
//            while (rd1.armLifterMotorLeft.getCurrentPosition() > 0 && rd1.armLifterMotorRight.getCurrentPosition() < 0) {
//                this.rd1.armLifterMotorLeft.setPower(-0.80);
//                this.rd1.armLifterMotorRight.setPower(0.80);
//                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//                telemetry.update();
//            }
//                this.rd1.armLifterMotorLeft.setPower(0);
//                this.rd1.armLifterMotorRight.setPower(0);
//        }
//
//        telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//        telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//        telemetry.update();
//    }
//
//}
//
//


//region imports
        package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.HardwareInit;
//endregion

// the class that controls the entire robot arm
public class ArmController {
    private HardwareInit rd1;
    private Telemetry telemetry;

    public ArmController(HardwareInit rd1, Telemetry telemetry)
    {
        this.rd1 = rd1;
        this.telemetry = telemetry;
        //rd1.pixelDropperServo.setPosition(0.9);
    }

//    public void robotHanger(Gamepad _gamepad2){
//        if(_gamepad2.dpad_down){
//            this.rd1.armLifterMotor.setPower(-1);
//        }
//    }

//    public void armHolder(Gamepad _gamepad2) {
//        telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//        telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//        telemetry.update();
//
//        if (_gamepad2.right_bumper) {
//            while (rd1.armLifterMotorLeft.getCurrentPosition() < 3340 && rd1.armLifterMotorRight.getCurrentPosition() > -3340) {
//                this.rd1.armLifterMotorLeft.setPower(0.80);
//                this.rd1.armLifterMotorRight.setPower(-0.80);
//                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//                telemetry.update();
//            }
////                this.rd1.armLifterMotorLeft.setPower(0);
////                this.rd1.armLifterMotorRight.setPower(0);
//        }
//        else if (_gamepad2.left_bumper) {
//            while (rd1.armLifterMotorLeft.getCurrentPosition() > 1000 && rd1.armLifterMotorRight.getCurrentPosition() < -1000) {
//                this.rd1.armLifterMotorLeft.setPower(-0.70);
//                this.rd1.armLifterMotorRight.setPower(0.70);
//                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//                telemetry.update();
//            }
//        }
//        if (_gamepad2.dpad_right) {  //trebuie rezolvat coborare lenta
//            while (rd1.armLifterMotorLeft.getCurrentPosition() > 0 && rd1.armLifterMotorRight.getCurrentPosition() < 0) {
//                this.rd1.armLifterMotorLeft.setPower(0.40);
//                this.rd1.armLifterMotorRight.setPower(-0.40);
//                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//                telemetry.update();
//            }
//
//            telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//            telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//            telemetry.update();
//        } else if (_gamepad2.left_bumper) {
//            while (rd1.armLifterMotorLeft.getCurrentPosition() > 0 && rd1.armLifterMotorRight.getCurrentPosition() < 0) {
//                this.rd1.armLifterMotorLeft.setPower(-0.70);
//                this.rd1.armLifterMotorRight.setPower(0.70);
//                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
//                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
//                telemetry.update();
//            }
//        }
//    }


        public void armLifter(Gamepad _gamepad2) {
        telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
        telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
        telemetry.update();

        if (_gamepad2.right_trigger > 0) {
            while (rd1.armLifterMotorLeft.getCurrentPosition() < 3340 && rd1.armLifterMotorRight.getCurrentPosition() > -3340) {
                this.rd1.armLifterMotorLeft.setPower(0.80);
                this.rd1.armLifterMotorRight.setPower(-0.80);
                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
                telemetry.update();
            }
//                this.rd1.armLifterMotorLeft.setPower(0);
//                this.rd1.armLifterMotorRight.setPower(0);
        }
        else if (_gamepad2.left_trigger > 0) {
            while (rd1.armLifterMotorLeft.getCurrentPosition() > 0 && rd1.armLifterMotorRight.getCurrentPosition() < 0) {
                this.rd1.armLifterMotorLeft.setPower(-0.80);
                this.rd1.armLifterMotorRight.setPower(0.80);
                telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
                telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
                telemetry.update();
            }
                this.rd1.armLifterMotorLeft.setPower(0);
                this.rd1.armLifterMotorRight.setPower(0);
        }

        telemetry.addData("Pozitie vipere1:", rd1.armLifterMotorLeft.getCurrentPosition());
        telemetry.addData("Pozitie vipere2:", rd1.armLifterMotorRight.getCurrentPosition());
        telemetry.update();
    }
}
