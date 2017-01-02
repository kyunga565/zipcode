package zipcode.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConnectionFactoryTest {
private static Connection instance;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = zipcodeUtil.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		jdbc.close(instance);
	}

	@Test
	public void testConnection() {
		Assert.assertNotNull(instance);
	}

}
