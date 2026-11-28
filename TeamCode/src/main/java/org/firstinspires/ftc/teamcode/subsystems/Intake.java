package org.firstinspires.ftc.teamcode.subsystems;

import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.Constants.IntakeConstants;

import static com.pedropathing.ivy.commands.Commands.instant;

public class Intake {
    private final DcMotor motor;

    public Intake(HardwareMap hardwareMap) {
        motor = hardwareMap.get(DcMotor.class, IntakeConstants.MOTOR_NAME);
    }

    public Command run() {
        return Command.build()
            .setExecute(() -> motor.setPower(IntakeConstants.RUN_POWER))
            .setEnd(endCondition -> motor.setPower(0))
            .requiring(motor);
    }

    public Command reverse() {
        return Command.build()
            .setExecute(() -> motor.setPower(IntakeConstants.REVERSE_POWER))
            .setEnd(endCondition -> motor.setPower(0))
            .requiring(motor);
    }

    public Command stop() {
        return instant(() -> motor.setPower(0)).requiring(motor);
    }
}
