package org.firstinspires.ftc.teamcode;




import com.qualcomm.hardware.rev.RevSPARKMini;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;






@TeleOp(name="TeleOpTwo")
public class TeleOpTwo extends LinearOpMode {
    @Override
    public void runOpMode() {
        // driving init
        double drive, turn, strafe, turnl, strafel;
        double fLeftPower, fRightPower, bRightPower, bLeftPower;
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "fRight");
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "fLeft");
        DcMotor backLeft = hardwareMap.get(DcMotor.class, "bLeft");
        DcMotor backRight = hardwareMap.get(DcMotor.class, "bRight");
        CRServo sparkMini = hardwareMap.get(CRServo.class, "sparkMini");
        Servo hand = hardwareMap.get(Servo.class, "hand");
        Servo arm = hardwareMap.get(Servo.class, "claw");






        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);




        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);




        // linear slide init








        // it says claw but we all know it arm it lies like fox news :D // this has been fixed :D
        // end every line with a smile :D
        //nahhhhhh i gonna square clawPower not double :D






        //Zander made a spark large :D




        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();




        while (opModeIsActive()){
            drive = gamepad1.left_stick_y * -1;
            turn = gamepad1.right_stick_x;
            strafe = gamepad1.left_stick_x;


            telemetry.addData("Left Stick (1) position is", "("+gamepad1.left_stick_x+", "+gamepad1.left_stick_y+")");
            telemetry.addData("Left Stick (2) position is", "("+gamepad2.left_stick_x+", "+gamepad2.left_stick_y+")");


            // strafin' :D
            fLeftPower = drive + turn + strafe;
            fRightPower = drive - turn - strafe;
            bLeftPower = drive + turn - strafe;
            bRightPower = drive - turn + strafe;




            frontRight.setPower(-fRightPower);
            frontLeft.setPower(-fLeftPower);
            backRight.setPower(-bRightPower);
            backLeft.setPower(-bLeftPower);


            // linear slidin' :D


            if (Math.abs(gamepad2.left_stick_y) >= 0.1) {
                sparkMini.setPower(-gamepad2.left_stick_y);
            } else {
                sparkMini.setPower(0.0);
            }
            // idk what the open and closed positions will be :(
            if (gamepad2.x) {
                hand.setPosition(1);
            } else {
                hand.setPosition (0.0);
            }


            // claw clawin'
            // more like claw clown anyways why we do the claw like dat :(




            if (gamepad2.a) {
                arm.setPosition(0.05);
            } else {
                arm.setPosition(0.4);
            }


            telemetry.update();
        }
    }
}



