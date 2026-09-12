package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Biobuzz1 extends OpMode {

    // Set up a variable for each drive wheel to save power level for telemetry.
    double leftFrontPower;
    double rightFrontPower;
    double leftBackPower;
    double rightBackPower;

    // Create a variable to set to the intake.
    double intakePower;

    // Motors
    DcMotor frontRightMotor;
    DcMotor backRightMotor;
    DcMotor frontLeftMotor;
    DcMotor backLeftMotor;
    DcMotor intake;
    CRServo frontRightServo;
    CRServo frontLeftServo;

    @Override
    public void init() {

        // Match motors to motor names in config
        frontLeftMotor = hardwareMap.get(DcMotor.class, "Front Left Motor");
        frontRightMotor = hardwareMap.get(DcMotor.class, "Front Right Motor");
        backLeftMotor = hardwareMap.get(DcMotor.class, "Back Left Motor");
        backRightMotor = hardwareMap.get(DcMotor.class, "Back Right Motor");
        intake = hardwareMap.get(DcMotorEx.class, "intake");

        // Reverse FL and BR motors for proper mecanum drive
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        // Match servos to servo names in config
        frontRightServo = hardwareMap.get(CRServo.class, "Front Right Servo");
        frontLeftServo = hardwareMap.get(CRServo.class, "Front Left Servo");

        frontLeftServo.setPower(0);
        frontRightServo.setPower(0);
        frontRightServo.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        // Set intake speeds
        frontLeftServo.setPower(1);
        frontRightServo.setPower(1);
        intake.setPower(1);

        // Gather inputs
        mecanumDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x);

    }

    void mecanumDrive(double forward, double strafe, double rotate) {

        // Maintains correct proportions of power to motors if one would exceed -1,1
        double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(rotate), 1);

        // Mecanum math
        leftFrontPower = (forward + strafe + rotate) / denominator;
        rightFrontPower = (forward - strafe - rotate) / denominator;
        leftBackPower = (forward - strafe + rotate) / denominator;
        rightBackPower = (forward + strafe - rotate) / denominator;

        // Apply motor powers
        frontLeftMotor.setPower(leftFrontPower);
        frontRightMotor.setPower(rightFrontPower);
        backLeftMotor.setPower(leftBackPower);
        backRightMotor.setPower(rightBackPower);
    }
}