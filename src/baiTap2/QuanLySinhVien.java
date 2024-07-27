package baiTap2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QuanLySinhVien {
	ArrayList<SinhVien> arrayList;
	String[] nameArr = { "An", "Bình", "Cường", "Dũng", "Em", "Phương", "Giang", "Hà", "Linh", "Mai", "Nam", "Oanh",
			"Phúc", "Quỳnh", "Sơn", "Thảo", "Uyên", "Việt", "Xuân", "Yến" };
	SinhVien svTop1;
	ArrayList<SinhVien> weakList;
	ArrayList<SinhVien> findList;

	public QuanLySinhVien() {
		this.arrayList = new ArrayList<>();
		this.weakList = new ArrayList<>();
		this.findList = new ArrayList<>();
	}

	public void addNewSinhVien(Scanner scanner) {
		SinhVien sv = new SinhVien();
		sv.nhapThongTin(scanner);
		sv.printInfo();

		this.arrayList.add(sv);
	}

	public void addSinhVienAuto(int num) {
		String name;
		String maSV;
		double diemToan;
		double diemLy;
		double diemHoa;
		Random random = new Random();
		for (int i = 0; i < num; i++) {
			name = this.nameArr[random.nextInt(this.nameArr.length)];
			maSV = "SV" + (100000 + random.nextInt(900000));
			diemToan = random.nextInt(10) + 1;
			diemLy = random.nextInt(10) + 1;
			diemHoa = random.nextInt(10) + 1;
			SinhVien sVien = new SinhVien(name, maSV, diemToan, diemLy, diemHoa);
			sVien.printInfo();
			this.arrayList.add(sVien);
		}
	}

	public void printAllSinhVien() {
		System.out.println(">>>>> DANH SÁCH SINH VIÊN <<<<<");
		if (!(this.arrayList.size() > 0)) {
			System.out.println("Danh sách trống");
			System.out.println("");
			return;
		}
		for (int i = 0; i < this.arrayList.size(); i++) {
			this.arrayList.get(i).printInfoDetail();
		}
	}

	public SinhVien findTop1() {
		double maxTB = Double.MIN_VALUE;
		SinhVien sv = new SinhVien();
		for (SinhVien sVien : this.arrayList) {
			if (sVien.diemTB > maxTB) {
				maxTB = sVien.diemTB;
				sv = sVien;
			}
		}
		this.svTop1 = sv;
		return sv;
	}

	public void printTop1() {
		this.findTop1();

		System.out.println(">>>>> SINH VIÊN TOP 1 <<<<<");
		if (this.svTop1.diemTB > 0) {
			this.svTop1.printInfoDetail();
		} else {
			System.out.println("Không tìm thấy");
		}
	}

	public void findWeak() {
		for (SinhVien sVien : this.arrayList) {
			if (sVien.diemTB < 5) {
				this.weakList.add(sVien);
			}
		}
	}

	public void printAllWeak() {
		findWeak();
		System.out.println(">>>>> DANH SÁCH SINH VIÊN YẾU <<<<<");
		if (!(this.weakList.size() > 0)) {
			System.out.println("Danh sách trống");
			return;
		}
		for (SinhVien sv : this.weakList) {
			sv.printInfoDetail();
		}
	}

	public ArrayList<SinhVien> findSinhVienByName(String name) {
		this.findList.clear();
		String nameLowerCase = name.trim().toLowerCase();
		for (SinhVien sv : this.arrayList) {
			if (sv.ten.toLowerCase().contains(nameLowerCase)) {
				this.findList.add(sv);
			}
		}
		return this.findList;
	}

	public void printSinhVienByName(String name) {
		this.findSinhVienByName(name);
		System.out.println(">>>>> DANH SÁCH SINH VIÊN TÊN " + name + " <<<<<");
		if (!(this.findList.size() > 0)) {
			System.out.println("Danh sách trống");
			return;
		}
		for (SinhVien sv : this.findList) {
			sv.printInfoDetail();
		}
	}

	public SinhVien findSinhVienByID(String id) {
		SinhVien svByID = new SinhVien();
		String idLowerCase = id.trim().toLowerCase();
		for (SinhVien sv : this.arrayList) {
			if (sv.maSV.toLowerCase().contains(idLowerCase)) {
				svByID = sv;
				break;
			}
		}
		return svByID;
	}

	public void printSinhVienByID(String id) {
		SinhVien svByID = this.findSinhVienByID(id);
		System.out.println(">>>>> SINH VIÊN MÃ " + id + " <<<<<");
		if (svByID.maSV != null) {
			svByID.printInfoDetail();
		} else {
			System.out.println("Không tìm thấy");
		}
	}

	public void removeSinhVienByID(String id) {
		SinhVien svByID = this.findSinhVienByID(id);
		System.out.println(">>>>> XOÁ SINH VIÊN MÃ " + id + " <<<<<");
		if (svByID.maSV != null) {
			this.arrayList.remove(svByID);
			System.out.println("Đã xoá sinh viên");
		} else {
			System.out.println("Không tìm thấy");
		}
	}

}
