package com.mpdgr.sudokusolver.controller.Mapper;

import com.mpdgr.sudokusolver.controller.SudokuInput;
import com.mpdgr.sudokusolver.data.SudokuEntity;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {
    public SudokuInput entityToInput (SudokuEntity entity){
        SudokuInput input = new SudokuInput();

        input.setV11(entity.getV11().equals("0") ? "" : entity.getV11());
        input.setV21(entity.getV21().equals("0") ? "" : entity.getV21());
        input.setV31(entity.getV31().equals("0") ? "" : entity.getV31());
        input.setV41(entity.getV41().equals("0") ? "" : entity.getV41());
        input.setV51(entity.getV51().equals("0") ? "" : entity.getV51());
        input.setV61(entity.getV61().equals("0") ? "" : entity.getV61());
        input.setV71(entity.getV71().equals("0") ? "" : entity.getV71());
        input.setV81(entity.getV81().equals("0") ? "" : entity.getV81());
        input.setV91(entity.getV91().equals("0") ? "" : entity.getV91());

        input.setV12(entity.getV12().equals("0") ? "" : entity.getV12());
        input.setV22(entity.getV22().equals("0") ? "" : entity.getV22());
        input.setV32(entity.getV32().equals("0") ? "" : entity.getV32());
        input.setV42(entity.getV42().equals("0") ? "" : entity.getV42());
        input.setV52(entity.getV52().equals("0") ? "" : entity.getV52());
        input.setV62(entity.getV62().equals("0") ? "" : entity.getV62());
        input.setV72(entity.getV72().equals("0") ? "" : entity.getV72());
        input.setV82(entity.getV82().equals("0") ? "" : entity.getV82());
        input.setV92(entity.getV92().equals("0") ? "" : entity.getV92());

        input.setV13(entity.getV13().equals("0") ? "" : entity.getV13());
        input.setV23(entity.getV23().equals("0") ? "" : entity.getV23());
        input.setV33(entity.getV33().equals("0") ? "" : entity.getV33());
        input.setV43(entity.getV43().equals("0") ? "" : entity.getV43());
        input.setV53(entity.getV53().equals("0") ? "" : entity.getV53());
        input.setV63(entity.getV63().equals("0") ? "" : entity.getV63());
        input.setV73(entity.getV73().equals("0") ? "" : entity.getV73());
        input.setV83(entity.getV83().equals("0") ? "" : entity.getV83());
        input.setV93(entity.getV93().equals("0") ? "" : entity.getV93());

        input.setV14(entity.getV14().equals("0") ? "" : entity.getV14());
        input.setV24(entity.getV24().equals("0") ? "" : entity.getV24());
        input.setV34(entity.getV34().equals("0") ? "" : entity.getV34());
        input.setV44(entity.getV44().equals("0") ? "" : entity.getV44());
        input.setV54(entity.getV54().equals("0") ? "" : entity.getV54());
        input.setV64(entity.getV64().equals("0") ? "" : entity.getV64());
        input.setV74(entity.getV74().equals("0") ? "" : entity.getV74());
        input.setV84(entity.getV84().equals("0") ? "" : entity.getV84());
        input.setV94(entity.getV94().equals("0") ? "" : entity.getV94());

        input.setV15(entity.getV15().equals("0") ? "" : entity.getV15());
        input.setV25(entity.getV25().equals("0") ? "" : entity.getV25());
        input.setV35(entity.getV35().equals("0") ? "" : entity.getV35());
        input.setV45(entity.getV45().equals("0") ? "" : entity.getV45());
        input.setV55(entity.getV55().equals("0") ? "" : entity.getV55());
        input.setV65(entity.getV65().equals("0") ? "" : entity.getV65());
        input.setV75(entity.getV75().equals("0") ? "" : entity.getV75());
        input.setV85(entity.getV85().equals("0") ? "" : entity.getV85());
        input.setV95(entity.getV95().equals("0") ? "" : entity.getV95());

        input.setV16(entity.getV16().equals("0") ? "" : entity.getV16());
        input.setV26(entity.getV26().equals("0") ? "" : entity.getV26());
        input.setV36(entity.getV36().equals("0") ? "" : entity.getV36());
        input.setV46(entity.getV46().equals("0") ? "" : entity.getV46());
        input.setV56(entity.getV56().equals("0") ? "" : entity.getV56());
        input.setV66(entity.getV66().equals("0") ? "" : entity.getV66());
        input.setV76(entity.getV76().equals("0") ? "" : entity.getV76());
        input.setV86(entity.getV86().equals("0") ? "" : entity.getV86());
        input.setV96(entity.getV96().equals("0") ? "" : entity.getV96());

        input.setV17(entity.getV17().equals("0") ? "" : entity.getV17());
        input.setV27(entity.getV27().equals("0") ? "" : entity.getV27());
        input.setV37(entity.getV37().equals("0") ? "" : entity.getV37());
        input.setV47(entity.getV47().equals("0") ? "" : entity.getV47());
        input.setV57(entity.getV57().equals("0") ? "" : entity.getV57());
        input.setV67(entity.getV67().equals("0") ? "" : entity.getV67());
        input.setV77(entity.getV77().equals("0") ? "" : entity.getV77());
        input.setV87(entity.getV87().equals("0") ? "" : entity.getV87());
        input.setV97(entity.getV97().equals("0") ? "" : entity.getV97());

        input.setV18(entity.getV18().equals("0") ? "" : entity.getV18());
        input.setV28(entity.getV28().equals("0") ? "" : entity.getV28());
        input.setV38(entity.getV38().equals("0") ? "" : entity.getV38());
        input.setV48(entity.getV48().equals("0") ? "" : entity.getV48());
        input.setV58(entity.getV58().equals("0") ? "" : entity.getV58());
        input.setV68(entity.getV68().equals("0") ? "" : entity.getV68());
        input.setV78(entity.getV78().equals("0") ? "" : entity.getV78());
        input.setV88(entity.getV88().equals("0") ? "" : entity.getV88());
        input.setV98(entity.getV98().equals("0") ? "" : entity.getV98());

        input.setV19(entity.getV19().equals("0") ? "" : entity.getV19());
        input.setV29(entity.getV29().equals("0") ? "" : entity.getV29());
        input.setV39(entity.getV39().equals("0") ? "" : entity.getV39());
        input.setV49(entity.getV49().equals("0") ? "" : entity.getV49());
        input.setV59(entity.getV59().equals("0") ? "" : entity.getV59());
        input.setV69(entity.getV69().equals("0") ? "" : entity.getV69());
        input.setV79(entity.getV79().equals("0") ? "" : entity.getV79());
        input.setV89(entity.getV89().equals("0") ? "" : entity.getV89());
        input.setV99(entity.getV99().equals("0") ? "" : entity.getV99());

        return input;
    }
}
