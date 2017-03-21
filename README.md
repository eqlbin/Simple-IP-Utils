# Example

Code:

```java
int ip = IPv4Utils.asInteger("192.168.1.1");
int mask = IPv4Utils.asInteger("255.255.128.0");
System.out.println("IP address: " + IPv4Utils.asString(ip));
System.out.println("Subnet mask: " + IPv4Utils.asString(mask));

int network = IPv4SubnetUtils.network(ip, mask);
int broadcast = IPv4SubnetUtils.brodcast(ip, mask);
System.out.println("Network: " + IPv4Utils.asString(network));
System.out.println("Broadcast: " + IPv4Utils.asString(broadcast));

long subnetCount = IPv4SubnetUtils.subnetCount(mask);
long addressPerSubnetCount = IPv4SubnetUtils.addressPerSubnetCount(mask);
System.out.println("Number of subnets: " + subnetCount);
System.out.println("Adresses per subnet: " +addressPerSubnetCount);

for(String ipStr : new String[]{"192.168.0.1","192.168.127.254","192.168.128.1"}) {
    boolean inRange = IPv4SubnetUtils.isInRange(IPv4Utils.asInteger(ipStr), network, mask);
    System.out.println(inRange ? ipStr + " in range" : ipStr + " not in range");
}
```

Output:

```
IP address: 192.168.1.1
Subnet mask: 255.255.128.0
Network: 192.168.0.0
Broadcast: 192.168.127.255
Number of subnets: 2
Adresses per subnet: 32766
192.168.0.1 in range
192.168.127.254 in range
192.168.128.1 not in range
```
