package com.sl.boot.admindemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdmindemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testTrim() {
        String str = "   ";
        System.out.println(str.equals(""));
        System.out.println(str.trim().equals(""));
    }

    @Test
    void quan() {
        int a[] = {1, 2, 3, 4, 5, 6};

        int l = a.length;

        int nBit = 1 << l;

        for (int i = 1; i <= nBit; i++) {
            for (int j = 0; j < l; j++) {
                if ((i << (31 - j)) >> 31 == -1) {
                    System.out.print(a[j]);
                    String.valueOf(a[j]);
                }
            }
            System.out.println();
        }

    }

}
