package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Second_teleop")
public class MecanumTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        // yoooooooo it's the init stuff lolollololoololololololololololololol
        double drive, turn, strafe;
        double fLeftPower, fRightPower, bRightPower, bLeftPower;
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "fRight");
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "fLeft");
        DcMotor backLeft = hardwareMap.get(DcMotor.class, "bLeft");
        DcMotor backRight = hardwareMap.get(DcMotor.class, "bRight");

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        while (opModeIsActive()){
            drive = gamepad1.left_stick_y * -1;
            turn = gamepad1.right_stick_x;
            strafe = gamepad1.left_stick_x;

            // strafin'
            fLeftPower = drive + turn + strafe;
            fRightPower = drive - turn - strafe;
            bLeftPower = drive + turn - strafe;
            bRightPower = drive - turn + strafe;

            frontRight.setPower(-fRightPower);
            frontLeft.setPower(-fLeftPower);
            backRight.setPower(-bRightPower);
            backLeft.setPower(-bLeftPower);
        }
    }
}
