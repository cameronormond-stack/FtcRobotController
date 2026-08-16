package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class RobotArmTest extends OpMode {

    private DcMotor extender;
    private DcMotor rotater;

    public void init() {
        extender = hardwareMap.get(DcMotor.class, "Extender");
        rotater = hardwareMap.get(DcMotor.class, "Rotater");
        extender.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rotater.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    public void setExtender(double ESpeed) {
        extender.setPower(ESpeed);
    }

    public void setRotater(double RSpeed) {
        rotater.setPower(RSpeed);
    }

    @Override
    public void loop() {

    }
}
