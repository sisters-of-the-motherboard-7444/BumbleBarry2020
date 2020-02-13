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

@TeleOp (name= "clawtest", group= "Linear Opmode")
public class clawtest extends LinearOpMode {

public DcMotor claw;


{}
    ElapsedTime runtime = new ElapsedTime();

    @Override

    public void runOpMode() {

        System.out.println("Starting up");
        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();


        System.out.println("Initialize Robot");
        System.out.println("Robot Initialized");

        //   Rover.rightCollector.setPosition(1);
        //   Rover.leftCollector.setPosition(0);

        telemetry.addData("Status", "Ready to run");
        telemetry.update();


        waitForStart();

        //  Rover.imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);



        while (opModeIsActive()) {
            if (gamepad2.x)
                claw.setPower(1);
            else
                claw.setPower(0);
        }}

}




