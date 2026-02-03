package fr.epita.assistants.streamstudent;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StreamStudentTest {
    static void assertStreamEquals(Stream<Pair<Integer, String>> expectedStream,
                                   Stream<Pair<Integer, String>> actualStream) {
        // Get iterators from stream
        Iterator<Pair<Integer, String>> iterator1 = expectedStream.iterator();
        Iterator<Pair<Integer, String>> iterator2 = actualStream.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            // Get next objects
            Pair<Integer, String> login1 = iterator1.next();
            Pair<Integer, String> login2 = iterator2.next();

            // Check if pairs are equal
            assertEquals(login1, login2);
        }

        assertTrue(!iterator1.hasNext() && !iterator2.hasNext(),
                "Streams do not have the same length");

    }

    @Test
    public void validatorLoginContainsTwoOrMoreUnderscore() {
        Pair<Integer, String> loginTwoUnderscore = new Pair<>(50, "xavier._login");
        Pair<Integer, String> loginValid = new Pair<>(90, "xavier_login");
        Pair<Integer, String> loginMultipleUnderscord = new Pair<>(-1000, "login_x");
        Streamer streamer = new Streamer();

        var loginList = List.of(loginTwoUnderscore, loginValid, loginMultipleUnderscord);

        var expected = List.of(loginValid).stream();
        var actual = streamer.validator(loginList.stream());

        assertStreamEquals(expected, actual);
    }

    @Test
    public void validatorLoginContainsTwoOrMoreUnderscore2() {
        Pair<Integer, String> loginTwoUnderscore = new Pair<>(50, "xavierlogin_");
        Pair<Integer, String> loginValid = new Pair<>(90, "xavier_log_in");
        Pair<Integer, String> loginValid2 = new Pair<>(90, "xavier..login");
        Pair<Integer, String> loginValid3 = new Pair<>(90, "xa.vier_logi.n");
        Pair<Integer, String> loginValid4 = new Pair<>(90, "xavier_login");
        Streamer streamer = new Streamer();

        var loginList = List.of(loginTwoUnderscore, loginValid, loginValid2, loginValid3, loginValid4);

        var expected = List.of(loginValid4).stream();
        var actual = streamer.validator(loginList.stream());

        assertStreamEquals(expected, actual);
    }

    @Test
    public void testOrder() {
        Pair<Integer, String> one = new Pair<>(2, "zzz_z");
        Pair<Integer, String> two = new Pair<>(2, "aaaa_z");
        Pair<Integer, String> three = new Pair<>(1, "aaa_z");
        Streamer streamer = new Streamer();

        var loginList = List.of(three, two, one);

        var expected = Stream.of(three, two, one);
        var actual = streamer.orderGrade(loginList.stream());

        assertStreamEquals(expected, actual);
    }
}
