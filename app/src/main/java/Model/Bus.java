package Model;

/**
 * Created by ADMIN on 10/22/17.
 */

public class Bus  {
    public int maXeBus;
    public int soXeBus;
    public String biensoxeBus;

    public Bus() {
    }

    public Bus(int maXeBus, int soXeBus, String biensoxeBus) {
        this.maXeBus = maXeBus;
        this.soXeBus = soXeBus;
        this.biensoxeBus = biensoxeBus;
    }

    public int getMaXeBus() {
        return maXeBus;
    }

    public void setMaXeBus(int maXeBus) {
        this.maXeBus = maXeBus;
    }

    public int getSoXeBus() {
        return soXeBus;
    }

    public void setSoXeBus(int soXeBus) {
        this.soXeBus = soXeBus;
    }

    public String getBiensoxeBus() {
        return biensoxeBus;
    }

    public void setBiensoxeBus(String biensoxeBus) {
        this.biensoxeBus = biensoxeBus;
    }
}
