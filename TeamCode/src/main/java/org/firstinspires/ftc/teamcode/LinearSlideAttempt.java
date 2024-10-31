package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="slide_linearly")
public class LinearSlideAttempt extends LinearOpMode {
    @Override
    public void runOpMode() {
        // yoooooooo it's the init stuff lolollololoololololololololololololol
        double linearSlidePower;
        DcMotor linearSlide = hardwareMap.get(DcMotor.class, "linearSlide");

        linearSlide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        while (opModeIsActive()){
            if (gamepad1.a) {
                linearSlidePower = 1.0;
            } else if (gamepad1.b) {
                linearSlidePower = -1.0;
            } else {
                linearSlidePower = 0.0;
            }

            linearSlide.setPower(-linearSlidePower);
        }
    }
}
