package fr.epita.assistants.test2;

import fr.epita.assistants.server.MyServer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test2Test {
    @Test
    void testDivisionBasic()
    {
        assertEquals(42, Test2.division(84, 2));
    }

    @Test
    void testDivisionHardSiiiiixxxSeeeeeevveennn()
    {
        assertEquals(67, Test2.division(203, 3));
    }

    @Test
    void testDivisionErrorZero()
    {
        assertThrows(ArithmeticException.class, () -> Test2.division(69, 0));
    }

    @Test
    void testDivisionErrorMaxInt()
    {
//        int test = Test2.division(Integer.MIN_VALUE, -1);
//        assertThrows(ArithmeticException.class, () -> Test2.division(Integer.MIN_VALUE, -1));
    }

    @Test
    void testTriboBasic0()
    {
        assertEquals(0, Test2.tribonacci(0));
    }

    @Test
    void testTriboBasic1()
    {
        assertEquals(1, Test2.tribonacci(1));
    }

    @Test
    void testTriboBasic2()
    {
        assertEquals(1, Test2.tribonacci(2));
    }

    @Test
    void testTriboHard()
    {
        assertEquals(2, Test2.tribonacci(3));
    }

    @Test
    @Timeout(1)
    void testTriboHardTimeout()
    {
        assertEquals(1714397773144522752L, Test2.tribonacci(Integer.MAX_VALUE));
    }

    @Test
    void testTriboError()
    {
        assertThrows(IllegalArgumentException.class, () -> Test2.tribonacci(-6767));
    }

    @Test
    void testServBasic()
    {
        try {
            MyServer.launchServer();

            assertEquals(200, Test2.serverGetResponseCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            MyServer.stopServer();
        }
    }

    @Test
    @Timeout(1)
    void testServBasicTimeout()
    {
        try {
            MyServer.launchServer();

            assertEquals(200, Test2.serverGetResponseCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            MyServer.stopServer();
        }
    }

    @Test
    void testServError()
    {
        assertThrows(IOException.class, Test2::serverGetResponseCode);
    }
}
