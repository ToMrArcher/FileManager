import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        FileArchive baseArchive = new FileArchive("/");
        FileArchive pictures = baseArchive.addFolder("Pictures");
        FileArchive videos = baseArchive.addFolder("Videos");
        FileArchive documents = baseArchive.addFolder("Documents");
        FileArchive holiday = videos.addFolder("Holiday");

        baseArchive.addFile(new ArchivedFile("Windows", "os", 18742, pictures));
        pictures.addFile(new ArchivedFile("House", "png", 18742, pictures));
        videos.addFile(new ArchivedFile("House", "mov", 1940285, videos));
        holiday.addFile(new ArchivedFile("Juleferie", "mov", 1940285, videos));
        holiday.addFile(new ArchivedFile("Påske 2023", "mov", 1940285, videos));
        documents.addFile(new ArchivedFile("House", "docx", 100, documents));

        baseArchive.printFileTree();

    }
}