package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
///@Disabled
//WHO LIVES IN A PINEAPPLE UNDER THE SEA?
public class MyFirstTeleOpMode extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    //private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    //private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;

    private float amogus = 0;

    //idk how to use java at all
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        // Mapping the values to the Motor lol
        leftBackDrive  = hardwareMap.tryGet(DcMotor.class, "left_back_drive");
        rightBackDrive = hardwareMap.tryGet(DcMotor.class, "right_back_drive");


        while (opModeIsActive()) {
            double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral =  gamepad1.left_stick_x;
            double yaw     =  gamepad1.right_stick_x;

            if (gamepad1.a) {
                telemetry.addData("A", "is_Pressed");
                telemetry.update();
            }
            if (gamepad1.b) {
                telemetry.addData("B", "is_Pressed");
                telemetry.update();
                amogus = 0;
            }
            if (gamepad1.x) {
                telemetry.addData("X", "is_Pressed");
                telemetry.update();
            }
            if (gamepad1.y) {
                telemetry.addData("Y", "is_Probably_Pressed");
                telemetry.update();
            }
            if (gamepad2.x) {
                telemetry.addData("randomIncreasingVariable_is", amogus);
                telemetry.update();
                amogus++;
            }
            if (gamepad2.b) {
                telemetry.addData("randomIncreasingVariable_is", amogus);
                telemetry.update();
                amogus = 0;
            }
            if (gamepad2.y) {
                telemetry.addData("randomDecreasingVariable_is", amogus);
                telemetry.update();
                amogus -= 1;
            }
            if (amogus > 500000f)
            {
                amogus = -6000f;
            }
            if (lateral != 0) {
                telemetry.addData("LeftStickX_is", lateral);
                telemetry.update();
            }
            if (axial != 0) {
                telemetry.addData("LeftStickY_is", axial);
                telemetry.update();
            }
            if (yaw != 0) {
                telemetry.addData("RightStickX_is", yaw);
                telemetry.update();
            }
            double max;
            if (lateral != 0 || axial != 0 || yaw != 0) {
                // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.

                // Combine the joystick requests for each axis-motion to determine each wheel's power.
                // Set up a variable for each drive wheel to save the power level for telemetry.
                //double leftFrontPower = axial + lateral + yaw;
                //double rightFrontPower = axial - lateral - yaw;
                double leftBackPower = axial - lateral + yaw;
                double rightBackPower = axial + lateral - yaw;

                // Normalize the values so no wheel power exceeds 100%
                // This ensures that the robot maintains the desired motion.
                //max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
                max = Math.max(Math.abs(leftBackPower), Math.abs(rightBackPower));

                if (max > 1.0) {
                    //leftFrontPower /= max;
                    //rightFrontPower /= max;
                    leftBackPower /= max;
                    rightBackPower /= max;
                }

                // This is test code:
                //
                // Uncomment the following code to test your motor directions.
                // Each button should make the corresponding motor run FORWARD.
                //   1) First get all the motors to take to correct positions on the robot
                //      by adjusting your Robot Configuration if necessary.
                //   2) Then make sure they run in the correct direction by modifying the
                //      the setDirection() calls above.
                // Once the correct motors move in the correct direction re-comment this code.

                //leftFrontPower = gamepad1.x ? 1.0 : 0.0;  // X gamepad
                leftBackPower = gamepad1.a ? 1.0 : 0.0;  // A gamepad
                //rightFrontPower = gamepad1.y ? 1.0 : 0.0;  // Y gamepad
                rightBackPower = gamepad1.b ? 1.0 : 0.0;  // B gamepad

                // Send calculated power to wheels
                //leftFrontDrive.setPower(leftFrontPower);
                //rightFrontDrive.setPower(rightFrontPower);
                leftBackDrive.setPower(leftBackPower);
                rightBackDrive.setPower(rightBackPower);

                // Show the elapsed game time and wheel power.
                telemetry.addData("Status", "Run Time: " + runtime.toString());
                //telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
                telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
                telemetry.update();
            }
            // "Status: Running" text was interfering with the other telemetry data

            //telemetry.addData("Status", "Running");

            telemetry.update();
        }
    }
}