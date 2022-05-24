package com.pdgr.SudokuSolver;

import java.sql.*;

public class SqlExport {

    public static void exportToMySql(SudokuInputModel input) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sudoku_db", "springclient", "SpringPass01&#")) {
            String sqlStatement =
                    "insert into SUDOKU_ARCHIVE (v11,v21,v31,v41,v51,v61,v71,v81,v91,v12,v22,v32,v42,v52,v62,v72,v82,v92,v13,v23,v33,v43,v53,v63,v73,v83,v93,v14,v24,v34,v44,v54,v64,v74,v84,v94,v15,v25,v35,v45,v55,v65,v75,v85,v95,v16,v26,v36,v46,v56,v66,v76,v86,v96,v17,v27,v37,v47,v57,v67,v77,v87,v97,v18,v28,v38,v48,v58,v68,v78,v88,v98,v19,v29,v39,v49,v59,v69,v79,v89,v99) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement)) {
                preparedStatement.setString(1 , input.getV11());
                preparedStatement.setString(2 , input.getV21());
                preparedStatement.setString(3 , input.getV31());
                preparedStatement.setString(4 , input.getV41());
                preparedStatement.setString(5 , input.getV51());
                preparedStatement.setString(6 , input.getV61());
                preparedStatement.setString(7 , input.getV71());
                preparedStatement.setString(8 , input.getV81());
                preparedStatement.setString(9 , input.getV91());
                preparedStatement.setString(10, input.getV12());
                preparedStatement.setString(11, input.getV22());
                preparedStatement.setString(12, input.getV32());
                preparedStatement.setString(13, input.getV42());
                preparedStatement.setString(14, input.getV52());
                preparedStatement.setString(15, input.getV62());
                preparedStatement.setString(16, input.getV72());
                preparedStatement.setString(17, input.getV82());
                preparedStatement.setString(18, input.getV92());
                preparedStatement.setString(19, input.getV13());
                preparedStatement.setString(20, input.getV23());
                preparedStatement.setString(21, input.getV33());
                preparedStatement.setString(22, input.getV43());
                preparedStatement.setString(23, input.getV53());
                preparedStatement.setString(24, input.getV63());
                preparedStatement.setString(25, input.getV73());
                preparedStatement.setString(26, input.getV83());
                preparedStatement.setString(27, input.getV93());
                preparedStatement.setString(28, input.getV14());
                preparedStatement.setString(29, input.getV24());
                preparedStatement.setString(30, input.getV34());
                preparedStatement.setString(31, input.getV44());
                preparedStatement.setString(32, input.getV54());
                preparedStatement.setString(33, input.getV64());
                preparedStatement.setString(34, input.getV74());
                preparedStatement.setString(35, input.getV84());
                preparedStatement.setString(36, input.getV94());
                preparedStatement.setString(37, input.getV15());
                preparedStatement.setString(38, input.getV25());
                preparedStatement.setString(39, input.getV35());
                preparedStatement.setString(40, input.getV45());
                preparedStatement.setString(41, input.getV55());
                preparedStatement.setString(42, input.getV65());
                preparedStatement.setString(43, input.getV75());
                preparedStatement.setString(44, input.getV85());
                preparedStatement.setString(45, input.getV95());
                preparedStatement.setString(46, input.getV16());
                preparedStatement.setString(47, input.getV26());
                preparedStatement.setString(48, input.getV36());
                preparedStatement.setString(49, input.getV46());
                preparedStatement.setString(50, input.getV56());
                preparedStatement.setString(51, input.getV66());
                preparedStatement.setString(52, input.getV76());
                preparedStatement.setString(53, input.getV86());
                preparedStatement.setString(54, input.getV96());
                preparedStatement.setString(55, input.getV17());
                preparedStatement.setString(56, input.getV27());
                preparedStatement.setString(57, input.getV37());
                preparedStatement.setString(58, input.getV47());
                preparedStatement.setString(59, input.getV57());
                preparedStatement.setString(60, input.getV67());
                preparedStatement.setString(61, input.getV77());
                preparedStatement.setString(62, input.getV87());
                preparedStatement.setString(63, input.getV97());
                preparedStatement.setString(64, input.getV18());
                preparedStatement.setString(65, input.getV28());
                preparedStatement.setString(66, input.getV38());
                preparedStatement.setString(67, input.getV48());
                preparedStatement.setString(68, input.getV58());
                preparedStatement.setString(69, input.getV68());
                preparedStatement.setString(70, input.getV78());
                preparedStatement.setString(71, input.getV88());
                preparedStatement.setString(72, input.getV98());
                preparedStatement.setString(73, input.getV19());
                preparedStatement.setString(74, input.getV29());
                preparedStatement.setString(75, input.getV39());
                preparedStatement.setString(76, input.getV49());
                preparedStatement.setString(77, input.getV59());
                preparedStatement.setString(78, input.getV69());
                preparedStatement.setString(79, input.getV79());
                preparedStatement.setString(80, input.getV89());
                preparedStatement.setString(81, input.getV99());
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Invalid SQL statement/ " + e);
            }
        } catch (SQLException e) {
            System.out.println("Server unavailable/ " + e);
        }
    }
}






