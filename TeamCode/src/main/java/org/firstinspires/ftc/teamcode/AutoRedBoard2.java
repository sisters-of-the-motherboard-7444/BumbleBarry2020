

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

@Autonomous (name= "RedBoard2", group= "Autonomous")
public class AutoRedBoard2 extends LinearOpMode {

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
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.leftFront.setPower(.25);
        Bumblebarry.leftBack.setPower(-.25);
        Bumblebarry.rightFront.setPower(.25);
        Bumblebarry.rightBack.setPower(-.25);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.leftFront.setPower(.28);
        Bumblebarry.leftBack.setPower(.28);
        Bumblebarry.rightFront.setPower(-.28);
        Bumblebarry.rightBack.setPower(-.28);

        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.Grabber(1,0);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.leftFront.setPower(-.45);
        Bumblebarry.leftBack.setPower(-.45);
        Bumblebarry.rightFront.setPower(.45);
        Bumblebarry.rightBack.setPower(.45);

        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.Grabber(0,1);

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.leftFront.setPower(-.45);
        Bumblebarry.leftBack.setPower(.45);
        Bumblebarry.rightFront.setPower(-.45);
        Bumblebarry.rightBack.setPower(.45);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.leftFront.setPower(.28);
        Bumblebarry.leftBack.setPower(.28);
        Bumblebarry.rightFront.setPower(-.28);
        Bumblebarry.rightBack.setPower(-.28);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        Bumblebarry.leftFront.setPower(-.45);
        Bumblebarry.leftBack.setPower(-.45);
        Bumblebarry.rightFront.setPower(.45);
        Bumblebarry.rightBack.setPower(.45);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
