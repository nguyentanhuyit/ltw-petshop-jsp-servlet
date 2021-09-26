package service;


import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

public class CreatLink {
    MD5 md5 = new MD5();
    public CreatLink() {
    }

//    public String creatToken() throws Exception {
//        String charac = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
//        StringBuffer token = new StringBuffer();
//        SecureRandom rnd = new SecureRandom();
//
//        while (token.length() < 1000) { // length of the random string.
//            int index = (int) (rnd.nextFloat() * charac.length());
//            token.append(charac.charAt(index));
//        }
//        String strBuild = token.toString();
//        System.out.println(strBuild);
//        String generateEncode = md5.encryptMD5String(strBuild);
//         return generateEncode;
//    }

    public static void main(String[] args) throws Exception {
        CreatLink cr = new CreatLink();
//        System.out.println(cr.creatToken());
//        String str ="agiRQduUR5tJ3G9Kmao4vSQLbkk4pWu65XNxhAOmfcI6sNxrJVxEYwQRXjAXDYvSwKU2qaei7ujJ5H2PVpcjtkeF2c5zs0cBWembP1ez3x5tpNL7xFpK7MAopNOldCBfHzwGXieOgoH4Sl5wd5AhB1hGfkb52rit1qaunDsC5HUJZKt72pGEwcDxPxNk4wND6RHEChxc2GQse09pm4WhHiFe93lmhxd1f09D8uTY0tXhVlCMJejGgjne9bOcW9yYkVcLEb7T6GIt7bkXnK3TyB2sQA5Bl4itBenzR68YUBCpKMBL7mndHPLsPoNnrGKrllkItfG2OJBY2byFBmcvP5ZwAXkfFXl53igNq17gTNRyxC0KU7UEHEIsbwWQZ6L0IZv5jLjdQqmJE1jLdN5TkGH6NSR7MOktGelp1rtIOXXJSPEVCgvgXBFIm400t3OewB9JDbZTUqgiP9C8qD1jgyXXDVC5i9wdFY07tkupKmkWStrDST9atIIkhztuDoQThFUybOaLifyYUHbhcmgQW7Mg5KoRr99huJcTricEIk4hcUjeB0C5QilU3c5EdHQSEXu3AXVkODHTLN5E0ULWOo3Q2RHFy4B054SEuIqajPFOVEmaVGcZdpxRrRJbuc6KPrzjUeN7TFvZiwyObPcedLBlIUcdsemU5cPLB7K54yK6atdTMhuo0oLOLKUBWed83JImFXKLN2RZPFK2xLMlbEyeHepFHkVfgQ9RniX6gCzjbuAoVDQAWJwVlfol3Y5ktid2xeRk19CuiqY854W1XWf7SHAnIY9JEbb5lvkj9pWe5IHeiQX9HTu1jXFskdXxxIrIFuzr7eOL50N2xlStrRKausjn055GyHx5O3JPRMqi799SBwz6J6UCePBKZYxNthiSCkqwiWFc2R8sS3PjYEqZoF0g0uGNk0bQheIns3raSyLDIhPNP63jRnFm5fz3vB2l1MBN15VYP4AHveBDyGBQKwc92K8RqMP5HTDz";
////        ebc540e1a88ba14f4bbe88d69edeb59e
//        MD5  g= new MD5();
//        System.out.println(g.encryptMD5String(str));
    }
}
