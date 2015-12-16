package junxiao.leetcode;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class GreeterTest {

	@Test
	public void testSayHello() {
        //fail("Not yet implemented");
        Greeter test = mock(Greeter.class);
        when(test.sayHello()).thenReturn("fake...");
        assertEquals("mock test 1", test.sayHello(),"fake...");
        //assertEquals("mock test 2", test.sayHello(),"Hello world!");
	}

}
