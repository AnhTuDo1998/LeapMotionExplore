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
		 
		 Hand firstHand = hands.get(0);
		 
		//get fingers
		 FingerList fingers = firstHand.fingers();
		 
		 //get position, velocity and direction
		 //Vector position = firstHand.palmPosition();
		 //Vector velocity = firstHand.palmVelocity();
		 //Vector direction = firstHand.direction();
		 
		 float pitch = firstHand.direction().pitch();
		 float yaw = firstHand.direction().yaw();
		 float roll = firstHand.palmNormal().roll();
		 if (firstHand.isLeft()) {
			 System.out.println("Left Hand detected");
			 //System.out.print("Position: "+position+", Velocity: "+velocity+" ,Direction: "+direction);
			 //System.out.println("Roll: "+roll);
			 System.out.println("Pitch: "+ Math.toDegrees(pitch));
		 }
		 else{
			 System.out.println("Right Hand detected");
		 }
		 
		 /*System.out.println("Frame id: " + frame.id()
         + ", timestamp: " + frame.timestamp()
         + ", hands: " + frame.hands().count()
         + ", fingers: " + frame.fingers().count());*/
	    }
}
