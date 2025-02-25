package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
///@Disabled
public class AutonomousTwo extends LinearOpMode {

    //A
    @Override
    public void runOpMode() {
        // fake controls init
        double gamepad1_left_stick_x = 0.0;
        double gamepad1_left_stick_y = 0.0;
        double gamepad1_right_stick_x = 0.0;
        double gamepad1_right_stick_y = 0.0;
        double gamepad2_left_stick_x = 0.0;
        double gamepad2_left_stick_y = 1.0;
        double gamepad2_right_stick_x = 0.0;
        double gamepad2_right_stick_y = 0.0;
        boolean gamepad1_a = false;
        boolean gamepad1_b = false;
        boolean gamepad1_x = false;
        boolean gamepad1_y = false;
        boolean gamepad2_a = false;
        boolean gamepad2_b = false;
        boolean gamepad2_x = false;
        boolean gamepad2_y = false;

        // driving init
        double drive, turn, strafe, turnl, strafel;
        double fLeftPower, fRightPower, bRightPower, bLeftPower;
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "fRight");
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "fLeft");
        DcMotor backLeft = hardwareMap.get(DcMotor.class, "bLeft");
        DcMotor backRight = hardwareMap.get(DcMotor.class, "bRight");
        CRServo sparkMini = hardwareMap.get(CRServo.class, "sparkMini");
        Servo hand = hardwareMap.get(Servo.class, "hand");
        Servo claw = hardwareMap.get(Servo.class, "claw");


        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);


        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        // linear slide init




        // it says claw but we all know it arm it lies like fox news :D
        // end every line with a smile :D
        //nahhhhhh i gonna square clawPower not double :D



        //Zander made a spark large :D


        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        if (opModeIsActive()) {

            /*
                Movement :D

                use the calcMotorMove() function
                just do it, mate
                you plug in the wanted left joystick x, left joystick y, and right joystick x
                then it pops out an array with the needed motor movements
                it's in the format: {leftFrontWheel, rightFrontWheel, leftBackWheel, rightBackWheel}

                L i n e a r   s l i d e   t h i n g y   y a y

                to move the linear slide, use sparkMini.setPower(number)
                replace "number" with the amount you want to move it from -1 to 1

                to move the arm down, use claw.setPosition(0.05)
                to move it back up, use claw.setPosition(0.4);

                to shut the claw, use hand.setPosition(1)
                to reopen it, use hand.setPosition(0.0)
             */



            // Move down arm
            for (int i = 0; i < 10; i++) {

                claw.setPosition(0.05);

                sleep(50);
            }

            sleep(100);

            for (int i = 0; i < 1; i++) {

                fLeftPower = calcMotorMove(1, 0, 0)[0];
                fRightPower = calcMotorMove(1, 0, 0)[1];
                bLeftPower = calcMotorMove(1, 0, 0)[2];
                bRightPower = calcMotorMove(1, 0, 0)[3];
                frontRight.setPower(-fRightPower);
                frontLeft.setPower(-fLeftPower);
                backRight.setPower(-bRightPower);
                backLeft.setPower(-bLeftPower);

                sleep(50);
            }

            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);

            // grab
            for (int i = 0; i < 22; i++) {

                hand.setPosition(1);

                sleep(50);
            }
                gamepad2_a = false;

            gamepad1_left_stick_y = 0.0;
            // Dat the end of go forward :(
            drive = gamepad1_left_stick_y * -1;
            turn = gamepad1_right_stick_x;
            strafe = gamepad1_left_stick_x;
            fLeftPower = drive + turn + strafe;
            fRightPower = drive - turn - strafe;
            bLeftPower = drive + turn - strafe;
            bRightPower = drive - turn + strafe;
            frontRight.setPower(-fRightPower);
            frontLeft.setPower(-fLeftPower);
            backRight.setPower(-bRightPower);
            backLeft.setPower(-bLeftPower);

            sleep(1000);

            for (int i = 0; i < 62; i++) {

                gamepad1_left_stick_x = -1.0;
                gamepad1_right_stick_x = 0.48;

                drive = gamepad1_left_stick_y * -1;
                turn = gamepad1_right_stick_x;
                strafe = gamepad1_left_stick_x;
                fLeftPower = drive + turn + strafe;
                fRightPower = drive - turn - strafe;
                bLeftPower = drive + turn - strafe;
                bRightPower = drive - turn + strafe;
                frontRight.setPower(-fRightPower);
                frontLeft.setPower(-fLeftPower);
                backRight.setPower(-bRightPower);
                backLeft.setPower(-bLeftPower);
                if (gamepad2_left_stick_y > 0.1) {
                    sparkMini.setPower(gamepad2_left_stick_y);
                } else if (gamepad2_left_stick_y < 0.1) {
                    sparkMini.setPower(gamepad2_left_stick_y);
                } else {
                    sparkMini.setPower (0.0);
                }
                if (gamepad2_x) {
                    hand.setPosition(1);
                } else {
                    hand.setPosition (0.0);
                }
                if (gamepad2_a) {
                    claw.setPosition(0.05);
                } else {
                    claw.setPosition(0.4);
                }

                sleep(50);
            }

            drive = gamepad1_left_stick_y * -1;
            turn = gamepad1_right_stick_x;
            strafe = gamepad1_left_stick_x;
            fLeftPower = drive + turn + strafe;
            fRightPower = drive - turn - strafe;
            bLeftPower = drive + turn - strafe;
            bRightPower = drive - turn + strafe;
            frontRight.setPower(-fRightPower);
            frontLeft.setPower(-fLeftPower);
            backRight.setPower(-bRightPower);
            backLeft.setPower(-bLeftPower);

            gamepad1_left_stick_x = 0.0;

            // Forthwards

            // 10 in the i thing is ~11.5 inches
            for (int i = 0; i < 25; i++) {

                gamepad1_left_stick_y = -1.0;

                drive = gamepad1_left_stick_y * -1;
                turn = gamepad1_right_stick_x;
                strafe = gamepad1_left_stick_x;
                fLeftPower = drive + turn + strafe;
                fRightPower = drive - turn - strafe;
                bLeftPower = drive + turn - strafe;
                bRightPower = drive - turn + strafe;
                frontRight.setPower(-fRightPower);
                frontLeft.setPower(-fLeftPower);
                backRight.setPower(-bRightPower);
                backLeft.setPower(-bLeftPower);
                if (gamepad2_left_stick_y > 0.1) {
                    sparkMini.setPower(gamepad2_left_stick_y);
                } else if (gamepad2_left_stick_y < 0.1) {
                    sparkMini.setPower(gamepad2_left_stick_y);
                } else {
                    sparkMini.setPower (0.0);
                }
                if (gamepad2_x) {
                    hand.setPosition(1);
                } else {
                    hand.setPosition (0.0);
                }
                if (gamepad2_a) {
                    claw.setPosition(0.05);
                } else {
                    claw.setPosition(0.4);
                }

                sleep(50);
            }
            sleep(100);
            // 10 in the i thing is ~11.5 inches
            for (int i = 0; i < 25; i++) {

                gamepad1_left_stick_y = -1.0;

                drive = gamepad1_left_stick_y * -1;
                turn = gamepad1_right_stick_x;
                strafe = gamepad1_left_stick_x;
                fLeftPower = drive + turn + strafe;
                fRightPower = drive - turn - strafe;
                bLeftPower = drive + turn - strafe;
                bRightPower = drive - turn + strafe;
                frontRight.setPower(-fRightPower);
                frontLeft.setPower(-fLeftPower);
                backRight.setPower(-bRightPower);
                backLeft.setPower(-bLeftPower);
                if (gamepad2_left_stick_y > 0.1) {
                    sparkMini.setPower(gamepad2_left_stick_y);
                } else if (gamepad2_left_stick_y < 0.1) {
                    sparkMini.setPower(gamepad2_left_stick_y);
                } else {
                    sparkMini.setPower (0.0);
                }
                if (gamepad2_x) {
                    hand.setPosition(1);
                } else {
                    hand.setPosition (0.0);
                }
                if (gamepad2_a) {
                    claw.setPosition(0.05);
                } else {
                    claw.setPosition(0.4);
                }

                sleep(50);
            }

            // Rotate rihtwards

            /*for (int i = 0; i < 10; i++) {

                gamepad1_right_stick_x = 1.0;

                drive = gamepad1_left_stick_y * -1;
                turn = gamepad1_right_stick_x;
                strafe = gamepad1_left_stick_x;
                fLeftPower = drive + turn + strafe;
                fRightPower = drive - turn - strafe;
                bLeftPower = drive + turn - strafe;
                bRightPower = drive - turn + strafe;
                frontRight.setPower(-fRightPower);
                frontLeft.setPower(-fLeftPower);
                backRight.setPower(-bRightPower);
                backLeft.setPower(-bLeftPower);

                sleep(180);
            }

            gamepad1_right_stick_x = 0.0;

            // Forthwards

            for (int i = 0; i < 40; i++) {

                gamepad1_left_stick_y = -1.0;

                drive = gamepad1_left_stick_y * -1;
                turn = gamepad1_right_stick_x;
                strafe = gamepad1_left_stick_x;
                fLeftPower = drive + turn + strafe;
                fRightPower = drive - turn - strafe;
                bLeftPower = drive + turn - strafe;
                bRightPower = drive - turn + strafe;
                frontRight.setPower(-fRightPower);
                frontLeft.setPower(-fLeftPower);
                backRight.setPower(-bRightPower);
                backLeft.setPower(-bLeftPower);

                sleep(50);
            }*/

            //gamepad1_left_stick_y = 0.0;

            telemetry.update();
        }
    }

    public double[] calcMotorMove(double lx, double ly, double rx) {

        double drive = ly * -1;
        double turn = rx * 1;
        double strafe = lx * 1;
        double fLeftPower = drive + turn + strafe;
        double fRightPower = drive - turn - strafe;
        double bLeftPower = drive + turn - strafe;
        double bRightPower = drive - turn + strafe;

        return new double[] {fLeftPower, fRightPower, bLeftPower, bRightPower};
    }
}