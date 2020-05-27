package products;import console.ConsoleOutput;import inter.*;import java.io.*;import java.util.ArrayList;public abstract class Product implements productControl {    private int cost;    private String name;    private int weight;    private String good;    public Product(int cost, String name, int weight, String good) {        this.cost = cost;        this.name = name;        this.weight = weight;        this.good = good;    }    public Product() {    }    public int getCost() {        return cost;    }    public void setCost(int cost) {        this.cost = cost;    }    public String getName() {        return name;    }    public void setName(String name) {        this.name = name;    }    public int getWeight() {        return weight;    }    public void setWeight(int weight) {        this.weight = weight;    }    public String getGood() {        return good;    }    public void setGood(String good) {        this.good = good;    }    @Override    public String toString() {        return "Product{" +                "cost=" + cost +                '}';    }    public void deleteProductById(int indexToDelete) throws IOException {        ConsoleOutput consoleOutput = new ConsoleOutput();        consoleOutput.showDbContent();        consoleOutput.showMainDeleteDescription();        ArrayList<String> list = new ArrayList<String>();        try {            try {                String st;                BufferedReader br = new BufferedReader(new FileReader(ConsoleOutput.db_path));                while ((st = br.readLine()) != null) {                    list.add(st);                }                br.close();                list.remove(indexToDelete);                FileWriter f2 = new FileWriter(ConsoleOutput.db_path, false);                for (int i = 0; i < list.size(); i++) {                    f2.write(list.get(i) +"\n");                }                f2.close();            }            catch (FileNotFoundException fileNotFoundException){                System.out.println("NIE MOGE ZNALEZC PLIK Z BAZĄ DANYCH");            } catch (IOException e) {                e.printStackTrace();            }        }        catch (java.util.InputMismatchException inputMismatchException){            System.out.println("PODANY PARAMETR NIE JEST INTEGER PODAJ INNY");            deleteProductById(indexToDelete);        }        finally {            System.out.println("Closed");        }    }}