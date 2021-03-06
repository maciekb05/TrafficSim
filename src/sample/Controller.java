package sample;

import javafx.scene.layout.Pane;
import jdk.nashorn.api.tree.SimpleTreeVisitorES5_1;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class Controller {

    //Panel glowny do wyswietlania
    private Pane root;

    //kontroller
    Controller(Pane root) {
        this.root = root;
    }

    //inicjalizacja modelu
    void initializeModel() {
        int mult = 25;
        // street 1
        Point A1 = new Point(11 * mult, 0 * mult);
        Point A2 = new Point(11 * mult, 8 * mult);
        Point B1 = new Point(12 * mult, 0 * mult);
        Point B2 = new Point(12 * mult, 8 * mult);
        Point C1 = new Point(13 * mult, 0 * mult);
        Point C2 = new Point(13 * mult, 8 * mult);

        Point D1 = new Point(16 * mult, 8 * mult);
        Point D2 = new Point(16 * mult, 0 * mult);
        Point E1 = new Point(17 * mult, 8 * mult);
        Point E2 = new Point(17 * mult, 0 * mult);

        // street 2
        Point F1 = new Point(28 * mult, 11 * mult);
        Point F2 = new Point(20 * mult, 11 * mult);
        Point G1 = new Point(28 * mult, 12 * mult);
        Point G2 = new Point(20 * mult, 12 * mult);
        Point H1 = new Point(28 * mult, 13 * mult);
        Point H2 = new Point(20 * mult, 13 * mult);

        Point I1 = new Point(20 * mult, 16 * mult);
        Point I2 = new Point(28 * mult, 16 * mult);
        Point J1 = new Point(20 * mult, 17 * mult);
        Point J2 = new Point(28 * mult, 17 * mult);

        // street 3
        Point K1 = new Point(17 * mult, 28 * mult);
        Point K2 = new Point(17 * mult, 20 * mult);
        Point L1 = new Point(16 * mult, 28 * mult);
        Point L2 = new Point(16 * mult, 20 * mult);
        Point M1 = new Point(15 * mult, 28 * mult);
        Point M2 = new Point(15 * mult, 20 * mult);

        Point N1 = new Point(12 * mult, 20 * mult);
        Point N2 = new Point(12 * mult, 28 * mult);
        Point O1 = new Point(11 * mult, 20 * mult);
        Point O2 = new Point(11 * mult, 28 * mult);

        // street 4
        Point P1 = new Point(0 * mult, 17 * mult);
        Point P2 = new Point(8 * mult, 17 * mult);
        Point Q1 = new Point(0 * mult, 16 * mult);
        Point Q2 = new Point(8 * mult, 16 * mult);
        Point R1 = new Point(0 * mult, 15 * mult);
        Point R2 = new Point(8 * mult, 15 * mult);

        Point S1 = new Point(8 * mult, 12 * mult);
        Point S2 = new Point(0 * mult, 12 * mult);
        Point T1 = new Point(8 * mult, 11 * mult);
        Point T2 = new Point(0 * mult, 11 * mult);

        Point CI1P = new Point(13 * mult, 12 * mult);
        Point CI2P = new Point(15 * mult, 15 * mult);

        Point HN1P = new Point(16 * mult, 13 * mult);
        Point HN2P = new Point(13 * mult, 15 * mult);

        Point MS1P = new Point(15 * mult, 16 * mult);
        Point MS2P = new Point(13 * mult, 13 * mult);

        Point RD1P = new Point(12 * mult, 15 * mult);
        Point RD2P = new Point(15 * mult, 13 * mult);



        //dodawanie punktow do modelu (na ich podstawie bedzie mozna robic ulice
        Model.getInstance().setPoints(Arrays.asList(A1, A2, B1, B2, C1, C2, D1, D2, E1, E2, F1, F2, G1, G2, H1, H2,
                J1, J2, K1, K2, L1, L2, M1, M2, N1, N2, O1, O2, P1, P2, Q1, Q2, R1, R2, S1, S2, T1, T2,
                CI1P, CI2P, HN1P, HN2P, MS1P, MS2P, RD1P, RD2P));

        Street A = new Street(A1, A2);
        Street B = new Street(B1, B2);
        Street C = new Street(C1, C2);
        Street D = new Street(D1, D2);
        Street E = new Street(E1, E2);

        Street F = new Street(F1, F2);
        Street G = new Street(G1, G2);
        Street H = new Street(H1, H2);
        Street I = new Street(I1, I2);
        Street J = new Street(J1, J2);

        Street K = new Street(K1, K2);
        Street L = new Street(L1, L2);
        Street M = new Street(M1, M2);
        Street N = new Street(N1, N2);
        Street O = new Street(O1, O2);

        Street P = new Street(P1, P2);
        Street Q = new Street(Q1, Q2);
        Street R = new Street(R1, R2);
        Street S = new Street(S1, S2);
        Street T = new Street(T1, T2);


        // crossing
        Street AO = new Street(A2, O1);
        Street AT = new Street(A2, T1);
        Street BN = new Street(B2, N1);

        //CI
        Street CI = new Street(C2, CI1P);
        Street CI1 = new Street(CI1P, CI2P);
        Street CI2 = new Street(CI2P, I1);


        Street FE = new Street(F2, E1);
        Street FT = new Street(F2, T1);
        Street GS = new Street(G2, S1);

        //HN
        Street HN = new Street(H2, HN1P);
        Street HN1 = new Street(HN1P, HN2P);
        Street HN2 = new Street(HN2P, N1);


        Street KJ = new Street(K2, J1);
        Street KE = new Street(K2, E1);
        Street LD = new Street(L2, D1);

        //MS
        Street MS = new Street(M2, MS1P);
        Street MS1 = new Street(MS1P, MS2P);
        Street MS2 = new Street(MS2P, S1);


        Street PO = new Street(P2, O1);
        Street PJ = new Street(P2, J1);
        Street QI = new Street(Q2, I1);

        //RD
        Street RD = new Street(R2, RD1P);
        Street RD1 = new Street(RD1P, RD2P);
        Street RD2 = new Street(RD2P, D1);



        A.setRight(AT);
        A.setStraight(AO);
        B.setStraight(BN);
        C.setLeft(CI);

        F.setRight(FE);
        F.setStraight(FT);
        G.setStraight(GS);
        H.setLeft(HN);

        K.setStraight(KJ);
        K.setRight(KE);
        L.setStraight(LD);
        M.setLeft(MS);

        P.setRight(PO);
        P.setStraight(PJ);
        Q.setStraight(QI);
        R.setLeft(RD);


        AO.setStraight(O);
        AT.setStraight(T);
        BN.setStraight(N);
        CI.setStraight(CI1);
        CI1.setStraight(CI2);
        CI2.setStraight(I);

        FE.setStraight(E);
        FT.setStraight(T);
        GS.setStraight(S);
        HN.setStraight(HN1);
        HN1.setStraight(HN2);
        HN2.setStraight(N);

        KJ.setStraight(J);
        KE.setStraight(E);
        LD.setStraight(D);
        MS.setStraight(MS1);
        MS1.setStraight(MS2);
        MS2.setStraight(S);


        PO.setStraight(O);
        PJ.setStraight(J);
        QI.setStraight(I);
        RD.setStraight(RD1);
        RD1.setStraight(RD2);
        RD2.setStraight(D);



        //dodawanie ulic do modelu
        Model.getInstance().getStreets().addAll(Arrays.asList(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, AO, AT, BN, CI, FE, FT, GS, HN, KJ, KE, LD, MS, PO, PJ, QI, RD,
                CI1, CI2, HN1, HN2, MS1, MS2, RD1, RD2));
        //dodawanie punktow pojawiania sie ulic
        Model.getInstance().addSpawningPlace(new SpawningPlace(A1, A, 20));
        Model.getInstance().addSpawningPlace(new SpawningPlace(B1, B, 20));
        Model.getInstance().addSpawningPlace(new SpawningPlace(C1, C, 40));

        Model.getInstance().addSpawningPlace(new SpawningPlace(F1, F, 30));
        Model.getInstance().addSpawningPlace(new SpawningPlace(G1, G, 20));
        Model.getInstance().addSpawningPlace(new SpawningPlace(H1, H, 60));

        Model.getInstance().addSpawningPlace(new SpawningPlace(K1, K, 15));
        Model.getInstance().addSpawningPlace(new SpawningPlace(L1, L, 20));
        Model.getInstance().addSpawningPlace(new SpawningPlace(M1, M, 20));

        Model.getInstance().addSpawningPlace(new SpawningPlace(P1, P, 50));
        Model.getInstance().addSpawningPlace(new SpawningPlace(Q1, Q, 20));
        Model.getInstance().addSpawningPlace(new SpawningPlace(R1, R, 10));

        Light lightA = new Light();
        lightA.setCenterX(A2.getX());
        lightA.setCenterY(A2.getY());

        Light lightB = new Light();
        lightB.setCenterX(B2.getX());
        lightB.setCenterY(B2.getY());

        Light lightC = new Light();
        lightC.setCenterX(C2.getX());
        lightC.setCenterY(C2.getY());

        Light lightF = new Light();
        lightF.setCenterX(F2.getX());
        lightF.setCenterY(F2.getY());

        Light lightG = new Light();
        lightG.setCenterX(G2.getX());
        lightG.setCenterY(G2.getY());

        Light lightH = new Light();
        lightH.setCenterX(H2.getX());
        lightH.setCenterY(H2.getY());

        Light lightM = new Light();
        lightM.setCenterX(M2.getX());
        lightM.setCenterY(M2.getY());

        Light lightL = new Light();
        lightL.setCenterX(L2.getX());
        lightL.setCenterY(L2.getY());

        Light lightK = new Light();
        lightK.setCenterX(K2.getX());
        lightK.setCenterY(K2.getY());

        Light lightP = new Light();
        lightP.setCenterX(P2.getX());
        lightP.setCenterY(P2.getY());

        Light lightQ = new Light();
        lightQ.setCenterX(Q2.getX());
        lightQ.setCenterY(Q2.getY());

        Light lightR = new Light();
        lightR.setCenterX(R2.getX());
        lightR.setCenterY(R2.getY());


        //dodawanie sygnalizacji swietlnej
        Model.getInstance().getLights().addAll(Arrays.asList(lightA,lightB,lightC,lightF,lightG,lightH,lightK,lightL,lightM,lightP,lightQ,lightR));

    }

}
