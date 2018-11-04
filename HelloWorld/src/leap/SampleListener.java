package leap;

import com.leapmotion.leap.*;
import java.lang.Math.*;

public class SampleListener extends Listener{
	//invokes by the controller
	public void onConnect(Controller controller) {
		//do something on connect
		System.out.println("Connected");
	}
	
	 public void onFrame(Controller controller) {
		 //get a frame
		 Frame frame = controller.frame();
		 HandList hands = frame.hands();
		 FingerList fingers;
		 Finger.Type fingerFrontmostType;
		 
		 // if the hand list is empty, do nothing
		 if (hands.isEmpty()) {
			 //System.out.println("Blank!");
		 }
		 
		 //when hand list is not empty then start do analysis
		 else {
			 Hand firstHand = hands.get(0);			 
			 //get position, velocity and direction
			 //Vector position = firstHand.palmPosition();
			 //Vector velocity = firstHand.palmVelocity();
			 //Vector direction = firstHand.direction();
			 
			 //get pitch, yaw, roll
			 /*float pitch = firstHand.direction().pitch();
			 float yaw = firstHand.direction().yaw();
			 float roll = firstHand.palmNormal().roll();*/
			  
			 if (firstHand.isLeft()) {
				 fingerFrontmostType = firstHand.fingers().frontmost().type();
				 System.out.println("Left Hand, frontmost = "+ fingerFrontmostType);
				 //System.out.print("Position: "+position+", Velocity: "+velocity+" ,Direction: "+direction);
				 //System.out.println("Roll: "+roll);
				 //System.out.println("Pitch: "+ Math.toDegrees(pitch));
			 }
			 
			 else{
				fingerFrontmostType = firstHand.fingers().frontmost().type();
				System.out.println("Right Hand, frontmost = " + fingerFrontmostType);
				 //System.out.println("Pitch: "+ Math.toDegrees(pitch));
			 }
			 
			 
			 /*System.out.println("Frame id: " + frame.id()
	         + ", timestamp: " + frame.timestamp()
	         + ", hands: " + frame.hands().count()
	         + ", fingers: " + frame.fingers().count());*/
	    }
	 }
}
