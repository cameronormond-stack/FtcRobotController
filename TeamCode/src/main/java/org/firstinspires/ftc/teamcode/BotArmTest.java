package org.firstinspires.ftc.teamcode;

public class BotArmTest {
    RobotArmTest arm = new RobotArmTest();

    public void init() {
        arm.init();
    }

    public void loop() {
        arm.setExtender(0.5);
        arm.setRotater(0.5);
    }
}
