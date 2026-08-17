package org.firstinspires.ftc.teamcode;

import static android.os.SystemClock.sleep;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class BotArmTest extends OpMode{
    RobotArmTest arm = new RobotArmTest();

    public void init() {
        arm.init(hardwareMap);
    }

    public void loop() {
        arm.setExtender(1);
        arm.setRotater(0.0);
        sleep(2000);
        arm.setExtender(-1);
        sleep(2000);
        arm.setExtender(0);
        sleep(2000);
    }
}
