package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by mandy.peake and helen.watson on 8/30/2019.
 */

public class HardwareSkystone {

    //Wheels
    public DcMotor leftFront;
    public DcMotor leftBack;
    public DcMotor rightFront;
    public DcMotor rightBack;

    int driveTime;

  //LiftMotors - Upper and Lower lift motors on lead screw platform

    public DcMotor LiftL;
    public DcMotor LiftU;
    public DcMotor GrabberArm;




    //Actuator motor
    //public DcMotor claw;

    //Grabbing mechanism servos
    public Servo Grab1;
    public Servo Grab2;
   // public CRServo twist;

   // public Servo Backgrab;
   // public Servo Backgrab2;

/*



    //----------------------------------METHODS------------------------------------------------------



    //---------------------------------INIT--ROBOT---------------------------------------------------
    /*  This method allows us to initialize the motors and sensors only once.
        It is used in every other program after "Init" is pressed.
     */


    public void initializeRobot(HardwareMap hwMap) {

        HardwareMap HWMap = hwMap;

        //initialize motors

        leftFront = HWMap.dcMotor.get("leftFront");
        leftBack = HWMap.dcMotor.get("leftBack");
        rightFront = HWMap.dcMotor.get("rightFront");
        rightBack = HWMap.dcMotor.get("rightBack");

        LiftL = HWMap.dcMotor.get("liftL");

        LiftU = HWMap.dcMotor.get("liftU");

        //claw = HWMap.dcMotor.get("claw");

        GrabberArm = HWMap.dcMotor.get("GrabberArm");

        Grab1 = HWMap.servo.get("Grab");
        Grab2 = HWMap.servo.get("Grab2");
      //  twist = HWMap.crservo.get("twist");

        Grab1.setPosition(0);
        Grab2.setPosition(0);

      //  Backgrab=HWMap.servo.get("Backgrab");
       // Backgrab2=HWMap.servo.get("Backgrab2");




    }


    //--------------------------DRIVE--FORWARD-------------------------------------------------------

    /*  This method allows the robot to drive forward based on encoder values.
        A distance is given that is converted to an encoder position in the code.
        leftDirection and rightDirection set the direction of the motors to allow
        the robot to either mover straight ot turn.
     */


    public void driveStraight(double power, double totalInches, int Direction) { //For driving

        // declare variables for this method

        int NewLeftFrontTarget;
        int NewLeftBackTarget;
        int NewRightFrontTarget;
        int NewRightBackTarget;

        //set encoder values to zero

      //  leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       // leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      //  rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
       // rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // counts = inches * 1120 (counts per revolution)/ 4*pi (circumference of wheels)
        // 1120/4*pi ~ 89 - we found that there was less error when given a precise number

      //  NewLeftBackTarget = (int) (totalInches * 99);
      //  NewLeftFrontTarget = (int) (totalInches * 99);
       // NewRightBackTarget = (int) (totalInches * 99);
        // NewRightFrontTarget = (int) (totalInches * 99);

        //get current position of the encoders at the start of the method

      //  leftFront.setTargetPosition(Direction * NewLeftFrontTarget);
        //leftBack.setTargetPosition(Direction * NewLeftBackTarget);
      //  rightFront.setTargetPosition(-Direction * NewRightFrontTarget);
      //  rightBack.setTargetPosition(-Direction * NewRightBackTarget);

       // leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       // leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
       // rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //reset the timeout time  and start motion


        driveTime = 0;

        leftFront.setPower(power * Direction * .99);
        leftBack.setPower(power * Direction * .99);

        rightFront.setPower(power * -Direction * .99) ;
        rightBack.setPower(power * -Direction * .99);

        while (leftFront.isBusy() && leftBack.isBusy() && rightFront.isBusy() && rightBack.isBusy()) {

        }

        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }

    public void driveTurn(double power, double totalInches, int Direction) { //For driving

        // declare variables for this method

        int NewLeftFrontTarget;
        int NewLeftBackTarget;
        int NewRightFrontTarget;
        int NewRightBackTarget;

        //set encoder values to zero

       // leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      //  leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // counts = inches * 1120 (counts per revolution)/ 4*pi (circumference of wheels)
        // 1120/4*pi ~ 89 - we found that there was less error when given a precise number

        //NewLeftBackTarget = (int) (totalInches * 89 * .9);
       // NewLeftFrontTarget = (int) (totalInches * 89 * .5);
       // NewRightBackTarget = (int) (totalInches * 89 * .8);
        //NewRightFrontTarget = (int) (totalInches * 89);

        //get current position of the encoders at the start of the method

       // leftFront.setTargetPosition(Direction * NewLeftFrontTarget);
        //leftBack.setTargetPosition(Direction * NewLeftBackTarget);
        //rightFront.setTargetPosition(Direction * NewRightFrontTarget);
        //rightBack.setTargetPosition(Direction * NewRightBackTarget);

        //leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //reset the timeout time  and start motion

        driveTime = 0;

        leftFront.setPower(power * Direction * .8);
        leftBack.setPower(power * Direction * .9);
        rightFront.setPower(power * Direction);
        rightBack.setPower(power * Direction * .8);

        while (leftFront.isBusy() && leftBack.isBusy() && rightFront.isBusy() && rightBack.isBusy()) {

        }

        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }


    //------------------------------DRIVE--SIDEWAYS--------------------------------------------------
    /*  This method makes the robot move in a sideways direction.
        It is separate from the other drive method because the motors on each side must turn
        in opposite directions. (See Mecanum Drive diagram)
        Because the weight on the robot is not evenly balanced, we found that each motor
        needed to run at a slightly different power (and thus had a slightly different encoder count).
     */


    public void driveMecanum(double power, double totalInches, int leftFrontDirection, int leftBackDirection, int rightFrontDirection, int rightBackDirection) { //For driving

        // declare variables for this method

        int NewLeftFrontTarget;
        int NewLeftBackTarget;
        int NewRightFrontTarget;
        int NewRightBackTarget;

        //set encoder values to zero
      /*  leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
*/

        // counts = inches * 1120 (counts per revolution)/ 4*pi (circumference of wheels)
        // 1120/4*pi ~ 89 - we found that there was less error when given a precise number

/*
       NewLeftFrontTarget = (int) (totalInches * 1);
        NewLeftBackTarget = (int) (totalInches * 89);
        NewRightFrontTarget = (int) (totalInches * 89);
        NewRightBackTarget = (int) (totalInches * 89);
*/
        //get current position of the encoders at the start of the method
/*
        leftFront.setTargetPosition(leftFrontDirection * NewLeftFrontTarget);
        leftBack.setTargetPosition(leftBackDirection * NewLeftBackTarget);
        rightFront.setTargetPosition(rightFrontDirection * NewRightFrontTarget);
        rightBack.setTargetPosition(rightBackDirection * NewRightBackTarget);
*/
/*
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
*/
        //reset the timeout time  and start motion

        driveTime = 0;

        //powers scaled scaled based on trials & by the same as encoder values, so that everything
        //stops at the same time

        leftFront.setPower(power * leftFrontDirection * .99);
        leftBack.setPower(power * leftBackDirection * .99);
        rightFront.setPower(power * rightFrontDirection * .99);
        rightBack.setPower(power * rightBackDirection * .99);

        while (leftFront.isBusy() && leftBack.isBusy() && rightFront.isBusy() && rightBack.isBusy()) {

        }

        // stops all motion

        leftFront.setPower(0.0);
        leftBack.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
    }


/*public void RubberBand (double power)
{ GrabberArm.setPower(power);}*/




    //-------------------------BUILDBOARD-GRABBER--------------------------------------------------------



   public void Grabber(double positionL, double positionR)
    { Grab1.setPosition(positionL);
    Grab2.setPosition((positionR));
    }


  //  public void twister(double power)
    {
  //      twist.setPower(power);
    }

   // public void moveClaw (double power){
     //   claw.setPower(power);


}


   // public void BackGrabber(double positionL, double positionR) {
       // Backgrab.setPosition(positionL);
        //Backgrab2.setPosition(positionR);







