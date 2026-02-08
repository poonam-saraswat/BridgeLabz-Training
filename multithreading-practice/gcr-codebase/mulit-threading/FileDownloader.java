import java.util.*;

public class FileDownloader extends Thread{
    private String fileName;
    private Random random = new Random();
    
    public FileDownloader(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run(){
        try{
            for(int i = 0; i <= 100; i+=10){
                System.out.println("[" + Thread.currentThread().getName() + "] Downloading " + fileName + ": " + i + "%");
                Thread.sleep(200 + random.nextInt(300));
            }
        }
        catch(InterruptedException e){
            System.out.println(fileName + " download interrupted.");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        FileDownloader f1 = new FileDownloader("Document.pdf");
        FileDownloader f2 = new FileDownloader("Image.png");
        FileDownloader f3 = new FileDownloader("Video.mp4");

        f1.start();
        f2.start();
        f3.start();

        f1.join();
        f2.join();
        f3.join();

        System.out.println("...");
        System.out.println("All downloads complete!");
    }
}