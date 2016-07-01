package ru.eqlbin.utils.net.ipv4.test;

import static org.junit.Assert.*;
import static ru.eqlbin.utils.net.ipv4.IPv4Utils.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import ru.eqlbin.utils.net.ipv4.IPv4Utils;
import ru.eqlbin.utils.net.ipv4.InvalidIPAddressException;

import java.util.Arrays;

public class IPv4UtilsTest {
    
    private final String referenceStringIP = "192.168.1.1";
    private final int referenceIntIP = -1062731519;
    private final byte[] referenceBytesIP = {-64, -88, 1, 1};
    
    private final String invalidStringIP = "192.168.1.256";
    
    @Rule
    public final SimpleTestWatcher watcher = new SimpleTestWatcher();
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAsByteArrayFromString() {
        assertTrue(Arrays.equals(asByteArray(referenceStringIP), referenceBytesIP));
    }

    @Test
    public void testAsIntegerFromString() {
        assertTrue(asInteger(referenceStringIP) == referenceIntIP);
    }

    @Test
    public void testAsIntegerFromByteArray() {
        assertTrue(asInteger(referenceBytesIP) == referenceIntIP);
    }

    @Test
    public void testAsStringFromInt() {
        assertTrue(IPv4Utils.asString(referenceIntIP).equals(referenceStringIP));
    }

    @Test(expected = InvalidIPAddressException.class)
    public void testValidateIPInvalid() {
        validateIP(invalidStringIP);
    }
    
    @Test
    public void testValidateIP() {
        validateIP(referenceStringIP);
    }

}
