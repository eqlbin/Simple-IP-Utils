// Copyright (c) 2016 Nikita Shpak aka eqlbin
// 
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to
// permit persons to whom the Software is furnished to do so, subject to
// the following conditions:
// 
// The above copyright notice and this permission notice shall be included
// in all copies or substantial portions of the Software.
// 
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
// IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
// CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
// TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
// SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

package ru.eqlbin.utils.net.ipv4;

import java.util.regex.Pattern;

/**
 * A set of static methods for converting IP(v4) addresses to different types
 * 
 * @author Nikita Shpak aka eqlbin
 *
 */
public class IPv4Utils {
    
    private static final String REGEXP_0_255 = "(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)";
    private static final Pattern IP_PATTERN = 
            Pattern.compile("^("+REGEXP_0_255+"\\.){3}"+REGEXP_0_255+"$");

    /**
     * Converts the string representation of the IP address, network or netmask in array of bytes.
     * 
     * @param ip a string representation of the IP address, network or netmask (for example 192.168.1.1)
     * @return IP address as array of bytes
     * @throws InvalidIPAddressException
     * @see #validateIP(String)
     */
    public static byte[] asByteArray(String ip){
        validateIP(ip);
        String[] ipParts = ip.split("\\.");
        
        return new byte[]{
                (byte)Short.parseShort(ipParts[0]),
                (byte)Short.parseShort(ipParts[1]),
                (byte)Short.parseShort(ipParts[2]),
                (byte)Short.parseShort(ipParts[3])};
    }
    
    /**
     * Converts the string representation of the IP address, network or netmask in integer.
     * 
     * @param ip a string representation of the IP address, network or netmask (for example 192.168.1.1)
     * @return an integer representation of the IP address
     * @throws InvalidIPAddressException
     * @see #validateIP(String)
     */
    public static int asInteger(String ip) {
        return asInteger(asByteArray(ip));
    }

    /**
     * Converts the bytes array representation of the IP address in integer.
     * 
     * @param ip IP address as array of bytes
     * @return an integer representation of the IP address
     */
    public static int asInteger(byte[] ip) {
        return (ip[0] & 0xff) << 24 | 
                (ip[1] & 0xff) << 16 | 
                (ip[2] & 0xff) << 8 | 
                (ip[3] & 0xff) << 0; 
    }
    
    /**
     * Converts the integer representation of the IP address in string.
     * 
     * @param ip an integer representation of the IP address
     * @return a string representation of the IP address (for example 192.168.1.1)
     */
    public static String asString(int ip) {
        
        short[] ipParts = new short[4];
        
        ipParts[0] = (short)((ip >> 24) & 0xff); 
        ipParts[1] = (short)((ip >> 16) & 0xff); 
        ipParts[2] = (short)((ip >> 8) & 0xff); 
        ipParts[3] = (short)(ip & 0xff); 

        return ipParts[0] + "." + ipParts[1] + "." + ipParts[2] + "." + ipParts[3];
    }
    
    /**
     * Verify that the ip address is valid.
     * 
     * @param ip a string representation of the IP address (for example 192.168.1.1)
     * @throws InvalidIPAddressException if the IP address 
     * does not match the regular expression 
     * <code>^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)$</code>
     */
    public static void validateIP(String ip) {
        if(!IP_PATTERN.matcher(ip).matches())
            throw new InvalidIPAddressException("'" + ip +"'");
    }
}
