import java.util.ArrayList;

public class FileArchive {

    private ArrayList<ArchivedFile> files;
    private ArrayList<FileArchive> folders;
    private String path;
    private int numberOfFiles;

    public ArrayList<ArchivedFile> getFiles() {
        return files;
    }

    public FileArchive(String path) {
        this.path = path;
        this.numberOfFiles = 0;
        this.files = new ArrayList<>();
        this.folders = new ArrayList<>();
    }

    public String getPath() {
        return path;
    }

    public ArchivedFile addFile(ArchivedFile file) throws Exception {
        for (ArchivedFile f : files) {
            if(f.getName() == file.getName() && f.getExtension() == file.getExtension()) throw new Exception("File already exist");
        }
        numberOfFiles++;
        files.add(file);
        return file;
    }

    public ArchivedFile removeFile(ArchivedFile file) {
        ArchivedFile fileToRemove = files.get(files.indexOf(file));
        files.remove(fileToRemove);
        return fileToRemove;
    }

    public ArchivedFile removeFile(String name, String extension) throws Exception {
        for(ArchivedFile file: files){
            if(file.getExtension().equals(extension) && file.getName().equals(name)){
                removeFile(file);
            }
        }

        throw new Exception("File not found");
    }

    public void printFileTree(int nOfTabs) {
        printFolder(nOfTabs);
        for(FileArchive archive: folders){
            nOfTabs++;
            archive.printFolder(nOfTabs);
            nOfTabs--;
        }
    }

    public void printFileTree() {
        int nOfTabs = 0;
        printFolder(nOfTabs);
        for(FileArchive archive: folders){
            nOfTabs++;
            archive.printFileTree(nOfTabs);
            nOfTabs--;
        }
    }

    public void clear() {
        files.clear();
    }

    public FileArchive addFolder(String name){
        FileArchive archive = new FileArchive(name);
        folders.add(archive);
        return archive;
    }

    public void printFolder(int nOfTabs){
        printTabs(nOfTabs);
        System.out.println(getPath());
        printTabs(nOfTabs + 1);
        for(ArchivedFile file: files){
            System.out.print(file.getName() + "." + file.getExtension() + "   ");
        }
        System.out.println();
    }

    public void printTabs(int n){
        for(int i = 0; i < n; i++){
            System.out.print("\t");
        }
    }


}
