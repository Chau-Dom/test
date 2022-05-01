package demau.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import exception.InvalidDOBException;
import exception.InvalidFullNameException;
import exception.InvalidPhoneNumberException;

public class JDBCStatement {
	public static void addGStudent()
			throws ParseException, InvalidPhoneNumberException, InvalidFullNameException, InvalidDOBException {
		List<GoodStudent> gsRead = Main.showGStudent();
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into Student(id,fullname,doB,sex,phoneNumber,university,gradeLevel,gpa,bestRewardName) values (?,?,?,?,?,?,?,?,?)";
		try {
			for (GoodStudent gs : gsRead) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, gs.getID());
				pstmt.setString(2, gs.getFullName());
				pstmt.setDate(3, ConvertDate.convertUtilToSqlDate(gs.getDoB()));
				pstmt.setString(4, gs.getSex());
				pstmt.setString(5, gs.getPhoneNumber());
				pstmt.setString(6, gs.getUniversityName());
				pstmt.setString(7, gs.getGradeLevel());
				pstmt.setDouble(8, gs.getGpa());
				pstmt.setString(9, gs.getBestRewardName());
				pstmt.executeUpdate();

				System.out.println();
				System.out.println("Thêm sv thành công!");
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Thêm sv không thành công!");
			e.printStackTrace();
		} finally {
			JDBCConnection.closeConn(null, pstmt, conn);
		}
	}

	public static void showGStudent() throws InvalidPhoneNumberException {
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GoodStudent> listGS = new ArrayList<GoodStudent>();

		String sql = "select * from Student where id like 'P%'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.println("-----------------------");
			while (rs.next()) {
				GoodStudent gs = new GoodStudent();
				gs.setID(rs.getString(1));
				gs.setFullName(rs.getString(2));
				gs.setDoB(ConvertDate.convertSqlToUtilDate(rs.getDate(3)));
				gs.setSex(rs.getString(4));
				gs.setPhoneNumber(rs.getString(5));
				gs.setUniversityName(rs.getString(6));
				gs.setGradeLevel(rs.getString(7));
				gs.setGpa(rs.getDouble(8));
				gs.setBestRewardName(rs.getString(9));

				listGS.add(gs);
			}
			if (listGS.isEmpty()) {
				System.out.println("Không có sv nào!");
			} else {
				System.out.println("------------");
				System.out.println("Thông tin sv: ");
				for (GoodStudent gs : listGS) {
					System.out.println(gs.toString());
				}
			}
		} catch (SQLException e) {
			System.out.println("Chương trình bị lỗi do: " + e.getMessage());
		} finally {
			JDBCConnection.closeConn(rs, pstmt, conn);
		}
	}

	public static void addNStudent() throws ParseException {
		List<NormalStudent> nsRead = Main.showNStudent();
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into Student(id,fullname,doB,sex,phoneNumber,universityName,gradeLevel,englishScore,entryTestScore) values (?,?,?,?,?,?,?,?,?)";
		try {
			for (NormalStudent ns : nsRead) {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ns.getID());
				pstmt.setString(2, ns.getFullName());
				pstmt.setDate(3, ConvertDate.convertUtilToSqlDate(ns.getDoB()));
				pstmt.setString(4, ns.getSex());
				pstmt.setString(5, ns.getPhoneNumber());
				pstmt.setString(6, ns.getUniversityName());
				pstmt.setString(7, ns.getGradeLevel());
				pstmt.setDouble(8, ns.getEnglishScore());
				pstmt.setDouble(9, ns.getEntryTestScore());
				pstmt.executeUpdate();

				System.out.println();
				System.out.println("Thêm sv thành công!");
				System.out.println();
			}
		} catch (SQLException e) {
			System.out.println("Thêm sv không thành công!");
			e.printStackTrace();
		} finally {
			JDBCConnection.closeConn(null, pstmt, conn);
		}
	}

	public static void showAll() {
		Connection conn = JDBCConnection.getConnection();
		List<AllStudents> listAll = new ArrayList<AllStudents>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from Student";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			System.out.println("---------------");
			while (rs.next()) {
				AllStudents std = new AllStudents();
				std.setId(rs.getString(1));
				std.setFullName(rs.getString(2));
				std.setDoB(ConvertDate.convertSqlToUtilDate(rs.getDate(3)));
				std.setSex(rs.getString(4));
				std.setPhoneNumber(rs.getString(5));
				std.setUniversityName(rs.getString(6));
				std.setGradeLevel(rs.getString(7));
				listAll.add(std);
			}
			if (listAll.isEmpty()) {
				System.out.println("Không có sinh viên nào");
			} else {
				System.out.println("Thông tin sv: ");
				Collections.sort(listAll, new Comparator<AllStudents>() {

					@Override
					public int compare(AllStudents o1, AllStudents o2) {
						int rs;
						rs = o2.getFullName().compareTo(o1.getFullName());
						if (rs == 0) {
							return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
						} else {
							return rs;
						}
//						return Integer.parseInt(o1.getID()-o2.getID()); kiểu số khác int
					}
				});
				for (AllStudents std : listAll) {
					System.out.println(std.toString());
				}
			}
		} catch (SQLException e) {
			System.out.println("ct lỗi do: " + e.getMessage());
		} finally {
			JDBCConnection.closeConn(rs, pstmt, conn);
		}
	}

	public static void showTopStd() {
		Scanner sc = new Scanner(System.in);
		Connection conn = JDBCConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<AllStudents> listAll = new ArrayList<AllStudents>();

		String sql = "select * from Student";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("---------------");
			while (rs.next()) {
				AllStudents std = new AllStudents();
				std.setId(rs.getString(1));
				std.setFullName(rs.getString(2));
				std.setDoB(ConvertDate.convertSqlToUtilDate(rs.getDate(3)));
				std.setSex(rs.getString(4));
				std.setPhoneNumber(rs.getString(5));
				std.setUniversityName(rs.getString(6));
				std.setGradeLevel(rs.getString(7));
				std.setGpa(rs.getDouble(8));
				std.setBestRewardName(rs.getString(9));
				std.setEnglishScore(rs.getDouble(10));
				std.setEntryTestScore(rs.getDouble(11));
				listAll.add(std);
			}
			if (listAll.isEmpty()) {
				System.out.println("Không có sv nào!");
			} else {
				Collections.sort(listAll, new Comparator<AllStudents>() {

					@Override
					public int compare(AllStudents o1, AllStudents o2) {
						int rs;
						rs = o1.getGradeLevel().compareTo(o2.getGradeLevel());
						if (rs == 0) {
							rs = (int) (o1.getGpa() - o2.getGpa());
							if (rs == 0) {
								return rs = o1.getFullName().compareTo(o2.getFullName());
							} else {
								return rs;
							}
						} else {
							rs = (int) (o1.getEntryTestScore() - o2.getEntryTestScore());
							if (rs == 0) {
								rs = (int) (o1.getEnglishScore() - o2.getEnglishScore());
								if (rs == 0) {
									rs = o1.getFullName().compareTo(o2.getFullName());
								}
							}
							return rs;
						}
					}
				});
				System.out.print("Nhập vào số lượng: ");
				int n = Integer.parseInt(sc.nextLine());
				int i;

				for (i = 0; i <= listAll.size(); i++) {
					if (i < n) {
						System.out.println(listAll.get(i).toString());
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Không có dữ liệu!");
		} finally {
			JDBCConnection.closeConn(rs, pstmt, conn);
		}
	}

}
