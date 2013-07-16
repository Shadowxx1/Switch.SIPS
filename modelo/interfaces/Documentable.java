package modelo.interfaces;

/**
 *
 * @author Nelson Moncada
 */
public interface Documentable {

    public String getFileName();

    public void setFileName(String fileName);

    public byte[] getFile();

    public void setFileLength(Integer fileLength);

    public void setFile(byte[] file);

    public Integer getFileLength();
}
