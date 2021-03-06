package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
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

    //
    public DcMotor arm;


    //public DcMotor Grabber


    //Actuator motor
    public DcMotor LinearActuator;

    //Board Grabber servos
    public Servo Grab1;
    public Servo Grab2;
    // public CRServo twist;


    public Servo Thumper1;
    public Servo Thumper2;


    // IMPORTANT:  For Phone Camera, set 1) the camera source and 2) the orientation, based on how your phone is mounted:
    // 1) Camera Source.  Valid choices are:  BACK (behind screen) or FRONT (selfie side)
    // 2) Phone Orientation. Choices are: PHONE_IS_PORTRAIT = true (portrait) or PHONE_IS_PORTRAIT = false (landscape)
    //
    // NOTE: If you are running on a CONTROL HUB, with only one USB WebCam, you must select CAMERA_CHOICE = BACK; and PHONE_IS_PORTRAIT = false;
    //

        private static final VuforiaLocalizer.CameraDirection CAMERA_CHOICE = BACK;
        private static final boolean PHONE_IS_PORTRAIT = false;

        private static final String VUFORIA_KEY =
                " AddfCmL/////AAAAGfhZdqZawEPNnf6i6NP5bBJnbxm51Vv6Ic543cGLSFZRXzcCLKL8Dz/UCbHG7kVdxhx3dkMGRdopyfekAowHmlslyP5m3pZkhDaGrzdVyZZnVV7rho4mjaUSBQJhx6plhZyFPPK6q7+7xcdFXRhSpOXtRTU3tjVQOFbA2B9uuRGheb1HeidRDvhS/856blHK3Wv +PmeJBgZIrPkGOrLPDsyUqQtFZxKnn65Yce43u0wcs/dbn0ssr+bvvqp1Q4JKJrm2XnzwmtqNd0PZHO6hxHzyaxC5ge +aExWcSEM72yE8d1DznHQ/s5wYRJpVaAss7/F885CTL0zB+Pzcb3wfuG93rlIQE8coMcmqrk+tmuHH ";

        // Since ImageTarget trackables use mm to specifiy their dimensions, we must use mm for all the physical dimension.
        // We will define some constants and conversions here
        private static final float mmPerInch = 25.4f;
        private static final float mmTargetHeight = (6) * mmPerInch;          // the height of the center of the target image above the floor

        // Constant for Stone Target
        private static final float stoneZ = 2.00f * mmPerInch;

        // Constants for the center support targets
        private static final float bridgeZ = 6.42f * mmPerInch;
        private static final float bridgeY = 23 * mmPerInch;
        private static final float bridgeX = 5.18f * mmPerInch;
        private static final float bridgeRotY = 59;                                 // Units are degrees
        private static final float bridgeRotZ = 180;

        // Constants for perimeter targets
        private static final float halfField = 72 * mmPerInch;
        private static final float quadField = 36 * mmPerInch;

        // Class Members
        private OpenGLMatrix lastLocation = null;
        private VuforiaLocalizer vuforia = null;
        private boolean targetVisible = false;
        private float phoneXRotate = 0;
        private float phoneYRotate = 0;
        private float phoneZRotate = 0;

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

        LinearActuator = HWMap.dcMotor.get("LinearActuator");

        arm = HWMap.dcMotor.get("arm");

        // GrabberArm = HWMap.dcMotor.get("GrabberArm");

        Grab1 = HWMap.servo.get("Grab1");
        Grab2 = HWMap.servo.get("Grab2");

        Thumper1= HWMap.servo.get("Thumper1");
        Thumper2 = HWMap.servo.get("Thumper2");


        //  twist = HWMap.crservo.get("twist");



        Thumper1.setPosition(1);
        Thumper2.setPosition(0);




        int cameraMonitorViewId = HWMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", HWMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        // VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters();

        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = BACK;

        //  Instantiate the Vuforia engine
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        // Load the data sets for the trackable objects. These particular data
        // sets are stored in the 'assets' part of our application.
        VuforiaTrackables targetsSkyStone = this.vuforia.loadTrackablesFromAsset("Skystone");

        VuforiaTrackable stoneTarget = targetsSkyStone.get(0);
        stoneTarget.setName("Stone Target");
        VuforiaTrackable blueRearBridge = targetsSkyStone.get(1);
        blueRearBridge.setName("Blue Rear Bridge");
        VuforiaTrackable redRearBridge = targetsSkyStone.get(2);
        redRearBridge.setName("Red Rear Bridge");
        VuforiaTrackable redFrontBridge = targetsSkyStone.get(3);
        redFrontBridge.setName("Red Front Bridge");
        VuforiaTrackable blueFrontBridge = targetsSkyStone.get(4);
        blueFrontBridge.setName("Blue Front Bridge");
        VuforiaTrackable red1 = targetsSkyStone.get(5);
        red1.setName("Red Perimeter 1");
        VuforiaTrackable red2 = targetsSkyStone.get(6);
        red2.setName("Red Perimeter 2");
        VuforiaTrackable front1 = targetsSkyStone.get(7);
        front1.setName("Front Perimeter 1");
        VuforiaTrackable front2 = targetsSkyStone.get(8);
        front2.setName("Front Perimeter 2");
        VuforiaTrackable blue1 = targetsSkyStone.get(9);
        blue1.setName("Blue Perimeter 1");
        VuforiaTrackable blue2 = targetsSkyStone.get(10);
        blue2.setName("Blue Perimeter 2");
        VuforiaTrackable rear1 = targetsSkyStone.get(11);
        rear1.setName("Rear Perimeter 1");
        VuforiaTrackable rear2 = targetsSkyStone.get(12);
        rear2.setName("Rear Perimeter 2");

        // For convenience, gather together all the trackable objects in one easily-iterable collection */
        List<VuforiaTrackable> allTrackables = new ArrayList<VuforiaTrackable>();
        allTrackables.addAll(targetsSkyStone);

        // Set the position of the Stone Target.  Since it's not fixed in position, assume it's at the field origin.
        // Rotated it to to face forward, and raised it to sit on the ground correctly.
        // This can be used for generic target-centric approach algorithms
        stoneTarget.setLocation(OpenGLMatrix
                .translation(0, 0, stoneZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));

        //Set the position of the bridge support targets with relation to origin (center of field)
        blueFrontBridge.setLocation(OpenGLMatrix
                .translation(-bridgeX, bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, bridgeRotY, bridgeRotZ)));

        blueRearBridge.setLocation(OpenGLMatrix
                .translation(-bridgeX, bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, -bridgeRotY, bridgeRotZ)));

        redFrontBridge.setLocation(OpenGLMatrix
                .translation(-bridgeX, -bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, -bridgeRotY, 0)));

        redRearBridge.setLocation(OpenGLMatrix
                .translation(bridgeX, -bridgeY, bridgeZ)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 0, bridgeRotY, 0)));

        //Set the position of the perimeter targets with relation to origin (center of field)
        red1.setLocation(OpenGLMatrix
                .translation(quadField, -halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 180)));

        red2.setLocation(OpenGLMatrix
                .translation(-quadField, -halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 180)));

        front1.setLocation(OpenGLMatrix
                .translation(-halfField, -quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 90)));

        front2.setLocation(OpenGLMatrix
                .translation(-halfField, quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 90)));

        blue1.setLocation(OpenGLMatrix
                .translation(-quadField, halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 0)));

        blue2.setLocation(OpenGLMatrix
                .translation(quadField, halfField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, 0)));

        rear1.setLocation(OpenGLMatrix
                .translation(halfField, quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));

        rear2.setLocation(OpenGLMatrix
                .translation(halfField, -quadField, mmTargetHeight)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, XYZ, DEGREES, 90, 0, -90)));

        //
        // Create a transformation matrix describing where the phone is on the robot.
        //
        // NOTE !!!!  It's very important that you turn OFF your phone's Auto-Screen-Rotation option.
        // Lock it into Portrait for these numbers to work.
        //
        // Info:  The coordinate frame for the robot looks the same as the field.
        // The robot's "forward" direction is facing out along X axis, with the LEFT side facing out along the Y axis.
        // Z is UP on the robot.  This equates to a bearing angle of Zero degrees.
        //
        // The phone starts out lying flat, with the screen facing Up and with the physical top of the phone
        // pointing to the LEFT side of the Robot.
        // The two examples below assume that the camera is facing forward out the front of the robot.

        // We need to rotate the camera around it's long axis to bring the correct camera forward.
        if (CAMERA_CHOICE == BACK) {
            phoneYRotate = -90;
        } else {
            phoneYRotate = 90;
        }

        // Rotate the phone vertical about the X axis if it's in portrait mode
        if (PHONE_IS_PORTRAIT) {
            phoneXRotate = 90;
        }

        // Next, translate the camera lens to where it is on the robot.
        // In this example, it is centered (left to right), but forward of the middle of the robot, and above ground level.
        final float CAMERA_FORWARD_DISPLACEMENT = 4.0f * mmPerInch;   // eg: Camera is 4 Inches in front of robot center
        final float CAMERA_VERTICAL_DISPLACEMENT = 8.0f * mmPerInch;   // eg: Camera is 8 Inches above ground
        final float CAMERA_LEFT_DISPLACEMENT = 0;     // eg: Camera is ON the robot's center line

        OpenGLMatrix robotFromCamera = OpenGLMatrix
                .translation(CAMERA_FORWARD_DISPLACEMENT, CAMERA_LEFT_DISPLACEMENT, CAMERA_VERTICAL_DISPLACEMENT)
                .multiplied(Orientation.getRotationMatrix(EXTRINSIC, YZX, DEGREES, phoneYRotate, phoneZRotate, phoneXRotate));

        /**  Let all the trackable listeners know where the phone is.  */
        for (VuforiaTrackable trackable : allTrackables) {
            ((VuforiaTrackableDefaultListener) trackable.getListener()).setPhoneInformation(robotFromCamera, parameters.cameraDirection);
        }
}




    //--------------------------DRIVE--FORWARD-------------------------------------------------------



    public void driveStraight(double power, double Direction) { //For driving

        driveTime = 0;

        leftFront.setPower(power * -Direction * .99);
        leftBack.setPower(power * -Direction * .99);

        rightFront.setPower(power * Direction * .99);
        rightBack.setPower(power * Direction * .99);

    }
    //--------------------------DRIVE--TURN-------------------------------------------------------

    public void driveTurn(double power, String direction) { //For driving

        driveTime = 0;
        int leftFrontDirection;
        int leftBackDirection;
        int rightFrontDirection;
        int rightBackDirection;


        if (direction.equals("leftturn")) {
            leftFrontDirection = 1;
            leftBackDirection = 1;
            rightFrontDirection = 1;
            rightBackDirection = 1;
        } else {
            leftFrontDirection = -1;
            leftBackDirection = -1;
            rightFrontDirection = -1;
            rightBackDirection = -1;
        }

        leftFront.setPower(power * leftFrontDirection * .8);
        leftBack.setPower(power * leftBackDirection * .9);
        rightFront.setPower(power * rightFrontDirection);
        rightBack.setPower(power * rightBackDirection * .8);

    }




    //------------------------------DRIVE--SIDEWAYS--------------------------------------------------
    /*  This method makes the robot move in a sideways direction.
        It is separate from the other drive method because the motors on each side must turn
        in opposite directions. (See Mecanum Drive diagram)
        Because the weight on the robot is not evenly balanced, we found that each motor
        needed to run at a slightly different power (and thus had a slightly different encoder count).
     */


    public void driveMecanum(double power, String direction) {
        // declare variables for this method
        int leftFrontDirection;
        int leftBackDirection;
        int rightFrontDirection;
        int rightBackDirection;

        if (direction.equals("right")) {
            leftFrontDirection = 1;
            leftBackDirection = -1;
            rightFrontDirection = 1;
            rightBackDirection = -1;
        }
        else {
            leftFrontDirection = -1;
            leftBackDirection = 1;
            rightFrontDirection = -1;
            rightBackDirection = 1;
        }

        //powers scaled scaled based on trials & by the same as encoder values, so that everything
        //stops at the same time

        leftFront.setPower(power * leftFrontDirection * .99);
        leftBack.setPower(power * leftBackDirection * .99);
        rightFront.setPower(power * rightFrontDirection * .99);
        rightBack.setPower(power * rightBackDirection * .99);

    }


/*public void RubberBand (double power)
{ GrabberArm.setPower(power);}*/


//-------------------------BUILDBOARD-GRABBER--------------------------------------------------------


    public void Grabber(double positionR, double positionL) {
        Grab1.setPosition(positionR);
        Grab2.setPosition((positionL));
    }


//-------------------------SKYSTONE-THUMPER-------------------------------------------------------------



    public void ThumperClamp (double positionR, double positionL) {
        Thumper1.setPosition(positionR);
        Thumper2.setPosition(positionL);
    }

//-------------------------STOP-BUMBLEBARRY-------------------------------------------------------------
 public void stop (double power) {
        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
 }




    }









