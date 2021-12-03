package utilities;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
public class Testlog {

	private static Logger log = LogManager.getLogger(Testlog.class);
	
	
	
	public static void main(String[] args){
		
		for (int i=200;i<250;i++)
		{
		log.info("test"+i);
		
		log.debug("dfdf");
		log.error("dfdfdfxf");
		log.warn("dfdfdfdfdf");
		}
	}
	
}
