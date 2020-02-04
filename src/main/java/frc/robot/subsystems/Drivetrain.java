package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem {

    CANSparkMax _leftBackCanSparkMax = new CANSparkMax((13), MotorType.kBrushless);

    CANSparkMax _leftFrontCanSparkMax = new CANSparkMax((12), MotorType.kBrushless);
  
    CANSparkMax _rightBackCanSparkMax = new CANSparkMax((14), MotorType.kBrushless);
  
    CANSparkMax _rightFrontCanSparkMax = new CANSparkMax((11), MotorType.kBrushless); 

    private SpeedControllerGroup m_LeftMotors = new SpeedControllerGroup(_leftBackCanSparkMax, _leftFrontCanSparkMax);
    private SpeedControllerGroup m_RightMotors = new SpeedControllerGroup(_rightBackCanSparkMax, _rightFrontCanSparkMax);
   
    private DifferentialDrive m_Drive = new DifferentialDrive(m_LeftMotors, m_RightMotors);

    double leftBack_encoder = _leftBackCanSparkMax.getEncoder().getPosition();
    double rightBack_encoder = _rightBackCanSparkMax.getEncoder().getPosition();

    
   public Drivetrain() {


   }

   public void arcadeDrive(double m_LeftMotors, double m_RightMotors) {
		m_Drive.tankDrive(m_LeftMotors, m_RightMotors);
    }
    
    public double getLeftBack_encoder() {
        return leftBack_encoder;
    }

    public double getRightBack_encoder() {
        return rightBack_encoder;
    }

    // public void resetDriveEncoders() {
    //     CANEncoder leftEncoder = new CANEncoder();
    // }

    public double getDriveEncoderDistance() {
		double driveEncoderCountsPerFoot = 6.28;
		return (getLeftBack_encoder() / (driveEncoderCountsPerFoot)) * 12;
	}

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub

    }
    
}