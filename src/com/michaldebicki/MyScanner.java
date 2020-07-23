package com.michaldebicki;

import java.io.*;
import java.util.StringTokenizer;

public class MyScanner {
    BufferedReader br;
    StringTokenizer st;

    public MyScanner () {
        try {
            InputStream inputStream = new FileInputStream("pla4a.in");
            br = new BufferedReader(new InputStreamReader(inputStream));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}

