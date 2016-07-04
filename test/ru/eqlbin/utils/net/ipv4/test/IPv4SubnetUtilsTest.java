package ru.eqlbin.utils.net.ipv4.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import ru.eqlbin.utils.net.ipv4.IPv4Utils;
import ru.eqlbin.utils.net.ipv4.InvalidRoutingPrefixLengthException;
import ru.eqlbin.utils.net.ipv4.InvalidSubnetMaskException;

import static ru.eqlbin.utils.net.ipv4.IPv4SubnetUtils.*;

public class IPv4SubnetUtilsTest {

    private int zeroSubnetMask = IPv4Utils.asInteger("0.0.0.0"); 
    private int validSubnetMask = IPv4Utils.asInteger("255.255.255.192");
    private int invalidSubnetMask = IPv4Utils.asInteger("255.255.255.130");
    private int network = IPv4Utils.asInteger("192.168.5.128");
    private int ipFromSubnet = IPv4Utils.asInteger("192.168.5.135");
    private int ipFromAnotherSubnet = IPv4Utils.asInteger("192.168.5.195");
    private int broadcastForSubnet = IPv4Utils.asInteger("192.168.5.191");
    private int validPrefixLength = 26;
    private int invalidPrefixLength = 33;
    private int zeroPrefixLength = 0;
    private int subnetCount = 4;
    private int addressPerSubnetCount = 62;
    
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
    public void testSubnetMaskToPrefixLength() {
        assertTrue("Wrong routing prefix length!",
                subnetMaskToPrefixLength(validSubnetMask) == validPrefixLength);
    }

    @Test(expected = InvalidSubnetMaskException.class)
    public void testInvalidSubnetMaskToPrefixLength() {
        subnetMaskToPrefixLength(invalidSubnetMask);
    }

    @Test(expected = InvalidSubnetMaskException.class)
    public void testZeroSubnetMaskToPrefixLength() {
        subnetMaskToPrefixLength(zeroSubnetMask);
    }
    
    public void testPrefixLengthToSubnetMask() {
        assertTrue("Wrong subnet mask!",
                prefixLengthToSubnetMask(validPrefixLength) == validSubnetMask);
    }
    
    @Test(expected = InvalidRoutingPrefixLengthException.class)
    public void testInvalidPrefixLengthToSubnetMask() {
        prefixLengthToSubnetMask(invalidPrefixLength);
    }
    
    @Test(expected = InvalidRoutingPrefixLengthException.class)
    public void testZeroPrefixLengthToSubnetMask() {
        prefixLengthToSubnetMask(zeroPrefixLength);
    }

    @Test
    public void testAddressPerSubnetCount() {
        assertTrue("Wrong count of addresses per one subnet!", 
                addressPerSubnetCount(validSubnetMask) == addressPerSubnetCount);
    }

    @Test
    public void testSubnetCount() {
        assertTrue("Wrong subnet count!", 
                subnetCount(validSubnetMask) == subnetCount);
    }

    @Test
    public void testNetwork() {
        assertTrue("Wrong network!", 
                network(ipFromSubnet, validSubnetMask) == network);
    }

    @Test
    public void testBrodcast() {
        assertTrue("Wrong broadcast!", 
                brodcast(ipFromSubnet, validSubnetMask) == broadcastForSubnet);
    }

    @Test
    public void testIsInRange() {
        assertTrue("IP is not in range, but should be!", 
                isInRange(ipFromSubnet, network, validSubnetMask));
        assertFalse("IP is in range, but should not be!",
                isInRange(ipFromAnotherSubnet, network, validSubnetMask));
    }
}
