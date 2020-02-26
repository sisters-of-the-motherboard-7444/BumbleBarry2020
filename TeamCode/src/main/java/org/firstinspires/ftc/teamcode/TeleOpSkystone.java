package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import java.util.Locale;

/**
 * Created by mandy.peake and helen.watson on 8/30/2019.
 */

@TeleOp (name= "TeleOpSkystone", group= "Linear Opmode")
public class TeleOpSkystone extends LinearOpMode {

    HardwareSkystone Bumblebarry = new HardwareSkystone();

    ElapsedTime runtime = new ElapsedTime();

    @Override

    public void runOpMode() {

        System.out.println("Starting up");
        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();


        System.out.println("Initialize Robot");
        Bumblebarry.initializeRobot(hardwareMap);
        System.out.println("Robot Initialized");


        telemetry.addData("Status", "Ready to run");
        telemetry.update();

      // composeTelemetry();

        waitForStart();


        while (opModeIsActive()) {


            double fwdBack = gamepad1.right_stick_y;
            double strafe = gamepad1.right_stick_x;
            double turn = gamepad1.left_stick_x;

            //Linear Actuator
             double MoveActuator = -gamepad2.left_stick_y;
            Bumblebarry.LinearActuator.setPower(MoveActuator);

            double Liftarm = -gamepad2.right_stick_y;
            Bumblebarry.arm.setPower(Liftarm);

            if (gamepad1.start) { // drive robot at slower speed for fine adjustments while carrying gold

                Bumblebarry.leftFront.setPower((fwdBack + 1.5 * strafe - turn) * .25);
                Bumblebarry.leftBack.setPower((fwdBack - 1.5 * strafe - turn) * .25);
                Bumblebarry.rightFront.setPower((-fwdBack + 1.5 * strafe - turn) * .25);
                Bumblebarry.rightBack.setPower((-fwdBack - 1.5 * strafe - turn) * .25);

            } else { // drive robot normally at full speed

                Bumblebarry.leftFront.setPower((fwdBack + strafe - turn));
                Bumblebarry.leftBack.setPower((fwdBack - strafe - turn));
                Bumblebarry.rightFront.setPower((-fwdBack + strafe - turn));
                Bumblebarry.rightBack.setPower((-fwdBack - strafe - turn));

            }
            //Lower Lift Control

            if (gamepad2.left_bumper) {
                Bumblebarry.LiftL.setPower(.9);
            } else if (gamepad2.left_trigger > 0.5) {
                Bumblebarry.LiftL.setPower(-.9);
            } else {
                Bumblebarry.LiftL.setPower(0);
            }

            //Upper Lift Control
            if (gamepad2.right_bumper) {
                Bumblebarry.LiftU.setPower(1);
            } else if (gamepad2.right_trigger > 0.5) {
                Bumblebarry.LiftU.setPower(-1);
            } else {
                Bumblebarry.LiftU.setPower(0);
            }
            //motor test
/*
            if (gamepad2.y) {
                Bumblebarry.GrabberArm.setPower(1);
            } else {
                Bumblebarry.GrabberArm.setPower(0);
            }

*/
        }

               /* {
                    if (gamepad2.dpad_right) {
                        Bumblebarry.LiftL.setPower(1);
                    } else if (gamepad2.dpad_left) {
                        Bumblebarry.LiftL.setPower(-1);}
                    else {
                        Bumblebarry.LiftL.setPower(0);
                    }
                }
                */


        //Board thing grabber

        if (gamepad1.b) {
            Bumblebarry.Grabber(1, 0);
        } else if (gamepad1.y) {
            Bumblebarry.Grabber(0, 1);
        }

     /*   if (gamepad2.x) {

        } else if (gamepad2.a) {

        }
*/
        if (gamepad2.b) {
            Bumblebarry.ThumperBack.setPosition(.5);
        } else if (gamepad2.y) {
            Bumblebarry.ThumperBack.setPosition(1);
        }


            // {
            //     if (gamepad2.x) {
            //          Bumblebarry.twister(.9);
            //     } else if (gamepad2.y) {
            //         Bumblebarry.twister(-.9);
            //     }
            //  }


            //  Bumblebarry.claw.setPower(gamepad2.left_stick_y);


            //----------------------------------------------------------------------------------------------
            // Telemetry Configuration
            //----------------------------------------------------------------------------------------------

  /* public void composeTelemetry();
           {

        // At the beginning of each telemetry update, grab a bunch of data
        // from the IMU that we will then display in separate lines.
        telemetry.addAction(new Runnable() {
            @Override
            public void run() {
                // Acquiring the angles is relatively expensive; we don't want
                // to do that in each of the three items that need that info, as that's
                // three times the necessary expense.
              //  Rover.angles = Rover.imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
               // Rover.gravity = Rover.imu.getGravity();
            }
        });

        telemetry.addLine()
                .addData("status", new Func<String>() {
                    @Override
                    public String value() {
                       return "";
                        // return Rover.imu.getSystemStatus().toShortString();
                    }
                })
                .addData("calib", new Func<String>() {
                    @Override
                    public String value() {
                       return "";
                        // return Rover.imu.getCalibrationStatus().toString();
                    }
                });

        telemetry.addLine()
                .addData("heading", new Func<String>() {
                    @Override
                    public String value() {
                       return "";
                       // return formatAngle(Rover.angles.angleUnit, Rover.angles.firstAngle);
                    }
                })
                .addData("roll", new Func<String>() {
                    @Override
                    public String value() {
                       return "";
                       // return formatAngle(Rover.angles.angleUnit, Rover.angles.secondAngle);
                    }
                })
                .addData("pitch", new Func<String>() {
                    @Override
                    public String value() {
                        return "";
                        //return formatAngle(Rover.angles.angleUnit, Rover.angles.thirdAngle);
                    }
                });

        telemetry.addLine()
                .addData("grvty", new Func<String>() {
                    @Override
                    public String value() {
                        return "";
                        //return Rover.gravity.toString();
                    }
                })
                .addData("mag", new Func<String>() {
                    @Override
                    public String value() {
                        return String.format(Locale.getDefault(), "%.3f"//,
                               // Math.sqrt(Rover.gravity.xAccel * Rover.gravity.xAccel
                                      //  + Rover.gravity.yAccel * Rover.gravity.yAccel
                                      //  + Rover.gravity.zAccel * Rover.gravity.zAccel)
                                );
                    }
                });
    }

    //----------------------------------------------------------------------------------------------
    // Formatting
    //----------------------------------------------------------------------------------------------
   // String formatAngle(AngleUnit angleUnit, double angle) {
  //      return formatDegrees(AngleUnit.DEGREES.fromUnit(angleUnit, angle));
    }

  //  String formatDegrees(double degrees) {
   //     return String.format(Locale.getDefault(), "%.1f", AngleUnit.DEGREES.normalize(degrees));
  //  }




*/
    }
}