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

/*Created by mandy.peake and helen.watson on 1/27/20 */

@Autonomous (name= "Blue2", group= "Autonomous")
public class AutoBlue2 extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    HardwareSkystone Bumblebarry = new HardwareSkystone();

    @Override
    public void runOpMode() {
        System.out.println("Starting up");
        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();


        System.out.println("Initialize Robot");
        Bumblebarry.initializeRobot(hardwareMap);
        System.out.println("Robot Initialized");

        // Bumblebarry.Grab.setPosition(.5);

        telemetry.addData("Status", "Ready to run");
        telemetry.update();


        waitForStart();
    }}/* Bumblebarry.driveStraight(.5,2,1);
        sleep(1000);

        Bumblebarry.driveTurn(.5,5,-1);
        sleep(1000);
        Bumblebarry.driveStraight(.5,10,1);
        sleep(1000);

        Bumblebarry.driveTurn(.5,4,1);

        { Bumblebarry.LiftL.setPower(.5);
            Bumblebarry.LiftL.setPower(.5);}
        sleep(1000);
        Bumblebarry.driveStraight(.5,1,1);
        sleep(1000);
        {Bumblebarry.LiftL.setPower(-.5);
            Bumblebarry.LiftL.setPower(-.5);}
        sleep(1000);
        Bumblebarry.driveStraight(.8,10,-1);

        { Bumblebarry.LiftL.setPower(.5);
            Bumblebarry.LiftL.setPower(.5);}
        sleep(1000);

        Bumblebarry.driveMecanum(.5,10,-1,1,1,-1);


    }
}
*/