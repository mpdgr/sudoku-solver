package com.pdgr.SudokuSolver;

public class InitialCheck {

    public static boolean initialCheck(SudokuInputModel model) {

        Integer[][] newSudoku = new Integer[9][9];

        try{
        String v11 = model.getV11(); Integer intv11; if (v11.equals("")){intv11 = 0;} else {intv11 = Integer.valueOf(v11);} newSudoku[0][0] = intv11;
        String v21 = model.getV21(); Integer intv21; if (v21.equals("")){intv21 = 0;} else {intv21 = Integer.valueOf(v21);} newSudoku[0][1] = intv21;
        String v31 = model.getV31(); Integer intv31; if (v31.equals("")){intv31 = 0;} else {intv31 = Integer.valueOf(v31);} newSudoku[0][2] = intv31;
        String v41 = model.getV41(); Integer intv41; if (v41.equals("")){intv41 = 0;} else {intv41 = Integer.valueOf(v41);} newSudoku[0][3] = intv41;
        String v51 = model.getV51(); Integer intv51; if (v51.equals("")){intv51 = 0;} else {intv51 = Integer.valueOf(v51);} newSudoku[0][4] = intv51;
        String v61 = model.getV61(); Integer intv61; if (v61.equals("")){intv61 = 0;} else {intv61 = Integer.valueOf(v61);} newSudoku[0][5] = intv61;
        String v71 = model.getV71(); Integer intv71; if (v71.equals("")){intv71 = 0;} else {intv71 = Integer.valueOf(v71);} newSudoku[0][6] = intv71;
        String v81 = model.getV81(); Integer intv81; if (v81.equals("")){intv81 = 0;} else {intv81 = Integer.valueOf(v81);} newSudoku[0][7] = intv81;
        String v91 = model.getV91(); Integer intv91; if (v91.equals("")){intv91 = 0;} else {intv91 = Integer.valueOf(v91);} newSudoku[0][8] = intv91;

        String v12 = model.getV12(); Integer intv12; if (v12.equals("")){intv12 = 0;} else {intv12 = Integer.valueOf(v12);} newSudoku[1][0] = intv12;
        String v22 = model.getV22(); Integer intv22; if (v22.equals("")){intv22 = 0;} else {intv22 = Integer.valueOf(v22);} newSudoku[1][1] = intv22;
        String v32 = model.getV32(); Integer intv32; if (v32.equals("")){intv32 = 0;} else {intv32 = Integer.valueOf(v32);} newSudoku[1][2] = intv32;
        String v42 = model.getV42(); Integer intv42; if (v42.equals("")){intv42 = 0;} else {intv42 = Integer.valueOf(v42);} newSudoku[1][3] = intv42;
        String v52 = model.getV52(); Integer intv52; if (v52.equals("")){intv52 = 0;} else {intv52 = Integer.valueOf(v52);} newSudoku[1][4] = intv52;
        String v62 = model.getV62(); Integer intv62; if (v62.equals("")){intv62 = 0;} else {intv62 = Integer.valueOf(v62);} newSudoku[1][5] = intv62;
        String v72 = model.getV72(); Integer intv72; if (v72.equals("")){intv72 = 0;} else {intv72 = Integer.valueOf(v72);} newSudoku[1][6] = intv72;
        String v82 = model.getV82(); Integer intv82; if (v82.equals("")){intv82 = 0;} else {intv82 = Integer.valueOf(v82);} newSudoku[1][7] = intv82;
        String v92 = model.getV92(); Integer intv92; if (v92.equals("")){intv92 = 0;} else {intv92 = Integer.valueOf(v92);} newSudoku[1][8] = intv92;

        String v13 = model.getV13(); Integer intv13; if (v13.equals("")){intv13 = 0;} else {intv13 = Integer.valueOf(v13);} newSudoku[2][0] = intv13;
        String v23 = model.getV23(); Integer intv23; if (v23.equals("")){intv23 = 0;} else {intv23 = Integer.valueOf(v23);} newSudoku[2][1] = intv23;
        String v33 = model.getV33(); Integer intv33; if (v33.equals("")){intv33 = 0;} else {intv33 = Integer.valueOf(v33);} newSudoku[2][2] = intv33;
        String v43 = model.getV43(); Integer intv43; if (v43.equals("")){intv43 = 0;} else {intv43 = Integer.valueOf(v43);} newSudoku[2][3] = intv43;
        String v53 = model.getV53(); Integer intv53; if (v53.equals("")){intv53 = 0;} else {intv53 = Integer.valueOf(v53);} newSudoku[2][4] = intv53;
        String v63 = model.getV63(); Integer intv63; if (v63.equals("")){intv63 = 0;} else {intv63 = Integer.valueOf(v63);} newSudoku[2][5] = intv63;
        String v73 = model.getV73(); Integer intv73; if (v73.equals("")){intv73 = 0;} else {intv73 = Integer.valueOf(v73);} newSudoku[2][6] = intv73;
        String v83 = model.getV83(); Integer intv83; if (v83.equals("")){intv83 = 0;} else {intv83 = Integer.valueOf(v83);} newSudoku[2][7] = intv83;
        String v93 = model.getV93(); Integer intv93; if (v93.equals("")){intv93 = 0;} else {intv93 = Integer.valueOf(v93);} newSudoku[2][8] = intv93;

        String v14 = model.getV14(); Integer intv14; if (v14.equals("")){intv14 = 0;} else {intv14 = Integer.valueOf(v14);} newSudoku[3][0] = intv14;
        String v24 = model.getV24(); Integer intv24; if (v24.equals("")){intv24 = 0;} else {intv24 = Integer.valueOf(v24);} newSudoku[3][1] = intv24;
        String v34 = model.getV34(); Integer intv34; if (v34.equals("")){intv34 = 0;} else {intv34 = Integer.valueOf(v34);} newSudoku[3][2] = intv34;
        String v44 = model.getV44(); Integer intv44; if (v44.equals("")){intv44 = 0;} else {intv44 = Integer.valueOf(v44);} newSudoku[3][3] = intv44;
        String v54 = model.getV54(); Integer intv54; if (v54.equals("")){intv54 = 0;} else {intv54 = Integer.valueOf(v54);} newSudoku[3][4] = intv54;
        String v64 = model.getV64(); Integer intv64; if (v64.equals("")){intv64 = 0;} else {intv64 = Integer.valueOf(v64);} newSudoku[3][5] = intv64;
        String v74 = model.getV74(); Integer intv74; if (v74.equals("")){intv74 = 0;} else {intv74 = Integer.valueOf(v74);} newSudoku[3][6] = intv74;
        String v84 = model.getV84(); Integer intv84; if (v84.equals("")){intv84 = 0;} else {intv84 = Integer.valueOf(v84);} newSudoku[3][7] = intv84;
        String v94 = model.getV94(); Integer intv94; if (v94.equals("")){intv94 = 0;} else {intv94 = Integer.valueOf(v94);} newSudoku[3][8] = intv94;

        String v15 = model.getV15(); Integer intv15; if (v15.equals("")){intv15 = 0;} else {intv15 = Integer.valueOf(v15);} newSudoku[4][0] = intv15;
        String v25 = model.getV25(); Integer intv25; if (v25.equals("")){intv25 = 0;} else {intv25 = Integer.valueOf(v25);} newSudoku[4][1] = intv25;
        String v35 = model.getV35(); Integer intv35; if (v35.equals("")){intv35 = 0;} else {intv35 = Integer.valueOf(v35);} newSudoku[4][2] = intv35;
        String v45 = model.getV45(); Integer intv45; if (v45.equals("")){intv45 = 0;} else {intv45 = Integer.valueOf(v45);} newSudoku[4][3] = intv45;
        String v55 = model.getV55(); Integer intv55; if (v55.equals("")){intv55 = 0;} else {intv55 = Integer.valueOf(v55);} newSudoku[4][4] = intv55;
        String v65 = model.getV65(); Integer intv65; if (v65.equals("")){intv65 = 0;} else {intv65 = Integer.valueOf(v65);} newSudoku[4][5] = intv65;
        String v75 = model.getV75(); Integer intv75; if (v75.equals("")){intv75 = 0;} else {intv75 = Integer.valueOf(v75);} newSudoku[4][6] = intv75;
        String v85 = model.getV85(); Integer intv85; if (v85.equals("")){intv85 = 0;} else {intv85 = Integer.valueOf(v85);} newSudoku[4][7] = intv85;
        String v95 = model.getV95(); Integer intv95; if (v95.equals("")){intv95 = 0;} else {intv95 = Integer.valueOf(v95);} newSudoku[4][8] = intv95;

        String v16 = model.getV16(); Integer intv16; if (v16.equals("")){intv16 = 0;} else {intv16 = Integer.valueOf(v16);} newSudoku[5][0] = intv16;
        String v26 = model.getV26(); Integer intv26; if (v26.equals("")){intv26 = 0;} else {intv26 = Integer.valueOf(v26);} newSudoku[5][1] = intv26;
        String v36 = model.getV36(); Integer intv36; if (v36.equals("")){intv36 = 0;} else {intv36 = Integer.valueOf(v36);} newSudoku[5][2] = intv36;
        String v46 = model.getV46(); Integer intv46; if (v46.equals("")){intv46 = 0;} else {intv46 = Integer.valueOf(v46);} newSudoku[5][3] = intv46;
        String v56 = model.getV56(); Integer intv56; if (v56.equals("")){intv56 = 0;} else {intv56 = Integer.valueOf(v56);} newSudoku[5][4] = intv56;
        String v66 = model.getV66(); Integer intv66; if (v66.equals("")){intv66 = 0;} else {intv66 = Integer.valueOf(v66);} newSudoku[5][5] = intv66;
        String v76 = model.getV76(); Integer intv76; if (v76.equals("")){intv76 = 0;} else {intv76 = Integer.valueOf(v76);} newSudoku[5][6] = intv76;
        String v86 = model.getV86(); Integer intv86; if (v86.equals("")){intv86 = 0;} else {intv86 = Integer.valueOf(v86);} newSudoku[5][7] = intv86;
        String v96 = model.getV96(); Integer intv96; if (v96.equals("")){intv96 = 0;} else {intv96 = Integer.valueOf(v96);} newSudoku[5][8] = intv96;

        String v17 = model.getV17(); Integer intv17; if (v17.equals("")){intv17 = 0;} else {intv17 = Integer.valueOf(v17);} newSudoku[6][0] = intv17;
        String v27 = model.getV27(); Integer intv27; if (v27.equals("")){intv27 = 0;} else {intv27 = Integer.valueOf(v27);} newSudoku[6][1] = intv27;
        String v37 = model.getV37(); Integer intv37; if (v37.equals("")){intv37 = 0;} else {intv37 = Integer.valueOf(v37);} newSudoku[6][2] = intv37;
        String v47 = model.getV47(); Integer intv47; if (v47.equals("")){intv47 = 0;} else {intv47 = Integer.valueOf(v47);} newSudoku[6][3] = intv47;
        String v57 = model.getV57(); Integer intv57; if (v57.equals("")){intv57 = 0;} else {intv57 = Integer.valueOf(v57);} newSudoku[6][4] = intv57;
        String v67 = model.getV67(); Integer intv67; if (v67.equals("")){intv67 = 0;} else {intv67 = Integer.valueOf(v67);} newSudoku[6][5] = intv67;
        String v77 = model.getV77(); Integer intv77; if (v77.equals("")){intv77 = 0;} else {intv77 = Integer.valueOf(v77);} newSudoku[6][6] = intv77;
        String v87 = model.getV87(); Integer intv87; if (v87.equals("")){intv87 = 0;} else {intv87 = Integer.valueOf(v87);} newSudoku[6][7] = intv87;
        String v97 = model.getV97(); Integer intv97; if (v97.equals("")){intv97 = 0;} else {intv97 = Integer.valueOf(v97);} newSudoku[6][8] = intv97;

        String v18 = model.getV18(); Integer intv18; if (v18.equals("")){intv18 = 0;} else {intv18 = Integer.valueOf(v18);} newSudoku[7][0] = intv18;
        String v28 = model.getV28(); Integer intv28; if (v28.equals("")){intv28 = 0;} else {intv28 = Integer.valueOf(v28);} newSudoku[7][1] = intv28;
        String v38 = model.getV38(); Integer intv38; if (v38.equals("")){intv38 = 0;} else {intv38 = Integer.valueOf(v38);} newSudoku[7][2] = intv38;
        String v48 = model.getV48(); Integer intv48; if (v48.equals("")){intv48 = 0;} else {intv48 = Integer.valueOf(v48);} newSudoku[7][3] = intv48;
        String v58 = model.getV58(); Integer intv58; if (v58.equals("")){intv58 = 0;} else {intv58 = Integer.valueOf(v58);} newSudoku[7][4] = intv58;
        String v68 = model.getV68(); Integer intv68; if (v68.equals("")){intv68 = 0;} else {intv68 = Integer.valueOf(v68);} newSudoku[7][5] = intv68;
        String v78 = model.getV78(); Integer intv78; if (v78.equals("")){intv78 = 0;} else {intv78 = Integer.valueOf(v78);} newSudoku[7][6] = intv78;
        String v88 = model.getV88(); Integer intv88; if (v88.equals("")){intv88 = 0;} else {intv88 = Integer.valueOf(v88);} newSudoku[7][7] = intv88;
        String v98 = model.getV98(); Integer intv98; if (v98.equals("")){intv98 = 0;} else {intv98 = Integer.valueOf(v98);} newSudoku[7][8] = intv98;

        String v19 = model.getV19(); Integer intv19; if (v19.equals("")){intv19 = 0;} else {intv19 = Integer.valueOf(v19);} newSudoku[8][0] = intv19;
        String v29 = model.getV29(); Integer intv29; if (v29.equals("")){intv29 = 0;} else {intv29 = Integer.valueOf(v29);} newSudoku[8][1] = intv29;
        String v39 = model.getV39(); Integer intv39; if (v39.equals("")){intv39 = 0;} else {intv39 = Integer.valueOf(v39);} newSudoku[8][2] = intv39;
        String v49 = model.getV49(); Integer intv49; if (v49.equals("")){intv49 = 0;} else {intv49 = Integer.valueOf(v49);} newSudoku[8][3] = intv49;
        String v59 = model.getV59(); Integer intv59; if (v59.equals("")){intv59 = 0;} else {intv59 = Integer.valueOf(v59);} newSudoku[8][4] = intv59;
        String v69 = model.getV69(); Integer intv69; if (v69.equals("")){intv69 = 0;} else {intv69 = Integer.valueOf(v69);} newSudoku[8][5] = intv69;
        String v79 = model.getV79(); Integer intv79; if (v79.equals("")){intv79 = 0;} else {intv79 = Integer.valueOf(v79);} newSudoku[8][6] = intv79;
        String v89 = model.getV89(); Integer intv89; if (v89.equals("")){intv89 = 0;} else {intv89 = Integer.valueOf(v89);} newSudoku[8][7] = intv89;
        String v99 = model.getV99(); Integer intv99; if (v99.equals("")){intv99 = 0;} else {intv99 = Integer.valueOf(v99);} newSudoku[8][8] = intv99;}
        catch (NumberFormatException e){return false;};

        for (Integer[] input : newSudoku){
            for(Integer integer : input) {
                if (integer < 0 || integer > 9) {
                    return false;
                }
            }
        }
        int initialBoardCheck = BoardChecker.checkMatrix(newSudoku);
        return initialBoardCheck != 1;
    }
}
