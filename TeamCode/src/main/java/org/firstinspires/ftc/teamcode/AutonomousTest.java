package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
///@Disabled
public class AutonomousTest extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    //private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    //private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;
    private Servo claw = null;

    private Servo Hand = null;

    private DcMotor Arm = null;
    private float leftJoystickForwards;
    private float rightJoystickRightwards;

    //idk how to use java at all
    //update: i now slightly know how to use java
    //update2: i've coded full games in java, i'm reasonably good no
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        // Mapping the values to the Motor lol
        leftBackDrive = hardwareMap.tryGet(DcMotor.class, "left_back_drive");
        Arm = hardwareMap.tryGet(DcMotor.class, "Arm");
        rightBackDrive = hardwareMap.tryGet(DcMotor.class, "right_back_drive");
        claw = hardwareMap.tryGet(Servo.class, "claw");
        Hand = hardwareMap.tryGet(Servo.class, "Hand");


        if (opModeIsActive()) {
            // Goes Forwards
            for (int i = 0; i < 10; i++) {
                leftBackDrive.setPower(-1);
                rightBackDrive.setPower(1);
                sleep(500);
            }
            // Turns Right
            for (int i = 0; i < 2; i++) {
                leftBackDrive.setPower(-1);
                rightBackDrive.setPower(-1);
                sleep(500);
            }

            telemetry.update();
        }
    }
}