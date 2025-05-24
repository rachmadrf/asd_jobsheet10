public class AntrianKRS {
    DataMahasiswa[] data;
    int front;
    int rear;
    int size;
    int max;
    int totalDilayani;

    public AntrianKRS(int max) {
        this.max = max;
        data = new DataMahasiswa[max];
        front = 0;
        rear = -1;
        size = 0;
        totalDilayani = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian dikosongkan.");
    }

    public void tambahAntrian(DataMahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh!");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println("Mahasiswa " + mhs.nama + " masuk antrian.");
    }

    public void panggilKRS() {
        if (size < 2) {
            System.out.println("Antrian kurang dari 2 mahasiswa.");
            return;
        }
        System.out.println("Memproses KRS dua mahasiswa:");
        for (int i = 0; i < 2; i++) {
            DataMahasiswa mhs = data[front];
            System.out.print((i + 1) + ". ");
            mhs.tampilkanData();
            front = (front + 1) % max;
            size--;
            totalDilayani++;
        }
    }

    public void tampilkanSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar mahasiswa dalam antrian:");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[index].tampilkanData();
        }
    }

    public void tampilkanDuaTerdepan() {
        if (size == 0) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("2 Mahasiswa Terdepan:");
            for (int i = 0; i < Math.min(2, size); i++) {
                int index = (front + i) % max;
                System.out.print((i + 1) + ". ");
                data[index].tampilkanData();
            }
        }
    }

    public void tampilkanAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Mahasiswa paling akhir:");
            data[rear].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size;
    }

    public int getJumlahDilayani() {
        return totalDilayani;
    }

    public int getJumlahBelumKRS() {
        return 30 - totalDilayani;
    }
}