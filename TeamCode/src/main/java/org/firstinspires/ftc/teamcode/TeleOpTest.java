package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp
///@Disabled


// "Wait, there's a Donut Vending Machine?!" - Misha
// "La salle de sport." - Finn
// "AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH" - Will
// "Applebee's." - Andy

public class TeleOpTest extends LinearOpMode {


    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    //private DcMotor leftFrontDrive = null;
    private DcMotor FrontLeftDrive = null;
    //private DcMotor rightFrontDrive = null;
    private DcMotor FrontRightDrive = null;

    private DcMotor BackLeftDrive = null;

    private DcMotor BackRightDrive = null;
    private Servo Tail = null;

    private Servo Jaw = null;

    private Servo Head = null;





    //idk how to use java at all
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();


        // Mapping the values to the Motor lol
        FrontLeftDrive  = hardwareMap.tryGet(DcMotor.class, "Front_Left_Drive");
        FrontRightDrive  = hardwareMap.tryGet(DcMotor.class, "Front_Right_Drive");
        BackLeftDrive  = hardwareMap.tryGet(DcMotor.class, "Back_Left_Drive");
        BackRightDrive = hardwareMap.tryGet(DcMotor.class, "Back_Right_Drive");
        Head = hardwareMap.tryGet(Servo.class, "Head");
        Jaw = hardwareMap.tryGet(Servo.class, "Jaw");
        Tail = hardwareMap.tryGet(Servo.class, "Tail");






        while (opModeIsActive()) {




            if (gamepad1.left_stick_y != 0) {//left joystick is up = forward, down = backwards
                BackLeftDrive.setPower(-gamepad1.left_stick_y);
                BackRightDrive.setPower(gamepad1.left_stick_y);
                FrontLeftDrive.setPower(-gamepad1.left_stick_y);
                FrontRightDrive.setPower(gamepad1.left_stick_y);
                if (gamepad1.left_stick_y > 0){
                    telemetry.addLine("left joystick up = forward");
                } else {
                    telemetry.addLine("left joystick up = backwards");
                }
                telemetry.update();
            }

            if (gamepad1.right_stick_x != 0) {//right joystick is right = turn right, left = turn left
                BackLeftDrive.setPower(gamepad1.right_stick_x);
                BackRightDrive.setPower(gamepad1.right_stick_x);
                FrontLeftDrive.setPower(gamepad1.right_stick_x);
                FrontRightDrive.setPower(gamepad1.right_stick_x);
                telemetry.addLine("left joystick up = forward");
                telemetry.update();
            }
            if (gamepad2.x){//close Jaw
                Jaw.setPosition(0);
            }
            if (gamepad2.b){//open Jaw
                Jaw.setPosition(2);
            }
            if (gamepad2.y){//close Tail
                Tail.setPosition(0-.5);
            }
            if (gamepad2.a){//open Tail
                Tail.setPosition(.5);
            }
            if (gamepad2.right_stick_button){//Turn Head
                Head.setPosition(0-.5);
            }
            if (gamepad2.left_stick_button){//Turn Head
                Head.setPosition(.5);
            }











            else{
                BackRightDrive.setPower(0);
                BackLeftDrive.setPower(0);
                FrontLeftDrive.setPower(0);
                FrontRightDrive.setPower(0);
            }




            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());


            telemetry.update();
        }
        // "Status: Running" text was interfering with the other telemetry data


        //telemetry.addData("Status", "Running");


        telemetry.update();
    }
}
