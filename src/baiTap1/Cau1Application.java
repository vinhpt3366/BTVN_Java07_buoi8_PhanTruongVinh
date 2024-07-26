package baiTap1;

import java.util.Scanner;

public class Cau1Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Vui lòng nhập họ và tên:");
		String hoTen = scanner.nextLine();
		System.out.println("Vui lòng nhập mã sinh viên:");
		String maSV = scanner.nextLine();
		System.out.println("Vui lòng nhập điểm Toán:");
		double diemToan = getValidScore(scanner);
		System.out.println("Vui lòng nhập điểm Lý:");
		double diemLy = getValidScore(scanner);
		System.out.println("Vui lòng nhập điểm Hoá:");
		double diemHoa = getValidScore(scanner);

		xuatThongTin(hoTen, maSV, diemToan, diemLy, diemHoa);
		scanner.close();
	}

	public static double tinhTrungBinh(double a, double b, double c) {
		return (a + b + c) / 3;
	}

	public static String xepLoai(double d) {
		if (d < 0 || d > 10) {
			return "Điểm không hợp lệ!";
		} else if (d >= 9) {
			return "Xuất sắc";
		} else if (d >= 8) {
			return "Giỏi";
		} else if (d >= 7) {
			return "Khá";
		} else if (d >= 6) {
			return "Trung bình";
		} else if (d >= 5) {
			return "Yếu";
		} else {
			return "Kém";
		}
	}

	public static void xuatThongTin(String hoTen, String maSV, double diemToan, double diemLy, double diemHoa) {
		double tb = tinhTrungBinh(diemToan, diemLy, diemHoa);
		String xl = xepLoai(tb);

		System.out.println("--------------");
		System.out.printf("%-15s: %s%n", "Họ tên", hoTen);
		System.out.printf("%-15s: %s%n", "MSSV", maSV);
		System.out.printf("%-15s: %,.1f%n", "Toán", diemToan);
		System.out.printf("%-15s: %,.1f%n", "Lý", diemLy);
		System.out.printf("%-15s: %,.1f%n", "Hoá", diemHoa);
		System.out.printf("%-15s: %,.1f%n", "Trung bình", tb);
		System.out.printf("%-15s: %s%n", "Xếp loại", xl);
	}

	public static double getValidScore(Scanner scanner) {
		double number;
		while (true) {
			if (scanner.hasNextDouble()) {
				number = scanner.nextDouble();
				scanner.nextLine();
				if (number >= 0 && number <= 10) {
					break;
				} else {
					System.out.println("Vui lòng nhập điểm từ 0 - 10:");
				}
			} else {
				System.out.println("Giá trị không hợp lệ. Vui lòng nhập điểm từ 0 - 10:");
				scanner.next();
			}
		}
		return number;
	}
}
