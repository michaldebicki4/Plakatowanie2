package com.michaldebicki;


import java.util.*;

public class Main implements Runnable {
    public static void main(String[] args) {
        new Thread(new Main()).start();
    }
    public void run() {
        try {
            int lewaKrawedz;
            int prawaKrawedz;
            MyScanner scanner = new MyScanner();
            int n = scanner.nextInt();
            Integer[] dlugosc = new Integer[n];
            Integer[] wysokosc = new Integer[n + 2];
            wysokosc[0] = 0;
            wysokosc[n + 1] = 0;
            for (int i = 0; i <= n - 1; i++) {
                dlugosc[i] = scanner.nextInt();
                wysokosc[i + 1] = scanner.nextInt();
            }
            int count = 0;
            int h = Collections.max(Arrays.asList(wysokosc));
            int hTymczasowe;
            int min = Collections.min(Arrays.asList(wysokosc));
            int dlugoscSklejki;

            if (h == min) {
                count = 1;
            } else {
                for (int i = n + 1; i >= 0; i--) {
                    hTymczasowe = h;
                    if (wysokosc[i] == h) {
                        lewaKrawedz = wysokosc[i - 1];
                        prawaKrawedz = wysokosc[i + 1];
                        dlugoscSklejki = 0;
                        while (lewaKrawedz == h) {
                            i--;
                            dlugoscSklejki++;
                            if (i != 0) {
                                lewaKrawedz = wysokosc[i - 1];
                            }
                        }

                        //sprawdzamy do której krawędzi obniżamy
                        if (prawaKrawedz >= lewaKrawedz) {
                            for (int j = dlugoscSklejki; j >= 0; j--) {
                                wysokosc[i + dlugoscSklejki] = prawaKrawedz;
                                dlugoscSklejki--;
                            }
                        } else {
                            for (int j = dlugoscSklejki; j >= 0; j--) {
                                wysokosc[i + dlugoscSklejki] = lewaKrawedz;
                                dlugoscSklejki--;
                            }
                        }

                        //zwiększamy wynik końcowy
                        count++;


                        h = Collections.max(Arrays.asList(wysokosc));
                        if (h == hTymczasowe) {
                            //podążamy dalej szukając tej samej wysokości
                        } else if (h == min) {
                            i = -1;
                        } else {
                            i = n + 2;
                        }
                    }
                }
                //wyjscie
                System.out.println(count);
            }
        } catch (Exception e){
            throw new RuntimeException();
        }
    }
}
