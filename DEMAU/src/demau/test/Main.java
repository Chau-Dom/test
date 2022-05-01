package demau.test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import exception.InvalidDOBException;
import exception.InvalidFullNameException;
import exception.InvalidPhoneNumberException;

public class Main {

	public static void showMenu() {
		System.out.println("-----MENU-----");
		System.out.println("1.Ghi tt Good Student vào file csv!");
		System.out.println("2.Đọc tt Good Student từ file csv");
		System.out.println("3.Ghi tt Normal Student vào csv!");
		System.out.println("4.Đọc tt Normal Student từ file csv");
		System.out.println("5.Ghi tt Good Student vào database!");
		System.out.println("6.Đọc tt Good Student từ database!");
		System.out.println("7.Ghi tt Normal Student vào database!");
		System.out.println("8.Đọc tt All Student sắp xếp giảm theo tên và tăng theo Phone!");
		System.out.println("9.Lấy tt All Student theo số lượng yêu cầu!");
		System.out.println("0.Kết thúc chương trình!");
		System.out.println("--------------------------------------");
	}
// test edit
	public static void main(String[] args) throws ParseException, InvalidPhoneNumberException, InvalidFullNameException, InvalidDOBException {
		
		try {
			Scanner sc1 = new Scanner(System.in);
			int opt = -1;

			showMenu();

			do {

				try {
					System.out.print("Nhập vào lựa chọn của bạn: ");
					opt = Integer.parseInt(sc1.nextLine());

					switch (opt) {
					case 1:
						addGStudent();
						break;
					case 2:
						List<GoodStudent> gsRead = showGStudent();
						for (GoodStudent gs : gsRead) {
							System.out.println(gs.toString());
						}
						break;
					case 3:
						addNStudent();
						break;
					case 4:
						List<NormalStudent> nsRead = showNStudent();
						for (NormalStudent ns : nsRead) {
							System.out.println(ns.toString());
						}
						break;
					case 5:
						JDBCStatement.addGStudent();
						break;
					case 6:
						JDBCStatement.showGStudent();
						break;
					case 7:
						JDBCStatement.addNStudent();
						break;
					case 8:
						JDBCStatement.showAll();
						break;
					case 9:
						JDBCStatement.showTopStd();
						break;
					case 0:
						System.out.println("Chương trình kết thúc!");
						break;
					default:
						System.out.println("Không có giá trị này!");
						break;
					}
				} catch (NumberFormatException n) {
					System.out.println();
					System.out.println("Vui lòng nhập vào 1 số!");
					System.out.println();
				}

			} while (opt != 0);

			sc1.close();
		} catch (Exception e) {
			System.out.println("Input files have unknow errors !!!");
		}

	}

	public static void addGStudent() throws ParseException {
		List<GoodStudent> listGS = new ArrayList<GoodStudent>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false); // 31/2 sẽ bắt lỗi, nếu true thì 31/2 sẽ thành 3/3

		listGS.add(new GoodStudent("P1", "Nguyen Van A1", sdf.parse("21/12/1990"), "Nam", "0914002343", "BKDN", "Kha",
				7.0, "Microsoft"));
		listGS.add(new GoodStudent("P2", "Nguyen Van A2", sdf.parse("21/12/1990"), "Nu", "0913123456", "BKDN", "Kha",
				8.0, "Microsoft"));
		listGS.add(new GoodStudent("P3", "Nguyen Van A3", sdf.parse("21/12/1990"), "Nam", "0916789456", "BKDN", "Kha",
				7.0, "Microsoft"));
		listGS.add(new GoodStudent("P4", "Nguyen Van A4", sdf.parse("21/12/1990"), "Nu", "0915456321", "BKDN", "Kha",
				9.0, "Microsoft"));
		listGS.add(new GoodStudent("P5", "Nguyen Van A5", sdf.parse("21/12/1990"), "Nam", "0917464313", "BKDN", "Kha",
				6.0, "Microsoft"));
		listGS.add(new GoodStudent("P6", "Nguyen Van A6", sdf.parse("21/12/1990"), "Nam", "0917464313", "BKDN", "Kha",
				7.0, "Microsoft"));
//		listGS.add(new GoodStudent("P6", "Nguyen Van A6", sdf.parse("21/12/1990"), "Nam", "0907464313", "BKDN", "Kha",7.0, "Microsoft"));
//		listGS.add(new GoodStudent("P7", "Nguyen Van A7", sdf.parse("21/12/1990"), "Nam", "0907464313", "BKDN", "Kha",7.0, "Microsoft"));
//		listGS.add(new GoodStudent("P7", "Nguyen Van A7", sdf.parse("22-25--990"), "Nam", "0907464313", "BKDN", "Kha",7.0, "Microsoft"));
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("goodStudent.txt"))) {
			for (GoodStudent gs : listGS) {
				writer.append(gs.convertString());
				writer.println();
			}
			System.out.println("Ghi thành công!");
		} catch (IOException e) {
			System.out.println("ct lỗi do: " + e.getMessage());
		}
	}

	public static List<GoodStudent> showGStudent()
			throws ParseException, InvalidPhoneNumberException, InvalidFullNameException, InvalidDOBException {
		List<GoodStudent> listGS = new ArrayList<GoodStudent>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try (BufferedReader reader = new BufferedReader(new FileReader("goodStudent.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.trim().isEmpty()) {
					continue;
				}
				String[] temp = line.split(",");
				String id = temp[0];
				String name = null;
				try {
					if (temp[1].length() < 10 || temp[1].length() > 50) {
						throw (new InvalidFullNameException(temp[1]));
					} else {
						name = temp[1];
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				Date dob = sdf.parse(temp[2]);
				String sex = temp[3];
				String phone;
				if (temp[4].matches("091[0-9]{7}") == false) {
					throw (new InvalidPhoneNumberException(temp[4]));
				} else {
					phone = temp[4];
				}
				String uni = temp[5];
				String grade = temp[6];
				double gpa = Double.parseDouble(temp[7]);
				String reward = temp[8];
				GoodStudent gs = new GoodStudent(id, name, dob, sex, phone, uni, grade, gpa, reward);
				listGS.add(gs);
			}
		} catch (IOException e) {
			System.out.println("ct lỗi do: " + e.getMessage());
		}
		return listGS;
	}

	public static void addNStudent() throws ParseException {
		List<NormalStudent> listNS = new ArrayList<NormalStudent>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		listNS.add(new NormalStudent("F1", "Nguyen Van B1", sdf.parse("21/12/1990"), "Nam", "0914002343", "BKDN",
				"TrungBinh", 8.0, 9.5));
		listNS.add(new NormalStudent("F2", "Nguyen Van B2", sdf.parse("21/12/1990"), "Nam", "0914002343", "BKDN",
				"TrungBinh", 7.0, 8.5));
		listNS.add(new NormalStudent("F3", "Nguyen Van B3", sdf.parse("21/12/1990"), "Nam", "0914002343", "BKDN",
				"TrungBinh", 6.0, 7.5));
		listNS.add(new NormalStudent("F4", "Nguyen Van B4", sdf.parse("21/12/1990"), "Nam", "0914002343", "BKDN",
				"TrungBinh", 5.0, 6.5));
		listNS.add(new NormalStudent("F5", "Nguyen Van C1", sdf.parse("21/12/1990"), "Nam", "0914002343", "BKDN",
				"TrungBinh", 4.0, 6.0));
		listNS.add(new NormalStudent("F6", "Nguyen Van C2", sdf.parse("21/12/1990"), "Nam", "0914002343", "BKDN",
				"TrungBinh", 5.0, 7.5));
		listNS.add(new NormalStudent("F7", "Nguyen Van C3", sdf.parse("21/12/1990"), "Nam", "0914002343", "BKDN",
				"TrungBinh", 6.0, 9.0));
		listNS.add(new NormalStudent("F8", "Nguyen Van C4", sdf.parse("21/12/1990"), "Nam", "0914002343", "BKDN",
				"TrungBinh", 8.0, 8.0));
		try (PrintWriter writer = new PrintWriter(new FileOutputStream("normalStudent.txt"))) {
			for (NormalStudent ns : listNS) {
				writer.append(ns.convertString());
				writer.println();
			}
			System.out.println("Ghi thành công!");
		} catch (IOException e) {
			System.out.println("ct lỗi do: " + e.getMessage());
		}
	}

	public static List<NormalStudent> showNStudent() throws ParseException {
		List<NormalStudent> listNS = new ArrayList<NormalStudent>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try (BufferedReader reader = new BufferedReader(new FileReader("normalStudent.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.trim().isEmpty()) {
					continue;
				}
				String[] temp = line.split(",");
				String id = temp[0];
				String name = temp[1];
				Date dob = sdf.parse(temp[2]);
				String sex = temp[3];
				String phone = temp[4];
				String uni = temp[5];
				String grade = temp[6];
				double engScore = Double.parseDouble(temp[7]);
				double entryScore = Double.parseDouble(temp[8]);
				NormalStudent ns = new NormalStudent(id, name, dob, sex, phone, uni, grade, engScore, entryScore);
				listNS.add(ns);
			}
		} catch (IOException e) {
			System.out.println("ct lỗi do: " + e.getMessage());
		}
		return listNS;
	}
}
