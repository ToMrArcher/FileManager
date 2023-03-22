public class ArchivedFile {

    private String name;
    private String extension;
    private int size;

    private FileArchive fileArchive;

    public ArchivedFile(String name, String extension, int size, FileArchive fileArchive) {
        this.name = name;
        this.extension = extension;
        this.size = size;
        this.fileArchive = fileArchive;
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public int getSize() {
        return size;
    }

    public String getPath() {
        return fileArchive.getPath() + this.name + "." + this.extension;
    }
}
