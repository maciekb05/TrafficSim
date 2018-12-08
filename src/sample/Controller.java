package sample;

import javafx.scene.layout.Pane;
import jdk.nashorn.api.tree.SimpleTreeVisitorES5_1;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;

public class Controller {

    private Pane root;

    Controller(Pane root) {
        this.root = root;
    }

    void initializeModel() {
        int mult = 25;
        // street 1
        Point A1 = new Point(11, 0);
        Point A2 = new Point(11, 8);
        Point B1 = new Point(12, 0);
        Point B2 = new Point(12, 8);
        Point C1 = new Point(13, 0);
        Point C2 = new Point(13, 8);

        Point D1 = new Point(16, 8);
        Point D2 = new Point(16, 0);
        Point E1 = new Point(17, 8);
        Point E2 = new Point(17, 0);

        // street 2
        Point F1 = new Point(28, 11);
        Point F2 = new Point(20, 11);
        Point G1 = new Point(28, 12);
        Point G2 = new Point(20, 12);
        Point H1 = new Point(28, 13);
        Point H2 = new Point(20, 13);

        Point I1 = new Point(20, 16);
        Point I2 = new Point(28, 16);
        Point J1 = new Point(20, 17);
        Point J2 = new Point(28, 17);

        // street 3
        Point K1 = new Point(17, 28);
        Point K2 = new Point(17, 20);
        Point L1 = new Point(16, 28);
        Point L2 = new Point(16, 20);
        Point M1 = new Point(15, 28);
        Point M2 = new Point(15, 20);

        Point N1 = new Point(12, 20);
        Point N2 = new Point(12, 28);
        Point O1 = new Point(11, 20);
        Point O2 = new Point(11, 28);

        // street 4
        Point P1 = new Point(0, 17);
        Point P2 = new Point(8, 17);
        Point Q1 = new Point(0, 16);
        Point Q2 = new Point(8, 16);
        Point R1 = new Point(0, 15);
        Point R2 = new Point(8, 15);

        Point S1 = new Point(8, 12);
        Point S2 = new Point(0, 12);
        Point T1 = new Point(8, 11);
        Point T2 = new Point(0, 11);


        Model.getInstance().setPoints(Arrays.asList(A1,A2,B1,B2,C1,C2,D1,D2,E1,E2,F1,F2,G1,G2,H1,H2,
                J1,J2,K1,K2,L1,L2,M1,M2,N1,N2,O1,O2,P1,P2,Q1,Q2,R1,R2,S1,S2,T1,T2));

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
        Street AO = new Street(A2,O1);
        Street AT = new Street(A2,T1);
        Street BN = new Street(B2,N1);
        Street CI = new Street(C2,I1);

        Street FE = new Street(F2,E1);
        Street FT = new Street(F2,T1);
        Street GS = new Street(G2, S1);
        Street HN = new Street(H2,N1);

        Street KJ = new Street(K2,J1);
        Street KE = new Street(K2,E1);
        Street LD = new Street(L2,D1);
        Street MS = new Street(M2,S1);

        Street PO = new Street(P2,O1);
        Street PJ = new Street(P2,J1);
        Street QI = new Street(Q2,I1);
        Street RD = new Street(R2,D1);


        A.setRight(AT);
        A.setStraight(AO);
        B.setStraight(BN);
        C.setLeft(CI);

        F.setRight(FE);
        F.setStraight(FT);
        G.setStraight(GS);
        H.setLeft(HN);

        K.setStraight(KJ);
        K.setStraight(KE);
        L.setStraight(LD);
        M.setLeft(MS);

        P.setRight(PO);
        P.setStraight(PJ);
        Q.setStraight(QI);
        R.setLeft(RD);



        Model.getInstance().getStreets().addAll(Arrays.asList(
                A,
                B,
                C,
                D,
                E,
                F,
                G,
                H,
                I,
                J,
                K,
                L,
                M,
                N,
                O,
                P,
                Q,
                R,
                S,
                T,
                AO,
                AT,
                BN,
                CI,
                FE,
                FT,
                GS,
                HN,
                KJ,
                KE,
                LD,
                MS,
                PO,
                PJ,
                QI,
                RD)
        );

//        Model.getInstance().addSpawningPlace(new SpawningPlace(M, alejaNorthToCzarnowiejska, 60));
//        Model.getInstance().addSpawningPlace(new SpawningPlace(G, rynekWest, 20));
//        Model.getInstance().addSpawningPlace(new SpawningPlace(A, alejaSouthToCzarnowiejska, 60));
//        Model.getInstance().addSpawningPlace(new SpawningPlace(H, czarnowiejskaEast, 40));

    }

    public Pane getRoot() {
        return root;
    }

    public void setRoot(Pane root) {
        this.root = root;
    }

}
