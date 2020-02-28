/*package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.ArrayList;
import java.util.List;

import static org.firstinspires.ftc.robotcore.external.navigation.AngleUnit.DEGREES;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.XYZ;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesOrder.YZX;
import static org.firstinspires.ftc.robotcore.external.navigation.AxesReference.EXTRINSIC;
import static org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer.CameraDirection.BACK;

/*Created by mandy.peake and helen.watson on 11/22/19 */

@Autonomous (name= "Red1", group= "Autonomous")
public class AutoRed1 extends LinearOpMode {

    ElapsedTime runtime = new ElapsedTime();

    HardwareSkystone Bumblebarry = new HardwareSkystone();

    static final int LTurn = -1;
    static final int RTurn = 1;

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


        waitForStart();


        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        Bumblebarry.leftFront.setPower(.5);
        Bumblebarry.leftBack.setPower(.5);
        Bumblebarry.rightFront.setPower(-.5);
        Bumblebarry.rightBack.setPower(-.5);




        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

      //  Bumblebarry.ThumperClamp(1);

        Bumblebarry.leftFront.setPower(0.0);
        Bumblebarry.leftBack.setPower(0.0);
        Bumblebarry.rightFront.setPower(0.0);
       Bumblebarry.rightBack.setPower(0.0);



    }
}

      /*  while (runtime.equals(1))
            Bumblebarry.leftFront.setPower(.5);

        { Bumblebarry.leftBack.setPower(.5);

            Bumblebarry.rightFront.setPower(-.5);}

        Bumblebarry.rightBack.setPower(-.5);

        while (runtime.equals(2))
            Bumblebarry.leftFront.setPower(.5);

        { Bumblebarry.leftBack.setPower(.5);

            Bumblebarry.rightFront.setPower(-.5);}

        Bumblebarry.rightBack.setPower(-.5);

 while (runtime.equals())
     Bumblebarry.leftFront.setPower(.5);

            { Bumblebarry.leftBack.setPower(.5);

                Bumblebarry.rightFront.setPower(-.5);}

            Bumblebarry.rightBack.setPower(-.5);

       // { Bumblebarry.driveStraight(0,10,1);}

   // while (runtime.equals(4))
      //  Bumblebarry.leftFront.setPower(0);
       // Bumblebarry.leftBack.setPower(0);
       // Bumblebarry.rightFront.setPower(0);
       // Bumblebarry.rightBack.setPower(0);
       */








//drive forward


//stops

// turn

//Vuforia Code to recognize star wars block

//Use lift code and pick up block and place on builder zone

//Turn
