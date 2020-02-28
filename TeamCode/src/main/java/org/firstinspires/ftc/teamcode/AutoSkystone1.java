/*package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.vuforia.Vuforia;

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

@Autonomous (name= "AutoSkystone1", group= "Autonomous")

public class AutoSkystone1 extends LinearOpMode {

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

//TODO Commented out next line
       //public void targetSkystone.activate();
        boolean targetVisible = false;
        boolean stoneTargetSeen = false;
        int counter = 0;
        while (!stoneTargetSeen && counter < 3) {

            //TODO commented out if else
            //if (((VuforiaTrackableDefaultListener) targetSkystone.get(0).getListener()).isVisible()) {
                telemetry.addLine("Stone Target Seen. YAY");
                stoneTargetSeen = true;
          // } else {
                Bumblebarry.driveMecanum(.5, "right");
                sleep(1000);
                Bumblebarry.driveMecanum(0, "right");
                counter++;
            }

    Bumblebarry.driveStraight(.5,1);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.LinearActuator.setPower(.1);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    Bumblebarry.ThumperClamp(0,1);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    Bumblebarry.driveStraight(.5,-1);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    Bumblebarry.driveMecanum(.8,"left");

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    Bumblebarry.driveStraight(.3,1);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    Bumblebarry.LiftU.setPower(.5);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    Bumblebarry.ThumperClamp(.8,.2);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.driveTurn(.7,"right");

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.Grabber(1,0);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.driveStraight(.6,-1);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.Grabber(0,1);

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.driveMecanum(.6,"right");

        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }}
            // check all the trackable targets to see which one (if any) is visible


