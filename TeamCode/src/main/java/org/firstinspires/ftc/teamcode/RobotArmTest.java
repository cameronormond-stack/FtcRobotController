package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class RobotArmTest {

    private DcMotor extender;
    private DcMotor rotater;

    public void init(HardwareMap hwMap) {
        extender = hwMap.get(DcMotor.class, "Extender");
        rotater = hwMap.get(DcMotor.class, "Rotater");
        extender.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rotater.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    public void setExtender(double ESpeed) {
        extender.setPower(ESpeed);
    }

    public void setRotater(double RSpeed) {
        rotater.setPower(RSpeed);
    }

    public void loop() {

    }
}
