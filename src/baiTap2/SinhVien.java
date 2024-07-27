package baiTap2;

import java.util.Scanner;

public class SinhVien {
	String ten;
	String maSV;
	double diemToan;
	double diemLy;
	double diemHoa;
	double diemTB;
	String xl;

	public SinhVien() {

	}

	public SinhVien(String ten, String maSV, double diemToan, double diemLy, double diemHoa) {
		this.ten = ten;
		this.maSV = maSV;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;

		this.tinhDiemTB();
		this.xepLoai();
	}

	public void nhapThongTin(Scanner scanner) {
		System.out.println("Vui lòng nhập họ và tên:");
		this.ten = scanner.nextLine();
		System.out.println("Vui lòng nhập mã sinh viên:");
		this.maSV = scanner.nextLine();
		System.out.println("Vui lòng nhập điểm Toán:");
		this.diemToan = getValidScore(scanner);
		System.out.println("Vui lòng nhập điểm Lý:");
		this.diemLy = getValidScore(scanner);
		System.out.println("Vui lòng nhập điểm Hoá:");
		this.diemHoa = getValidScore(scanner);

		this.tinhDiemTB();
		this.xepLoai();
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

	public void tinhDiemTB() {
		this.diemTB = (this.diemToan + this.diemLy + this.diemHoa) / 3;
	}

	public void xepLoai() {
		double d = this.diemTB;
		if (d < 0 || d > 10) {
			this.xl = "Điểm không hợp lệ!";
		} else if (d >= 9) {
			this.xl = "Xuất sắc";
		} else if (d >= 8) {
			this.xl = "Giỏi";
		} else if (d >= 6.5) {
			this.xl = "Khá";
		} else if (d >= 5) {
			this.xl = "Trung bình";
		} else {
			this.xl = "Yếu";
		}
	}

	public void printInfo() {
		System.out.printf("Sinh viên: %-6s,MSSV: %-7s, Toán: %4.1f, Lý: %4.1f, Hoá: %4.1f%n", this.ten, this.maSV,
				this.diemToan, this.diemLy, this.diemHoa);
	}

	public void printInfoDetail() {
		System.out.printf("Sinh viên: %-6s,MSSV: %-7s, Toán: %4.1f, Lý: %4.1f, Hoá: %4.1f, ĐTB: %4.1f, Xếp loại: %s%n",
				this.ten, this.maSV, this.diemToan, this.diemLy, this.diemHoa, this.diemTB, this.xl);
	}

}
