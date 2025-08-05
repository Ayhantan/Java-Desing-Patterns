package Structural;
// 1. Subject
interface File {
    void open();
}

// 2. Real Subject
class RealFile implements File {
    private String filename;

    public RealFile(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading file from disk: " + filename);
    }

    public void open() {
        System.out.println("Opening file: " + filename);
    }
}

// 3. Proxy
class ProxyFile implements File {
    private RealFile realFile;
    private String filename;
    private String user;

    public ProxyFile(String filename, String user) {
        this.filename = filename;
        this.user = user;
    }

    private boolean checkAccess() {
        System.out.println("Checking access for user: " + user);
        return user.equalsIgnoreCase("admin");
    }

    public void open() {
        if (checkAccess()) {
            if (realFile == null) {
                realFile = new RealFile(filename);
            }
            realFile.open();
        } else {
            System.out.println("Access Denied: " + user + " cannot open " + filename);
        }
    }
}

// 4. Client
public class ProxyPatternExample {
    public static void main(String[] args) {
        File file1 = new ProxyFile("testfile1.txt", "admin");
        file1.open();

        System.out.println();

        File file2 = new ProxyFile("testfile2.txt", "guest");
        file2.open();
    }
}

